package SocketPack;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * Created by Yassen on 8/24/2017.
 */
public class ProgramManager {

    public static void main(String args[]){

        try(ServerSocket serverSocket = new ServerSocket(9999)){
            while(true){
                new CommunicationServer(serverSocket.accept()).start();
            }

        } catch (IOException ioe){
            ioe.getMessage();
        }
    }
}
