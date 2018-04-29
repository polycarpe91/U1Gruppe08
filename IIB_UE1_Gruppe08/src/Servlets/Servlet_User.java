package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Beans.Login;
import Beans.Project;
import DB_connect.Connection_and_ResultSet_close;
import DB_connect.databank;

/**
 * Servlet implementation class Servlet_User
 */
@WebServlet("/Servlets_User")
public class Servlet_User extends HttpServlet {
	private String  SQL_Call_User_Projekt="SELECT * from project as p, user as u, user_hat_project as "
			+ "uhp where uhp.user_hat_project_project_id=p.project_id and uhp.user_hat_project_user_id =";
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet_User() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			Projekt_Anzeige(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			Projekt_Anzeige(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	@SuppressWarnings("null")
	public void Projekt_Anzeige(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		HttpSession mysession=request.getSession();
		Login user=(Login) mysession.getAttribute("utilisateur");	
		//MySQL Connection
		ResultSet rs;
		Connection  con;
		Statement st;
			con= databank.getInstance();
			st = con.createStatement();
			String SQL_Projekt="";
		     rs = st.executeQuery(SQL_Projekt);
			rs = st.executeQuery(SQL_Call_User_Projekt+user.getLogin()+";");
		Project project=new Project();
		ArrayList<Project> maListe = null;
		while(rs.next()) {	
			project.setProject_anfang(rs.getString("project_anfang"));
			project.setProject_end(rs.getString("project_end"));
			project.setProject_name(rs.getString("project_name"));
			project.setProject_id(rs.getInt("project_id"));
			maListe.add(project);
			
		}
		  
		if(maListe.isEmpty()) {
			int message = 1;
			request.setAttribute( "message", message );
			this.getServletContext().getRequestDispatcher( "./Vue_Backend/Error.jsp" ).forward( request, response );
			
		}else {
			mysession.setAttribute("myListe",maListe); //mit diese liste hast du alle projet in user_Fronkend.jsp
			this.getServletContext().getRequestDispatcher("./Vue_Backend/user_Fronkend.jsp").forward(request, response);
			
		}
			
			
			
			Connection_and_ResultSet_close.silentClosing(rs, st, con);
	}


	
	

}
