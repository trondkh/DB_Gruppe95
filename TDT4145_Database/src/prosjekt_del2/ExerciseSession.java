package prosjekt_del2;

import java.sql.*;

public class ExerciseSession {


	public void save(Connection conn)
	{
		String[] v = {"'2016:03:01 00:00:00'", "1.5", "5", "5", "'Nothing in particular...'", "1"};
		String updateTable = "INSERT INTO ExerciseSession ";
		updateTable+= "(TimeStart, Duration, FormScore, PerformanceScore, Note, PersonID)";
		updateTable+= " values ";
		updateTable+= " ( ";
		for(int i=0;i<v.length-1;i++)
		{
			updateTable+=v[i] + ", ";
		}
		updateTable+=v[v.length-1];
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
}