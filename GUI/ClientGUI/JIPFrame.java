package GUI.ClientGUI;

import GUI.ButtonListeners.cloudControllerListener;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JIPFrame {
    JFrame dashboard = new JFrame("Pending Application Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel JIPTitlePanel = new JPanel();
    JPanel JIPPanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Jobs In Progress");
    JLabel JIPTitle = new JLabel("Jobs In Progress");
    JLabel JIPS = new JLabel("No Current Jobs");

    JButton returnButton = new JButton("Return");

    public JIPFrame() {
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting up the title of the frame.
        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 600, 150);
        dashboardTitle.setForeground(Color.white);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);
        dashboard.add(titlePanel);

        JIPTitlePanel.setBackground(Color.LIGHT_GRAY);
        JIPTitlePanel.setBounds(225, 200, 750, 50);
        JIPTitle.setBounds(550, 200, 50, 50);
        JIPTitlePanel.add(JIPTitle);

        JIPPanel.setBackground(Color.LIGHT_GRAY);
        JIPPanel.setBounds(225, 250, 750, 350);
        JIPS.setBounds(550, 250, 750, 350);
        JIPPanel.add(JIPS);

        returnPanel.setBounds(550, 650, 100, 50);

        ActionListener client = new clientDashboardListener();
        returnButton.addActionListener(client);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.add(JIPTitlePanel);
        dashboard.add(JIPPanel);
        dashboard.add(returnPanel);

        dashboard.setVisible(true);

    }

}

class clientDashboardListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        ClientDashboard clientDash = new ClientDashboard();
    }
}