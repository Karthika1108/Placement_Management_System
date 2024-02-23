package Controller;
import java.sql.SQLException;
import java.util.*;

import Model.AdminModel;
public class AdminController {
	AdminModel ad=new AdminModel(); 
	public boolean checkLogin(String email,String password) throws SQLException {
		
		return ad.checkLogin(email,password);
	}
	
    public boolean addMentor(String email,String name,String password,String batch) throws SQLException {
    	
    	return ad.insertMentor(email,name,password,batch);
    }
    
    public boolean changeBatch(String email,String batch) throws SQLException {
    	 return ad.updateBatch(email,batch);
    }
    
    public boolean removeMentor(String email) throws SQLException {
    	return ad.deleteMentor(email);
    }
    public boolean addCompany(String name, double mark_10, double mark_12, String lang, String domain, double cgpa, double pack, String dateFixed, String location, String mode) throws SQLException {
    	return ad.addCompany(name,mark_10,mark_12,lang,domain,cgpa,pack,dateFixed,location,mode);
    }
    public boolean updateCompany(String name,String dateFixed) throws SQLException {
    	return ad.updateCompany(name,dateFixed);
    }
    public boolean deleteCompany(String name) throws SQLException {
    	return ad.deleteCompany(name);
    }
    private boolean changePassword(String email,String password) throws SQLException {
    	return ad.changePassword(email,password);
    }
    public boolean getChangePassword(String email,String password) throws SQLException {
    	return changePassword(email,password);
    }
    public ArrayList<String> display(String Ccat,String Scat,String Clang,String Slang,String Ccgpa,String Scgpa,String Cmark10,String Smark10,String Cmark12,String Smark12,String Splace,String Cname) throws SQLException {
    	return ad.display(Ccat,Scat,Clang,Slang,Ccgpa,Scgpa,Cmark10,Smark10,Cmark12,Smark12,Splace,Cname);
    }
    public ArrayList<String> displayRange() throws SQLException{
    	return ad.displayRange();
    }
    public boolean setPlaced(String reg_no,String c_name,String c_package,String c_date) throws SQLException {
    	return ad.setPlaced(reg_no,c_name,c_package,c_date);
    }
    public boolean updatePackage(String reg_no,String c_package) throws SQLException {
    	return ad.updatePackage(reg_no,c_package);
    }
    public ArrayList<String> displayAll() throws SQLException{
    	return ad.displayAll();
    }
    public int countStud() throws SQLException {
    	return ad.countStud();
    }
    public int countPlaced() throws SQLException {
    	return ad.countPlaced();
    }
    public int countNon() throws SQLException {
    	return ad.countNon();
    }
    public int countMentor() throws SQLException {
    	return ad.countMentor();
    }
    public int countCompany() throws SQLException {
    	return ad.countCompany();
    }
}
