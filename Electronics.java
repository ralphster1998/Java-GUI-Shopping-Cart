
/**
 * This is Electronics class to create an item for an electronic item.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

public final class Electronics extends Item {

    /**
     * Electronic constructor
     * @param name The name of the electronic item
     * @param price The price of the book
     * @param stock The initial stock value of the book
     * @param quantity The initial quantity value of the book
     * @param img The string path for the image of the book
     */
    public Electronics(String name, double price, int stock, int quantity, String img) {
        super(name, price, stock, quantity, img);
    }
    
    /**
     * Gives string "Electronics" so the StoreDisplayPanel class refreshes item list
     * 
     * @return A string that holds the category name: Electronics
     */
    public final String toString() {
        return "Electronics";
    }

}  