import javax.swing.*;
import java.awt.*;
public class registration {
    public static void main(String[] args) {
        JFrame dashboard = new JFrame("Car Registration");
        dashboard.setSize(1200, 800);
        dashboard.setLocationRelativeTo(null);
        dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dashboard.setResizable(false);
        dashboard.getContentPane().setBackground(new Color(41, 55, 77));
        dashboard.setLayout(null);
        JPanel titlePanel = new JPanel();
        titlePanel.setBackground(new Color(50, 100, 100));
        titlePanel.setBounds(300, 20, 600, 150);
        JLabel registrationTitle = new JLabel("Car Registration");
        registrationTitle.setForeground(Color.white);
        registrationTitle.setFont(new Font("Monospaced", Font.BOLD, 35));
        titlePanel.add(registrationTitle);
        dashboard.add(titlePanel);
        JTextField carModel, carMake, carYear; 
        carModel = new JTextField("");
        carMake = new JTextField("");
        carYear = new JTextField("");


        dashboard.setVisible(true);

    }
}
