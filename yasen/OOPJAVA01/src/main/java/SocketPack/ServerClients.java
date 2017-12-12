package SocketPack;

        import java.io.IOException;
        import java.io.ObjectOutputStream;
        import java.io.PrintWriter;
        import java.util.ArrayList;

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

    public void SendClientsOut(LinesPanel linesPanel){
        for (ObjectOutputStream item : ClientsOutObjectList) {
            try{
                item.writeObject(linesPanel);
            }catch (IOException ioe){
                ioe.getMessage();
            }
        }
    }

    public int CountClients(){
        return ClientsOutList.size();
    }
}
