import javax.swing.*;
import java.awt.*;
public class registration {
    public static void main(String[] args) {
        //This frame will display the car registration form which will ask the user to input details such as car make, model and year. The inputs will then be received by the backend and added to the registry.
        JFrame dashboard = new JFrame("Car Registration");
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);
        //Setting up the title of the frame.
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(50, 100, 100));
        titlePanel.setBounds(300, 20, 600, 150);
        JLabel registrationTitle = new JLabel("Car Registration");
        registrationTitle.setForeground(Color.white);
        registrationTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(registrationTitle);
        dashboard.add(titlePanel);
        //Panel that is supposed to include all the components. I will come back to this later.
        
        JPanel form = new JPanel();
        form.setBackground(Color.LIGHT_GRAY);
        form.setBounds(50,300,100,50);
        
        
        //Labels for each text box.
        JLabel OwnerID = new JLabel("Owner ID");
        JLabel carModel = new JLabel("Car Model");    
        JLabel carMake = new JLabel("Car Make");
        JLabel carYear = new JLabel("Car Year");
        //Setting up the text fields.
        JTextField carModelInput, carMakeInput, carYearInput; 
        carModel.setBounds(50,300,50,50);
        form.add(carModel);
        carModelInput = new JTextField();
        carModelInput.setBounds(250,300,200,50);
        carMakeInput = new JTextField();
        carMakeInput.setBounds(250,400,200,50);
        carYearInput = new JTextField();
        carYearInput.setBounds(250,500,200,50);           
        dashboard.add(carModelInput);
        dashboard.add(carMakeInput);
        dashboard.add(carYearInput);
        dashboard.add(carModel);
        dashboard.add(carMake);
        dashboard.add(carYear);
        dashboard.add(form);
        dashboard.setVisible(true);

    }
}
