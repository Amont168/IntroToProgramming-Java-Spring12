/**
 * Author: Dustyne Brown
 * Class Name: Intro To Programming
 * Instructor: Brian McLaughlan
 * Date: 3/22/12
 */

/**
 * Things to do.
 * 1. Ask the user for a file name.
 * 2. Open the requested file.
 * 3. Read the data from the file and display it.(Use the WHILE loop)
 * 4. Close the file.
 * 5. Open the same file, but appended mode.
 * 6. Generate a random number from 3 to 8.
 * 7. Ask the user to enter than many new words.
 * 8. save them to the file as the user enters them.
 * 9. Close the file again.
 */

//Gather required imports.
import java.io.*; //Java file writing utilities
import java.util.Scanner; //import scanner
import javax.swing.JOptionPane; //J Option Panes
import java.util.Random; //Import the class to create random numbers

public class Week_10_Files_And_Random_Numbers {
	public static void main(String[] args) throws IOException {
		/**Declare all variables*/
		String filename;
		String name;
		int number1;
		
		/**Ask for file name*/
		filename=JOptionPane.showInputDialog("Enter the name of the file you wish to open.");
		
		/**Create a file variable named file based off the entered filename*/
		File file= new File(filename);
		
		/**Create a scanner named inputFile to scan the text in the file entered by the user*/
		Scanner inputFile = new Scanner(file);
		
		/**Create a while loop to read each line in the requested file.*/
		while (inputFile.hasNext())
			{
			/**create a string that is set to each line as the while loop repeats*/
			String fileLine = inputFile.nextLine();
			
			/**Print the string*/
			System.out.println(fileLine);
			}
		/**Close the file!*/
		inputFile.close();
		
		/**Open the filename in an appending mode, and create a filewriter for it*/
		FileWriter fwriter = new FileWriter(filename, true);
		
		/**Create a Print Writer to write to the filename requested*/
		PrintWriter outputFile = new PrintWriter(fwriter);
		
		/**Create a random numbers class*/
		Random randomNumbers = new Random();
		
		/**Generate a random number between 3 and 8*/
		number1 = randomNumbers.nextInt(5) + 3;
		
		//Was doing output tests, this is trash, keeping in case later tested is needed. !--outputFile.println(random);--!
		
		/**Let the user know how many names I'd like them to enter.*/
		JOptionPane.showMessageDialog(null, "Now I'd like you to enter " + number1 + " names to add to the list please.");
		
		/**Only added this because it was putting the first thing you inputted against the last name in the file, and I wanted it on a new line*/
		outputFile.println("");
		
		/**Ask for the names a random amount of times (Number of times was pre-defined by the random class)*/
		for(int count=number1; count>0; count--)
			{
			/**Ask for the name during each execution*/
			name=JOptionPane.showInputDialog("Please enter a name to add to the list here.");
			/**Add the name to the file for each execution*/
			outputFile.println(name);
			
			}
		/**Closes the file being appended*/
		outputFile.close();
		
		//Just testing, keeping the line intact however, for documentation. !--System.out.println(number1);--!
		

	}

}