package TranscriptActivity;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Transcript {
	ArrayList<CourseEnrollment> courses = new ArrayList<CourseEnrollment>();
	NumberFormat formatter = NumberFormat.getInstance();
	
	public Transcript(){
		formatter.setMaximumFractionDigits(1);
	}
	
	public ArrayList<CourseEnrollment> getCourse(){
		return courses;
	}

	public void addCourse(CourseEnrollment course){
		course.setPoints(getGradeScaledTo4(course.getGrade()));
		courses.add(course);
		
	}
	
	public double getOverallGPA(){
		double gpa = 0;
		
		double totalPoints = 0;
		double totalCredits = 0;
		for(CourseEnrollment c : courses){
			totalCredits += c.getCredtis();
			totalPoints += c.getCredtis() * c.getPoints();
		}
		
		gpa = totalPoints / totalCredits;
		
		return gpa;
	}
	
	public String getFormattedGPA(){		
		return formatter.format(getOverallGPA());
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
