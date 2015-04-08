//****************************************************
// File: Activity.java  
//
// Purpose: Definitions for the Activity class
//
// Written By: Nick Johnson 
//
// Date: 3/4/2014
//
// Update Information
// ------------------

package johnson.bcs345.studenttime.activity;

import java.io.PrintStream;
import java.util.Scanner;

public class Activity {
	//member variables
	private ActivityEnum Type;
	private TimeSpent Time;
	
	//****************************************************
		// Method: public Activity()
		//
		// Purpose: Default constructor
		//****************************************************
	public Activity()
	{
		Type = ActivityEnum.OTHER;
		Time = new TimeSpent();
		
		
	}
	
	//****************************************************
		// Method: public Activity(ActivityEnum newType, TimeSpent newTime)
		//
		// Purpose: Constructor that takes two parameters
		//****************************************************
	public Activity(ActivityEnum newType, TimeSpent newTime)
	{
		Type = newType;
		Time = newTime;
		
	}
	
	//****************************************************
		// Method: public void setType(ActivityEnum newType)
		//
		// Purpose: set method for the Type variable
		//****************************************************
	public void setType(ActivityEnum newType)
	{
		Type = newType;
	}
	
	//****************************************************
		// Method: public void setTime(TimeSpent newTime)
		//
		// Purpose: set method for the Time object
		//****************************************************
	public void setTime(TimeSpent newTime)
	{
		
		
		Time = newTime;
	}

	//****************************************************
		// Method: ActivityEnum getType()
		//
		// Purpose: get method for the Type variable
		//****************************************************
	public ActivityEnum getType()
	{
		return Type;
	}
	
	//****************************************************
		// Method: public TimeSpent getTime()
		//
		// Purpose: get method for the Time object
		//****************************************************
	public TimeSpent getTime()
	{
		return Time;
	}
	
	//****************************************************
		// Method: public void Write(PrintStream ps)
		//
		// Purpose: Writes the data to a textfile
		//****************************************************
	public void Write(PrintStream ps)
	{
		ps.printf("%s\n%d\n%d\n", Type, Time.getHours(), Time.getMinutes());
	}
	
	//****************************************************
		// Method: public void Read(Scanner s)
		//
		// Purpose: Reads data from a textfile
		//****************************************************
	public void Read(Scanner s)
	{
		
		String enumAsString;
		enumAsString = s.next();
		Type = ActivityEnum.valueOf(enumAsString);
		Time.setHours(s.nextInt());
		Time.setMinutes(s.nextInt());
		
	}
	
	//****************************************************
		// Method: public void Show()
		//
		// Purpose: prints the data to the console
		//****************************************************
	public void Show()
	{
		System.out.printf("Type = %s\nHours = %d\nMinutes = %d\n", Type, Time.getHours(), Time.getMinutes());
	}
}

