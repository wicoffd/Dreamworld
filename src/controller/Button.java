package controller;

import view.CustomTitle;

import javax.swing.*;
import java.awt.*;


public class Button {
    static Color transparent = new Color(0, true);

    Dimension size;

    public void setJButton(JFrame frame, JPanel topBar) {

        CustomTitle title = new CustomTitle(frame, topBar);
        topBar.setBackground(transparent);
        topBar.setLayout(new FlowLayout());
        size =  frame.getSize();

        //createButtons(frame);


        topBar.setVisible(true);
        frame.add(topBar);
    }

    private static Object[] createButtons(JFrame frame) { // creates buttons
        JButton button = new JButton("Button"); // create a Button
        button.setBounds(120, 120, 120, 40);
        Object[] buttons = new Object[2];
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = button;
        }
       ////toolBar.add((Component) exitButton(toolBar));

        return buttons;
    }


}
