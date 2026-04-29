/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.crecheapp.gui;

import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import za.ac.cput.Movie;

/**
 *
 * @author CPUT
 */
public class SunshineDBGUI  extends JFrame implements ActionListener {
	
	 private JLabel lblLabel;
	 private JPanel panelLabel;
	 private JPanel panelProperties;
	 private JPanel panelBttons; 
	
	private JLabel lblTitle;
        private JComboBox cobTitle;
	
	private JLabel lblMovieID;
	private JTextField txtMovieID;
	
	private JLabel lblMovieTitle;
	private JTextField txtMovieTiltle;
	
	private JLabel lblMovieDirector;
	private JTextField txtMovieDirector;
	
	private JLabel lblMovieGenre;
	private JTextField txtMovieGenre;
	
	private JButton btnDelete;
	private JButton btnExit;
	
	private ArrayList<Movie> movies;
 
	public SunshineDBGUI(){

	 super("DVD Invetory App");

	lblLabel = new JLabel();
	lblLabel.setAlignmentX(CENTER_ALIGNMENT);
        lblLabel.setAlignmentY(CENTER_ALIGNMENT);
	panelLabel = new JPanel();
        panelProperties = new JPanel();
        panelBttons= new JPanel();

	lblTitle = new JLabel("Select Movie ID  to Delete:");
	String[] movies = {};
	cobTitle = new JComboBox(movies);
	
	lblMovieID = new JLabel("Movie iD: ");
	txtMovieID = new JTextField(15);
	
	lblMovieDirector = new JLabel("Director Name: ");
	txtMovieDirector = new JTextField(15);
	
	lblMovieGenre = new JLabel("Genre");
	txtMovieGenre = new JTextField(15);
	
	btnDelete = new JButton();
	btnExit = new JButton();
	
	
	}

	public void setGUI(){
	
	 this.setLayout(new GridLayout(3, 2)); // This places all GUI components in the grid layout 
        panelLabel.setLayout(new GridLayout(1, 1));
        panelBttons.setLayout(new GridBagLayout());
        panelProperties.setLayout(new GridLayout(6, 2));
	
	panelLabel.add(lblLabel);
        
        panelProperties.add(lblTitle);
        panelProperties.add(cobTitle);

        panelProperties.add(lblMovieID);
        panelProperties.add(txtMovieID);
	
	panelProperties.add(lblMovieTitle);
        panelProperties.add(txtMovieTiltle);
	
	panelProperties.add(lblMovieDirector);
        panelProperties.add(txtMovieDirector);

	panelProperties.add(lblMovieGenre);
	panelProperties.add(txtMovieGenre);
	
	panelBttons.add(btnDelete);
	panelBttons.add(btnExit);

	   
        this.add(panelLabel);
        this.add(panelProperties);
        this.add(panelBttons);
	
	btnDelete.addActionListener(this);
	btnExit.addActionListener(this);
	
	this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

  public static void main(String[] args) {
   
	  new SunshineDBGUI().setGUI();


}
}
