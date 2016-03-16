
import java.sql.*;
import java.util.Scanner;


public class CreateSession extends DBConn {
	
	public void CreateSession(){
		try {
			Statement stmt = conn.createStatement();
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter YYYY-MM-DD HH:MM:SS");
			Timestamp TimeStart = Timestamp.valueOf(scan.next());
			System.out.println("Duration: ");
			double Duration = Double.parseDouble((scan.next()));
			System.out.println("Form Score(1-10): ");
			int FormScore = Integer.parseInt(scan.next());
			System.out.println("Performance Score(1-10): ");
			int PerformanceScore = Integer.parseInt(scan.next());
			System.out.println("Note: ");
			String Note = scan.next();
			System.out.println("Person ID: ");
			int PersonID = Integer.parseInt(scan.next());
			stmt.executeUpdate("INSERT INTO ExerciseSession " + "VALUES ("+TimeStart+", "+Duration+", "+FormScore+", "+PerformanceScore+", "+Note+", "+PersonID+")");
		} catch (Exception e){
			System.out.println("db error" + e);
		}
		System.out.println("Exercise Session Saved");
	}
}
