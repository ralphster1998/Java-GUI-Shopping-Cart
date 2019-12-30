
/**
 * This is ShoppingCart class, which is also the Controller part of the class.
 * This will make a list of the user's picked items and give them the option
 * to delete an item if they change their mind.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class ShoppingCart extends JFrame {

        private final ItemModel savedItemModel;
        private JPanel shoppingCart;

        /**
        * Shopping Cart constructor
        * @param savedItemModel passes the ItemModel to this class
        */
        
        public ShoppingCart(ItemModel savedItemModel) {
                this.setTitle("Shopping Cart");
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setSize(1000, 800);
                this.setLocationRelativeTo(null);

                this.savedItemModel = savedItemModel;

                this.shoppingCart = getShoppingCart();
                JScrollPane scroll = new JScrollPane(shoppingCart, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroll.setPreferredSize(new Dimension(800, 300));
                this.add(scroll, BorderLayout.CENTER);

                JPanel toolBarPanel = getToolBar();
                this.add(toolBarPanel, BorderLayout.SOUTH);
        }

        /**
        *  Method paintShoppingCartPanel() refreshes the panel when items are removed or added
        */
        private final void paintShoppingCartPanel() {
                shoppingCart.removeAll();
                shoppingCart.revalidate();
                shoppingCart.repaint();

                Iterator<Item> it = savedItemModel.iterator();
                while (it.hasNext()) {
                        Item item = (Item) it.next();
                        shoppingCart.add(displayItemBox(item), BorderLayout.CENTER);
                }

        }

       /**
        * Create a  JPanel "getShoppingCart" to be display as the shopping cart  panel which has the itemBox displayed on it.
        * 
        * @return A JPanel that has certain size, border, background color and items.
        */
        private final JPanel getShoppingCart() {
                shoppingCart = new JPanel();
                shoppingCart.setPreferredSize(new Dimension(700, 300 * savedItemModel.getSize()));
                shoppingCart.setBorder(BorderFactory.createEtchedBorder());
                shoppingCart.setBackground(Color.WHITE);
                Iterator<Item> it = savedItemModel.iterator();
                while (it.hasNext()) {
                        Item item = it.next();
                        shoppingCart.add(displayItemBox(item), BorderLayout.CENTER);
                }

                return shoppingCart;
        }
     
        /**
        * Create a  JPanel "displayItemBox" to display the itemBox layouts.
        * 
        * @param item This puts the item in the method to retrieve the info.
        * @return A JPanel that has certain border, layouts,and labels to be displayed as the itemBox.
        */
        private final JPanel displayItemBox(Item item) {

                // set dimensions
                Dimension buttonSize = new Dimension(100, 190);
                JButton deleteItem = new JButton("Delete");
                deleteItem.setPreferredSize(buttonSize);

                // name, price, stock, quantity, and picture
                JLabel name = new JLabel(item.toString() + " Name: " + item.getName());

                ImageIcon img = new ImageIcon(getClass().getResource(item.getImg()));
                Image imgScaled = img.getImage();

                Image newImage = imgScaled.getScaledInstance(150, 200, Image.SCALE_SMOOTH);

                ImageIcon rightImg = new ImageIcon(newImage);
                JLabel image = new JLabel(rightImg);

                JLabel price = new JLabel("Total Price:$ " + (item.getPrice() * item.getQuantity()));

                JLabel stock = new JLabel("Stock Left: " + item.getStock());

                JLabel quantity = new JLabel("Quantity: " + item.getQuantity());

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

                JPanel combine = new JPanel();
                combine.add(quantity);

                // GridBag Layout
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = 0;
                c.gridy = 0;
                c.insets = new Insets(10, 10, 10, 10);
                c.anchor = GridBagConstraints.NORTHWEST;
                west.add(image, c);

                c.gridx = 0;
                c.gridy = 0;
                center.add(name, c);
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
                east.add(deleteItem, c);

                // delete action when clicked on the delete button in the shopping cart window
                deleteItem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                                Iterator<Item> it = savedItemModel.iterator();
                                while (it.hasNext()) { // you traverse all elements of the collection
                                        System.out.println(it.next());
                                }
                                item.resetStock();
                                item.resetQuantity();
                                // remove the selected item
                                savedItemModel.removeItem(item);

                                paintShoppingCartPanel();

                        }
                });

                return itemBox;

        }

        /**
        * Create a  JPanel "getToolBar" to display the 'Pay' and 'Back' button layouts.
        * 
        * @return A JPanel that has certain border, layouts,and buttons to be displayed as the toolBar.
        */
        private final JPanel getToolBar() {
                JPanel toolBar = new JPanel();

                Dimension buttonSize = new Dimension(150, 50);
                JButton btnBack = new JButton("Back");
                btnBack.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                dispose();
                                ShoppingFrame frame = new ShoppingFrame();
                                frame.pack();
                                frame.setVisible(true);
                        }
                });
                btnBack.setPreferredSize(buttonSize);
                toolBar.add(btnBack, BorderLayout.WEST);

                JButton btnPay = new JButton("Pay");
                btnPay.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent arg0) {
                                dispose();
                                Receipt ty = new Receipt(savedItemModel);
                                Iterator<Item> it = savedItemModel.iterator();

                                while (it.hasNext()) {
                                        Item it2 = (Item) it.next();
                                        it2.resetStock();
                                        it2.resetQuantity();
                                        it.remove();
                                }
                                ty.setVisible(true);
                        }
                });
                btnPay.setPreferredSize(buttonSize);
                toolBar.add(btnPay, BorderLayout.EAST);

                return toolBar;
        }

}