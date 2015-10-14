package TranscriptActivity;
import java.util.Scanner;

public class TranscriptApp {
	public static void main(String[] args) {
		Transcript transcript = new Transcript();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the transcript application.");
		
		do{
			
			CourseEnrollment course = new CourseEnrollment();
			course.setCode(scan, "\nEnter Course: ");
			course.setCredtis(scan, "Enter Credits: ");
			course.setGrade(scan, "Enter Grade: ");
			
			transcript.addCourse(course);
			
		}while(Validator.getString(scan, "Another Course? (y/n): ").equalsIgnoreCase("y"));
		
		System.out.println(String.format("\n%-15s","Course") + "\t" + "Credits" + "\t" + "Grade" + "\t" + "Quality Points");
		System.out.println(String.format("%-15s","-------") + "\t" + "-----" + "\t" + "-----" + "\t" + "-----");
		for (CourseEnrollment c : transcript.getCourse()){
			System.out.println(String.format("%-20s",c.getCode()) + "\t" + c.getCredtis() + "\t" + c.getGrade() + "\t" + c.getPoints());
			
		}
		
		System.out.println("\n\t\t\t\t\tGPA: " + transcript.getFormattedGPA());
		
	}

}
