package AppUIPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame {
    private JButton button;
    private JTextField textField;
    public JTextArea textArea;
    private JPanel panelBottom;
    private JPanel controlPanel;
    private JPanel panelRight;
    private JPanel panelBase;
    private JFrame mainFrame = null;
    private Client currentClient;

    public MainForm(Client client){
        currentClient = client;
        PrepareForm();
        CreatePanel();
        new RecvText().start();
    }

    private void PrepareForm(){
        mainFrame = new JFrame();
        mainFrame.setSize(615,640);
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
        panelBottom.setLayout(null);
        panelBottom.setLocation(0,500);
        panelBottom.setBackground(Color.red);
        controlPanel.add(panelBottom); //add bottom side panel to control panel

        //creating right side panel
        panelRight = new JPanel();
        panelRight.setSize(100,500);
        panelRight.setLayout(null);
        panelRight.setLocation(500,0);
        panelRight.setBackground(Color.BLUE);
        controlPanel.add(panelRight); //add right side panel to control panel

        //creating right side panel
        panelBase = new JPanel();
        panelBase.setSize(500,500);
        panelBase.setLayout(null);
        panelBase.setLocation(0,0);
        panelBase.setBackground(Color.GRAY);
        controlPanel.add(panelBase); //add right side panel to control panel

        //create bottom button
        button = new JButton("Send");
        button.setLocation(510,10);
        button.setSize(80,80);
        panelBottom.add(button);


        //create text field
        textField = new JTextField(10);
        textField.setLocation(10,10);
        textField.setSize(480,80);
        textField.setHorizontalAlignment(JTextField.LEFT);
        panelBottom.add(textField); //add ui text field component to panel bottom

        //create text pane
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLocation(10,10);
        textArea.setSize(480,480);
        panelBase.add(textArea);

        //set the main frame to visible
        mainFrame.setVisible(true);

        //register action listener for ui components
        button.addActionListener(new SendText());

    }


    //receiving text listener for chat

    private class RecvText extends Thread {

        public void run(){
            while(true){
                String clientName = currentClient.name;
                String input = currentClient.receiveText();
                textArea.append(clientName+": " + input + "\n");
            }
        }
    }


    //action listener instances

    class SendText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            currentClient.sendText(GetText());
        }
    }

    //properties

    public String GetText(){
        String message = textField.getText();
        textField.setText(" ");
        return message;
    }

    public void SetText(){
        String text = textField.getText();
    }

}
