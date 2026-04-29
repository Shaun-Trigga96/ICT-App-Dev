/**
 * ShowCustomersGUI.java
 * Assignment 2 Sample Solution - Swing app
 * @author Kruben Naidoo
 * Date: 21 April 2021
 */

package za.ac.cput;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class ShowCustomersGUI extends JFrame implements ActionListener {
    private JPanel panelNorth;
    private JPanel panelCenter, panelGender;
    private JPanel panelSouth;
    
    private JLabel lblLogo;
    private JLabel lblHeading;
    private JLabel lblPadding0, lblPadding01, lblPadding1, lblPadding2, lblPadding3, lblPadding4, lblPadding5;
    
    private JLabel lblRecordCount;
    
    private JLabel lblTitle;
    private JComboBox cboTitle;
    
    private JLabel lblFirstName;
    private JTextField txtFirstName;
    
    private JLabel lblLastName;
    private JTextField txtLastName;
    
    private JLabel lblGender;
    private JRadioButton radMale;
    private JRadioButton radFemale;
    private ButtonGroup genderGroup;
    
    private JLabel lblPensioner;
    private JCheckBox chkPensioner;
    
    private JButton btnPrevious, btnNext, btnExit;
    private Font ft1, ft2, ft3, ft4;
    
    private ArrayList<Customer> list = new ArrayList<>();
    private int index;
    private int size;
        
    public ShowCustomersGUI() {
        super("Assignment 2 version 1.0 - Customers");
        panelNorth = new JPanel();
        panelCenter = new JPanel();
        panelGender = new JPanel();
        panelSouth = new JPanel();
        
        lblLogo = new JLabel();
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("chef.gif").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lblLogo.setIcon(imageIcon);
        lblHeading = new JLabel("CPUT Hotel School Event Registration");
        lblRecordCount = new JLabel("Displaying: Record 1 of 10 ");
        lblTitle = new JLabel("Title: ");
        cboTitle = new JComboBox(new String[]{"Adv", "Dr", "Miss", "Mr", "Mrs", "Prof"});
        lblFirstName = new JLabel("First Name: ");
        txtFirstName = new JTextField();
        lblLastName = new JLabel("Last Name: ");
        txtLastName = new JTextField();
        lblGender = new JLabel("Gender: ");
        radMale = new JRadioButton("Male");
        radFemale = new JRadioButton("Female");
        genderGroup = new ButtonGroup();
        lblPensioner = new JLabel("Pensioner: ");
        chkPensioner = new JCheckBox();
        
        lblPadding0 = new JLabel("");
        lblPadding01 = new JLabel("");
        lblPadding1 = new JLabel("");
        lblPadding2 = new JLabel("");
        lblPadding3 = new JLabel("");
        lblPadding4 = new JLabel("");
        lblPadding5 = new JLabel("");
        
        
        btnPrevious = new JButton("Previous");
        btnNext = new JButton("Next");
        btnExit = new JButton("Exit");
        
        ft1 = new Font("Arial", Font.BOLD, 32);
        ft2 = new Font("Arial", Font.PLAIN, 22);
        ft3 = new Font("Arial", Font.PLAIN, 24);
        ft4 = new Font("Arial", Font.ITALIC, 16);
        
        list.add(new Customer("Mr", "Kruben", "Naidoo", "Male", false));
        list.add(new Customer("Mr", "Faried", "Gasant", "Male", true));
        list.add(new Customer("Mr", "Gordon", "Lawrence", "Male", true));
        list.add(new Customer("Mrs", "Estelle", "Zietsman", "Female", false));
        list.add(new Customer("Dr", "Wilhelm", "Rothman", "Male", false));
        list.add(new Customer("Dr", "Sheethal", "Tom", "Female", false));
        list.add(new Customer("Mr", "Arinze", "Anikwue", "Male", false));
        list.add(new Customer("Mr", "Radford", "Burger", "Male", false));
        list.add(new Customer("Mrs", "Karin", "Swart", "Female", false));
        list.add(new Customer("Mr", "Zukile", "Ndyalivana", "Male", false));
        
        Collections.sort(list);
        
        index = 0;
        size = list.size();
        
        /* testing sort
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        } */
    }
    
    public void setGUI() {
        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(7, 3));
        panelGender.setLayout(new GridLayout(1, 2));
        panelSouth.setLayout(new GridLayout(1, 3));
        
        panelNorth.add(lblLogo);
        panelNorth.add(lblHeading);
        lblHeading.setFont(ft1);
        lblHeading.setForeground(Color.yellow);
        panelNorth.setBackground(new Color(0, 106, 255));
        
        lblRecordCount.setFont(ft4);
        lblRecordCount.setHorizontalAlignment(JLabel.RIGHT);
        panelCenter.add(lblPadding0);
        panelCenter.add(lblPadding01);
        panelCenter.add(lblRecordCount);
        
        lblTitle.setFont(ft2);
        lblTitle.setHorizontalAlignment(JLabel.RIGHT);
        cboTitle.setFont(ft2);
        panelCenter.add(lblTitle);
        panelCenter.add(cboTitle);
        panelCenter.add(lblPadding1);
        
        lblFirstName.setFont(ft2);
        lblFirstName.setHorizontalAlignment(JLabel.RIGHT);
        txtFirstName.setFont(ft2);
        panelCenter.add(lblFirstName);
        panelCenter.add(txtFirstName);
        panelCenter.add(lblPadding2);
        
        lblLastName.setFont(ft2);
        lblLastName.setHorizontalAlignment(JLabel.RIGHT);
        txtLastName.setFont(ft2);
        panelCenter.add(lblLastName);
        panelCenter.add(txtLastName);
        panelCenter.add(lblPadding3);
        
        lblGender.setFont(ft2);
        lblGender.setHorizontalAlignment(JLabel.RIGHT);
        radMale.setFont(ft2);
        radMale.setHorizontalAlignment(JRadioButton.CENTER);
        radMale.setBackground(new Color(36, 145, 255));
        radFemale.setFont(ft2);
        radFemale.setHorizontalAlignment(JRadioButton.LEFT);
        radFemale.setBackground(new Color(36, 145, 255));
        radMale.setSelected(true);
        
        genderGroup.add(radMale);
        genderGroup.add(radFemale);
        
        panelCenter.add(lblGender);      
        panelGender.add(radMale);
        panelGender.add(radFemale);
        panelGender.setBackground(new Color(36, 145, 255));
        panelCenter.add(panelGender);
        panelCenter.add(lblPadding4);
        
        lblPensioner.setFont(ft2);
        lblPensioner.setHorizontalAlignment(JLabel.RIGHT);
        chkPensioner.setFont(ft2);
        chkPensioner.setHorizontalAlignment(JRadioButton.LEFT);
        chkPensioner.setBackground(new Color(36, 145, 255));
        
        panelCenter.add(lblPensioner);
        panelCenter.add(chkPensioner);
        panelCenter.add(lblPadding5);
        panelCenter.setBackground(new Color(36, 145, 255));
        
        btnPrevious.setFont(ft3);
        btnNext.setFont(ft3);
        btnExit.setFont(ft3);
        panelSouth.add(btnPrevious);
        panelSouth.add(btnNext);
        panelSouth.add(btnExit);
        
        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnPrevious.addActionListener(this);
        btnNext.addActionListener(this);
        btnExit.addActionListener(this);
        
        this.setSize(600, 600);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        showCustomer();
    }
    
    public void showCustomer() {
        cboTitle.setSelectedItem(list.get(index).getTitle());
        txtFirstName.setText(list.get(index).getFirstName());
        txtLastName.setText(list.get(index).getLastName());
        if (list.get(index).getGender().equals("Male"))
            radMale.setSelected(true);
        else
            radFemale.setSelected(true);
        chkPensioner.setSelected(list.get(index).isPensioner());
        lblRecordCount.setText("Displaying: Record " + (index + 1) + " of " + size + " ");
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Previous")) {
            index--;
            if (index < 0)
                index = size - 1;
            showCustomer();
        }
        else if (e.getActionCommand().equals("Next")) {
            index++;
            if (index >= size)
                index = 0;
            showCustomer();
        }   
        else if (e.getActionCommand().equals("Exit")) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args) {
        new ShowCustomersGUI().setGUI();
    }    
}
