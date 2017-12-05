package SocketPack;

/**
 * Created by Yassen on 8/27/2017.
 */
public class CommunicationServerProtocol {

    private String stateValue = "";

    public String processState(String state){

        if(state.equals("WAITING")){
            stateValue = "ACCEPTED";
        } else if(state.equals("TRYING")){
            stateValue = "DECLINED";
        }

        if(state.equals("EXECUTE")){
            stateValue = "START";
        } else if(state.equals("FINISH")){
            stateValue = "STOP";
        }

        return stateValue;
    }

}
