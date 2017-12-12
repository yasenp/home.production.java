package SocketPack;

        import AppUIPack.CommunicationObject;
        import AppUIPack.LinesPanel;

        import java.io.IOException;
        import java.io.ObjectOutputStream;
        import java.io.PrintWriter;
        import java.util.ArrayList;
        import java.util.LinkedList;

public class ServerClients {

    ArrayList<PrintWriter> ClientsOutList = new ArrayList<PrintWriter>();
    ArrayList<ObjectOutputStream> ClientsOutObjectList = new ArrayList<ObjectOutputStream>();

    public void addClientsOut(PrintWriter out){
        ClientsOutList.add(out);
    }

    //overwriting
    public void addClientsOut(ObjectOutputStream out){
        ClientsOutObjectList.add(out);
    }

    //overwriting
    public void RemoveClientsOut(ObjectOutputStream out){
        ClientsOutObjectList.remove(out);
    }

    public void RemoveClientsOut(PrintWriter out){
        ClientsOutList.remove(out);
    }

    public void SendClientsOut(String message){
        for (PrintWriter item : ClientsOutList) {
            item.println(message);
        }
    }

    public void SendClientsOut(LinkedList<Stick> sticks){
        for (ObjectOutputStream item : ClientsOutObjectList) {
            try{
                item.writeObject(sticks);
            }catch (IOException ioe){
                ioe.getMessage();
            }
        }
    }

    public void SendCommunicationObjectsOut(CommunicationObject communicationObject){

        for (ObjectOutputStream item : ClientsOutObjectList) {
            try{
                item.writeObject(communicationObject);
            }catch (IOException ioe){
                ioe.getMessage();
            }
        }
    }

    public int CountClients(){
        return ClientsOutList.size();
    }
}
