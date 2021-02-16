/*
 * Lalithsai Posam
 * TestInventory.java
 * This program creates 4 InventoryItem objects and displays information
 * about each object.
 */


public class TestInventory {
	
	public static void main (String[] args) {
		// Creates four objects of inventory item
		InventoryItem emptyItem = new InventoryItem();
		InventoryItem staplers = new InventoryItem("Stapler, Red", 
													91745, 7.89);
		InventoryItem pencils = new InventoryItem("Pencil, #2", 
												   73105, 0.35, 210);
		InventoryItem notebooks = new InventoryItem("Notebook, Spiral", 
													68332, 2.57, 38);
		
		// Adds the four objects into an array
		InventoryItem[] supplies = {emptyItem, staplers, pencils, notebooks};
		
		// Displays all the information of each object and prints
		// the total value of each object
		System.out.println(InventoryItem.getnItems() - 1);
		for (int item = 0; item < supplies.length; item++) {
			supplies[item].display();
			System.out.printf("Total Value:  %.2f\n", 
							   supplies[item].getTotalValue());
			System.out.print("\n");
		}
		
		// Compares the total value between pencils and notebooks
		// and prints which one is greater
		
		int compareResult = InventoryItem.compare(pencils, notebooks);
		
		if (compareResult == 0) {
			System.out.print(pencils.getitemName() + 
			" has the same value as " + notebooks.getitemName() + " .");
		}
		else if (compareResult == 1) {
			System.out.print(pencils.getitemName() + 
			" has a higher value than " + notebooks.getitemName() + " .");
		}
		else {
			System.out.println(pencils.getitemName() + 
			" has a lower value than " + notebooks.getitemName() + ".");

		}
	}
}
