package GUI.CloudControllerGUI;

import javax.swing.*;

import GUI.ButtonListeners.cloudControllerListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import BackEnd.*;
import BackEnd.Entities.CloudController;
import java.util.*;

public class PendingAppsFrame {

    JFrame dashboard = new JFrame("Pending Application Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel ownerAppTitlePanel = new JPanel();
    JPanel renterAppTitlePanel = new JPanel();
    JPanel ownerAppPanel = new JPanel();

    JPanel acceptVehiclePanel = new JPanel();
    JPanel declineVehiclePanel = new JPanel();

    JPanel acceptJobPanel = new JPanel();
    JPanel declineJobPanel = new JPanel();

    JPanel renterAppPanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Pending Applications");
    JLabel ownerAppTitle = new JLabel("Vehicle Applications");
    JLabel renterAppTitle = new JLabel("Job Applications");
    JLabel noCurrentJobsLabel = new JLabel("No Current Job Applications");
    JLabel noCurrentVehiclesLabel = new JLabel("No Current Vehicle Applications");

    JButton acceptVehicleButton = new JButton("Accept Vehicle");
    JButton declineVehicleButton = new JButton("Decline Vehicle");
    JButton acceptJobButton = new JButton("Accept Job");
    JButton declineJobButton = new JButton("Decline Job");

    JButton returnButton = new JButton("Return");

    public PendingAppsFrame() throws IOException {

        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting up the title of the frame.
        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 600, 150);
        dashboardTitle.setForeground(Color.black);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);

        ownerAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        ownerAppTitlePanel.setBounds(50, 200, 550, 50);
        ownerAppTitle.setBounds(50, 200, 50, 50);
        ownerAppTitlePanel.add(ownerAppTitle);

        ownerAppPanel.setBackground(Color.LIGHT_GRAY);
        ownerAppPanel.setBounds(50, 250, 550, 300);

        renterAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        renterAppTitlePanel.setBounds(600, 200, 550, 50);
        renterAppTitle.setBounds(600, 200, 50, 50);
        renterAppTitlePanel.add(renterAppTitle);

        renterAppPanel.setBackground(Color.LIGHT_GRAY);
        renterAppPanel.setBounds(600, 250, 550, 300);

        noCurrentJobsLabel.setBounds(650, 250, 500, 300);
        noCurrentVehiclesLabel.setBounds(650, 250, 500, 300);

        returnPanel.setBounds(550, 600, 100, 50);

        acceptVehiclePanel.setBounds(100, 600, 150, 50);
        declineVehiclePanel.setBounds(300, 600, 150, 50);

        acceptJobPanel.setBounds(750, 600, 150, 50);
        declineJobPanel.setBounds(950, 600, 150, 50);

        ActionListener cloud = new cloudControllerListener();
        ActionListener acceptVehListener = new acceptVehicleListener();
        ActionListener declineVehListener = new declineVehicleListener();
        ActionListener acceptJobListener = new acceptJobListener();
        ActionListener declineJobListener = new declineJobListener();

        // populating pending aplication tables for jobs and vehicles
        CloudController cc = new CloudController();
        ArrayList<Vehicle> listOfPendingVeh = cc.getAllPendingVehicles();
        ArrayList<Job> listOfPendingJobs = cc.getAllPendingJobs();
        populatePendingVehicles(cc, listOfPendingVeh);
        populatePendingJobs(cc, listOfPendingJobs);

        // return button
        returnButton.addActionListener(cloud);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        // accept vehicle button
        acceptVehicleButton.addActionListener(acceptVehListener);
        acceptVehicleButton.addActionListener(e -> {
            dashboard.dispose();
        });
        acceptVehiclePanel.add(acceptVehicleButton);

        // decline vehicle button
        declineVehicleButton.addActionListener(declineVehListener);
        declineVehicleButton.addActionListener(e -> {
            dashboard.dispose();
        });
        declineVehiclePanel.add(declineVehicleButton);

        // accept job button
        acceptJobButton.addActionListener(acceptJobListener);
        acceptJobButton.addActionListener(e -> {
            dashboard.dispose();
        });
        acceptJobPanel.add(acceptJobButton);

        // decline job button
        declineJobButton.addActionListener(declineJobListener);
        declineJobButton.addActionListener(e -> {
            dashboard.dispose();
        });
        declineJobPanel.add(declineJobButton);

        declineVehiclePanel.add(declineVehicleButton);
        acceptJobPanel.add(acceptJobButton);
        declineJobPanel.add(declineJobButton);

        dashboard.add(titlePanel);
        dashboard.add(ownerAppTitlePanel);
        dashboard.add(renterAppTitlePanel);
        dashboard.add(ownerAppPanel);
        dashboard.add(renterAppPanel);
        dashboard.add(returnPanel);
        dashboard.add(acceptVehiclePanel);
        dashboard.add(declineVehiclePanel);
        dashboard.add(acceptJobPanel);
        dashboard.add(declineJobPanel);

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

    public void populatePendingJobs(CloudController cloudController, ArrayList<Job> listOfJobs) {
        String headers[] = { "JobID", "name", "type", "duration", "deadline" };
        JTable jobList = new JTable(11, 5);

        for (int i = 0; i < headers.length; i++) {
            jobList.setValueAt(headers[i], 0, i);
        }

        int x = 10;
        if (listOfJobs.size() < x) {
            x = listOfJobs.size();
        }

        for (int i = 0; i < x; i++) {
            jobList.setValueAt(listOfJobs.get(i).getJobID(), i + 1, 0);
            jobList.setValueAt(listOfJobs.get(i).getJobName(), i + 1, 1);
            jobList.setValueAt(listOfJobs.get(i).getJobType(), i + 1, 2);
            jobList.setValueAt(listOfJobs.get(i).getJobDuration(), i + 1, 3);
            jobList.setValueAt(listOfJobs.get(i).getJobDeadline(), i + 1, 4);
        }

        jobList.setBounds(550, 250, 750, 350);
        renterAppPanel.add(jobList);
    }

    public class acceptVehicleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AcceptVehicleFrame accept = new AcceptVehicleFrame();

        }
    }

    public class declineVehicleListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DeclineVehicleFrame accept = new DeclineVehicleFrame();

        }
    }

    public class acceptJobListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            AcceptJobFrame accept = new AcceptJobFrame();

        }
    }

    public class declineJobListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DeclineJobFrame decline = new DeclineJobFrame();

        }
    }

}
