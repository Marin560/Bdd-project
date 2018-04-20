/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author peti_
 */
public class Essai extends Fenetre implements ActionListener{

    //Panel
    JPanel panel_content = new JPanel();
    JPanel panel_1 = new JPanel();
    JPanel panel_2 = new JPanel();
    //Bouton
    JButton bouton1 = new JButton("Vers panel 2");
    JButton bouton2 = new JButton("Vers panel 1");
    //CardLayout
    CardLayout cd = new CardLayout();
    
    public Essai(){

         panel_content.setLayout(cd);
         
         panel_1.add(bouton1);
         panel_2.add(bouton2);
         panel_1.setBackground(Color.BLUE);
         panel_2.setBackground(Color.RED);
         
         panel_content.add(panel_1, "1");
         panel_content.add(panel_2, "2");
         cd.show(panel_content,"1");
         
         bouton1.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent ae) {
                cd.show(panel_content, "2");
             }
         });
        
        bouton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cd.show(panel_content, "1");
            }
        });
             
        add(panel_content);
        pack();
        
        }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    }


    

