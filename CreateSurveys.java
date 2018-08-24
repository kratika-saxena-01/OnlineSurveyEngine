

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CreateSurvey
 */
@WebServlet("/CreateSurveys")
public class CreateSurveys extends HttpServlet {
	private static final long serialVersionUID = 1L;
	SurveyDAO surveyDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateSurveys() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	surveyDAO = new SurveyDAO(jdbcURL,jdbcUserName,jdbcPassword);

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {
		// TODO Auto-generated method stub
		String sname = request.getParameter("survey_name");
		System.out.println(sname);
		HttpSession session = request.getSession(false);
		int aid = (int) session.getAttribute("a_id");
		Survey s = new Survey();
		s.setAID(aid);
		s.setSname(sname);
		s.setSnq(0);
		s.setDoc(java.time.LocalDate.now()+"");
		
		try {
			System.out.println(surveyDAO.insertSurveyId(s));
			response.sendRedirect("CreateSurvey.jsp");
			
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
