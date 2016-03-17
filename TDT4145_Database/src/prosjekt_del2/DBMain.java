package prosjekt_del2;

public class DBMain {

	UserCUI ui;
	Exercise exercise;
	ExerciseSession session;

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
		exercise = new Exercise();
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
			saveExerciseSession();
			break;
		case 2: 
			viewAllSessions();
			break;
		case 3:
			saveExercise();
			break;
		case 4:
			viewExercises();
		default:
			break;
		}
	}
	
	void saveExerciseSession()
	{
		String[] strings = ui.getExerciseSessionSaveArgs();
		System.out.println("Arguments are:");
		for(String s:strings)
			System.out.println(s);
		session.save(databaseHandler.conn, strings);
	}
	
	void viewAllSessions()
	{
		session.printAllSessions(databaseHandler.conn);
	}
	
	void saveExercise()
	{
		String[] strings = ui.getExerciseSaveArgs();
		System.out.println("Arguments are:");
		for(String s:strings)
			System.out.println(s);
		exercise.save(databaseHandler.conn, strings);
	}
	
	void viewExercises()
	{
		exercise.printAllExercises(databaseHandler.conn);
	}
}
