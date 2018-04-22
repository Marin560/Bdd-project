/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 *
 * @author guill
 */
public class Rechercher extends Fenetre implements ActionListener{
    
    //zone pour entrer du texte
    private JTextField nomtexte, prenomtexte, nochambretexte, batimenttexte, mutuelletexte, idtexte, rotationtexte;
    
    //bouton rechercher en bas de page 
    private JButton rechercherbouton;
    
    //zone de placement 
    private JPanel precherche, panel_combo, p0;
    
    //description des zones de textes
    private JLabel label ;
    private JLabel nom, prenom, nochambre, batiment, mutuelle, id, rotation;
    
    //tableau de stockage pour la recupération des données recupérées
    public String infotab[];
   
     private Connection conn;
    
    //constructeur
    public Rechercher(Connection connect){
        super("Recherche",1200,1000);
        
        //Création des boutons 
        rechercherbouton = new JButton("Rechercher");
        //on récupere Connection
        this.conn = connect;
        //création des titres
        nom = new JLabel("Nom:", JLabel.CENTER);
        prenom = new JLabel("Prenom:", JLabel.CENTER);
        nochambre = new JLabel("Numéro de chambre:", JLabel.CENTER);
        batiment = new JLabel("Batiment:", JLabel.CENTER);
        mutuelle = new JLabel("Mutuelle:", JLabel.CENTER);
        id = new JLabel("identifiant:", JLabel.CENTER);
        rotation = new JLabel("rotation:", JLabel.CENTER);
        label = new JLabel("Faites votre recherche", JLabel.CENTER);
        //création des zones de textes
        nomtexte = new JTextField();
        prenomtexte = new JTextField();
        nochambretexte = new JTextField();
        batimenttexte =  new JTextField();
        mutuelletexte =  new JTextField();
        idtexte =  new JTextField();
        rotationtexte = new JTextField();
        
        //création du tableau
        String[] infotab = new String [6];
        
        
        //Ajout des listeners
        // on attend que l'utilisateur lance la recherche 
        rechercherbouton.addActionListener(this);
    
        precherche = new JPanel();
        panel_combo = new JPanel();
        p0 = new JPanel ();
        p0.setLayout(new GridLayout(0, 1,-5,5)); 
        
        //Ajout aux panels
        precherche.add(rechercherbouton);
        panel_combo.add(label);
        
        // on place les différentes zones dans p0 
        p0.add(nom);
        p0.add(nomtexte);
        p0.add(prenom);
        p0.add(prenomtexte);
        p0.add(nochambre);
        p0.add(nochambretexte);
        p0.add(batiment);
        p0.add(batimenttexte);
        p0.add(mutuelle);
        p0.add(mutuelletexte);
        //p0.add(id);
        //p0.add(idtexte);
        p0.add(rotation);
        p0.add(rotationtexte);
        
        setAlwaysOnTop(true);
       
        //on place le bouton de recherche en bas de page
        add(precherche, BorderLayout.SOUTH);
        
        // on place p0 en haut de page 
        add(p0, BorderLayout.NORTH);
        
        // on fait apparaitre à l'ecran
        setVisible(true);
    }

    /**
     * on verifie dans quelle zone on recherche, on envoie une requete pour la recherche et on recupère le 
     * résultat dans un tableau 
     * @param ae
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        int i =0, j=0;
        if (ae.getSource() == rechercherbouton){ //si l'utilisateur clique sur le bouton recherche
            
            if (!"".equals(nomtexte.getText())){ //si on recherche un nom 
                
                //System.out.println("nom");
                
                try {
                    Statement stmt = conn.createStatement(); 
                    //on envoie la requete en sql 
                    //on cherche dans la table employe le nom rentré dans la barre de recherche 
                    ResultSet Requete = stmt.executeQuery("SELECT * FROM employe WHERE nom = '"+nomtexte.getText()+"'");
                    System.out.println(Requete.getString("nom"));
                   while(Requete.next()){ 
                        infotab[i] = Requete.getString("numero");
                        i++;  
                        infotab[i] = Requete.getString("nom");
                        i++;  
                        infotab[i] = Requete.getString("prenom");
                        i++;  
                        infotab[i] = Requete.getString("tel");
                        i++;  
                        infotab[i] = Requete.getString("adresse");
                        i=0;
                        System.out.println(Arrays.toString(infotab));
                    }  
                } catch (SQLException ex) {
                    Logger.getLogger(Rechercher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (!"".equals(prenomtexte.getText())){ //si on recherche un prenom
                //System.out.println("prenom");
                
                try {
                    Statement stmt = conn.createStatement(); 
                    ResultSet Requete = stmt.executeQuery("SELECT * FROM employe WHERE prenom = '"+prenomtexte.getText()+"'");
                   while(Requete.next()){ 
                        infotab[i] = Requete.getString("numero");
                        i++;  
                        infotab[i] = Requete.getString("nom");
                        i++;  
                        infotab[i] = Requete.getString("prenom");
                        i++;  
                        infotab[i] = Requete.getString("tel");
                        i++;  
                        infotab[i] = Requete.getString("adresse");
                        i=0;
                        System.out.println(Arrays.toString(infotab));
                    }  
                } catch (SQLException ex) {
                    Logger.getLogger(Rechercher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (!"".equals(nochambre.getText())){ //si on recherche une chambre
                System.out.println("nochambre");
                
                try {
                    Statement stmt = conn.createStatement(); 
                    ResultSet Requete = stmt.executeQuery("SELECT * FROM hospitalisation WHERE no_chambre = '"+nochambretexte.getText()+"'");
                    System.out.println(Requete.getString("no_malade"));
                   while(Requete.next()){  
                        infotab[i] = Requete.getString("no_malade");
                        i++;
                        infotab[i] = Requete.getString("code_service");
                        i++;  
                        infotab[i] = Requete.getString("no_chambre");
                        i++;  
                        infotab[i] = Requete.getString("lit");
                        i=0;
                        System.out.println(Arrays.toString(infotab));
                    }  
                } catch (SQLException ex) {
                    Logger.getLogger(Rechercher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (!"".equals(batimenttexte.getText())){ //si on recherche un batiment 
                System.out.println("batiment");
                
                try {
                    Statement stmt = conn.createStatement(); 
                    ResultSet Requete = stmt.executeQuery("SELECT * FROM service WHERE batiment = '"+batimenttexte.getText()+"'");
                    System.out.println(Requete.getString("batiment"));
                   while(Requete.next()){ 
                        infotab[i] = Requete.getString("code");
                        i++;  
                        infotab[i] = Requete.getString("nom");
                        i++;  
                        infotab[i] = Requete.getString("batiment");
                        i++;  
                        infotab[i] = Requete.getString("directeur");
                        i=0;
                        System.out.println(Arrays.toString(infotab));
                    }  
                } catch (SQLException ex) {
                    Logger.getLogger(Rechercher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (!"".equals(mutuelletexte.getText())){ //si on recherche une mutuelle
                System.out.println("mutuelle");
                
                try {
                    Statement stmt = conn.createStatement(); 
                    ResultSet Requete = stmt.executeQuery("SELECT * FROM malade WHERE mutuelle = '"+mutuelletexte.getText()+"'");
                    System.out.println(Requete.getString("mutuelle"));
                   while(Requete.next()){ 
                        infotab[i] = Requete.getString("numero");
                        i++;  
                        infotab[i] = Requete.getString("nom");
                        i++;  
                        infotab[i] = Requete.getString("prenom");
                        i++;  
                        infotab[i] = Requete.getString("adresse");
                        i++;
                        infotab[i] = Requete.getString("mutuelle");
                        i = 0; 
                        System.out.println(Arrays.toString(infotab));
                    }  
                } catch (SQLException ex) {
                    Logger.getLogger(Rechercher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
             if (!"".equals(rotationtexte.getText())){ //si on recherche le personnel de nuit ou de jour
                System.out.println("rotation");
                
                try {
                    Statement stmt = conn.createStatement(); 
                    ResultSet Requete = stmt.executeQuery("SELECT * FROM infirmier WHERE rotation = '"+rotationtexte.getText()+"'");
                    System.out.println(Requete.getString("rotation"));
                   while(Requete.next()){ 
                        infotab[i] = Requete.getString("numero");
                        i++;  
                        infotab[i] = Requete.getString("code_service");
                        i++;  
                        infotab[i] = Requete.getString("rotation");
                        i++;  
                        infotab[i] = Requete.getString("salaire");
                        i = 0; 
                        System.out.println(Arrays.toString(infotab));
                    }  
                } catch (SQLException ex) {
                    Logger.getLogger(Rechercher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }
}
