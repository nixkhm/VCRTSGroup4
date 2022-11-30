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

public class AcceptJobFrame {

    JFrame dashboard = new JFrame("Accept Job");
    JPanel jobAppPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Accept a Job");
    JPanel titlePanel = new JPanel();

    JPanel returnPanel = new JPanel();
    JButton returnButton = new JButton("Return");

    JPanel jobIDPanel = new JPanel();
    JLabel jobIDLabel = new JLabel("Job ID");
    JTextField jobIDInput = new JTextField();

    JButton submitButton = new JButton("Accept");
    JPanel submitPanel = new JPanel();

    public AcceptJobFrame() {
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

        jobIDPanel.setBackground(Color.LIGHT_GRAY);
        jobIDPanel.setBounds(700, 300, 200, 50);

        jobIDLabel.setBounds(750, 300, 50, 50);
        jobIDPanel.add(jobIDLabel);

        jobIDInput.setBounds(900, 300, 200, 50);

        jobAppPanel.setBackground(Color.LIGHT_GRAY);
        jobAppPanel.setBounds(50, 250, 550, 300);

        CloudController cc = new CloudController();
        ArrayList<Job> listOfPendingJobs = cc.getAllPendingJobs();
        populatePendingJobs(cc, listOfPendingJobs);

        ActionListener back = new backToPending();
        ActionListener acceptVehicle = new AcceptJob();

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

        dashboard.add(jobIDPanel);
        dashboard.add(jobIDInput);
        dashboard.add(titlePanel);
        dashboard.add(jobAppPanel);
        dashboard.add(returnPanel);
        dashboard.add(submitPanel);

        dashboard.setVisible(true);
    }

    public void populatePendingJobs(CloudController cloudController, ArrayList<Job> listOfVehicles) {
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
        jobAppPanel.add(jobList);
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

    public class AcceptJob implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JPanel responsePanel = new JPanel();
            responsePanel.setBackground(Color.LIGHT_GRAY);
            responsePanel.setBounds(300, 550, 250, 75);
            JLabel response = new JLabel("Error");
            if (jobIDInput.getText().isEmpty()) {
                response.setText("All text fields must be completed");
                responsePanel.add(response);
                dashboard.add(responsePanel);
                dashboard.setVisible(true);
            } else {
                showMessageDialog(null, "The job has been accepted.");
                String jobIDStr = jobIDInput.getText();
                System.out.println(jobIDStr);
                CloudController cc = new CloudController();
                cc.acceptJob(jobIDStr);
                try {
                    PendingAppsFrame frame = new PendingAppsFrame();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }
}
