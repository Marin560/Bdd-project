/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.Ajouter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Effectue les traitements SQL lors de l'ajout d'un nouvel élément à la base de données
 * 
 * @author peti_
 */
public class Ajouter_traitement {
    
    private Connection maConnexion;
    
    public Ajouter_traitement(Connection maConnexion){
        //Nouvelle connexion qu'on reçoit lors de la création de l'objet
        this.maConnexion = maConnexion;
    }
       
    //Methodes : ajouter Malade
    public void ajouter_malade(String nom, String prenom, String adresse, String telephone, String mutuelle) throws SQLException{ //Je reçoit tous les paramètres
        //Si chaque String n'est pas vide = toutes les infos ont été entrées
        if((nom.length()== 0)||(prenom.length()== 0)||(adresse.length()==0)||(telephone.length()==0)||(mutuelle.length() == 0)){
            System.out.println("null"); //Ca marche
            JOptionPane.showMessageDialog(null,"Vous n'avez pas entré toutes les infos necessaires","Impossible d'ajouter le malade",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Statement stmt = maConnexion.createStatement();
        
            //On récupère le dernier numéro de la liste des malades 
            int dernier=0;
            ResultSet Requete = stmt.executeQuery("SELECT MAX(numero) FROM malade");
            while(Requete.next()){
                dernier = Integer.parseInt(Requete.getString("MAX(numero)"));
            }
            //On incrémente le numéro du malade de 1
            dernier++;
            //Envoie des infos dans la base de donnée grâce à la classe connexion
            stmt.execute("INSERT INTO `malade` (`numero`, `nom`, `prenom`, `adresse`, `tel`, `mutuelle`) VALUES ('"+dernier+"', '"+nom+"', '"+prenom+"', '"+adresse+"', '"+telephone+"', '"+mutuelle+"')");
            //this.dispose();
        }
    }
    
    public void ajout_employe(String nom, String prenom, String adresse, String telephone, String type_employe, JComboBox box_infirmier_service, JComboBox box_infirmier_rotation, JComboBox doc_service) throws SQLException{
        //Si chaque String n'est pas vide, (= toutes les infos ont bien été entrées)
        System.out.println(nom);
        System.out.println(prenom);
        System.out.println(adresse);
        System.out.println(telephone);
        System.out.println(type_employe);
        
        if((nom.length()== 0)||(prenom.length()== 0)||(adresse.length()==0)||(telephone.length()==0)){
            System.out.println("null"); //Ca marche
            JOptionPane.showMessageDialog(null,"Vous n'avez pas entré toutes les infos necessaires","Impossible d'ajouter l'employe",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Statement stmt = maConnexion.createStatement();
            
            //On récupère le dernier numéro de la liste des malades 
            int dernier=0;
            
            //On récupère le numéro du malade avec le plus grand numéro 
            ResultSet Requete = stmt.executeQuery("SELECT MAX(numero) FROM employe");
            while(Requete.next()){
                dernier = Integer.parseInt(Requete.getString("MAX(numero)"));
            }
            //On incrémente le numéro du malade de 1
            dernier++;
            //Envoie des infos dans la base de donnée grâce à la classe connexion
            //De cette manière, le numéro du dernier ajouté, est toujours le plus grand. Cela évite aussi les doublons
            stmt.execute("INSERT INTO `employe` (`numero`, `nom`, `prenom`, `adresse`, `tel`) VALUES ('"+dernier+"', '"+nom+"', '"+prenom+"', '"+adresse+"', '"+telephone+"')");
            
            //En fonction du type d'employé que j'ajoute 
            if(type_employe.equals("Infirmier")){
                
                //Ajout de l'infirmier
                String service, rotation, salaire;
                service = (String) box_infirmier_service.getSelectedItem();
                rotation = (String) box_infirmier_rotation.getSelectedItem();
                //salaire = (String) salaire;
                
                stmt.execute("INSERT INTO `infirmier` (`numero`, `code_service`, `rotation`, `salaire`) VALUES ('"+dernier+"', '"+service+"', '"+rotation+"', NULL)");
                //this.dispose();
            }
            else if(type_employe.equals("Docteur")){
                //Ajout du docteur
                String specialite = (String) doc_service.getSelectedItem();
                stmt.execute("INSERT INTO `docteur` (`numero`, `specialite`) VALUES ('"+dernier+"', '"+specialite+"')");
                //this.dispose();
            }
            
        }
    }
    
    
    
        
        
        
}

    
