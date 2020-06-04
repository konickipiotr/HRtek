package com.hrtek;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.Tasks.Task;
import com.hrtek.Tasks.TaskOwner;
import com.hrtek.db.MyNoteRepository;
import com.hrtek.db.TaskRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserRepository;
import com.hrtek.model.MyNote;
import com.hrtek.model.User;
import com.hrtek.model.UserInfo;

@Service
public class UserHomeService {

	private TaskRepository taskRepo;
	private UserRepository userRepo;
	private MyNoteRepository myNoteRepo;

	@Autowired
	public UserHomeService(TaskRepository taskRepo, UserRepository userRepo, MyNoteRepository myNoteRepo) {
		this.taskRepo = taskRepo;
		this.userRepo = userRepo;
		this.myNoteRepo = myNoteRepo;
	}
	
	public List<Task> getBossTasks(String username){
		User user = userRepo.findByUsername(username);
		List<Task> tasks = taskRepo.findByEmployeeidAndOwnerOrderByDeadlinedate(user.getId(), TaskOwner.BOSS);
		return tasks;
	}
	public List<Task> getMyTasks(String username){
		User user = userRepo.findByUsername(username);
		List<Task> tasks = taskRepo.findByEmployeeidAndOwnerOrderByDeadlinedate(user.getId(), TaskOwner.ME);
		return tasks;
	}
	
	public MyNote getMyNote(String username){
		User user = userRepo.findByUsername(username);
		
		return this.myNoteRepo.findById(user.getId()).get();
	}
	
	public void saveMyNote(MyNote myNote) {
		System.out.println(myNote);
		this.myNoteRepo.save(myNote);
	}
}
