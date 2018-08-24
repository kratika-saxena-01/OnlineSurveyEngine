
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SurveyDAO {
	private String dbURL;
	private String dbUsername;
	private String dbPassword;	
	Connection con=null;
	SurveyDAO(String dbURL,String dbUsername,String dbPassword)
	{
		this.dbURL=dbURL;
		this.dbUsername=dbUsername;
		this.dbPassword=dbPassword;
		
	}
   void connect() throws SQLException
   {
        if(con == null|| con.isClosed()) 
        {
            try
            {
                Class.forName("oracle.jdbc.driver.OracleDriver");
            } 
            catch(ClassNotFoundException e) 
            {
                throw new SQLException(e);
            }
            
            con = DriverManager.getConnection(dbURL, dbUsername,dbPassword);
        }
   }
     
  /* void disconnect() throws SQLException 
   {
       if(con != null  && !con.isClosed()) 
           con.close();
   }*/
   
   boolean insertSurveyId(Survey survey) throws SQLException
   {
	   String sql = "INSERT INTO Surveys (SID,AID) VALUES (?,?)";
       connect();
       PreparedStatement ps = con.prepareStatement(sql);
       ps.setInt(1, survey.getSid());
       ps.setInt(2, survey.getAid());
       boolean rowInserted = ps.executeUpdate() > 0;
       ps.close();
       con.close();
       return rowInserted;
   }
   
   boolean insertQuestionDetails(Survey survey) throws SQLException
   {
	   String sql = "UPDATE Surveys SET SNAME = ?, SNQ = ?, DOC = ?, DOM = ?, NOR= ?";
       sql += " WHERE SID = ?";  
       connect();
       
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setString(1, survey.getSname());
       statement.setInt(2, survey.getSnq());
       statement.setString(3, survey.getDoc());
       statement.setString(4, survey.getDom());
       statement.setInt(5, survey.getNor());
       
       statement.setInt(5, survey.getSid());
       
       boolean rowUpdated = statement.executeUpdate() > 0;
       statement.close();
       con.close();
       return rowUpdated;
   }
   
   public List<Survey> listAllSurvey() throws SQLException {
       List<Survey> listSurvey = new ArrayList<>();
        String sql = "SELECT * FROM Surveys";
        connect();
        Statement statement = con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()) {
        	int Sid=resultSet.getInt("SID");
        	int Aid=resultSet.getInt("AID");
        	String Sname=resultSet.getString("SNAME");
        	int Snq=resultSet.getInt("SNQ");
        	String Doc=resultSet.getString("DOC");
        	String Dom=resultSet.getString("DOM");
        	int Nor=resultSet.getInt("NOR");
            Survey survey = new Survey(Sid, Aid, Sname, Snq, Doc, Dom, Nor);
            listSurvey.add(survey); 
       }
        
         resultSet.close();
         statement.close();
         con.close();
         return listSurvey;
    }
        
    boolean deleteSurvey(Survey survey) throws SQLException {
        String sql = "DELETE FROM Surveys where SID= ?";
        connect();
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, survey.getSid());
        boolean rowDeleted = ps.executeUpdate() > 0;
        ps.close();
        con.close();
        return rowDeleted;             
   }
   
    public Survey getSurvey(int Sid) throws SQLException {
       Survey survey = null;
       String sql = "SELECT * FROM Surveys WHERE SID= ?";
       connect();
       PreparedStatement statement = con.prepareStatement(sql);
       statement.setInt(1, Sid);
        
       ResultSet resultSet = statement.executeQuery();
        
       if(resultSet.next()) {
       	int Aid=resultSet.getInt("AID");
       	String Sname=resultSet.getString("SNAME");
       	int Snq=resultSet.getInt("SNQ");
       	String Doc=resultSet.getString("DOC");
       	String Dom=resultSet.getString("DOM");
       	int Nor=resultSet.getInt("NOR");
            
        survey= new Survey(Sid, Aid, Sname, Snq, Doc, Dom, Nor);
       }
        
       resultSet.close();
       statement.close();
       return survey;
   }

}