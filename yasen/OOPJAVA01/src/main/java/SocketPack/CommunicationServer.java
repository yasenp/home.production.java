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
    CommunicationServerProtocol serverProtocol;
    ServerClients clients;

    //CommunicationServer constructor with specific client socket as argument.
    public CommunicationServer(Socket socket, ServerClients serverClients) {
        this.socket = socket;
        this.clients = serverClients;
        try {
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            clients.addClientsOut(out);
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
                    String processedInput = serverProtocol.processState(input);
                    clients.SendClientsOut(processedInput);
                }
            }
        } catch(IOException e){
                e.getMessage();
        }
    }
}

