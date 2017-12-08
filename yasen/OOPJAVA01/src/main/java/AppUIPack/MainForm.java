package AppUIPack;

import javax.swing.*;
import java.awt.*;

public class MainForm extends JFrame{
    private JButton button;
    private JTextField textField;
    private JTextPane textPane;
    private JPanel panelBottom;
    private JPanel controlPanel;
    private JPanel panelRight;
    private JPanel panelBase;
    private JFrame mainFrame = null;

    public MainForm(){
        PrepareForm();

    }

    public static MainForm CreateMainForm(){
        return new MainForm();
    }

    private void PrepareForm(){
        mainFrame = new JFrame();
        mainFrame.setSize(600,600);
        mainFrame.getDefaultCloseOperation();
        mainFrame.setLocationRelativeTo(null);
        controlPanel = new JPanel();
        controlPanel.setLayout(null);
        mainFrame.add(controlPanel);
    }

    public void CreatePanel(){

        //creating bottom side panel
        panelBottom = new JPanel();
        panelBottom.setSize(600,100);
        panelBottom.setLayout(new FlowLayout());
        panelBottom.setLocation(0,500);
        panelBottom.setBackground(Color.red);

        //add bottom side panel to control panel
        controlPanel.add(panelBottom);

        //creating right side panel
        panelRight = new JPanel();
        panelRight.setSize(100,500);
        panelRight.setLayout(new FlowLayout());
        panelRight.setLocation(500,0);
        panelRight.setBackground(Color.BLUE);

        //add right side panel to control panel
        controlPanel.add(panelRight);


        //creating right side panel
        panelBase = new JPanel();
        panelBase.setSize(500,500);
        panelBase.setLayout(new FlowLayout());
        panelBase.setLocation(0,0);
        panelBase.setBackground(Color.GRAY);

        //add right side panel to control panel
        controlPanel.add(panelBase);

        //create bottom button
        button = new JButton("Send");
        //button.setLocation(0,200);
        //button.setSize(200,80);
        panelBottom.add(button);
        


        //create text field
//        textField = new JTextField();
//        textPane = new JTextPane();
//
//        //add ui components to panel
//        panel.add(textField);
//        panel.add(textPane);


        //set the main frame to visible
        mainFrame.setVisible(true);
    }
}
