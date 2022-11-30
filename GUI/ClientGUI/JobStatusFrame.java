package GUI.ClientGUI;

import javax.swing.*;
import GUI.ButtonListeners.returnButtonListener;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import BackEnd.*;
import BackEnd.Entities.CloudController;

public class JobStatusFrame {
    JFrame dashboard = new JFrame("Job Status and Notifications");

    JPanel titlePanel = new JPanel();
    JPanel approvedAppTitlePanel = new JPanel();
    JPanel declinedAppTitlePanel = new JPanel();
    JPanel approvedAppPanel = new JPanel();
    JPanel declinedAppPanel = new JPanel();
    JPanel returnPanel = new JPanel();
    JPanel clearPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Status of Job Applications");
    JLabel pendingAppTitle = new JLabel("Pending Applications");
    JLabel declinedAppTitle = new JLabel("Declined Applications");
    JLabel noCurrentJobsLabel = new JLabel("No Current Job Applications");
    JLabel noCurrentVehiclesLabel = new JLabel("No Current Vehicle Applications");

    JButton returnButton = new JButton("Return");
    JButton clearDeclined = new JButton("Remove Declined Jobs");

    public JobStatusFrame() {
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting up the title of the frame.
        titlePanel.setBackground(new Color(50, 100, 100));
        titlePanel.setBounds(300, 20, 600, 150);
        dashboardTitle.setForeground(Color.white);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);

        approvedAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        approvedAppTitlePanel.setBounds(50, 200, 550, 50);
        pendingAppTitle.setBounds(50, 200, 50, 50);
        approvedAppTitlePanel.add(pendingAppTitle);

        approvedAppPanel.setBackground(Color.LIGHT_GRAY);
        approvedAppPanel.setBounds(50, 250, 550, 300);

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

        ActionListener client = new returnListener();
        ActionListener clear = new ackowledgeDeclined();

        // return button
        returnButton.addActionListener(client);
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
        ArrayList<Job> listOfPending = cc.getAllPendingJobs();
        ArrayList<Job> listOfDeclined = cc.getDeclinedJobs();
        populatePendingJobs(cc, listOfPending);
        populateDeclinedJobs(cc, listOfDeclined);

        dashboard.add(titlePanel);
        dashboard.add(approvedAppTitlePanel);
        dashboard.add(declinedAppTitlePanel);
        dashboard.add(approvedAppPanel);
        dashboard.add(declinedAppPanel);
        dashboard.add(returnPanel);
        dashboard.add(clearPanel);

        dashboard.setVisible(true);

    }

    public void populatePendingJobs(CloudController cloudController, ArrayList<Job> listOfJobs) {
        String headers[] = { "JobID", "Job Name", "Job Type", "Duration", "Deadline" };
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
        approvedAppPanel.add(jobList);
    }

    public void populateDeclinedJobs(CloudController cloudController, ArrayList<Job> listOfVehicles) {
        String headers[] = { "JobID", "Job Name", "Job Type", "Duration", "Deadline" };
        JTable jobList = new JTable(11, 5);

        for (int i = 0; i < headers.length; i++) {
            jobList.setValueAt(headers[i], 0, i);
        }

        int x = 10;
        if (listOfVehicles.size() < x) {
            x = listOfVehicles.size();
        }

        for (int i = 0; i < x; i++) {
            jobList.setValueAt(listOfVehicles.get(i).getJobID(), i + 1, 0);
            jobList.setValueAt(listOfVehicles.get(i).getJobName(), i + 1, 1);
            jobList.setValueAt(listOfVehicles.get(i).getJobType(), i + 1, 2);
            jobList.setValueAt(listOfVehicles.get(i).getJobDuration(), i + 1, 3);
            jobList.setValueAt(listOfVehicles.get(i).getJobDeadline(), i + 1, 4);
        }

        jobList.setBounds(550, 250, 750, 350);
        declinedAppPanel.add(jobList);
    }

}

class returnListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        ClientDashboard clientDash = new ClientDashboard();

    }
}

class ackowledgeDeclined implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        CloudController cc = new CloudController();
        cc.clearDeclinedJobs();
        JobStatusFrame refresh = new JobStatusFrame();
    }
}
