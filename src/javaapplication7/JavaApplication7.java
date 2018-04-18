/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.sql.SQLException;

import jdbcv2018.Connexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author peti_
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        
        
    Fenetre fn = new Fenetre();  
        
    try {
        /*
        //Connection to database
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:8889/hopital", "root", "root");
        
        //Create Statement
         Statement myStmt = myConn.createStatement();
         
        //execute sql query
        ResultSet myRs = myStmt.executeQuery("select * from employe");
        
        //Results st
        while (myRs.next()) {
            System.out.println(myRs.getString("nom")+ " , "+myRs.getString("prenom")+ " , "+myRs.getString("adresse"));
        }
        */
        
        /*
        //Connexion à la base de données
        Connexion co = new Connexion ("hopital","root","root");
                
        //Affichage de ce qu'il y a dans la colonne Employés
        ArrayList<String>tab = new ArrayList<String>();
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
