/*
* Simple Text Editor using java GUI
*
* Future Features:
* Choose user's language
*
* Needs Fixing:
* limiting font size
*
* please contact me via the contact info in my GitHub profile (AugustoMF) in case of need
*
* last modification 23rd October 2023, 09:54
*/

// Adding all the necessary imports for the application
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.*;

//The editor class, where everything happens
public class TextEditor extends JFrame implements ActionListener {

//Declaring the variables I will use through the scope
    private JTextArea textArea;
    private JScrollPane scroller;
    private JLabel topHeader;
    private JSpinner fontSize;
    private JButton fontColor;
    private JButton colorMode;
    private JMenuBar menuBar;
    private JMenu menu;
    private JMenuItem openFile;
    private JMenuItem saveFile;
    private JMenuItem exitFile;
    private JComboBox fontStyle;
    private String theme = "clear";

    public TextEditor() throws IOException {

//Giving the variables their values and types
    textArea = new JTextArea();
    scroller = new JScrollPane(textArea);
    topHeader = new JLabel("Tamanho da fonte");
    fontSize = new JSpinner();
    fontColor = new JButton("Cor");
    colorMode = new JButton("Tema");
    menuBar = new JMenuBar();
    menu = new JMenu("File");
    openFile = new JMenuItem("Open");
    saveFile = new JMenuItem("Save");
    exitFile = new JMenuItem("Exit");

    menuBar.add(menu);
    menuBar.setBackground(Color.WHITE);
    menuBar.setForeground(Color.BLACK);

    menu.add(openFile);
    menu.add(saveFile);
    menu.add(exitFile);
    menu.setBackground(Color.WHITE);
    menu.setOpaque(true);

    openFile.addActionListener(this);
    openFile.setBackground(Color.WHITE);
    openFile.setOpaque(true);

    saveFile.addActionListener(this);
    saveFile.setBackground(Color.WHITE);
    saveFile.setOpaque(true);

    exitFile.addActionListener(this);
    exitFile.setBackground(Color.WHITE);
    exitFile.setOpaque(true);

    topHeader.setFont(new Font("Times News Roman", Font.ITALIC, 15));

//Setting up the default font size and allowing it to be changed according to the user's will
    fontSize.setPreferredSize(new Dimension(45, 25));
    fontSize.setValue(20);
    fontSize.addChangeListener(new ChangeListener() {
        @Override
        public void stateChanged(ChangeEvent changeEvent) {
            textArea.setFont(new Font(textArea.getFont().getFamily(), Font.PLAIN, (int) fontSize.getValue()));
        }
    });

//Adding the font bollor button and giving its actions listener to be implemented below
    fontColor.setPreferredSize(new Dimension(75, 25));
    fontColor.addActionListener(this);
    fontColor.setBackground(Color.WHITE);

    String [] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();

    fontStyle = new JComboBox(fonts);
    fontStyle.addActionListener(this);
    fontStyle.setSelectedItem("Arial");
    fontStyle.setBackground(Color.WHITE);
    fontStyle.setForeground(Color.BLACK);

//Adding the changing theme button and giving its actions listener to be implemented below
    colorMode.setPreferredSize(new Dimension(75, 25));
    colorMode.addActionListener(this);
    colorMode.setBackground(Color.WHITE);

// Scoller and text area where user will type
    scroller.setPreferredSize(new Dimension (670, 670));
    scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

    textArea.setLineWrap(true);
    textArea.setFont(new Font( "Arial", Font.PLAIN, 20));

    //My main frame, where every functionality is added to the sceen

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(700, 700);
        this.setTitle("Editor de Texto");
        this.setForeground(Color.lightGray);
        this.setVisible(true);
        this.setJMenuBar(menuBar);
        this.add(topHeader);
        this.add(fontSize);
        this.add(fontColor);
        this.add(fontStyle);
        this.add(colorMode);
        this.add(scroller);
        this.setLocationRelativeTo(null);
        this.setIconImage(ImageIO.read(new File("imgs/icon.png")));

    }

// The action listener to both buttons
    @Override
    public void actionPerformed(ActionEvent e) {

//Verifying the clicked button and telling the final user to select a color for the font
        if (e.getSource()==fontColor){
            JColorChooser pickColor = new JColorChooser();

            Color color = pickColor.showDialog(null, "Escolha uma cor", Color.BLACK);

            textArea.setForeground(color);
        }

        if (e.getSource()==fontStyle){
            textArea.setFont(new Font((String)fontStyle.getSelectedItem(),Font.PLAIN,textArea.getFont().getSize()));
        }

//Verifying the current theme and changing it when the user clicks
        if (e.getSource()==colorMode){

            if (theme.equals("clear")){
                textArea.setForeground(Color.WHITE);
                textArea.setBackground(Color.DARK_GRAY);
                menuBar.setBackground(Color.BLACK);
                menuBar.setForeground(Color.WHITE);
                fontColor.setBackground(Color.DARK_GRAY);
                fontColor.setForeground(Color.WHITE);
                fontStyle.setBackground(Color.DARK_GRAY);
                fontStyle.setForeground(Color.WHITE);
                colorMode.setForeground(Color.WHITE);
                colorMode.setBackground(Color.DARK_GRAY);
                fontSize.getEditor().getComponent(0).setForeground(Color.WHITE);
                fontSize.getEditor().getComponent(0).setBackground(Color.DARK_GRAY);
                topHeader.setForeground(Color.WHITE);
                menu.setBackground(Color.DARK_GRAY);
                menu.setForeground(Color.WHITE);
                menu.setOpaque(true);
                openFile.setBackground(Color.DARK_GRAY);
                openFile.setForeground(Color.WHITE);
                openFile.setOpaque(true);
                saveFile.setBackground(Color.DARK_GRAY);
                saveFile.setForeground(Color.WHITE);
                saveFile.setOpaque(true);
                exitFile.setBackground(Color.DARK_GRAY);
                exitFile.setForeground(Color.WHITE);
                exitFile.setOpaque(true);
                this.getContentPane().setBackground(Color.BLACK);

                theme = "dark";
            }
            else if (theme.equals("dark")){
                textArea.setForeground(Color.BLACK);
                textArea.setBackground(Color.WHITE);
                menuBar.setBackground(Color.WHITE);
                menuBar.setForeground(Color.BLACK);
                fontColor.setBackground(Color.WHITE);
                fontColor.setForeground(Color.BLACK);
                fontStyle.setBackground(Color.WHITE);
                fontStyle.setForeground(Color.BLACK);
                colorMode.setForeground(Color.BLACK);
                colorMode.setBackground(Color.WHITE);
                fontSize.getEditor().getComponent(0).setForeground(Color.BLACK);
                fontSize.getEditor().getComponent(0).setBackground(Color.WHITE);
                topHeader.setForeground(Color.BLACK);
                menu.setBackground(Color.WHITE);
                menu.setForeground(Color.BLACK);
                menu.setOpaque(true);
                openFile.setBackground(Color.WHITE);
                openFile.setForeground(Color.BLACK);
                openFile.setOpaque(true);
                saveFile.setBackground(Color.WHITE);
                saveFile.setForeground(Color.BLACK);
                saveFile.setOpaque(true);
                exitFile.setBackground(Color.WHITE);
                exitFile.setForeground(Color.BLACK);
                exitFile.setOpaque(true);
                this.getContentPane().setBackground(Color.LIGHT_GRAY);

                theme = "clear";
            }

        }

        if (e.getSource()==openFile){

                textArea.setText(null);
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
                fileChooser.setFileFilter(filter);

                int response = fileChooser.showOpenDialog(null);

                if(response == JFileChooser.APPROVE_OPTION) {
                    File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    Scanner fileIn = null;

                    try {
                        fileIn = new Scanner(file);
                        if(file.isFile()) {
                            while(fileIn.hasNextLine()) {
                                String line = fileIn.nextLine()+"\n";
                                textArea.append(line);
                            }
                        }
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                    finally {
                        fileIn.close();
                    }
                }
            }

            if (e.getSource()==saveFile){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("."));

                int response = fileChooser.showOpenDialog(null);

                if(response == JFileChooser.APPROVE_OPTION) {
                    File file;
                    PrintWriter fileOut = null;
                    
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                    try {
                     fileOut = new PrintWriter(file);
                     fileOut.println(textArea.getText());
                    } 
                    catch (FileNotFoundException e1) {
                     // TODO Auto-generated catch block
                     e1.printStackTrace();
                    }
                    finally {
                     fileOut.close();
                    }   
                   }
                  }
            if (e.getSource()==exitFile){
             System.exit(0);
          }
     }
 }