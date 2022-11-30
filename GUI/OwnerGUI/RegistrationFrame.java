package GUI.OwnerGUI;

import javax.swing.*;

import BackEnd.Entities.CloudController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/*
 * This will be the frame where the owners can register their vehicle to be added to the VC
 */

public class RegistrationFrame {

    JFrame dashboard = new JFrame("Vehicle Registration");
    JLabel registrationTitle = new JLabel("Vehicle Registration");

    JPanel carRegistrationPanel = new JPanel();
    JPanel vehicleIDPanel = new JPanel();
    JPanel carModelPanel = new JPanel();
    JPanel carMakePanel = new JPanel();
    JPanel carYearPanel = new JPanel();
    JPanel timeStartPanel = new JPanel();
    JPanel timeEndPanel = new JPanel();
    JPanel submitPanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel vehicleIDLabel = new JLabel("Vehicle ID");
    JLabel carMakeLabel = new JLabel("Car Make");
    JLabel carModelLabel = new JLabel("Car Model");
    JLabel carYearLabel = new JLabel("Car Year");
    JLabel timeInLabel = new JLabel("Time Start");
    JLabel timeOutLabel = new JLabel("Time End");

    JTextField vehicleIDInput = new JTextField();
    JTextField carModelInput = new JTextField();
    JTextField carMakeInput = new JTextField();
    JTextField carYearInput = new JTextField();
    JTextField timeStartInput = new JTextField();
    JTextField timeEndInput = new JTextField();

    JButton submitButton = new JButton("Submit");
    JButton goBackButton = new JButton("Go Back");

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

    public RegistrationFrame() {

        // dimensions and features of the dashboard
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        carRegistrationPanel.setBackground(new Color(249, 217, 126));
        carRegistrationPanel.setBounds(300, 20, 600, 150);
        registrationTitle.setForeground(Color.black);
        registrationTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        carRegistrationPanel.add(registrationTitle);

        // panels
        vehicleIDPanel.setBackground(Color.LIGHT_GRAY);
        vehicleIDPanel.setBounds(50, 200, 200, 50);

        carMakePanel.setBackground(Color.LIGHT_GRAY);
        carMakePanel.setBounds(50, 250, 200, 50);

        carModelPanel.setBackground(Color.LIGHT_GRAY);
        carModelPanel.setBounds(50, 300, 200, 50);

        carYearPanel.setBackground(Color.LIGHT_GRAY);
        carYearPanel.setBounds(50, 350, 200, 50);

        timeStartPanel.setBackground(Color.LIGHT_GRAY);
        timeStartPanel.setBounds(50, 400, 200, 50);

        timeEndPanel.setBackground(Color.LIGHT_GRAY);
        timeEndPanel.setBounds(50, 450, 200, 50);

        submitPanel.setBounds(400, 550, 100, 50);
        submitPanel.add(submitButton);

        returnPanel.setBounds(600, 550, 100, 50);
        returnPanel.add(goBackButton);

        // labels
        vehicleIDLabel.setBounds(50, 200, 50, 50);
        vehicleIDPanel.add(vehicleIDLabel);

        carMakeLabel.setBounds(50, 250, 50, 50);
        carMakePanel.add(carMakeLabel);

        carModelLabel.setBounds(50, 300, 50, 50);
        carModelPanel.add(carModelLabel);

        carYearLabel.setBounds(50, 350, 50, 50);
        carYearPanel.add(carYearLabel);

        timeInLabel.setBounds(50, 400, 50, 50);
        timeStartPanel.add(timeInLabel);

        timeOutLabel.setBounds(50, 450, 50, 50);
        timeEndPanel.add(timeOutLabel);

        // text fields
        vehicleIDInput.setBounds(300, 200, 200, 50);
        carMakeInput.setBounds(300, 250, 200, 50);
        carModelInput.setBounds(300, 300, 200, 50);
        carYearInput.setBounds(300, 350, 200, 50);
        timeStartInput.setBounds(300, 400, 200, 50);
        timeEndInput.setBounds(300, 450, 200, 50);

        // button listeners
        ActionListener submit = new submitPendingVehicle();
        submitButton.addActionListener(submit);
        submitButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goBack = new returnButtonListener();
        goBackButton.addActionListener(goBack);
        goBackButton.addActionListener(e -> {
            dashboard.dispose();
        });

        dashboard.add(carRegistrationPanel);
        dashboard.add(vehicleIDInput);
        dashboard.add(carModelInput);
        dashboard.add(carMakeInput);
        dashboard.add(carYearInput);
        dashboard.add(timeStartInput);
        dashboard.add(timeEndInput);
        dashboard.add(vehicleIDPanel);
        dashboard.add(carModelPanel);
        dashboard.add(carMakePanel);
        dashboard.add(carYearPanel);
        dashboard.add(timeStartPanel);
        dashboard.add(timeEndPanel);
        dashboard.add(returnPanel);
        dashboard.add(submitPanel);

        dashboard.setVisible(true);
    }

    class submitPendingVehicle implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JPanel responsePanel = new JPanel();
            responsePanel.setBackground(Color.LIGHT_GRAY);
            responsePanel.setBounds(300, 550, 250, 75);
            JLabel response = new JLabel("Registration Info");

            if (carYearInput.getText().isEmpty() || carModelInput.getText().isEmpty()
                    || carMakeInput.getText().isEmpty() || timeStartInput.getText().isEmpty()
                    || timeEndInput.getText().isEmpty()) {
                response.setText("All text fields must be completed");
                responsePanel.add(response);
                dashboard.add(responsePanel);
                dashboard.setVisible(true);
            } else {

                String vehicleIDStr = vehicleIDInput.getText();
                int vehicleID = Integer.parseInt(vehicleIDStr);

                String carMake = carMakeInput.getText();

                String carModel = carModelInput.getText();

                String carYearStr = carYearInput.getText();
                int carYear = Integer.parseInt(carYearStr);

                String timeInStr = timeStartInput.getText();
                int timeIn = Integer.parseInt(timeInStr);

                String timeEndStr = timeEndInput.getText();
                int timeEnd = Integer.parseInt(timeEndStr);

                String info = vehicleID + "/" + carMake + "/" + carModel + "/"
                        + carYear + "/" + timeIn + "/" + timeEnd + "/" + "0";

                String messageIn = "";
                String messageOut = "";

                try {
                    System.out.println("----------*** This is client side ***--------");
                    System.out.println("client started!");
                    // connect the client socket to server
                    Socket socket = new Socket("localhost", 8000);

                    // client reads a message from Server
                    inputStream = new DataInputStream(socket.getInputStream());
                    outputStream = new DataOutputStream(socket.getOutputStream());

                    // client reads a message from keyboard
                    System.out.println("Enter a message you want to send to server side: ");

                    boolean sent = false;
                    while (!sent) {
                        messageOut = info;
                        outputStream.writeUTF(messageOut);
                        System.out.println("Message Sent!");
                        sent = true;
                    }
                    sent = false;

                } catch (Exception e1) {
                    e1.printStackTrace();
                }

                CloudController cc = new CloudController();
                OwnerDashboard dashboard1 = new OwnerDashboard();
                dashboard.dispose();
            }
        }
    }

    class returnButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            OwnerDashboard goToDash = new OwnerDashboard();
        }
    }
}