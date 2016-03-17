package prosjekt_del2;
import java.sql.*;

public class ListSessions {
	
	public void printAllSessions(Connection conn){
		
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT TimeStart, Duration, FormScore, PerformanceScore FROM ExerciseSession ORDER BY TimeStart DESC"; // Query til DB
			//System.out.println(query);
			
			ResultSet rs = stmt.executeQuery(query); // Henter fra DB
			System.out.println("Exercise Sessions: ");
			while (rs.next()){
				System.out.println(" " + "DATE: " + rs.getTimestamp("TimeStart") + " " + "DURATION: " + rs.getDouble("Duration") + " " + "FORMSCORE: " +
									rs.getInt("FormScore") + " " + "PERFORMANCE SCORE: " + rs.getInt("PerformanceScore") + " " );
			}
			
	} catch (Exception e){
		System.out.println("db error" + e);
		}
		System.out.println("All Exercise Sessions Printed");
	} 
}