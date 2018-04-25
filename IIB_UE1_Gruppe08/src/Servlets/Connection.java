package Servlets;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Login;
import Beans.User;

/**
 * Servlet implementation class Passwort_Pruef
 */
@WebServlet("/Connection")
public class Connection extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connection() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			traitement(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			traitement(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		RequestDispatcher dispatcher;
		try {
			//MySQL Connection
			Class.forName("com.mysql.jdbc.Driver");
			java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iib2_ue1_gruppe08?useSSL=false", "root", "root");
			java.sql.Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select login_username,login_password  from login where login_username= '"+login+"' and login_password= '"+password+"';");
			if(rs.next()) {
				Login user=new Login(login,password);
				HttpSession mysession=request.getSession();
				mysession.setAttribute("utilisateur",user);					
				dispatcher=request.getRequestDispatcher("home.jsp");
				}else {
					dispatcher=request.getRequestDispatcher("index.jsp");
		      	}
				dispatcher.forward(request, response);
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
