package SocketPack;

import AppUIPack.CommunicationObject;
import AppUIPack.LinesPanel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Yassen on 8/24/2017.
 */
public class ProgramManager {

    public static void main(String args[]){
        ServerClients serverClients = new ServerClients();
        CommunicationServer.CreateSticksCollection();
        int idcon = 0;
        try(ServerSocket serverSocket = new ServerSocket(9999)){
            while(true){
                Socket socket = serverSocket.accept();
                new CommunicationServer(socket, serverClients, idcon).start();
                idcon++;
        }
    } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
