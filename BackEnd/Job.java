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

    public Job(String jobNameIn, String jobTypeIn, int durationIn, int jobDeadlineIn, int jobIDIn) {
        jobID = new Random().nextInt(100);
        jobName = jobNameIn;
        jobType = jobTypeIn;
        duration = durationIn;
        jobDeadline = jobDeadlineIn;
        jobID = jobIDIn;
    }

    public int getJobID() {
        return jobID;
    }

    public String getJobName() {
        return jobName;
    }

    public String getJobType() {
        return jobType;
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
        return "Job Name:" + jobName + " / Job Type:" + jobType + " / Job Duration:" + duration + " / Job Deadline:"
                + jobDeadline + " / Job ID:" + jobID;
    }

}
