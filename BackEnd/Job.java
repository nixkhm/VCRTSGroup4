package BackEnd;

public class Job {

    private int jobID;
    private String jobName;
    private String jobType;
    private int duration;
    private int jobDeadline;
    private String notes;
    private int progress;

    public Job(int jobIDIn, String jobNameIn, String jobTypeIn, int durationIn, int jobDeadlineIn) {
        jobID = jobIDIn;
        jobName = jobNameIn;
        jobType = jobTypeIn;
        duration = durationIn;
        jobDeadline = jobDeadlineIn;
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
