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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author peti_
 */
public class Ajouter extends Fenetre implements ActionListener{
    //Bouttons 
    //Ajouter des infos
    private JButton chambre, employe, malade;
    private JPanel panel_bouton, panel_combo;
    
    //Menu déroulant
    private JComboBox combo;
    
    //Afficher les données 
    
    
    
    //Constructeur 
    public Ajouter(){
        
        super("Nouvel Element",400,400);
        
        //Création des boutons 
        chambre = new JButton("Ajouter une chambre");
        employe = new JButton ("Ajouter un employe");
        malade = new JButton("Ajouter un malade");
        
        combo = new JComboBox();
        
        //Création du menu déroulant
        combo.addItem("Patient");
        combo.addItem("Docteur");
        combo.addItem("Employe");
        
        //Ajout des listeners
        chambre.addActionListener(this);
        employe.addActionListener(this);
        malade.addActionListener(this);
        combo.addActionListener(this);
    
        panel_bouton = new JPanel();
        panel_combo = new JPanel();
        
        //Ajout aux panels
        //panel_bouton.add(chambre);
        //panel_bouton.add(employe);
        //panel_bouton.add(malade);
        panel_combo.add(combo);
        
        setAlwaysOnTop(true);
        
        add(panel_bouton, BorderLayout.NORTH);
        add(panel_combo, BorderLayout.CENTER);
        
        setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource()== combo){
            //On vérifie quel élément a été sélectionné
            if(combo.getSelectedItem() == "Patient"){
                System.out.println("Patient sélectionnée");
                
                //On affiche les champs à remplir pour ajouter une nouveau patient
                //Numéro 
                //Nom
                //Prénom
                //Adresse
                //Tel
                //Mutuelle
                
            }
            else if(combo.getSelectedItem() == "Docteur"){
                System.out.println("Doc sélectionnée");
            }
            else if(combo.getSelectedItem() == "Employe"){
                System.out.println("Employe sélectionnée");
            }
        }
        
    }
}