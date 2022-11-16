package GUI.ClientGUI;

import javax.swing.*;

import BackEnd.Entities.CloudController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
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

    JPanel jobNamePanel = new JPanel();

    JPanel jobDurationPanel = new JPanel();

    JPanel jobDeadlinePanel = new JPanel();

    JPanel jobIDPanel = new JPanel();

    JPanel jobTypePanel = new JPanel();

    // Labels for each text box.
    JLabel jobName = new JLabel("Job Name");
    JLabel jobType = new JLabel("Job Type");
    JLabel jobDuration = new JLabel("Approximate Job Duration");
    JLabel jobDeadline = new JLabel("Job Deadline");
    JLabel jobID = new JLabel("Job ID");

    JTextField jobNameInput, jobTypeInput, jobDurationInput, jobDeadlineInput, jobIDInput;

    JButton submitButton = new JButton("Submit");
    JButton goBackButton = new JButton("Go Back");

    Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingJobsApps.txt");
    File jobTranscript = file.toFile();

    static ServerSocket serverSocket;
    static Socket socket;
    static DataInputStream inputStream;
    static DataOutputStream outputStream;

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

        jobNamePanel.setBackground(Color.LIGHT_GRAY);
        jobNamePanel.setBounds(50, 200, 200, 50);
        jobName.setBounds(50, 200, 50, 50);
        jobNamePanel.add(jobName);

        jobTypePanel.setBackground(Color.LIGHT_GRAY);
        jobTypePanel.setBounds(50, 250, 200, 50);
        jobType.setBounds(50, 250, 50, 50);
        jobTypePanel.add(jobType);

        jobDurationPanel.setBackground(Color.LIGHT_GRAY);
        jobDurationPanel.setBounds(50, 300, 200, 50);
        jobDuration.setBounds(50, 300, 50, 50);
        jobDurationPanel.add(jobDuration);

        jobDeadlinePanel.setBackground(Color.LIGHT_GRAY);
        jobDeadlinePanel.setBounds(50, 350, 200, 50);
        jobDeadline.setBounds(50, 350, 50, 50);
        jobDeadlinePanel.add(jobDeadline);

        jobIDPanel.setBackground(Color.LIGHT_GRAY);
        jobIDPanel.setBounds(50, 400, 200, 50);
        jobID.setBounds(50, 400, 50, 50);
        jobIDPanel.add(jobID);

        // Setting up the text fields.
        jobNameInput = new JTextField();
        jobNameInput.setBounds(300, 200, 200, 50);

        jobTypeInput = new JTextField();
        jobTypeInput.setBounds(300, 250, 200, 50);

        jobDurationInput = new JTextField();
        jobDurationInput.setBounds(300, 300, 200, 50);

        jobDeadlineInput = new JTextField();
        jobDeadlineInput.setBounds(300, 350, 200, 50);

        jobIDInput = new JTextField();
        jobIDInput.setBounds(300, 400, 200, 50);

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

        submitPanel.add(submitButton);
        returnPanel.add(goBackButton);
        dashboard.add(returnPanel);
        dashboard.add(submitPanel);

        dashboard.add(jobDurationInput);
        dashboard.add(jobDeadlineInput);
        dashboard.add(jobIDInput);
        dashboard.add(jobNameInput);
        dashboard.add(jobTypeInput);
        dashboard.add(jobNamePanel);
        dashboard.add(jobDurationPanel);
        dashboard.add(jobDeadlinePanel);
        dashboard.add(jobIDPanel);
        dashboard.add(jobTypePanel);
        dashboard.setVisible(true);
    }

    class submitButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JPanel responsePanel = new JPanel();
            responsePanel.setBackground(Color.LIGHT_GRAY);
            responsePanel.setBounds(300, 550, 250, 75);
            JLabel response = new JLabel("Registration Info");

            if (jobNameInput.getText().isEmpty() || jobTypeInput.getText().isEmpty()
                    || jobDurationInput.getText().isEmpty() || jobDeadlineInput.getText().isEmpty()
                    || jobIDInput.getText().isEmpty()) {
                response.setText("All text fields must be completed");
                responsePanel.add(response);
                dashboard.add(responsePanel);
                dashboard.setVisible(true);
            } else {
                String str = "";
                try {
                    str = readFile(jobTranscript, StandardCharsets.UTF_8);
                } catch (IOException e2) {
                    e2.printStackTrace();
                }

                String jobName = jobNameInput.getText();
                String jobType = jobTypeInput.getText();
                String jobDurationStr = jobDurationInput.getText();
                int jobDuration = Integer.parseInt(jobDurationStr);
                String jobDeadlineStr = jobDeadlineInput.getText();
                int jobDeadline = Integer.parseInt(jobDeadlineStr);
                String jobIDStr = jobIDInput.getText();
                int jobID = Integer.parseInt(jobIDStr);

                String info = jobName + "/" + jobType
                        + "/" + jobDuration + "/" + jobDeadline + "/" + jobID + "/";

                String messageIn = "";
                String messageOut = "";

                try {
                    System.out.println("----------*** This is client side ***--------");
                    System.out.println("client started!");
                    // connect the client socket to server
                    Socket socket2 = new Socket("localhost", 1000);

                    // client reads a message from Server
                    inputStream = new DataInputStream(socket2.getInputStream());
                    outputStream = new DataOutputStream(socket2.getOutputStream());

                    // client reads a message from keyboard
                    System.out.println("Enter a message you want to send to server side: ");
                    // server sends the message to client
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
                ClientDashboard goToDash = new ClientDashboard();
                dashboard.dispose();
            }
        }
    }

    class returnButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            ClientDashboard goToDash = new ClientDashboard();
        }
    }

    public static String readFile(File file, Charset charset) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), charset);
    }
}