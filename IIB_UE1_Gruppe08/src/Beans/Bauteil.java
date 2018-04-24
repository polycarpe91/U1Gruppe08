package Beans;

public class Bauteil {
private int bauteil_id;
private String project_name;

	public Bauteil(int bauteil_id, String project_name) {
	super();
	this.bauteil_id = bauteil_id;
	this.project_name = project_name;
}

	public Bauteil() {
		// TODO Auto-generated constructor stub
	}

	public int getBauteil_id() {
		return bauteil_id;
	}

	public void setBauteil_id(int bauteil_id) {
		this.bauteil_id = bauteil_id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

}
