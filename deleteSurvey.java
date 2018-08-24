

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class delete
 */
@WebServlet("/deleteSurvey")
public class deleteSurvey extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SurveyDAO surveyDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteSurvey() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	surveyDAO = new SurveyDAO(jdbcURL,jdbcUserName,jdbcPassword);
  
    	//a = new AdminDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		Survey a = new Survey();
		a.setSID(id);
		try {
			surveyDAO.deleteSurvey(a);
			response.sendRedirect("AdminHome");
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
	}

}
