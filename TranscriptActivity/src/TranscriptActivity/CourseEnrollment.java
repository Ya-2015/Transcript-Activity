package TranscriptActivity;
import java.util.Scanner;


public class CourseEnrollment {
	private String code;
	private int credtis;
	private String grade;
	private double points;
	
	public String getCode() {
		return code;
	}
	public void setCode(Scanner sc, String prompt) {
		this.code = Validator.getString(sc, prompt);;
	}
	public int getCredtis() {
		return credtis;
	}
	public void setCredtis(Scanner sc, String prompt) {
		this.credtis = Validator.getInt(sc, prompt);
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(Scanner sc, String prompt) {
		this.grade = Validator.getString(sc, prompt).toUpperCase();
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
	
	

}
