package com.hrtek.user.display.views;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.StatusWorker;
import com.hrtek.model.worker.Worker;
import com.hrtek.utils.FieldsComparator;

import lombok.Data;

@Data
public class ResidencyView implements Comparable<ResidencyView>{
	
	private int status;
	private Long id;
	private String firstname;
	private String lastname;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String paszport;
	private String biopaszport;
	private String company;
	private String factory;
	private String visa;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidFrom;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate visaValidTo;
	

	public ResidencyView(Worker w) {
		this.id = w.getId();
		this.firstname = w.getFirstname();
		this.lastname = w.getLastname();
		if(w.getStatus().equals(StatusWorker.ACTIVE))
			this.status = 1;
		else
			this.status = 0;
	}
	
	public void setFromResidency(Residency re) {
		this.paszport = re.getPassport();
		this.biopaszport = re.getBiopassport();
		this.visa = re.getVisa();
		this.visaValidFrom = re.getVisaValidFrom();
		this.visaValidTo = re.getVisaValidTo();
	}
	
	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;


	@Override
	public int compareTo(ResidencyView o) {
		switch (field) {
		case STATUS: return FieldsComparator.compareNumber(this.status, o.getStatus(), isup);
		case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
		case LASTNAME: return FieldsComparator.compareText(this.firstname, o.getLastname(), isup);
		case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
		case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
		case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);

		case PASZPORT: return FieldsComparator.compareText(this.paszport, o.getPaszport(), isup);
		case BIOPASZPORT: return FieldsComparator.compareText(this.biopaszport, o.getBiopaszport(), isup);
		case VISA: return FieldsComparator.compareText(this.visa, o.getVisa(), isup);
		case VISAFROM: return FieldsComparator.compareDate(this.visaValidFrom, o.getVisaValidFrom(), isup);
		case VISATO: return FieldsComparator.compareDate(this.visaValidTo, o.getVisaValidTo(), isup);
		default:
			break;
		}
		return 0;
	}
}
