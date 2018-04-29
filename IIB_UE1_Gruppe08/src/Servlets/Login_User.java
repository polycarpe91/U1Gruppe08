package Servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
		//connection to Databank
		Connection  con= databank.getInstance();
		Statement st = con.createStatement();
		String SQL_login="Select * from iib2_ue1_gruppe08.login where login_username= '"+login+"' and login_password= '"+password+"';";
		ResultSet rs = st.executeQuery(SQL_login);
		String login_user_id = null;
		if(rs.next()) {
		   login_user_id=rs.getString("login_user_id");
			
		}
		else {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	     }
		System.out.println(login_user_id);
		String SQL_Taetigkeit="SELECT taetigkeit_name FROM iib2_ue1_gruppe08.taetigkeit as T , "
				+ "iib2_ue1_gruppe08.user as U ,iib2_ue1_gruppe08.login as L  where "
				+ " U.user_taetigkeit_id=T.taetigkeit_id and  U.user_id ='"+login_user_id+"' LIMIT 1;";
		Login user=new Login(login,password);
		ResultSet rs2 = st.executeQuery(SQL_Taetigkeit);
		String taetigkeit = null;
		while(rs2.next()) {
		   taetigkeit=rs2.getString("taetigkeit_name");
		   System.out.println(taetigkeit );
		
				if(taetigkeit.equalsIgnoreCase("Bauleiter")){
					HttpSession mysession=request.getSession();
					mysession.setAttribute("utilisateur",user);
					mysession.setAttribute("taetigkeit",taetigkeit);
					
					this.getServletContext().getRequestDispatcher("/Vue_Backend/home.jsp").forward(request, response);
					}else {
						HttpSession mysession=request.getSession();
						mysession.setAttribute("utilisateur",user);
						mysession.setAttribute("taetigkeit",taetigkeit);
						this.getServletContext().getRequestDispatcher("/Vue_Backend/home.jsp").forward(request, response);
					}
			
			}
				
		Connection_and_ResultSet_close.silentClosing(rs, st, con);
		
	}
	

}
