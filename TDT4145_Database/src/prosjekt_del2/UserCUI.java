package prosjekt_del2;

import java.util.Scanner;

/*
 *  User Consol User Interface
 */
public class UserCUI {

	private Scanner scanner;
	private int minNumber;
	private int maxNumber;
	public UserCUI()
	{
		scanner = new Scanner(System.in);
		minNumber = 0;
		maxNumber = 2;
	}
	
	public void showMenu()
	{
		String menuTitle = "Choose an option:";
		String menu0 = "1. Create a traning session";
		String menu1 = "2. Get traning sessions";
		String menuExit = "0. Exit";

		System.out.println(menuTitle);
		System.out.println(menu0);
		System.out.println(menu1);
		System.out.println(menuExit);
	}
	
	public int getOption()
	{
		int option = -1;
		try{
			do{
				option = scanner.nextInt();
				if(!numberIsValid(option))
				{
					System.out.println("Invalid number, try again");
				}
			} while(!numberIsValid(option));
		}
		catch(Exception e)
		{
			System.out.println("Wrong input from user");
		}
		return option;
	}
	
	public String[] getExerciseSessionSaveArgs()
	{
		scanner.nextLine();
		System.out.println("Input arguments for the ExcersiseSession:");
		System.out.println("StartTime: <'2016:03:01 00:00:00'>");
		String startTime = scanner.nextLine();
		System.out.println("Duration in hours:");
		String durationTime = scanner.nextLine();
		System.out.println("Form score:");
		String formScore = scanner.nextLine();
		System.out.println("Performance score:");
		String performanceScore = scanner.nextLine();
		System.out.println("Personal note:");
		String note = scanner.nextLine();
		note = "'" + note + "'";
		String personId = "1";
		return new String[]{startTime,durationTime,formScore,performanceScore,note,personId};
	}
	
	private boolean numberIsValid(int num)
	{
		return num>=minNumber && num<=maxNumber;
	}
	
	public void close()
	{
		scanner.close();
	}
}
