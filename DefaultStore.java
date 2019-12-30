
/**
 * This is DefaultStore class to a store for the program,
 * which holds all the items in the store.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

import java.io.*;
import java.util.*;
public final class DefaultStore implements Iterable<Item> {
        // if you're using Windows: use the line below this comment to read the files
        // private final static String[] FILES = { "\\book.txt", "\\clothing.txt", "\\electronic.txt" };
        // if you're using MAC, please modify the paths to each text file from the folder you're using so the files are read
        // for the following line of code: 
        private final static String[] FILES = { "/src/book.txt", "/src/clothing.txt", "/src/electronic.txt" };
        private final ArrayList<Item> store = new ArrayList<>();

        /**
         * DefaultStore constructor: This reads through the files 
         * mentioned in the FILES array by reading the book.txt, clothing.txt,
         * and electronic.txt respectively. This then puts the read values 
         * into each item where necessary.
         */
        public DefaultStore() {
                Scanner input;
                try {
                        for (int i = 0; i < FILES.length; i++) {
                                input = new Scanner(new File(System.getProperty("user.dir") + FILES[i]));
                                for (int j = 0; j < 3; j++) {
                                        if (i == 0) {
                                                Books b = new Books(input.next(), input.nextDouble(), input.nextInt(), input.nextInt(),
                                                                input.next());
                                                store.add(b);
                                        } else if (i == 1) {
                                                Clothing c = new Clothing(input.next(), input.nextDouble(), input.nextInt(), input.nextInt(),
                                                                input.next());
                                                store.add(c);
                                        } else {
                                                Electronics e = new Electronics(input.next(), input.nextDouble(), input.nextInt(),
                                                                input.nextInt(), input.next());
                                                store.add(e);
                                        }
                                        
                                }
                                input.close();
                        }

                } catch (FileNotFoundException e) {
                        System.out.println(e.getMessage());
                }
        }

        /**
         * This iterator helps iterate through the list of items in the store
         * @return the store collection iterator for other classes to use if necessary
         */
        @Override
        public final Iterator<Item> iterator() {
                return store.iterator();
        }

        /**
         * Gives the number of items in the store collection
         * @return the size of the number of items in the store
         */
        public final int getSize() {
                System.out.println(store.size());
                return store.size();
        }
}