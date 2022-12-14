package BackEnd;

public class Job {

    private int jobID;
    private String jobName;
    private String jobType;
    private int duration;
    private String jobDeadline;
    private String notes;
    private int status;

    public Job(int jobIDIn, String jobNameIn, String jobTypeIn, int durationIn, String jobDeadlineIn, int statusIn) {
        jobID = jobIDIn;
        jobName = jobNameIn;
        jobType = jobTypeIn;
        duration = durationIn;
        jobDeadline = jobDeadlineIn;
        status = statusIn;
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

    public String getJobDeadline() {
        return jobDeadline;
    }

    public String getJobNotes() {
        return notes;
    }

    public int getStatus() {
        return status;
    }

    public String toString() {
        return "Job Name:" + jobName + " / Job Type:" + jobType + " / Job Duration:" + duration + " / Job Deadline:"
                + jobDeadline + " / Job ID:" + jobID;
    }

}
