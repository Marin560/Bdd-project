/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Connexion;
import java.awt.BorderLayout; 
import java.awt.GridLayout; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.awt.event.ItemEvent; 
import java.awt.event.ItemListener; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton; 
import javax.swing.JComboBox;
import javax.swing.JFrame; 
import javax.swing.JOptionPane;
import javax.swing.JPanel; 
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.*;
import javax.swing.table.TableModel;

/**
 *
 * @author Roxane
 */
  
public class EcranPrincipal extends Fenetre implements ActionListener, ItemListener,TableModelListener,MouseListener{ 
     
    private JButton Recherche, MaJ, Reporting, modif; //Bouttons de la fenêtre
    //private MonBouton Recherche, MaJ, Reporting;
    private JPanel p0, p1, p2, p3; 
    
    //Création de la comboBox (barre de selection)
    private JComboBox combo = new JComboBox();
    
    // Création du tableau déroulant
    public JTable jtable = new JTable();
    
    public String namebdd;
    private Connection conn; ///////////
    
    public EcranPrincipal (Connection maConnexion) throws SQLException{ //Constructeur
        // creation par heritage de la fenetre 
        super("Logiciel de Gestion du Centre Hospitalier",800,750); 
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Quitte le programme quand la fenêtre est fermée

        this.conn = maConnexion;
        Statement stmt = maConnexion.createStatement(); 
        
        
        //On crée le panneau déroulant
        combo.addItem("Chambre");
        combo.addItem("Docteur");
        combo.addItem("Employe");
        combo.addItem("Hospitalisation");
        combo.addItem("Infirmier");
        combo.addItem("Malade");
        combo.addItem("Service");
        combo.addItem("Soigne");
        combo.addActionListener(this);
         
        ////////////////////////////
        
        jtable.addMouseListener(new MouseAdapter()  {
			public void mousePressed(MouseEvent e) {
 
                                // clic sur le bouton gauche ou droit
				if(e.getButton() == MouseEvent.BUTTON1 ||
						e.getButton() == MouseEvent.BUTTON3) 
				{
					int row = jtable.rowAtPoint(e.getPoint()); 
					int col = jtable.columnAtPoint(e.getPoint());
					
                                        //On vérifie la colonne sélectionnée 
                                        //jtable.getColumnName(col)
                                        String ancienne_valeur = (String) jtable.getValueAt(row, col);
                                        
                                        System.out.println(jtable.getColumnName(col));
                                        //System.out.println(combo.getSelectedItem());
                                        
                                        JOptionPane op = new JOptionPane();
                                        String nom ;  
                                        
                                        //Pour la chambre
                                        //Si on clique sur la bonne colonne, ici c'est surveillant 
                                        if(jtable.getColumnName(col).equals("surveillant")){
                                            //On demande la nouvelle valeur
                                            nom = op.showInputDialog(null, "Entrez le nouveau Surveillant", "Changement de Surveillant", JOptionPane.QUESTION_MESSAGE);

                                            try {
                                                //UPDATE `chambre` SET `surveillant` = '86' WHERE CONCAT(`chambre`.`no_chambre`) = '101'
                                                //stmt.execute("UPDATE '"+maString+"' SET '"+jtable.getColumnName(col)+"' = '"+nom+"' WHERE CONCAT(`chambre`.`"+jtable.getColumnName(col-1)+"`) = '"+jtable.getValueAt(row, col-1)+"' ");
                                                stmt.execute("UPDATE `"+combo.getSelectedItem()+"` SET `"+jtable.getColumnName(col)+"` = '"+nom+"' WHERE CONCAT(`chambre`.`"+jtable.getColumnName(col-1)+"`) = '101'");
                                                //On met la valeur dans le tableau
                                                jtable.setValueAt(nom, row, col);
                                            
                                            } catch (SQLException ex) {
                                                Logger.getLogger(EcranPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                                            }

                                            
                                        }
                                        
                                        //Modification dans la base de donnée
                                        //UPDATE `malade` SET `tel` = '0516545' WHERE CONCAT(`malade`.`numero`) = '0';
                                        
                                        
                                }
                                
                        }
        });
        
        
        JScrollPane jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(jtable);
        
        // Création des boutons 
        Recherche = new JButton("Recherche d'informations"); 
        MaJ = new JButton ("Ajouter Element"); 
        modif = new JButton ("Modifier des élements");
        Reporting = new JButton ("Reporting");

        
        Recherche.addActionListener(this);
        MaJ.addActionListener(this);
        modif.addActionListener(this);
        Reporting.addActionListener(this);
        
        DefaultTableModel table = new DefaultTableModel();
        
        
        
        //Recherche des noms des colonnes pour la table "chambre"
        ResultSet Requete = stmt.executeQuery("SELECT column_name FROM information_schema.columns WHERE table_name = 'chambre'");
        
        while(Requete.next())
        {
            //System.out.println(Requete.getString("column_name"));
            table.addColumn(Requete.getString("column_name"));
        }
       
        jtable.setModel(table);
        
        Requete = stmt.executeQuery("SELECT * FROM chambre");
        while(Requete.next())
        {
            table.addRow(new Object[]{
                Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3))
            });
        }
        
        jtable.setModel(table);
        
       
        
        // Création des pannels  
        p0 = new JPanel(); 
        p1 = new JPanel(); 
        p2 = new JPanel();  
        p3 = new JPanel();
        
        
        p0.setLayout(new GridLayout(1, 3)); 
        p1.setLayout(new GridLayout(1,1)); 
        p2.setLayout(new GridLayout(1, 1)); 
        
        
        p0.add(Recherche); 
        p0.add(MaJ); 
        p0.add(modif);
        p0.add(Reporting); 
        p2.add(combo);
        p1.add(jScrollPane); 

        // disposition geographique des panneaux 
        this.getContentPane().add(p2, BorderLayout. CENTER);
        this.getContentPane().add(p1, BorderLayout.SOUTH);
        this.getContentPane().add(p0, BorderLayout.NORTH);
        add("North", p0); 
        add("Center", p2); 
        add("South", p1); 
        this.pack();
        
    }  
  

     
 
    @Override 
    public void actionPerformed(ActionEvent e) { 
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods,choose Tools | Templates. 
     Object source = e.getSource();
     
     if (source == combo){
         try {
             DefaultTableModel table = new DefaultTableModel();
             Statement stmt = conn.createStatement(); 
             
             ResultSet Requete = stmt.executeQuery("SELECT column_name FROM information_schema.columns WHERE table_name = '"+combo.getSelectedItem()+"'");
           
                 while(Requete.next())
                 {
                     //On ajoute au tableau chaque colonne de la table sélectionne
                     table.addColumn(Requete.getString("column_name"));
                 }
             
                //On crée notre jtable en fonction du tableau crée
                jtable.setModel(table);
             
      
                Requete = stmt.executeQuery("SELECT * FROM "+combo.getSelectedItem()+"");
                
                if(jtable.getColumnCount()== 2){
                while(Requete.next()){
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1))
                     });
                    }
                }
                 
                 if(jtable.getColumnCount()== 4){
                 while(Requete.next())
                 {
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3))
                     });
                 }
                }
                 
                if(jtable.getColumnCount()== 5){
                while(Requete.next())
                {
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3)),Requete.getString(table.getColumnName(4))
                     });
                 }
                }
                 
                if(jtable.getColumnCount()== 6){
                 while(Requete.next())
                 {
                     table.addRow(new Object[]{
                         Requete.getString(table.getColumnName(0)),Requete.getString(table.getColumnName(1)),Requete.getString(table.getColumnName(2)),Requete.getString(table.getColumnName(3)),Requete.getString(table.getColumnName(4)), Requete.getString(table.getColumnName(5))
                     });
                 }
                }

             jtable.setModel(table);
             
         } catch (SQLException ex) {
             Logger.getLogger(EcranPrincipal.class.getName()).log(Level.SEVERE, null, ex);
         }
        
     
     }
     else if(source == MaJ){
        
         Ajouter ajout = new Ajouter(conn);
     }
     
     else if(source == modif){
         Modifier_element nouvelle_modif = new Modifier_element(conn);
     }
     
     else if(source == Reporting){
         Reporting report = new Reporting(conn); 
     }
    }
    
    @Override 
    public void itemStateChanged(ItemEvent ie) { 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    } 

    @Override
    public void tableChanged(TableModelEvent tme) {
        //On regarde les modifications de la table
        System.out.println("Oui");
        int row = tme.getFirstRow();
        int column = tme.getColumn();
        System.out.println(jtable.getValueAt(row, column));
        
        
        TableModel model = (TableModel)tme.getSource();
        
        String columName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        
        
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(me.getSource()== jtable){
            int row = jtable.getSelectedRow();
            int column = jtable.getSelectedColumn();
            
            System.out.println("Oui");
            System.out.println(row);
            System.out.println(column);
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent me) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
} 



