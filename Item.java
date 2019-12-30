
import javax.swing.*;

/**
 * This is Item abstract class, which holds the member variables and primary
 * methods for Books, Clothing and Electronics classes.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

public abstract class Item extends JFrame {
        private final int stockInit = 5;
        private final int quantityInit = 0;
        private final String name;
        private final double price;
        private int stock;
        private int quantity;
        private final String img;

        /**
         * Item constructor
         * @param name The name of the generic item
         * @param price The price of the generic item
         * @param stock The initial stock value of the generic item
         * @param quantity The initial quantity value of the generic item
         * @param img The string path for the image of the generic item
         */
        public Item(String name, double price, int stock, int quantity, String img) {
                this.name = name;
                this.price = price;
                this.stock = stock;
                this.quantity = quantity;
                this.img = img;
        }

        /**
         * Adds quantity to the item when user wants some quantity of an item.
         * @param addNum An integer that will be added to quantity when necessary.
         */
        public void addQuantity(int addNum) {
                this.quantity = this.quantity + addNum;
        }

        /**
         * Subtracts stock to the item when user buys an item.
         * @param subNum An integer that will subtract from quantity when necessary.
         */
        public void subtractStock(int subNum) {
                this.stock = this.stock - subNum;
        }

        /**
         * Resets stock of an item when user shops again.
         * 
         */
        public void resetStock() {
                this.stock = stockInit;
        }

        /**
         * Resets quantity of an item after user pays, when they want to shop more.
         * 
         */
        public void resetQuantity() {
                this.quantity = quantityInit;
        }

        /**
         * Gets the name of the generic item.
         * @return string specifying name of the item
         */
        public String getName() {
                return name;
        }

        /**
         * Gets the price of the generic item.
         * @return price of the item in double type
         */
        public double getPrice() {
                return price;
        }

        /**
         * Gets the stock amount of the generic item.
         * @return stock amount of item in type 'int'
         */
        public int getStock() {
                return stock;
        }

        /**
         * Gets the quantity amount of the generic item.
         * @return stock amount of item in type 'int'
         */
        public int getQuantity() {
                return quantity;
        }

        /**
         * Gets the path of a specific image.
         * @return String of the path of a specific image.
         */
        public String getImg() {
                return img;
        }

        /**
         * Gets the whole information of the item.
         * @return String of the whole item information
         */
        public String toString() {
                return this.name + ", " + this.price + ", " + this.stock + ", " + this.quantity + ", " + this.img;
        }
}