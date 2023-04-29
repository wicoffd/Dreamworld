package view;

import controller.KeyManager;

import javax.swing.*;
import java.awt.*;

public class CustomTitle extends JFrame{
    static Color transparent = new Color(0, true);
    Dimension size;
    public CustomTitle(JFrame frame, JPanel topBar){

        // TODO  https://stackoverflow.com/questions/16046824/making-a-java-swing-frame-movable-and-setundecorated  make window moveable
        size =  Window.getSize();
        System.out.println("size width = " + size.width);
        //frame.setLayout(new BoxLayout(topBar,BoxLayout.PAGE_AXIS));
        exitButton(topBar, frame);
        JButton title=new JButton();
        maximizeButton(topBar, frame, title);
        minimizeButton(topBar,frame);
        ImageIcon titleImage = new ImageIcon("D:\\DummyDir\\Dreamworld\\src\\view\\title.png");
        title.setBackground(transparent);
        title.setForeground(transparent);
        setTitleSize(frame, title);
        title.setContentAreaFilled(false); // unsure
        title.setBorderPainted(false); //removes border outline
        title.setIcon(titleImage);
        title.setVisible(true);
        topBar.add(title, BorderLayout.CENTER);
        KeyManager keyManager = new KeyManager(frame,title);
        frame.setIconImage(new ImageIcon(getClass().getResource("stone.png")).getImage());
    }

    /*private void setTitleSize(JFrame frame, JButton title) {
        if(frame.getExtendedState() != MAXIMIZED_BOTH) {
            title.setPreferredSize(new Dimension(size.width, 16));
        }else{
            title.setPreferredSize(new Dimension(frame.getBounds().width, 16));
        }
    }*/
    private void setTitleSize(JFrame frame, JButton title) {
        if(frame.getExtendedState() != MAXIMIZED_BOTH) {
            // nested if to bug fix TODO fix nested if

                title.setPreferredSize(new Dimension(1080, 32));

        }else{
            title.setPreferredSize(new Dimension(frame.getWidth(), 32));

        }
    }

    private JButton createButton(ImageIcon buttonIcon) {
        JButton button = new JButton();
        button.setBackground(transparent);
        button.setForeground(transparent);
        button.setContentAreaFilled(false); // unsure
        button.setMaximumSize(new Dimension(32,32));
        button.setBorderPainted(false); //removes border outline
        button.setIcon(buttonIcon);
        button.setLocation(size.width,size.height);
        button.setPreferredSize(new Dimension(32,32));// changes the boundary of the button to the correct size
        button.setVisible(true);
        return button;
    }

    private void maximizeButton(JPanel topBar, JFrame frame, JButton title){
        ImageIcon x = new ImageIcon("D:\\DummyDir\\Dreamworld\\src\\controller\\maximizebutton.png");
        JButton maximize = createButton(x);
        maximize.addActionListener(actionEvent -> {
            if(frame.getExtendedState() != MAXIMIZED_BOTH) {
                frame.setExtendedState(MAXIMIZED_BOTH);
                //setTitleSize(frame, title);
            }else{
                frame.setExtendedState(NORMAL);
                frame.pack();
                //setTitleSize(frame, title);
            }
        }); // maybe use pack() to make the window smaller again?
        topBar.add(maximize);

    }




    private void minimizeButton(JPanel topBar, JFrame frame){
        ImageIcon x = new ImageIcon("D:\\DummyDir\\Dreamworld\\src\\controller\\minimizebutton.png");
        JButton minimize = createButton(x);
        minimize.addActionListener(actionEvent -> frame.setState(ICONIFIED));
        topBar.add(minimize);

    }

    private void exitButton(JPanel topBar, JFrame frame){
        ImageIcon x = new ImageIcon("D:\\DummyDir\\Dreamworld\\src\\controller\\smallexit.png");
        JButton exit = createButton(x);
        exit.addActionListener(actionEvent -> frame.dispose());
        topBar.add(exit);

    }
}
