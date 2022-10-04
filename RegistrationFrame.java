import javax.swing.*;
import java.awt.*;

public class RegistrationFrame {
    public static void main(String[] args) {
        // This frame will display the car registration form which will ask the user to
        // input details such as car make, model and year. The inputs will then be
        // received by the backend and added to the registry.
        JFrame dashboard = new JFrame("Car Registration");
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);
        // Setting up the title of the frame.
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(249, 217, 126));
        titlePanel.setBounds(300, 20, 600, 150);
        JLabel registrationTitle = new JLabel("Car Registration");
        registrationTitle.setForeground(Color.white);
        registrationTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(registrationTitle);
        dashboard.add(titlePanel);

        // Panels that are supposed to include all the labels.
        JPanel submitPanel = new JPanel();
        submitPanel.setBounds(400, 500, 100, 50);
        JPanel carModelPanel = new JPanel();
        carModelPanel.setBackground(Color.LIGHT_GRAY);
        carModelPanel.setBounds(50, 300, 200, 50);
        JPanel carMakePanel = new JPanel();
        carMakePanel.setBackground(Color.LIGHT_GRAY);
        carMakePanel.setBounds(50, 350, 200, 50);
        JPanel carYearPanel = new JPanel();
        carYearPanel.setBackground(Color.LIGHT_GRAY);
        carYearPanel.setBounds(50, 400, 200, 50);
        JPanel ownerIdPanel = new JPanel();
        ownerIdPanel.setBackground(Color.LIGHT_GRAY);
        ownerIdPanel.setBounds(50, 200, 200, 50);
        JPanel durationOfRegistryPanel = new JPanel();
        durationOfRegistryPanel.setBackground(Color.LIGHT_GRAY);
        durationOfRegistryPanel.setBounds(50, 250, 200, 50);

        // Labels for each text box.
        JLabel ownerID = new JLabel("Owner ID");
        JLabel durationOfRegistry = new JLabel("Duration of registry input");
        JLabel carModel = new JLabel("Car Model");
        JLabel carMake = new JLabel("Car Make");
        JLabel carYear = new JLabel("Car Year");
        carModel.setBounds(50, 300, 50, 50);
        ownerID.setBounds(50, 200, 50, 50);
        durationOfRegistry.setBounds(50, 250, 50, 50);
        carMake.setBounds(50, 350, 50, 50);
        carYear.setBounds(50, 400, 50, 50);
        carModelPanel.add(carModel);
        carMakePanel.add(carMake);
        carYearPanel.add(carYear);
        ownerIdPanel.add(ownerID);
        durationOfRegistryPanel.add(durationOfRegistry);

        // Setting up the text fields.
        JTextField carModelInput, carMakeInput, carYearInput, ownerIdInput, durationOfRegistryInput;
        ownerIdInput = new JTextField();
        ownerIdInput.setBounds(300, 200, 200, 50);
        durationOfRegistryInput = new JTextField();
        durationOfRegistryInput.setBounds(300, 250, 200, 50);
        carModelInput = new JTextField();
        carModelInput.setBounds(300, 300, 200, 50);
        carMakeInput = new JTextField();
        carMakeInput.setBounds(300, 350, 200, 50);
        carYearInput = new JTextField();
        carYearInput.setBounds(300, 400, 200, 50);

        // Submit button
        JButton submitButton = new JButton("Submit");
        submitPanel.add(submitButton);
        dashboard.add(submitPanel);
        dashboard.add(carModelInput);
        dashboard.add(carMakeInput);
        dashboard.add(carYearInput);
        dashboard.add(ownerIdInput);
        dashboard.add(durationOfRegistryInput);
        dashboard.add(carModelPanel);
        dashboard.add(carMakePanel);
        dashboard.add(carYearPanel);
        dashboard.add(ownerIdPanel);
        dashboard.add(durationOfRegistryPanel);
        dashboard.setVisible(true);

    }
}
