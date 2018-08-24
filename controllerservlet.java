

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ControllerServlet
 */
public class controllerservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    AdminDAO adminDAO;
    questionDAO quesDAO;
    AdminBean ab;
    public controllerservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init()
    {
    	String jdbcURL=getServletContext().getInitParameter("dbURL");
    	String jdbcUserName=getServletContext().getInitParameter("dbUsername");
    	String jdbcPassword=getServletContext().getInitParameter("dbPassword");
    	adminDAO = new AdminDAO(jdbcURL,jdbcUserName,jdbcPassword);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action=request.getServletPath();
		try
		{
			switch(action)
			{
			case "/new":
				showNewForm(request,response);
				break;
			case "/insert":
				insertadmin(request,response);
				break;
			case "/delete":
				deleteadmin(request,response);
				break;
			case "/edit":
				showEditadmin(request,response);
				break;
			case "/update":
				updateadmin(request,response);
				break;
			case "/list":
				listallAdmin(request,response);
				break;
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	
	private void listallAdmin(HttpServletRequest request,HttpServletResponse response)
	throws SQLException,IOException,ServletException
	{
		List<AdminBean> adminlist= adminDAO.listAdmin();
		request.setAttribute("adminlist",adminlist);
		RequestDispatcher dispatcher=request.getRequestDispatcher("adminlists.jsp");
		dispatcher.forward(request, response);
	}

	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response)
			throws SQLException,IOException,ServletException
			{
				RequestDispatcher dispatcher=request.getRequestDispatcher("editadmin.jsp");
				dispatcher.forward(request, response);
			}
	
	private void insertadmin(HttpServletRequest request,HttpServletResponse response)
			throws SQLException,IOException
			{
				String aemail=request.getParameter("email");
				String apass=request.getParameter("password");
								
				AdminBean newad =new AdminBean(aemail,apass);
				adminDAO.insert(newad);
				response.sendRedirect("list");
				
			}
	
	private void updateadmin(HttpServletRequest request,HttpServletResponse response)
			throws SQLException,IOException
			{
				int aid=Integer.parseInt(request.getParameter("aid"));
				String aemail=request.getParameter("aemail");
				String apass=request.getParameter("apass");
								
				AdminBean ab =new AdminBean(aid,aemail,apass);
		             adminDAO.update(ab);
				response.sendRedirect("list");
			}
	
	
	private void deleteadmin(HttpServletRequest request,HttpServletResponse response)
			throws SQLException,IOException
			{
				int aid=Integer.parseInt(request.getParameter("aid"));
				AdminBean ab=new AdminBean(aid);
			adminDAO.delete(ab);
				response.sendRedirect("list");
			}
	

	private void showEditadmin(HttpServletRequest request,HttpServletResponse response)
			throws SQLException,IOException,SQLException, ServletException
			{
				String aemail=request.getParameter("email");
				String apass=request.getParameter("password");
				AdminBean existingadmin=adminDAO.getAdmin(aemail,apass);
				RequestDispatcher dispatcher=request.getRequestDispatcher("editadmin.jsp");
				request.setAttribute("admin", existingadmin);
				dispatcher.forward(request, response);
			}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
