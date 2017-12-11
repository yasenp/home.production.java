package AppUIPack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public interface UIActions {


     class SendText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    class RecvText implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }

    public ActionListener SendText();

    public ActionListener RecvText();

}
