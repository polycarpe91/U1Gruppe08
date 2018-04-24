package Beans;

public class User {
   int user_id;
   private String user_vorname;
   private String user_Nachname;
   private String user_tel;
   private String user_create_time;
   
	public int getUser_id() {
	return user_id;
}

public User(int user_id, String user_vorname, String user_Nachname, String user_tel, String user_create_time) {
		super();
		this.user_id = user_id;
		this.user_vorname = user_vorname;
		this.user_Nachname = user_Nachname;
		this.user_tel = user_tel;
		this.user_create_time = user_create_time;
	}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}

public String getUser_vorname() {
	return user_vorname;
}

public void setUser_vorname(String user_vorname) {
	this.user_vorname = user_vorname;
}

public String getUser_Nachname() {
	return user_Nachname;
}

public void setUser_Nachname(String user_Nachname) {
	this.user_Nachname = user_Nachname;
}

public String getUser_tel() {
	return user_tel;
}

public void setUser_tel(String user_tel) {
	this.user_tel = user_tel;
}

public String getUser_create_time() {
	return user_create_time;
}

public void setUser_create_time(String user_create_time) {
	this.user_create_time = user_create_time;
}

	public User() {
		// TODO Auto-generated constructor stub
	}

}
