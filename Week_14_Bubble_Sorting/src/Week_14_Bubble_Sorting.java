/**
 * Author: Dustyne Brown
 * Class Name: Intro To Programming
 * Instructor: Brian McLaughlan
 * Date: 4/19/12
 */

/**
 * Things to do.
 * Create a program that allows you to create and sort a music collection.
 * Use a two-dimensional array to hold the information.
 * The array should have at least three columns.
 * Examples of information stored could be "name of song", "artist", "album", "length of song", etc.
 * Allow the user to enter up to 20 songs and associated information.  
 * After the user enters the songs, allow the user to choose how they would like the songs to be sorted (by name, by artist, etc).  
 * Sort the array by the chosen column and display the sorted array.
 */
import javax.swing.JOptionPane; 

public class Week_14_Bubble_Sorting {
	public static void main(String[] args) {
		String songTitle, artist, album, sortStyleSelection;
		int counter=0, selectionFail=0;
		String[][] musicalArray = new String[20][3];
		
		
		JOptionPane.showMessageDialog(null, "Please keep in mind, if you are done entering " +
				"information, just the 'Song' entry blank.");
		for(int y=0; y<20; y++)
			{
				songTitle=JOptionPane.showInputDialog("Please enter the title of the song. " +
						"\nPlease use propper casing.(Example. 'Embrace')");
				if(songTitle.matches(""))
					{
						break;
					}//End of If Breaker Loop.
				artist=JOptionPane.showInputDialog("Enter the artist of the song. \nPlease use " +
						"propper casing. (Example. 'Chase & Status')");
				album=JOptionPane.showInputDialog("Enter the album the song appears on. \nPlease " +
						"use propper casing. (Example. 'No More Idols')");
				musicalArray[counter][0]=songTitle;
				musicalArray[counter][1]=artist;
				musicalArray[counter][2]=album;
				counter++;
			}//End of For Loop
		sortStyleSelection=JOptionPane.showInputDialog(null, "How would you like to sort the data? " +
				"\n Please enter 'Title', 'Artist', or 'Album'");
		do
		{
			if(sortStyleSelection.matches("Title"))
				{
					selectionFail=0;
					sorttitle(musicalArray, counter);
				}//End of If
			else if(sortStyleSelection.matches("Artist"))
				{
					selectionFail=0;
					sortartist(musicalArray, counter);
				}//End of Else If 1
			else if(sortStyleSelection.matches("Album"))
				{
					selectionFail=0;
					sortalbum(musicalArray, counter);
				}//End of Else If 2
			else
				{
					selectionFail=1;
					sortStyleSelection=JOptionPane.showInputDialog(null, "I'm sorry, your sorting style was nore entered correctly. Please pick again." +
					"\nPlease pick 'Title', 'Artist', or 'Album'");
				}//End of else
		}while(selectionFail==1);//End of do while loop
		
		for(int y=0; y<counter;)
			{
			System.out.println(musicalArray[y][0] + " " + musicalArray[y][1] + " " + musicalArray[y][2]);
			y++;
			}
	}//End of Main

	
	
	
	public static void sorttitle(String[][] musicalArray, int counter){
		int z=1;
		do
		{
			z=1;
			for(int y=0; y<counter-1;)
			{
				if(musicalArray[y][0].compareTo(musicalArray[y+1][0])>0)
				{
					String tempSwitch=musicalArray[y][0];
					musicalArray[y][0]=musicalArray[y+1][0];
					musicalArray[y+1][0]=tempSwitch;
					tempSwitch=musicalArray[y][1];
					musicalArray[y][1]=musicalArray[y+1][1];
					musicalArray[y+1][1]=tempSwitch;
					tempSwitch=musicalArray[y][2];
					musicalArray[y][2]=musicalArray[y+1][2];
					musicalArray[y+1][2]=tempSwitch;
					z=0;
				}//End If Statement
				y++;
			}//End For Loop
		}while(z==0);
	}//End Sort Title
	
	
	
	public static void sortartist(String[][] musicalArray, int counter){
		int z=1;
		do
		{
			z=1;
			for(int y=0; y<counter-1;)
			{
				if(musicalArray[y][1].compareTo(musicalArray[y+1][1])>0)
					{
						String tempSwitch=musicalArray[y][0];
						musicalArray[y][0]=musicalArray[y+1][0];
						musicalArray[y+1][0]=tempSwitch;
						tempSwitch=musicalArray[y][1];
						musicalArray[y][1]=musicalArray[y+1][1];
						musicalArray[y+1][1]=tempSwitch;
						tempSwitch=musicalArray[y][2];
						musicalArray[y][2]=musicalArray[y+1][2];
						musicalArray[y+1][2]=tempSwitch;
						z=0;
					}//End If Statement
				y++;
			}//End For Loop
		}while(z==0);
	}//End Sort Artist
	
	
	
	public static void sortalbum(String[][] musicalArray, int counter){
		int z=1;
		do
		{
			z=1;
			for(int y=0; y<counter-1;)
				{
					if(musicalArray[y][2].compareTo(musicalArray[y+1][2])>0)
					{
						String tempSwitch=musicalArray[y][0];
						musicalArray[y][0]=musicalArray[y+1][0];
						musicalArray[y+1][0]=tempSwitch;
						tempSwitch=musicalArray[y][1];
						musicalArray[y][1]=musicalArray[y+1][1];
						musicalArray[y+1][1]=tempSwitch;
						tempSwitch=musicalArray[y][2];
						musicalArray[y][2]=musicalArray[y+1][2];
						musicalArray[y+1][2]=tempSwitch;	
						z=0;
					}//End If Statement
					y++;
				}//End For Loop
		}while(z==0);
	}//End Sort Artist
}//End of Class
	
