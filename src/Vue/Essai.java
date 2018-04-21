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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComponent;
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
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        
        JLabel label1 = new JLabel("Prenom");
        JLabel label2 = new JLabel("Nom");
        JLabel label3 = new JLabel("Telephone");
        JLabel label4 = new JLabel("Mutuelle");
        
        JTextField tf1 = new JTextField();
        JTextField tf2 = new JTextField();
        JTextField tf3 = new JTextField();
        JTextField tf4 = new JTextField();
        
        // Turn on automatically adding gaps between components
        layout.setAutoCreateGaps(true);

        // Turn on automatically creating gaps between components that touch
        // the edge of the container and the container.
        layout.setAutoCreateContainerGaps(true);

        // Create a sequential group for the horizontal axis.

        GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();

        // The sequential group in turn contains two parallel groups.
        // One parallel group contains the labels, the other the text fields.
        // Putting the labels in a parallel group along the horizontal axis
        // positions them at the same x location.
        //
        // Variable indentation is used to reinforce the level of grouping.
        hGroup.addGroup(layout.createParallelGroup().
            addComponent(label1).addComponent(label2).addComponent(label3).addComponent(label4));
        hGroup.addGroup(layout.createParallelGroup().
                 addComponent(tf1).addComponent(tf2).addComponent(tf3).addComponent(tf4));
        layout.setHorizontalGroup(hGroup);

        // Create a sequential group for the vertical axis.
        GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();

        // The sequential group contains two parallel groups that align
        // the contents along the baseline. The first parallel group contains
        // the first label and text field, and the second parallel group contains
        // the second label and text field. By using a sequential group
        // the labels and text fields are positioned vertically after one another.
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(label1).addComponent(tf1));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(label2).addComponent(tf2));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(label3).addComponent(tf3));
        vGroup.addGroup(layout.createParallelGroup(Alignment.BASELINE).
                 addComponent(label4).addComponent(tf4));
        layout.setVerticalGroup(vGroup);
        
        add(panel);
        
        /*
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
        
        */
        }

    @Override
    
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    }


    

