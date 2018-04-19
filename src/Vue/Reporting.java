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
    
    private JButton MparS, DparS, LparS, IparS, MparD, SuparS;
     private Connection conn;
     private JPanel p0, p1;
    
    public Reporting(Connection maConnexion){
        
        super ("Reporting");
        
        this.conn = maConnexion;
        
       MparS = new JButton("Nbr Malades par Service");
       DparS = new JButton("Nbr de Docteur par Spécialité");
       LparS = new JButton("Nbr de Lits par Service");
       IparS = new JButton("Nbr d'Infirmiers par Service");
       MparD = new JButton("Nbr de Malades par Docteurs");
       SuparS = new JButton("Nbr de Surveillants par Service");
       
       
       MparS.addActionListener(new ButtonReportController(this, conn));
       DparS.addActionListener(new ButtonReportController(this, conn));
       LparS.addActionListener(new ButtonReportController(this, conn));
       IparS.addActionListener(new ButtonReportController(this, conn));
       MparD.addActionListener(new ButtonReportController(this, conn));
       SuparS.addActionListener(new ButtonReportController(this, conn));
        //Création des panneaux
        
        p0 = new JPanel();
        p1 = new JPanel();
       
        
        // Ajout des bouteaux dans le p0
        
        p0.add(MparS);
        p0.add(DparS);
        p0.add(LparS);
        p1.add(IparS);
        p1.add(MparD);
        p1.add(SuparS);
        
     
        
        // disposition geographique des panneaux 
        this.getContentPane().add(p0, BorderLayout. NORTH);
        this.getContentPane().add(p1, BorderLayout. CENTER);
    }
    
    public JButton getMparS(){
        return MparS;
    }
    
    public JButton getDparS(){
        return DparS;
    }
        
    public JButton getLparS(){
        return LparS;
    }
    
    public JButton getIparS(){
        return IparS;
    }
    
    public JButton getMparD(){
        return MparD;
    }
    
    public JButton getSuparS(){
        return SuparS;
    }
    
    
}
