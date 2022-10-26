package BackEnd;

import java.time.LocalTime;
import java.util.Random;

import BackEnd.Entities.Client;

public class Job {

    private int jobID;
    private String jobName;
    private LocalTime duration;
    private int jobDeadline;
    private String notes;
    private int progress;
    private Client client;

    public Job(String jobNameIn, int jobDeadlineIn, String notesIn, Client clientIn) {
        jobID = new Random().nextInt(100);
        jobName = jobNameIn;
        duration = LocalTime.now();
        jobDeadline = jobDeadlineIn;
        notes = notesIn;
        client = clientIn;
    }

    public int getJobID() {
        return jobID;

    }

    public String getJobName() {
        return jobName;

    }

    public LocalTime getJobDuration() {
        return duration;

    }

    public int getJobDeadline() {
        return jobDeadline;

    }

    public String getJobNotes() {
        return notes;

    }

    public int getJobProgress() {
        return progress;

    }

    public Client getJobClient() {
        return client;

    }

}
