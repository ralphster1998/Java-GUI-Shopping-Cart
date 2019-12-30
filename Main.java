
import javax.swing.JFrame;

/**
* Main class starts the program
* @author Ralph Dela Cruz, Emily Laih, Tam Huynh
*/

public class Main {
      
        /**
        * The main function runs the program and create a JFrame window 
        * @param args the command line arguments 
        */
        public static void main(String[] args) {
                JFrame window = new ShoppingFrame();
                window.pack();
                window.setVisible(true);

        }
}