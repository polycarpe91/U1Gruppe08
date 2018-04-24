package Beans;

public class Pruefung {
  private int pruefung_id;
  private String pruefung_ergebnis;
  
	public Pruefung(int pruefung_id, String pruefung_ergebnis) {
	super();
	this.pruefung_id = pruefung_id;
	this.pruefung_ergebnis = pruefung_ergebnis;
}
	public Pruefung() {
		// TODO Auto-generated constructor stub
	}
	public int getPruefung_id() {
		return pruefung_id;
	}
	public void setPruefung_id(int pruefung_id) {
		this.pruefung_id = pruefung_id;
	}
	public String getPruefung_ergebnis() {
		return pruefung_ergebnis;
	}
	public void setPruefung_ergebnis(String pruefung_ergebnis) {
		this.pruefung_ergebnis = pruefung_ergebnis;
	}

}
