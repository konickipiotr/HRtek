package com.hrtek.files.doc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.hrtek.settings.GlobalSettings;

public class SaveFile{
	
	private String path;
	
	public SaveFile() {
		String userName = System.getProperty("user.name");
		path = "/home/" + userName + GlobalSettings.hrtekRoot;
	}

	public String saveDoc(Doc doc) {
		
		String path = getPath(doc);
		XWPFDocument textfile;
		Workbook excelfile;
		FileOutputStream out;
		try {
			out = new FileOutputStream(new File(path));
			
			switch (doc.getType()) {
			case TEXTUSERDOC:{
				textfile = (XWPFDocument) doc.getDoc();
				textfile.write(out);
				
			} break;
			case EXCELRAPORT:{
				excelfile = (Workbook) doc.getDoc();
				excelfile.write(out);
			}break;
			default:
				break;
			}
			
			out.close();
			out.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
		return path;
	}
	
	private String getPath(Doc doc) {
		String filepath = "";
		
		switch (doc.getType()) {
		case TEXTUSERDOC: filepath = path + "/" + GlobalSettings.hrtekWorkersDir + "/" +  doc.getFilepath(); break;
		case EXCELRAPORT: filepath = path + "/" + doc.getFilepath(); break;
		default:
			break;
		}
		
		Path basepath = Paths.get(filepath);
		Path absolutepath = basepath.toAbsolutePath();
		
		new File(absolutepath.toString()).mkdirs();
		return filepath = absolutepath.toString() + "/" + doc.getFilename();
	}
}
