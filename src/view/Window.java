package view;

import controller.Button;
import controller.KeyManager;

import javax.swing.*;
import java.awt.*;



public interface Window {
    Button addButtons = new Button();
    JPanel topBar = new JPanel();
    JFrame frame = new JFrame(); // create a JFrame
    JFrame testFrame = new JFrame();
    //JDesktopPane desktopPane = new JDesktopPane();
    Dimension size =  frame.getSize();
    Dimension preferredSize = new Dimension(1080, 980);
    static void getWindow(){

        createWindow();

        //frame.add(createGameWindow());

    }

    private static void createWindow() {


        addButtons.setJButton(frame, topBar); // put before background image and custom title to fix issues
        new BackgroundImageJFrame(frame, "start");
        frame.setSize(preferredSize); // set frame size
        frame.setTitle("Dreamworld");
        frame.setPreferredSize(preferredSize);
        frame.setUndecorated(true);
        Color transparent = new Color(0, true);
        frame.setLayout(new SpringLayout());
        frame.setBackground(transparent);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setVisible(true); // create frame

        //////////////
        //Test window
        Container info = new Container();
        Container input = new Container();
        testFrame.setVisible(true);
        testFrame.setLayout(new GridLayout());
        testFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        testFrame.setSize(new Dimension(900,900));
        JTextArea textArea = new JTextArea();
        textArea.setSize(200,65);
        textArea.setPreferredSize(new Dimension(90,90));
        textArea.setForeground(Color.WHITE);
        JTextArea inputArea = new JTextArea();
        inputArea.setSize(200,65);
        inputArea.setPreferredSize(new Dimension(700,90));
        inputArea.setForeground(Color.BLACK);
        info.add(textArea);
        input.add(inputArea);
        testFrame.add(info);
        testFrame.add(input);
        textArea.setBackground(Color.GRAY);
        textArea.setOpaque(true);
        textArea.setVisible(true);
        textArea.setText("Help");
        //Container testPanel = new Container();
        //////////
    }


    class BackgroundImageJFrame extends JFrame { //TODO // https://www.geeksforgeeks.org/working-with-json-data-inin-java/#
        //TODO https://stackoverflow.com/questions/66929223/how-to-move-an-undecorated-jframe-window
        private BackgroundImageJFrame(JFrame frame, String map) {
            if(map.equalsIgnoreCase("start")) {
                JLabel background = new JLabel(new ImageIcon("D:\\DummyDir\\Dreamworld\\src\\view\\crab.jpg"));
                frame.add(background);
            }


        }
    }


    /*static JInternalFrame createGameWindow() {
        JInternalFrame gameFrame = new JInternalFrame();

        gameFrame.setVisible(true);
        Dimension gameSize = new Dimension(500,500);
        gameFrame.setPreferredSize(gameSize);

        gameFrame.setResizable(true);
        gameFrame.setLocation((-size.width + gameSize.width)/2,
                (-size.height + gameSize.height)/2);

        return gameFrame;
    }*/
    static Dimension getSize(){
        return frame.getSize();
    }
    static Dimension getPreferredSize(){
        return preferredSize;
    }

}
