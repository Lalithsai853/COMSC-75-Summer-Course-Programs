/*
 * Lalithsai Posam
 * InventoryItem.java
 * This program creates an InventoryItem class and has several methods
 * to create objects with a specific name, sku, price, and quantity. It
 * models a real life inventory system.
 */


public class InventoryItem {
	// Declares private variables
	private String itemName;
	private int sku;
	private double price;
	private int quantity;
	private static int nItems;
	
	// This is the no arg constructor
	public InventoryItem () {
		this("TBD", 0, 0.0, 0);
	}
	
	// This is the three arg constructor that creates an object with
	// an item name, sku, and price with a default quantity
	public InventoryItem (String itemName, int sku, double price) {
		this(itemName, sku, price, 0);
	}
	
	// This is the four arg constructor that creates an object with
	// an item name, sku, price, and quantity
	public InventoryItem(String itemName, int sku, double price, 
						 int quantity) {
	   	this.itemName = itemName;
		this.sku = sku;
		this.price = Math.abs(price);
		this.quantity = Math.abs(quantity);
		nItems++;
	}
	
	// returns the item name
	public String getitemName () {
		return itemName;
	}
	
	// sets the item name
	public void setitemName (String itemName) {
		this.itemName = itemName;
	}
	
	// returns the sku
	public int getsku () {
		return sku;
	}
	
	// sets sku
	public void setsku (int sku) {
		this.sku = sku;
	}
	
	// returns price
	public double getPrice () {
		return price;
	}
	
	// sets price
	public void setPrice (double price) {
		this.price = Math.abs(price);
	}
	
	// returns quantity
	public int getQuantity () {
		return quantity;
	}
	
	// sets quantity
	public void setQuantity (int quantity) {
		this.quantity = Math.abs(quantity);
	}
	
	// returns the number of objects or items
	public static int getnItems () {
		return nItems;
	}
	
	// returns the total value of the item
	public double getTotalValue () {
		double totalValue = price * quantity;
		return totalValue;
	}
	
	// Displays all the information about the item
	public void display () {
		System.out.printf("Item: " + itemName + "\n" + "SKU: " + sku + 
						   "\n" + "Price: $%.2f" + "\n" + "Quantity: " 
						   + quantity + "\n", price);
	}
	
	// This method compares the total value of two items 
	public static int compare (InventoryItem item1, InventoryItem item2) {
		int compareResult;
		if (item1.getTotalValue() > item2.getTotalValue()) {
			compareResult = 1;
		}
		else if (item1.getTotalValue() == item2.getTotalValue()) {
			compareResult = 0;
		}
		else {
			compareResult = -1;
		}
		return compareResult;
	}
	
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
		
		System.out.println("Number of inventory items: " + 
							InventoryItem.getnItems() + "\n");
		for (int item = 0; item < supplies.length; item++) {
			supplies[item].display();
			System.out.printf("Total Value:  $%.2f\n", 
							   supplies[item].getTotalValue());
			System.out.print("\n");
		}
		
		// Compares the total value between pencils and notebooks
		// and prints which one is greater
		int compareResult = InventoryItem.compare(pencils, notebooks);
		String pencilName = pencils.getitemName();
		String notebookName = notebooks.getitemName();
		
		if (compareResult == 0) {
			System.out.print(pencilName + 
			" has the same value as " + notebookName + " .");
		}
		else if (compareResult == 1) {
			System.out.print(pencilName + 
			" has a higher value than " + notebookName + " .");
		}
		else {
			System.out.println(pencilName + 
			" has a lower value than " + notebookName + ".");

		}
	}
}




