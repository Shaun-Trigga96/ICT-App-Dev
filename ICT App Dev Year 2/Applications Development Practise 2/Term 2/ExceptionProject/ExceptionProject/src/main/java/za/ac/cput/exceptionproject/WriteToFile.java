/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.cput.exceptionproject;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author BURGERR
 */
public class WriteToFile {
   FileWriter fw;
  BufferedWriter bw;
    public static void main(String[] args) {  
        try{
            FileWriter fw = new FileWriter("testout.txt");  
            BufferedWriter bw = new BufferedWriter(fw);  
            bw.write(String.format("%-15s%-15s%-15s%-15s\n", "Student Name", "Student number", "Qualification", "Date of Birth"));  
            bw.write(String.format("%-15s%-15s%-15s%-15s\n", "Emilio Gustavo", "12436578", "BSc", "19950509"));  
            bw.close();  
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    System.out.println("Great success"); 
    
    
//    WriteToFile wtf = new WriteToFile();
//    wtf.openFile();
//    wtf.writeFile();
//    wtf.closeFile();
    }     

  
    public void openFile()
    {
        try{
        fw = new FileWriter("testout.txt");  
        bw = new BufferedWriter(fw);  
        }
        catch (IOException e){
            System.out.println("File creation error has occured");    
        }
    }//end openFile()
    public void writeFile(){
        try{
            bw.write(String.format("%-15s%-15s%-15s%-15s\n", "Student Name", "Student number", "Qualification", "Date of Birth"));  
            bw.write(String.format("%-15s%-15s%-15s%-15s\n", "Emilio Gustavo", "12436578", "BSc", "19950509"));  
        }
        catch (IOException e){
            System.out.println("Error writing to file");    
        }
    }//end writeFile
    public void closeFile(){
        try{
            bw.close();
        }
        catch (IOException e){
            System.out.println("File closing error has occured");    
        }
        
    }//end closeFile()

}
