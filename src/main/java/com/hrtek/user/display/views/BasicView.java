package com.hrtek.user.display.views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;

import lombok.Data;

@Data
public class BasicView implements Comparable<BasicView> {

	private int status;
	private Long id;
	private String firstname;
	private String lastname;
	private LocalDate dateofbirth;
	private String sex;
	private String citizenship;
	private String pesel;
	private String paszport;
	private String biopaszport;
	private String company;
	private String factory;
	private LocalDate startWork;
	private LocalDate startZus;
	private LocalDate endWork;
	private LocalDate endZus;	
	
	public BasicView(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
		if(w.getStatus().equals(StatusWorker.ACTIVE))
			this.status = 1;
		else
			this.status = 0;
	}
	
	public void setFromWorkerBasic(WorkerBasic wb) {
		this.dateofbirth = wb.getDateofbirth();
		this.sex = wb.getSex();
		this.pesel = wb.getPesel();
	}
	
	public void setFromWorkerDate(WorkerDate wd) {
		this.startWork = wd.getStartWork();
		this.startZus = wd.getStartZus();
		this.endZus = wd.getEndZus();
	}
	
	public void setFromResidency(Residency re) {
		this.paszport = re.getPassport();
		this.biopaszport = re.getBiopassport();
	}

	
	public enum Field{
		STATUS,
		FIRSTNAME,
		LASTNAME,
		DATEOFBIRTH,
		SEX,
		CITIZENSHIP,
		PESEL,
		PASZPORT,
		BIOPASZPORT,
		COMPANY,
		FACTORY,
		STARTWORK,
		STARTZUS,
		ENDZUS,
		ENDWORK
	}
	
	public static boolean up = false;
	public static Field field = Field.FIRSTNAME;
	
	@Override
	public int compareTo(BasicView o) {
		
		switch (field) {
		case STATUS: return compareStatus(o);
		case FIRSTNAME: return compareText(this.firstname, o.getFirstname());
		case LASTNAME: return compareText(this.firstname, o.getLastname());
		case DATEOFBIRTH: return compareDate(this.dateofbirth, o.getDateofbirth());
		case SEX: return compareText(this.sex, o.getSex());
		case CITIZENSHIP: return compareText(this.citizenship, o.getCitizenship());
		case PESEL: return compareText(this.pesel, o.getPesel());
		case PASZPORT: return compareText(this.paszport, o.getPaszport());
		case BIOPASZPORT: return compareText(this.biopaszport, o.getBiopaszport());
		case COMPANY: return compareText(this.company, o.getCompany());
		case FACTORY: return compareText(this.factory, o.getFactory());
		case STARTWORK: return compareDate(this.startWork, o.getStartWork());
		case STARTZUS: return compareDate(this.startZus, o.getStartZus());
		case ENDZUS: return compareDate(this.endZus, o.getEndZus());
		case ENDWORK: return compareDate(this.endWork, o.getEndWork());
		default:
			break;
		}
		return 0;
	}
	
	
	private int compareDate(LocalDate member, LocalDate o) {
		if(up) {
			if(member == null) return 1;
			if(o == null) return -1;
			return member.compareTo(o);
		}
		if(member == null) return -1;
		if(o == null) return 1;
		return -member.compareTo(o);
	}
	
	private int compareText(String member, String o) {
		if(up) {
			if(member == null) return 1;
			if(o == null) return -1;
			return member.compareToIgnoreCase(o);
		}
		if(member == null) return -1;
		if(o == null) return 1;
		return -member.compareToIgnoreCase(o);
	}
	
	private int compareStatus(BasicView o) {
		if(up) {
			if(this.status > o.status) return -1;
			if(this.status < o.status) return 1;
			return 0;
		}
		if(this.status < o.status) return -1;
		if(this.status > o.status) return 1;
		return 0;
	}
}
