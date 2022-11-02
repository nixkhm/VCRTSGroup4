package BackEnd.model;

import BackEnd.*;
import java.util.*;

public class JobServer {

    Stack<Job> completedJobs;
    Queue<Job> inProgressJobs;

    public JobServer() {
        completedJobs = new Stack<Job>();
        inProgressJobs = new PriorityQueue<Job>();
    }

    public void eraseData() {

    }

    public Queue<Job> getJobsInProgress() {
        return inProgressJobs;
    }
}
