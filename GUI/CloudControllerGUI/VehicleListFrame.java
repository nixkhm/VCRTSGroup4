package GUI.CloudControllerGUI;

import javax.swing.*;
import GUI.ButtonListeners.cloudControllerListener;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;

import BackEnd.*;
import BackEnd.Entities.CloudController;

public class VehicleListFrame {
    JFrame dashboard = new JFrame("Vehicle List Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel vehicleListTitlePanel = new JPanel();
    JPanel vehiclePanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Vehicle List");

    JLabel vehicleTitle = new JLabel("Vehicle List");

    JButton returnButton = new JButton("Return");

    public VehicleListFrame() throws IOException {
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

        vehicleListTitlePanel.setBackground(Color.LIGHT_GRAY);
        vehicleListTitlePanel.setBounds(225, 200, 750, 50);
        vehicleTitle.setBounds(550, 200, 50, 50);
        vehicleListTitlePanel.add(vehicleTitle);

        vehiclePanel.setBackground(Color.LIGHT_GRAY);
        vehiclePanel.setBounds(225, 250, 750, 350);
        CloudController cloudController = new CloudController();
        final ArrayList<Vehicle> listofVehicles = cloudController.getAllVehApps();
        String headers[] = { "Make", "Model", "Year", "In", "Out" };
        JTable vehicleList = new JTable(11, 5);
        for (int i = 0; i < headers.length; i++) {
            vehicleList.setValueAt(headers[i], 0, i);
        }
        int x = 10;
        if (listofVehicles.size() < x) {
            x = listofVehicles.size();
        }
        for (int i = 0; i < x; i++) {
            vehicleList.setValueAt(listofVehicles.get(i).getMake(), i + 1, 0);
            vehicleList.setValueAt(listofVehicles.get(i).getModel(), i + 1, 1);
            vehicleList.setValueAt(listofVehicles.get(i).getYear(), i + 1, 2);
            vehicleList.setValueAt(listofVehicles.get(i).getTimeStart(), i + 1, 3);
            vehicleList.setValueAt(listofVehicles.get(i).getTimeEnd(), i + 1, 4);
        }
        vehicleList.setBounds(550, 250, 750, 350);
        vehiclePanel.add(vehicleList);

        returnPanel.setBounds(550, 650, 100, 50);
        ActionListener cloud = new cloudControllerListener();
        returnButton.addActionListener(cloud);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.setVisible(true);
        dashboard.add(vehicleListTitlePanel);
        dashboard.add(vehiclePanel);
        dashboard.add(returnPanel);
    }
}
