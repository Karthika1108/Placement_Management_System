package Model;
import java.util.*;
import java.sql.*;
public class AdminModel {
	private boolean flag;
	public  boolean checkLogin(String user,String pass) throws SQLException {
		Connection con=DbConnection.connection();
		Statement sts=con.createStatement();
		String query="Select * from admin";
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
    public boolean insertMentor(String email,String name,String password,String batch) throws SQLException {
    	Connection con=DbConnection.connection();
    	int count=0;
    	String cQuery="Select count(M_ID) from mentor";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(cQuery);
    	while(r1.next())
    		count=r1.getInt(1);
    	String query="Insert into mentor values(?,?,?,?,?)";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setInt(1, (count+1));
    	psd.setString(2,name);
    	psd.setString(3, email);
    	psd.setString(4, password);
    	psd.setString(5, batch);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean updateBatch(String email,String batch) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="update mentor set M_BATCH=? where M_EMAIL=?;";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1, batch);
    	psd.setString(2,email);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean deleteMentor(String email) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="delete  from mentor  where M_EMAIL=?;";
    	PreparedStatement psd=con.prepareStatement(query);
    	
    	psd.setString(1,email);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean addCompany(String name, double mark_10, double mark_12, String lang, String domain, double cgpa, double pack, String dateFixed, String location, String mode) throws SQLException {
    	Connection con=DbConnection.connection();
    	int count=0;
    	String cQuery="Select count(C_ID) from company";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(cQuery);
    	while(r1.next())
    		count=r1.getInt(1);
    	count+=1;
    	String query="INSERT INTO company VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setInt(1, count);
    	psd.setString(2, name);
    	psd.setDouble(3,mark_10);
        psd.setDouble(4, mark_12);
        psd.setString(5,lang);
        psd.setString(6, domain);
        psd.setDouble(7, cgpa);
        psd.setDouble(8, pack);
        psd.setString(9, dateFixed);
        psd.setString(10,location);
        psd.setString(11,mode);
        int res=psd.executeUpdate();
        if(res==1) {
        	flag=true;
        }
        else {
        	flag=false;
        }
        return flag;
    }
    public boolean updateCompany(String name,String dateFixed) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="UPDATE COMPANY SET C_DATEFIXED=? WHERE C_NAME=? ;";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1, dateFixed);
    	psd.setString(2, name);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public boolean deleteCompany(String name) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="DELETE FROM COMPANY WHERE C_NAME=?";
    	PreparedStatement psd=con.prepareStatement(query);
    	psd.setString(1, name);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public ArrayList<String> display(String Ccat,String Scat,String Clang,String Slang,String Ccgpa,String Scgpa,String Cmark10,String Smark10,String Cmark12,String Smark12,String Splace,String Cname) throws SQLException{
    	ArrayList<String > match=new ArrayList<>();
    	Connection con=DbConnection.connection();
    //	String query="SELECT * FROM STUDENT  JOIN COMPANY ON LOWER(STUDENT."+Scat+")"+"=LOWER(COMPANY."+Ccat+")"+"AND LOWER(STUDENT."+Slang+")"+"=LOWER(COMPANY."+Clang+")"+"AND (STUDENT."+Scgpa+")"+">=(COMPANY."+Ccgpa+")"+"AND (STUDENT."+Smark10+")"+">=(COMPANY."+Cmark10+")"+"AND (STUDENT."+Smark12+")"+">=(COMPANY."+Cmark12+")"+"WHERE STUDENT.placed="+Splace+"AND C_NAME="+Cname;
    	//System.out.println(query);
    	String query = "SELECT * FROM STUDENT " +
                "JOIN COMPANY ON LOWER(STUDENT." + Scat + ") = LOWER(COMPANY." + Ccat + ") " +
                "AND LOWER(STUDENT." + Slang + ") = LOWER(COMPANY." + Clang + ") " +
                "AND (STUDENT." + Scgpa + ") >= (COMPANY." + Ccgpa + ") " +
                "AND (STUDENT." + Smark10 + ") >= (COMPANY." + Cmark10 + ") " +
                "AND (STUDENT." + Smark12 + ") >= (COMPANY." + Cmark12 + ") " +
                "WHERE STUDENT.placed = ? AND C_NAME = ?";
                PreparedStatement pstmt = con.prepareStatement(query);
                 pstmt.setString(1, Splace);
                 pstmt.setString(2, Cname);
                ResultSet r = pstmt.executeQuery();

    	//Statement sts=con.createStatement();
    //	ResultSet r=sts.executeQuery(query);
    	String str="";
    	 while(r.next()) {
    		 str=r.getString(2)+"@"+r.getString(3)+"@"+r.getString(4)+"@"+r.getString(5)+"@"+r.getString(6)+"@"+r.getString(7)+"@"+r.getString(12);
    		 match.add(str);
    	 }
    	  return match;
    }
    public ArrayList<String> displayRange() throws SQLException{
    	ArrayList<String > match=new ArrayList<>();
    	Connection con=DbConnection.connection();
    	String query="SELECT STUDENT.*, placement.* FROM STUDENT JOIN placement ON STUDENT.S_ID = placement.P_ID";
    	Statement sts=con.createStatement();
    	ResultSet r=sts.executeQuery(query);
    	String str="";
    	 while(r.next()) {
    		 str=r.getString(2)+"@"+r.getString(3)+"@"+r.getString(4)+"@"+r.getString(5)+"@"+r.getString(6)+"@"+r.getString(7)+"@"+r.getString(12)+"@"+r.getString(15)+"@"+r.getString(16);
 
    	     match.add(str);
    	 }
    	  return match;
    }
    public boolean changePassword(String name,String password) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="UPDATE admin SET A_PASSWORD=? WHERE A_EMAIL=? ;";
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
    public boolean setPlaced(String reg_no,String c_name,String c_package,String c_date) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="SELECT S_ID FROM STUDENT WHERE S_REGNO ="+reg_no;
    	Statement sts=con.createStatement();
    	ResultSet r=sts.executeQuery(query);
    	String p_id="";
    	while(r.next())
    		 p_id=r.getString(1);
    	String q="INSERT INTO PLACEMENT VALUES(?,?,?,?)";
    	PreparedStatement psd=con.prepareStatement(q);
    	psd.setString(1, p_id);
    	psd.setString(2, c_name);
    	psd.setString(3, c_package);
    	psd.setString(4, c_date);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	String q1="update student set placed='1' WHERE S_REGNO="+reg_no;
    	sts.executeUpdate(q1);
    	return flag;
    }
    public boolean updatePackage(String reg_no,String c_package) throws SQLException {
    	Connection con=DbConnection.connection();
    	String query="SELECT S_ID FROM STUDENT WHERE S_REGNO ="+reg_no;
    	Statement sts=con.createStatement();
    	ResultSet r=sts.executeQuery(query);
    	String p_id="";
    	while(r.next())
    		 p_id=r.getString(1);
    	String q="UPDATE PLACEMENT SET C_PACKAGE=? WHERE P_ID=?";
    	PreparedStatement psd=con.prepareStatement(q);
    	psd.setString(1, c_package);
    	psd.setString(2, p_id);
    	int res=psd.executeUpdate();
    	if(res==1)
    		flag=true;
    	else
    		flag=false;
    	return flag;
    }
    public ArrayList<String> displayAll() throws SQLException{
    	ArrayList<String>placed=new ArrayList<>();
    	Connection con=DbConnection.connection();
    	String query="select * from placement";
    	Statement sts=con.createStatement();
    	ResultSet r=sts.executeQuery(query);
    	String p_id="",s="";
    	while(r.next()) {
    		 p_id=r.getString(1);
    		 s+=r.getString(2)+" "+r.getString(3)+" "+r.getString(4);
    	}
    	String q="SELECT S_REGNO,S_NAME,S_DEPARTMENT FROM STUDENT WHERE S_ID="+p_id;
    	ResultSet r1=sts.executeQuery(q);
    	while(r1.next()) {
    		s+=r1.getString(1)+" "+r1.getString(2)+" "+r1.getString(3);
    	}
    	placed.add(s);
    	return placed;
    }
    public int countStud() throws SQLException {
    	Connection con=DbConnection.connection();
    	String q1="SELECT COUNT(S_ID) FROM STUDENT";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(q1);
    	int res=0;
    	while(r1.next())
    		res=r1.getInt(1);
    	return res;
    }
    public int countPlaced() throws SQLException {
    	Connection con=DbConnection.connection();
    	String q1="SELECT COUNT(S_ID) FROM STUDENT where placed='1'";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(q1);
    	int res=0;
    	while(r1.next())
    		res=r1.getInt(1);
    	return res;
    }
    public int countNon() throws SQLException {
    	Connection con=DbConnection.connection();
    	String q1="SELECT COUNT(S_ID) FROM STUDENT where placed is NULL ";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(q1);
    	int res=0;
    	while(r1.next())
    		res=r1.getInt(1);
    	return res;
    }
    public int countCompany() throws SQLException {
    	Connection con=DbConnection.connection();
    	String q1="SELECT COUNT(C_ID) FROM company";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(q1);
    	int res=0;
    	while(r1.next())
    		res=r1.getInt(1);
    	return res;
    }
    public int countMentor()  throws SQLException {
    	Connection con=DbConnection.connection();
    	String q1="SELECT COUNT(M_ID) FROM MENTOR";
    	Statement sts=con.createStatement();
    	ResultSet r1=sts.executeQuery(q1);
    	int res=0;
    	while(r1.next())
    		res=r1.getInt(1);
    	return res;
    }
    
}
