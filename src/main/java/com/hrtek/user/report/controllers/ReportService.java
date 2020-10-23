package com.hrtek.user.report.controllers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.hrtek.db.CitizenshipRepository;
import com.hrtek.db.CompanyRepository;
import com.hrtek.db.FactoryRepository;
import com.hrtek.db.UserInfoRepository;
import com.hrtek.db.UserPositonsRepository;
import com.hrtek.db.accommodation.HouseRepository;
import com.hrtek.db.worker.ResidencyRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerContactRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerPermintRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.files.doc.Doc;
import com.hrtek.files.doc.ReportAccommodationDoc;
import com.hrtek.files.doc.ReportMedicalDoc;
import com.hrtek.files.doc.ReportPeselDoc;
import com.hrtek.files.doc.ReportRecruiterDoc;
import com.hrtek.files.doc.ReportStartWorkDoc;
import com.hrtek.files.doc.ReportVisaWorkDoc;
import com.hrtek.files.doc.ReportZusDoc;
import com.hrtek.files.doc.SaveFile;
import com.hrtek.model.Citizenship;
import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.UserInfo;
import com.hrtek.model.accommodation.House;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.report.views.ReportAccommodation;
import com.hrtek.user.report.views.ReportMedical;
import com.hrtek.user.report.views.ReportPesel;
import com.hrtek.user.report.views.ReportRecruiters;
import com.hrtek.user.report.views.ReportStartWork;
import com.hrtek.user.report.views.ReportVisaWork;
import com.hrtek.user.report.views.ReportWorkTime;
import com.hrtek.user.report.views.ReportZus;

@Service
public class ReportService {
	
	private WorkerRepository workerRepo;
	private WorkerBasicRepository workerBasicRepo;
	private WorkerDateRepository workerDateRepo;
	private WorkerPermintRepository permitSRepo;
	private ResidencyRepository residencyRepo;
	private WorkerContactRepository contactRepo;
	
	private UserInfoRepository userInfoRepo;
	private UserPositonsRepository userPositionRepo;
	private FactoryRepository factoryRepo;
	private CompanyRepository companyRepo;
	private CitizenshipRepository citizenshipRepository;
	private HouseRepository houseRepo;

	@Autowired
	public ReportService(WorkerRepository workerRepo, WorkerBasicRepository workerBasicRepo,
			WorkerDateRepository workerDateRepo, WorkerPermintRepository permitSRepo, ResidencyRepository residencyRepo,
			WorkerContactRepository contactRepo, UserInfoRepository userInfoRepo,
			UserPositonsRepository userPositionRepo, FactoryRepository factoryRepo, CompanyRepository companyRepo,
			CitizenshipRepository citizenshipRepository, HouseRepository houseRepo) {
		this.workerRepo = workerRepo;
		this.workerBasicRepo = workerBasicRepo;
		this.workerDateRepo = workerDateRepo;
		this.permitSRepo = permitSRepo;
		this.residencyRepo = residencyRepo;
		this.contactRepo = contactRepo;
		this.userInfoRepo = userInfoRepo;
		this.userPositionRepo = userPositionRepo;
		this.factoryRepo = factoryRepo;
		this.companyRepo = companyRepo;
		this.citizenshipRepository = citizenshipRepository;
		this.houseRepo = houseRepo;
	}
	
	public void setCompanyFactoryList(Model model) {
		model.addAttribute("comapnies", companyRepo.findAll());
		model.addAttribute("factroies", factoryRepo.findAll());
		
	}

	public String downloadWorkerWiza(ReportType reportType, LocalDate searched) {
		ReportWraper<ReportVisaWork> wraper = getReportReportVisaWork(reportType, searched);
		Doc<Workbook> doc = new ReportVisaWorkDoc(wraper.getReport());
		doc.prepareDoc();
		return new SaveFile().saveDoc(doc);
	}
	
	public String downloadZus(List<ReportZus> zusList, ReportType reportType) {
		ReportWraper<ReportZus> wraper = new ReportWraper<>();
		wraper.setReport(zusList);
		wraper.setReportType(reportType.toString());
		
		Doc<Workbook> doc = new ReportZusDoc(wraper.getReport());
		doc.prepareDoc();
		return new SaveFile().saveDoc(doc);
	}
	
	public String downloadFile(ReportType reportType, Long recruiterid) {

		switch (reportType) {
		case WITHPESEL:
		case WITHOUTPESEL:{
			ReportWraper<ReportPesel> wraper = getReportPesel(reportType);
			Doc<Workbook> doc = new ReportPeselDoc(wraper.getReport());
			doc.prepareDoc();
			return new SaveFile().saveDoc(doc);
		}
		case MEDICALEXAMS:{
			ReportWraper<ReportMedical> wraper = getReportMedical(reportType);
			Doc<Workbook> doc = new ReportMedicalDoc(wraper.getReport());
			doc.prepareDoc();
			return new SaveFile().saveDoc(doc);
		}
		case RECRUITERS:{
			ReportWraper<ReportRecruiters> wraper = getReportRecruiters(reportType, recruiterid);
			Doc<Workbook> doc = new ReportRecruiterDoc(wraper.getReport());
			doc.prepareDoc();
			return new SaveFile().saveDoc(doc);
		}
		case STARTWORK_LESS1MON:
		case STARTWORK_LESS3MON:
		case STARTWORK_MORE1MON:
		case STARTWORK_MORE3MON:{
			ReportWraper<ReportStartWork> wraper = getReportStartWork(reportType);
			Doc<Workbook> doc = new ReportStartWorkDoc(wraper.getReport());
			doc.prepareDoc();
			return new SaveFile().saveDoc(doc);
		}
		case ACCOMMODATION:{
			ReportWraper<ReportAccommodation> wraper = getReportAccommodation(reportType);
			Doc<Workbook> doc = new ReportAccommodationDoc(wraper.getReport());
			doc.prepareDoc();
			return new SaveFile().saveDoc(doc);
		}

		default:
			break;
		}
		return null;
	}

	
	
/////***************************************************************************
	

	public ReportWraper<ReportZus> getReportZus(ReportType rtype, Long comapnyid, Long factoryid, LocalDate dateform, String zusSearchingType){
		ReportWraper<ReportZus> wraper = new ReportWraper<>();
		List<ReportZus> report = new ArrayList<>();
		List<Worker> w_list = workerRepo.findByCompanyidAndFactoryid(comapnyid, factoryid);
		
		if(dateform != null) {
			for(Worker w : w_list) {
				ReportZus rz = getOneRecordReportZus(w, dateform, zusSearchingType);
				if(rz != null)
					report.add(rz);
			}
		}
		
		wraper.setReport(report);
		wraper.setReportType(rtype.toString());
		return wraper;
	}
	
	private ReportZus getOneRecordReportZus(Worker w, LocalDate dateform, String zusSearchingType) {
		ReportZus rp = new ReportZus();

		WorkerDate wd = workerDateRepo.findById(w.getId()).get();
		LocalDate startZus = wd.getStartZus();
		LocalDate endZus = wd.getEndZus();
		
		if(startZus == null) return null;
		if(zusSearchingType.equals("startZus")) {
			if(startZus.isBefore(dateform)) return null;
		}else {
			if(endZus == null) return null;
			if(endZus.isBefore(dateform)) return null;
		}
		

		rp.setStartZus(wd.getStartZus());
		rp.setEndZus(wd.getEndZus());
		
		Residency r = residencyRepo.findById(w.getId()).get();
		WorkerBasic wb = workerBasicRepo.findById(w.getId()).get();
		PermitStatement ps = permitSRepo.findById(w.getId()).get();
		Company company = companyRepo.findById(w.getCompanyid()).get();
		Factory factory = factoryRepo.findById(w.getFactoryid()).get();
		Contact conact = contactRepo.findById(w.getId()).get();
		
		String citizenship = "";
		if(wb.getCitizenship() != null) {
			Citizenship citiz = citizenshipRepository.findById(wb.getCitizenship()).get();
			citizenship = citiz.getName();
		}
		
		rp.setFirstname(w.getFirstname());
		rp.setLastname(w.getLastname());
		rp.setDateofbirth(wb.getDateofbirth());
		rp.setCitizenship(citizenship);
		rp.setPesel(wb.getPesel());
		rp.setSex(wb.getSex());
		
		String passport = (r.getPassport() == null || r.getPassport().isBlank()) ? r.getBiopassport() : r.getPassport();
		rp.setPassport(passport);
		
		
		if(ps.getStatement() != null && !ps.getStatement().isBlank()) {
			rp.setType(ps.getStatementType() + ": "+ ps.getStatement()+ "  " + ps.getStatementValidFrom() + "-" + ps.getStatementValidTo() );
		}else if(ps.getPermit() != null && !ps.getPermit().isBlank()){
			rp.setType("zezwolenie: " + ps.getPermit() + "  do " +  ps.getPermitValidTo());
		}else {
			rp.setType(ps.getOther());
		}
		
		rp.setFacotry(factory.getShortname());
		rp.setCompany(company.getShortname());
		rp.setAddress("ul. " + conact.getPladdress() + ", " + conact.getPlpostcode() + " " + conact.getPlcity() );

		return rp;
	}
	
/////***************************************************************************

	public ReportWraper<ReportAccommodation> getReportAccommodation(ReportType rtype){
		ReportWraper<ReportAccommodation> wraper = new ReportWraper<>();
		List<ReportAccommodation> report = new ArrayList<>();
		List<House> houses = houseRepo.findAll();
		
		for(House h : houses) {
			ReportAccommodation ra = new ReportAccommodation();
			ra.setAddress(h.getAddress() + ", " + h.getPostcode() + ", " + h.getCity());
			ra.setCapacity(h.getCapacity());
			ra.setFree(h.getCapacity() - h.getOccupied());
			report.add(ra);
		}
		
		wraper.setReport(report);
		wraper.setReportType(rtype.toString());
		return wraper;
	}

	
////***************************************************************************	
	
	public ReportWraper<ReportVisaWork> getReportReportVisaWork(ReportType rtype, LocalDate searched){
		ReportWraper<ReportVisaWork> wraper = new ReportWraper<>();
		List<ReportVisaWork> report = new ArrayList<>();
		String type = "";
		if(rtype.equals(ReportType.STATEMENTVISA)) {
			type = "VISA";
		}
		else {
			type = "WORK";
		}
		List<PermitStatement> ps_list = permitSRepo.findByStatementType(type);
				
		for(PermitStatement ps : ps_list) {
			LocalDate validFrom = ps.getStatementValidFrom();
			if(validFrom != null) {
				if(validFrom.getMonthValue() == searched.getMonthValue() && validFrom.getYear() == searched.getYear()) {
					report.add(getOneRecordReportVisaWork(ps, rtype));
				}
			}
		}
		
		wraper.setReport(report);
		wraper.setReportType(rtype.toString());
		return wraper;
	}
	
	
	private ReportVisaWork getOneRecordReportVisaWork(PermitStatement ps, ReportType rtype) {
		ReportVisaWork rp = new ReportVisaWork();
		Worker w = workerRepo.findById(ps.getId()).get();
		WorkerDate wd = workerDateRepo.findById(w.getId()).get();
		
		rp.setFirstname(w.getFirstname());
		rp.setLastname(w.getLastname());
		rp.setStartStatement(ps.getStatementValidFrom());
		rp.setStartWork(wd.getStartWork());
		rp.setType(ps.getStatementType());
		
		return rp;
	}
	
/////***************************************************************************	


	public ReportWraper<ReportStartWork> getReportStartWork(ReportType rtype){
		ReportWraper<ReportStartWork> wraper = new ReportWraper<>();
		List<ReportStartWork> report = new ArrayList<>();
		List<Worker> workers = workerRepo.findAll();
		
		for(Worker w : workers) {
			ReportStartWork rp = getOneRecordReportStartWork(w, rtype);
			if(rp != null)
				report.add(getOneRecordReportStartWork(w, rtype));
		}
		
		wraper.setReport(report);
		wraper.setReportType(rtype.toString());
		return wraper;
	}
	
	private ReportStartWork getOneRecordReportStartWork(Worker w, ReportType rtype) {
		ReportStartWork rp = new ReportStartWork();
		WorkerDate wd = workerDateRepo.findById(w.getId()).get();
		LocalDate date = LocalDate.now(ZoneId.systemDefault());
		if(wd.getStartWork() == null) return null;
		
		switch (rtype) {
		case STARTWORK_LESS1MON:{
			date = date.minusMonths(1);
			if(wd.getStartWork().isBefore(date)) {
				return null;
			}
		}break;
		case STARTWORK_LESS3MON:{
			date = date.minusMonths(3);
			if(wd.getStartWork().isBefore(date)) {
				return null;
			}
		}break;	
		case STARTWORK_MORE1MON:{
			date = date.minusMonths(1);
			if(wd.getStartWork().isAfter(date)) {
				return null;
			}
		}break;	
		case STARTWORK_MORE3MON:{
			date = date.minusMonths(3);
			if(wd.getStartWork().isAfter(date)) {
				return null;
			}
		}break;	

		default:
			return null;
		}
		
		rp.setFirstname(w.getFirstname());
		rp.setLastname(w.getLastname());
		rp.setStartWork(wd.getStartWork());
		rp.setEndWork(wd.getEndWork());
		
		return rp;
	}
	
	/////***************************************************************************	
	


	public ReportWraper<ReportRecruiters> getReportRecruiters(ReportType rtype, Long recruiterid){
		ReportWraper<ReportRecruiters> wraper = new ReportWraper<>();
		List<ReportRecruiters> report = new ArrayList<>();
		wraper.setReportType(rtype.toString());
		if(recruiterid == null) {
			wraper.setReport(report);
			return wraper;
		}
		
		UserInfo user = userInfoRepo.findById(recruiterid).get();
		List<Worker> workers = workerRepo.findByRecruiter(user.getId());
		
		for(Worker w : workers) {
			ReportRecruiters record = new ReportRecruiters();
			WorkerDate wd = workerDateRepo.findById(w.getId()).get();
			
			record.setAddtosystem(wd.getAddToSystem());
			record.setRfirstname(user.getFirstname());
			record.setRlastname(user.getLastname());
			record.setWfirstname(w.getFirstname());
			record.setWlastname(w.getLastname());
			report.add(record);
		}
		
		wraper.setReport(report);
		
		return wraper;
	}
	
	
	/////***************************************************************************

	public ReportWraper<ReportMedical> getReportMedical(ReportType rtype){
		ReportWraper<ReportMedical> wraper = new ReportWraper<>();
		List<ReportMedical> report = new ArrayList<>();
		List<Worker> workers = workerRepo.findAll();
		
		for(Worker w : workers) {
			report.add(getOneRecordReportMedical(w));
		}
		
		wraper.setReport(report);
		wraper.setReportType(rtype.toString());
		return wraper;
	}
	
	private ReportMedical getOneRecordReportMedical(Worker w) {
		ReportMedical rp = new ReportMedical();
		WorkerDate wd = workerDateRepo.findById(w.getId()).get();
		
		rp.setStatrtMedical(wd.getStartMedicalExams());
		rp.setEndMedical(wd.getEndMedicalExams());
		rp.setFirstname(w.getFirstname());
		rp.setLastname(w.getLastname());
		
		if(w.getFactoryid() != null) {
			rp.setFactory(factoryRepo.findById(w.getFactoryid()).get().getShortname());
		}
		return rp;
	}
	
	///////***************************************************************************
	
	public ReportWraper<ReportPesel> getReportPesel(ReportType rtype){
		ReportWraper<ReportPesel> wraper = new ReportWraper<>();
		
		List<ReportPesel> report = new ArrayList<>();
		List<WorkerBasic> wblist = workerBasicRepo.findAll();
		
		
		if(rtype.equals(ReportType.WITHPESEL)) {
			for(WorkerBasic wb : wblist) {
				if(wb.getPesel() != null && !wb.getPesel().isBlank())
					report.add(getOneRecordReportPesel(wb));
			}
		}else {
			for(WorkerBasic wb : wblist) {
				if(wb.getPesel() == null || wb.getPesel().isBlank())
					report.add(getOneRecordReportPesel(wb));
			}
		}
		
		wraper.setReport(report);
		wraper.setReportType(rtype.toString());
		return wraper;
	}
	
	private ReportPesel getOneRecordReportPesel(WorkerBasic wb) {
		ReportPesel rp = new ReportPesel();
		rp.setPesel(wb.getPesel());
		
		Worker worker = workerRepo.findById(wb.getId()).get();
		rp.setFirstname(worker.getFirstname());
		rp.setLastname(worker.getLastname());
		if(worker.getFactoryid() != null) {
			rp.setFactory(factoryRepo.findById(worker.getFactoryid()).get().getShortname());
		}
		return rp;
	}
	
/////***************************************************************************

	public ReportWraper<ReportWorkTime> getReportWorkTime(ReportType rtype){
		ReportWraper<ReportWorkTime> wraper = new ReportWraper<>();
		List<ReportWorkTime> report = new ArrayList<>();
		
		List<Worker> workers = this.workerRepo.findAll();
		for(Worker w : workers) {
			ReportWorkTime r = new ReportWorkTime();
			r.setFirstname(w.getFirstname());
			r.setLastname(w.getLastname());
			r.setCompany(this.companyRepo.findById(w.getCompanyid()).get().getShortname());
			WorkerDate wd = this.workerDateRepo.findById(w.getId()).get();
			if(wd.getStartZus() == null)
				r.setMonths("EMPTY");
			else
				calculateTime(wd, r);
			
			report.add(r);
		}
		
		wraper.setReport(report);
		wraper.setReportType(rtype.toString());
		return wraper;
	}

	private void calculateTime(WorkerDate wd, ReportWorkTime r) {
		LocalDate now = LocalDate.now(GlobalSettings.zid);
		LocalDate zus = wd.getStartZus();
		LocalDate result = now.minusYears(zus.getYear()); 
		result = result.minusMonths(zus.getMonthValue()); 
		result = result.minusDays(zus.getDayOfMonth());
		int mon = 0;
		if(result.getYear() > 0) {
			mon = result.getYear() * 12;
		}
		mon += result.getMonthValue();
		r.setMonths(Integer.toString(mon));
		r.setDays(result.getDayOfMonth());
		if(mon > 16)
			r.setGreaterThansixteen(true);
	}
	
	


}
