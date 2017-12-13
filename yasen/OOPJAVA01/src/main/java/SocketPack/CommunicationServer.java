package SocketPack; /**
 * Created by Yassen on 8/21/2017.
 */

import AppUIPack.CommunicationObject;
import AppUIPack.LinesPanel;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Random;

public class CommunicationServer extends Thread {

    //Create socket object to be assigned.
    Socket socket = null;
    String state = "WAITING";
    PrintWriter out;
    //BufferedReader in;
    ObjectInputStream inObject;
    ObjectOutputStream outObject;
    CommunicationServerProtocol serverProtocol;
    ServerClients clients;
    LinesPanel linesPanel;

    private static LinkedList<Stick> sticks = new LinkedList<Stick>();

    //CommunicationServer constructor with specific client socket as argument.
    public CommunicationServer(Socket socket, ServerClients serverClients) {
        this.socket = socket;
        this.clients = serverClients;

        try {

            //out / in socket for object stream
            outObject = new ObjectOutputStream(socket.getOutputStream());
            inObject = new ObjectInputStream(socket.getInputStream());

            clients.addClientsOut(outObject);

            serverProtocol = new CommunicationServerProtocol();
        } catch(IOException eio){
            eio.fillInStackTrace();
        }
    }

    //Override run() from super class Thread.
    public void run() {
        System.out.println("Server is started and ready for listening on port 9999");
            CommunicationObject input = null;
        try {
            while (true) {
                input = (CommunicationObject) inObject.readObject();
                if(input != null){
                    if(input.GetFlag().equals("start playground")) {
                        input.SetStick(sticks);
                        clients.SendCommunicationObjectsOut(input);
                    } else if(input.GetFlag().equals("playground")){
                            clients.SendCommunicationObjectsOut(input);
                        } else{
                    //String processedInput = serverProtocol.processState(input.GetText());
                    clients.SendCommunicationObjectsOut(input);
                    }
                }
            }
        } catch(IOException e){
                e.getMessage();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void CreateSticksCollection(){
        Random randomMain = new Random();
        for (int i = 0; i <= 20; i++) {
            int angle = (60 + randomMain.nextInt(120));
            int x1 = (int) (600/5 + 120 * Math.sin(angle))+200;
            int y1 = (int) (600/5 + 120 * Math.cos(angle))+200;
            int x2 = (int) (x1 + 300 * Math.cos(angle));
            int y2 = (int) (y1 + 200 * Math.sin(angle));
            sticks.add(new Stick(x1, y1, x2, y2));
        }
    }

    public void addStick(int x1, int y1, int x2, int y2){
        sticks.add(new Stick(x1, y1, x2, y2));
    }
}

