/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import gui.ServerForm;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Marenda
 */
public class Start {
    public static void main(String[] args) {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception ex){
            
        }
        
        try{
            JFrame serverForm = new ServerForm();
            serverForm.setVisible(true);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
            e.printStackTrace();
        }
    }
}
