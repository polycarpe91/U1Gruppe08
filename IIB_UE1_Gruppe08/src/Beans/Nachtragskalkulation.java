package Beans;

public class Nachtragskalkulation {
  private int kalkulation_id;
  private int kalkulation_menge;
  private String kalkulation_einheit;
  private String kalkulation_preise_einheit;
  private String kalkulation_prise_gesant;
	public Nachtragskalkulation() {
		// TODO Auto-generated constructor stub
	}
	public Nachtragskalkulation(int kalkulation_id, int kalkulation_menge, String kalkulation_einheit,
			String kalkulation_preise_einheit, String kalkulation_prise_gesant) {
		super();
		this.kalkulation_id = kalkulation_id;
		this.kalkulation_menge = kalkulation_menge;
		this.kalkulation_einheit = kalkulation_einheit;
		this.kalkulation_preise_einheit = kalkulation_preise_einheit;
		this.kalkulation_prise_gesant = kalkulation_prise_gesant;
	}
	public int getKalkulation_id() {
		return kalkulation_id;
	}
	public void setKalkulation_id(int kalkulation_id) {
		this.kalkulation_id = kalkulation_id;
	}
	public int getKalkulation_menge() {
		return kalkulation_menge;
	}
	public void setKalkulation_menge(int kalkulation_menge) {
		this.kalkulation_menge = kalkulation_menge;
	}
	public String getKalkulation_einheit() {
		return kalkulation_einheit;
	}
	public void setKalkulation_einheit(String kalkulation_einheit) {
		this.kalkulation_einheit = kalkulation_einheit;
	}
	public String getKalkulation_preise_einheit() {
		return kalkulation_preise_einheit;
	}
	public void setKalkulation_preise_einheit(String kalkulation_preise_einheit) {
		this.kalkulation_preise_einheit = kalkulation_preise_einheit;
	}
	public String getKalkulation_prise_gesant() {
		return kalkulation_prise_gesant;
	}
	public void setKalkulation_prise_gesant(String kalkulation_prise_gesant) {
		this.kalkulation_prise_gesant = kalkulation_prise_gesant;
	}

}
