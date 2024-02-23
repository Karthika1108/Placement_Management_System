package View;
import java.sql.SQLException;
import java.util.*;
public class PlacementManagement {
	public static void main(String[] args) throws SQLException {
	Scanner cs=new Scanner(System.in);
    int option=1;
    while(option!=3) {
    	 System.out.println("-----------------------------------------------");
    	 System.out.println("1--->LOGIN ADMIN\n2--->LOGIN MENTOR\n3--->EXIT");
    	 System.out.println("-----------------------------------------------");
    	 option=cs.nextInt();
    	 switch(option) {
    	 case 1:{
    		 AdminView av=new AdminView();
    		 av.checkAdmin();
    		 break;
    	 }
    	 case 2:{
    		 MentorView mv=new MentorView();
    		 mv.checkMentor();
    		 break;
    	 }
    	 case 3:{
    		 System.out.println("--------------------THANK YOU------------------");
    		 System.exit(3);
    	 }
    	 }
      }
    //cs.close();
	}
}
