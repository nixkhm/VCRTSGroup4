package BackEnd;

import java.time.LocalTime;
import java.util.Random;

public class Job {

    private int jobID;
    private String jobName;
    private String jobType;
    private int duration;
    private int jobDeadline;
    private String notes;
    private int progress;

    public Job(String jobNameIn, String jobTypeIn, int durationIn, int jobDeadlineIn, String notesIn) {
        jobID = new Random().nextInt(100);
        jobName = jobNameIn;
        jobType = jobTypeIn;
        duration = durationIn;
        jobDeadline = jobDeadlineIn;
        notes = notesIn;
    }

    public int getJobID() {
        return jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public int getJobDuration() {
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

    public String toString() {
        return jobName + " " + jobType + " " + duration + " " + jobDeadline + " " + notes;
    }

}
