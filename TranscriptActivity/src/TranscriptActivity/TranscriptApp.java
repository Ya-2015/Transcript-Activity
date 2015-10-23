package TranscriptActivity;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class TranscriptApp {
	public static void main(String[] args) throws SQLException {
		TranscriptDB transcript = new TranscriptDB();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to the transcript application.");
		
		do{
			
			CourseEnrollment course = new CourseEnrollment();
			course.setCode(scan, "\nEnter Course: ");
			course.setCredtis(scan, "Enter Credits: ");
			
			boolean flag;
			do{
				flag = false;
				try{
					course.setGrade(scan, "Enter Grade: ");
					flag = true;
				}catch(CustomException e){
					System.out.println(e.getMessage());
				}catch(Exception e){
					e.printStackTrace();
				}finally{
					System.out.println("Valide Grades: "+Arrays.deepToString(CourseEnrollment.VALID_GRADES));
				}
			}while(!flag);
			
			transcript.addCourse(course);
			
		}while(Validator.getString(scan, "Another Course? (y/n): ").equalsIgnoreCase("y"));
		
		//calculate GPA
		transcript.calculateGPA();
		
		System.out.println(String.format("\n%-15s","Course") + "\t" + "Credits" + "\t" + "Grade" + "\t" + "Quality Points");
		System.out.println(String.format("%-15s","-------") + "\t" + "-----" + "\t" + "-----" + "\t" + "-----");
		for (CourseEnrollment c : transcript.getCourse()){
			System.out.println(String.format("%-15s",c.getCode()) + "\t" + c.getCredtis() + "\t" + c.getGrade() + "\t" + c.getPoints());
			
		}
		
		System.out.println("\n\t\t\t\t\tGPA: " + transcript.getFormattedGPA());
		
	}

}
