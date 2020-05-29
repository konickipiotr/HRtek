package com.hrtek.user.display.views;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;
import com.hrtek.model.worker.WorkerDate;
import com.hrtek.utils.FieldsComparator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
		this.endWork = wd.getEndWork();
	}
	
	public void setFromResidency(Residency re) {
		this.paszport = re.getPassport();
		this.biopaszport = re.getBiopassport();
	}
	
	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;
	
	@Override
	public int compareTo(BasicView o) {
		
		switch (field) {
		case STATUS: return FieldsComparator.compareNumber(this.status, o.getStatus(), isup);
		case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
		case LASTNAME: return FieldsComparator.compareText(this.firstname, o.getLastname(), isup);
		case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
		case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
		case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);
		case STARTWORK: return FieldsComparator.compareDate(this.startWork, o.getStartWork(), isup);
		case STARTZUS: return FieldsComparator.compareDate(this.startZus, o.getStartZus(), isup);
		case ENDZUS: return FieldsComparator.compareDate(this.endZus, o.getEndZus(), isup);
		case ENDWORK: return FieldsComparator.compareDate(this.endWork, o.getEndWork(), isup);
		
		case SEX: return FieldsComparator.compareText(this.sex, o.getSex(), isup);
		case CITIZENSHIP: return FieldsComparator.compareText(this.citizenship, o.getCitizenship(), isup);
		case PESEL: return FieldsComparator.compareText(this.pesel, o.getPesel(), isup);
		case PASZPORT: return FieldsComparator.compareText(this.paszport, o.getPaszport(), isup);
		case BIOPASZPORT: return FieldsComparator.compareText(this.biopaszport, o.getBiopaszport(), isup);
		default:
			break;
		}
		return 0;
	}
}
