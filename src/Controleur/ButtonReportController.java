/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Vue.Action_Reporting;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Vue.Reporting;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;

/**
 *
 * @author Roxane
 */
public class ButtonReportController implements ActionListener {
    
    private Reporting fenetre;
    private Connection conn;

    public ButtonReportController(Reporting fen, Connection maConnexion) 
    {
        this.fenetre = fen;
         this.conn = maConnexion;
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == fenetre.getMparS())
        {
            Action_Reporting tpc = new Action_Reporting();
            tpc.setVisible(true);
        }
    }
    
}
