package TranscriptActivity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Properties;

public class TranscriptDB {
	ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
	//URL of Oracle database server
	String url = "jdbc:oracle:thin:system/password@localhost";
	//properties for creating connection to Oracle database
    Properties props = new Properties();
    DBQueries query =new DBQueries();
    private double gpa = 0;
	
	public TranscriptDB(){
        props.setProperty("user", "testuserdb");
        props.setProperty("password", "password");
	}
	
	public ArrayList<CourseEnrollment> getCourse(){
		return courses;
	}

	public void addCourse(CourseEnrollment course){
		//course.setPoints(getGradeScaledTo4(course.getGrade()));
		//courses.add(course);
		try {
			query.insertEnrollment(course.getCode(), course.getCredtis(), course.getGrade(), url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void calculateGPA() throws SQLException{
		
		double totalPoints = 0;
		double totalCredits = 0;
		
		
		//get courses from DB
		courses = query.getCoursesFromDB(url, props);
		double points = 0;
		for(CourseEnrollment c : courses){
			points = getGradeScaledTo4(c.getGrade());
        	c.setPoints(points);
			totalCredits += c.getCredtis();
			totalPoints += c.getCredtis() * c.getPoints();
		}
		
		gpa = totalPoints / totalCredits;
	}
	
	public String getFormattedGPA(){
		NumberFormat formatter = NumberFormat.getInstance();
		formatter.setMaximumFractionDigits(1);
		
		return formatter.format(gpa);
	}
	
	private double getGradeScaledTo4(String grade){
		double pnt = 0;
		
		switch(grade){
		case "A":
			pnt = 4;
			break;
		case "A-":
			pnt = 3.7;
			break;
		case "B+":
			pnt = 3.33;
			break;
		case "B":
			pnt = 3;
			break;
		case "B-":
			pnt = 2.7;
			break;
		case "C+":
			pnt = 2.3;
			break;
		case "C":
			pnt = 2;
			break;
		case "C-":
			pnt = 1.7;
			break;
		case "D+":
			pnt = 1.3;
			break;
		case "D":
			pnt = 1;
			break;
		case "D-":
			pnt = 0.7;
			break;
		default:
			break;
		}
		
		return pnt;
	}
}
