package GUI.OwnerGUI;

import javax.swing.*;
import GUI.ButtonListeners.logInListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class OwnerDashboard {

    // The Frame that will hold the entire dashboard
    JFrame dashboard = new JFrame("Owner Dashboard");

    // Creating multiple panels that will represent options on a menu
    JPanel logoPanel = new JPanel();
    JPanel homePanel = new JPanel();
    JPanel registerCarPanel = new JPanel();
    JPanel viewVehiclesPanel = new JPanel();
    JPanel historyPanel = new JPanel();
    JPanel settingsPanel = new JPanel();
    JPanel profilePanel = new JPanel();

    JButton homeButton = new JButton("Home");
    JButton registerCarButton = new JButton("Register a Vehicle");
    JButton viewVehiclesButton = new JButton("View my Vehicles");
    JButton historyButton = new JButton("History");
    JButton settingsButton = new JButton("Settings");
    JButton profileButton = new JButton("Profile");

    JLabel logo = new JLabel(new ImageIcon("GUI/Assets/logo.png"));

    public OwnerDashboard() {

        // dimensions and features of the dashboard
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // adding the logo to the dashboard
        logoPanel.add(logo);

        // setting background of the panels
        logoPanel.setBackground(new Color(41, 55, 77));
        logoPanel.setBounds(30, 20, 300, 150);

        homePanel.setBackground(new Color(205, 205, 205));
        homePanel.setBounds(100, 260, 175, 50);

        registerCarPanel.setBackground(new Color(205, 205, 205));
        registerCarPanel.setBounds(100, 360, 175, 50);

        viewVehiclesPanel.setBackground(new Color(205, 205, 205));
        viewVehiclesPanel.setBounds(100, 460, 175, 50);

        historyPanel.setBackground(new Color(205, 205, 205));
        historyPanel.setBounds(100, 560, 175, 50);

        settingsPanel.setBackground(new Color(205, 205, 205));
        settingsPanel.setBounds(100, 660, 175, 50);

        profilePanel.setBackground(new Color(205, 205, 205));
        profilePanel.setBounds(1000, 30, 175, 50);

        homeButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        homeButton.setOpaque(false);
        homeButton.setContentAreaFilled(false);
        homeButton.setBorderPainted(false);
        homePanel.add(homeButton);

        registerCarButton.setFont(new Font("Monospaced", Font.BOLD, 15));
        registerCarButton.setOpaque(false);
        registerCarButton.setContentAreaFilled(false);
        registerCarButton.setBorderPainted(false);
        registerCarPanel.add(registerCarButton);

        viewVehiclesButton.setFont(new Font("Monospaced", Font.BOLD, 17));
        viewVehiclesButton.setOpaque(false);
        viewVehiclesButton.setContentAreaFilled(false);
        viewVehiclesButton.setBorderPainted(false);
        viewVehiclesPanel.add(viewVehiclesButton);

        historyButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        historyButton.setOpaque(false);
        historyButton.setContentAreaFilled(false);
        historyButton.setBorderPainted(false);
        historyPanel.add(historyButton);

        settingsButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        settingsButton.setOpaque(false);
        settingsButton.setContentAreaFilled(false);
        settingsButton.setBorderPainted(false);
        settingsPanel.add(settingsButton);

        profileButton.setFont(new Font("Monospaced", Font.BOLD, 35));
        profileButton.setOpaque(false);
        profileButton.setContentAreaFilled(false);
        profileButton.setBorderPainted(false);
        profilePanel.add(profileButton);

        ActionListener goToLogin = new logInListener();
        homeButton.addActionListener(goToLogin);
        homeButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener register = new registerACarListener();
        registerCarButton.addActionListener(register);
        registerCarButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToVehicles = new viewMyVehicles();
        viewVehiclesButton.addActionListener(goToVehicles);
        viewVehiclesButton.addActionListener(e -> {
            dashboard.dispose();
        });

        // adding the multiple panels onto the dashboard
        dashboard.add(logoPanel);
        dashboard.add(homePanel);
        dashboard.add(registerCarPanel);
        dashboard.add(viewVehiclesPanel);
        dashboard.add(historyPanel);
        dashboard.add(settingsPanel);
        dashboard.add(profilePanel);

        dashboard.setVisible(true);
    }
}

// Register a Vehicle Button
class registerACarListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        RegistrationFrame registration = new RegistrationFrame();
    }
}

// View my Vehicles Button
class viewMyVehicles implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        try {
            ViewVehicleFrame viewVehicles = new ViewVehicleFrame();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}
