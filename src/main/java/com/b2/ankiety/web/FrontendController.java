package com.b2.ankiety.web;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.b2.ankiety.model.Answer;
import com.b2.ankiety.model.Choice;
import com.b2.ankiety.model.Dictionary;
import com.b2.ankiety.model.Division;
import com.b2.ankiety.model.Person;
import com.b2.ankiety.model.Question;
import com.b2.ankiety.model.Subdivision;

@RequestMapping("/frontend/**")
@Controller
public class FrontendController {

    @RequestMapping(method = RequestMethod.POST, value = "{id}")
    public void post(@PathVariable Long id, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
    }

    @RequestMapping
    public String index() {
        return "frontend/index";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/fixtures")
    public String fixtures() {
    	
    	String[] choicesBody1 = {"Mam pewną wiedzę o obszarze, wymagam wsparcia w rozumieniu  szczegółów i relacji", "Rozumiem możliwości i ograniczenia, jestem na bieżąco ze zmianami i planami w obszarze, mam wystarczającą wiedzę i doświadczenie, aby działać samodzielnie", "Mam szeroką wiedzę i doświadczenie w obszarze, identyfikuję problemy i mogę proponować rozwiązania, jestem rozpoznawany jako ekspert w obszarze" }; 
    	Dictionary d1 = createDictionary("Umiejętności biznesowe", choicesBody1);
    	
    	Division div1 = new Division();
    	div1.setTitle("Umiejętności biznesowe");
    	div1.persist();
    	
    	String[] questionBody1 = {"Zarządzanie Polisami Majątkowymi – klienci indywidualni", "Zarządzanie Polisami Majątkowymi – klienci korporacyjni", "Zarządzanie Grupowymi Polisami Życiowymi", "Zarządzanie Polisami Zdrowotnymi", "Zarządzanie Indywidualnymi Polisami Życiowymi Ochronnymi (w tym bancassurance)", "Zarządzanie Produktami Emerytalnymi, Produktami Inwestycyjnymi i Polisami Życiowymi Inwestycyjnymi", "Zarządzanie relacjami z klientem", "Sprzedaż i posprzedażowa  obsługa polis", "Kanały Dostępu i Marketing (w tym direct, self-service, kanały komunikacji)", "Likwidacja Szkód i Świadczeń", "Assistance", "Płatności i Rozliczenia", "Windykacje", "Gospodarka Własna", "Księgowość ubezpieczeniowa i księgowość funduszy (w tym reasekuracja)", "Kadry i Płace", "Zarządzanie Procesami i Treścią", "Business Intelligence /Raportowanie analityczne", "Zarządzanie aktywami", "Zarządzanie bezpieczeństwem/tożsamością"};
    	createQuestionsForSubdivision(div1, d1, "Znajomość procesów biznesowych i/lub produktów i otoczenia IT w danym obszarze", questionBody1);

    	
    	
    	Division div2 = new Division();
    	div2.setTitle("Umiejętności IT");
    	div2.persist();

    	String[] choicesBody2 = {"Znam zasady, mogę je zastosować pod nadzorem", "Stosuję zasady w praktyce, mogę działać samodzielnie", "Jestem ekspertem, mogę ocenić  jakość"};
    	Dictionary d2 = createDictionary("Umiejętności IT", choicesBody2);

    	String[] questionBody4 = {"Tworzenie strategii IT", "Zarządzanie popytem", "Zarządzanie jakością organizacji i procesów", "Modelowanie i optymalizacja procesów", "Tworzenie strategii architektury korporacyjnej", "Tworzenie strategii architektury infrastruktury IT", "Tworzenie strategii bezpieczeństwa IT", "Zarządzanie programem (portfelem)  projektów", "Zarządzanie poziomem usług", "Zarządzanie portfelem dostawców", "Zarządzanie standardami"};
    	createQuestionsForSubdivision(div2, d2, "Strategia i nadzór IT", questionBody4);

    	String[] questionBody5 = {"Tworzenie architektury rozwiązań", "Analizy biznesowe", "Analizy opłacalności rozwiązania", "Zarządzanie wymaganiami/zakresem ", "Analizy systemowe", "Projektowanie systemów", "Projektowanie infrastruktury rozwiązania", "Programowanie", "Organizacja i koordynowanie testów (w tym zarządzanie błędami)", "Tworzenie planu jakości i strategii testów", "Projektowanie i budowa scenariuszy testów wydajnościowych", "Projektowanie i budowa scenariuszy testowych", "Projektowanie i budowa automatycznych skryptów testowych", "Tworzenie dokumentacji architektury korporacyjnej"};
    	createQuestionsForSubdivision(div2, d2, "Budowa rozwiązań", questionBody5);

    	String[] questionBody6 = {"Zarządzanie incydentami", "Zarządzanie problemami", "Administrowanie aplikacjami", "Administrowanie infrastrukturą", "Zarządzanie konfiguracją", "Zarządzanie zmianą IT", "Zarządzanie pojemnością", "Monitorowanie"};
    	createQuestionsForSubdivision(div2, d2, "Utrzymanie rozwiązań", questionBody6);

    	String[] questionBody7 = {"PR i komunikacja", "Wycena usług IT", "Analiza finansowa inwestycji IT", "Budżetowanie IT", "Zarządzanie licencjami / znajomość modeli licencjonowania", "Zarządzanie sprzętem IT", "Budowa kontraktów", "Rozliczenia dostawców", "Analiza danych raportowych", "Przygotowywanie raportów zarządczych", "Analiza i raportowanie portfela projektów"};
    	createQuestionsForSubdivision(div2, d2, "Wsparcie", questionBody7);

    	String[] questionBody8 = {"Zarządzanie ciągłością usług (DR)", "Zarzadzanie bezpieczeństwem IT", "Zarządzanie ryzykiem IT", "Audyty i kontrole", "Testy penetracyjne", "Zarządzanie incydentami bezpieczeństwa", "Zarządzanie usługami kryptograficznymi", "Informatyka śledcza", "Monitorowanie bezpieczeństwa IT"};
    	createQuestionsForSubdivision(div2, d2, "Bezpieczeństwo", questionBody8);

    	String[] questionBody9 = {"Zarządzanie budżetem projektu", "Zarządzanie ryzykiem", "Zarządzanie projektem", "Zarządzanie zespołem zwinnym (SCRUM master)"};
    	createQuestionsForSubdivision(div2, d2, "Zarządzanie", questionBody9);


    	
    	Division div3 = new Division();
    	div3.setTitle("Umiejętności Technologiczne i Znajomość Narzędzi IT");
    	div3.persist();

    	String[] choicesBody3 = {"Mam pewną wiedzę o narzędziu lub technologii, nie używałem w praktyce lub wymagam wsparcia i nadzoru", "Rozumiem możliwości i ograniczenia, potrafię samodzielnie stosować w praktyce, jestem na bieżąco ze zmianami i rozwojem technologii/narzędzia", "Mam szeroką wiedzę i doświadczenie w technologii/narzędziu, potrafię proponować rozwiązania z zastosowaniem technologii/narzędzia, jestem rozpoznawany jako ekspert"};
    	Dictionary d3 = createDictionary("Umiejętności Technologiczne i Znajomość Narzędzi IT", choicesBody3);

    	String[] questionBody10 = {"ARIS", "Enterprise Architect"};
    	createQuestionsForSubdivision(div3, d3, "Architektura", questionBody10);

    	String[] questionBody11 = {"Java", "PL/SQL (Oracle)", "Oracle Forms", "GOSU", "SPL (Informix)", ".NET/C#", "PHP", "C++", "Clipper", "FoxPro", "Delphi", "Access", "Python", "Perl", "Bash"};
    	createQuestionsForSubdivision(div3, d3, "Programowanie", questionBody11);

    	String[] questionBody12 = {"WAN", "San FC", "LoadBalancery", "Iptelefonia", "Firewalls", "WIFI", "LANDC", "LAN"};
    	createQuestionsForSubdivision(div3, d3, "Sieci", questionBody12);

    	String[] questionBody13 = {"Netbackup", "Networker"};
    	createQuestionsForSubdivision(div3, d3, "Backup", questionBody13);

    	String[] questionBody14 = {"Nagios", "RUEI", "BSM", "Nimsoft", "Oprogramowanie do monitrowania SANu", "Oprogramowanie do monitorowania sieci", "DynaTrace", "AppDynamics", "CloudControl", "SCOM", "IBM Director", "CACA", "SOI"};
    	createQuestionsForSubdivision(div3, d3, "Monitoring", questionBody14);

    	String[] questionBody15 = {"Raportowanie-SAS Web Report Studio", "Silniki danych – SAS "};
    	createQuestionsForSubdivision(div3, d3, "Hurtownie", questionBody15);

    	String[] questionBody16 = {"Linux", "Solaris", "Windows Server", "Windows PC", "AIX", "Mac OS", "iOS", "Windows Phone", "BSD", "Android", "Solaris"};
    	createQuestionsForSubdivision(div3, d3, "Systemy operacyjne", questionBody16);

    	String[] questionBody17 = {"Serwery RISC", "Serwery Intel", "NAS", "FC switche", "Macierze mid-range", "Macierze high-end", "Backup (bliblioteki taśmowe, data domain, VTL etc)", "UPSy", "Środowisko biurowe (komputery i peryferia)", "Urządzenia mobilne (smartphones, tablety)"};
    	createQuestionsForSubdivision(div3, d3, "Hardware", questionBody17);

    	String[] questionBody18 = {"Oracle DB", "MS SQL", "Informix", "DB2", "MySQL", "PostgreSQL"};
    	createQuestionsForSubdivision(div3, d3, "Bazy danych", questionBody18);

    	String[] questionBody19 = {"Kontener servletów – Apache Tomcat, tcServer, etc.", "Kontener EJB, JMS – Oracle Weblogic, Websphere, JBoss, Oracle AS ", "Serwer http – apache, IIS, Oracle http", "Platforma .net – IIS", "Platforma PHP", "Silnik regułowy - drools", "Silnik raportowy – Pentaho, SWR, Crystal Reports, Oracle Publisher …", "Kontener portletów – Liferay", "Repozytorium dokumentów – ECM sprzętowy, Filenet,", "Magistrala danych IBM", "Magistrala serwisowa", "MS AD", "MS ISA Server", "MS Exchange Server", "MS SCCM", "MS MOM/SCOM", "LDAP", "Platforma wirtualizacyjna"};
    	createQuestionsForSubdivision(div3, d3, "Middleware", questionBody19);

    	String[] questionBody20 = {"Spring", "Freemarker", "JQuery", "Vaadin", "ExtGWT"};
    	createQuestionsForSubdivision(div3, d3, "Software front end", questionBody20);

    	String[] questionBody21 = {"SharePoint", "Administracja i instalacja MS Office"};
    	createQuestionsForSubdivision(div3, d3, "Aplikacje biurowe", questionBody21);

    	String[] questionBody22 = {"Administracja i rozwój JIRA", "SDM", "TestLink", "HP QC", "Lotus Notes", "Aplikacje do testów wydajnościowych"};
    	createQuestionsForSubdivision(div3, d3, "Aplikacje biznesowe/IT standardowe", questionBody22);

    	String[] questionBody23 = {"Assistance", "AZI", "Bankowe", "CBA", "CBKI PZU SA", "CBKI PZU Życie SA", "CCMS", "CCMS", "CENJOTY", "COK", "Compass", "COMW2", "ECM", "eDOK", "ELFIK", "ERP", "eRU", "Form Analyzer", "Guidewire BC", "Guidewire PC", "GURiK", "HRM", "Hurtownia Danych PZU SA", "IBUZ", "Insurer-CSI", "Internetowy portal korporacyjny www.pzu.pl", "Invest", "IPA", "JIRA", "KanGUR", "Kondor+", "KOZUB/KOKOSZ", "Magistrala danych", "Magistrala serwisowa", "MAX", "MDM", "mFact", "NND", "Pentaho", "PERS", "Portal agenta", "PPO", "PWD", "RENTY NP", "ROS", "Samor", "SATOFE2", "Sezam", "SGW", "SHDS", "SKUNKS", "SLS", "SOBA", "SOFI", "Solar", "Statystyka", "SWS (SAS Financial Management + SAS Planning)", "TETA", "TimeSheet", "TitusPlus", "ZUDU", "Zarządzanie danymi (information management)"};
    	createQuestionsForSubdivision(div3, d3, "Aplikacje biznesowe dedykowane (znajomość budowy systemu lub administracji)", questionBody23);

    	String[] questionBody24 = {"PKI", "eGRC", "DLP", "Narzędzia do monitorowania (IPS, SIEM, Antywirus, monitoring sesji adm., DAM)", "Bezpieczństwo transmisji danych", "Narzędzia testów penetracyjnych/ VA"};
    	createQuestionsForSubdivision(div3, d3, "Bezpieczeństwo i ryzyko IT", questionBody24);
    	
    	
    	
    	Division div4 = new Division();
    	div4.setTitle("Metodyki i Certyfikaty");
    	div4.persist();

    	String[] choicesBody4 = {"Znam", "Zam i mam certyfikat"};
    	Dictionary d4 = createDictionary("Metodyki i Certyfikaty", choicesBody4);

    	String[] questionBody25 = {"MSP", "Prince2/ PMP", "AgilePM/ SAFe", "Profesional Scrum Master", "P3O/ MoP"};
    	createQuestionsForSubdivision(div4, d4, "Zarządzanie programami, projektami i inicjatywami", questionBody25);

    	String[] questionBody26 = {"ISO9000"};
    	createQuestionsForSubdivision(div4, d4, "Zarządzanie jakością", questionBody26);

    	String[] questionBody27 = {"COBIT", "Lean/ Six-Sigma", "BPMN"};
    	createQuestionsForSubdivision(div4, d4, "Modelowanie i optymalizacja procesów", questionBody27);

    	String[] questionBody28 = {"UML", "ReqB - CPRE", "FURPS"};
    	createQuestionsForSubdivision(div4, d4, "Analizy i zarządzanie wymaganiami", questionBody28);

    	String[] questionBody29 = {"TOGAF", "Archimate", "The Open Group Certified Architect"};
    	createQuestionsForSubdivision(div4, d4, "Architektura korporacyjnaa", questionBody29);

    	String[] questionBody30 = {"SOA"};
    	createQuestionsForSubdivision(div4, d4, "Projektowanie aplikacji", questionBody30);

    	String[] questionBody31 = {"RUP", "SCRUM", "RAD", "Extreme programming"};
    	createQuestionsForSubdivision(div4, d4, "Programowanie", questionBody31);

    	String[] questionBody32 = {"ISTQB", "TQM"};
    	createQuestionsForSubdivision(div4, d4, "Testy i zarządzanie jakością", questionBody32);

    	String[] questionBody33 = {"ITIL3"};
    	createQuestionsForSubdivision(div4, d4, "Wsparcie użytkownika", questionBody33);

    	String[] questionBody34 = {"CIMA", "CFA"};
    	createQuestionsForSubdivision(div4, d4, "Zarządzanie finansami", questionBody34);

    	String[] questionBody35 = {"CGEIT"};
    	createQuestionsForSubdivision(div4, d4, "Nadzór IT", questionBody35);

    	String[] questionBody36 = {"M_o_R", "CISA/CISM/CISSP", "ISO27001", "CRISC", "SANS"};
    	createQuestionsForSubdivision(div4, d4, "Zarzadzanie bezpieczeństwem i ryzykiem IT", questionBody36);

    	String[] questionBody37 = {"ISO 22301:2012, ISO 22313:2012"};
    	createQuestionsForSubdivision(div4, d4, "Planowanie ciągłości działania / Disaster recovery", questionBody37);
    	
    	
    	
    	Division div5 = new Division();
    	div5.setTitle("Języki Obce");
    	div5.persist();

    	String[] choicesBody5 = {"Bierna znajomość języka, np. umożliwiająca korzystanie z aplikacji/systemów informatycznych", "Komunikacja werbalna, pisanie i czytanie, tworzenie dokumentów i komunikacja w zakresie merytorycznym"};
    	Dictionary d5 = createDictionary("Języki Obce", choicesBody5);

    	String[] questionBody38 = {"Angielski", "Rosyjski"};
    	createQuestionsForSubdivision(div5, d5, "Języki Obce", questionBody38);
    	
    	
    	///users
    	createAnswer("aaa", 1L);
    	createAnswer("aaa", 2L);
    	createAnswer("aaa", 3L);    	
    	createAnswer("bbb", 1L);
    	createAnswer("bbb", 2L);
    	createAnswer("bbb", 5L);
    	createAnswer("ccc", 1L);
    	createAnswer("ddd", 3L);
    	createAnswer("ddd", 4L);
    	
        return "frontend/fixtures";
    }

    private void createAnswer(String username, long subdivisionId) {
    	Person p1 = Person.findPersonByUsernameOrCreate(username);
    	Subdivision sub = Subdivision.findSubdivision(subdivisionId); 
    	
    	Answer a1 = new Answer();
    	a1.setChoice(firstChoice(sub.getDictionary().getChoices()));
    	a1.setPerson(p1);
    	a1.setQuestion(firstQuestion(sub.getQuestions()));
    	a1.setInterested(false);
    	a1.persist();
    	
    }
    
    private Choice firstChoice(Set<Choice> s) {
    	Choice rq = null;
    	for (Choice q : s) {
    		rq = q;
    		break;
    	}
    	return rq;
    }
    
    private Question firstQuestion(Set<Question> s) {
    	Question rq = null;
    	for (Question q : s) {
    		rq = q;
    		break;
    	}
    	return rq;
    }
     
    private void createQuestionsForSubdivision(Division div, Dictionary d, String divisionTitle, String[] questionBody) {

    	Subdivision sub1 = new Subdivision();
    	sub1.setTitle(divisionTitle);
    	sub1.setDictionary(d);
    	sub1.persist();
    	
    	Set<Subdivision> subdivisions = div.getSubdivisions();
    	subdivisions.add(sub1);
    	div.setSubdivisions(subdivisions);
    	div.persist();
    	
    	Set<Question> questions = new HashSet<Question>();
    	
    	for (String b : questionBody) {
    		Question q = new Question();
    		q.setBody(b);
    		questions.add(q);
    		q.persist();
    	}
    	
    	sub1.setQuestions(questions);
    	sub1.persist();
	}

	private Dictionary createDictionary(String description, String[] choicesBody) {
    	Dictionary d0 = new Dictionary();
    	d0.setDescription(description);
    	d0.persist();
    	
    	Set<Choice> choices = new HashSet<Choice>();
    	
    	for (String b : choicesBody) {
    		Choice c = new Choice();
    		c.setBody(b);
    		choices.add(c);
    		c.persist();
    	}
    	d0.setChoices(choices);
    	d0.persist(); 
    	return d0;
    }
    
}
