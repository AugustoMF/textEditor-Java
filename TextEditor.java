import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class TextEditor extends JFrame implements ActionListener {

    private JTextArea textArea;
    private JScrollPane scroller;
    private JLabel topHeader;
    private JSpinner fontSize;
    private JButton fontColor;

    public TextEditor(){

    textArea = new JTextArea();
    scroller = new JScrollPane(textArea);
    topHeader = new JLabel("Tamanho da fonte");
    fontSize = new JSpinner();
    fontColor = new JButton("Cor");

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.setSize(700, 700);
    this.setTitle("Editor de Texto");
    this.setForeground(Color.lightGray);
    this.setVisible(true);
    this.add(topHeader);
    this.add(fontSize);
    this.add(fontColor);
    this.add(scroller);
    this.setLocationRelativeTo(null);

    topHeader.setFont(new Font("Times News Roman", Font.ITALIC, 15));

    fontSize.setPreferredSize(new Dimension(45, 25));
    fontSize.setValue(20);
    fontSize.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSize.getValue()));
        }
    });

    fontColor.setPreferredSize(new Dimension(75, 25));
    fontColor.addActionListener(this);

    scroller.setPreferredSize(new Dimension (670, 670));
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    textArea.setLineWrap(true);
    textArea.setFont(new Font( "Arial", Font.PLAIN, 20));


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==fontColor){
            JColorChooser pickColor = new JColorChooser();

            Color color = pickColor.showDialog(null, "Escolha uma cor", Color.BLACK);

            textArea.setForeground(color);
        }

    }
}