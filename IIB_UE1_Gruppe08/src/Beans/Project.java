package Beans;

public class Project {

	 private int project_id;
	 private String project_name;
	 private String project_anfang;
	 public int getProject_id() {
		return project_id;
	}
	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getProject_anfang() {
		return project_anfang;
	}
	public void setProject_anfang(String project_anfang) {
		this.project_anfang = project_anfang;
	}
	public String getProject_end() {
		return project_end;
	}
	public void setProject_end(String project_end) {
		this.project_end = project_end;
	}
	private String project_end;
	public Project() {
		// TODO Auto-generated constructor stub
	}
	public Project(int project_id, String project_name, String project_anfang, String project_end) {
		super();
		this.project_id = project_id;
		this.project_name = project_name;
		this.project_anfang = project_anfang;
		this.project_end = project_end;
	}

}
