/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;





import Controleur.ButtonReportController;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.data.general.DefaultPieDataset;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;

/**
 *
 * @author Roxane
 */
public class Reporting extends Fenetre {
    
    private JButton MparS, DparS, SparI, DiffMetiers, MparD, IparS;
     private Connection conn;
     private JPanel p0, p1, p2;
    
    public Reporting(Connection maConnexion){
        
        super ("Reporting");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quitte le programme quand la fenêtre est fermée
        
        this.conn = maConnexion;
        
       MparS = new JButton("Nbr Malades par Service");
       DparS = new JButton("Nbr de Docteur par Spécialité");
       SparI = new JButton("Salaire des Infirmiers");
       DiffMetiers = new JButton("Proprortions des différents métiers");
       MparD = new JButton("Nbr de Malades par Docteurs");
       IparS = new JButton("Nbr d'infirmiers par Service");
       
       
       MparS.addActionListener(new ButtonReportController(this, conn));
       DparS.addActionListener(new ButtonReportController(this, conn));
       SparI.addActionListener(new ButtonReportController(this, conn));
       DiffMetiers.addActionListener(new ButtonReportController(this, conn));
       MparD.addActionListener(new ButtonReportController(this, conn));
       IparS.addActionListener(new ButtonReportController(this, conn));
        //Création des panneaux
        
        p0 = new JPanel();
        //p1 = new JPanel();
        p2 = new JPanel();
        
        p0.setLayout(new GridLayout(2, 3, -20, 20)); 
       
        
        // Ajout des bouteaux dans le p0
        
        p0.add(MparS);
        p0.add(DparS);
        p0.add(SparI);
        p0.add(DiffMetiers);
        p0.add(MparD);
        p0.add(IparS);
        
     
        
        // disposition geographique des panneaux 
        this.getContentPane().add(p0, BorderLayout. NORTH);
        this.getContentPane().add(p2, BorderLayout. CENTER);
    }
    
    public JButton getMparS(){
        return MparS;
    }
    
    public JButton getDparS(){
        return DparS;
    }

    public JButton getSparI(){
        return SparI;
    }
    
            
    public JButton getDiffMetiers(){
        return DiffMetiers;
    }
    
    
    public JButton getMparD(){
        return MparD;
    }
    
    public JButton getIparS(){
        return IparS;
    }
    
     public JPanel getp2()
    {
        return p2;
    }
    
    
}
