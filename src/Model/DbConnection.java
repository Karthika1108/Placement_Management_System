package Model;
import java.sql.*;
   public class DbConnection {
	   static String  url ="jdbc:mysql://localhost:3306/placement";
	   static String  username="root";
	   static String pwd="Thara@123^123";
   public static Connection connection() {
	   try {
		Connection conn=DriverManager.getConnection(url,username, pwd);
		return conn;
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
	   return null;
   }

}
