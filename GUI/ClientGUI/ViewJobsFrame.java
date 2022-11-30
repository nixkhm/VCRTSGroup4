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

public class ViewJobsFrame {

    JFrame dashboard = new JFrame("Vehicle List Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel jobPanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Job List");
    JLabel jobTitle = new JLabel("Job List");

    JButton returnButton = new JButton("Return");

    public ViewJobsFrame() throws IOException {

        // dimensions and features of the dashboard
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // title of the frame
        titlePanel.setBackground(new Color(50, 100, 100));
        titlePanel.setBounds(300, 20, 600, 150);
        dashboardTitle.setForeground(Color.white);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);

        // panels
        jobPanel.setBackground(Color.LIGHT_GRAY);
        jobPanel.setBounds(225, 250, 750, 350);

        returnPanel.setBounds(550, 600, 100, 50);

        // populating the JTable
        CloudController cloudController = new CloudController();
        final ArrayList<Job> listofJobs = cloudController.getAllJobs();
        populateTable(cloudController, listofJobs);

        // button listener for return
        ActionListener clientDashboard = new backToClient();
        returnButton.addActionListener(clientDashboard);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.add(jobPanel);
        dashboard.add(returnPanel);

        dashboard.setVisible(true);

    }

    public void populateTable(CloudController cloudController, ArrayList<Job> listOfVehicles) {

        String headers[] = { "Name", "Type", "Duration", "Deadline" };
        JTable jobList = new JTable(11, 4);

        for (int i = 0; i < headers.length; i++) {
            jobList.setValueAt(headers[i], 0, i);
        }

        int x = 10;

        if (listOfVehicles.size() < x) {
            x = listOfVehicles.size();
        }

        for (int i = 0; i < x; i++) {
            jobList.setValueAt(listOfVehicles.get(i).getJobName(), i + 1, 0);
            jobList.setValueAt(listOfVehicles.get(i).getJobType(), i + 1, 1);
            jobList.setValueAt(listOfVehicles.get(i).getJobDuration(), i + 1, 2);
            jobList.setValueAt(listOfVehicles.get(i).getJobDeadline(), i + 1, 3);
        }

        jobList.setBounds(550, 250, 1000, 1000);
        jobPanel.add(jobList);
    }

    class backToClient implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ClientDashboard dash = new ClientDashboard();

        }
    }
}
