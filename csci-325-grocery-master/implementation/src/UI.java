/**
 * Created by Matthew on 11/24/2015.
 */

import javax.swing.*;
import java.awt.*;


public class UI {


    public static void main(String args[]) {

        JFrame groceryUI = new JFrame("CSCI 325 Grocery Project");
        UIManagement myHomeScreen = new UIManagement();
        groceryUI.setPreferredSize(new Dimension(600, 850));
        groceryUI.add(new UIManagement());
        groceryUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        groceryUI.pack();
        groceryUI.setVisible(true);
        LANManagement.startServer(13001);


    }



}
