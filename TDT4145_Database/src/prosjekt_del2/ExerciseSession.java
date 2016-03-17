package prosjekt_del2;

import java.sql.*;

public class ExerciseSession {


	public void save(Connection conn,String[] argsOfSession)
	{
		if(argsOfSession.length!=6)
			throw new IllegalArgumentException("save method in session needs exactly 6 arguments");
		String updateTable = "INSERT INTO ExerciseSession ";
		updateTable+= "(TimeStart, Duration, FormScore, PerformanceScore, Note, PersonID)";
		updateTable+= " values ";
		updateTable+= " ( ";
		for(int i=0;i<argsOfSession.length-1;i++)
		{
			updateTable+=argsOfSession[i] + ", ";
		}
		updateTable+=argsOfSession[argsOfSession.length-1];
		updateTable+=")";
		
		System.out.println(updateTable);
		
		try {    
            Statement stmt = conn.createStatement(); 
            stmt.executeUpdate(updateTable);
        } catch (Exception e) {
            System.out.println("db error during insert of Avtale="+e);
            return;
        }
	}
	
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
