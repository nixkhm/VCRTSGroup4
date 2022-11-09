package GUI.OwnerGUI;

import javax.swing.*;

import BackEnd.Vehicle;
import BackEnd.Application.VehicleApplication;
import BackEnd.Entities.CloudController;
import GUI.ClientGUI.ClientDashboard;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class RegistrationFrame {

    // This frame will display the car registration form which will ask the user to
    // input details such as car make, model and year. The inputs will then be
    // received by the backend and added to the registry.
    JFrame dashboard = new JFrame("Car Registration");

    JPanel titlePanel = new JPanel();

    JLabel registrationTitle = new JLabel("Car Registration");

    JPanel submitPanel = new JPanel();

    JPanel returnPanel = new JPanel();

    JPanel jobNamePanel = new JPanel();

    JPanel jobDurationPanel = new JPanel();

    JPanel jobDeadlinePanel = new JPanel();

    JPanel timeInPanel = new JPanel();

    JPanel timeOutPanel = new JPanel();

    // Labels for each text box.
    JLabel carMake = new JLabel("Car Make");
    JLabel carModel = new JLabel("Car Model");
    JLabel carYear = new JLabel("Car Year");
    JLabel timeIn = new JLabel("Time Start");
    JLabel timeOut = new JLabel("Time End");

    JTextField carModelInput, carMakeInput, carYearInput, timeStartInput, timeEndInput;

    JButton submitButton = new JButton("Submit");

    JButton goBackButton = new JButton("Go Back");

    Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allVehicleApps.txt");
    File allVehiclesTranscript = file.toFile();

    public RegistrationFrame() {
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting up the titlePanel of the frame.
        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 600, 150);
        registrationTitle.setForeground(Color.white);
        registrationTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(registrationTitle);
        dashboard.add(titlePanel);

        // Panels that are supposed to include all the labels.
        jobDurationPanel.setBackground(Color.LIGHT_GRAY);
        jobDurationPanel.setBounds(50, 200, 200, 50);
        carMake.setBounds(50, 200, 50, 50);
        jobDurationPanel.add(carMake);

        jobNamePanel.setBackground(Color.LIGHT_GRAY);
        jobNamePanel.setBounds(50, 250, 200, 50);
        carModel.setBounds(50, 250, 50, 50);
        jobNamePanel.add(carModel);

        jobDeadlinePanel.setBackground(Color.LIGHT_GRAY);
        jobDeadlinePanel.setBounds(50, 300, 200, 50);
        carYear.setBounds(50, 300, 50, 50);
        jobDeadlinePanel.add(carYear);

        timeInPanel.setBackground(Color.LIGHT_GRAY);
        timeInPanel.setBounds(50, 350, 200, 50);
        timeIn.setBounds(50, 350, 50, 50);
        timeInPanel.add(timeIn);

        timeOutPanel.setBackground(Color.LIGHT_GRAY);
        timeOutPanel.setBounds(50, 400, 200, 50);
        timeOut.setBounds(50, 400, 50, 50);
        timeOutPanel.add(timeOut);

        submitPanel.setBounds(400, 500, 100, 50);
        returnPanel.setBounds(600, 500, 100, 50);
        submitPanel.add(submitButton);
        returnPanel.add(goBackButton);
        dashboard.add(returnPanel);
        dashboard.add(submitPanel);

        // Setting up the text fields.
        carMakeInput = new JTextField();
        carMakeInput.setBounds(300, 200, 200, 50);

        carModelInput = new JTextField();
        carModelInput.setBounds(300, 250, 200, 50);

        carYearInput = new JTextField();
        carYearInput.setBounds(300, 300, 200, 50);

        timeStartInput = new JTextField();
        timeStartInput.setBounds(300, 350, 200, 50);

        timeEndInput = new JTextField();
        timeEndInput.setBounds(300, 400, 200, 50);

        ActionListener goToDash = new submitButtonListener();
        submitButton.addActionListener(goToDash);
        submitButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToDash2 = new returnButtonListener();
        goBackButton.addActionListener(goToDash2);
        goBackButton.addActionListener(e -> {
            dashboard.dispose();
        });

        dashboard.add(carModelInput);
        dashboard.add(carMakeInput);
        dashboard.add(carYearInput);
        dashboard.add(timeStartInput);
        dashboard.add(timeEndInput);
        dashboard.add(jobNamePanel);
        dashboard.add(jobDurationPanel);
        dashboard.add(jobDeadlinePanel);
        dashboard.add(timeInPanel);
        dashboard.add(timeOutPanel);
        dashboard.setVisible(true);
    }

    class submitButtonListener implements ActionListener {
        // Once the user signs in by clicking the button, the program will generate a
        // file containing the time and date that the user logged in.

        public void actionPerformed(ActionEvent e) {
            JPanel responsePanel = new JPanel();
            responsePanel.setBackground(Color.LIGHT_GRAY);
            responsePanel.setBounds(300, 550, 250, 75);
            JLabel response = new JLabel("Registration Info");
           
            if(carYearInput.getText().isEmpty() || carModelInput.getText().isEmpty() || carMakeInput.getText().isEmpty() || timeStartInput.getText().isEmpty() || timeEndInput.getText().isEmpty()){                 
                 response.setText("All text fields must be completed");
                 responsePanel.add(response);
                 dashboard.add(responsePanel);
                 dashboard.setVisible(true);
}  
          else{
            String str = "";
            try {
                str = readFile(allVehiclesTranscript, StandardCharsets.UTF_8);
            } catch (IOException e2) {
                e2.printStackTrace();
            }

            String carMake = carMakeInput.getText();
            String carModel = carModelInput.getText();
            String carYearStr = carYearInput.getText();
            int carYear = Integer.parseInt(carYearStr);
            String timeInStr = timeStartInput.getText();
            int timeIn = Integer.parseInt(timeInStr);
            String timeEndStr = timeEndInput.getText();
            int timeEnd = Integer.parseInt(timeEndStr);

            String info = carMake + "/" + carModel + "/"
                    + carYear + "/" + timeIn + "/" + timeEnd + "/";

            try {
                FileWriter regTranscript = new FileWriter(allVehiclesTranscript);
                regTranscript.write(info + "\n");
                regTranscript.write(str);
                regTranscript.close();
            } catch (IOException e1) {

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

    public static String readFile(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }
}
