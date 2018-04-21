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
    private JRadioButton selectC, selectH;
     private Connection conn;
     private JPanel boutons, ronds, p2, p3;
    
    public Reporting(Connection maConnexion){
        
        super ("Reporting");

        this.conn = maConnexion;
        
       MparS = new JButton("Nbr Malades par Service");
       DparS = new JButton("Nbr de Docteur par Spécialité");
       SparI = new JButton("Salaire des Infirmiers");
       DiffMetiers = new JButton("Proprortions des différents métiers");
       MparD = new JButton("Nbr de Malades par Docteurs");
       IparS = new JButton("Nbr d'infirmiers par Service");
       
       selectC = new JRadioButton("Camembert");
       selectH = new JRadioButton("Histogramme");
 
        selectC.setSelected(true);

         ButtonGroup group = new ButtonGroup();
        group.add(selectC);
        group.add(selectH);
    
        selectC.addActionListener(new ButtonReportController(this, conn));
        selectH.addActionListener(new ButtonReportController(this, conn));

       MparS.addActionListener(new ButtonReportController(this, conn));
       DparS.addActionListener(new ButtonReportController(this, conn));
       SparI.addActionListener(new ButtonReportController(this, conn));
       DiffMetiers.addActionListener(new ButtonReportController(this, conn));
       MparD.addActionListener(new ButtonReportController(this, conn));
       IparS.addActionListener(new ButtonReportController(this, conn));
       
        
   
        //Création des panneaux
        
        boutons = new JPanel();
        ronds = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel(new BorderLayout());
        p3.add(boutons,BorderLayout. NORTH);
        p3.add(p2,BorderLayout. CENTER);
        
        boutons.setLayout(new GridLayout(2, 3, -20, 20)); 
        ronds.setLayout(new GridLayout(1, 1, -20, 20)); 
       
        
        // Ajout des boutons dans le p0
        
        boutons.add(MparS);
        boutons.add(DparS);
        boutons.add(SparI);
        boutons.add(DiffMetiers);
        boutons.add(MparD);
        boutons.add(IparS);
        ronds.add(selectC);
        ronds.add(selectH);
        
     
        
        // disposition geographique des panneaux 
        this.getContentPane().add(p3, BorderLayout. CENTER);
        this.getContentPane().add(ronds, BorderLayout. NORTH);
        //this.getContentPane().add(p2, BorderLayout. SOUTH);
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
     
    public JRadioButton getSelectC()
    {
        return selectC;
    }
    
    public JRadioButton getSelectH()
    {
        return selectH;
    }
    
    
}
