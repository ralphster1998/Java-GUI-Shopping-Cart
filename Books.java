
/**
 * This is Book class to create an item for a book in a store.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

public final class Books extends Item {

    /**
     * Book constructor
     * @param name The name of the book item
     * @param price The price of the book item
     * @param stock The initial stock value of the book item
     * @param quantity The initial quantity value of the book item
     * @param img The string path for the image of the book item
     */

    public Books(String name, double price, int stock, int quantity, String img) {
        super(name, price, stock, quantity, img);
    }


    /**
     * Gives string "Books" so the StoreDisplayPanel class refreshes item list
     * 
     * @return A string that holds the category name: Books
     */
    public final String toString() {
        return "Books";
    }
    
} 