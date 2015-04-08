//****************************************************
// File: Main.java  
//
// Purpose: Definitions for the student class
//
// Written By: Nick Johnson 
//
// Date: 3/31/2014
//
// Update Information
// ------------------
package johnson.bcs345.studenttime.student;

import java.io.PrintStream;
import java.util.Scanner;






//Imports activity package
import johnson.bcs345.studenttime.activity.*;


public class Student {
	
	//member variables
	private String firstName;
	private String lastName;
	private int credits;
	private Activity[] activities;
	
	
	//constructor
	
	//****************************************************
	// Method: public Student()
	//
	// Purpose: Default constructor
	//****************************************************
	public Student()
	{
		firstName = "";
		lastName = "";
		credits = 0;
		activities = new Activity[0];
	}
	
	//methods
	
	
	//set methods
	
	//****************************************************
	// Method: public void setFirstName(String newFirst)
	//
	// Purpose: sets first name
	//****************************************************
	public void setFirstName(String newFirst)
	{
		firstName = newFirst;
	}
	
	
	//****************************************************
	// Method: public void setLastName(String newLast)
	//
	// Purpose: sets last name
	//****************************************************
	public void setLastName(String newLast)
	{
		lastName = newLast;
	}
	
	//****************************************************
	// Method: public void setCredits(int newCredits)
	//
	// Purpose: sets credits
	//****************************************************
	public void setCredits(int newCredits)
	{
		credits = newCredits;
	}
	
	//get methods
	
	//****************************************************
	// Method: public String getFirstName()
	//
	// Purpose: returns first name
	//****************************************************
	public String getFirstName()
	{
		return firstName;
	}
	
	//****************************************************
	// Method: public string getLastName
	//
	// Purpose: returns last name
	//****************************************************
	public String getLastName()
	{
		return lastName;
	}
	
	//****************************************************
	// Method: public int getCredits()
	//
	// Purpose: returns credits
	//****************************************************
	public int getCredits()
	{
		return credits;
	}
	
	//****************************************************
	// Method: public void addActivity(Activity A)
	//
	// Purpose: adds another activity to the array
	//****************************************************
	public void addActivity(Activity A)
	{
		//sets values to the A activity
//		Scanner input = new Scanner(System.in);
//		System.out.println("Enter Activity");
//		A.setType(ActivityEnum.valueOf(input.next()));
//		
//		System.out.println("Enter hours");
//		TimeSpent time = new TimeSpent();
//		time.setHours(input.nextInt());
//		
//		System.out.println("Enter minutes");
//		time.setMinutes(input.nextInt());
//		A.setTime(time);
		
		
		//loops to copy array into a bigger array 
		Activity[] newArray = new Activity[activities.length + 1];
		for(int i = 0; i < activities.length; i++)
			{
				newArray[i] = new Activity();
				newArray[i] = activities[i];
			
			}
		
		
		newArray[newArray.length - 1] = A;
		activities = newArray;
		 
		
		/*activities = new Activity [newArray.length];
		for(int i = 0; i < newArray.length; i++)
			{
			activities[i] = new Activity();
			activities[i] = newArray[i];
			
			
			}*/
	
		
		
		
	}
	
	//****************************************************
	// Method: public void Read(Scanner s)
	//
	// Purpose: reads data from file
	//****************************************************
	public void Read(Scanner s)
	{
		
		
		//reading in values from text files
		while (s.hasNext()) {
		firstName = s.next();
		lastName = s.next();
		credits = s.nextInt();
		int count = s.nextInt();
		
		activities = new Activity[count];
		
		for(int i = 0; i < count; i++)
			{
				
				activities[i] = new Activity();
				activities[i].setType(ActivityEnum.valueOf(s.next()));
				
				TimeSpent time = new TimeSpent();
				time.Read(s);
		
				activities[i].setTime(time);
				
								
			}
			

		}

	}
	
	//****************************************************
	// Method: public void Write(PrintStream ps)
	//
	// Purpose: writes data to a file
	//****************************************************
	public void Write(PrintStream ps)
	{
		ps.printf("%s\n%s\n%d\n%d\n", firstName, lastName, credits, activities.length );
		for(int i = 0; i < activities.length; i++)
		{
	
		
		ps.printf("%s\n%d\n%d\n", activities[i].getType(), activities[i].getTime().getHours()
					, activities[i].getTime().getMinutes());
		}
		
	}
	
	//****************************************************
	// Method: public void Show()
	//
	// Purpose: Shows all the data on console
	//****************************************************
	public void Show()
	{
		System.out.printf("First Name = %s\nLast Name = %s\nCredits = %d\nCount = %d\n", firstName, lastName, credits, activities.length);
		for(int i = 0; i < activities.length; i++)
		{
	
			System.out.printf("Activity = %s\nHours = %d\nMinutes = %d\n", activities[i].getType(), activities[i].getTime().getHours(), activities[i].getTime().getMinutes());
		}
	}
	
	//****************************************************
	// Method: public Activity GetActivity(int index)
	//
	// Purpose: returns activities array at a given index
	//****************************************************
	public Activity GetActivity(int index)
	{
		
		
		return activities[index];
	}
	
	//****************************************************
	// Method: public int GetActivityCount()
	//
	// Purpose: returns the current count of the array
	//****************************************************
	public int GetActivityCount()
	{
		int i = 0;
		int count1 = 0;
		
		while(i < activities.length)
		{
			i++;
			count1++;
		}
		
		return count1;
	}
	
	//****************************************************
	// Method: public void Clear()
	//
	// Purpose: clears all the data 
	//****************************************************
	public void Clear()
	{
		firstName = "";
		lastName = "";
		credits = 0;
		for(int i = 0; i < activities.length; i++ )
		{
			activities[i] = null;
			
		}
	}
	
}

