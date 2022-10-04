import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OwnerDashboard {
    ActionListener rL = new registrationListener();
    // The Frame that will hold the entire dashboard
    JFrame dashboard = new JFrame("Owner Dashboard");

    // Creating multiple panels that will represent options on a menu
    JPanel panel = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();
    JPanel panel6 = new JPanel();
    JPanel panel7 = new JPanel();

    JButton homeLabel = new JButton("Home");

    JButton tasksLabel = new JButton("Register a Vehicle");
    
    JButton JIPLabel = new JButton("View my Vehicles");

    JButton historyLabel = new JButton("History");

    JButton settingsLabel = new JButton("Settings");

    JButton userLabel = new JButton("Profile");

    JLabel logoLabel = new JLabel(new ImageIcon("logo.png"));

    JLabel greetingUser = new JLabel("Hello, [username_goes_here]!");

    JPanel greetingUserCard = new JPanel();

    public OwnerDashboard(){

        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

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
        panel2.setBounds(100, 260, 175, 50);
        panel3.setBounds(100, 360, 175, 50);
        panel4.setBounds(100, 460, 175, 50);
        panel5.setBounds(100, 560, 175, 50);
        panel6.setBounds(100, 660, 175, 50);

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
            dashboard.dispose();
         });



        // Label for "Submitting a Job" option
        tasksLabel.setFont(new Font("Monospaced", Font.BOLD, 15));
        tasksLabel.setOpaque(false);
        tasksLabel.setContentAreaFilled(false);
        tasksLabel.setBorderPainted(false);
        panel3.add(tasksLabel);

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

        // Label for "Job History" option
        settingsLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        settingsLabel.setOpaque(false);
        settingsLabel.setContentAreaFilled(false);
        settingsLabel.setBorderPainted(false);
        panel6.add(settingsLabel);

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

    
        
        ActionListener rL = new registrationListener();
        tasksLabel.addActionListener(rL);
        tasksLabel.addActionListener(e -> {
            dashboard.dispose();
        });
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
    class registrationListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            RegistrationFrame registrationFrame = new RegistrationFrame();
        }
    }
}

