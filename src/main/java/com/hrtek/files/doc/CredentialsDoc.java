package com.hrtek.files.doc;

import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;

import com.hrtek.model.User;
import com.hrtek.model.UserInfo;

public class CredentialsDoc implements Doc<XWPFDocument> {

	private String font = "Times New Roman";
	private XWPFDocument doc = new XWPFDocument();
	private DocType doctype = DocType.TEXTUSERDOC;
	private User user;
	private UserInfo userinfo;
	private String pass;
	
	private void fontstyle(XWPFRun r, boolean bold) {
		r.setFontFamily(font);
		r.setFontSize(10);
		r.setBold(bold);
	}
	
	@Override
	public void prepareDoc() {
		CTSectPr sectPr = doc.getDocument().getBody().addNewSectPr();
		CTPageMar pgMar = sectPr.addNewPgMar();
		
		pgMar.setLeft(BigInteger.valueOf(1000L));
		pgMar.setTop(BigInteger.valueOf(1000L));
		pgMar.setRight(BigInteger.valueOf(1000L));
		pgMar.setBottom(BigInteger.valueOf(1000L));
		
		XWPFParagraph p1 = doc.createParagraph();
		p1.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r1 = p1.createRun();
		fontstyle(r1, true);
		r1.setText("Credentials");
		r1.addBreak();
		
		XWPFParagraph p2 = doc.createParagraph();
		p2.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("Imię:  ");
		r2 = p2.createRun();
		fontstyle(r2, true);
		r2.setText(userinfo.getFirstname());
		r2.addBreak();
		r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("Nazwisko:  ");
		r2 = p2.createRun();
		fontstyle(r2, true);
		r2.setText(userinfo.getLastname());
		r2.addBreak();
		
		r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("Login:  ");
		r2 = p2.createRun();
		fontstyle(r2, true);
		r2.setText(user.getUsername());
		r2.addBreak();
		r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("One-time password: ");
		r2 = p2.createRun();
		fontstyle(r2, true);
		r2.setText(pass);
		r2.addBreak();
		
		
	}

	@Override
	public XWPFDocument getDoc() {
		return doc;
	}

	@Override
	public String getFilepath() {
		return "/tmp";
	}

	@Override
	public String getFilename() {
		return "Credentials_" + userinfo.getLastname() + "_"  + userinfo.getFirstname() + ".docx";
	}

	@Override
	public DocType getType() {
		return this.doctype;
	}

	public CredentialsDoc(User user, UserInfo userinfo, String pass) {
		this.user = user;
		this.userinfo = userinfo;
		this.pass = pass;
	}

	
}
