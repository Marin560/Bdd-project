/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.Action_Reporting;
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
 *
 * @author Roxane
 */
public class ButtonReportController implements ActionListener {
    
    private Reporting fenetre;
    private Connection conn;

    public ButtonReportController(Reporting fen, Connection maConnexion) 
    {
        this.fenetre = fen;
         this.conn = maConnexion;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == fenetre.getMparS())
        {
              try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM hospitalisation WHERE code_service = 'CAR') as numero1, (SELECT COUNT(*) FROM hospitalisation WHERE code_service = 'CHG') as numero2, (SELECT COUNT(*) FROM hospitalisation WHERE code_service = 'REA') as numero3");
                Requete.next();
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                
                int Tab[] = new int[3];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                
                String Nom_Service[] = new String[3];
                Nom_Service[0]= ("CAR = "+a);
                Nom_Service[1]= ("REA = "+b);
                Nom_Service[2]= ("CHG = "+c);
                
                String titre = ("Nombre de Malades par Service");
                
               String choix = null;
                
                if(fenetre.getSelectC().isSelected()){
                  choix = "camembert"; 
               }
               else{ choix = "histogramme";}
                
                
            Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
             JPanel z = new JPanel();
            z = tpc.getp0();
            fenetre.getp2().removeAll();
            fenetre.getp2().add(z);
            fenetre.revalidate();
            //tpc.setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
           
        }
        
         if(e.getSource() == fenetre.getDparS())
        {
           try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM docteur WHERE specialite = 'Anesthesiste') as numero1, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Cardiologue') as numero2, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Orthopediste') as numero3 , (SELECT COUNT(*) FROM docteur WHERE specialite = 'Pneumologue') as numero4, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Radiologue') as numero5, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Generaliste') as numero6, (SELECT COUNT(*) FROM docteur WHERE specialite = 'Traumatologue') as numero7");

                Requete.next();
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                int d = Requete.getInt("numero4");
                int ee = Requete.getInt("numero5");
                int f = Requete.getInt("numero6");
                int g = Requete.getInt("numero7");
                
                int Tab[] = new int[7];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                Tab[3]=d;
                Tab[4]=ee;
                Tab[5]=f;
                Tab[6]=g;
                
                String Nom_Service[] = new String[7];
                Nom_Service[0]= ("Anesthesiste = "+a);
                Nom_Service[1]= ("Cardiologue = "+b);
                Nom_Service[2]= ("Generaliste = "+c);
                Nom_Service[3]= ("Orthopediste = "+d);
                Nom_Service[4]= ("Pneumologue = "+ee);
                Nom_Service[5]= ("Radiologue = "+f);
                Nom_Service[6]= ("Traumatologue = "+g);
                
                String titre = ("Nombre de Docteurs par Specialité");
                
                String choix = null;
                
          if(fenetre.getSelectC().isSelected())
          {
              choix = "camembert"; 
          }
          else{ choix = "histogramme";}
                
            Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
             JPanel z = new JPanel();
            z = tpc.getp0();
            fenetre.getp2().removeAll();
            fenetre.getp2().add(z);
            fenetre.revalidate();

            //tpc.setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
          if(e.getSource() == fenetre.getSparI())
        {
              try {
                Statement stmt = conn.createStatement();  
               ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM infirmier WHERE salaire < 1300) as numero1, (SELECT COUNT(*) FROM infirmier WHERE salaire > 1300 AND salaire < 1600) as numero2, (SELECT COUNT(*) FROM infirmier WHERE salaire > 1600) as numero3 ");

                Requete.next();
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                
                int Tab[] = new int[3];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                
                String Nom_Service[] = new String[3];
                Nom_Service[0]= ("Salaires < 1300 euros = "+a);
                Nom_Service[1]= ("Salaires entre 1300 et 1600 euros = "+b);
                Nom_Service[2]= ("Salaires > 1600 euros = "+c);
                
                String titre = ("Répartition des salaires chez les Infirmiers");
                
                String choix = null;
              if(fenetre.getSelectC().isSelected())
              {
                choix = "camembert"; 
              }
              else{ choix = "histogramme";}
                
            Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
             JPanel z = new JPanel();
            z = tpc.getp0();
            fenetre.getp2().removeAll();
            fenetre.getp2().add(z);
            fenetre.revalidate();
            //tpc.setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
          
         if(e.getSource() == fenetre.getDiffMetiers())
        {
           try {
                Statement stmt = conn.createStatement();  
               ResultSet Requete1 = stmt.executeQuery("SELECT COUNT(*) AS resultat1 FROM docteur");

                Requete1.next();
                int a = Requete1.getInt("resultat1");
                 ResultSet Requete2 = stmt.executeQuery("SELECT COUNT(*) AS resultat2 FROM infirmier");
                Requete2.next();   
                int b = Requete2.getInt("resultat2");
                
                int Tab[] = new int[2];
                Tab[0]= a;
                Tab[1]=b;
              
                
                String Nom_Service[] = new String[2];
                Nom_Service[0]= (" Docteurs = "+a);
                Nom_Service[1]= ("Infirmiers = "+b);
                
                
                String titre = ("Effectifs par Métier");
                
                String choix = null;
             if(fenetre.getSelectC().isSelected())
             {
                  choix = "camembert"; 
             }
               else{ choix = "histogramme";}
                
            Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
             JPanel z = new JPanel();
            z = tpc.getp0();
            fenetre.getp2().removeAll();
            fenetre.getp2().add(z);
            fenetre.revalidate();
            //tpc.setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            }  
           
        }
         
         if(e.getSource() == fenetre.getMparD())
        {
         try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete = stmt.executeQuery("SELECT (SELECT COUNT(*) FROM soigne WHERE no_docteur = 4) as numero1, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 7) as numero2, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 8) as numero3 , (SELECT COUNT(*) FROM soigne WHERE no_docteur = 10) as numero4, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 19) as numero5, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 24) as numero6, (SELECT COUNT(*) FROM soigne WHERE no_docteur = 26) as numero7");


                Requete.next();
                int a = Requete.getInt("numero1");
             
                int b = Requete.getInt("numero2");

                int c = Requete.getInt("numero3");
                int d = Requete.getInt("numero4");
                int ee = Requete.getInt("numero5");
                int f = Requete.getInt("numero6");
                int g = Requete.getInt("numero7");
                
                int Tab[] = new int[7];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                Tab[3]=d;
                Tab[4]=ee;
                Tab[5]=f;
                Tab[6]=g;
                
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
            if(fenetre.getSelectC().isSelected())
            {
                  choix = "camembert"; 
            }
               else{ choix = "histogramme";}
                
            Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
             JPanel z = new JPanel();
            z = tpc.getp0();
            fenetre.getp2().removeAll();
            fenetre.getp2().add(z);
            fenetre.revalidate();
            //tpc.setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
        
        
        if(e.getSource() == fenetre.getIparS()) 
        {
            try {
                Statement stmt = conn.createStatement();  
                ResultSet Requete1 = stmt.executeQuery("SELECT COUNT(`numero`) AS numero FROM `infirmier` WHERE `code_service` = 'CAR'");
                Requete1.next();
                int a = Requete1.getInt("numero");
                
                ResultSet Requete2 = stmt.executeQuery("SELECT COUNT(`numero`) AS numero FROM `infirmier` WHERE `code_service` = 'REA'");
                Requete2.next();
                int b = Requete2.getInt("numero");
                
                ResultSet Requete3 = stmt.executeQuery("SELECT COUNT(`numero`) AS numero FROM `infirmier` WHERE `code_service` = 'CHG'");
                Requete3.next();
                int c = Requete3.getInt("numero");
                
                int Tab[] = new int[3];
                Tab[0]= a;
                Tab[1]=b;
                Tab[2]=c;
                
                String Nom_Service[] = new String[3];
                Nom_Service[0]= ("CAR = "+a);
                Nom_Service[1]= ("REA = "+b);
                Nom_Service[2]= ("CHG = "+c);
                
                String titre = ("Nombre d'infirmiers par Service");
                
                String choix = null;
                
            if(fenetre.getSelectC().isSelected())
            {
               choix = "camembert"; 
            }
               else{ choix = "histogramme";}
                
            Action_Reporting tpc = new Action_Reporting( Tab, Nom_Service, titre, choix);
            
             JPanel z = new JPanel();
            z = tpc.getp0();
            fenetre.getp2().removeAll();
            fenetre.getp2().add(z);
            fenetre.revalidate();
            //tpc.setVisible(true);
                
                
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ButtonReportController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        }
    }
    

