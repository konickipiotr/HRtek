package com.hrtek.Tasks;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.TaskRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.ListModel;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;

@Service
public class TaskService {
	
	private UserInfoRepository userInfoRepo;
	private TaskRepository taskRepo;
	private UserRepository userRepo;
	
	@Autowired
	public TaskService(UserInfoRepository userInfoRepo, TaskRepository taskRepo, UserRepository userRepo) {
		this.userInfoRepo = userInfoRepo;
		this.taskRepo = taskRepo;
		this.userRepo = userRepo;
	}

	public void setBossModel(Model model) {
		List<UserInfo> list = userInfoRepo.findAll();
		List<ListModel> employees = new ArrayList<ListModel>();
		
		for(UserInfo u : list) {
			employees.add(new ListModel(u.getId(), u.getName()));
		}
		
		List<Task> tlist = taskRepo.findByOwnerOrderByDeadlinedate(TaskOwner.BOSS);
		for(Task t : tlist) {
			UserInfo user = userInfoRepo.findById(t.getEmployeeid()).get();
			t.setEmployeename(user.getName());
		}
		
		model.addAttribute("task", new Task());
		model.addAttribute("tlist", tlist);
		model.addAttribute("employees", employees);
	}
	
	public void addNewTask(Task task) {
		
		if(task.getDeadline().equals("TODAY")) {
			task.setDeadlinedate(LocalDate.now(ZoneId.systemDefault()));
		}else if(task.getDeadline().equals("TOMORROW")) {
			LocalDate now = LocalDate.now(ZoneId.systemDefault());
			task.setDeadlinedate(now.plusDays(1));
		}
		
		this.taskRepo.save(task);
	}
	
	public void removetask(Long tid) {
		this.taskRepo.deleteById(tid);
	}
	
	public void removeMytask(Long tid, String username) {
		User user = userRepo.findByUsername(username);
		
		Optional<Task> oTask = this.taskRepo.findById(tid);
		if(oTask.isEmpty()) {
			//TODO
		}
		Task task = oTask.get();
		
		if(user.getId().equals(task.getEmployeeid())) {
			this.taskRepo.deleteById(tid);
		}
	}
	
	public void newstatus(Long tid, TaskStatus status, String username) {
		User user = userRepo.findByUsername(username);
		Optional<Task> oTask = this.taskRepo.findById(tid);
		if(oTask.isEmpty()) {
			//TODO
		}
		Task task = oTask.get();
		if(user.getId().equals(task.getEmployeeid())) {
			task.setStatus(status);
			this.taskRepo.save(task);
		}
		
	}
}
