
/**
 * This is Clothing class to create a clothing item.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

public final class Clothing extends Item {

    /**
     * Book constructor
     * @param name The name of the clothing item
     * @param price The price of the clothing item
     * @param stock The initial stock value of the clothing item
     * @param quantity The initial quantity value of the clothing item
     * @param img The string path for the image of the clothing item
     */
    public Clothing(String name, double price, int stock, int quantity, String img) {
        super(name, price, stock, quantity, img);
    }
    
    /**
     * Gives string "Clothing" so the StoreDisplayPanel class refreshes item list
     * 
     * @return A string that holds the category name: Clothing
     */
    public final String toString() {
        return "Clothing";
    }

} 