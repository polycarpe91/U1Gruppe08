package Beans;

public class Login {

	private  String login;
	private String password;
	
	
	public Login(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}


	public Login() {
		// TODO Auto-generated constructor stub
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

}
