import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClientDashboard {

    public static void main() {

        // this is a template to go by to organize the Panels, variable names will be
        // modified accordingly

        // The Frame that will hold the entire dashboard
        JFrame dashboard = new JFrame("VCRTS Dashboard");
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Creating multiple panels that will represent options on a menu
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();

        // Setting background of the panels
        panel.setBackground(new Color(41, 55, 77));
        panel2.setBackground(new Color(205, 205, 205));
        panel3.setBackground(new Color(205, 205, 205));
        panel4.setBackground(new Color(205, 205, 205));
        panel5.setBackground(new Color(205, 205, 205));
        panel6.setBackground(new Color(205, 205, 205));
        panel7.setBackground(new Color(205, 205, 205));
        // Logo Panel
        panel.setBounds(30, 20, 300, 150);

        // Options Panel
        panel2.setBounds(30, 260, 175, 50);
        panel3.setBounds(30, 360, 175, 50);
        panel4.setBounds(30, 460, 175, 50);
        panel5.setBounds(30, 560, 175, 50);
        panel6.setBounds(30, 660, 175, 50);

        // user Panel
        panel7.setBounds(1000, 30, 175, 50);

        // Label for "Home" option
        JButton homeLabel = new JButton("Home");
        homeLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        homeLabel.setOpaque(false);
        homeLabel.setContentAreaFilled(false);
        homeLabel.setBorderPainted(false);
        panel2.add(homeLabel);
        ActionListener goToLogin = new logInListener();
        homeLabel.addActionListener(goToLogin);
        homeLabel.addActionListener(e -> {
            dashboard.dispose();
         });

        // Label for "Submitting a Job" option
        JButton tasksLabel = new JButton("Submit a Job");
        tasksLabel.setFont(new Font("Monospaced", Font.BOLD, 22));
        tasksLabel.setOpaque(false);
        tasksLabel.setContentAreaFilled(false);
        tasksLabel.setBorderPainted(false);
        panel3.add(tasksLabel);

        // Label for "Jobs in Progress" option
        JButton JIPLabel = new JButton("Jobs in Progress");
        JIPLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
        JIPLabel.setOpaque(false);
        JIPLabel.setContentAreaFilled(false);
        JIPLabel.setBorderPainted(false);
        panel4.add(JIPLabel);

        // Label for "History" option
        JButton historyLabel = new JButton("History");
        historyLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        historyLabel.setOpaque(false);
        historyLabel.setContentAreaFilled(false);
        historyLabel.setBorderPainted(false);
        panel5.add(historyLabel);

        // Label for "Job History" option
        JButton settingsLabel = new JButton("Settings");
        settingsLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        settingsLabel.setOpaque(false);
        settingsLabel.setContentAreaFilled(false);
        settingsLabel.setBorderPainted(false);
        panel6.add(settingsLabel);

        // Label for "Profile" option
        JButton userLabel = new JButton("Profile");
        userLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        userLabel.setOpaque(false);
        userLabel.setContentAreaFilled(false);
        userLabel.setBorderPainted(false);
        panel7.add(userLabel);

        // Placing the logo on the logo panel
        JLabel logoLabel = new JLabel(new ImageIcon("logo.png"));
        panel.add(logoLabel);

        // Greeting card to greet users who signed in.
        JLabel greetingUser = new JLabel("Hello, [username_goes_here]!");
        greetingUser.setForeground(new Color(255, 255, 255));
        greetingUser.setFont(new Font("Monospaced", Font.BOLD, 25));
        JPanel greetingUserCard = new JPanel();
        greetingUserCard.add(greetingUser);
        greetingUserCard.setBounds(350, 50, 600, 100);
        greetingUserCard.setBackground(new Color(41, 55, 77));
        // adding the multiple panels onto the dashboard
        dashboard.add(panel);
        dashboard.add(panel2);
        dashboard.add(panel3);
        dashboard.add(panel4);
        dashboard.add(panel5);
        dashboard.add(panel6);
        dashboard.add(panel7);
        dashboard.add(greetingUserCard);
        // setting the Frame to be visible for view
        dashboard.setVisible(true);

    }

}

