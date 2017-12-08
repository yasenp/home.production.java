package SocketPack;

import AppUIPack.MainForm;
import sun.applet.Main;

import javax.swing.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Yassen on 8/24/2017.
 */
public class Client {

    String name;

    public Client(String name){
        this.name = name;
    }

    public static void main(String[] args){

        try (
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            BufferedReader output = new BufferedReader(new InputStreamReader(System.in));
            out.println("CORRECTREQUEST");
            String input = in.readLine();
            String fromClient;
            Client currentClient = new Client(args[0]);
            JFrame frame = new JFrame();

            MainForm.CreateMainForm().CreatePanel();

            while(input != null){
                if(input.equals("ACCEPTED")){

                    out.println(currentClient);
                }
                if(input.equals("DISCONNECT")) break;

                System.out.println(input);
                System.out.print(currentClient.name + ":");
                out.println(output.readLine());
            }
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
