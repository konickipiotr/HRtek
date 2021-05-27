package com.hrtek.user.managingfile;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.util.*;
import java.util.stream.Collectors;

import com.hrtek.db.CompanyRepository;
import com.hrtek.model.Company;
import com.hrtek.model.ListModel;
import com.hrtek.model.StatusFC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrtek.db.FactoryRepository;
import com.hrtek.db.worker.TimesheetRepository;
import com.hrtek.db.worker.WorkerBasicRepository;
import com.hrtek.db.worker.WorkerDateRepository;
import com.hrtek.db.worker.WorkerPermintRepository;
import com.hrtek.db.worker.WorkerRepository;
import com.hrtek.model.Factory;
import com.hrtek.model.worker.PermitStatement;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.settings.GlobalSettings;
import com.hrtek.user.timesheet.DateTimesheetOperation;
import com.hrtek.user.timesheet.Timesheet;
import com.hrtek.user.timesheet.TimesheetOperation;
import com.hrtek.user.timesheet.WorkerTimesheet;

@Service
public class ManagingFileService {
	
	private FactoryRepository factoryRepository;
	private WorkerRepository workerRepository;
	private WorkerBasicRepository workerBasicRepository;
	private WorkerDateRepository workerDateRepository;
	private WorkerPermintRepository workerPermintRepository;
	private TimesheetRepository timesheetRepository;
	private MFileTempAdditionalDataRepo mFileTempAdditionalDataRepo;
	private CompanyRepository companyRepository;

	@Autowired
	public ManagingFileService(FactoryRepository factoryRepository, WorkerRepository workerRepository, WorkerBasicRepository workerBasicRepository, WorkerDateRepository workerDateRepository, WorkerPermintRepository workerPermintRepository, com.hrtek.db.worker.TimesheetRepository timesheetRepository, MFileTempAdditionalDataRepo mFileTempAdditionalDataRepo, CompanyRepository companyRepository) {
		this.factoryRepository = factoryRepository;
		this.workerRepository = workerRepository;
		this.workerBasicRepository = workerBasicRepository;
		this.workerDateRepository = workerDateRepository;
		this.workerPermintRepository = workerPermintRepository;
		this.timesheetRepository = timesheetRepository;
		this.mFileTempAdditionalDataRepo = mFileTempAdditionalDataRepo;
		this.companyRepository = companyRepository;
	}

	public List<ListModel> getCompaniesNames(){
		List<Company> all = this.companyRepository.findAll();
		List<ListModel> com = new ArrayList<>();
		for(Company c : all){
			com.add(new ListModel(c.getId(), c.getShortname()));
		}
		return com;
	}

	public ListWrapper<FactoryElement> getManagingFileData(int monOffset, Long companyid) {
		ListWrapper<FactoryElement> wrapper = new ListWrapper<>();
		Optional<Company> oCompany = this.companyRepository.findById(companyid);
		if(oCompany.isEmpty()){
			wrapper.setErrormsg("Not found company ");
			return wrapper;
		}

		Company company = oCompany.get();
		wrapper.setCompanyid(companyid);
		wrapper.setCompanyname(company.getShortname());

		List<Worker> workers = this.workerRepository.findByCompanyid(companyid);

		Set<Long> factoriesIds = workers.stream().map(i -> i.getFactoryid()).collect(Collectors.toSet());
		List<Factory> allFactories = this.factoryRepository.findAllById(factoriesIds)
				.stream()
				.filter(i -> i.getStatus().equals(StatusFC.ENABLED))
				.collect(Collectors.toList());

		Map<Long, List<Worker>> factoryWorkersMap = new TreeMap<>();

		for(Factory f : allFactories){
			factoryWorkersMap.put(f.getId(), new ArrayList<>());
		}

		for(Worker worker : workers){
			List<Worker> wList = factoryWorkersMap.get(worker.getFactoryid());
			wList.add(worker);
		}

		List<FactoryElement> factoryElementList = new ArrayList<>();
		for(Map.Entry<Long, List<Worker>> factoryElement : factoryWorkersMap.entrySet()){
			Long key = factoryElement.getKey();
			List<Worker> value = factoryElement.getValue();

			Factory factory = allFactories.stream().filter(i -> i.getId().equals(key)).findFirst().get();
			FactoryElement element = new FactoryElement(factory, monOffset);
			element.setRecords(getWorkersRecords(value, monOffset));
			factoryElementList.add(element);
		}
		wrapper.setList(factoryElementList);
//
//		List<Factory> factories = factoryRepository.findByStatusOrderByShortname(StatusFC.ENABLED);
//		List<ManagElement> manElements = new ArrayList<>();
//
//		for(Factory factory : factories) {
//			ManagElement mel = new ManagElement(factory, monOffset);
//			mel.setRecords(getWorkersRecords(factory.getId(), monOffset));
//			manElements.add(mel);
//		}
//		ListWrapper<ManagElement> wrapper = new ListWrapper<>(manElements);
		saveToDb(wrapper, monOffset);
		return wrapper;
	}
	
	private List<WorkerRecord> getWorkersRecords(List<Worker> workers, int monOffset) {
		
		List<WorkerRecord> records = new ArrayList<>();
		for(Worker w : workers) {
			WorkerRecord wr = new WorkerRecord(w);
			setBasicDate(wr);
			setWorkerDetails(wr);
			getWorkingHours(wr, monOffset);
			findAdditionalDataInDb(monOffset, wr);

			records.add(wr);
		}
		return records;
	}

	private void findAdditionalDataInDb(int monOffset, WorkerRecord wr){
		LocalDate date = new DateTimesheetOperation(monOffset).getSelected();
		List<MFileTempAdditionalData> list = this.mFileTempAdditionalDataRepo.findByYearAndMonth(date.getYear(), date.getMonthValue());

		boolean found = false;
		for(MFileTempAdditionalData f : list){
			if(f.getWorkerid().equals(wr.getId())){
				wr.setChosenHours(f.getHours());
				wr.setSuperplus(wr.getSumOfHours() - wr.getChosenHours());
				wr.setSalaryForm(f.getSalaryform());
				wr.setBonus(f.getBonus());
				wr.setLoan(f.getLoan());
				BigDecimal salary = f.getSalary();
				if(salary == null)
					wr.setSalary(BigDecimal.valueOf(0));
				else
					wr.setSalary(f.getSalary());

				found = true;
				break;
			}
		}

		if(list.isEmpty() || found == false) {
			YearMonth ym = YearMonth.of(new DateTimesheetOperation(monOffset).getYear(), new DateTimesheetOperation(monOffset).getMonth());
			wr.setChosenHours(0);
			wr.setSuperplus(wr.getSumOfHours() - wr.getChosenHours());
			wr.setSalaryForm("G");
			wr.setBonus(BigDecimal.valueOf(0));
			wr.setLoan(BigDecimal.valueOf(0));
			wr.setSalary(BigDecimal.valueOf(0));
		}

		wr.setCz1(BigDecimal.valueOf(wr.getChosenHours() * 14));
		BigDecimal bd = new BigDecimal((wr.getSumOfHours() * 14)
				- wr.getCz1().setScale(2, RoundingMode.HALF_UP).doubleValue()
				+ wr.getBonus().setScale(2, RoundingMode.HALF_UP).doubleValue()
				- wr.getLoan().setScale(2, RoundingMode.HALF_UP).doubleValue()
				- wr.getFlatcost().setScale(2, RoundingMode.HALF_UP).doubleValue());
		wr.setCz2(bd.setScale(2,RoundingMode.HALF_UP));
		wr.setResult(wr.getSalary().subtract(wr.getCz1().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP));
	}
	
	private void setBasicDate(WorkerRecord wr) {
		Optional<WorkerBasic> oWorkerbasic = this.workerBasicRepository.findById(wr.getId());
		
		if(oWorkerbasic.isEmpty()) {
			System.err.println("not found WorkerBasic record for worker id " + wr.getId());
			return;
		}
		
		WorkerBasic wb = oWorkerbasic.get();
		wr.setPesel(wb.getPesel());
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		wr.setDateofbirth(sf.format(Date.valueOf(wb.getDateofbirth())));

		LocalDate now = LocalDate.now(GlobalSettings.zid);
		LocalDate dateofbirth = wb.getDateofbirth();
		int age = Period.between(dateofbirth, now).getYears();
		wr.setAge(Integer.toString(age));
		wr.setBelove26(age < 26);
	}
	
	private void setWorkerDetails(WorkerRecord wr) {
		Optional<WorkerDate> oWorkerDate = this.workerDateRepository.findById(wr.getId());
		Optional<PermitStatement> oPermit = this.workerPermintRepository.findById(wr.getId());
		
		if(oWorkerDate.isEmpty() || oPermit.isEmpty()) {
			System.err.println("Can't find worker in Date Repo or/and Permit repo");
			return;
		}
		
		WorkerDate wd = oWorkerDate.get();
		PermitStatement ps = oPermit.get();
		
		if(ps.getStatement() == null && ps.getPermit() == null) {
			wr.setDocumentType("");
			wr.setStartZus("IN PROGRESS");
			wr.setEndZus("IN PROGRESS");
			wr.setValidTo("");
			return;
		}
		
		wr.setStartZus(wd.getStartZus());
		wr.setEndZus(wd.getEndZus());
		
		if(ps.getStatement() == null) {
			wr.setDocumentType("ZEZ");
			wr.setValidTo(setValidDate(ps.getPermitValidTo()));
			
		}else {
			wr.setDocumentType("OŚW");
			wr.setValidTo(setValidDate(ps.getStatementValidTo()));
		}
	}
	
	private String setValidDate(LocalDate ld) {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		if(ld == null)
			return "";
		
		return sf.format(Date.valueOf(ld));
	}
	
	private void getWorkingHours(WorkerRecord wr, int monOffset) {
		Optional<Timesheet> oTimeS = this.timesheetRepository.findById(wr.getId());
		
		if(oTimeS.isEmpty()) {
			System.err.println("Cannot find timesheet");
			return;
		}
		
		DateTimesheetOperation dts = new DateTimesheetOperation(monOffset);
		TimesheetOperation to = new TimesheetOperation(dts);
		WorkerTimesheet workerTimesheet = to.getWorkerTimesheet(oTimeS.get());
		wr.setHourlList(workerTimesheet.getHourlList());
		wr.setSumOfHours(workerTimesheet.getHsum());
		int workedDays = wr.getHourlList()
				.stream()
				.filter(i -> !i.equals("XX"))
				.filter(i -> !i.equals("00"))
				.filter(i -> !i.equals("NW"))
				.collect(Collectors.toList()).size();
		wr.setFlatcost(workedDays < 8 ? BigDecimal.valueOf(80) : BigDecimal.valueOf(250));

	}

	public void setHoursForAll(ListWrapper<FactoryElement> listWrapper, Long factoryid, int value, int monOffset) {
		for(FactoryElement me : listWrapper.list) {
			if(me.getFactoryid().equals(factoryid)) {
				me.getRecords().forEach(i -> i.setChosenHours(value));
				me.getRecords().forEach(i -> i.setSuperplus(i.getSumOfHours() - i.getChosenHours()));
				break;
			}
		}
		saveToDb(listWrapper, monOffset);
	}

	public void setHoursForWorker(ListWrapper<FactoryElement> listWrapper, Long factoryid, List<WorkVal> workVals, int monOffset) {
		for(FactoryElement me : listWrapper.list) {
			if(me.getFactoryid().equals(factoryid)) {
				for(WorkerRecord wr : me.getRecords()) {
					for(WorkVal vv : workVals) {
						if (wr.getId().equals(vv.getWorkerid())) {
							wr.setChosenHours(vv.getChosenHours());
							wr.setSuperplus(wr.getSumOfHours() - wr.getChosenHours());
							wr.setSalary(vv.getSalary().setScale(2, RoundingMode.HALF_UP));
							wr.setSalaryForm(vv.getSalaryform());
							wr.setLoan(vv.getLoan());
							wr.setBonus(vv.getBonus());
							wr.setCz1(BigDecimal.valueOf(wr.getChosenHours() * 14));
							BigDecimal bd = new BigDecimal((wr.getSumOfHours() * 14)
									- wr.getCz1().setScale(2, RoundingMode.HALF_UP).doubleValue()
									+ wr.getBonus().setScale(2, RoundingMode.HALF_UP).doubleValue()
									- wr.getLoan().setScale(2, RoundingMode.HALF_UP).doubleValue()
									- wr.getFlatcost().setScale(2, RoundingMode.HALF_UP).doubleValue());
							wr.setCz2(bd.setScale(2,RoundingMode.HALF_UP));

							wr.setResult(wr.getSalary().subtract(wr.getCz1().setScale(2, RoundingMode.HALF_UP)).setScale(2, RoundingMode.HALF_UP));

							break;
						}
					}
				}
			}
		}
		saveToDb(listWrapper, monOffset);
	}

	public void saveToDb(ListWrapper<FactoryElement> wrapper, int monOffset){
		List<FactoryElement> list = wrapper.getList();
		LocalDate selected = new DateTimesheetOperation(monOffset).getSelected();

		for(FactoryElement me : list){
			List<WorkerRecord> records = me.getRecords();
			for(WorkerRecord wr : records){
				Optional<MFileTempAdditionalData> oTmpData = this.mFileTempAdditionalDataRepo.findByYearAndMonthAndWorkerid(selected.getYear(), selected.getMonthValue(), wr.getId());
				if(oTmpData.isEmpty()){
					MFileTempAdditionalData mFile = new MFileTempAdditionalData(selected.getYear(), selected.getMonthValue(), wr.getId(), wr.getSumOfHours(), wr.getSalary(), wr.getSalaryForm(), BigDecimal.valueOf(0), BigDecimal.valueOf(0));
					this.mFileTempAdditionalDataRepo.save(mFile);
				}else {
					MFileTempAdditionalData mFile = oTmpData.get();
					mFile.setSalary(wr.getSalary());
					mFile.setHours(wr.getChosenHours());
					mFile.setSalaryform(wr.getSalaryForm());
					mFile.setLoan(wr.getLoan());
					mFile.setBonus(wr.getBonus());
					this.mFileTempAdditionalDataRepo.save(mFile);
				}
			}
		}
	}

	public void sumColumns(ListWrapper<FactoryElement> wrapper){
		List<FactoryElement> list = wrapper.getList();

		for(FactoryElement el : list){
			int allinmonth = 0;
			int	sumOfChosenH = 0;
			int	sumOfSurplus = 0;
			BigDecimal sumOfSalaries = new BigDecimal(0);
			BigDecimal sumOfCz1 = new BigDecimal(0);
			BigDecimal sumOfCz2 = new BigDecimal(0);
			BigDecimal sumOfFlatsCost = new BigDecimal(0);
			BigDecimal sumOfLoans = new BigDecimal(0);
			BigDecimal sumOfBonuses = new BigDecimal(0);
			BigDecimal sumOfResults = new BigDecimal(0);

			for(WorkerRecord wr : el.getRecords()){
				allinmonth += wr.getSumOfHours();
				sumOfChosenH += wr.getChosenHours();
				sumOfSurplus += wr.getSuperplus();
				sumOfSalaries = sumOfSalaries.add(wr.getSalary());
				sumOfCz1 = sumOfCz1.add(wr.getCz1());
				sumOfCz2 = sumOfCz2.add(wr.getCz2());
				sumOfFlatsCost = sumOfFlatsCost.add(wr.getFlatcost());
				sumOfLoans = sumOfLoans.add(wr.getLoan());
				sumOfBonuses = sumOfBonuses.add(wr.getBonus());
				sumOfResults = sumOfResults.add(wr.getResult());
			}

			el.setAllinmonth(allinmonth);
			el.setSumOfChosenH(sumOfChosenH);
			el.setSumOfSurplus(sumOfSurplus);
			el.setSumOfSalaries(sumOfSalaries);
			el.setSumOfCz1(sumOfCz1);
			el.setSumOfCz2(sumOfCz2);
			el.setSumOfFlatsCost(sumOfFlatsCost);
			el.setSumOfLoans(sumOfLoans);
			el.setSumOfBonuses(sumOfBonuses);
			el.setSumOfResults(sumOfResults);
		}
	}
}

