package SocketPack; /**
 * Created by Yassen on 8/21/2017.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CommunicationServer extends Thread{

    //Create socket object to be assigned.
    Socket socket = null;
    String state = "WAITING";

    //CommunicationServer constructor with specific client socket as argument.
    public CommunicationServer(Socket socket){
        this.socket = socket;
    }

    //Override run() from super class Thread.
    public void run() {
        System.out.println("Server is started and ready for listening on port 9999");
        try{
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String input = state;
            CommunicationServerProtocol serverProtocol = new CommunicationServerProtocol();

            if((input = in.readLine()) != null){
                String processedState = serverProtocol.processState(state);
                out.println(processedState);
            } else {
                socket.close();
            }
    }   catch(IOException e){
            e.getMessage();
        }
    }
}
