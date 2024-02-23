package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
public class MentorModel {
	boolean flag;
	public  boolean loginMentor(String user,String pass) throws SQLException {
		Connection con=DbConnection.connection();
		Statement sts=con.createStatement();
		String query="Select * from mentor";
		ResultSet r=sts.executeQuery(query);
		while(r.next()) {
			if(r.getString(3).equals(user)) {
				if(r.getString(4).equals(pass)) {
					flag=true;
					break;
				}
				else
					flag=false;
			}
			else {
				flag=false;
			}
		}
		return flag;
	}
	public boolean insertStudent(String name,String reg_no,String dept,int p_level,String lang,String domain,String project,double mark_10,double mark_12,double cgpa,String batch) throws SQLException {
		Connection con=DbConnection.connection();
		String query="INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psd=con.prepareStatement(query);
		int count=0;
    	String cQuery="Select count(S_ID) from STUDENT";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(cQuery);
    	while(r1.next())
    		count=r1.getInt(1);
		psd.setInt(1,count+1);
		psd.setString(2, name);
		psd.setString(3, reg_no);
		psd.setString(4, dept);
		psd.setInt(5, p_level);
		psd.setString(6, lang);
		psd.setString(7, domain);
		psd.setString(8, project);
		psd.setDouble(9, mark_10);
		psd.setDouble(10, mark_12);
		psd.setDouble(11, cgpa);
		psd.setString(12,batch);
		int res=psd.executeUpdate();
		if(res==1)
			flag=true;
		else
			flag=false;
		return flag;
		
	}
	public boolean deleteStudent(String regno) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="DELETE FROM STUDENT WHERE S_REGNO=?";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1, regno);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean changePassword(String name,String password) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="UPDATE MENTOR SET M_PASSWORD=? WHERE M_EMAIL=? ;";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1, password);
    	psd.setString(2, name);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean updateBatch(String regno,String batch) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="UPDATE STUDENT SET S_BATCH=? WHERE S_REGNO=? ;";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1, batch);
    	psd.setString(2, regno);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean updateProject(String regno,String status) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="UPDATE STUDENT SET S_PROJECT=? WHERE S_REGNO=? ;";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1,status );
    	psd.setString(2, regno);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean updatePortal(String regno,String level) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="UPDATE STUDENT SET S_PLEVEL=? WHERE S_REGNO=? ;";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1,level );
    	psd.setString(2, regno);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
     public ArrayList<String> displayAll(String placed) throws SQLException{
    	 Connection con=DbConnection.connection();
    	 String str="";
    	 ArrayList<String>students=new ArrayList<>();
    	 String query="SELECT * FROM STUDENT where placed "+placed;
    	 Statement sts=con.createStatement();
    	 ResultSet r=sts.executeQuery(query);
    	 while(r.next()) {
    		 str=r.getString(2)+"@"+r.getString(3)+"@"+r.getString(4)+"@"+r.getString(5)+"@"+r.getString(6)+"@"+r.getString(7)+"@"+r.getString(12);
    		 
    	     students.add(str);
    	 }
    	  return students;
     }
     public ArrayList<String> display(String cat,String val) throws SQLException {
    	 Connection con=DbConnection.connection();
    	 ArrayList<String>student=new ArrayList<>();
    	 String str="";
    	 String query="SELECT * FROM STUDENT WHERE "+cat+" = \""+val+"\"";
    	 PreparedStatement psd=con.prepareStatement(query);
    	
    	// System.out.println(query);
    	 ResultSet r=psd.executeQuery();
    	 while(r.next()) {
    		 str=r.getString(2)+"@"+r.getString(3)+"@"+r.getString(4)+"@"+r.getString(5)+"@"+r.getString(6)+"@"+r.getString(7)+"@"+r.getString(12);
    		  student.add(str);
    	 }
    	 return student;
     }
     public ArrayList<String> displayRange(String cat,String val) throws SQLException {
    	 Connection con=DbConnection.connection();
    	 ArrayList<String>student=new ArrayList<>();
    	 String str="";
    	 String query="SELECT * FROM STUDENT WHERE "+cat+" >= \""+val+"\"";
    	 PreparedStatement psd=con.prepareStatement(query);
    	
    	// System.out.println(query);
    	 ResultSet r=psd.executeQuery();
    	 while(r.next()) {
    		 str=r.getString(2)+"@"+r.getString(3)+"@"+r.getString(4)+"@"+r.getString(5)+"@"+r.getString(6)+"@"+r.getString(7)+"@"+r.getString(12);
    		  student.add(str);
    	 }
    	 return student;
     }
}
/*

hema@gmail.com

87654321

s_language

*/
