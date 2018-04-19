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

/**
 *
 * @author Roxane
 */
public class Action_Reporting extends JFrame {
    
    private JPanel p2;
    
    public Action_Reporting(){
    
       addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
    dispose();
    System.exit(0);
    }
    });
    
    p2 = new JPanel(new BorderLayout());
    setContentPane(p2);
    setSize(400, 250);
    
    DefaultPieDataset pieDataset = new DefaultPieDataset();

    pieDataset.setValue("Valeur1", new Integer(27));
    pieDataset.setValue("Valeur2", new Integer(10));
    pieDataset.setValue("Valeur3", new Integer(50));
    pieDataset.setValue("Valeur4", new Integer(5));
 

    JFreeChart pieChart = ChartFactory.createPieChart("Test camembert",pieDataset, true, true, true);

    ChartPanel cPanel = new ChartPanel(pieChart);
    p2.add(cPanel);
    
    }
}
