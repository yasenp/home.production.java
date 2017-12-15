package SocketPack; /**
 * Created by Yassen on 8/21/2017.
 */

import AppUIPack.CommunicationObject;
import AppUIPack.LinesPanel;
import sun.invoke.empty.Empty;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class CommunicationServer extends Thread {

    //Create socket object to be assigned.
    Socket socket = null;
    String state = "WAITING";
    ObjectInputStream inObject;
    ObjectOutputStream outObject;
    int id;
    CommunicationServerProtocol serverProtocol;
    ServerClients clients;
    public static Boolean isStarted = true;
    public static CommunicationObject communicationObjectServer;

    private static LinkedList<Stick> sticks = new LinkedList<Stick>();

    //CommunicationServer constructor with specific client socket as argument.
    public CommunicationServer(Socket socket, ServerClients serverClients, int idcon) {
        this.socket = socket;
        this.clients = serverClients;
        this.id = idcon;

        try {

            //out / in socket for object stream
            outObject = new ObjectOutputStream(socket.getOutputStream());
            inObject = new ObjectInputStream(socket.getInputStream());


            clients.addClientsOut(id, outObject);
            communicationObjectServer = new CommunicationObject();
            communicationObjectServer.SetClientId(id);
            outObject.writeObject(communicationObjectServer);
            outObject.reset();

            serverProtocol = new CommunicationServerProtocol();
        } catch(IOException eio){
            eio.fillInStackTrace();
        }
    }

    //Override run() from super class Thread.
    public void run() {
        System.out.println("Server is started and ready for listening on port 9999");
        CommunicationObject input;

        try {
            while (true) {
                input = (CommunicationObject) inObject.readObject();

                if(input != null){
                    if(input.GetFlag().equals("start playground")) {
                        if(isStarted){
                            input.SetStick(sticks);
                            isStarted = false;
                            clients.addClientsOutCurrentGame(input.GetClientId());
                            clients.SendSingleCommunicationObjectsOut(input);
                            setCommunicationObject(input);
                        } else {
                            continue;
                            //input.SetStick(new LinkedList<>());
                            //clients.SendSingleCommunicationObjectsOut(input);
                        }

                    } else if(input.GetFlag().equals("playground")) {
                        setCommunicationObject(input);
                        clients.SendCommunicationObjectsOutCurrentGame(input);
                    } else if(input.GetFlag().equals("join playground")){
                            clients.addClientsOutCurrentGame(input.GetClientId());
                            clients.SendCommunicationObjectsOutCurrentGame(getCommunicationObject());
                    } else{
                    //String processedInput = serverProtocol.processState(input.GetText());
                    //communicationObjectServer = input;
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

    public static synchronized void CreateSticksCollection(){
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

    public static synchronized CommunicationObject getCommunicationObject(){
        return communicationObjectServer;
    }

    public static synchronized void setCommunicationObject(CommunicationObject communicationObject){
        communicationObjectServer = communicationObject;
    }
//    public ArrayList<CommunicationObject> readAll(CommunicationObject input) throws IOException, ClassNotFoundException {
//        ArrayList<CommunicationObject> inputs = new ArrayList<CommunicationObject>();
//        try {
//
//            //input = (CommunicationObject) inObject.readObject();
//            inputs.add(input);
//        } catch (NullPointerException e) {
//            e.getMessage();
//        }
//        return inputs;
//    }

/*    public void addStick(int x1, int y1, int x2, int y2){
        sticks.add(new Stick(x1, y1, x2, y2));
    }*/
}

