import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
	
	private String dbURL;
	private String dbUsername;
	private String dbPassword;	
	Connection con=null;
	public UsersDAO(String dbURL, String dbUsername, String dbPassword) {
		this.dbURL = dbURL;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}
	void connect() throws SQLException{
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
	
	boolean registerUser(Users u) throws SQLException {
		String sql = "insert into users(ufname, ulname, uemail, upass, udob,ugender,ucity) values (?,?,?,?,?,?,?)";
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getUfname());
		ps.setString(2, u.getUlname());
		ps.setString(3, u.getUemail());
		ps.setString(4, u.getUpass());
		ps.setString(5, u.getUdob());
		ps.setString(6, u.getUgender()+"");
		ps.setString(7, u.getUcity());
		boolean rowInserted = ps.executeUpdate() > 0;
		ps.close();
		con.close();
		return rowInserted;		
	}
	
	boolean updateUser(Users u) throws SQLException {
		String sql = "UPDATE book SET ufname = ?, ulname = ?, uemail = ?, upass = ?, udob = ?, ucity = ? where userid = ?";
		connect();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, u.getUfname());
		ps.setString(2, u.getUlname());
		ps.setString(3, u.getUemail());
		ps.setString(4, u.getUpass());
		ps.setString(5, u.getUdob());
		ps.setString(6, u.getUcity());
		ps.setInt(7, u.getUid());
		boolean rowUpdated = ps.executeUpdate() > 0;
        ps.close();
        con.close();
        return rowUpdated;  
	}
	
	Users getUser(String email, String pass) throws SQLException {
		String sql = "select * from users where uemail = ? and upass = ?";
		connect();
		Users u = new Users();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, email);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			u.setUid(rs.getInt(1));
			u.setUfname(rs.getString(2));
			u.setUlname(rs.getString(3));
			u.setUemail(rs.getString(4));
			u.setUpass(rs.getString(5));
			u.setUdob(rs.getString(6));
			u.setUgender(rs.getString(7).charAt(0));
			u.setUcity(rs.getString(8));
		}
		return u;		
	}
}
