
/**
 * This is ItemModel class, which holds the list of selected items that
 * the user picked from the store.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

import java.util.ArrayList;
import java.util.Iterator;

public final class ItemModel implements Iterable<Item> {
    private final ArrayList<Item> items;
    
    /**
     * ItemModel constructor: This creates a collection by making a new 
     * ArrayList object and setting it to items member variable. 
     */
    public ItemModel() {
        items = new ArrayList<Item>();
    }
    
    /**
     * Adds selected item that user wants into the items collection
     * @param newItem An item that is added to list of users' wanted items.
     */
    public final void addItem(Item newItem) {
        items.add(newItem);
    }
    
    /**
     * Removes selected item that user may not want anymore.
     * @param removedItem An item that is removed by user through shopping cart.
     */
    public final void removeItem(Item removedItem)
    {
        items.remove(removedItem);
    }
    
    
    /**
     * This iterator helps iterate through the list of items that the user has picked.
     * @return the collection of selected items put in iterator for other classes to use if necessary
     */
    @Override
    public final Iterator<Item> iterator() { 
        return items.iterator();
    }
    
    /**
     * Gives the number of items in the user's collection of selected items
     * @return the size of the number of items in the user's collection of selected items
     */
    public final int getSize() {
        return items.size();
        }

}