package com.hrtek.user.display.views;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.utils.FieldsComparator;


public class DataView implements Comparable<DataView> {
	
	private int status;
	private Long id;
	private String firstname;
	private String lastname;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String recruiter;
	private String company;
	private String factory;
	private LocalDate startMedicalExams;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate endMedicalExams;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate addToSystem;
	
	public DataView(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
		if(w.getStatus().equals(StatusWorker.ACTIVE))
			this.status = 1;
		else
			this.status = 0;
	}
	
	public void setFromWorkerDate(WorkerDate wd) {
		this.startMedicalExams = wd.getStartMedicalExams();
		this.endMedicalExams = wd.getEndMedicalExams();
		this.addToSystem = wd.getAddToSystem();

	}
	
	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(DataView o) {
		switch (field) {
			case STATUS: return FieldsComparator.compareNumber(this.status, o.getStatus(), isup);
			case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
			case LASTNAME: return FieldsComparator.compareText(this.firstname, o.getLastname(), isup);
			case RECRUITER: return FieldsComparator.compareText(this.recruiter, o.getRecruiter(), isup);
			case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
			case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
			case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);
			case STARTMEDICAL: return FieldsComparator.compareDate(this.startMedicalExams, o.getStartMedicalExams(), isup);
			case ENDMEDICAL: return FieldsComparator.compareDate(this.endMedicalExams, o.getEndMedicalExams(), isup);
			case ADDTOSYSTEM: return FieldsComparator.compareDate(this.addToSystem, o.getAddToSystem(), isup);
			
		default:
			break;
		}
		return 0;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getFactory() {
		return factory;
	}

	public void setFactory(String factory) {
		this.factory = factory;
	}

	public LocalDate getStartMedicalExams() {
		return startMedicalExams;
	}

	public void setStartMedicalExams(LocalDate startMedicalExams) {
		this.startMedicalExams = startMedicalExams;
	}

	public LocalDate getEndMedicalExams() {
		return endMedicalExams;
	}

	public void setEndMedicalExams(LocalDate endMedicalExams) {
		this.endMedicalExams = endMedicalExams;
	}

	public LocalDate getAddToSystem() {
		return addToSystem;
	}

	public void setAddToSystem(LocalDate addToSystem) {
		this.addToSystem = addToSystem;
	}

	public static boolean isIsup() {
		return isup;
	}

	public static void setIsup(boolean isup) {
		DataView.isup = isup;
	}

	public static ViewFields getField() {
		return field;
	}

	public static void setField(ViewFields field) {
		DataView.field = field;
	}	
}
