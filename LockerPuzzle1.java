/*
 * Lalithsai Posam
 * LockerPuzzle1.java
 * This program models a situation in which the 100 lockers are closed, 
 * and 100 students come inaide. The first student opens every locker,
 * and then the second student closes every second locker. The third 
 * student either opens or closes every third locker. This continues to 
 * the 100th student and in the end the program displays which lockers 
 * are open.
*/

public class LockerPuzzle1 {
	public static void main (String[] args) {
		// Declare and create array with type boolean
		boolean [] isOpen = new boolean[100];
		
		// Declaring constants for the total number of lockares and 
		// students.
		final int LOCKER_NUMBERS = 100;
		final int STUDENT_NUMBERS = 100;

		// Declaring lockerNumber as type int
		int lockerNumber;
		
		// Intially setting all lockers to false
		for (lockerNumber = 1; lockerNumber <= LOCKER_NUMBERS; 
			lockerNumber++) {
		    isOpen[lockerNumber - 1] = false;
		}
		
		// Loops through all 100 students and opens and closes lockers
		// according to the student number.
   		for (int studentNumber = 1; studentNumber <= STUDENT_NUMBERS; 
			studentNumber++) {
			lockerNumber = studentNumber;
			
			// While Loop switches the lockers from open to closed or 
			// closed to open.
			while (lockerNumber < LOCKER_NUMBERS) {
				isOpen[lockerNumber] = !(isOpen[lockerNumber]);
				lockerNumber += studentNumber; 
			}
		}
		
		// Displays the open lockers to the user
		for (lockerNumber = 0; lockerNumber < LOCKER_NUMBERS; 
			lockerNumber++) {
			if (isOpen[lockerNumber]) {
				System.out.print(lockerNumber + " ");
			}
		}
		System.out.print("\n");
	}
}
