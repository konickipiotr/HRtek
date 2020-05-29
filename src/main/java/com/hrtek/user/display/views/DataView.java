package com.hrtek.user.display.views;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.utils.FieldsComparator;

import lombok.Data;

@Data
public class DataView implements Comparable<DataView> {
	
	private int status;
	private Long id;
	private String firstname;
	private String lastname;
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
	
	
	
}
