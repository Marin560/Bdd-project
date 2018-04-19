/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;



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

/**
 *
 * @author Roxane
 */
public class Reporting extends Fenetre implements ActionListener{
    
    private JButton MparS, DparS, LparS, IparS, MparD, SuparS;
     private Connection conn;
     private JPanel p0, p1, p2;
    
    public Reporting(Connection maConnexion){
        
        super ("Reporting");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quitte le programme quand la fenêtre est fermée
        
        this.conn = maConnexion;
        
       MparS = new JButton("Nbr Malades par Service");
       DparS = new JButton("Nbr de Docteur par Spécialité");
       LparS = new JButton("Nbr de Lits par Service");
       IparS = new JButton("Nbr d'Infirmiers par Service");
       MparD = new JButton("Nbr de Malades par Docteurs");
       SuparS = new JButton("Nbr de Surveillants par Service");
        //Création des panneaux
        
        p0 = new JPanel();
        p1 = new JPanel();
        p2 = new JPanel();
        
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

    @Override
    public void actionPerformed(ActionEvent ae) {
    //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
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
