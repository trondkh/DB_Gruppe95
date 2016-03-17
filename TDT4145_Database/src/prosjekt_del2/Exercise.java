package prosjekt_del2;

import java.sql.*;

public class Exercise {
	
	public void save(Connection conn, String[] argsOfExercise)
	{
		if(argsOfExercise.length!=4)
			throw new IllegalArgumentException("save method in exercise needs exactly 4 arguments");
		String updateTable = "INSERT INTO Exercise ";
		updateTable+="(ExerciseID, ExerciseName, Description, ExerciseType)";
		updateTable+= " values ";
		updateTable+= " ( ";
		for(int i=0;i<argsOfExercise.length-1;i++)
		{
			updateTable+=argsOfExercise[i] + ", ";
		}
		updateTable+=argsOfExercise[argsOfExercise.length-1];
		updateTable+=")";
		
		System.out.println(updateTable);
		
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(updateTable);
		} catch (Exception e) {
			System.out.println("db error during insert of Exercise="+e);
			return;
		}
	}

	public void printAllExercises(Connection conn)
	{
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT * FROM Exercise ORDER BY ExerciseID ASC"; // Query til DB
			ResultSet rs = stmt.executeQuery(query); // Henter fra DB
			System.out.println("Exercises: ");
			while (rs.next()){
				System.out.println(" " + "ID: " + rs.getInt("ExerciseID") + " Name: " + rs.getString("ExerciseName") + " Type: " + rs.getString("ExerciseType") + "\n" + 
									" Desc: " + rs.getString("Description"));
			}
		} catch (Exception e){
			System.out.println("db error" + e);
		}
		System.out.println("All Exercises Printed");
	} 
}


