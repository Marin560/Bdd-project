/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 *
 * @author Roxane
 */
public class Accueil extends Fenetre implements ActionListener {
    
    private Connection maconnexion; //Ajout d'une nouvelle connexion
    private JLabel nameECE, passwdECE, loginBDD, passwdBDD, nameBDD;
    private JTextField nameECETexte, loginBDDTexte, nameBDDTexte;
    private JPasswordField passwdECETexte, passwdBDDTexte;
    private JButton connectECE, executer, connectlocal;
    private JPanel p0, p1, p2, p3;
    
    //Liste des noms de nos conteneurs pour les deux pages
  //String[] listContent = {"ConnexionLocale", "ConnexionECE"};
  //int indice = 0;
    
 
    public Accueil(){
        
        super("Accueil");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quitte le programme quand la fenêtre est fermée

        
        // creation des boutons
        connectECE = new JButton("Connexion ECE");
        connectlocal = new JButton("Connexion locale");
        executer = new JButton("Executer");
        
        
        // creation des textes
        nameECETexte = new JTextField();
        passwdECETexte = new JPasswordField(8);
        loginBDDTexte = new JTextField();
        passwdBDDTexte = new JPasswordField(8);
        nameBDDTexte = new JTextField();
        
        //Création des labels
        nameECE = new JLabel("login ECE :", JLabel.CENTER);
        passwdECE = new JLabel("password ECE :", JLabel.CENTER);
        loginBDD = new JLabel("login base :", JLabel.CENTER);
        passwdBDD = new JLabel("password base :", JLabel.CENTER);
        nameBDD = new JLabel("nom base :", JLabel.CENTER);
        
        // Création des panneaux
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        
        
        p0.setLayout(new GridLayout(0, 1,-5,5)); 
        //p1.setLayout(new GridLayout(0,1)); 
        //p2.setLayout(new GridLayout(5, 5)); 
        //p3.setLayout(new GridLayout(8, 8)); 
        
        p0.add(nameECE);
        p0.add(nameECETexte);
        p0.add(passwdECE);
        p0.add(passwdECETexte);
        p0.add(loginBDD);
        p0.add(loginBDDTexte);
        p0.add(passwdBDD);
        p0.add(passwdBDDTexte);
        p0.add(nameBDD);
        p0.add(nameBDDTexte);
        p0.add(connectECE);
        p0.add(connectlocal);
 
        // ajout des listeners
       
        executer.addActionListener(this);
        connectlocal.addActionListener(this);
        nameECETexte.addActionListener(this);
        passwdECETexte.addActionListener(this);
        loginBDDTexte.addActionListener(this);
        passwdBDDTexte.addActionListener(this);
        
        //this.getContentPane().add(p0, BorderLayout.NORTH);
        this.getContentPane().add(p0, BorderLayout.CENTER);
        this.getContentPane().add(p2, BorderLayout.CENTER);
        this.getContentPane().add(p2, BorderLayout.SOUTH);
        add("North", p0); 
        add("Center", p1); 
        add("Center", p2);
        add("South", p3); 
         
        //On affiche finalement la fenêtre
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {      
      if(e.getSource() == connectECE){ //Si on se connecte à la base de l'ece
          ArrayList<String> liste;
            
            String passwdECEString = new String(passwdECETexte.getPassword());
            String passwdBDDString = new String(passwdBDDTexte.getPassword());
        
      }
      else if (e.getSource() == connectlocal) { try {
          
          //On crée un ArrayList pour récupérer les données
          ArrayList<String> liste;
          //Connexion au serveur local (Nom bdd, user bdd, mdp bdd)
          
          //Connexion maConnexion = new Connexion(nameBDDTexte.getText(), "root", "root");
          Connexion maConnexion = new Connexion ("hopital","root","root");
          // Connection maConnexion = new Connection("hopital","root","root");
          //On lance l'écran d'après pour gérer la base de données
          
          EcranPrincipal ep = new EcranPrincipal(maConnexion.getConn());
          this.dispose();
          
      } catch (SQLException ex) {
            //Ajout d'une popup pour dire qu'il y a eu un problème
            JOptionPane.showMessageDialog(this,"Erreur: " + ex,"Titre : exception",JOptionPane.ERROR_MESSAGE);

            Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
          } catch (ClassNotFoundException ex) {
              JOptionPane.showMessageDialog(this,"Erreur: " + ex,"Titre : exception",JOptionPane.ERROR_MESSAGE);
              Logger.getLogger(Accueil.class.getName()).log(Level.SEVERE, null, ex);
          }
          
              
    }
    }

}
