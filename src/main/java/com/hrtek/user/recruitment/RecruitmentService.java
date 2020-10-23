package com.hrtek.user.recruitment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CandidateRepository;
import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.DepartmentRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.LogRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.accommodation.BedRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.accommodation.RoomRepository;
import com.hrtek.enums.LogType;
import com.hrtek.model.ListModel;
import com.hrtek.model.Log;
import com.hrtek.model.UserInfo;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.settings.Msg;
import com.hrtek.utils.SortFields;

@Service
@Transactional
public class RecruitmentService {
	
	private CandidateRepository candidateRepo;
	private UserInfoRepository userInfoRepo;
	private UserPositonsRepository userPositionRepo;
	private FactoryRepository factroryRepo;
	private CompanyRepository companyRepo;
	private BedRepository bedRepo;
	private HouseRepository houseRepo;
	private RoomRepository roomRepo;
	private CitizenshipRepository citizenshipRepo;
	private DepartmentRepository departmentRepo;
	private LogRepository logRepo;

	
	@Autowired	
	public RecruitmentService(CandidateRepository candidateRepo, UserInfoRepository userInfoRepo,
			UserPositonsRepository userPositionRepo, FactoryRepository factroryRepo, CompanyRepository companyRepo,
			BedRepository bedRepo, HouseRepository houseRepo, RoomRepository roomRepo,
			CitizenshipRepository citizenshipRepo, DepartmentRepository departmentRepo, LogRepository logRepo) {
		this.candidateRepo = candidateRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
		this.factroryRepo = factroryRepo;
		this.companyRepo = companyRepo;
		this.bedRepo = bedRepo;
		this.houseRepo = houseRepo;
		this.roomRepo = roomRepo;
		this.citizenshipRepo = citizenshipRepo;
		this.departmentRepo = departmentRepo;
		this.logRepo = logRepo;
	}

	public List<ListModel> getCoordinatorsAndAgents(){
		List<ListModel> recruiters = new ArrayList<>();
		int agenid = userPositionRepo.findByPosition(GlobalSettings.agent).getId();
		int coordinatorsid = userPositionRepo.findByPosition(GlobalSettings.coordinator).getId();
		List<UserInfo> agentsAndcoordinators = userInfoRepo.getAgentsAndCoordinators(agenid, coordinatorsid);
		
		for(UserInfo u : agentsAndcoordinators) {
			String position = u.getPosition() == agenid ? GlobalSettings.agent : GlobalSettings.coordinator;
			recruiters.add(new ListModel(u.getId(), u.getName()+" - " + position));
		}
		return recruiters;
	}
	
	public List<CandidateView> getCandidateViewList(){
		List<Candidate> allCandidate = candidateRepo.findAll();
		List<CandidateView> candidates = new ArrayList<>();
		
		for(Candidate c :allCandidate) {
			CandidateView cv = new CandidateView(c);
			Optional<UserInfo> oRecruiter = userInfoRepo.findById(c.getRecruiter());
			if(oRecruiter.isEmpty())
				cv.setRecruiter("ERR: DOESN'T EXIST");
			else
				cv.setRecruiter(oRecruiter.get().getName());
			
			candidates.add(cv);
		}	
		return candidates;
	}

	public Long addCandidate(Candidate candidate, HttpSession session) {
		this.candidateRepo.save(candidate);
		UserInfo ui = (UserInfo) session.getAttribute("user");
		this.logRepo.save(new Log(ui.getName(), Msg.newCandidate + candidate.toString(), LogType.CREATE));
		return candidate.getId();
	}
	
	public void deleteCandidate(Long id, HttpSession session) {
		Optional<Candidate> oCandi = candidateRepo.findById(id);
		if(oCandi.isPresent()) {
			this.candidateRepo.deleteById(id);
			UserInfo ui = (UserInfo) session.getAttribute("user");
			this.logRepo.save(new Log(ui.getName(), Msg.removeCandidate + oCandi.get(), LogType.DELETE));
		}
		
	}

	public NewWorker selectCandidatAsNewWorker(Long id) {
		Candidate c = candidateRepo.findById(id).get();
		return new NewWorker(c);
	}
	
	public List<ListModel> prepareCadnidatsList(){
		List<ListModel> list = new ArrayList<ListModel>();
		List<Candidate> candidates = candidateRepo.findAll();
		
		for(Candidate c : candidates) {
			list.add(new ListModel(c.getId(), c.getName()));
		}
		Collections.sort(list);
		return list;		
	}

	
	public void setModel(Model model, NewWorker nw) {
		SortFields fs = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		model.addAttribute("candidates", prepareCadnidatsList());	
		model.addAttribute("recruiters", fs.getOrederAgentsAndCoordinators(nw.getRecruiter()));
		model.addAttribute("beds", fs.getBedsInOrder(nw.getBedid()));
		model.addAttribute("companies", fs.getCompaniesInOrder(nw.getCompanyid()));
		model.addAttribute("factories", fs.getFactoryInOrder(nw.getFactoryid()));
	}
	
	public void setOtherDataModel(Model model, WorkerAll w) {
		SortFields fs = new SortFields(citizenshipRepo, departmentRepo, factroryRepo, companyRepo, userInfoRepo, userPositionRepo, bedRepo, houseRepo, roomRepo);
		model.addAttribute("candidates", prepareCadnidatsList());	
		model.addAttribute("recruiters", fs.getOrederAgentsAndCoordinators(w.getRecruiter()));
		model.addAttribute("beds", fs.getBedsInOrder(w.getBedid()));
		model.addAttribute("companies", fs.getCompaniesInOrder(w.getCompanyid()));
		model.addAttribute("factories", fs.getFactoryInOrder(w.getFactoryid()));
		model.addAttribute("departments", fs.getDepartmentInOrder(w.getDepartment()));
		model.addAttribute("citizenships", fs.getCitizenshipInOrder(w.getCitizenship()));
	}

}
