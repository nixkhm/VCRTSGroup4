import javax.swing.*;
import java.awt.*;

public class LogInFrame {
    public static void main(String[] args) {

        // The frame that will hold the entire Log-In screen
        JFrame logInWindow = new JFrame("VCRTS");
        logInWindow.setSize(300, 400);
        logInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInWindow.setLocationRelativeTo(null);
        logInWindow.setResizable(false);

        // Created JLabels to hold the Logo and text at top
        ImageIcon img = new ImageIcon("logo.png");
        JLabel icon = new JLabel(img, JLabel.CENTER);

        JLabel logInText = new JLabel("VCRTS Log In");
        logInText.setFont(new Font("Monospaced", Font.BOLD, 24));
        logInText.setForeground(new Color(249, 217, 126));

        // Created buttons for register & sign-in (Will not use Text-Field for
        // implementation)
        JButton logInButton = new JButton("Log In");
        JButton registerButton = new JButton("Register");
        JTextField userName = new JTextField("Username:");
        JTextField pass = new JTextField("Password:");
        userName.setColumns(20);
        pass.setColumns(20);

        // The JPanel object that will hold all of the componenets
        JPanel panel = new JPanel();

        // setting the background of the Panel to match the background of the logo
        panel.setBackground(new Color(41, 55, 77));

        // adding all the components into the Panel
        panel.add(logInText);
        panel.add(userName);
        panel.add(pass);
        panel.add(logInButton);
        panel.add(registerButton);
        panel.add(icon);

        // adding the Panel to the frame
        logInWindow.add(panel);

        // setting the Frame to be visible for view
        logInWindow.setVisible(true);
    }

}
