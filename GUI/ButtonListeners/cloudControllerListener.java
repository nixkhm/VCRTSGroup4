package GUI.ButtonListeners;

import GUI.CloudControllerGUI.CloudControllerDashboard;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cloudControllerListener implements ActionListener {
    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        CloudControllerDashboard cloudController = new CloudControllerDashboard();
    }
}
