

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UsersDAO usersDAO;
	Users u;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public register() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	usersDAO = new UsersDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        String ufname=request.getParameter("userfname");
        String ulname=request.getParameter("userlname");
		String uemail = request.getParameter("uemail");
		String upass = request.getParameter("upass");
		String ugender =request.getParameter("ugender");
		String udob = request.getParameter("udob");
		String ucity = request.getParameter("ucity");
		try
		{
        u=new Users(ufname,ulname,uemail,upass,udob,ugender,ucity);
       System.out.println( usersDAO.registerUser(u));
		response.sendRedirect("login.jsp");
     }
		catch (SQLException e) {
			e.printStackTrace();}
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
