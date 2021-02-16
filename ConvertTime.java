
public class ConvertTime {
	
	public static void main (String[] args) {
		int seconds = 560;
		int mins = seconds / 60;
		int remaining_seconds = seconds % 60;
		System.out.println("The total time is " + mins + " minutes and "  + remaining_seconds + " seconds");
		
	}
}

