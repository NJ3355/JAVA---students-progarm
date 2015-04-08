//****************************************************
// File: TimeSpent.java  
//
// Purpose: Definitions for the TimeSpent class
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

public class TimeSpent {
	
	//member variables
	private int Hours;
	private int Minutes;
	
	
	
	//****************************************************
	// Method: public TimeSpent()
	//
	// Purpose: Default constructor
	//****************************************************

	public TimeSpent()
	{
		Hours = 0;
		Minutes = 0;
	}

	//****************************************************
		// Method: public TimeSpent(int newHours, int newMinutes )
		//
		// Purpose: Constructor that takes two parameters
		//****************************************************
	public TimeSpent(int newHours, int newMinutes)
	{
		Hours = newHours;
		Minutes = newMinutes;
	}
	
	//****************************************************
		// Method: public void setHours(int newHours)
		//
		// Purpose: set method for Hours
		//****************************************************
	public void setHours(int newHours)
	{
		Hours = newHours;
	}
	
	
	//****************************************************
		// Method: public void setMinutes(int newMinutes)
		//
		// Purpose: set method for minutes
		//****************************************************
	public void setMinutes(int newMinutes)
	{
		Minutes = newMinutes;
	}
	
	//****************************************************
		// Method: public int getHours()
		//
		// Purpose: get method for Hours
		//****************************************************
	public int getHours()
	{
		return Hours;
	}
	
	//****************************************************
		// Method: public int getMinutes()
		//
		// get method for minutes
		//****************************************************
	public int getMinutes()
	{
		return Minutes;
	}
	
	//****************************************************
		// Method: public void Add(TimeSpent other)
		//
		// Purpose: Adds Hours and Minutes of two separate instances
		//****************************************************
	public void Add(TimeSpent other)
	{
		
		Hours = Hours + other.Hours; 
		Minutes = Minutes + other.Minutes;
		
		if(Minutes > 59)
		{
			Minutes = Minutes % 60;
			Hours = Hours + 1;
		}
		
		if(Minutes < 0)
		{
			System.out.printf("Minutes can't be less than 0\n");
		}
	}
	
	//****************************************************
		// Method: public void Read(Scanner s)
		//
		// Purpose: Uses Scanner to read data from a text file
		//****************************************************
	public void Read(Scanner s)
	{
//		while(s.hasNextLine())
		//{
			Hours = s.nextInt();
			Minutes = s.nextInt();
		//}
		
		
	}
	
	//****************************************************
		// Method: public void Write(PrintStream ps)
		//
		// Purpose: Uses PrintStream to write data to a text file
		//****************************************************
	public void Write(PrintStream ps)
	{
		ps.printf("%d\n%d\n", Hours, Minutes);
		
		
	}
	
	//****************************************************
		// Method: public void Show()
		//
		// Purpose: used to print data to the console
		//****************************************************
	public void Show()
	{
		System.out.printf("Hours = %d\nMinutes = %d\n", Hours, Minutes);
		
	}
}
