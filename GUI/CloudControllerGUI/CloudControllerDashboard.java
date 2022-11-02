package GUI.CloudControllerGUI;

import javax.swing.*;
import GUI.ClientGUI.JIPFrame;
import GUI.Start.LogInFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.*;
import java.time.format.*;

class logInListener implements ActionListener {
    // Goes back to login Dashboard
    public void actionPerformed(ActionEvent e) {
        LogInFrame logInDashboard = new LogInFrame();
    }
}

class pendingAppsListener implements ActionListener {
    // Returns pending applications
    public void actionPerformed(ActionEvent e) {
        PendingAppsFrame pendingAppsDashboard = new PendingAppsFrame();
    }
}

class JIPListener implements ActionListener {
    // Returns jobs in progress
    public void actionPerformed(ActionEvent e) {
        JIPFrame jipDashboard = new JIPFrame();
    }
}

class historyListener implements ActionListener {
    // Returns job history
    public void actionPerformed(ActionEvent e) {
        HistoryFrame historyDashboard = new HistoryFrame();
    }
}

class userDataListener implements ActionListener {
    // Returns user data
    public void actionPerformed(ActionEvent e) {

    }
}

class vehicleListListener implements ActionListener {
    // Returns job history
    public void actionPerformed(ActionEvent e) {
        try {
            VehicleListFrame vehicleListDashboard = new VehicleListFrame();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

public class CloudControllerDashboard {
    // this is a template to go by to organize the Panels, variable names will be
    // modified accordingly

    // The Frame that will hold the entire dashboard
    JFrame dashboard = new JFrame("Cloud Controller Dashboard");

    // Creating multiple panels that will represent options on a menu
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();
    JPanel panel8 = new JPanel();

    // Buttons
    JButton homeLabel = new JButton("Home");
    JButton pendingAppsLabel = new JButton("Pending Applications");
    JButton JIPLabel = new JButton("Jobs in Progress");
    JButton historyLabel = new JButton("History");
    JButton userDataLabel = new JButton("User Data");
    JButton userLabel = new JButton("Profile");
    JButton vehicleListLabel = new JButton("List of Vehicles");

    // labels
    JLabel logoLabel = new JLabel(new ImageIcon("GUI/Assets/logo.png"));
    JLabel greetingUser = new JLabel("Hello, [username_goes_here]!");
    JPanel greetingUserCard = new JPanel();

    public CloudControllerDashboard() {

        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting background of the panels
        panel.setBackground(new Color(41, 55, 77));
        panel2.setBackground(new Color(205, 205, 205));
        panel3.setBackground(new Color(205, 205, 205));
        panel4.setBackground(new Color(205, 205, 205));
        panel5.setBackground(new Color(205, 205, 205));
        panel6.setBackground(new Color(205, 205, 205));
        panel7.setBackground(new Color(205, 205, 205));
        panel8.setBackground(new Color(205, 205, 205));
        // Logo Panel
        panel.setBounds(30, 20, 300, 150);

        // Options Panel
        panel2.setBounds(100, 260, 175, 50);
        panel3.setBounds(100, 360, 175, 50);
        panel4.setBounds(100, 460, 175, 50);
        panel5.setBounds(100, 560, 175, 50);
        panel6.setBounds(100, 660, 175, 50);
        panel8.setBounds(300,260,175,50);

        // user Panel
        panel7.setBounds(1000, 30, 175, 50);

        // Label for "Home" option
        homeLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        homeLabel.setOpaque(false);
        homeLabel.setContentAreaFilled(false);
        homeLabel.setBorderPainted(false);
        panel2.add(homeLabel);

        ActionListener goToLogin = new logInListener();
        homeLabel.addActionListener(goToLogin);
        homeLabel.addActionListener(e -> {
            dashboard.dispose();
        });

        // Label for "Pending Applications" option
        pendingAppsLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        pendingAppsLabel.setOpaque(false);
        pendingAppsLabel.setContentAreaFilled(false);
        pendingAppsLabel.setBorderPainted(false);
        panel3.add(pendingAppsLabel);

        ActionListener goToPendingApps = new pendingAppsListener();
        pendingAppsLabel.addActionListener(goToPendingApps);
        pendingAppsLabel.addActionListener(e -> {
            dashboard.dispose();
        });

        // Label for "Jobs in Progress" option
        JIPLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
        JIPLabel.setOpaque(false);
        JIPLabel.setContentAreaFilled(false);
        JIPLabel.setBorderPainted(false);
        panel4.add(JIPLabel);

        ActionListener goToJIPS = new JIPListener();
        JIPLabel.addActionListener(goToJIPS);
        JIPLabel.addActionListener(e -> {
            dashboard.dispose();
        });

        // Label for "History" option
        historyLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        historyLabel.setOpaque(false);
        historyLabel.setContentAreaFilled(false);
        historyLabel.setBorderPainted(false);
        panel5.add(historyLabel);

        ActionListener goToHistory = new JIPListener();
        historyLabel.addActionListener(goToHistory);
        historyLabel.addActionListener(e -> {
            dashboard.dispose();
        });

        // Label for "User Data" option
        userDataLabel.setFont(new Font("Monospaced", Font.BOLD, 32));
        userDataLabel.setOpaque(false);
        userDataLabel.setContentAreaFilled(false);
        userDataLabel.setBorderPainted(false);
        panel6.add(userDataLabel);

        // Label for "Profile" option
        userLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        userLabel.setOpaque(false);
        userLabel.setContentAreaFilled(false);
        userLabel.setBorderPainted(false);
        panel7.add(userLabel);

        // Label for "List of Vehicles" option
        vehicleListLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
        vehicleListLabel.setOpaque(false);
        vehicleListLabel.setContentAreaFilled(false);
        vehicleListLabel.setBorderPainted(false);
        panel8.add(vehicleListLabel);

        ActionListener goToVehicleList = new vehicleListListener();
        vehicleListLabel.addActionListener(goToVehicleList);
        vehicleListLabel.addActionListener(e -> {
            dashboard.dispose();
        });

        // Placing the logo on the logo panel
        panel.add(logoLabel);

        // Greeting card to greet users who signed in.
        greetingUser.setForeground(new Color(255, 255, 255));
        greetingUser.setFont(new Font("Monospaced", Font.BOLD, 25));
        greetingUserCard.add(greetingUser);
        greetingUserCard.setBounds(350, 50, 600, 100);
        greetingUserCard.setBackground(new Color(41, 55, 77));
        // adding the multiple panels onto the dashboard
        dashboard.add(panel);
        dashboard.add(panel2);
        dashboard.add(panel3);
        dashboard.add(panel4);
        dashboard.add(panel5);
        dashboard.add(panel6);
        dashboard.add(panel7);
        dashboard.add(panel8);
        dashboard.add(greetingUserCard);
        // setting the Frame to be visible for view
        dashboard.setVisible(true);
    }
}
