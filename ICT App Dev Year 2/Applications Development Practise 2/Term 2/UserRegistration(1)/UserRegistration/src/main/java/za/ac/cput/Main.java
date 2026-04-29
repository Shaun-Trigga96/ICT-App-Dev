/**
 * Main.java
 * This is a user registration swing application
 * @author Kruben Naidoo (student-number)
 * Date: 28 April 2021
 */

package za.ac.cput;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import org.apache.commons.validator.routines.EmailValidator;

public class Main extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JComboBox cboTitle;
    private JLabel lblErrorTitle;
    
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    private JLabel lblErrorFirstName;
    
    private JLabel lblLastName;
    private JTextField txtLastName;
    private JLabel lblErrorLastName;
    
    private JLabel lblGender;
    private JPanel panelGender;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private JLabel lblErrorGender;
    private ButtonGroup genderButtonGroup;
    
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblErrorEmail;
    
    private JLabel lblPassword;
    private JPasswordField txtPassword;
    private JLabel lblErrorPassword;
    
    private JLabel lblConfirmPassword;
    private JPasswordField txtConfirmPassword;
    private JLabel lblErrorConfirmPassword;
    
    private JLabel lblTerms;
    private JCheckBox chkTerms;
    private JLabel lblErrorTerms;
    
    private JButton btnSave;
    private JButton btnClear;
    private JButton btnExit;
    
    
    public Main() {
        // this constructor is where we will initialise our instance variables
        super("User Registration");
        lblTitle = new JLabel("Title: ");
        String listOfTitles[] = {"Dr", "Miss", "Mr", "Mrs", "Prof"};   
        cboTitle = new JComboBox(listOfTitles);
        /*cboTitle.addItem("Dr");
        cboTitle.addItem("Miss");
        cboTitle.addItem("Mrs"); */
        lblErrorTitle = new JLabel("*required");
        lblErrorTitle.setForeground(Color.red);
        lblErrorTitle.setVisible(false);
    
        lblFirstName = new JLabel("First Name: ");
        txtFirstName = new JTextField(15);
        lblErrorFirstName = new JLabel("*required");
        lblErrorFirstName.setForeground(Color.red);
        lblErrorFirstName.setVisible(false);
        
        lblLastName = new JLabel("Last Name: ");
        txtLastName = new JTextField(15);
        lblErrorLastName = new JLabel("*required");
        lblErrorLastName.setForeground(Color.red);
        lblErrorLastName.setVisible(false); 
        
        lblGender = new JLabel("Gender: ");
        panelGender = new JPanel();
        radFemale = new JRadioButton("Female");
        radMale = new JRadioButton("Male");
        genderButtonGroup = new ButtonGroup();
        genderButtonGroup.add(radFemale);
        genderButtonGroup.add(radMale);
        panelGender.setLayout(new GridLayout(1, 2));
        radFemale.setSelected(true);        // make the female option default
        panelGender.add(radFemale);
        panelGender.add(radMale);
        lblErrorGender = new JLabel("*required");
        lblErrorGender.setForeground(Color.red);
        lblErrorGender.setVisible(false);
        
        lblEmail = new JLabel("Email: ");
        txtEmail = new JTextField(15);
        lblErrorEmail = new JLabel("*valid email required");
        lblErrorEmail.setForeground(Color.red);
        lblErrorEmail.setVisible(false);
        
        lblPassword = new JLabel("Password: ");
        txtPassword = new JPasswordField();
        lblErrorPassword = new JLabel("*minimum of 8 characters");
        lblErrorPassword.setForeground(Color.red);
        lblErrorPassword.setVisible(false);
        
        lblConfirmPassword = new JLabel("Confirm Password: ");
        txtConfirmPassword = new JPasswordField();
        lblErrorConfirmPassword = new JLabel("*passwords do not match");
        lblErrorConfirmPassword.setForeground(Color.red);
        lblErrorConfirmPassword.setVisible(false);
        
        lblTerms = new JLabel("Terms and Conditions: ");
        chkTerms = new JCheckBox("I agree to the terms and conditions");
        lblErrorTerms = new JLabel("*required");
        lblErrorTerms.setForeground(Color.red);
        lblErrorTerms.setVisible(false);
        
        btnSave = new JButton("Save");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        btnSave.setEnabled(false);
    }
    
    public void setGUI() {
        // this place all gui components on the frame ... gridlayout(3 columns and 9 rows)
        this.setLayout(new GridLayout(9, 3));
        
        this.add(lblTitle);
        this.add(cboTitle);
        this.add(lblErrorTitle);
        
        this.add(lblFirstName);
        this.add(txtFirstName);
        this.add(lblErrorFirstName);
        
        this.add(lblLastName);
        this.add(txtLastName);
        this.add(lblErrorLastName);
        
        this.add(lblGender);
        this.add(panelGender);
        this.add(lblErrorGender);
        
        this.add(lblEmail);
        this.add(txtEmail);
        this.add(lblErrorEmail);
        
        this.add(lblPassword);
        this.add(txtPassword);
        this.add(lblErrorPassword);
        
        this.add(lblConfirmPassword);
        this.add(txtConfirmPassword);
        this.add(lblErrorConfirmPassword);
        
        this.add(lblTerms);
        this.add(chkTerms);
        this.add(lblErrorTerms);
        
        this.add(btnSave);
        this.add(btnClear);
        this.add(btnExit);
        
        btnSave.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
        chkTerms.addActionListener(this);
        
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public boolean isInputValid() {
        boolean valid = true;
        
        if (txtFirstName.getText().equals("")) {
            valid = false;
            lblErrorFirstName.setVisible(true);
        } else
            lblErrorFirstName.setVisible(false);
        
        if (txtLastName.getText().equals("")) {
            valid = false;
            lblErrorLastName.setVisible(true);
        } else
            lblErrorLastName.setVisible(false);
        
        if (!EmailValidator.getInstance().isValid(txtEmail.getText())) {
            valid = false;
            lblErrorEmail.setVisible(true);
        } else
            lblErrorEmail.setVisible(false);
        
        return valid;
    }
      
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSave) {
            if (isInputValid()) {
                // write the gui info to a file
            }
        } else if (e.getSource() == btnClear) {
            // reset the gui components to default values
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        } else if (e.getSource() == chkTerms) {
            if (chkTerms.isSelected()) {
                btnSave.setEnabled(true);
            } else {
                btnSave.setEnabled(false);
            }    
        }
    }
    
    public static void main(String[] args) {
        new Main().setGUI();
    }
}
