import javax.swing.JFrame;

public class index {

    public static void main(String[] args) {

        LogInFrame logIn = new LogInFrame();

        ClientDashboard clientDashboard = new ClientDashboard();
        JFrame clientDash = clientDashboard.getFrame();
        clientDash.setVisible(false);

        OwnerDashboard ownerDashboard = new OwnerDashboard();
        JFrame ownerDash = ownerDashboard.getFrame();
        ownerDash.setVisible(false);

        ClientSubmission clientSubmission = new ClientSubmission();

        RegistrationFrame registrationFrame = new RegistrationFrame();

    }

}
