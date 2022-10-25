package GUI.CloudControllerGUI;

import javax.swing.*;

import GUI.ButtonListeners.cloudControllerListener;

import java.awt.*;
import java.awt.event.ActionListener;

public class HistoryFrame {

    JFrame dashboard = new JFrame("Pending Application Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel historyTitlePanel = new JPanel();
    JPanel historyPanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Job History");

    JLabel historyTitle = new JLabel("Jobs History");
    JLabel history = new JLabel("No Job History");

    JButton returnButton = new JButton("Return");

    public HistoryFrame() {
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

        historyTitlePanel.setBackground(Color.LIGHT_GRAY);
        historyTitlePanel.setBounds(225, 200, 750, 50);
        historyTitle.setBounds(550, 200, 50, 50);
        historyTitlePanel.add(historyTitle);

        historyPanel.setBackground(Color.LIGHT_GRAY);
        historyPanel.setBounds(225, 250, 750, 350);
        history.setBounds(550, 250, 750, 350);
        historyPanel.add(history);

        returnPanel.setBounds(550, 650, 100, 50);
        ActionListener cloud = new cloudControllerListener();
        returnButton.addActionListener(cloud);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.setVisible(true);
        dashboard.add(historyTitlePanel);
        dashboard.add(historyPanel);
        dashboard.add(returnPanel);
    }

}
