import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PendingAppsFrame {
    JFrame dashboard = new JFrame("Pending Application Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel ownerAppTitlePanel = new JPanel();
    JPanel renterAppTitlePanel = new JPanel();
    JPanel ownerAppPanel = new JPanel();
    JPanel renterAppPanel = new JPanel();
    JPanel returnPanel = new JPanel();


    JLabel dashboardTitle = new JLabel("Pending Applications");

    JLabel ownerAppTitle = new JLabel("Owner Applications");
    JLabel renterAppTitle = new JLabel("Renter Applications");
    JLabel ownerApplications = new JLabel("No Current Applications");
    JLabel renterApplications = new JLabel("No Current Applications");

    JButton returnButton = new JButton("Return");

    public PendingAppsFrame() {
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


        ownerAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        ownerAppTitlePanel.setBounds(50, 200, 500, 50);
        ownerAppTitle.setBounds(50, 200, 50, 50);
        ownerAppTitlePanel.add(ownerAppTitle);

        ownerAppPanel.setBackground(Color.LIGHT_GRAY);
        ownerAppPanel.setBounds(50, 250, 500, 300);
        ownerApplications.setBounds(50, 250, 500, 300);
        ownerAppPanel.add(ownerApplications);

        renterAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        renterAppTitlePanel.setBounds(650, 200, 500, 50);
        renterAppTitle.setBounds(650, 200, 50, 50);
        renterAppTitlePanel.add(renterAppTitle);

        renterAppPanel.setBackground(Color.LIGHT_GRAY);
        renterAppPanel.setBounds(650, 250, 500, 300);
        renterApplications.setBounds(650, 250, 500, 300);
        renterAppPanel.add(renterApplications);

        returnPanel.setBounds(550, 600, 100, 50);
        ActionListener cloud = new cloudControllerListener();
        returnButton.addActionListener(cloud);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.setVisible(true);
        dashboard.add(ownerAppTitlePanel);
        dashboard.add(renterAppTitlePanel);
        dashboard.add(ownerAppPanel);
        dashboard.add(renterAppPanel);
        dashboard.add(returnPanel);
    }
}
