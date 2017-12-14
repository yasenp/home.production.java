package AppUIPack;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Yassen on 8/24/2017.
 */
public class Client extends Thread {

    String name;
    Socket socket;
    ObjectInputStream inObject;
    ObjectOutputStream outObject;
    InetAddress inetAddr;

    public Client(String name){
        this.name = name;
        InitClient();
    }

    public void InitClient() {

        try {
            inetAddr = InetAddress.getLocalHost();
            socket = new Socket(inetAddr, 9999);
            inObject = new ObjectInputStream(socket.getInputStream());
            outObject = new ObjectOutputStream(socket.getOutputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendCommunicationObject(CommunicationObject communicationObject){
        try {
            outObject.writeObject(communicationObject);
            outObject.reset();
            //outObject.flush(); //proba
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CommunicationObject receiveCommunicationObject(){
        CommunicationObject communicationObject = null;
        try {
            communicationObject = (CommunicationObject)inObject.readObject();
        } catch (IOException eio){
            eio.fillInStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return communicationObject;
    }

    //    public LinkedList<Stick> receiveObject(){
//        LinkedList<Stick> sticks = null;
//        try {
//            sticks = (LinkedList<Stick>)inObject.readObject();
//
//        } catch (IOException eio){
//            eio.fillInStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return sticks;
//    }

    public static void main(String[] args){

            Client clientInst = new Client(args[0]);
            MainForm GUI = new MainForm(clientInst);

    }
}