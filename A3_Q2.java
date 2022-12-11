// -------------------------------------------------------
// Assignment {3}
// Written by: {Mustafa Ahmad 40196075}
// For COMP 248 Section {EC} – Fall 2022
// --------------------------------------------------------
/* This program is used to vote for candidates the user has entered, and show who is at which ranking based on votes. 
 * 
 * First the user is welcomed and asked to input a collection of ids and candidate names in a specific format.
 * Then the user is shown a menu with 5 options.
 * if user enters 1, the user is shown a list of ids along with the corresponding candidate name.
 * if user enters 2, the user can vote for a candidate but inputting an id, casting a vote for the corresponding candidate,
 * if user enters 3, the user can enter new candidates with id's, to the existing list of candidates entered previously.
 * if user enters 4, Results are displayed. These results consists of how many votes each candidate has received, in order from highest at the top and lowest at the bottom.
 * if user enters 0, the program is ended and the user is shown a goodbye message.
 */
package ass_3;

import java.util.Scanner;
public class A3_Q2 {
	public static void main(String[] args) {
		Scanner x = new Scanner(System.in);
		System.out.println("Welcome to the Simple Electronic Voting System (SEVS):"); //welcome message
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println();
		System.out.println("Please enter a String collection of electoral candidates below:");

		String[] collection = x.nextLine().toUpperCase().split(";|,"); //user input, which is turned into an array, to upper case, and split at ";" , ","

		for (int i = 0; i < collection.length; i++) {  //Loop to trim user input.
			collection[i] = collection[i].trim();}

		String codem;
		int code;
		String[] id = new String [(collection.length/2)]; //new array id is created with half the length of array of user input.
		String[] names = new String [(collection.length/2)]; //new array names is created with half the length of array of user input.
		int [] voteArray = new int[100]; //vote array is created.

		for ( int i = 0 ; i < collection.length ; i+=2) { //Id array is filled with id values from the user input array (collection).
			id[i/2] = collection[i];}

		for (int j = 1 ; j < collection.length; j +=2) {//Names array is filled with name values from the user input array (collection).
			names [j/2] = collection[j];}

		System.out.println("*********************************");
		System.out.println("| Code >> Description           |");
		System.out.println("*********************************");
		System.out.println("|  1   >> Display candidates    |"); //Menu
		System.out.println("|  2   >> Vote a candidate      |");
		System.out.println("|  3   >> Add new candidate(s)  |");
		System.out.println("|  4   >> Display results       |");
		System.out.println("|  0   >> End SEVS              |");
		System.out.println("*********************************");


		System.out.println();
		System.out.print("Enter a code, from the aforementioned, that corresponds to your task: ");

		do  {

			codem = x.next();
			if (((codem.equals("1"))||(codem.equals("2"))||(codem.equals("3"))||(codem.equals("4"))||(codem.equals("0")))) {
				code=Integer.parseInt(codem);
			}                               
			else  //If user input is not equal to or not more than 0 and smaller than 4, ask the user to enter a code again.
				code=5;


			switch (code) {

			case 0: //If user input is 0 then it carries onto the statement, and ends the program

				System.out.println("Thank you for using our Simple Electronic Voting System (SEVS).");
				System.exit(0);
				break;

			case 1: //If user input is 1 then it displays the candidates names along with their id

				System.out.println("*********************************");
				System.out.println("|  ID   >> Candidate's Name     |");
				System.out.println("*********************************");

				for (int a = 0 ; a < id.length ; a++ ) { 
					System.out.println("|\s\s" + id[a] + "\t>>\s" + names[a] + "\t\t|");}

				System.out.println("*********************************");

				break;

			case 2: //If user input is 2 then it asks for input for which id the user would like to vote for and places a vote for that candidate.
				System.out.println();
				System.out.print("Please enter the ID of the candidate you wish to vote for: ");

				int vote = x.nextInt();

				for (int index = 0; index < id.length; index++) {
					if (Integer.parseInt(id[index]) == vote) { //increments by 1 in the vote array for the same position in id array, which the user has inputed to vote for. 
						voteArray[index]++;
						System.out.println("Your ballot has been succesfully casted for: " + names[index] + " bearing Candidate ID: " + id[index]);}

				}
				System.out.println(); //space

				break;

			case 3: //Asks the user to input new collection of electoral candidates
				System.out.println();
				System.out.println("Please enter a String collection of NEW electoral candidates below:");

				x.nextLine();

				String[] NewCollection = x.nextLine().toUpperCase().split(";|,"); // User input of string, uppercased, and split.

				for (int i = 0; i < NewCollection.length; i++) { //Trim user input
					NewCollection[i] = NewCollection[i].trim();}

				String[] TempId = new String [(NewCollection.length/2)]; //New temp ID array 
				String[] TempNames = new String [(NewCollection.length/2)]; //New temp names array

				int NamesCounter = TempNames.length + names.length; //adding temp names array length with old names array length to find the size of the two arrays combined
				int IdCounter = TempId.length + id.length; //adding temp id array length with old id array length to find the size of the two arrays combined

				int l=0;
				for ( int p = 0 ; p < NewCollection.length ; p+=2) {
					TempId[l] = NewCollection[p]; //fills up TempId array with values from the new user input
					l++;}

				for (int q = 1 ; q < NewCollection.length; q+=2) {
					TempNames [q/2] = NewCollection[q];} //fills up TempNames array with values from the new user input

				String [] NewNames = new String [NamesCounter]; // New empty array with the size of old and new array combined, to store old and new name values in one.
				String [] NewId = new String [IdCounter];// New empty array with the size of old and new array combined, to store old and new id values in one.

				for ( int i = 0 ; i < id.length; i++) {
					NewId[i] = id[i];} //fills up first half of newId array with old values.

				int k=0; 
				for (int c = id.length; c < NewId.length ; c++) {
					NewId[c] = TempId[k++];}//fills up second half of newId array with new values.

				for ( int b = 0 ; b < names.length; b++) {
					NewNames[b] = names[b];} //fills up first half of new names array with old values.

				int s=0; 
				for (int d = names.length; d < NewNames.length ; d++) {
					NewNames[d] = TempNames[s++];}//fills up second half of new names array with new values.

				names = NewNames; // reassign names array to the new Names array.
				id = NewId;// reassign id array to the new id array.
				collection = NewCollection; // reassign collection array to the new collection array.

				System.out.println("Successfully added a NEW set of electoral candidates to the Simple Electronic Voting System (SEVS).");
				System.out.println();

				TempId = null; //clear all temp arrays
				TempNames = null;
				NewCollection = null;

				break;

			case 4: //Sorts all candidates and puts the highest voted candidate at the top, and others to follow, in order of their votes, highest to lowest.

				int min, temp;
				String temp2, temp3 = "";

				for (int index = 0; index < voteArray.length-1; index++) {
					min = index; 
					for (int scan = index + 1 ; scan < voteArray.length; scan++) {
						if(voteArray[scan] > voteArray[min]) {
							//this for loop sorts all the candidates by highest voted on top and lowest voted at the bottom, in order.
							min = scan;

							temp = voteArray[min];
							voteArray[min] = voteArray[index];
							voteArray[index] = temp;

							temp2 = id[min];
							id[min] = id[index];
							id[index] = temp2;

							temp3 = names[min];
							names[min] = names[index];
							names[index] = temp3;

						}

					}


				}

				System.out.println("*****************************************************************");
				System.out.println("| Position | Votes/Ballots | ID | Candidate's Name              |");
				System.out.println("*****************************************************************");

				for (int index = 1 ; index < names.length+1 ; index++) {
					System.out.println("|\t\s\s" + index + "|\t\t\s\s" + voteArray[index-1] + "|\s" + id[index-1] + "\s|\s" + names[index-1] + " \t\t\t|");}
				System.out.println("*****************************************************************"); //Prints out a table with all votes with positions.

				break;
			}
			System.out.println();
			System.out.print("Kindly continue by entering a valid code, from the aforementioned, which corresponds to your task: ");
		}while (code != 0); //if code does not equal to 0, continue running the code.
	}
}
