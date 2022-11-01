package GUI.ClientGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.format.*;
import java.time.*;

public class ClientSubmission {

    // This frame will display the car registration form which will ask the user to
    // input details such as car make, model and year. The inputs will then be
    // received by the backend and added to the registry.
    JFrame dashboard = new JFrame("Submit a Job");

    JPanel titlePanel = new JPanel();

    JLabel registrationTitle = new JLabel("Submit a Job");

    JPanel submitPanel = new JPanel();

    JPanel returnPanel = new JPanel();

    JPanel carModelPanel = new JPanel();

    JPanel carMakePanel = new JPanel();

    JPanel carYearPanel = new JPanel();

    JPanel ownerIdPanel = new JPanel();

    JPanel durationOfRegistryPanel = new JPanel();

    // Labels for each text box.
    JLabel clientID = new JLabel("Client ID");
    JLabel jobType = new JLabel("Job Type");
    JLabel approxJobDuration = new JLabel("Approximate Job Duration");
    JLabel jobDeadline = new JLabel("Job Deadline");
    JLabel notes = new JLabel("Notes (Optional)");

    JTextField approxInput, jobDeadlineInput, notesInput, clientIdInput, jobTypeInput;

    JButton submitButton = new JButton("Submit");

    JButton goBackButton = new JButton("Go Back");

    Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allJobsApps.txt");
    File jobTranscript = file.toFile();

    public ClientSubmission() throws IOException {

        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);
        // Setting up the title of the frame.
        titlePanel.setBackground(new Color(50, 100, 100));
        titlePanel.setBounds(300, 20, 600, 150);

        registrationTitle.setForeground(Color.white);
        registrationTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(registrationTitle);
        dashboard.add(titlePanel);

        // Panels that are supposed to include all the labels.
        submitPanel.setBounds(400, 500, 100, 50);
        returnPanel.setBounds(600, 500, 100, 50);
        carModelPanel.setBackground(Color.LIGHT_GRAY);
        carModelPanel.setBounds(50, 300, 200, 50);
        carMakePanel.setBackground(Color.LIGHT_GRAY);
        carMakePanel.setBounds(50, 350, 200, 50);
        carYearPanel.setBackground(Color.LIGHT_GRAY);
        carYearPanel.setBounds(50, 400, 200, 50);
        ownerIdPanel.setBackground(Color.LIGHT_GRAY);
        ownerIdPanel.setBounds(50, 200, 200, 50);

        durationOfRegistryPanel.setBackground(Color.LIGHT_GRAY);
        durationOfRegistryPanel.setBounds(50, 250, 200, 50);

        approxJobDuration.setBounds(50, 300, 50, 50);
        clientID.setBounds(50, 200, 50, 50);
        jobType.setBounds(50, 250, 50, 50);
        jobDeadline.setBounds(50, 350, 50, 50);
        notes.setBounds(50, 400, 50, 50);
        carModelPanel.add(approxJobDuration);
        carMakePanel.add(jobDeadline);
        carYearPanel.add(notes);
        ownerIdPanel.add(clientID);
        durationOfRegistryPanel.add(jobType);

        // Setting up the text fields.
        clientIdInput = new JTextField();
        clientIdInput.setBounds(300, 200, 200, 50);
        jobTypeInput = new JTextField();
        jobTypeInput.setBounds(300, 250, 200, 50);
        approxInput = new JTextField();
        approxInput.setBounds(300, 300, 200, 50);
        jobDeadlineInput = new JTextField();
        jobDeadlineInput.setBounds(300, 350, 200, 50);
        notesInput = new JTextField();
        notesInput.setBounds(300, 400, 200, 50);

        ActionListener goToDash = new submitButtonListener();
        submitButton.addActionListener(goToDash);
        submitButton.addActionListener(e -> {
            dashboard.dispose();
        });

        ActionListener goToDash2 = new submitButtonListener();
        goBackButton.addActionListener(goToDash2);
        goBackButton.addActionListener(e -> {
            dashboard.dispose();
        });

        // Submit button
        submitPanel.add(submitButton);
        returnPanel.add(goBackButton);
        dashboard.add(returnPanel);
        dashboard.add(submitPanel);
        dashboard.add(approxInput);
        dashboard.add(jobDeadlineInput);
        dashboard.add(notesInput);
        dashboard.add(clientIdInput);
        dashboard.add(jobTypeInput);
        dashboard.add(carModelPanel);
        dashboard.add(carMakePanel);
        dashboard.add(carYearPanel);
        dashboard.add(ownerIdPanel);
        dashboard.add(durationOfRegistryPanel);
        dashboard.setVisible(true);
    }

    class submitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            String str = "";
            try {
                str = readFile(jobTranscript, StandardCharsets.UTF_8);
            } catch (IOException e2) {
                e2.printStackTrace();
            }

            DateTimeFormatter jobTimeAndDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            String date = "" + jobTimeAndDate.format(now);
            String clientID = clientIdInput.getText();
            String approxJobDuration = jobTypeInput.getText();
            String jobType = approxInput.getText();
            String jobDeadline = jobDeadlineInput.getText();
            String notesOptional = notesInput.getText();
            String info = "\n clientID: " + clientID + "\n Approximate job duration: " + approxJobDuration
                    + "\n Job type: " + jobType + "\n Job Deadline: " + jobDeadline + "\n Notes: " + notesOptional + "";
            try {
                FileWriter regTranscript = new FileWriter(jobTranscript);
                regTranscript.write(date);
                regTranscript.write(info + "\n");
                regTranscript.write(str);
                regTranscript.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

            ClientDashboard goToDash = new ClientDashboard();
        }
    }

    public static String readFile(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }
}