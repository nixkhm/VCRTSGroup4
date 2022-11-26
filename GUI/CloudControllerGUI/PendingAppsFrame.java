package GUI.CloudControllerGUI;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;

import GUI.ButtonListeners.cloudControllerListener;
import java.awt.*;
import java.awt.event.ActionListener;

import BackEnd.*;
import BackEnd.Entities.CloudController;
import java.util.*;
import java.awt.event.ActionEvent;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.io.*;

public class PendingAppsFrame {

    JFrame dashboard = new JFrame("Pending Application Dashboard");

    JPanel titlePanel = new JPanel();
    JPanel ownerAppTitlePanel = new JPanel();
    JPanel renterAppTitlePanel = new JPanel();
    JPanel ownerAppPanel = new JPanel();
    JPanel renterAppPanel = new JPanel();
    JPanel returnPanel = new JPanel();

    JLabel dashboardTitle = new JLabel("Pending Applications");
    JLabel ownerAppTitle = new JLabel("Owner Applications");
    JLabel renterAppTitle = new JLabel("Renter Applications");
    JLabel noCurrentJobsLabel = new JLabel("No Current Job Applications");
    JLabel noCurrentVehiclesLabel = new JLabel("No Current Vehicle Applications");

    JButton returnButton = new JButton("Return");

    public PendingAppsFrame() {

        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);

        // Setting up the title of the frame.
        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 600, 150);
        dashboardTitle.setForeground(Color.white);
        dashboardTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(dashboardTitle);

        ownerAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        ownerAppTitlePanel.setBounds(50, 200, 550, 50);
        ownerAppTitle.setBounds(50, 200, 50, 50);
        ownerAppTitlePanel.add(ownerAppTitle);

        ownerAppPanel.setBackground(Color.LIGHT_GRAY);
        ownerAppPanel.setBounds(50, 250, 550, 300);

        renterAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        renterAppTitlePanel.setBounds(650, 200, 550, 50);
        renterAppTitle.setBounds(650, 200, 50, 50);
        renterAppTitlePanel.add(renterAppTitle);

        renterAppPanel.setBackground(Color.LIGHT_GRAY);
        renterAppPanel.setBounds(650, 250, 550, 300);

        noCurrentJobsLabel.setBounds(650, 250, 500, 300);
        noCurrentVehiclesLabel.setBounds(650, 250, 500, 300);

        returnPanel.setBounds(550, 600, 100, 50);

        ActionListener cloud = new cloudControllerListener();

        // populating pending aplication tables for jobs and vehicles
        CloudController cc = new CloudController();
        populateTables(cc);

        // return button
        returnButton.addActionListener(cloud);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.add(ownerAppTitlePanel);
        dashboard.add(renterAppTitlePanel);
        dashboard.add(ownerAppPanel);
        dashboard.add(renterAppPanel);
        dashboard.add(returnPanel);

        dashboard.setVisible(true);
    }

    public void populateTables(CloudController cc) {
        try {
            final ArrayList<Job> listofPendingJobApps = cc.getAllPendingJobApps();
            final ArrayList<Vehicle> listOfPendingVehicleApps = cc.getAllPendingVehicles();

            for (Job j : listofPendingJobApps)
                System.out.println(j);

            if (listofPendingJobApps.size() == 0) {
                renterAppPanel.add(noCurrentJobsLabel);
            } else {

                // Table for pending Job applications
                // -----------------------------------------------------------------------------//

                JTable pendingJobApps = new JTable(11, 7);
                String headers[] = { "Job ID", "Name", "Type", "Duration", "Deadline", "Accept", "Decline" };
                for (int i = 0; i < headers.length; i++) {
                    pendingJobApps.setValueAt(headers[i], 0, i);

                }
                int x = 10;
                if (listofPendingJobApps.size() < x) {
                    x = listofPendingJobApps.size();
                }
                for (int i = 0; i < x; i++) {
                    pendingJobApps.setValueAt(listofPendingJobApps.get(i).getJobID(), i + 1, 0);
                    pendingJobApps.setValueAt(listofPendingJobApps.get(i).getJobName(), i + 1, 1);
                    pendingJobApps.setValueAt(listofPendingJobApps.get(i).getJobType(), i + 1, 2);
                    pendingJobApps.setValueAt(listofPendingJobApps.get(i).getJobDuration(), i + 1, 3);
                    pendingJobApps.setValueAt(listofPendingJobApps.get(i).getJobDeadline(), i + 1, 4);

                    pendingJobApps.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
                    pendingJobApps.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));

                    pendingJobApps.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
                    pendingJobApps.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));

                }
                pendingJobApps.setBounds(15, 15, 800, 175);
                renterAppPanel.add(pendingJobApps);

            }
            if (listOfPendingVehicleApps.size() == 0) {
                ownerAppPanel.add(noCurrentVehiclesLabel);
            } else {
                // Table for pending vehicle applications
                // -----------------------------------------------------------------------------//
                JTable pendingVehicleApps = new JTable(11, 7);
                String vehHeaders[] = { "Make", "Model", "Year", "In", "Out", "Accept", "Decline" };
                for (int i = 0; i < vehHeaders.length; i++) {
                    pendingVehicleApps.setValueAt(vehHeaders[i], 0, i);
                }
                int y = 10;
                if (listOfPendingVehicleApps.size() < y) {
                    y = listOfPendingVehicleApps.size();
                }
                for (int i = 0; i < y; i++) {
                    pendingVehicleApps.setValueAt(listOfPendingVehicleApps.get(i).getMake(), i + 1, 0);
                    pendingVehicleApps.setValueAt(listOfPendingVehicleApps.get(i).getModel(), i + 1, 1);
                    pendingVehicleApps.setValueAt(listOfPendingVehicleApps.get(i).getYear(), i + 1, 2);
                    pendingVehicleApps.setValueAt(listOfPendingVehicleApps.get(i).getTimeStart(), i + 1, 3);
                    pendingVehicleApps.setValueAt(listOfPendingVehicleApps.get(i).getTimeEnd(), i + 1, 4);

                    pendingVehicleApps.getColumnModel().getColumn(5).setCellRenderer(new ButtonRenderer());
                    pendingVehicleApps.getColumnModel().getColumn(5).setCellEditor(new ButtonEditor(new JTextField()));

                    pendingVehicleApps.getColumnModel().getColumn(6).setCellRenderer(new ButtonRenderer());
                    pendingVehicleApps.getColumnModel().getColumn(6).setCellEditor(new ButtonEditor(new JTextField()));
                }
                pendingVehicleApps.setBounds(75, 100, 720, 175);
                ownerAppPanel.add(pendingVehicleApps);
                JButton accButton = new JButton();
                AcceptJobAppListener accept = new AcceptJobAppListener();
                accButton.addActionListener(e -> accept.acceptApp(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// BUTTON RENDERER CLASS
class ButtonRenderer extends JButton implements TableCellRenderer {

    // CONSTRUCTOR
    public ButtonRenderer() {
        // SET BUTTON PROPERTIES
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object obj,
            boolean selected, boolean focused, int row, int col) {

        // SET PASSED OBJECT AS BUTTON TEXT
        setText((obj == null) ? "" : obj.toString());

        return this;
    }

}

// BUTTON EDITOR CLASS
class ButtonEditor extends DefaultCellEditor {

    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditor(JTextField txt) {
        super(txt);

        btn = new JButton();
        btn.setOpaque(true);

        // WHEN BUTTON IS CLICKED
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                fireEditingStopped();
            }
        });
    }

    // OVERRIDE A COUPLE OF METHODS
    @Override
    public Component getTableCellEditorComponent(JTable table, Object obj,
            boolean selected, int row, int col) {

        // SET TEXT TO BUTTON,SET CLICKED TO TRUE,THEN RETURN THE BTN OBJECT
        lbl = (obj == null) ? "" : obj.toString();
        btn.setText(lbl);
        clicked = true;
        return btn;
    }

    // IF BUTTON CELL VALUE CHNAGES,IF CLICKED THAT IS
    @Override
    public Object getCellEditorValue() {

        if (clicked) {
            // SHOW US SOME MESSAGE
            JOptionPane.showMessageDialog(btn, "Button Clicked");
        }
        // SET IT TO FALSE NOW THAT ITS CLICKED
        clicked = false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {

        // SET CLICKED TO FALSE FIRST
        clicked = true;
        return super.stopCellEditing();
    }

    @Override
    protected void fireEditingStopped() {
        // TODO Auto-generated method stub
        super.fireEditingStopped();
    }
}

class AcceptJobAppListener {
    public void acceptApp(int ID) {
        // First, the file with all pending apps is opened.
        // ----------------------------------------------------------------------------------------//

        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingJobApps.txt");
        File allPendingJobTranscript = file.toFile();
        PrintWriter pendingJobTranscriptClear;
        try {
            // Deletes all the content from the text file so that it can then be refilled
            // again without the approved submission.
            // ----------------------------------------------------------------------------------------//

            pendingJobTranscriptClear = new PrintWriter(allPendingJobTranscript);
            pendingJobTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // Then, the file that contains all the approved submissions are opened. This is
        // where the pending apps will be resubmitted.
        // ----------------------------------------------------------------------------------------//
        Path toApprovedJobFile = FileSystems.getDefault().getPath("GUI/Transcripts/allJobsApps.txt");
        File allApprovedJobsFile = toApprovedJobFile.toFile();
        Scanner read;
        try {
            read = new Scanner(allPendingJobTranscript);

            FileWriter approve;
            FileWriter insertBackIntoFile;
            CloudController newAppList = new CloudController();
            try {
                approve = new FileWriter(allApprovedJobsFile);
                insertBackIntoFile = new FileWriter(allPendingJobTranscript);
                final ArrayList<Job> listofPendingJobApps = newAppList.getAllPendingJobApps();
                for (int i = 0; i < listofPendingJobApps.size(); i++) {
                    // Remove the submission that was approved and transfer it to its proper file.
                    if (listofPendingJobApps.get(i).getJobID() == ID) {
                        listofPendingJobApps.remove(i);
                        approve.write(
                                listofPendingJobApps.get(i).getJobID() + "/" + listofPendingJobApps.get(i).getJobName()
                                        + "/" + listofPendingJobApps.get(i).getJobType() + "/"
                                        + listofPendingJobApps.get(i).getJobDuration() + "/"
                                        + listofPendingJobApps.get(i).getJobDeadline() + "/"
                                        + listofPendingJobApps.get(i).getJobNotes() + "/");
                    } else {
                        insertBackIntoFile.write(
                                listofPendingJobApps.get(i).getJobID() + "/" + listofPendingJobApps.get(i).getJobName()
                                        + "/" + listofPendingJobApps.get(i).getJobType() + "/"
                                        + listofPendingJobApps.get(i).getJobDuration() + "/"
                                        + listofPendingJobApps.get(i).getJobDeadline() + "/"
                                        + listofPendingJobApps.get(i).getJobNotes() + "/");

                    }
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }
}

class rejectJobAppListener {
    public void rejectApp(int ID) {
        // First, the file with all pending apps is opened.
        // ----------------------------------------------------------------------------------------//

        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingJobApps.txt");
        File allPendingJobTranscript = file.toFile();
        PrintWriter pendingJobTranscriptClear;
        try {
            // Deletes all the content from the text file so that it can then be refilled
            // again without the approved submission.
            // ----------------------------------------------------------------------------------------//

            pendingJobTranscriptClear = new PrintWriter(allPendingJobTranscript);
            pendingJobTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // Then, the file that contains all the approved submissions are opened. This is
        // where the pending apps will be resubmitted.
        // ----------------------------------------------------------------------------------------//

        FileWriter insertBackIntoFile;
        CloudController newAppList = new CloudController();
        try {

            insertBackIntoFile = new FileWriter(allPendingJobTranscript);
            final ArrayList<Job> listofPendingJobApps = newAppList.getAllPendingJobApps();
            for (int i = 0; i < listofPendingJobApps.size(); i++) {
                // Remove the submission that was approved and transfer it to its proper file.
                if (listofPendingJobApps.get(i).getJobID() == ID) {
                    listofPendingJobApps.remove(i);

                } else {
                    insertBackIntoFile.write(listofPendingJobApps.get(i).getJobID() + "/"
                            + listofPendingJobApps.get(i).getJobName() + "/" + listofPendingJobApps.get(i).getJobType()
                            + "/" + listofPendingJobApps.get(i).getJobDuration() + "/"
                            + listofPendingJobApps.get(i).getJobDeadline() + "/"
                            + listofPendingJobApps.get(i).getJobNotes() + "/");

                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}

class AcceptVehicleAppListener {
    public void acceptApp(int ID) throws FileNotFoundException {
        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingVehicleApps.txt");
        File allPendingVehicleTranscript = file.toFile();
        PrintWriter pendingVehicleTranscriptClear;
        try {
            // Deletes all the content from the text file so that it can then be refilled
            // again without the approved submission.
            // ----------------------------------------------------------------------------------------//

            pendingVehicleTranscriptClear = new PrintWriter(allPendingVehicleTranscript);
            pendingVehicleTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // Then, the file that contains all the approved submissions are opened. This is
        // where the pending apps will be resubmitted.
        // ----------------------------------------------------------------------------------------//
        Path toApprovedVehicleFile = FileSystems.getDefault().getPath("GUI/Transcripts/allVehicleApps.txt");
        File allApprovedVehicleFile = toApprovedVehicleFile.toFile();
        FileWriter approve;

        FileWriter insertBackIntoFile;
        CloudController newAppList = new CloudController();
        try {
            approve = new FileWriter(allApprovedVehicleFile);
            insertBackIntoFile = new FileWriter(allPendingVehicleTranscript);
            final ArrayList<Job> listofPendingVehicleApps = newAppList.getAllPendingJobApps();
            for (int i = 0; i < listofPendingVehicleApps.size(); i++) {
                // Remove the submission that was approved and transfer it to its proper file.
                if (listofPendingVehicleApps.get(i).getJobID() == ID) {
                    listofPendingVehicleApps.remove(i);
                    approve.write(listofPendingVehicleApps.get(i).getJobID() + "/"
                            + listofPendingVehicleApps.get(i).getJobName() + "/"
                            + listofPendingVehicleApps.get(i).getJobType() + "/"
                            + listofPendingVehicleApps.get(i).getJobDuration() + "/"
                            + listofPendingVehicleApps.get(i).getJobDeadline() + "/"
                            + listofPendingVehicleApps.get(i).getJobNotes() + "/");
                } else {
                    // Reinsert all the other pending applications into the file.
                    insertBackIntoFile.write(listofPendingVehicleApps.get(i).getJobID() + "/"
                            + listofPendingVehicleApps.get(i).getJobName() + "/"
                            + listofPendingVehicleApps.get(i).getJobType() + "/"
                            + listofPendingVehicleApps.get(i).getJobDuration() + "/"
                            + listofPendingVehicleApps.get(i).getJobDeadline() + "/"
                            + listofPendingVehicleApps.get(i).getJobNotes() + "/");

                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}

class RejectVehicleAppListener {
    public void rejectApp(int ID) {
        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingVehicleApps.txt");
        File allPendingVehicleTranscript = file.toFile();
        PrintWriter pendingVehicleTranscriptClear;
        try {
            // Deletes all the content from the text file so that it can then be refilled
            // again without the approved submission.
            // ----------------------------------------------------------------------------------------//

            pendingVehicleTranscriptClear = new PrintWriter(allPendingVehicleTranscript);
            pendingVehicleTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // Then, the file that contains all the approved submissions are opened. This is
        // where the pending apps will be resubmitted.
        // ----------------------------------------------------------------------------------------//

        FileWriter insertBackIntoFile;
        CloudController newAppList = new CloudController();
        try {

            insertBackIntoFile = new FileWriter(allPendingVehicleTranscript);
            final ArrayList<Job> listofPendingVehicleApps = newAppList.getAllPendingJobApps();
            for (int i = 0; i < listofPendingVehicleApps.size(); i++) {
                // Remove the submission that was approved and transfer it to its proper file.
                if (listofPendingVehicleApps.get(i).getJobID() == ID) {
                    listofPendingVehicleApps.remove(i);

                } else {
                    insertBackIntoFile.write(listofPendingVehicleApps.get(i).getJobID() + "/"
                            + listofPendingVehicleApps.get(i).getJobName() + "/"
                            + listofPendingVehicleApps.get(i).getJobType() + "/"
                            + listofPendingVehicleApps.get(i).getJobDuration() + "/"
                            + listofPendingVehicleApps.get(i).getJobDeadline() + "/"
                            + listofPendingVehicleApps.get(i).getJobNotes() + "/");

                }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
