package SocketPack;

        import AppUIPack.CommunicationObject;
        import AppUIPack.LinesPanel;

        import java.io.IOException;
        import java.io.ObjectOutputStream;
        import java.io.PrintWriter;
        import java.util.*;

public class ServerClients {

    ArrayList<PrintWriter> ClientsOutList = new ArrayList<PrintWriter>();
    LinkedList<ObjectOutputStream> ClientsOutObjectList = new LinkedList<>();
    LinkedList<ObjectOutputStream> ClientsOutObjectCurrentGameList = new LinkedList<>();
    int id = 0;

    public void addClientsOut(PrintWriter out){
        ClientsOutList.add(out);
    }

    //overwriting
    public void addClientsOut(int idcon, ObjectOutputStream out){
        ClientsOutObjectList.add(idcon, out);
    }

    //overwriting
    public void addClientsOutCurrentGame(int idcon){
        if(ClientsOutObjectCurrentGameList.size() != ClientsOutObjectList.size()){
            ClientsOutObjectCurrentGameList.add(ClientsOutObjectList.get(idcon));
        }
    }

    public void SendCommunicationObjectsOut(CommunicationObject communicationObject){


        Iterator<ObjectOutputStream> itr = ClientsOutObjectList.iterator();
        while(itr.hasNext()){
            ObjectOutputStream objectOut = itr.next();
            try {
                objectOut.writeObject(communicationObject);
                objectOut.reset();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void SendSingleCommunicationObjectsOut(CommunicationObject communicationObject){
        int index = communicationObject.GetClientId();
        try {
            ClientsOutObjectList.get(index).writeObject(communicationObject);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SendCommunicationObjectsOutCurrentGame(CommunicationObject communicationObject){

        Iterator<ObjectOutputStream> itr = ClientsOutObjectCurrentGameList.iterator();
        while(itr.hasNext()){
            ObjectOutputStream objectOut = itr.next();
            try {
                objectOut.writeObject(communicationObject);
                objectOut.reset();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
