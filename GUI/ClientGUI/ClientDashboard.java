package GUI.ClientGUI;

import javax.swing.*;

import BackEnd.Entities.CloudController;
import GUI.ButtonListeners.logInListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ClientDashboard {

    // The Frame that will hold the entire dashboard
    JFrame dashboard = new JFrame("Client Dashboard");

    // Creating multiple panels that will represent options on a menu
    JPanel logoPanel = new JPanel();
    JPanel homePanel = new JPanel();
    JPanel submitJobPanel = new JPanel();
    JPanel JobsInProgressPanel = new JPanel();
    JPanel historyPanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JPanel profilePanel = new JPanel();
    JPanel notificationPanel = new JPanel();

    // Label for "Home" option
    JButton homeButton = new JButton("Home");
    JButton submitJobButton = new JButton("Submit a Job");
    JButton jobsInProgressButton = new JButton("View my Jobs");
    JButton statusButton = new JButton("Status");
    JButton settingsButton = new JButton("Settings");
    JButton profileButton = new JButton("Profile");

    JLabel logoLabel = new JLabel(new ImageIcon("GUI/Assets/logo.png"));
    JLabel update = new JLabel("You have an update on your Job Applications. Please press Status");

    public ClientDashboard() {

        // dimensions and features of dashboard
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting background of the panels
        logoPanel.setBackground(new Color(41, 55, 77));
        logoPanel.setBounds(30, 20, 300, 150);
        logoPanel.add(logoLabel);

        homePanel.setBackground(new Color(205, 205, 205));
        homePanel.setBounds(100, 260, 175, 50);

        submitJobPanel.setBackground(new Color(205, 205, 205));
        submitJobPanel.setBounds(100, 360, 175, 50);

        JobsInProgressPanel.setBackground(new Color(205, 205, 205));
        JobsInProgressPanel.setBounds(100, 460, 175, 50);

        historyPanel.setBackground(new Color(205, 205, 205));
        historyPanel.setBounds(100, 560, 175, 50);

        settingsPanel.setBackground(new Color(205, 205, 205));
        settingsPanel.setBounds(100, 660, 175, 50);

        profilePanel.setBackground(new Color(205, 205, 205));
        profilePanel.setBounds(1000, 30, 175, 50);

        notificationPanel.setBackground(new Color(205, 205, 205));
        notificationPanel.setBounds(450, 350, 650, 50);

        // home button configuration
        homeButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homePanel.add(homeButton);

        // submit a job button configuration
        submitJobButton.setFont(new Font("Monospaced", Font.BOLD, 22));
        submitJobButton.setOpaque(false);
        submitJobButton.setContentAreaFilled(false);
        submitJobButton.setBorderPainted(false);
        submitJobPanel.add(submitJobButton);

        // jobs in progress button configuration
        jobsInProgressButton.setFont(new Font("Monospaced", Font.BOLD, 17));
        jobsInProgressButton.setOpaque(false);
        jobsInProgressButton.setContentAreaFilled(false);
        jobsInProgressButton.setBorderPainted(false);
        JobsInProgressPanel.add(jobsInProgressButton);

        // history button configuration
        statusButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        statusButton.setOpaque(false);
        statusButton.setContentAreaFilled(false);
        statusButton.setBorderPainted(false);
        historyPanel.add(statusButton);

        // settings button configuration
        settingsButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsPanel.add(settingsButton);

        // profile button configuration
        profileButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setBorderPainted(false);
        profilePanel.add(profileButton);

        // button listeners
        ActionListener goToLogin = new logInListener();
        homeButton.addActionListener(goToLogin);
        homeButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToSubmit = new submitAJobListener();
        submitJobButton.addActionListener(goToSubmit);
        submitJobButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToJIP = new jobsInProgressListener();
        jobsInProgressButton.addActionListener(goToJIP);
        jobsInProgressButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener status = new jobStatusListener();
        statusButton.addActionListener(status);
        statusButton.addActionListener(e -> {
            dashboard.dispose();
        });

        CloudController cc = new CloudController();
        if (cc.getDeclinedJobs().size() > 0) {
            notificationTrue();
        }

        dashboard.add(logoPanel);
        dashboard.add(homePanel);
        dashboard.add(submitJobPanel);
        dashboard.add(JobsInProgressPanel);
        dashboard.add(historyPanel);
        dashboard.add(settingsPanel);
        dashboard.add(profilePanel);

        dashboard.setVisible(true);
    }

    public void notificationTrue() {
        update.setFont(new Font("Monospaced", Font.BOLD, 15));
        notificationPanel.add(update);
        dashboard.add(notificationPanel);
    }
}

class submitAJobListener implements ActionListener {
    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        try {
            ClientSubmission logInDashboard = new ClientSubmission();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

class jobsInProgressListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            ViewJobsFrame JIP = new ViewJobsFrame();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

// Register a Vehicle Button
class jobStatusListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        JobStatusFrame status = new JobStatusFrame();
    }
}
