package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Login;
import DB_connect.Connection_and_ResultSet_close;
import DB_connect.databank;

/**
 * Servlet implementation class Passwort_Pruef
 */
@WebServlet("/Login_User")
public class Login_User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_User() {
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
		//connection to Databank
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL_login="Select login_username,login_password  from login where login_username= '"+login+"' and login_password= '"+password+"';";
		ResultSet rs = st.executeQuery(SQL_login);
		if(rs.next()) {
			Login user=new Login(login,password);
			
			HttpSession mysession=request.getSession();
			mysession.setAttribute("utilisateur",user);
			
			dispatcher=request.getRequestDispatcher("./Vue_Backend/home.jsp");
			}else {
				dispatcher=request.getRequestDispatcher("index.jsp");
		  	}
			dispatcher.forward(request, response);
		
		Connection_and_ResultSet_close.silentClosing(rs, st, con);
		
	}
	

}
