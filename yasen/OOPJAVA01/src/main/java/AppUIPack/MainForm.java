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
    private JTextArea textAreaConn;

    private  JPanel panelPlayGround;

    public MainForm(Client client){
        currentClient = client;
        PrepareForm();
        CreatePanel();
        CreatePlayGround();
        new RecvText().start();
    }

    private void PrepareForm(){
        mainFrame = new JFrame();
        mainFrame.setSize(960,640);
        mainFrame.getDefaultCloseOperation();
        mainFrame.setLocationRelativeTo(null);
        controlPanel = new JPanel();
        controlPanel.setLayout(null);
        controlPanel.setBackground(Color.gray);
        mainFrame.add(controlPanel);
    }

    public void CreatePanel(){

        //creating bottom side panel
        panelBottom = new JPanel();
        panelBottom.setSize(260,100);
        panelBottom.setLayout(null);
        panelBottom.setLocation(680,500);
        panelBottom.setBackground(Color.red);
        controlPanel.add(panelBottom); //add bottom side panel to control panel

        //creating right side panel
        panelRight = new JPanel();
        panelRight.setSize(100,500);
        panelRight.setLayout(null);
        panelRight.setLocation(580,5);
        panelRight.setBackground(Color.BLUE);
        controlPanel.add(panelRight); //add right side panel to control panel

        //creating right side panel
        panelBase = new JPanel();
        panelBase.setSize(260,500);
        panelBase.setLayout(null);
        panelBase.setLocation(680,0);
        panelBase.setBackground(Color.GRAY);
        controlPanel.add(panelBase); //add right side panel to control panel

        //creating playground panel
        panelPlayGround = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawLine(10,20,30, 50);
                //g.drawImage(image, 0, 0, null);
            }
        };
        panelPlayGround.setLayout(null);
        panelPlayGround.setBackground(Color.yellow);
        panelPlayGround.setLocation(5, 5);
        panelPlayGround.setSize(570,500);
        controlPanel.add(panelPlayGround);

        //create bottom button
        button = new JButton("Send");
        button.setLocation(170,10);
        button.setSize(80,40);
        panelBottom.add(button);


        //create text field
        textField = new JTextField(10);
        textField.setLocation(10,10);
        textField.setSize(160,40);
        textField.setHorizontalAlignment(JTextField.LEFT);
        panelBottom.add(textField); //add ui text field component to panel bottom

        //create text pane
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLocation(5,5);
        textArea.setSize(175,490);
        panelBase.add(textArea);

        //create text pane
        textAreaConn = new JTextArea();
        textAreaConn.setEditable(false);
        textAreaConn.setLocation(185,5);
        textAreaConn.setSize(70,490);
        panelBase.add(textAreaConn);

        //set the main frame to visible
        mainFrame.setVisible(true);

        //register action listener for ui components
        button.addActionListener(new SendText());

    }

    public void CreatePlayGround(){

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
