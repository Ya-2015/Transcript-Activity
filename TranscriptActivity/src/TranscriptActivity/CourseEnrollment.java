package TranscriptActivity;
import java.util.Arrays;
import java.util.Scanner;


public class CourseEnrollment {
	private String code;
	private int credtis;
	private String grade;
	private double points;
	
	private final int CREDIT_MIN = 0;
	private final int CREDIT_MAX = 4;
	public final static String[] VALID_GRADES = {"A","A-","B+","B","B-","C+","C","C-","D+","D","D-","F"};
	
	public String getCode() {
		return code;
	}
	public void setCode(Scanner sc, String prompt) {
		this.code = Validator.getString(sc, prompt);;
	}
	public int getCredtis() {
		return credtis;
	}
	public void setCredtis(Scanner sc, String prompt){
		this.credtis = Validator.getInt(sc, prompt, CREDIT_MIN, CREDIT_MAX);
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(Scanner sc, String prompt) throws CustomException {
		String gd = Validator.getString(sc, prompt).toUpperCase();
		
		if(!Arrays.asList(VALID_GRADES).contains(gd)){
			throw new CustomException("Invalid Grade!!!"); 
		}
		
		this.grade = gd;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}
	
	

}
