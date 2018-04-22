/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modèle;

import Vue.Reporting;
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
 * Classe qui crée les graphiques à partir des valeurs de la bdd
 * @author Roxane
 */
public class Action_Reporting extends JFrame {
    
        
    private JPanel p0;
    private int Nombre[];
    private String[] Noms;
    private String titre;
    private String choix;
    
    /**
     *Constructeur surchargé
     * @param pNombre
     * @param pNoms
     * @param ptitre
     * @param pchoix
     */
    public Action_Reporting(int pNombre[], String pNoms[], String ptitre, String pchoix){
    
    // Création du panel
    p0 = new JPanel(new BorderLayout());
    setContentPane(p0);
    setSize(400, 250);
    
    // On crée les valeurs
    Nombre=pNombre;
    Noms = pNoms;
    titre=ptitre;
    choix=pchoix;
    
    // Création des graphiques ( camembert et histogramme)
    DefaultPieDataset pieDataset = new DefaultPieDataset();
    DefaultCategoryDataset barDataset = new DefaultCategoryDataset( );

    // On parcourt le tableau qui contient les quantités, et on crée les graphiques en fonction
    for(int i=0; i<Nombre.length; i++){
        
        // Camembert
        pieDataset.setValue(Noms[i], Nombre[i]);
        // Histogramme
        barDataset.addValue(Nombre[i], " ", Noms[i]);
        
    }
    
    // Si le mot 'camembert' est donné à la variable choix
    if (choix.equals("camembert"))
    {
        // On met dans p0 le graphique sous la forme camembert
        JFreeChart pieChart = ChartFactory.createPieChart3D(titre,pieDataset, true, true, true);
        ChartPanel cPanel = new ChartPanel(pieChart);
        p0.add(cPanel); 
    }
    
    // Sinon (si le mot 'histogramme' est donné à la variable choix
    else{
        // On met dans p0 le graphique sous la forme histogramme
        JFreeChart barChart = ChartFactory.createBarChart(titre,"","",barDataset,PlotOrientation.VERTICAL,true, true, false);
        ChartPanel cPanel = new ChartPanel(barChart);
        p0.add(cPanel);
    }
   
    
    }
    
    /**
     *Getter qui retourne le contenu de p0
     * @return
     */
    public JPanel getp0(){
        return p0;
    }

   
}
