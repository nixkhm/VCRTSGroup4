import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.*;
import java.time.format.*;

class logInListener implements ActionListener {
    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        LogInFrame logInDashboard = new LogInFrame(); 
        
    }
}

public class CloudController {

        // this is a template to go by to organize the Panels, variable names will be
        // modified accordingly

        // The Frame that will hold the entire dashboard
        JFrame cloudControllerDash = new JFrame("Cloud Controller Dashboard");

        // Creating multiple panels that will represent options on a menu
        JPanel panel = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        JPanel panel6 = new JPanel();
        JPanel panel7 = new JPanel();

        // Buttons
        JButton homeLabel = new JButton("Home");
        JButton pendingAppsLabel = new JButton("Pending Applications");
        JButton JIPLabel = new JButton("Jobs in Progress");
        JButton historyLabel = new JButton("History");
        JButton userDataLabel = new JButton("User Data");
        JButton userLabel = new JButton("Profile");

        // labels
        JLabel logoLabel = new JLabel(new ImageIcon("logo.png"));
        JLabel greetingUser = new JLabel("Hello, [username_goes_here]!");
        JPanel greetingUserCard = new JPanel();

        public CloudController(){

        // Setting b
        cloudControllerDash.setSize(1200, 800);
        cloudControllerDash.setLocationRelativeTo(null);
        cloudControllerDash.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cloudControllerDash.setResizable(false);
        cloudControllerDash.getContentPane().setBackground(new Color(41, 55, 77));
        cloudControllerDash.setLayout(null);

        
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
        homeLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        homeLabel.setOpaque(false);
        homeLabel.setContentAreaFilled(false);
        homeLabel.setBorderPainted(false);
        panel2.add(homeLabel);
        ActionListener goToLogin = new logInListener();
        homeLabel.addActionListener(goToLogin);
        homeLabel.addActionListener(e -> {
            cloudControllerDash.dispose();
         });
         
        // Label for "Pending Applications" option
        pendingAppsLabel.setFont(new Font("Monospaced", Font.BOLD, 14));
        pendingAppsLabel.setOpaque(false);
        pendingAppsLabel.setContentAreaFilled(false);
        pendingAppsLabel.setBorderPainted(false);
        panel3.add(pendingAppsLabel);

        // Label for "Jobs in Progress" option
        JIPLabel.setFont(new Font("Monospaced", Font.BOLD, 17));
        JIPLabel.setOpaque(false);
        JIPLabel.setContentAreaFilled(false);
        JIPLabel.setBorderPainted(false);
        panel4.add(JIPLabel);

        // Label for "History" option
        historyLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        historyLabel.setOpaque(false);
        historyLabel.setContentAreaFilled(false);
        historyLabel.setBorderPainted(false);
        panel5.add(historyLabel);

        // Label for "User Data" option
        userDataLabel.setFont(new Font("Monospaced", Font.BOLD, 32));
        userDataLabel.setOpaque(false);
        userDataLabel.setContentAreaFilled(false);
        userDataLabel.setBorderPainted(false);
        panel6.add(userDataLabel);

        // Label for "Profile" option
        userLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        userLabel.setOpaque(false);
        userLabel.setContentAreaFilled(false);
        userLabel.setBorderPainted(false);
        panel7.add(userLabel);

        // Placing the logo on the logo panel
        panel.add(logoLabel);

        // Greeting card to greet users who signed in.
        greetingUser.setForeground(new Color(255, 255, 255));
        greetingUser.setFont(new Font("Monospaced", Font.BOLD, 25));
        greetingUserCard.add(greetingUser);
        greetingUserCard.setBounds(350, 50, 600, 100);
        greetingUserCard.setBackground(new Color(41, 55, 77));
        // adding the multiple panels onto the dashboard
        cloudControllerDash.add(panel);
        cloudControllerDash.add(panel2);
        cloudControllerDash.add(panel3);
        cloudControllerDash.add(panel4);
        cloudControllerDash.add(panel5);
        cloudControllerDash.add(panel6);
        cloudControllerDash.add(panel7);
        cloudControllerDash.add(greetingUserCard);
        // setting the Frame to be visible for view
        cloudControllerDash.setVisible(true);
    }
}
