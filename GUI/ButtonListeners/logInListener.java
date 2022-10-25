package GUI.ButtonListeners;

import GUI.Start.LogInFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class logInListener implements ActionListener {
    // Goes back to login Dashboard
    public void actionPerformed(ActionEvent e) {
        LogInFrame logInDashboard = new LogInFrame();
    }
}
