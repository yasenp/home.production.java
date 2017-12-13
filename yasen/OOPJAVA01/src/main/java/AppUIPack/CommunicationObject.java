package AppUIPack;

import SocketPack.Stick;

import java.io.Serializable;
import java.util.LinkedList;

public class CommunicationObject implements Serializable {

//    public final static String start = "START";
//    public final static String stop = "STOP";

    private String text;
    LinkedList<Stick> sticks;
    private String flag;
    private String clientName;
    Boolean typeGame = true;

    public CommunicationObject(){

    }

    public CommunicationObject(String text){
        SetText(text);
        SetFlag("message");
    }

    public CommunicationObject(LinkedList<Stick> sticks){
        SetStick(sticks);
        if(sticks.isEmpty()){
            SetFlag("start playground");
        } else {
            SetFlag("playground");
        }
    }

    public synchronized CommunicationObject CreateCommunicationObject(String clientName){
        SetCurrentName(clientName);
        return this;
    }

    public synchronized CommunicationObject AddMessageCommunication(String text){
        SetText(text);
        SetFlag("message");
        return this;
    }

    public synchronized CommunicationObject AddSticksCommunication(LinkedList<Stick> sticks){
        SetStick(sticks);

        if(sticks.isEmpty() && typeGame == true) {
            SetFlag("start playground");
            typeGame = false;
        }  else if(sticks.isEmpty() && typeGame == false){
            SetFlag("join playground");
        } else {
            SetFlag("playground");
        }
        return this;
    }

    public synchronized String GetCurrentName(){
        return this.clientName;
    }

    public synchronized void SetCurrentName(String clientName){
        this.clientName = clientName;
    }

    public synchronized String GetText(){
        return this.text;
    }

    public synchronized void SetText(String text){
        this.text = text;
    }

    public synchronized LinkedList<Stick> GetStick(){
        return this.sticks;
    }

    public synchronized void SetStick(LinkedList<Stick> sticks){
        this.sticks = sticks;
    }

    public synchronized String GetFlag(){
        return this.flag;
    }

    public synchronized void SetFlag(String flag){
        this.flag = flag;
    }
}
