package GUI.OwnerGUI;

import javax.swing.*;
import GUI.ButtonListeners.returnButtonListener;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import BackEnd.*;
import BackEnd.Entities.CloudController;

public class ViewVehicleFrame {

    JFrame dashboard = new JFrame("Vehicle List Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel vehiclePanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Vehicle List");
    JLabel vehicleTitle = new JLabel("Vehicle List");

    JButton returnButton = new JButton("Return");

    public ViewVehicleFrame() throws IOException {

        // dimensions and features of the dashboard
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // title of the frame
        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 600, 150);
        dashboardTitle.setForeground(Color.white);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);

        // panels
        vehiclePanel.setBackground(Color.LIGHT_GRAY);
        vehiclePanel.setBounds(225, 250, 750, 350);

        returnPanel.setBounds(550, 600, 100, 50);

        // populating the JTable
        CloudController cloudController = new CloudController();
        final ArrayList<Vehicle> listofVehicles = cloudController.getAllVehicles();
        populateTable(cloudController, listofVehicles);

        // button listener for return
        ActionListener goToDash = new returnButtonListener();
        returnButton.addActionListener(goToDash);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.add(vehiclePanel);
        dashboard.add(returnPanel);

        dashboard.setVisible(true);

    }

    public void populateTable(CloudController cloudController, ArrayList<Vehicle> listOfVehicles) {

        String headers[] = { "Make", "Model", "Year", "In", "Out" };
        JTable vehicleList = new JTable(11, 5);

        for (int i = 0; i < headers.length; i++) {
            vehicleList.setValueAt(headers[i], 0, i);
        }

        int x = 10;

        if (listOfVehicles.size() < x) {
            x = listOfVehicles.size();
        }

        for (int i = 0; i < x; i++) {
            vehicleList.setValueAt(listOfVehicles.get(i).getMake(), i + 1, 0);
            vehicleList.setValueAt(listOfVehicles.get(i).getModel(), i + 1, 1);
            vehicleList.setValueAt(listOfVehicles.get(i).getYear(), i + 1, 2);
            vehicleList.setValueAt(listOfVehicles.get(i).getTimeStart(), i + 1, 3);
            vehicleList.setValueAt(listOfVehicles.get(i).getTimeEnd(), i + 1, 4);
        }

        vehicleList.setBounds(550, 250, 750, 350);
        vehiclePanel.add(vehicleList);
    }
}
