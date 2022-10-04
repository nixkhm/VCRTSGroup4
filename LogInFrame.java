import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class LogInFrame {

    // registering the ClickListener
    ActionListener goToDashboard = new ClickListener();

    // The frame that will hold the entire Log-In screen
    JFrame logInWindow = new JFrame("VCRTS");

    // Created JLabels to hold the Logo and text at top
    ImageIcon img = new ImageIcon("logo.png");
    JLabel icon = new JLabel(img, JLabel.CENTER);

    // Label for the title of the frame
    JLabel logInText = new JLabel("VCRTS Log In");

    // Label for direction of dashboard
    JLabel signIn = new JLabel("Who is signing in?");

    // different buttons to specify which entity
    JButton renterButton = new JButton("Renter");
    JButton cloudControlButton = new JButton("Cloud Controller");
    JButton clientButton = new JButton("Client");

    JLabel placeHolder = new JLabel("                      ");

    // Panel for the entire frame
    JPanel panel = new JPanel();

    public LogInFrame() {
        logInWindow.setSize(300, 400);
        logInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInWindow.setLocationRelativeTo(null);
        logInWindow.setResizable(false);

        logInText.setFont(new Font("Monospaced", Font.BOLD, 24));
        logInText.setForeground(new Color(249, 217, 126));

        // Created buttons for register & sign-in (Will not use Text-Field for
        // implementation). These three buttons will each lead to their own dashboards.
        signIn.setForeground(Color.white);

        renterButton.addActionListener(goToDashboard);
        ActionListener renter = new ownerListener();
        renterButton.addActionListener(renter);
        renterButton.addActionListener(e -> {
            logInWindow.dispose();
        });

        cloudControlButton.addActionListener(goToDashboard);
        ActionListener cloud = new cloudControllerListener();
        cloudControlButton.addActionListener(cloud);
        cloudControlButton.addActionListener(e -> {
            logInWindow.dispose();
        });

        clientButton.addActionListener(goToDashboard);
        ActionListener client = new clientListener();
        clientButton.addActionListener(client);
        clientButton.addActionListener(e -> {
            logInWindow.dispose();
        });

        // setting the background of the Panel to match the background of the logo
        panel.setBackground(new Color(41, 55, 77));

        // adding all the components into the Panel
        panel.add(logInText);
        panel.add(placeHolder);
        panel.add(signIn);
        panel.add(renterButton);
        panel.add(cloudControlButton);
        panel.add(clientButton);
        panel.add(icon);

        // adding the Panel to the frame
        logInWindow.add(panel);

        // setting the Frame to be visible for view
        logInWindow.setVisible(true);
    }
}

class ClickListener implements ActionListener {

    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        File transcript = new File("transcript.txt");
        DateTimeFormatter logInTimeAndDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(logInTimeAndDate.format(now));
        String date = "" + logInTimeAndDate.format(now);
        try {
            transcript.createNewFile();
            FileWriter logInTranscript = new FileWriter(transcript);
            logInTranscript.write(date);
            logInTranscript.close();
        } catch (IOException e1) {

            e1.printStackTrace();
        }
    }
}

class clientListener implements ActionListener {
    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        ClientDashboard client = new ClientDashboard();
    }
}

class ownerListener implements ActionListener {
    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        OwnerDashboard owner = new OwnerDashboard();
    }
}

class cloudControllerListener implements ActionListener {
    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        CloudController cloudController = new CloudController();
    }
}

// Saved the original logIn layout for the future.
/*
 * JButton logInButton = new JButton("Log In");
 * JButton registerButton = new JButton("Register");
 * JLabel userNameText = new JLabel("Username:");
 * JLabel passText = new JLabel("Password:");
 * userNameText.setForeground(Color.white);
 * passText.setForeground(Color.white);
 * JTextField userName = new JTextField();
 * JTextField pass = new JTextField();
 * userName.setColumns(20);
 * pass.setColumns(20);
 */