/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modèle.Action_Reporting;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vue.Reporting;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;

/**
 *Classe qui traite les données de la bdd en fonction des demandes de reporting
 * @author Roxane
 */
public class ButtonReportController implements ActionListener {
    
    private Reporting fenetre;
    private Connection conn;

    /**
     *Constructeur surchargé 
     * @param fen
     * @param maConnexion
     */
    public ButtonReportController(Reporting fen, Connection maConnexion) 
    {
        this.fenetre = fen;
         this.conn = maConnexion;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        // Lorsque on veut connaitre la quantité de malades par médecins
        if(e.getSource() == fenetre.getMparS())
        {
              try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM hospitalisation WHERE code_service = 'CAR') as numero1, (SELECT COUNT(*) FROM hospitalisation WHERE code_service = 'CHG') as numero2, (SELECT COUNT(*) FROM hospitalisation WHERE code_service = 'REA') as numero3");
                Requete.next();
                
                // On récupère les valeurs de la requete
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                
                // On crée un tableau pour stocker les valeurs
                int Tab[] = new int[3];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                
                // On crée un tableau pour stocker les noms 
                String Nom_Service[] = new String[3];
                Nom_Service[0]= ("CAR = "+a);
                Nom_Service[1]= ("REA = "+b);
                Nom_Service[2]= ("CHG = "+c);
                
                // Titre du graphique
                String titre = ("Nombre de Malades par Service");
               
                // On met le choix à 'null'
               String choix = null;
                
               // Si le client choisit le camembert 
               if(fenetre.getSelectC().isSelected()){
                  // On change la valeur de la variable choix
                   choix = "camembert"; 
               }
               else{ choix = "histogramme";}
                
                
           // On crée un nouvel élément avec les valeurs obtenues 
           Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
           //Création d'un nouveau JPanel
           JPanel z = new JPanel();
           // On récupère les données du p0 de tpc et on les met dans z
            z = tpc.getp0();
            // On efface la fenetre
            fenetre.getp2().removeAll();
            // On affiche z
            fenetre.getp2().add(z);
            fenetre.revalidate();
            //tpc.setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
           
        }
        
        // Lorsqu'on veut le détail des docteurs par service
        if(e.getSource() == fenetre.getDparS())
        {
           try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM docteur WHERE specialite = 'Anesthesiste') as numero1, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Cardiologue') as numero2, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Orthopediste') as numero3 , (SELECT COUNT(*) FROM docteur WHERE specialite = 'Pneumologue') as numero4, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Radiologue') as numero5, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Generaliste') as numero6, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Traumatologue') as numero7");

                Requete.next();
                
                 // On récupère les valeurs de la requete
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                int d = Requete.getInt("numero4");
                int ee = Requete.getInt("numero5");
                int f = Requete.getInt("numero6");
                int g = Requete.getInt("numero7");
                
                
                // On crée un tableau pour stocker les valeurs
                int Tab[] = new int[7];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                Tab[3]=d;
                Tab[4]=ee;
                Tab[5]=f;
                Tab[6]=g;
                
                // On crée un tableau pour stocker les noms 
                String Nom_Service[] = new String[7];
                Nom_Service[0]= ("Anesthesiste = "+a);
                Nom_Service[1]= ("Cardiologue = "+b);
                Nom_Service[2]= ("Generaliste = "+c);
                Nom_Service[3]= ("Orthopediste = "+d);
                Nom_Service[4]= ("Pneumologue = "+ee);
                Nom_Service[5]= ("Radiologue = "+f);
                Nom_Service[6]= ("Traumatologue = "+g);
                
               // Titre du graphique
                String titre = ("Nombre de Docteurs par Specialité");
                
               
                String choix = null;
                
         // Si le client choisit le camembert 
               if(fenetre.getSelectC().isSelected()){
                  // On change la valeur de la variable choix
                   choix = "camembert"; 
               }
               else{ choix = "histogramme";}
                
            // On crée un nouvel élément avec les valeurs obtenues 
           Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
           //Création d'un nouveau JPanel
           JPanel z = new JPanel();
           // On récupère les données du p0 de tpc et on les met dans z
            z = tpc.getp0();
            // On efface la fenetre
            fenetre.getp2().removeAll();
            // On affiche z
            fenetre.getp2().add(z);
            fenetre.revalidate();
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        // Si on veut connaitre les salaires par infirmier  
        if(e.getSource() == fenetre.getSparI())
        {
              try {
                Statement stmt = conn.createStatement();  
               ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM infirmier WHERE salaire < 1300) as numero1, (SELECT COUNT(*) FROM infirmier WHERE salaire > 1300 AND salaire < 1600) as numero2, (SELECT COUNT(*) FROM infirmier WHERE salaire > 1600) as numero3 ");

                Requete.next();
                
                 // On récupère les valeurs de la requete
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                
               // On crée un tableau pour stocker les valeurs
                int Tab[] = new int[3];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                
                // On crée un tableau pour stocker les noms 
                String Nom_Service[] = new String[3];
                Nom_Service[0]= ("Salaires < 1300 euros = "+a);
                Nom_Service[1]= ("Salaires entre 1300 et 1600 euros = "+b);
                Nom_Service[2]= ("Salaires > 1600 euros = "+c);
                
                String titre = ("Répartition des salaires chez les Infirmiers");
                
                String choix = null;
              
                // Si le client choisit le camembert 
               if(fenetre.getSelectC().isSelected()){
                  // On change la valeur de la variable choix
                   choix = "camembert"; 
               }
               else{ choix = "histogramme";}
                
            // On crée un nouvel élément avec les valeurs obtenues 
           Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
           //Création d'un nouveau JPanel
           JPanel z = new JPanel();
           // On récupère les données du p0 de tpc et on les met dans z
            z = tpc.getp0();
            // On efface la fenetre
            fenetre.getp2().removeAll();
            // On affiche z
            fenetre.getp2().add(z);
            fenetre.revalidate();
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
          
        // Si on veut connaitre la réparition des différents métiers au sein du Centre Hospitalier
        if(e.getSource() == fenetre.getDiffMetiers())
        {
           try {
                Statement stmt = conn.createStatement();  
               ResultSet Requete1 = stmt.executeQuery("SELECT COUNT(*) AS resultat1 FROM docteur");

                Requete1.next();
                 // On récupère la valeurs de la requete
                int a = Requete1.getInt("resultat1");
                 ResultSet Requete2 = stmt.executeQuery("SELECT COUNT(*) AS resultat2 FROM infirmier");
                Requete2.next(); 
                 // On récupère la valeurs de la requete
                int b = Requete2.getInt("resultat2");
                
                // On crée un tableau pour stocker les valeurs
                int Tab[] = new int[2];
                Tab[0]= a;
                Tab[1]=b;
              
                
               // On crée un tableau pour stocker les noms 
                String Nom_Service[] = new String[2];
                Nom_Service[0]= (" Docteurs = "+a);
                Nom_Service[1]= ("Infirmiers = "+b);
                
                
                String titre = ("Effectifs par Métier");
                
                String choix = null;
             
                // Si le client choisit le camembert 
               if(fenetre.getSelectC().isSelected()){
                  // On change la valeur de la variable choix
                   choix = "camembert"; 
               }
               else{ choix = "histogramme";}
                
             // On crée un nouvel élément avec les valeurs obtenues 
           Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
           //Création d'un nouveau JPanel
           JPanel z = new JPanel();
           // On récupère les données du p0 de tpc et on les met dans z
            z = tpc.getp0();
            // On efface la fenetre
            fenetre.getp2().removeAll();
            // On affiche z
            fenetre.getp2().add(z);
            fenetre.revalidate();
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            }  
           
        }
         
        // Si on veut connaitre le nombre de malades par docteur 
        if(e.getSource() == fenetre.getMparD())
        {
         try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM soigne WHERE no_docteur = 4) as numero1, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 7) as numero2, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 8) as numero3 , (SELECT COUNT(*) FROM soigne WHERE no_docteur = 10) as numero4, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 19) as numero5, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 24) as numero6, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 26) as numero7");


                Requete.next();
                
                 // On récupère les valeurs de la requete
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                int d = Requete.getInt("numero4");
                int ee = Requete.getInt("numero5");
                int f = Requete.getInt("numero6");
                int g = Requete.getInt("numero7");
                
                // On crée un tableau pour stocker les valeurs
                int Tab[] = new int[7];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                Tab[3]=d;
                Tab[4]=ee;
                Tab[5]=f;
                Tab[6]=g;
                
                // On crée un tableau pour stocker les noms 
                String Nom_Service[] = new String[7];
                Nom_Service[0]= ("Dr. NADAL Rafael = "+a);
                Nom_Service[1]= ("Dr. BJORKMAN Jonas = "+b);
                Nom_Service[2]= ("Dr. GROSJEAN Sebastien = "+c);
                Nom_Service[3]= ("Dr. FERRER David = "+d);
                Nom_Service[4]= ("Dr. SAFIN Marat= "+ee);
                Nom_Service[5]= ("Dr. ZVONAREVA Vera = "+f);
                Nom_Service[6]= ("Dr. HANTUCHOVA Daniela = "+g);
                
                String titre = ("Nombre de Malades par Medecin");
                
                String choix = null;
            
                // Si le client choisit le camembert 
               if(fenetre.getSelectC().isSelected()){
                  // On change la valeur de la variable choix
                   choix = "camembert"; 
               }
               else{ choix = "histogramme";}
                
             // On crée un nouvel élément avec les valeurs obtenues 
           Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
           //Création d'un nouveau JPanel
           JPanel z = new JPanel();
           // On récupère les données du p0 de tpc et on les met dans z
            z = tpc.getp0();
            // On efface la fenetre
            fenetre.getp2().removeAll();
            // On affiche z
            fenetre.getp2().add(z);
            fenetre.revalidate();
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        
        // Si on veut connaitre le nombre d'infirmiers par service
        if(e.getSource() == fenetre.getIparS()) 
        {
            try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete1 = stmt.executeQuery("SELECT COUNT(`numero`) AS numero FROM `infirmier` WHERE `code_service` = 'CAR'");
                Requete1.next();
                 // On récupère la valeurs de la requete
                int a = Requete1.getInt("numero");
                
                ResultSet Requete2 = stmt.executeQuery("SELECT COUNT(`numero`) AS numero FROM `infirmier` WHERE `code_service` = 'REA'");
                Requete2.next();
                 // On récupère la valeurs de la requete
                int b = Requete2.getInt("numero");
                
                ResultSet Requete3 = stmt.executeQuery("SELECT COUNT(`numero`) AS numero FROM `infirmier` WHERE `code_service` = 'CHG'");
                Requete3.next();
                 // On récupère la valeurs de la requete
                int c = Requete3.getInt("numero");
                
               // On crée un tableau pour stocker les valeurs
                int Tab[] = new int[3];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                
                // On crée un tableau pour stocker les noms 
                String Nom_Service[] = new String[3];
                Nom_Service[0]= ("CAR = "+a);
                Nom_Service[1]= ("REA = "+b);
                Nom_Service[2]= ("CHG = "+c);
                
                String titre = ("Nombre d'infirmiers par Service");
                
                String choix = null;
                
            // Si le client choisit le camembert 
               if(fenetre.getSelectC().isSelected()){
                  // On change la valeur de la variable choix
                   choix = "camembert"; 
               }
               else{ choix = "histogramme";}
               
            
            // On crée un nouvel élément avec les valeurs obtenues 
           Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
           //Création d'un nouveau JPanel
           JPanel z = new JPanel();
           // On récupère les données du p0 de tpc et on les met dans z
            z = tpc.getp0();
            // On efface la fenetre
            fenetre.getp2().removeAll();
            // On affiche z
            fenetre.getp2().add(z);
            fenetre.revalidate();
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        }
    }
    

