package AppUIPack;

import javax.swing.*;

public class MainForm extends JFrame{
    private JButton button;
    private JTextField textField;
    private JTextPane textPane;
    private JPanel panel;
    private JPanel controlPanel;
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
        mainFrame.add(controlPanel);
    }

    public void CreatePanel(){
        panel = new JPanel();
        button = new JButton();
        textField = new JTextField();
        textPane = new JTextPane();
        button.setSize(100,100);
        panel.add(button);
        panel.add(textField);
        panel.add(textPane);
        controlPanel.add(panel);
        mainFrame.setVisible(true);
    }
}
