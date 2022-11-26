package GUI.Start;

import GUI.ButtonListeners.cloudControllerListener;
import GUI.ClientGUI.ClientDashboard;
import GUI.OwnerGUI.OwnerDashboard;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.time.*;
import java.time.format.*;

public class LogInFrame {

    // The frame that will hold the entire Log-In screen
    JFrame logInWindow = new JFrame("VCRTS");

    JPanel dashboard = new JPanel();

    JLabel logInText = new JLabel("VCRTS Log In");
    JLabel signIn = new JLabel("Who is signing in?");
    JLabel placeHolder = new JLabel("                      ");

    ImageIcon img = new ImageIcon("GUI/Assets/logo.png");
    JLabel icon = new JLabel(img, JLabel.CENTER);

    JButton ownerButton = new JButton("Owner");
    JButton cloudControlButton = new JButton("Cloud Controller");
    JButton clientButton = new JButton("Client");

    ActionListener goToDashboard = new ClickListener();

    public LogInFrame() {

        // defining the attributes of the frame
        logInWindow.setSize(300, 400);
        logInWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        logInWindow.setLocationRelativeTo(null);
        logInWindow.setResizable(false);

        logInText.setFont(new Font("Monospaced", Font.BOLD, 24));
        logInText.setForeground(new Color(249, 217, 126));

        signIn.setForeground(Color.white);

        // owner button config
        ownerButton.addActionListener(goToDashboard);
        ActionListener owner = new ownerListener();
        ownerButton.addActionListener(owner);
        ownerButton.addActionListener(e -> {
            logInWindow.dispose();
        });

        // cloudcontroller button config
        cloudControlButton.addActionListener(goToDashboard);
        ActionListener cloud = new cloudControllerListener();
        cloudControlButton.addActionListener(cloud);
        cloudControlButton.addActionListener(e -> {
            logInWindow.dispose();
        });

        // client button config
        clientButton.addActionListener(goToDashboard);
        ActionListener client = new clientListener();
        clientButton.addActionListener(client);
        clientButton.addActionListener(e -> {
            logInWindow.dispose();
        });

        dashboard.setBackground(new Color(41, 55, 77));

        // adding all the components into the Panel
        dashboard.add(logInText);
        dashboard.add(placeHolder);
        dashboard.add(signIn);
        dashboard.add(ownerButton);
        dashboard.add(cloudControlButton);
        dashboard.add(clientButton);
        dashboard.add(icon);

        logInWindow.add(dashboard);

        logInWindow.setVisible(true);
    }
}

class ClickListener implements ActionListener {

    // Once the user signs in by clicking the button, the program will generate a
    // file containing the time and date that the user logged in.
    public void actionPerformed(ActionEvent e) {
        File transcript = new File("GUI/Transcripts/logInTranscript.txt");
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