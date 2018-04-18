package javaapplication7;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import jdbcv2018.Connexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author peti_
 */
public class Accueil extends JFrame implements ActionListener, ItemListener {
    
    private Connexion maconnexion; //Ajout d'une nouvelle connexion
    private JLabel nameECE, passwdECE, loginBDD, passwdBDD, nameBDD;
    private JTextField nameECETexte, loginBDDTexte, nameBDDTexte;
    private JPasswordField passwdECETexte, passwdBDDTexte;
    private JButton connectECE, executer, connectlocal;
    private JPanel p0, p1, p2, p3;
    
    
    public Accueil(){
        
        //Constructeur JFrame
        super("Accueil");
        
        //Mise en page de la fenêtre
        setLayout(new BorderLayout());
        setBounds(0, 0, 400, 400);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Création de nos variables 
        //Bouttons
        connectECE = new JButton("Connexion ECE");
        executer = new JButton("Executer"); 
        connectlocal = new JButton("Connexion Locale");
        
        //Textes
        nameECETexte = new JTextField();
        passwdECETexte = new JPasswordField(8);
        loginBDDTexte = new JTextField();
        passwdBDDTexte = new JPasswordField(8);
        nameBDDTexte = new JTextField();
        
        //Labels
        nameECE = new JLabel("login ECE :", JLabel.CENTER);
        passwdECE = new JLabel("password ECE :", JLabel.CENTER);
        loginBDD = new JLabel("login base :", JLabel.CENTER);
        passwdBDD = new JLabel("password base :", JLabel.CENTER);
        nameBDD = new JLabel("nom base :", JLabel.CENTER);
        
        //Pannels
        p0 = new JPanel();
        
        
        //Ajout des listeners
        //Boutons
        connectECE.addActionListener(this);
        executer.addActionListener(this);
        connectlocal.addActionListener(this);
        //Textes
        nameECETexte.addActionListener(this);
        passwdECETexte.addActionListener(this);
        loginBDDTexte.addActionListener(this);
        passwdBDDTexte.addActionListener(this);
        
        ///Ajout de tous les élément au panel
        //Bouttons
        p0.add(connectECE);
        p0.add(executer);
        p0.add(connectlocal);
        //Textes
        p0.add(nameECETexte);
        p0.add(passwdECETexte);
        p0.add(loginBDDTexte);
        p0.add(passwdBDDTexte);
        p0.add(nameBDDTexte);
        //Labels
        p0.add(nameECE);
        p0.add(passwdECE);
        p0.add(loginBDD);
        p0.add(passwdBDD);
        p0.add(nameBDD);
        
        //Ajout du pannel à la fenêtre créée
        add(p0, BorderLayout.CENTER);
       
        getContentPane().add(p0, BorderLayout.CENTER);
        add("North", p0);
        
        setVisible(true);
       
        
        System.out.println("Classe accueil");
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource()== connectECE){
            ArrayList<String> liste;
            
            String passwdECEString = new String(passwdECETexte.getPassword());
            String passwdBDDString = new String(passwdBDDTexte.getPassword());
        }
        else if (ae.getSource() == connectlocal){
            System.out.println("Oui");
            ArrayList<String> liste;
            
            try{
                //Connexion à la base de données
                Connexion co = new Connexion ("hopital","root","root");
                  
                System.out.println("Connection réussie");
                
                //On lance la page d'après
                EcranPrincipal ep = new EcranPrincipal();
                
                /*
                //Affichage de ce qu'il y a dans la colonne Employés
                ArrayList<String>tab = new ArrayList<>();
                tab = co.remplirChampsRequete("select * from employe");
                
                //On affiche les éléments du tableau
                Iterator it = tab.iterator();
                while(it.hasNext()){
                    System.out.println(it.next());
                }
                */
            }    
            catch (Exception e ){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
