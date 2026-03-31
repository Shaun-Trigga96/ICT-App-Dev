/**
 * LottoGUI.java
 * This is my first swing application
 * @author Kruben Naidoo
 * 14 April 2021
 */

package za.ac.cput;

// STEP 1: Add relevant packages only
import java.awt.*;
import javax.swing.*;	// use the wildcard * to include all subclasses
import java.awt.event.*;    // for event handlers
import java.util.Arrays;

public class LottoGUI implements ActionListener {
    // STEP 2: Declare variables
    private JFrame mainFrame;
    private JPanel panelWest, panelEast, panelSouth, panelCenter;
    private JButton btnRun, btnClear;
    private JTextField txtWest1, txtWest2, txtWest3, txtWest4, txtWest5, txtWest6, txtEast1, txtEast2, txtEast3, txtEast4, txtEast5, txtEast6;
    private JLabel lblCenter;
    private Font ft1, ft2;
    
    // STEP 3: Instantiate all the instance variables in the constructor
    public LottoGUI() {
        mainFrame = new JFrame("Java Lotto");
        panelWest = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();
        
        btnRun = new JButton("RUN");
        btnClear = new JButton("CLEAR");
        
        txtWest1 = new JTextField(2);
        txtWest2 = new JTextField(2);
        txtWest3 = new JTextField(2);
        txtWest4 = new JTextField(2);
        txtWest5 = new JTextField(2);
        txtWest6 = new JTextField(2);
        txtEast1 = new JTextField(2);
        txtEast2 = new JTextField(2);
        txtEast3 = new JTextField(2);
        txtEast4 = new JTextField(2);
        txtEast5 = new JTextField(2);
        txtEast6 = new JTextField(2);
        
        lblCenter = new JLabel(new ImageIcon("duke.running.gif"));
        ft1 = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
        ft2 = new Font("Arial", Font.BOLD, 14);         // We will use this font later
        
        btnRun.setForeground(Color.yellow);
        btnRun.setBackground(Color.blue);
        btnRun.setFont(ft1);
        
        btnClear.setForeground(Color.black);
        btnClear.setBackground(Color.green);
        btnClear.setFont(ft1);
    }
    
    // STEP 4: Now lets set up the GUI
    public void setGUI() {
        panelWest.setLayout(new GridLayout(6, 1));
        panelEast.setLayout(new GridLayout(6, 1));
        panelSouth.setLayout(new GridLayout(1, 2));
        
        panelWest.add(txtWest1);
        panelWest.add(txtWest2);
        panelWest.add(txtWest3);
        panelWest.add(txtWest4);
        panelWest.add(txtWest5);
        panelWest.add(txtWest6);
        
        panelEast.add(txtEast1);
        panelEast.add(txtEast2);
        panelEast.add(txtEast3);
        panelEast.add(txtEast4);
        panelEast.add(txtEast5);
        panelEast.add(txtEast6);
        
        panelSouth.add(btnRun);
        panelSouth.add(btnClear);
        
        panelCenter.add(lblCenter);
        
        mainFrame.add(panelWest, BorderLayout.WEST);
        mainFrame.add(panelEast, BorderLayout.EAST);
        mainFrame.add(panelSouth, BorderLayout.SOUTH);
        mainFrame.add(panelCenter, BorderLayout.CENTER);
        
        // STEP 5a: Lets add window listeners onto our gui components
        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                    System.exit(0);
            }
        });
        
        // STEP 5b: Lets add action listeners onto our gui components
        btnRun.addActionListener(this);
        btnClear.addActionListener(this);
        
        mainFrame.pack();	// mainFrame.setSize(400, 400);
        mainFrame.show();	// mainFrame.setVisible(true);
    }
    
    // STEP 6: Almost done: Writing code for the button when events are triggered
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("RUN")) {
            GenerateNumbers.populateValues();
            
            /* you can change also the text color, font, style, etc - put this section in the setGUI() method later */
            txtWest1.setBackground(Color.orange);
            txtWest2.setBackground(Color.orange);
            txtWest3.setBackground(Color.orange);
            txtWest4.setBackground(Color.orange);
            txtWest5.setBackground(Color.orange);
            txtWest6.setBackground(Color.orange);
            txtEast1.setBackground(Color.yellow);
            txtEast2.setBackground(Color.yellow);
            txtEast3.setBackground(Color.yellow);
            txtEast4.setBackground(Color.yellow);
            txtEast5.setBackground(Color.yellow);
            txtEast6.setBackground(Color.yellow);
            
            txtWest1.setFont(ft2);
            txtWest2.setFont(ft2);
            txtWest3.setFont(ft2);
            txtWest4.setFont(ft2);
            txtWest5.setFont(ft2);
            txtWest6.setFont(ft2);
            txtEast1.setFont(ft2);
            txtEast2.setFont(ft2);
            txtEast3.setFont(ft2);
            txtEast4.setFont(ft2);
            txtEast5.setFont(ft2);
            txtEast6.setFont(ft2);
            
            /**************** End of format, remember to put the above code in the setGUI() method  *****************************************************************/
            
            txtWest1.setText(String.valueOf(GenerateNumbers.numbers[0]));
            txtWest2.setText(String.valueOf(GenerateNumbers.numbers[1]));
            txtWest3.setText(String.valueOf(GenerateNumbers.numbers[2]));
            txtWest4.setText(String.valueOf(GenerateNumbers.numbers[3]));
            txtWest5.setText(String.valueOf(GenerateNumbers.numbers[4]));
            txtWest6.setText(String.valueOf(GenerateNumbers.numbers[5]));
            
            Arrays.sort(GenerateNumbers.numbers);
            
            txtEast1.setText(String.valueOf(GenerateNumbers.numbers[0]));
            txtEast2.setText(String.valueOf(GenerateNumbers.numbers[1]));
            txtEast3.setText(String.valueOf(GenerateNumbers.numbers[2]));
            txtEast4.setText(String.valueOf(GenerateNumbers.numbers[3]));
            txtEast5.setText(String.valueOf(GenerateNumbers.numbers[4]));
            txtEast6.setText(String.valueOf(GenerateNumbers.numbers[5]));         
        } else if (e.getActionCommand().equals("CLEAR")) {
            txtWest1.setText("");
            txtWest2.setText("");
            txtWest3.setText("");
            txtWest4.setText("");
            txtWest5.setText("");
            txtWest6.setText("");
            txtEast1.setText("");
            txtEast2.setText("");
            txtEast3.setText("");
            txtEast4.setText("");
            txtEast5.setText("");
            txtEast6.setText("");
        }
    }
    
    // STEP 8: Coding the main function
    public static void main(String[] args) {
        /* LottoGUI dummyObject = new LottoGUI();
        dummyObject.setGUI(); */ 
        new LottoGUI().setGUI();             // calling an anonymous object
    }
    
    // STEP 9: Final step, hit 'Run Project' in Netbeans
}