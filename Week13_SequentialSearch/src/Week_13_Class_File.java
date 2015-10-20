/**
 * Author: Dustyne Brown
 * Class Name: Intro To Programming
 * Instructor: Brian McLaughlan
 * Date: 4/12/12
 */

/**
 * Things To Do:
 * Build a program that allows the user to enter names into an array.  
 * Use a DO loop to get names until the user types "done."  
 * Then, display the names.  
 * Then, ask the user to enter a name to search for.  
 * Search for that name in the list.  
 * Tell the user if the name is in the list or not.  
 * Use two custom methods in your code.
 */

import javax.swing.JOptionPane; 

public class Week_13_Class_File {
	public static void main(String[] args) {
		
		//Declare all variables.
		String names, name_search;
		int counter_done=0, result_number=0, x=0, y=0;
		String[] names_array = new String[10000];
		
		
		//Allow the user to enter names until they type done.
		//X keeps track of the number of names entered since the array cannot be predefined. X acts as the marker for my last index slot.
		do {
			names=JOptionPane.showInputDialog("Please enter a name. \n If you are finished entereing names, type 'done'");
			
			//Checks if the name/word entered is the word "done". If so, it adds to the counter for the while loop.
			if(names.equals("done")){
			counter_done=1;	
			}
			
			//If what was entered is not the word "done" it stores it in a slot, then adds to X, which is acting as both the index and the
			//variable that changes to allow you to enter in different array values.
			else{
				names_array[x]=names;
				x++;
			}
			
			//Continues looping until the if statement which is triggered by "done" is activated.
		}while(counter_done!=1);
		
		
		//Calls the display names method, which simply reads all the names entered into the array.
		//Passes the array, my counter X, and my other counter Y
		displaynames(names_array, x, y);
		
		
		//Asks for the name to search for.
		name_search=JOptionPane.showInputDialog("Please enter the name you would like to search for.");
		
		
		//Calls the search name method, used to check for the requested name in the array.
		//Passes the array, the name it's searching for, the counter for number of times the name was found, and my X & Y counters.
		searchnames(names_array,name_search, result_number, x, y);
	}

	public static void displaynames(String[] names_array, int x, int y) {
		//Continues looping until y becomes equal to my index x.
		while(y<x)
		{
		JOptionPane.showMessageDialog(null, "Name number " + (y+1) + " is " +names_array[y] + ".");
		y++;
		}
	}
	
	public static void searchnames(String[] names_array, String name_search, int result_number, int x, int y) {
		//Loops until y becomes equal to x.
			while(y<x)
			{
				if(names_array[y].equals(name_search))
				{
					result_number++;
				}
				y++;
				System.out.println("test");
			}
		
		//Had to make if, else if, else so the grammar is correct for my results.
		if(result_number==0)
		{
			JOptionPane.showMessageDialog(null, "The name you searched for was not found.");
		}
		
		else if(result_number>0)
		{
			JOptionPane.showMessageDialog(null, "The name you searched for was found " + result_number + "times.");
		}
		
		else if (result_number==1)
		{
			JOptionPane.showMessageDialog(null, "The name you searched for was found " + result_number + "time.");
		}
		
		else
		{
			JOptionPane.showMessageDialog(null,  "You broke something... Good job...");
		}
	}
}

	
		
