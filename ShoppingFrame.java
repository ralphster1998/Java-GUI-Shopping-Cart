
/**
 * This is ShoppingFrame class, which is part of Controller part of the class.
 * This will make a list of the store's items and give the option for the
 * user to pick a selected item.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public final class ShoppingFrame extends JFrame {

    private final StoreDisplayPanel storeDisplay;

    /**
     * Shopping Frame constructor
     * The constructor sets the name of the frame and adds JPanels,JScroll to the frame
     */
    public ShoppingFrame() {
        this.setTitle("Shopping Application");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel toolBarPanel = getToolStatusPanel();
        JPanel shoppingCartPanel = getShoppingCartPanel();

        storeDisplay = new StoreDisplayPanel();

        JScrollPane scroll = new JScrollPane(storeDisplay, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(800, 600));
        this.add(toolBarPanel, BorderLayout.WEST);
        this.add(scroll, BorderLayout.EAST);
        this.add(shoppingCartPanel, BorderLayout.PAGE_END);
    }

    /**
     * Create JPanel "getToolStatusPanel"  that display the panel that holds the category buttons
     * 
     * @return A JPanel that contains the category buttons: Books, Clothing, Electronics
     */
    private final JPanel getToolStatusPanel() {
        JPanel toolBarPanel = new JPanel();

        Dimension buttonSize = new Dimension(100, 190);

        JButton books = new JButton("Books");
        books.setPreferredSize(buttonSize);

        JButton clothing = new JButton("Clothing");
        clothing.setPreferredSize(buttonSize);

        JButton electronics = new JButton("Electronics");
        electronics.setPreferredSize(buttonSize);

        toolBarPanel.add(books);
        toolBarPanel.add(clothing);
        toolBarPanel.add(electronics);

        books.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Books clicked");
                storeDisplay.paintStoreDisplayPanel("Books");
            }
        });

        clothing.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Clothing clicked");
                storeDisplay.paintStoreDisplayPanel("Clothing");
            }
        });

        electronics.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Electronics clicked");
                storeDisplay.paintStoreDisplayPanel("Electronics");
            }
        });

        toolBarPanel.setPreferredSize(new Dimension(130, 10));

        return toolBarPanel;
    }


    /**
     * Create JPanel "getShoppingCartPanel"  that display the panel that holds the "Go to Shopping Cart" button
     * 
     * @return A JPanel that display the "Go to Shopping Cart" button
     */    
    private final JPanel getShoppingCartPanel() {
        JPanel shoppingCartPanel = new JPanel();
        Dimension buttonSize = new Dimension(150, 50);

        JButton goTo = new JButton("Go To Shopping Cart");
        goTo.setPreferredSize(buttonSize);

        shoppingCartPanel.add(goTo, BorderLayout.CENTER);

        // Get the itemModel

        shoppingCartPanel.setPreferredSize(new Dimension(150, 70));
        goTo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ShoppingCart cart = new ShoppingCart(storeDisplay.getItemModel());
                cart.pack();
                cart.setVisible(true);
            }
        });

        return shoppingCartPanel;

    }
}