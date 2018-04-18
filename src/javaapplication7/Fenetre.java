package javaapplication7;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author peti_
 */
public class Fenetre extends JFrame {
    private JButton recherche,maj,reporting,connexion;
    private JPanel panel;
    
    //Constructeur 
    public Fenetre(){
       
        super();
        
        setLayout(new BorderLayout());
        
        //Création des bouton
        recherche = new JButton("Recherche d'informations"); 
        maj = new JButton ("Mise à Jour des données"); 
        reporting = new JButton ("Reporting"); 
        connexion = new JButton("Connexion"); 
        
        //Création du panel
        panel = new JPanel();
        
        //Ajout des boutons au panel
        panel.add(recherche);
        panel.add(maj);
        panel.add(reporting);
        panel.add(connexion);
        
        add(panel);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setVisible(true);
        
              
    }  
}
