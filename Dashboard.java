import javax.swing.*;
import java.awt.*;

public class Dashboard {

    public static void main(String[] args) {

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
        panel7.setBounds(1000, 30, 150, 150);

        // Label for "Home" option
        JLabel homeLabel = new JLabel("Home");
        homeLabel.setFont(new Font("Monospaced", Font.BOLD, 35));
        panel2.add(homeLabel);
        
        //Placing the logo on the logo panel
        JLabel logoLabel = new JLabel(new ImageIcon("logo.png"));
        panel.add(logoLabel);
        //
        
        //Greeting card to greet users who signed in.        
        JLabel greetingUser = new JLabel( "Hello, [username_goes_here]!");
        greetingUser.setForeground(new Color(255,255,255));
        greetingUser.setFont(new Font( "Monospaced", Font.BOLD, 25));
        JPanel greetingUserCard = new JPanel();
        greetingUserCard.add(greetingUser);
        greetingUserCard.setBounds(350,50, 600,100);
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
