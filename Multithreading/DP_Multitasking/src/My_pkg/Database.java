package My_pkg;
import java.sql.*;

public class Database {
	Connection conn;
	Statement stmt;
	public String name;
	public int roll_number;
	public float cgpa, attendance;
	private String DB_USER = "admin";
	private String DB_PASS = "admin";
	private String DB_URL = "jdbc:mysql://localhost/student";
	
	
	Database() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		stmt = conn.createStatement();
		name = null;
	}
	public ResultSet executeQuery(String query){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	
	public void print(Object ob){System.out.println(ob);}
	
	
	public boolean returnData(String user_name, String password){
		ResultSet rs = executeQuery("SELECT * FROM mis WHERE user_name='" + user_name + "' and password='" + password + "'");
		try{
			if(rs.next()){
				/*print("Roll Number: " + rs.getInt("roll_number"));
				print("Name: " + rs.getString("name"));
				print("CGPA: " + rs.getFloat("cgpa"));
				print("Attendance: " + rs.getFloat("attendance"));
				*/
				name = rs.getString("name");
				roll_number = rs.getInt("roll_number");
				cgpa = rs.getFloat("cgpa");
				attendance = rs.getFloat("attendance");
				return true;
			}
			else{
				print("User name and password incorrect");
				print("\n\n");
				print("Thankyou for using our system");
				return false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}
	/*
	 * 
	  // Driver code
	public static void main(String args[]) throws Exception{
		Database db = new Database();
		db.returnData("naren", "khake");
		
	}
	*/
}
