
/**
 * This is Receipt class, which will tell the user the info for each item
 * and the total cost for their purchases.
 * 
 * @author Ralph Dela Cruz, Emily Laih, Tam Huynh
 * 
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.*;


public final class Receipt extends JFrame {
        private final ItemModel savedItemModel;
        
        /**
        * Receipt constructor
        * @param savedItemModel passes the ItemModel to this class
        */
        public Receipt(ItemModel savedItemModel) {
                
                // set the window title as "Thank you"
                this.setTitle("Thank You");
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
                this.setSize(800, 300);
                this.setLocationRelativeTo(null);

                this.savedItemModel = savedItemModel;

                // create a receiptBox to display receipt text
                JTextArea receiptBox = new JTextArea();
                String receipt = getReceipt();
                receiptBox.setSize(new Dimension(800, 100 * savedItemModel.getSize()));
                receiptBox.setText(receipt);

                // create a scroll for the receipt frame
                JScrollPane scroll = new JScrollPane(receiptBox, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                scroll.setPreferredSize(new Dimension(800, 600));
                this.add(scroll, BorderLayout.CENTER);

                JPanel message = new JPanel();
                JLabel tyMessage = getThankYou();
                message.setPreferredSize(new Dimension(150, 70));
                message.add(tyMessage);
                this.add(message, BorderLayout.NORTH);

                // create the button for the receipt class
                JPanel buttons = new JPanel();
                JButton btnShopMore = getShopMore();
                btnShopMore.setPreferredSize(new Dimension(150, 50));
                buttons.add(btnShopMore);

                JButton btnExit = getButtonExit();
                btnExit.setPreferredSize(new Dimension(150, 50));
                buttons.add(btnExit);

                this.add(buttons, BorderLayout.PAGE_END);
        }
        
        
        /**
        *  JLabel "Shop more!!!"  displays the message "Thank you for using our shopping application" on the Receipt window.
        * 
        *  @return A JLabel named tyMessage that holds the message "Thank you for using our shopping application"
        */
        private final JLabel getThankYou() {
                JLabel tyMessage = new JLabel("Thank you for using our shopping application");
                tyMessage.setFont(new Font("Source Sans Pro", Font.ITALIC, 18));
                tyMessage.setHorizontalAlignment(SwingConstants.CENTER);
                tyMessage.setBounds(32, 250, 512, 20);

                return tyMessage;
        }

        
        /**
        * Gives a JButton "Shop more!!!" that when clicked it'll go open up a shopping Frame window
        * 
        * @return A JButton that holds the button name: Shop more!!!
        */
        private final JButton getShopMore() {
                JButton btnShopMore = new JButton("Shop more!!!");
                btnShopMore.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                dispose();
                                ShoppingFrame shop = new ShoppingFrame();
                                shop.pack();
                                shop.setVisible(true);
                        }
                });

                return btnShopMore;
        }

        
        /**
        * Gives a JButton"Exit" that when clicked it'll close the receipt window
        * 
        * @return A JButton that holds the button name: Exit
        */
        private final JButton getButtonExit() {
                JButton btnExit = new JButton("Exit");
                btnExit.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                                dispose();
                        }
                });

                return btnExit;
        }

        
        
  
        /**
        * Gives the string of the item's information so the Receipt class display it.
        * 
        * @return A string that holds the product's name, quantity, cost, and the total cost.
        */
        private final String getReceipt() {
                String receipt = "RECEIPT: \n\n";
                double totalCost = 0;
                Iterator<Item> it = savedItemModel.iterator();
                while (it.hasNext()) {
                        Item currentItem = it.next();
                        totalCost += currentItem.getPrice() * currentItem.getQuantity();
                        receipt = receipt + "\n Product: " + currentItem.getName() + "\n Quantity: " + currentItem.getQuantity()
                                        + "\n Cost: $" + String.format("%.2f", currentItem.getPrice() * currentItem.getQuantity()) + "\n";

                }

                receipt = receipt + "\n\n Total Cost: $" + String.format("%.2f", totalCost);

                return receipt;
        }

}