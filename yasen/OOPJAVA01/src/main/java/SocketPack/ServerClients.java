package SocketPack;

        import java.io.PrintWriter;
        import java.util.ArrayList;

public class ServerClients {

    ArrayList<PrintWriter> ClientsOutList = new ArrayList<PrintWriter>();

    public void addClientsOut(PrintWriter out){
        ClientsOutList.add(out);
    }

    public void RemoveClientsOut(PrintWriter out){
        ClientsOutList.remove(out);
    }

    public void SendClientsOut(String message){
        for (PrintWriter item : ClientsOutList) {
            item.println(message);
        }
    }

    public int CountClients(){
        return ClientsOutList.size();
    }
}
