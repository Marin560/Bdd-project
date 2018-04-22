/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author peti_
 */
public class Essai extends Fenetre implements ActionListener{
    
    private JTable table;
    private Connection co;
    private Statement stmt;
    
    public Essai(Connection coRecu){
        
        super("Essai");
        
        this.co = coRecu;
        
        String[] tab = new String[4]; //Nom, Prenom, Adresse, Tel
        int i =0;
        try { 
            stmt = co.createStatement();
            
            String nom_recherché = "Nadal";
            
            ResultSet Requete = stmt.executeQuery("SELECT * FROM `employe` WHERE `nom` = '"+nom_recherché+"' ");
            
            if(Requete.next())
                tab[i]=Requete.getString("prenom");
            i++;
            
            if(Requete.next())
                tab[i]=Requete.getString("nom");
           
            System.out.println(tab[i]);
            i++;
             
            if(Requete.next())
                tab[i]=Requete.getString("adresse");
            i++;
            
            if(Requete.next())
                tab[i]=Requete.getString("tel");
            i++;
            
            //On affiche les infos dans la console
            for(int e = 0 ; e<4 ; e++){
                System.out.println(tab[e]);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Essai.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        table = new JTable();
        
    
    }

    @Override
    
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    }


    

