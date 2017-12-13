package AppUIPack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class MainForm extends JFrame {

    private JButton button;
    private JButton buttonStart;
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

    private LinesPanel linesPanel;

    public MainForm(Client client){
        currentClient = client;
        PrepareForm();
        CreatePanel();

        new RecvObject().start();

    }

    private void PrepareForm(){
        mainFrame = new JFrame();
        mainFrame.setSize(1080,720);
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
        panelBottom.setSize(1070,100);
        panelBottom.setLayout(null);
        panelBottom.setLocation(5,580);
        panelBottom.setBackground(Color.red);
        controlPanel.add(panelBottom); //add bottom side panel to control panel

        //creating right side panel
        panelRight = new JPanel();
        panelRight.setSize(100,580);
        panelRight.setLayout(null);
        panelRight.setLocation(700,5);
        panelRight.setBackground(Color.BLUE);
        controlPanel.add(panelRight); //add right side panel to control panel

        //creating right side panel
        panelBase = new JPanel();
        panelBase.setSize(260,580);
        panelBase.setLayout(null);
        panelBase.setLocation(800,0);
        panelBase.setBackground(Color.GRAY);
        controlPanel.add(panelBase); //add right side panel to control panel

        panelPlayGround = new JPanel();
        panelPlayGround.setLayout(null);
        panelPlayGround.setBackground(Color.lightGray);
        panelPlayGround.setLocation(5, 5);
        panelPlayGround.setSize(790,580);
        controlPanel.add(panelPlayGround);

        //create bottom button
        button = new JButton("Send");
        button.setLocation(400,10);
        button.setSize(80,40);
        panelBottom.add(button);

        //create start button
        buttonStart = new JButton("Start");
        buttonStart.setLocation(10,10);
        buttonStart.setSize(80,40);
        panelBottom.add(buttonStart);

        //create text field
        textField = new JTextField(10);
        textField.setLocation(300,10);
        textField.setSize(160,40);
        textField.setHorizontalAlignment(JTextField.LEFT);
        panelBottom.add(textField); //add ui text field component to panel bottom

        //create text pane
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLocation(5,5);
        textArea.setSize(175,570);
        panelBase.add(textArea);

        //create text pane
        textAreaConn = new JTextArea();
        textAreaConn.setEditable(false);
        textAreaConn.setLocation(185,5);
        textAreaConn.setSize(70,570);
        panelBase.add(textAreaConn);

        //register action listener for ui components
        button.addActionListener(new SendText());
        buttonStart.addActionListener(new StartGame());

        //set the main frame to visible
        mainFrame.setVisible(true);
    }

    public void CreatePlayGround(){
        //create panel for sticks and add in playground panel
        linesPanel.setLayout(null);
        linesPanel.setLocation(0,0);
        linesPanel.setSize(680,580);
        panelPlayGround.add(linesPanel);
        linesPanel.addMouseListener(new MouseAdapter());
    }



    private class RecvObject extends Thread {
        CommunicationObject input = null;
        public void run(){
            while(true){
                input = currentClient.receiveCommunicationObject();
                if(input.GetFlag().equals("message")){
                    String clientName = currentClient.name;
                    textArea.append(clientName+": " + input.GetText() + "\n");
                } else {
                    linesPanel = new LinesPanel(input.GetStick());
                    CreatePlayGround();
                    linesPanel.repaint();
                }
            }
        }
    }

    //action listener instances

    class SendText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            currentClient.SendObject(new CommunicationObject(textField.getText()));
        }
    }

    class StartGame implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            currentClient.SendObject(new CommunicationObject(new LinkedList<>()));
        }
    }

    //action listener instances

    class MouseAdapter implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            linesPanel.removeLastStick();
            currentClient.SendObject(new CommunicationObject(linesPanel.GetCurrentSticks()));
            linesPanel.repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

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
