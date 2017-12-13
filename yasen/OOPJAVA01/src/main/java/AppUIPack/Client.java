package AppUIPack;

import SocketPack.Stick;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;

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
    ObjectOutputStream outObject;
    InetAddress inetAddr;
    String serverAddress;
    CommunicationObject commObj;
    //LinkedList<Stick> sticks;

    public Client(String name){
        this.name = name;
        InitClient();
    }

    public void InitClient() {

        try {
            //inetAddr = InetAddress.getByName(serverAddress);
            inetAddr = InetAddress.getLocalHost();
            socket = new Socket(inetAddr, 9999);
            //out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            //in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            inObject = new ObjectInputStream(socket.getInputStream());
            outObject = new ObjectOutputStream(socket.getOutputStream());
            //BufferedReader output = new BufferedReader(new InputStreamReader(System.in));
            //out.println("CORRECTREQUEST");



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendObject(CommunicationObject communicationObject){
        try {
            outObject.writeObject(communicationObject);
            outObject.reset();
            //outObject.flush(); //proba
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public static void main(String[] args){

            Client clientInst = new Client(args[0]);
            MainForm GUI = new MainForm(clientInst);

    }
}