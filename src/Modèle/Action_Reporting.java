/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Roxane
 */
public class Action_Reporting extends JFrame {
    
        
    private JPanel p0;
    private int Nombre[];
    private String[] Noms;
    private String titre;
    private String choix;
    
    private Reporting fenetre;
    
    
    public Action_Reporting(int pNombre[], String pNoms[], String ptitre, String pchoix){
    
    p0 = new JPanel(new BorderLayout());
    setContentPane(p0);
    setSize(400, 250);
    
    Nombre=pNombre;
    Noms = pNoms;
    titre=ptitre;
    choix=pchoix;
    
    DefaultPieDataset pieDataset = new DefaultPieDataset();
    DefaultCategoryDataset barDataset = new DefaultCategoryDataset( );

    for(int i=0; i<Nombre.length; i++){
        
        pieDataset.setValue(Noms[i], Nombre[i]);
        barDataset.addValue(Nombre[i], " ", Noms[i]);
        
    }
    
    if (choix.equals("camembert"))
    {
        JFreeChart pieChart = ChartFactory.createPieChart3D(titre,pieDataset, true, true, true);
        ChartPanel cPanel = new ChartPanel(pieChart);
        p0.add(cPanel); 
    }
    
    else{
        JFreeChart barChart = ChartFactory.createBarChart(titre,"","",barDataset,PlotOrientation.VERTICAL,true, true, false);
        ChartPanel cPanel = new ChartPanel(barChart);
        p0.add(cPanel);
    }
   
    
    }
    
    public JPanel getp0(){
        return p0;
    }

   
}
