package Beans;

public class Adresse {
   private int adresse_id;
   private String adresse_contry;
   private String adresse_stadt;
   private String adresse_code;
   private String adresse_Strasse;
   private String adresse_hausenummer;
	public Adresse(int adresse_id, String adresse_contry, String adresse_stadt, String adresse_code, String adresse_Strasse,
		String adresse_hausenummer) {
	super();
	this.adresse_id = adresse_id;
	this.adresse_contry = adresse_contry;
	this.adresse_stadt = adresse_stadt;
	this.adresse_code = adresse_code;
	this.adresse_Strasse = adresse_Strasse;
	this.adresse_hausenummer = adresse_hausenummer;
}
	public int getAdresse_id() {
	return adresse_id;
}
public void setAdresse_id(int adresse_id) {
	this.adresse_id = adresse_id;
}
public String getAdresse_contry() {
	return adresse_contry;
}
public void setAdresse_contry(String adresse_contry) {
	this.adresse_contry = adresse_contry;
}
public String getAdresse_stadt() {
	return adresse_stadt;
}
public void setAdresse_stadt(String adresse_stadt) {
	this.adresse_stadt = adresse_stadt;
}
public String getAdresse_code() {
	return adresse_code;
}
public void setAdresse_code(String adresse_code) {
	this.adresse_code = adresse_code;
}
public String getAdresse_Strasse() {
	return adresse_Strasse;
}
public void setAdresse_Strasse(String adresse_Strasse) {
	this.adresse_Strasse = adresse_Strasse;
}
public String getAdresse_hausenummer() {
	return adresse_hausenummer;
}
public void setAdresse_hausenummer(String adresse_hausenummer) {
	this.adresse_hausenummer = adresse_hausenummer;
}
	public Adresse() {
		// TODO Auto-generated constructor stub
	}

}
