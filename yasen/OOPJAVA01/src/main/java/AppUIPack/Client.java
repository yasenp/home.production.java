package AppUIPack;

import SocketPack.LinesPanel;

import javax.sound.sampled.Line;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Yassen on 8/24/2017.
 */
public class Client extends Thread {

    String name;
    MainForm gui = null;
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    ObjectInputStream inObject;
    InetAddress inetAddr;
    String serverAddress;

    public Client(String name){
        this.name = name;
        InitClient();
    }

    public void InitClient() {

        try {
            //inetAddr = InetAddress.getByName(serverAddress);
            inetAddr = InetAddress.getLocalHost();
            socket = new Socket(inetAddr, 9999);
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            inObject = new ObjectInputStream(socket.getInputStream());
            //BufferedReader output = new BufferedReader(new InputStreamReader(System.in));
            //out.println("CORRECTREQUEST");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendText(String s){
        out.println(s);
    }

    public String receiveText(){
        String input = "";
        try {
            input = in.readLine();

        } catch (IOException eio){
            eio.fillInStackTrace();
        }
        return input;
    }

    public LinesPanel receiveObject(){
        LinesPanel inputObj = null;
        try {
            inputObj = (LinesPanel)inObject.readObject();

        } catch (IOException eio){
            eio.fillInStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return inputObj;
    }


    public static void main(String[] args){

            Client clientInst = new Client(args[0]);
            MainForm GUI = new MainForm(clientInst);
    }
}