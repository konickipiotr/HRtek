package com.hrtek.files.doc;

import java.math.BigInteger;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTPageMar;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.springframework.beans.factory.annotation.Autowired;

import com.hrtek.model.Company;
import com.hrtek.model.Factory;
import com.hrtek.model.worker.Contact;
import com.hrtek.model.worker.Residency;
import com.hrtek.model.worker.Worker;
import com.hrtek.model.worker.WorkerBasic;

import lombok.Data;

@Data
public class Contract implements Doc<XWPFDocument> {

	private XWPFDocument doc = new XWPFDocument();
	private DocType doctype = DocType.TEXTUSERDOC;
	private double wage;
	private String sWage;
	
	private Company company;
	private Worker worker;
	private Residency residency;
	private Contact contact;
	private Factory factory;	
	private WorkerBasic wb;

	private static String font = "Times New Roman";

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
		
		pl();
		ukr();
	}
	
	private void ukr() {
		XWPFParagraph p1 = doc.createParagraph();
		p1.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r1 = p1.createRun();
		fontstyle(r1, true);
		r1.setText("Договор-поручение");
		r1.addBreak();
		
		XWPFParagraph p2 = doc.createParagraph();
		p2.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("Подписанный ............................................................. в городе  ");
		r2 = p2.createRun();
		fontstyle(r2, true);
		r2.setText("Вроцлав ");
		r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("между:");
		r2.addBreak();

		XWPFParagraph p3 = doc.createParagraph();
		p3.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText(company.agreementData());
		r3.addBreak();
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText("далее ");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText("Заказчик");	
		r3.addBreak();
		r3.addBreak();
		
		//XWPFParagraph p4 = doc.createParagraph();
		///p4.setAlignment(ParagraphAlignment.LEFT);
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText("и  (Имя, Фамилия) ");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText(worker.getFirstname() + " " + worker.getLastname());
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText(" номер и серия удосоверения личности/паспорта ");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText((residency.getPassport() == null || residency.getPassport().isBlank()) ? residency.getBiopassport() : residency.getPassport());
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText(" почтовый адрес или адрес прописки ");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText(contact.getPladdress() + ", " + contact.getPlpostcode() + " " + contact.getPlcity());
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText(" далее ");
		//XWPFRun r4_h = p4.createRun();
		//fontstyle(r4_h, true);
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText("Исполнитель.");
		r3.addBreak();
		r3.addBreak();
		
		XWPFParagraph p5 = doc.createParagraph();
		p5.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r5 = p5.createRun();
		fontstyle(r5, true);
		r5.setText("§ 1");
		
		XWPFParagraph p6 = doc.createParagraph();
		p6.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r6 = p6.createRun();
		fontstyle(r6, false);
		r6.setText("1.На основании данного договора Заказчик поверяет, а Исполнитель обязуется выполнить работы на должности: ");
		r6 = p6.createRun();
		fontstyle(r6, true);
		r6.setText("работник производства.");
		r6.addBreak();
		r6 = p6.createRun();
		fontstyle(r6, false);
		r6.setText("2.Адрес места работы:  ");
		r6 = p6.createRun();
		fontstyle(r6, true);
		r6.setText(factory.getAddress() + ", " + factory.getPostcode() + " " + factory.getCity());
		r6.addBreak();
		
		XWPFParagraph p7 = doc.createParagraph();
		p7.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r7 = p7.createRun();
		fontstyle(r7, true);
		r7.setText("§ 2");
		
		XWPFParagraph p8 = doc.createParagraph();
		p8.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r8 = p8.createRun();
		fontstyle(r8, false);
		r8.setText("1. За исполнение выше указанных работ Исполнитель получит заработную плату в размере "); 

		r8 = p8.createRun();
		fontstyle(r8, true);
		r8.setText(String.valueOf(Double.toString(wage)) + " zł");
		r8 = p8.createRun();
		fontstyle(r8, false);
		r8.setText(" злотых брутто в час (" + sWage + ").");
		
		r8.addBreak();
		r8 = p8.createRun();
		fontstyle(r8, false);
		r8.setText("2. Заработная плата до 15 числа следующего месяца. ");
		r8.addBreak();	
		
		
		XWPFParagraph p9 = doc.createParagraph();
		p9.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r9 = p9.createRun();
		fontstyle(r9, true);
		r9.setText("§ 3");
		
		XWPFParagraph p10 = doc.createParagraph();
		p10.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r10 = p10.createRun();
		fontstyle(r10, false);
		r10.setText("Исполнитель не может передать свои обязанности третьему лицу без согласия Заказчика. ");
		r10.addBreak();
		
		XWPFParagraph p11 = doc.createParagraph();
		p11.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r11 = p11.createRun();
		fontstyle(r11, true);
		r11.setText("§ 4");
		
		XWPFParagraph p12 = doc.createParagraph();
		p12.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r12 = p12.createRun();
		fontstyle(r12, false);
		r12.setText("Исполнитель обязан придерживаться внутреннего распорядка работы, с которым его ознакомят перед началом трудовой деятельности.");
	
		XWPFParagraph p13 = doc.createParagraph();
		p13.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r13 = p13.createRun();
		fontstyle(r13, true);
		r13.setText("§ 5");
		
		XWPFParagraph p14 = doc.createParagraph();
		p14.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r14 = p14.createRun();
		fontstyle(r14, false);
		r14.setText("1. Договор действует с  .......................................-......................................");
		r14.addBreak();
		r14 = p14.createRun();
		fontstyle(r14, false);
		r14.setText("2. Начало работы наступит после получения всех необходимых разрешений. ");
		r14.addBreak();
		
		XWPFParagraph p15 = doc.createParagraph();
		p15.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r15 = p15.createRun();
		fontstyle(r15, true);
		r15.setText("§ 6");
		
		XWPFParagraph p16 = doc.createParagraph();
		p16.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r16 = p16.createRun();
		fontstyle(r16, false);
		r16.setText("1. Заказчик имеет право разорвать договор-поручение в лубое время, если Исполнитель выполняет работу не добросовестно и не придерживается правил поведения, обязывающих на территории предприятия.");
		r16.addBreak();
		r16 = p16.createRun();
		fontstyle(r16, false);
		r16.setText("2. Исполнитель имеет право разорвать договор-поручение, заранее проинформировав об этом Заказчика, придерживаясь срока 7 рабочих дней. ");
		r16.addBreak();
		
		XWPFParagraph p17 = doc.createParagraph();
		p17.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r17 = p17.createRun();
		fontstyle(r17, true);
		r17.setText("§ 7");
		
		XWPFParagraph p18 = doc.createParagraph();
		p18.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r18 = p18.createRun();
		fontstyle(r18, false);
		r18.setText("1. Остальные пункты, не указанные в данном договоре, регулирует Гражданский Кодекс РП. ");
		r18.addBreak();
		
		XWPFParagraph p19 = doc.createParagraph();
		p19.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r19 = p19.createRun();
		fontstyle(r19, true);
		r19.setText("§ 8");
		
		XWPFParagraph p20 = doc.createParagraph();
		p20.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r20 = p20.createRun();
		fontstyle(r20, false);
		r20.setText("1.Договор составлен в 2 идентичных экземплярах на польском и русском языках, по одной копии для каждой из сторон.");
		r20.addBreak();
		r20 = p20.createRun();
		fontstyle(r20, false);
		r20.setText("2.Подписывая данный договор, я согласен с ним и понимаю его содержание. ");
		r20.addBreak();
		
		XWPFParagraph p21 = doc.createParagraph();
		p21.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r21 = p21.createRun();
		fontstyle(r21, false);
		r21.addBreak();
		r21.addBreak();
		r21.addBreak();
		r21.setText("...........................                                                            ..........................");
		r21.addBreak();  
		r21.setText("(Заказчик)                                                                    ( Исполнитель)");
		r21.addBreak();
		
		XWPFParagraph p22 = doc.createParagraph();
		p22.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r22 = p22.createRun();
		fontstyle(r22, false);
		r22.setText("Ваши личные данные будут обрабатываться в процессе набора персонала, получения необходимых разрешений на работу, а также всех видов деятельности, связанных с работой по договору-поручению. Администратором персональных данных является фирма UWC Sp. z o.o.c зарегистрированным офисом во Вроцлаве по ул. Кутновска 1-3, НРАТ 17873, e-mail: uwc.biuro@gmail.com . Администратор разрешает обрабатывать личные данные только уполномоченным лицам.");
		r22.addBreak();
		r22.setText("Личные данные будут храниться в течение 5 лет с момента окончания контракта. По истечении этого времени личные данные будут удалены. Лицо, чьи данные будут хранится, имеет право получить доступ к своим данным, исправить их, ограничить их обработку, внести протест их обработки и право подать жалобу в надзорный орган.");
	}
	
	private void pl() {
		XWPFParagraph p1 = doc.createParagraph();
		p1.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r1 = p1.createRun();
		fontstyle(r1, true);
		r1.setText("Umowa zlecenie");
		r1.addBreak();
		
		XWPFParagraph p2 = doc.createParagraph();
		p2.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("Zawarta w dniu ............................................................. we ");
		r2 = p2.createRun();
		fontstyle(r2, true);
		r2.setText("Wrocławiu ");
		r2 = p2.createRun();
		fontstyle(r2, false);
		r2.setText("pomiędzy");
		r2.addBreak();

		XWPFParagraph p3 = doc.createParagraph();
		p3.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText(company.agreementData());
		r3.addBreak();
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText("Zwanym dalej ");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText("Zleceniodawcą");	
		r3.addBreak();
		r3.addBreak();
		
		XWPFParagraph p4 = doc.createParagraph();
		p4.setAlignment(ParagraphAlignment.LEFT);
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText(wb.getSex().equals("M") ? "A Panem " : "A Panią ");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText(worker.getFirstname() + " " + worker.getLastname());
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText((wb.getSex().equals("M") ? " legitymującym" : " legitymującą" ) + " się dowodem osobistym/paszportem seria i nr ");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText( (residency.getPassport() == null || residency.getPassport().isBlank()) ? residency.getBiopassport() : residency.getPassport());
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText(" adres korespondencyjny w " + (wb.getSex().equals("M") ? "Pana" : "Pani" )+ " kraju");
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText(contact.getAddress() + ", " + contact.getPostcode() + " " + contact.getCity());
		r3 = p3.createRun();
		fontstyle(r3, false);
		r3.setText((wb.getSex().equals("M") ? "zwanym" : "zwaną" ) + " dalej ");
		XWPFRun r4_h = p4.createRun();
		fontstyle(r4_h, true);
		r3 = p3.createRun();
		fontstyle(r3, true);
		r3.setText("Zleceniobiorcą.");
		r3.addBreak();
		r3.addBreak();
		
		XWPFParagraph p5 = doc.createParagraph();
		p5.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r5 = p5.createRun();
		fontstyle(r5, true);
		r5.setText("§ 1");
		
		XWPFParagraph p6 = doc.createParagraph();
		p6.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r6 = p6.createRun();
		fontstyle(r6, false);
		r6.setText("1.Na podstawie niniejszej umowy Zleceniodawca zleca, a  Zleceniobiorca zobowiązuje się do wykonania pracy na następującym stanowisku: ");
		r6 = p6.createRun();
		fontstyle(r6, true);
		r6.setText("pracownik produkcji");
		r6.addBreak();
		r6 = p6.createRun();
		fontstyle(r6, false);
		r6.setText("2.Adres miejsca wykonywania pracy: ");
		r6 = p6.createRun();
		fontstyle(r6, true);
		r6.setText(factory.getAddress() + ", " + factory.getPostcode() + " " + factory.getCity());
		r6.addBreak();
		
		XWPFParagraph p7 = doc.createParagraph();
		p7.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r7 = p7.createRun();
		fontstyle(r7, true);
		r7.setText("§ 2");
		
		XWPFParagraph p8 = doc.createParagraph();
		p8.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r8 = p8.createRun();
		fontstyle(r8, false);
		r8.setText("1. Za wykonanie prac określonych w § 1 Zleceniobiorca otrzyma po ich wykonaniu wynagrodzenie w wysokości ");
		r8 = p8.createRun();
		fontstyle(r8, true);
		r8.setText(Double.toString(wage));
		r8 = p8.createRun();
		fontstyle(r8, false);
		r8.setText(" zł  brutto/godzina, (słownie: " +sWage+  " brutto za godzinę");
		r8.addBreak();
		r8 = p8.createRun();
		fontstyle(r8, false);
		r8.setText("2. Wynagrodzenie płatne jest do 15 dnia następnego miesiąca. ");
		r8.addBreak();
		
		XWPFParagraph p9 = doc.createParagraph();
		p9.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r9 = p9.createRun();
		fontstyle(r9, true);
		r9.setText("§ 3");
		
		XWPFParagraph p10 = doc.createParagraph();
		p10.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r10 = p10.createRun();
		fontstyle(r10, false);
		r10.setText("Zleceniobiorca nie może powierzyć prac wymienionych w § 1 innym osobom bez zgody Zleceniodawcy.");
		r10.addBreak();
		
		XWPFParagraph p11 = doc.createParagraph();
		p11.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r11 = p11.createRun();
		fontstyle(r11, true);
		r11.setText("§ 4");
		
		XWPFParagraph p12 = doc.createParagraph();
		p12.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r12 = p12.createRun();
		fontstyle(r12, false);
		r12.setText("Zleceniobiorca zobowiązuje się do przestrzegania wewnętrznego regulaminu firmy, z którym zostanie \n" + 
				"zapoznany przed rozpoczęciem pracy.");
		r12.addBreak();
	
		XWPFParagraph p13 = doc.createParagraph();
		p13.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r13 = p13.createRun();
		fontstyle(r13, true);
		r13.setText("§ 5");
		
		XWPFParagraph p14 = doc.createParagraph();
		p14.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r14 = p14.createRun();
		fontstyle(r14, false);
		r14.setText("1.Umowa została zawarta na czas: ");
		r14 = p14.createRun();
		fontstyle(r14, true);
		r14.setText( ".......................................-......................................"); //TODO
		r14.addBreak();
		r14 = p14.createRun();
		fontstyle(r14, false);
		r14.setText("2. Rozpoczęcie pracy następuje w momencie uzyskania wszystkich niezbędnych zezwoleń.");
		r14.addBreak();
		
		XWPFParagraph p15 = doc.createParagraph();
		p15.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r15 = p15.createRun();
		fontstyle(r15, true);
		r15.setText("§ 6");
		
		XWPFParagraph p16 = doc.createParagraph();
		p16.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r16 = p16.createRun();
		fontstyle(r16, false);
		r16.setText("1. Zleceniodawca ma prawo wypowiedzieć umowę Zleceniobiorcy bez zachowania okresu wypowiedzenia w przypadku braku staralności wykonania zlecenia, nieprzestrzegania panujących zasad dotyczących zachowania.");
		r16.addBreak();
		r16 = p16.createRun();
		fontstyle(r16, false);
		r16.setText("2. Zleceniobiorca ma prawo wypowiedzieć umowę zlecenia z zachowaniem terminu 7 dni roboczych.");
		r16.addBreak();
		
		XWPFParagraph p17 = doc.createParagraph();
		p17.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r17 = p17.createRun();
		fontstyle(r17, true);
		r17.setText("§ 7");
		
		XWPFParagraph p18 = doc.createParagraph();
		p18.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r18 = p18.createRun();
		fontstyle(r18, false);
		r18.setText("1.W sprawach nieuregulowanych niniejszą umową mają zastosowanie przepisy Kodeksu Cywilnego.");
		r18.addBreak();
		
		XWPFParagraph p19 = doc.createParagraph();
		p19.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r19 = p19.createRun();
		fontstyle(r19, true);
		r19.setText("§ 8");
		
		XWPFParagraph p20 = doc.createParagraph();
		p20.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r20 = p20.createRun();
		fontstyle(r20, false);
		r20.setText("1.Umowa została sporządzona w dwóch jednobrzmiących egzemplarzach w dwóch językach – po jednej  dla każdej ze stron.");
		r20.addBreak();
		r20 = p20.createRun();
		fontstyle(r20, false);
		r20.setText("2.Podpisując daną umowę oświadczam, że rozumiem i zgadzam się z jej treścią. ");
		r20.addBreak();
		
		XWPFParagraph p21 = doc.createParagraph();
		p21.setAlignment(ParagraphAlignment.CENTER);
		XWPFRun r21 = p21.createRun();
		fontstyle(r21, false);
		r21.addBreak();
		r21.addBreak();
		r21.addBreak();
		r21.setText("...........................                                                            ..........................");
		r21.addBreak();  
		r21.setText("(Zleceniodawca)                                                          (Zleceniobiorca)");
		r21.addBreak();
		//r21.addBreak();
		
		XWPFParagraph p22 = doc.createParagraph();
		p22.setAlignment(ParagraphAlignment.LEFT);
		XWPFRun r22 = p22.createRun();
		fontstyle(r22, false);
		r22.setText((wb.getSex().equals("M") ? "Pana" : "Pani" ) + " dane osobowe będą przetwarzane w procesie rekrutacji, uzyskania niezbędnych zezwoleń na pracę oraz wszystkich czynności związanych z procesem z wykonywania umowy zlecenia. Administratorem danych osobowych jest spółka UWC z siedzibą we Wrocławiu przy ul . Kutnowskiej 1-3, KRAZ 17873, e-mail: uwc.biuro@gmail.com. Pracodawca dopuszcza do przetwarzania danych osobowych wyłącznie osoby i podmioty upoważnione.");
		r22.addBreak();
		r22.setText("Dane osobowe będą przechowywane przez okres 5 lat od zakończenie umowy. Po tym czasie dane osobowe zostaną usunięte. Osobie, której dane dotyczą przysługuje prawo dostępu do swoich danych, ich sprostowania, ograniczenia przetwarzania, wniesienia sprzeciwu wobec ich przetwarzania, a także prawo wniesienia skargi do organu nadzorczego.");
	}

	public Contract() {
	}

	public XWPFDocument getDoc() {
		return doc;
	}

	@Override
	public String getFilepath() {
		String filepath = worker.getId() + worker.getLastname();
		return filepath;
	}

	@Override
	public DocType getType() {
		return this.doctype;
	}

	@Override
	public String getFilename() {
		return "Contract_" + worker.getLastname() + "_"  + worker.getFirstname() + ".docx";
	}

	@Autowired
	public Contract(Company company, Worker worker, Residency residency, Contact contact,
			Factory factory, WorkerBasic wb, double wage, String sWage) {
		this.company = company;
		this.worker = worker;
		this.residency = residency;
		this.contact = contact;
		this.factory = factory;
		this.wb = wb;
		this.wage = wage;
		this.sWage = sWage;
	}
	
	
}
