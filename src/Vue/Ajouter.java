/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author peti_
 */
public class Ajouter extends Fenetre implements ActionListener{
    //Bouttons 
    //Ajouter des infos
    private JButton chambre, employe, malade;
    private JPanel panel_bouton, panel_combo,panel_ajout;
    private JLabel label ;
    
    
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
        label = new JLabel("Choisissez votre ajout");
        
        combo = new JComboBox();
        
        //Création du menu déroulant
        combo.addItem("Choisissez une catégorie");
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
         panel_ajout= new JPanel();
        
        //panel_combo.setLayout(new GridLayout(10, 110)); 
        
        //Ajout aux panels
        //panel_bouton.add(chambre);
        //panel_bouton.add(employe);
        //panel_bouton.add(malade);
        panel_combo.add(label);
        panel_combo.add(combo);
        
        setAlwaysOnTop(true);
       
        add(panel_combo, BorderLayout.NORTH);
        add(panel_bouton,BorderLayout.CENTER);
        setVisible(true);
        
    }
    
    public void update(){
        add(panel_bouton,BorderLayout.SOUTH);
        System.out.println("oui");
    }
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource()== combo){
            //On vérifie quel élément a été sélectionné
            if(combo.getSelectedItem() == "Patient"){
                System.out.println("Patient sélectionnée");
                
                //On supprime tous les éléments du panel 
                panel_bouton.removeAll();
                
                //On ajoute deux panels 
               
                //JPanel panel_ajout2= new JPanel();
                
                //On affiche les champs à remplir sur le nouveau panel
                JTextField nom = new JTextField("ssssssss");
                JTextField prenom = new JTextField("Prenom");
                JTextField adresse = new JTextField("Adresse");
                JTextField tel = new JTextField("Telephone");
                
                //JButton jb = new JButton("remplir");
                
                //panel_ajout1.add(jb);
                panel_ajout.add(nom);
                panel_ajout.add(prenom);
                panel_ajout.add(adresse);
                panel_ajout.add(tel);
                                
                //panel_bouton.add(panel_ajout1,BorderLayout.EAST);
                //panel_bouton.add(panel_ajout2,BorderLayout.WEST);
                
                add(panel_ajout,BorderLayout.WEST);
                //update();
                revalidate();
                
                //Numéro 
                //Nom
                //Prénom
                //Adresse
                //Tel
                //Mutuelle
                
            }
            else if(combo.getSelectedItem() == "Docteur"){
                System.out.println("Doc sélectionnée");
                
                panel_ajout.removeAll();
                revalidate();
                
            }
            else if(combo.getSelectedItem() == "Employe"){
                System.out.println("Employe sélectionnée");
            }
        }
        
    }
}
