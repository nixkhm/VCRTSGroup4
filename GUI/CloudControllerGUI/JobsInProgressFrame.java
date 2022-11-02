package GUI.CloudControllerGUI;

import javax.swing.*;
import GUI.ButtonListeners.cloudControllerListener;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import BackEnd.*;
import BackEnd.Entities.CloudController;

public class JobsInProgressFrame {
    JFrame dashboard = new JFrame("Jobs in Progress Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel JIPTitlePanel = new JPanel();
    JPanel JIPPanel = new JPanel();
    JPanel returnPanel = new JPanel();
    JPanel jobDurationPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Jobs In Progress");

    JLabel JIPTitle = new JLabel("Jobs In Progress");
    
    JButton returnButton = new JButton("Return");

    public JobsInProgressFrame() throws IOException {
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

        JIPTitlePanel.setBackground(Color.LIGHT_GRAY);
        JIPTitlePanel.setBounds(225, 200, 750, 50);
        JIPTitle.setBounds(550, 200, 50, 50);
        JIPTitlePanel.add(JIPTitle);

        JIPPanel.setBackground(Color.LIGHT_GRAY);
        JIPPanel.setBounds(225, 250, 750, 350);
        JIPPanel.setLayout(null);
        CloudController cloudController = new CloudController();
        final ArrayList<Job> listofJobs = cloudController.getAllJobApps();
        String headers[]= {"Job ID", "Name", "Type","Duration","Deadline","Notes"};
        JTable JIP = new JTable(11, 6);
        for (int i = 0; i < headers.length; i++){
            JIP.setValueAt(headers[i],0, i);
        }
        int x = 10;
        if (listofJobs.size() < x){
            x = listofJobs.size();
        }
        for (int i = 0; i < x; i++){
            JIP.setValueAt(listofJobs.get(i).getJobID(), i+1, 0);
            JIP.setValueAt(listofJobs.get(i).getJobName(),i+1,1);
            JIP.setValueAt(listofJobs.get(i).getJobType(),i+1,2);
            JIP.setValueAt(listofJobs.get(i).getJobDuration(),i+1,3);
            JIP.setValueAt(listofJobs.get(i).getJobDeadline(),i+1,4);
            JIP.setValueAt(listofJobs.get(i).getJobNotes(),i+1,5);
        }
        JIP.setBounds(15, 15, 720, 175);
        jobDurationPanel.setBounds(300, 200, 150, 150);
        JLabel jobIDLabel = new JLabel("IDs "+cloudController.getAllJobIds().toString());
        JLabel jobDurationLabel = new JLabel("Duration "+cloudController.getFullJobTime().toString());
        jobDurationPanel.add(jobIDLabel);
        jobDurationPanel.add(jobDurationLabel);
        JIPPanel.add(jobDurationPanel);
        JIPPanel.add(JIP);

        


        returnPanel.setBounds(550, 600, 100, 50);
        ActionListener cloud = new cloudControllerListener();
        returnButton.addActionListener(cloud);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.setVisible(true);
        dashboard.add(JIPTitlePanel);
        dashboard.add(JIPPanel);
        dashboard.add(returnPanel);
    }
    }
    

