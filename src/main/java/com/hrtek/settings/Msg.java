package com.hrtek.settings;

import java.util.ArrayList;
import java.util.List;

public class Msg {
	public static String unknowPos = "Unknown position for ";
	public static String removedEmployee = "Removed employee: ";
	public static String modifiedEmployee  = " Modified Employee: <br />";
	public static String newEmployee  = "Added new employee: <br />";
	public static String disableFactory  = "Disabled factory: <br />";
	public static String enableFactory  = "Enabled factory: <br />";
	public static String modifiedFactory  = "Modified factory: <br />";
	public static String newFactory  = "Added new factory: <br />";
	
	public static String enableCompany  = "Enabled company: <br />";
	public static String modifiedCompany  = "Modified company: <br />";
	public static String newCompany  = "Added new company: <br />";
	
	
	public static String newDepartment  = "Added new department: ";
	public static String removeDepartment  = "Removed department: ";
	public static String newCitizenship  = "Added new citizenship: ";
	public static String removeCitizenship  = "Removed citizenship: ";
	public static String newPosition  = "Added new position: ";
	public static String removePosition  = "Removed positon: ";
	
	public static String newCandidate  = "Added new candidate: <br />";
	public static String removeCandidate  = "Removed candidate: <br />";
	public static String hireWorker  = "Hire worker: ";
	
	public static String permanentlyRemoved = "Permanently removed current worker: ";
	public static String permanentlyRemovedfromArchive = "Permanently removed worker from archive: ";

	public static List<String> mFileHeaders = new ArrayList<>();
	static {
		mFileHeaders.add("NR");
		mFileHeaders.add("FABRYKA");
		mFileHeaders.add("NAZWISKO IMIĘ");
		mFileHeaders.add("PESEL");
		mFileHeaders.add("DATA URODZENIA");
		mFileHeaders.add("WIEK");
		mFileHeaders.add("ZUS OD");
		mFileHeaders.add("ZUS DO");
		mFileHeaders.add("RODZAJ DOKUMENTU");
		mFileHeaders.add("OŚW/ZEZ WAŻNE OD");
		mFileHeaders.add("CAŁOŚĆ W MIESIACU");
		mFileHeaders.add("ILOSC GODZIN");
		mFileHeaders.add("NADWYŻKA");
		mFileHeaders.add("WYNAGRODZENIE NETTO");
		mFileHeaders.add("OS. DO 26 LAT");
		mFileHeaders.add("CZ 1");
		mFileHeaders.add("CZ 2");
		mFileHeaders.add("MIESZKANIE");
		mFileHeaders.add("ZALICZKA");
		mFileHeaders.add("BONUS");
		mFileHeaders.add("WYPŁATA GOTOWKA/PRZELEW");
		mFileHeaders.add(" ");
	}
}

