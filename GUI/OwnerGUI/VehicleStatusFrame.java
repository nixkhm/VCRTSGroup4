package GUI.OwnerGUI;

import javax.swing.*;
import GUI.ButtonListeners.returnButtonListener;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import BackEnd.*;
import BackEnd.Entities.CloudController;

public class VehicleStatusFrame {
    JFrame dashboard = new JFrame("Vehicle Status and Notifications");

    JPanel titlePanel = new JPanel();
    JPanel acceptedAppTitlePanel = new JPanel();
    JPanel declinedAppTitlePanel = new JPanel();
    JPanel acceptedAppPanel = new JPanel();
    JPanel declinedAppPanel = new JPanel();
    JPanel returnPanel = new JPanel();
    JPanel clearPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Status of Vehicle Applications");
    JLabel acceptedAppTitle = new JLabel("Pending Applications");
    JLabel declinedAppTitle = new JLabel("Declined Applications");
    JLabel noCurrentJobsLabel = new JLabel("No Current Vehicle Applications");
    JLabel noCurrentVehiclesLabel = new JLabel("No Current Vehicle Applications");

    JButton returnButton = new JButton("Return");
    JButton clearDeclined = new JButton("Remove Declined Vehicles");

    public VehicleStatusFrame() {
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting up the title of the frame.
        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 750, 150);
        dashboardTitle.setForeground(Color.black);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);

        acceptedAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        acceptedAppTitlePanel.setBounds(50, 200, 550, 50);
        acceptedAppTitle.setBounds(50, 200, 50, 50);
        acceptedAppTitlePanel.add(acceptedAppTitle);

        acceptedAppPanel.setBackground(Color.LIGHT_GRAY);
        acceptedAppPanel.setBounds(50, 250, 550, 300);

        declinedAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        declinedAppTitlePanel.setBounds(600, 200, 550, 50);
        declinedAppTitle.setBounds(600, 200, 50, 50);
        declinedAppTitlePanel.add(declinedAppTitle);

        declinedAppPanel.setBackground(Color.LIGHT_GRAY);
        declinedAppPanel.setBounds(600, 250, 550, 300);

        noCurrentJobsLabel.setBounds(650, 250, 500, 300);
        noCurrentVehiclesLabel.setBounds(650, 250, 500, 300);

        returnPanel.setBounds(550, 600, 100, 50);

        clearPanel.setBounds(850, 600, 220, 50);

        ActionListener owner = new returnButtonListener();
        ActionListener clear = new ackowledgeDeclined();

        // return button
        returnButton.addActionListener(owner);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        // clear button
        clearDeclined.addActionListener(clear);
        clearDeclined.addActionListener(e -> {
            dashboard.dispose();
        });
        clearPanel.add(clearDeclined);

        // populating pending aplication tables for jobs and vehicles
        CloudController cc = new CloudController();
        ArrayList<Vehicle> listOfPending = cc.getAllPendingVehicles();
        ArrayList<Vehicle> listOfDeclined = cc.getDeclinedVehicles();
        populatePendingVehicles(cc, listOfPending);
        populateDeclinedVehicles(cc, listOfDeclined);

        dashboard.add(titlePanel);
        dashboard.add(acceptedAppTitlePanel);
        dashboard.add(declinedAppTitlePanel);
        dashboard.add(acceptedAppPanel);
        dashboard.add(declinedAppPanel);
        dashboard.add(returnPanel);
        dashboard.add(clearPanel);

        dashboard.setVisible(true);

    }

    public void populatePendingVehicles(CloudController cloudController, ArrayList<Vehicle> listOfVehicles) {
        String headers[] = { "VehicleID", "Car Make", "Car Model", "Car Year", "Time Start", "Time End" };
        JTable vehicleList = new JTable(11, 6);

        for (int i = 0; i < headers.length; i++) {
            vehicleList.setValueAt(headers[i], 0, i);
        }

        int x = 10;
        if (listOfVehicles.size() < x) {
            x = listOfVehicles.size();
        }

        for (int i = 0; i < x; i++) {
            vehicleList.setValueAt(listOfVehicles.get(i).getVehicleID(), i + 1, 0);
            vehicleList.setValueAt(listOfVehicles.get(i).getMake(), i + 1, 1);
            vehicleList.setValueAt(listOfVehicles.get(i).getModel(), i + 1, 2);
            vehicleList.setValueAt(listOfVehicles.get(i).getYear(), i + 1, 3);
            vehicleList.setValueAt(listOfVehicles.get(i).getTimeStart(), i + 1, 4);
            vehicleList.setValueAt(listOfVehicles.get(i).getTimeEnd(), i + 1, 5);
        }

        vehicleList.setBounds(550, 250, 750, 350);
        acceptedAppPanel.add(vehicleList);
    }

    public void populateDeclinedVehicles(CloudController cloudController, ArrayList<Vehicle> listOfVehicles) {
        String headers[] = { "VehicleID", "Car Make", "Car Model", "Car Year", "Time Start", "Time End"   };
        JTable vehicleList = new JTable(11, 6);

        for (int i = 0; i < headers.length; i++) {
            vehicleList.setValueAt(headers[i], 0, i);
        }

        int x = 10;
        if (listOfVehicles.size() < x) {
            x = listOfVehicles.size();
        }

        for (int i = 0; i < x; i++) {
            vehicleList.setValueAt(listOfVehicles.get(i).getVehicleID(), i + 1, 0);
            vehicleList.setValueAt(listOfVehicles.get(i).getMake(), i + 1, 1);
            vehicleList.setValueAt(listOfVehicles.get(i).getModel(), i + 1, 2);
            vehicleList.setValueAt(listOfVehicles.get(i).getYear(), i + 1, 3);
            vehicleList.setValueAt(listOfVehicles.get(i).getTimeStart(), i + 1, 4);
            vehicleList.setValueAt(listOfVehicles.get(i).getTimeEnd(), i + 1, 5);
        }

        vehicleList.setBounds(550, 250, 750, 350);
        declinedAppPanel.add(vehicleList);
    }

    class ackowledgeDeclined implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            CloudController cc = new CloudController();
            cc.clearDeclinedVehicles();
            VehicleStatusFrame refresh = new VehicleStatusFrame();
        }
    }

}
