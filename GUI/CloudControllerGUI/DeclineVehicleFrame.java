package GUI.CloudControllerGUI;

import java.sql.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.*;
import GUI.ButtonListeners.cloudControllerListener;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import BackEnd.*;
import BackEnd.Entities.CloudController;

public class DeclineVehicleFrame {

    JFrame dashboard = new JFrame("Decline Vehicle");
    JPanel ownerAppPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Decline a Vehicle");
    JPanel titlePanel = new JPanel();

    JPanel returnPanel = new JPanel();
    JButton returnButton = new JButton("Return");

    JPanel vehicleIDPanel = new JPanel();
    JLabel vehicleIDLabel = new JLabel("Vehicle ID");
    JTextField vehicleIDInput = new JTextField();

    JButton submitButton = new JButton("Decline");
    JPanel submitPanel = new JPanel();

    public DeclineVehicleFrame() {
        dashboard.setSize(1200, 800);
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 600, 150);
        dashboardTitle.setForeground(Color.black);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);

        vehicleIDPanel.setBackground(Color.LIGHT_GRAY);
        vehicleIDPanel.setBounds(700, 300, 200, 50);

        vehicleIDLabel.setBounds(750, 300, 50, 50);
        vehicleIDPanel.add(vehicleIDLabel);

        vehicleIDInput.setBounds(900, 300, 200, 50);

        ownerAppPanel.setBackground(Color.LIGHT_GRAY);
        ownerAppPanel.setBounds(50, 250, 550, 300);

        CloudController cc = new CloudController();
        ArrayList<Vehicle> listOfPendingVeh = cc.getAllPendingVehicles();
        populatePendingVehicles(cc, listOfPendingVeh);

        ActionListener back = new backToPending();
        ActionListener acceptVehicle = new DeclineVehicle();

        returnPanel.setBounds(550, 600, 100, 50);
        returnButton.addActionListener(back);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        submitPanel.setBounds(850, 400, 100, 50);
        submitButton.addActionListener(acceptVehicle);
        submitButton.addActionListener(e -> {
            dashboard.dispose();
        });
        submitPanel.add(submitButton);

        dashboard.add(vehicleIDPanel);
        dashboard.add(vehicleIDInput);
        dashboard.add(titlePanel);
        dashboard.add(ownerAppPanel);
        dashboard.add(returnPanel);
        dashboard.add(submitPanel);

        dashboard.setVisible(true);
    }

    public void populatePendingVehicles(CloudController cloudController, ArrayList<Vehicle> listOfVehicles) {
        String headers[] = { "VehicleID", "Make", "Model", "Year", "In", "Out" };
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
        ownerAppPanel.add(vehicleList);
    }

    public class backToPending implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                PendingAppsFrame pending = new PendingAppsFrame();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class DeclineVehicle implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JPanel responsePanel = new JPanel();
            responsePanel.setBackground(Color.LIGHT_GRAY);
            responsePanel.setBounds(300, 550, 250, 75);
            JLabel response = new JLabel("Error");
            if (vehicleIDInput.getText().isEmpty()) {
                response.setText("All text fields must be completed");
                responsePanel.add(response);
                dashboard.add(responsePanel);
                dashboard.setVisible(true);
            } else {
                showMessageDialog(null, "The vehicle has been declined.");
                String vehicleIDStr = vehicleIDInput.getText();
                System.out.println(vehicleIDStr);
                CloudController cc = new CloudController();
                cc.declineVehicle(vehicleIDStr);
                try {
                    PendingAppsFrame frame = new PendingAppsFrame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
