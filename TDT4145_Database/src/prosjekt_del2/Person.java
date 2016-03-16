
import java.sql.*;

public class Person extends DBConn{
	
	private int PersonID;
	private String Username;
	
	public Person(int PersonID){
		this.PersonID = PersonID;
	}
	
	public int getPersonID(){
		return PersonID;
	}
	
	public void init() {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT Username FROM Person WHERE PersonID="+PersonID);
			while (rs.next()){
				Username = rs.getString("Username");
			}
		} catch (Exception e) {
            System.out.println("db error");
	}
}
}
