package prosjekt_del2;

public class DBMain {

	ExerciseSession session;
	DBConnect test;

	public static void main(String[] args) {
		DBMain dbm = new DBMain();
		dbm.init();
		dbm.run();
	}
	
	void init()
	{
		test = new DBConnect();
		test.connect();
		session = new ExerciseSession();
	}
	
	void run()
	{
		saveExercise();
	}
	
	void saveExercise()
	{
		session.save(test.conn);
	}
	
	void testStrings()
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
	}
}
