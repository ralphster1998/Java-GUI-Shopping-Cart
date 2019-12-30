
/**
 * This is StoreDisplayPanel class is the View Component of the project.
 * This will refresh the right list of item boxes every time a user clicks
 * on a category button or clicks on an item they want to buy.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public final class StoreDisplayPanel extends JPanel {

        private static final ItemModel itemModel = new ItemModel(); // database for storing items in shopping cart
        private static final DefaultStore defaultStore = new DefaultStore(); // default store to generate items for it

        /**
         * StoreDisplayPanel constructor: This puts the list of item boxes to
         * the category of "Books" and also sets the dimensions and formatting
         * of its own display panel. 
         */
        public StoreDisplayPanel() {
                this.setPreferredSize(new Dimension(800, 100 * defaultStore.getSize()));
                this.setBorder(BorderFactory.createEtchedBorder());
                this.setBackground(Color.WHITE);

                paintStoreDisplayPanel("Books");
        }

        /**
         * Refreshes with the right list of items every time a user clicks
         * on a category button or selects the item they want to buy. 
         * @param categoryName The category name that will have the panel
         *                     display the list of items based off its category.                      
         */
        public final void paintStoreDisplayPanel(String categoryName) {
                this.removeAll();
                this.revalidate();
                this.repaint();

                Iterator<Item> it = defaultStore.iterator();
                while (it.hasNext()) {
                        Item item = it.next();

                        if (item.toString().equals(categoryName)) {
                                this.add(displayItemBox(item), BorderLayout.CENTER);
                        }
                }

        }
        
        /**
         * Makes an item box for each item in the store and is displayed
         * through the StoreDisplayPanel.
         * @param item The current item that is being iterated through to
         *        display the item info and change values in the item info
         *        when the user interacts with them.  
         * @return A JPanel that has certain border, layouts,and labels to be displayed as the itemBox.                   
         */
        private final JPanel displayItemBox(Item item) {

                // set dimensions
                Dimension buttonSize = new Dimension(250, 100);
                JButton shopButton = new JButton("Add to Shopping Cart");
                shopButton.setPreferredSize(buttonSize);

                // name, price, stock, quantity, and picture
                JLabel itemName = new JLabel(item.toString() + " Name: " + item.getName());

                ImageIcon imageIcon = new ImageIcon(getClass().getResource(item.getImg()));
                Image imgScaled = imageIcon.getImage();

                Image newImage = imgScaled.getScaledInstance(150, 200, Image.SCALE_SMOOTH);
                ImageIcon rightImg = new ImageIcon(newImage);
                JLabel image = new JLabel(rightImg);

                JLabel price = new JLabel("Price:$ " + item.getPrice());

                JLabel stock = new JLabel("Stock: " + item.getStock());

                JLabel quantity = new JLabel("Quantity: ");

                JPanel west = new JPanel(new GridBagLayout());
                west.setPreferredSize(new Dimension(200, 190));

                JPanel center = new JPanel(new GridBagLayout());
                center.setPreferredSize(new Dimension(550, 190));

                JPanel east = new JPanel(new GridBagLayout());
                center.setPreferredSize(new Dimension(300, 190));

                JPanel itemBox = new JPanel();
                itemBox.add(west, BorderLayout.WEST);
                itemBox.add(center, BorderLayout.CENTER);
                itemBox.add(east, BorderLayout.EAST);

                // quantityBox
                Integer[] value = { 1, 2, 3, 4, 5 };
                JComboBox<Integer> quantityBox = new JComboBox<>(value);
                // combine quantity and quantityBox
                JPanel combine = new JPanel();
                combine.add(quantity);
                combine.add(quantityBox);

                // GridBag Layout
                GridBagConstraints c = new GridBagConstraints();
                String nameStr = item.getName();
                c.gridx = 0;
                c.gridy = 0;
                c.insets = new Insets(10, 10, 10, 10);
                c.anchor = GridBagConstraints.NORTHWEST;
                west.add(image, c);

                c.gridx = 0;
                c.gridy = 0;
                center.add(itemName, c);
                c.gridx = 0;
                c.gridy = 1;
                center.add(price, c);
                c.gridx = 0;
                c.gridy = 2;
                center.add(stock, c);
                c.weightx = 0.5;
                c.gridx = 0;
                c.gridy = 3;
                c.anchor = GridBagConstraints.SOUTHWEST;
                center.add(combine, c);

                c.gridx = 1;
                c.gridy = 3;
                c.gridwidth = c.gridheight = 1;
                c.fill = GridBagConstraints.BOTH;
                c.anchor = GridBagConstraints.NORTHWEST;
                c.weightx = 33;
                c.weighty = 20;
                east.add(shopButton, c);

                shopButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                int quantityValue = (int) quantityBox.getSelectedItem();
                                if (item.getStock() == 0) {
                                        JOptionPane.showMessageDialog(itemBox, "That item is out of stock");
                                } else if (quantityValue > item.getStock()) {
                                        JOptionPane.showMessageDialog(itemBox,
                                                        "That item doesn't have enough stock for the selected quantity");
                                } else if (itemModel.getSize() != 0 && item.getQuantity() != 0) {
                                        item.addQuantity(quantityValue);
                                        item.subtractStock(quantityValue);
                                        stock.setText("Stock: " + item.getStock());
                                        JOptionPane.showMessageDialog(itemBox, nameStr + " added to cart");
                                } else {
                                        item.addQuantity(quantityValue);
                                        item.subtractStock(quantityValue);
                                        stock.setText("Stock: " + item.getStock());
                                        JOptionPane.showMessageDialog(itemBox, nameStr + " added to cart");
                                        addItem(item);
                                }
                        }
                });

                return itemBox;

        }

        /**
         * Adds an item to the itemModel or user's list of selected items.
         * Interacts with model component of the project.
         * @param newItem The current item that is placed once user 
         *        wants to buy that item.                    
         */
        private final void addItem(Item newItem) {
                itemModel.addItem(newItem);
                System.out.println("Item added");

                Iterator<Item> it = itemModel.iterator();
                while (it.hasNext()) { // you traverse all elements of the collection
                        System.out.println(it.next());
                }
        }

        /**
         * Gets the list of items that the user has selected for their shopping
         * cart.
         * @return returns the list of items user has selected as ItemModel                 
         */
        public final ItemModel getItemModel() {
                return itemModel;
        }
}