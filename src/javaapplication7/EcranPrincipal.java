/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author peti_
 */
public class EcranPrincipal extends JFrame implements ActionListener, ItemListener{

    private JButton Recherche, MaJ, Reporting;
    private JPanel p0;
    private JComboBox ChoixAffichageTab;
    public JTable jtable;
    public String namebdd;
    
    //Constructeur
    public EcranPrincipal(){
        
        super("Logiciel de Gestion du Centre Hospitalier");
        
        // mise en page (layout) de la fenetre visible 
        setLayout(new BorderLayout()); 
        //setSize(1000,1000);
        setBounds(0, 0, 400, 400); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quitte le programme quand la fenêtre est fermée
        setResizable(true); 
        
        //Création des boutons 
        Recherche = new JButton("Recherche d'informations"); 
        MaJ = new JButton ("Mise à Jour des données"); 
        Reporting = new JButton ("Reporting");
        
        //Pannel 
        p0 = new JPanel();
        p0.setLayout(new GridLayout(1, 1)); 
        
        //Ajout des boutons au panel
        p0.add(Recherche); 
        p0.add(MaJ); 
        p0.add(Reporting); 
        
        //Disposition du panel
        // disposition geographique des panneaux 
        this.getContentPane().add(p0, BorderLayout.SOUTH);
        add("North", p0); 
        
        
        setVisible(true); 
        
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void itemStateChanged(ItemEvent ie) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
