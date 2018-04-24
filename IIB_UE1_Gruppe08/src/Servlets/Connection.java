package Servlets;

import java.io.IOException;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		traitement(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
		
	}

	public void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		
		Login user=new Login(login,password);
		HttpSession mysession=request.getSession();
		mysession.setAttribute("utilisateur",user);
		
//		RequestDispatcher dispatcher=request.getRequestDispatcher("acceuille.jsp");
		
		RequestDispatcher dispatcher;
		if("admi".equalsIgnoreCase(password) && "admi".equalsIgnoreCase(login)) {
			dispatcher=request.getRequestDispatcher("accueille.jsp");
		}else {
			dispatcher=request.getRequestDispatcher("index.jsp");
      	}
		dispatcher.forward(request, response);
	}

}
