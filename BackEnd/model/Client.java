package BackEnd.model;

import java.util.Queue;

public class Client extends User {

    private Queue<Job> jobs;

    public Client(String nameIn, String emailIn, int phoneIn, User entityIn, Queue<Job> jobsIn) {
        super(nameIn, emailIn, phoneIn, entityIn);
        jobs = jobsIn;
    }

    public Queue<Job> getJobs() {
        return jobs;
    }

}
