import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class TextEditor extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JScrollPane scroller;
    private JLabel topHeader;

    public TextEditor(){

    textArea = new JTextArea();
    scroller = new JScrollPane(textArea);
    topHeader = new JLabel("Editor de Texto");

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.setSize(700, 700);
    this.setTitle("Editor de Texto");
    this.setForeground(Color.lightGray);
    this.setVisible(true);
    this.add(topHeader);
    this.add(scroller);
    this.setLocationRelativeTo(null);

    textArea.setLineWrap(true);
    textArea.setFont(new Font( "Arial", Font.PLAIN, 20));

    scroller.setPreferredSize(new Dimension (670, 670));
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    topHeader.setFont(new Font("Times News Roman", Font.ITALIC, 25));

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
