package com.hrtek.user.recruitment;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.CandidateRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.model.ListModel;
import com.hrtek.model.UserInfo;
import com.hrtek.settings.GlobalSettings;

@Service
public class CandidateService {

	private CandidateRepository candidateRepo;
	private UserInfoRepository userInfoRepo;
	private UserPositonsRepository userPositionRepo;
	
	@Autowired
	public CandidateService(CandidateRepository candidateRepo, UserInfoRepository userInfoRepo,
			UserPositonsRepository userPositionRepo) {
		this.candidateRepo = candidateRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
	}

	public List<ListModel> getCoordinatorsAndAgents(){
		List<ListModel> recruiters = new ArrayList<>();
		int agenid = userPositionRepo.findByPosition(GlobalSettings.agent).getId();
		int coordinatorsid = userPositionRepo.findByPosition(GlobalSettings.coordinator).getId();
		List<UserInfo> agentsAndcoordinators = userInfoRepo.getAgentsAndCoordinators(agenid, coordinatorsid);
		
		agentsAndcoordinators.forEach(i -> System.out.println(i)); //TEST
		
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
			cv.setRecruiter(userInfoRepo.findById(c.getRecruterid()).get().getName());
			candidates.add(cv);
		}	
		return candidates;
	}
	
	public void addCandidate(Candidate candidate) {
		this.candidateRepo.save(candidate);
	}
	
	public void deleteCandidate(Long id) {
		this.candidateRepo.deleteById(id);
	}
}
