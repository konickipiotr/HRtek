package com.hrtek.admin.others;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import com.hrtek.model.worker.Worker;
import com.hrtek.user.dismissed.Dismissed;
import com.hrtek.user.display.views.ViewFields;
import com.hrtek.utils.FieldsComparator;


public class WorkerView implements Comparable<WorkerView> {
	
	private Long id;
	private String firstname;
	private String lastname;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private LocalDate dateofbirth;
	private String company;
	private String factory;
	private String passport;
	private String pesel;
	
	public WorkerView() {
	}
	
	public WorkerView(Long id, String firstname, String lastname, LocalDate dateofbirth, String company, String factory,
			String passport, String pesel) {
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dateofbirth = dateofbirth;
		this.company = company;
		this.factory = factory;
		this.passport = passport;
		this.pesel = pesel;
	}
	
	public WorkerView(Worker worker) {
		this.id = worker.getId();
		this.firstname = worker.getFirstname();
		this.lastname = worker.getLastname();
	}
	
	public WorkerView(Dismissed worker) {
		this.id = worker.getId();
		this.firstname = worker.getFirstname();
		this.lastname = worker.getLastname();
		this.dateofbirth = worker.getDateofbirth();
		this.pesel = worker.getPesel();
		this.company = worker.getCompany();
		this.factory = worker.getFactory();
	}
	
	public static boolean isup = false;
	public static ViewFields field = ViewFields.FIRSTNAME;

	@Override
	public int compareTo(WorkerView o) {
		switch (field) {
		
		case FIRSTNAME: return FieldsComparator.compareText(this.firstname, o.getFirstname(), isup);
		case LASTNAME: return FieldsComparator.compareText(this.firstname, o.getLastname(), isup);
		case DATEOFBIRTH: return FieldsComparator.compareDate(this.dateofbirth, o.getDateofbirth(), isup);
		case COMPANY: return FieldsComparator.compareText(this.company, o.getCompany(), isup);
		case FACTORY: return FieldsComparator.compareText(this.factory, o.getFactory(), isup);		
		case PESEL: return FieldsComparator.compareText(this.pesel, o.getPesel(), isup);
		case PASZPORT: return FieldsComparator.compareText(this.passport, o.getPassport(), isup);
		default:
			break;
		}
		return 0;
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

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public static boolean isIsup() {
		return isup;
	}

	public static void setIsup(boolean isup) {
		WorkerView.isup = isup;
	}

	public static ViewFields getField() {
		return field;
	}

	public static void setField(ViewFields field) {
		WorkerView.field = field;
	}
}
