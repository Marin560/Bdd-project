package Vue;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author peti_
 */
public class Fenetre extends JFrame {
    private JButton recherche,maj,reporting,connexion;
    private JPanel panel;
    
    //Constructeur 
    public Fenetre(){
       
        super();
        
        setLayout(new BorderLayout());     
        //Taille de la fenêtre
        setSize(800,700); 
        //place la fenêtre au centre de l'écran
        setLocationRelativeTo(null);
        
        //Ajout de l'icône de la fenêtre
        ImageIcon icone = new ImageIcon("images/hopital.jpeg");
        setIconImage(icone.getImage());
        
        //Affiche la fenêtre
        setVisible(true);
         
    }  
    
    public Fenetre (String nom){
        super(nom);
        
        setLayout(new BorderLayout());     
        //Taille de la fenêtre
        setSize(800,700); 
        //place la fenêtre au centre de l'écran
        setLocationRelativeTo(null);
        
        //Ajout de l'icône de la fenêtre
        ImageIcon icone = new ImageIcon("images/hopital.jpeg");
        setIconImage(icone.getImage());
        
        //Affiche la fenêtre
        setVisible(true);
    }
    
        public Fenetre (String nom, int taille_x, int taille_y){
        super(nom);
        
        setLayout(new BorderLayout());     
        //Taille de la fenêtre
        setSize(taille_x,taille_y); 
        //place la fenêtre au centre de l'écran
        setLocationRelativeTo(null);
        
        //Ajout de l'icône de la fenêtre
        ImageIcon icone = new ImageIcon("images/hopital.jpeg");
        setIconImage(icone.getImage());
        
        //Affiche la fenêtre
        setVisible(true);
    }
    
}
