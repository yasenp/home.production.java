package SocketPack;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Yassen on 8/24/2017.
 */
public class ProgramManager {

    public static void main(String args[]){
        ServerClients serverClients = new ServerClients();
        try(ServerSocket serverSocket = new ServerSocket(9999)){
            while(true){
                new CommunicationServer(serverSocket.accept(), serverClients).start();
            }

        } catch (IOException ioe){
            ioe.getMessage();
        }
    }
}
