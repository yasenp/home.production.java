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

    public String GetText(){
        return this.text;
    }

    public void SetText(String text){
        this.text = text;
    }

    public LinkedList<Stick> GetStick(){
        return this.sticks;
    }

    public void SetStick(LinkedList<Stick> sticks){
        this.sticks = sticks;
    }

    public String GetFlag(){
        return this.flag;
    }

    public void SetFlag(String flag){
        this.flag = flag;
    }
}
