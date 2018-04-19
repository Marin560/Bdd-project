/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author peti_
 */
public class MisesAJour extends Fenetre implements ActionListener{
    //Bouttons 
    //Ajouter des infos
    private JButton chambre, employe, malade;
    private JPanel panel;
    
    //Champs pour remplir

    
    //Afficher les données 
    
    
    
    //Constructeur 
    public MisesAJour(){
        
        super("Mise à Jour",400,400);
        
        //Création des boutons 
        chambre = new JButton("Ajouter une chambre");
        employe = new JButton ("Ajouter un employe");
        malade = new JButton("Ajouter un malade");
        
        panel = new JPanel();
        
        //Ajout au panel
        panel.add(chambre);
        panel.add(employe);
        panel.add(malade);

        setAlwaysOnTop(true);
        
        add(panel, BorderLayout.CENTER);
        
        setVisible(true);
        
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
