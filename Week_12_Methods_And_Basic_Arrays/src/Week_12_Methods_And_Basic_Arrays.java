/**
 * Author: Dustyne Brown
 * Class Name: Intro To Programming
 * Instructor: Brian McLaughlan
 * Date: 4/7/12
 */

/**
 * Ask the user how many grades they would like to enter.  Allow them to enter a number from 1 to 20.  
 * Use input validation to make sure they only enter a valid number.
 * Allow the user to enter that many grades.  Make sure they are from 0 to 100.  Store them in an array.
 * Find the average of the grades.  Display it for the user.
 * Determine how many grades are above the average.  Display for the user.
 * Determine how many grades are below the average.  Display that too.
 * Determine the highest and lowest grades.  Display them.
 * Use at least one custom method in your program.
 */

import java.util.Arrays;
import javax.swing.JOptionPane; 

public class Week_12_Methods_And_Basic_Arrays {
	public static void main(String[] args) {
		/**
		 * Declare variables.
		 */
		int gradenum, x, array_entry;
		
		int[] grades;
		
		String gradenum_catch, array_catch;
		
		/**
		 * Ask for the number of grades to be entered.
		 */
		gradenum_catch=JOptionPane.showInputDialog(null, "How many grades would you like to enter? \n You can only enter up to 20.");
		
		/**
		 * Convert string entered to an int.
		 */
		gradenum=Integer.parseInt(gradenum_catch);
		
		/**
		 * Validate that the number entered is between 0 and 20.
		 */
		while(gradenum<0 || gradenum>20)
			{
				gradenum_catch=JOptionPane.showInputDialog(null, "I'm sorry, but the number you entered is invalid. " +
																	"\nPlease enter a number between 0 and 20,");
				gradenum=Integer.parseInt(gradenum_catch);
			}
		
		
		
		
		/**
		 * Create array sizing.
		 */
		grades=new int[gradenum];
		
		/**
		 * Use the accounted number of grades to create the array size.
		 */
		gradenum--;
		int gradenumbers=1;
		x=0;
		for(int y=0; y<=gradenum;)
			{
			
			array_entry=0;
			array_catch=JOptionPane.showInputDialog(null, "Please enter grade number: " + gradenumbers);
			array_entry=Integer.parseInt(array_catch);
			
				/**
				 * Validate grade entry.
				 */
				while(array_entry<0 || array_entry>100){
					array_catch=JOptionPane.showInputDialog(null, "I'm sorry, the number you entered is invalid." +
									"\nPlease enter a grade between or equal to 0 or 100.");
					array_entry=Integer.parseInt(array_catch);
					}
					
			grades[x]=array_entry;
			//System.out.println("Value" + grades[x]);
			//System.out.println("Slot number" + x);
			//System.out.println("Count number" +y);
			x++;
			y++;
			gradenumbers++;
			}
		
		x=0;
		int loop_counter_average=0;
		int average_calc=0;
		while (loop_counter_average<gradenum+1)
			{
			average_calc=grades[x]+average_calc;
			//System.out.println("Current totalled" + average_calc);
			//System.out.println("test"+loop_counter_average);
			loop_counter_average++;
			x++;
			}
		
		average_calc=average_calc/x;
		JOptionPane.showMessageDialog(null,"The class average is "+ average_calc + "%.");
		
		/**
		 * Calculate the above average method calling!
		 */
		displayaboveaverage(average_calc, grades, gradenum);
		displaybelowaverage(average_calc, grades, gradenum);
		displaymaxandmin(grades);
		System.exit(0);
	}

	
	public static void displayaboveaverage(int average_calc, int grades[], int gradenum){
		//System.out.println(gradenum+1); //(TEST)
		int grades_above_ave=0;
		int x=0;
		for(int y=0; y<gradenum+1;)
			{
				if(grades[x]>average_calc)
					{
					grades_above_ave++;
					}
				//System.out.println("test");
				y++;
				x++;
			}
		if(grades_above_ave>=2)
			{
			JOptionPane.showMessageDialog(null,"There are " + grades_above_ave + " grades above the average.");
			}
		else if(grades_above_ave==1)
			{
			JOptionPane.showMessageDialog(null,"There is " + grades_above_ave + " grade above the average.");
			}
		else
			{
			JOptionPane.showMessageDialog(null,"There are no grades above the average.");
			}
		
	}
	
	public static void displaybelowaverage(int average_calc, int grades[], int gradenum){
		int grades_below_ave=0;
		int x=0;
		for(int y=0; y<gradenum+1;)
			{
				if(grades[x]<average_calc)
					{
					grades_below_ave++;
					}
				//System.out.println("test");
				y++;
				x++;
			}
		if(grades_below_ave>=2)
			{
			JOptionPane.showMessageDialog(null,"There are " + grades_below_ave + " grades below the average.");
			}
		else if(grades_below_ave==1)
			{
			JOptionPane.showMessageDialog(null,"There is " + grades_below_ave + " grade below the average.");
			}
		else
			{
			JOptionPane.showMessageDialog(null,"There are no below above the average.");
			}
	}
	
	public static void displaymaxandmin(int grades[]){  
		Arrays.sort(grades);  
		JOptionPane.showMessageDialog(null,"The lowest grade in the class is " + grades[0] + "%.");  
		JOptionPane.showMessageDialog(null,"The highest grade in the class is " + grades[grades.length-1] + "%."); 
	}

}
