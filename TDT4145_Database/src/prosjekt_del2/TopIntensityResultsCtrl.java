
import java.sql.*;

public class TopIntensityResultsCtrl extends DBConn {
	
	public void printExerciseResults (String exerciseName) {
		try {
			Statement stmt = conn.createStatement();
			String query = "SELECT ExerciseLoadValue, Repetitions, Sets FROM IntensityResults WHERE ExerciseID='"+exerciseName+"' ORDER BY ExerciseLoadValue DESC" ; // String for å hente fra DB
			//System.out.println(query)
			
			ResultSet rs = stmt.executeQuery(query); // Henter fra DB
			int nr = 1;
			System.out.println("Resultat for øvelse"+exerciseName);
			while (rs.next()){
				System.out.println(" " + nr++ + " " + rs.getInt("ExerciseID")+ " " + "Vekt: " + rs.getInt("ExerciseLoadValue") + " " + "Sets: " + rs.getInt("Sets")+ " " + "Reps: " + " " + rs.getInt("Repetitions"));
			}
		} catch (Exception e){
			System.out.println("db error" + e);
		}
	}

}
