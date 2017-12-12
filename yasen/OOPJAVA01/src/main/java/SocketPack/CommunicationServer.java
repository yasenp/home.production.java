package SocketPack; /**
 * Created by Yassen on 8/21/2017.
 */

import java.io.*;
import java.net.Socket;

public class CommunicationServer extends Thread {

    //Create socket object to be assigned.
    Socket socket = null;
    String state = "WAITING";
    PrintWriter out;
    BufferedReader in;
    ObjectInputStream inObject;
    ObjectOutputStream outObject;
    CommunicationServerProtocol serverProtocol;
    ServerClients clients;
    LinesPanel linesPanel;

    //CommunicationServer constructor with specific client socket as argument.
    public CommunicationServer(Socket socket, ServerClients serverClients, LinesPanel linesPanel) {
        this.socket = socket;
        this.clients = serverClients;
        this.linesPanel = linesPanel;
        try {
            //out / in socket for string stream
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //out / in socket for object stream
            outObject = new ObjectOutputStream(socket.getOutputStream());
            //inObject = new ObjectInputStream(socket.getInputStream());

            clients.addClientsOut(out);
            clients.addClientsOut(outObject);

            serverProtocol = new CommunicationServerProtocol();
        } catch(IOException eio){
            eio.fillInStackTrace();
        }
    }

    //Override run() from super class Thread.
    public void run() {
        System.out.println("Server is started and ready for listening on port 9999");
            String input = null;
        try {
            while (true) {
                input = in.readLine();
                if(input != null){
                    if(input.equals("START")){
                        clients.SendClientsOut(linesPanel);
                    } else{
                    String processedInput = serverProtocol.processState(input);
                    clients.SendClientsOut(processedInput);
                    }
                }
            }
        } catch(IOException e){
                e.getMessage();
        }
    }
}

