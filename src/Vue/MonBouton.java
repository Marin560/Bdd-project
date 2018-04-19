/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.awt.Color;
import javax.swing.JButton;

/**
 *
 * @author peti_
 */
public class MonBouton extends JButton {
    
    public MonBouton(String nom) {
    
        super(nom);
        setForeground(Color.BLUE);
        setOpaque(true);
        /*
         setContentAreaFilled(false); // On met à false pour empêcher le composant de peindre l'intérieur du JButton.
        setBorderPainted(false); // De même, on ne veut pas afficher les bordures.
        setFocusPainted(false); // On n'affiche pas l'effet de focus.
        setHorizontalAlignment(SwingConstants.CENTER);
        setHorizontalTextPosition(SwingConstants.CENTER);
        setIcon(new ImageIcon(icon));
        setRolloverIcon(new ImageIcon(iconHover));
        */
    }
}

