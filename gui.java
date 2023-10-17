// creating a notepad in java

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

public class gui{

    private JPanel panel;
    private JFrame frame;
    private JLabel topTitle;
    public gui(){

        panel = new JPanel();
        frame = new JFrame();
        topTitle = new JLabel("Welcome Back!");

        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(1000, 1000, 1000, 1000));
        panel.setBackground(Color.WHITE);
        panel.add(topTitle);
        
        frame.add(panel, BorderLayout.CENTER);
        frame.setTitle("Notepad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.setVisible(true);

        topTitle.setBounds(0, 3, 950, 75);
        topTitle.setHorizontalAlignment(JLabel.CENTER);
        topTitle.setFont(new Font("Arial", Font.BOLD, 50));

        
    }

    public static void main (String[] args){
        new gui();
    }
}
