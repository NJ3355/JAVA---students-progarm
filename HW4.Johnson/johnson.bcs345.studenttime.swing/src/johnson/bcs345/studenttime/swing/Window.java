//****************************************************
// File: Window.java  
//
// Purpose: Definitions for the Window class
//
// Written By: Nick Johnson 
//
// Date: 5/5/2014
//
// Update Information
// ------------------

package johnson.bcs345.studenttime.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.Scanner;

import javax.swing.*;

import johnson.bcs345.studenttime.student.Student;
import johnson.bcs345.studenttime.activity.*;

public class Window extends JFrame implements ActionListener {
	
	//all the member variables to set up the swing etc..
	
	private Student myStudent;
	private JTabbedPane tabPane;
	private JPanel panel1;
	private JPanel panel2;
	
	private JLabel labelFirst, labelLast, labelCredits, labelList, labelType, labelHours, labelMinutes;
	private JTextField sFirstName, sLastName, sCredits, aHours, aMinutes; 
	private JList<String> studentList;
	private JComboBox<String> activityCombo;
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem item, item2, item3;
	
	private JFileChooser file;
	private JButton addActivityButton;
	private DefaultListModel<String> listModel = new DefaultListModel<>();
	
	
	//****************************************************
	// Method: public Window()
	//
	// Purpose: Default constructor
	//****************************************************
	public Window()
	{
		myStudent = new Student();
		
		//sets title and windowsize 
		setSize(500, 500);
		setTitle("BCS 345 - Nick Johnson - Student Activity Data");
		
		
		//use to select files
		file = new JFileChooser();
		
		//creating the menu bar with file, save, exit
		//adds the menu items and and action listener also
		menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		menu = new JMenu("File");
		
		
		item = new JMenuItem("Open");
		item.addActionListener(this);
		
		item2 = new JMenuItem("Save");
		item2.addActionListener(this);
		
		item3 = new JMenuItem("Exit");
		item3.addActionListener(this);
		
		menu.add(item);
		menu.add(item2);
		menu.add(item3);
		
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
		
		
		
		
		//creates two panels to hold student info and to create a new activity
		panel1 = new JPanel();
		panel1.setLayout(new GridLayout(4,1));
		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(4,1));
		
		//creates panel tabs
		tabPane = new JTabbedPane();
		tabPane.addTab("Student Info", panel1);
		tabPane.addTab("New Activity", panel2);
		add(tabPane);
		
		//all labeling for panel1
		panel1.add(labelFirst = new JLabel("First name"));
		panel1.add(sFirstName = new JTextField(""));
		panel1.add(labelLast = new JLabel("Last name"));
		panel1.add(sLastName = new JTextField(""));
		panel1.add(labelCredits = new JLabel("Credits"));
		panel1.add(sCredits = new JTextField(""));
		panel1.add(labelList = new JLabel("Activities"));
		
		
	
		panel1.add(studentList = new JList<String>(listModel));
		
		
		//labeling for panel2
		panel2.add(labelType = new JLabel("Type"));
		panel2.add(activityCombo = new JComboBox<String>());
		panel2.add(labelHours = new JLabel("Hours"));
		panel2.add(aHours = new JTextField(""));
		panel2.add(labelMinutes = new JLabel("Minutes"));
		panel2.add(aMinutes = new JTextField(""));
		panel2.add(addActivityButton = new JButton("Add"));
		
		//adding the enum combo box
		activityCombo.addItem("STUDY");
		activityCombo.addItem("SLEEP");
		activityCombo.addItem("WORK");
		activityCombo.addItem("RELAX");
		activityCombo.addItem("OTHER");
		
		
		activityCombo.addActionListener(this);
		addActivityButton.addActionListener(this);
		

	}



	//****************************************************
	// Method: public void actionPerformed(ActionEvent e)
	//
	// Purpose: does all the events when clicking on the swing program
	//****************************************************
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		//runs when clicking open
		if(e.getSource() == item)
		{
			//empties the jlist
			studentList.removeAll();
			file.showOpenDialog(null);
			
			
			Scanner inputScanner = null;
			
			
			
			//selects file
			try {
				inputScanner = new Scanner(new FileReader(file.getSelectedFile()));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//reads file
			myStudent.Read(inputScanner);
			
			//sets the jframe variables
			sFirstName.setText(myStudent.getFirstName());
			sLastName.setText(myStudent.getLastName());
			sCredits.setText(Integer.toString(myStudent.getCredits()));
			
			//loop to add items into jlist
			for(int i = 0; i < myStudent.GetActivityCount(); i++)
			{
				String enumS, hourS, minuteS, full;
				Activity a = new Activity();
				
				a = myStudent.GetActivity(i);
				
				enumS = a.getType().name();
				hourS = Integer.toString(a.getTime().getHours());
				minuteS = Integer.toString(a.getTime().getMinutes());
				full = enumS + "," + hourS + "," + minuteS;
				
				listModel.addElement(full);
				
			}
			
				myStudent.Show();	
			
		} 
		//runs when clicking save
		else if(e.getSource() == item2)
		{
			
			  //System.out.println("firstname:" + myStudent.getFirstName());
			
				file.showSaveDialog(null);
				
				
				
				//selects file you want to print to
				PrintStream outputStudent = null;
				try {
					outputStudent = new PrintStream(file.getSelectedFile());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				//writes to file
				
				myStudent.Write(outputStudent);
				
		} 
		//exits program
		else if(e.getSource() == item3)
		{
			System.exit(0);
		}
		//used to add an activity
		else if(e.getSource() == addActivityButton)
		{
			//local variables
			String type;
			String enumS, hourS, minuteS, full;
			Activity a = new Activity();
			
		
			
			
			
			//selects new enum type
			type = (String) activityCombo.getSelectedItem();
			a.setType(ActivityEnum.valueOf(type));
			
			
			TimeSpent time = new TimeSpent();
			
			//sets hours and minutes
			time.setHours(Integer.parseInt(aHours.getText()));
			time.setMinutes(Integer.parseInt(aMinutes.getText()));
			
			a.setTime(time);
			
			
			//adds the activity
			myStudent.addActivity(a);
			
			
			
			enumS = a.getType().name();
			hourS = Integer.toString(a.getTime().getHours());
			minuteS = Integer.toString(a.getTime().getMinutes());
			full = enumS + "," + hourS + "," + minuteS;
			//adds to jlist
			listModel.addElement(full);
			
	
		}
		
		
		
		
		
	}
	
}
