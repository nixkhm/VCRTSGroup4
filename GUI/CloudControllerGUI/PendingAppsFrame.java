package GUI.CloudControllerGUI;

import javax.swing.*;
import GUI.ButtonListeners.cloudControllerListener;
import java.awt.*;
import java.awt.event.ActionListener;

import BackEnd.*;
import BackEnd.Entities.CloudController;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.io.*;
class AcceptJobAppListener {
    public void acceptApp(int ID){
        //First, the file with all pending apps is opened.
        //----------------------------------------------------------------------------------------//

        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingJobApps.txt");      
        File allPendingJobTranscript = file.toFile();
        PrintWriter pendingJobTranscriptClear;
        try {
            //Deletes all the content from the text file so that it can then be refilled again without the approved submission.
            //----------------------------------------------------------------------------------------//

            pendingJobTranscriptClear = new PrintWriter(allPendingJobTranscript);
            pendingJobTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }    
        //Then, the file that contains all the approved submissions are opened. This is where the pending apps will be resubmitted. 
        //----------------------------------------------------------------------------------------//
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
            final ArrayList<Job> listofPendingJobApps = newAppList.getAllJobApps();
            for(int i = 0; i < listofPendingJobApps.size(); i++){
                //Remove the submission that was approved and transfer it to its proper file.
                  if(listofPendingJobApps.get(i).getJobID() == ID){
                        listofPendingJobApps.remove(i);
                        approve.write(listofPendingJobApps.get(i).getJobID()+"/"+listofPendingJobApps.get(i).getJobName()+"/"+listofPendingJobApps.get(i).getJobType()+"/"+listofPendingJobApps.get(i).getJobDuration()+"/"+listofPendingJobApps.get(i).getJobDeadline()+"/"+listofPendingJobApps.get(i).getJobNotes()+"/");
                  }
                  else{
                        insertBackIntoFile.write(listofPendingJobApps.get(i).getJobID()+"/"+listofPendingJobApps.get(i).getJobName()+"/"+listofPendingJobApps.get(i).getJobType()+"/"+listofPendingJobApps.get(i).getJobDuration()+"/"+listofPendingJobApps.get(i).getJobDeadline()+"/"+listofPendingJobApps.get(i).getJobNotes()+"/");
                                             
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
    public void rejectApp(int ID){
        //First, the file with all pending apps is opened.
        //----------------------------------------------------------------------------------------//

        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingJobApps.txt");      
        File allPendingJobTranscript = file.toFile();
        PrintWriter pendingJobTranscriptClear;
        try {
            //Deletes all the content from the text file so that it can then be refilled again without the approved submission.
            //----------------------------------------------------------------------------------------//

            pendingJobTranscriptClear = new PrintWriter(allPendingJobTranscript);
            pendingJobTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }    
        //Then, the file that contains all the approved submissions are opened. This is where the pending apps will be resubmitted. 
        //----------------------------------------------------------------------------------------//
        
              
        FileWriter insertBackIntoFile; 
        CloudController newAppList = new CloudController();
        try {
            
            insertBackIntoFile = new FileWriter(allPendingJobTranscript);
            final ArrayList<Job> listofPendingJobApps = newAppList.getAllJobApps();
            for(int i = 0; i < listofPendingJobApps.size(); i++){
                //Remove the submission that was approved and transfer it to its proper file.
                  if(listofPendingJobApps.get(i).getJobID() == ID){
                        listofPendingJobApps.remove(i);
                        
                  }
                  else{
                        insertBackIntoFile.write(listofPendingJobApps.get(i).getJobID()+"/"+listofPendingJobApps.get(i).getJobName()+"/"+listofPendingJobApps.get(i).getJobType()+"/"+listofPendingJobApps.get(i).getJobDuration()+"/"+listofPendingJobApps.get(i).getJobDeadline()+"/"+listofPendingJobApps.get(i).getJobNotes()+"/");
                                             
                  }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 
    }


class AcceptVehicleAppListener{
    public void acceptApp(int ID) throws FileNotFoundException{
        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingVehicleApps.txt");      
        File allPendingVehicleTranscript = file.toFile();
        PrintWriter pendingVehicleTranscriptClear;
        try {
            //Deletes all the content from the text file so that it can then be refilled again without the approved submission.
            //----------------------------------------------------------------------------------------//

            pendingVehicleTranscriptClear = new PrintWriter(allPendingVehicleTranscript);
            pendingVehicleTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }    
        //Then, the file that contains all the approved submissions are opened. This is where the pending apps will be resubmitted. 
        //----------------------------------------------------------------------------------------//
        Path toApprovedVehicleFile = FileSystems.getDefault().getPath("GUI/Transcripts/allVehicleApps.txt");
        File allApprovedVehicleFile = toApprovedVehicleFile.toFile();       
        FileWriter approve;
        
        FileWriter insertBackIntoFile; 
        CloudController newAppList = new CloudController();
        try {
            approve = new FileWriter(allApprovedVehicleFile);
            insertBackIntoFile = new FileWriter(allPendingVehicleTranscript);
            final ArrayList<Job> listofPendingVehicleApps = newAppList.getAllJobApps();
            for(int i = 0; i < listofPendingVehicleApps.size(); i++){
                //Remove the submission that was approved and transfer it to its proper file.
                  if(listofPendingVehicleApps.get(i).getJobID() == ID){
                    listofPendingVehicleApps.remove(i);
                    approve.write(listofPendingVehicleApps.get(i).getJobID()+"/"+listofPendingVehicleApps.get(i).getJobName()+"/"+listofPendingVehicleApps.get(i).getJobType()+"/"+listofPendingVehicleApps.get(i).getJobDuration()+"/"+listofPendingVehicleApps.get(i).getJobDeadline()+"/"+listofPendingVehicleApps.get(i).getJobNotes()+"/");
                  }
                  else{
                    //Reinsert all the other pending applications into the file. 
                        insertBackIntoFile.write(listofPendingVehicleApps.get(i).getJobID()+"/"+listofPendingVehicleApps.get(i).getJobName()+"/"+listofPendingVehicleApps.get(i).getJobType()+"/"+listofPendingVehicleApps.get(i).getJobDuration()+"/"+listofPendingVehicleApps.get(i).getJobDeadline()+"/"+listofPendingVehicleApps.get(i).getJobNotes()+"/");
                                             
                  }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
}
}
class RejectVehicleAppListener{
    public void rejectApp(int ID){
        Path file = FileSystems.getDefault().getPath("GUI/Transcripts/allPendingVehicleApps.txt");      
        File allPendingVehicleTranscript = file.toFile();
        PrintWriter pendingVehicleTranscriptClear;
        try {
            //Deletes all the content from the text file so that it can then be refilled again without the approved submission.
            //----------------------------------------------------------------------------------------//

            pendingVehicleTranscriptClear = new PrintWriter(allPendingVehicleTranscript);
            pendingVehicleTranscriptClear.close();
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }    
        //Then, the file that contains all the approved submissions are opened. This is where the pending apps will be resubmitted. 
        //----------------------------------------------------------------------------------------//
       
           
        
        
        FileWriter insertBackIntoFile; 
        CloudController newAppList = new CloudController();
        try {
            
            insertBackIntoFile = new FileWriter(allPendingVehicleTranscript);
            final ArrayList<Job> listofPendingVehicleApps = newAppList.getAllJobApps();
            for(int i = 0; i < listofPendingVehicleApps.size(); i++){
                //Remove the submission that was approved and transfer it to its proper file.
                  if(listofPendingVehicleApps.get(i).getJobID() == ID){
                    listofPendingVehicleApps.remove(i);
                        
                  }
                  else{
                        insertBackIntoFile.write(listofPendingVehicleApps.get(i).getJobID()+"/"+listofPendingVehicleApps.get(i).getJobName()+"/"+listofPendingVehicleApps.get(i).getJobType()+"/"+listofPendingVehicleApps.get(i).getJobDuration()+"/"+listofPendingVehicleApps.get(i).getJobDeadline()+"/"+listofPendingVehicleApps.get(i).getJobNotes()+"/");
                                             
                  }
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
    

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
    JLabel ownerApplications = new JLabel("No Current Applications");
    JLabel renterApplications = new JLabel("No Current Applications");

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
        dashboard.add(titlePanel);

        ownerAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        ownerAppTitlePanel.setBounds(50, 200, 500, 50);
        ownerAppTitle.setBounds(50, 200, 50, 50);
        ownerAppTitlePanel.add(ownerAppTitle);

        ownerAppPanel.setBackground(Color.LIGHT_GRAY);
        ownerAppPanel.setBounds(50, 250, 500, 300);
        ownerApplications.setBounds(50, 250, 500, 300);

        renterAppTitlePanel.setBackground(Color.LIGHT_GRAY);
        renterAppTitlePanel.setBounds(650, 200, 500, 50);
        renterAppTitle.setBounds(650, 200, 50, 50);
        renterAppTitlePanel.add(renterAppTitle);

        renterAppPanel.setBackground(Color.LIGHT_GRAY);
        renterAppPanel.setBounds(650, 250, 500, 300);
        renterApplications.setBounds(650, 250, 500, 300);

        returnPanel.setBounds(550, 600, 100, 50);
        ActionListener cloud = new cloudControllerListener();

        /*
         * This portion of the code will display the pending job and vehicle
         * application. Within this frame, the cloud controller can then decide whether
         * to accept or reject the pending applications.
         */
        CloudController cc = new CloudController();

        try {
            final ArrayList<Job> listofPendingJobApps = cc.getAllJobApps();
            final ArrayList<Vehicle> listOfPendingVehicleApps = cc.getAllVehApps();
            if (listofPendingJobApps.size() == 0) {
                renterAppPanel.add(renterApplications);
            }

            else {
                // Table for pending Job applications
                // -----------------------------------------------------------------------------//

                JTable pendingJobApps = new JTable(11, 5);
                String headers[] = { "Job ID", "Name", "Type", "Duration", "Deadline" };
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
                }
                pendingJobApps.setBounds(15, 15, 720, 175);
                renterAppPanel.add(pendingJobApps);

            }
            if (listOfPendingVehicleApps.size() == 0) {
                ownerAppPanel.add(ownerApplications);
            } else {
                // Table for pending vehicle applications
                // -----------------------------------------------------------------------------//
                JTable pendingVehicleApps = new JTable(11, 5);
                String vehHeaders[] = { "Make", "Model", "Year", "In", "Out" };
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
                }
                pendingVehicleApps.setBounds(75, 15, 720, 175);
                ownerAppPanel.add(pendingVehicleApps);
                JButton accButton = new JButton();
                AcceptJobAppListener accept = new AcceptJobAppListener();
                accButton.addActionListener(e -> accept.acceptApp(2));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        returnButton.addActionListener(cloud);
        returnButton.addActionListener(e -> {
            dashboard.dispose();
        });
        returnPanel.add(returnButton);

        dashboard.add(titlePanel);
        dashboard.setVisible(true);
        dashboard.add(ownerAppTitlePanel);
        dashboard.add(renterAppTitlePanel);
        dashboard.add(ownerAppPanel);
        dashboard.add(renterAppPanel);
        dashboard.add(returnPanel);
    }

    
}
