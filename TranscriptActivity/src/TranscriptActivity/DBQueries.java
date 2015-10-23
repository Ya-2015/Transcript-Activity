package TranscriptActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

public class DBQueries {
	
	public boolean insertEnrollment(String code,int credit, String grade,String url,Properties props) throws SQLException{
		String sql ="insert into Enrollment (code,credit,grade) values (?,?,?)";
        boolean isSuccess = false;
//        return updateDatabase(sql, url, props);
        try{
        
		//creating connection to Oracle database using JDBC
        Connection conn = DriverManager.getConnection(url,props);
        
        //System.out.println(sql);
        //creating PreparedStatement object to execute query
        PreparedStatement preStatement = conn.prepareStatement(sql);
        preStatement.setString(1, code);
        preStatement.setInt(2, credit);
        preStatement.setString(3, grade);
        int result = preStatement.executeUpdate();
        conn.close();
        
        if (result != 0){
        	isSuccess = true;
        }
        }catch(Exception e){
        	isSuccess = false;
        }
        
        return isSuccess;
	}
	

	public ArrayList<CourseEnrollment> getCoursesFromDB(String url,Properties props) throws SQLException{
		ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
		
		try{
			//creating connection to Oracle database using JDBC
	        Connection conn = DriverManager.getConnection(url,props);
	        
	        //*********************//
	        String sql ="select * from Enrollment";

	        //creating PreparedStatement object to execute query
	        PreparedStatement preStatement = conn.prepareStatement(sql);
	        ResultSet result = preStatement.executeQuery();
	      
	        while(result.next()){
	        	String code = result.getString(1);
	        	int credit = result.getInt(2);
	        	String grade = result.getString(3);
	        	CourseEnrollment enroll = new CourseEnrollment();
	        	enroll.setCode(code);
	        	enroll.setGrade(grade);
	        	enroll.setCredits(credit);
	        	courses.add(enroll);
	  
	        }
	        
	        conn.close();
	    }catch(Exception e){
	    		courses = null;
	        	System.out.println(e.getMessage());
	    }
		
		return courses;
	}

}
