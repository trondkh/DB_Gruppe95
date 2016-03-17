package prosjekt_del2;

public class DBMain {

	UserCUI ui;
	ExerciseSession session;
	ListSessions listSessions;

	// This is our connection to the DB. 
	DBConnect databaseHandler;

	public static void main(String[] args) {
		DBMain dbm = new DBMain();
		dbm.init();
		dbm.run();
	}
	
	// All initializations here...
	void init()
	{
		ui = new UserCUI();
		databaseHandler = new DBConnect();
		databaseHandler.connect();
		session = new ExerciseSession();
		listSessions = new ListSessions();
	}
	
	// Main loop
	void run()
	{
		
		int menuOption;
		do{
			ui.showMenu();
			menuOption = ui.getOption();
			callMethod(menuOption);
		} while(menuOption>0);
		ui.close();
	}
	
	void callMethod(int methodNumber)
	{
		switch (methodNumber) {
		case 1:
			saveExercise();
			break;
		case 2: 
			listAllSessions();
			break;
		default:
			break;
		}
	}
	
	void listAllSessions()
	{
		listSessions.printAllSessions(databaseHandler.conn);
	}
	
	void saveExercise()
	{
		String[] strings = ui.getExerciseSessionSaveArgs();
		System.out.println("Arguments are:");
		for(String s:strings)
			System.out.println(s);
		session.save(databaseHandler.conn, strings);
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
