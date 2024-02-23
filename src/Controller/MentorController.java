package Controller;
import java.sql.SQLException;
import java.util.*;
import Model.MentorModel;
public class MentorController {
	MentorModel mm=new MentorModel();
    public boolean loginMentor(String email,String password) throws SQLException {
    	return mm.loginMentor(email,password);
    }
    public boolean insertStudent(String name,String reg_no,String dept,int p_level,String lang,String domain,String project,double mark_10,double mark_12,double cgpa,String batch) throws SQLException {
    	return mm.insertStudent(name,reg_no,dept,p_level,lang,domain,project,mark_10,mark_12,cgpa,batch);
    }
    public boolean updateBatch(String regno,String batch  ) throws SQLException {
    	return mm.updateBatch(regno,batch);
    }
    public boolean updatePortal(String regno,String level  ) throws SQLException {
    	return mm.updatePortal(regno,level);
    }
    public boolean updateProject(String regno,String status  ) throws SQLException {
    	return mm.updateProject(regno,status);
    }
    public boolean deleteStudent(String reg_no) throws SQLException {
    	return mm.deleteStudent(reg_no);
    }
    public boolean changePassword(String email,String password) throws SQLException {
    	return mm.changePassword(email, password);
    }
    public ArrayList<String> displayAll(String placed) throws SQLException{
    	return mm.displayAll(placed);
    }
    public ArrayList<String> display(String cat,String val) throws SQLException{
    	return mm.display(cat,val);
    }
    public ArrayList<String> displayRange(String cat,String val) throws SQLException{
    	return mm.displayRange(cat,val);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
