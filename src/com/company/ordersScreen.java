package com.company;

import javax.swing.*;

/**
 * Created by kings on 12/06/2017.
 */
public class ordersScreen {

    JWindow window;

    public ordersScreen(){
        window = new JWindow();
        window.getContentPane().add(new JLabel("",new ImageIcon("C:\\Users\\kings\\IdeaProjects\\FazConsertos\\src\\com\\company\\logo.png"),SwingConstants.CENTER));
        window.setBounds(450,300,400,300);
        window.setVisible(true);
        try{
            Thread.sleep(3000);
        }
        catch(InterruptedException e){}
        window.dispose();
    }
}
