package GUI.CloudControllerGUI;

import javax.swing.*;

import GUI.Start.LogInFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class CloudControllerDashboard {

    // The Frame that will hold the entire dashboard
    JFrame dashboard = new JFrame("Cloud Controller Dashboard");

    // panels
    JPanel logoPanel = new JPanel();
    JPanel homePanel = new JPanel();
    JPanel pendingApplicationsPanel = new JPanel();
    JPanel jobsInProgressPanel = new JPanel();
    JPanel historyPanel = new JPanel();
    JPanel userDataPanel = new JPanel();
    JPanel profile = new JPanel();
    JPanel listOfVehiclesPanel = new JPanel();

    // Buttons
    JButton homeButton = new JButton("Home");
    JButton pendingApplicationsButton = new JButton("Pending Applications");
    JButton jobsInProgressButton = new JButton("Jobs in Progress");
    JButton historyButton = new JButton("History");
    JButton userDataButton = new JButton("User Data");
    JButton profileButton = new JButton("Profile");
    JButton vehicleListButton = new JButton("List of Vehicles");

    // labels
    JLabel logoLabel = new JLabel(new ImageIcon("GUI/Assets/logo.png"));

    public CloudControllerDashboard() {

        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // panels
        logoPanel.setBackground(new Color(41, 55, 77));
        logoPanel.setBounds(30, 20, 300, 150);
        logoPanel.add(logoLabel);

        homePanel.setBackground(new Color(205, 205, 205));
        homePanel.setBounds(100, 260, 175, 50);

        pendingApplicationsPanel.setBackground(new Color(205, 205, 205));
        pendingApplicationsPanel.setBounds(100, 360, 175, 50);

        jobsInProgressPanel.setBackground(new Color(205, 205, 205));
        jobsInProgressPanel.setBounds(100, 460, 175, 50);

        historyPanel.setBackground(new Color(205, 205, 205));
        historyPanel.setBounds(100, 560, 175, 50);

        userDataPanel.setBackground(new Color(205, 205, 205));
        userDataPanel.setBounds(100, 660, 175, 50);

        profile.setBackground(new Color(205, 205, 205));
        profile.setBounds(1000, 30, 175, 50);

        listOfVehiclesPanel.setBackground(new Color(205, 205, 205));
        listOfVehiclesPanel.setBounds(300, 260, 175, 50);

        // home button configuration
        homeButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homePanel.add(homeButton);

        // pending applications button configuration
        pendingApplicationsButton.setFont(new Font("Monospaced", Font.BOLD, 14));
        pendingApplicationsButton.setOpaque(false);
        pendingApplicationsButton.setContentAreaFilled(false);
        pendingApplicationsButton.setBorderPainted(false);
        pendingApplicationsPanel.add(pendingApplicationsButton);

        // jobs in progress button configuration
        jobsInProgressButton.setFont(new Font("Monospaced", Font.BOLD, 17));
        jobsInProgressButton.setOpaque(false);
        jobsInProgressButton.setContentAreaFilled(false);
        jobsInProgressButton.setBorderPainted(false);
        jobsInProgressPanel.add(jobsInProgressButton);

        // history button configuration
        historyButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        historyButton.setOpaque(false);
        historyButton.setContentAreaFilled(false);
        historyButton.setBorderPainted(false);
        historyPanel.add(historyButton);

        // user data button configuration
        userDataButton.setFont(new Font("Monospaced", Font.BOLD, 32));
        userDataButton.setOpaque(false);
        userDataButton.setContentAreaFilled(false);
        userDataButton.setBorderPainted(false);
        userDataPanel.add(userDataButton);

        // profile button configuration
        profileButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setBorderPainted(false);
        profile.add(profileButton);

        // list of vehicles button configuration
        vehicleListButton.setFont(new Font("Monospaced", Font.BOLD, 17));
        vehicleListButton.setOpaque(false);
        vehicleListButton.setContentAreaFilled(false);
        vehicleListButton.setBorderPainted(false);
        listOfVehiclesPanel.add(vehicleListButton);

        // action listeners
        ActionListener goToLogin = new logInListener();
        homeButton.addActionListener(goToLogin);
        homeButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToPendingApps = new pendingAppsListener();
        pendingApplicationsButton.addActionListener(goToPendingApps);
        pendingApplicationsButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToJIPS = new JIPListener();
        jobsInProgressButton.addActionListener(goToJIPS);
        jobsInProgressButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToHistory = new historyListener();
        historyButton.addActionListener(goToHistory);
        historyButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToVehicleList = new vehicleListListener();
        vehicleListButton.addActionListener(goToVehicleList);
        vehicleListButton.addActionListener(e -> {
            dashboard.dispose();
        });

        dashboard.add(logoPanel);
        dashboard.add(homePanel);
        dashboard.add(pendingApplicationsPanel);
        dashboard.add(jobsInProgressPanel);
        dashboard.add(historyPanel);
        dashboard.add(userDataPanel);
        dashboard.add(profile);
        dashboard.add(listOfVehiclesPanel);

        dashboard.setVisible(true);
    }
}

// Goes back to login Dashboard
class logInListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        LogInFrame logInDashboard = new LogInFrame();
    }
}

// Returns pending applications
class pendingAppsListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        PendingAppsFrame pendingAppsDashboard = new PendingAppsFrame();
    }
}

// Returns jobs in progress
class JIPListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            JobsInProgressFrame jipDashboard = new JobsInProgressFrame();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

// Returns job history
class historyListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        HistoryFrame historyDashboard = new HistoryFrame();
    }
}

// Returns user data
class userDataListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {

    }
}

// Returns job history
class vehicleListListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            VehicleListFrame vehicleListDashboard = new VehicleListFrame();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
