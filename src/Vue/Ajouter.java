/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.Ajouter_traitement;
import Controleur.Connexion;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer.Form;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import static javax.swing.text.html.HTML.Tag.FORM;

/**
 * Permet d'ajouter des éléments à la base de données 
 * Possibilité de rajouter un malade, ou un employé
 * 
 * Un employé est soit un docteur, soit un infirmier
 * 
 * @author peti_
 */
public class Ajouter extends Fenetre implements ActionListener{
    //Elemnts d'interface
    private JButton chambre, employe, malade, ajout,submit;
    private JPanel panel_principal,panel_malade, panel_malade2,panel_employe, panel_0, uper_panel;
    private JLabel label ;
    private CardLayout card_layout = new CardLayout();
    private GroupLayout layout;
    private JTextField tf = new JTextField(10);
    private JComboBox combo, box_infirmier_service, box_infirmier_rotation, doc_service;
    
    
    //Elements de traitement 
    private Ajouter_traitement traitements ;
    
    private Connection maCo;
    //Menu déroulant
    
   
    //Afficher les données 
    //Constructeur 

    /**
     *
     * @param maConnexion
     */
    public Ajouter(Connection maConnexion){
        
        //Création de la fenêtre et définition de la taille
        super("Nouvel Element",400,400);
        
        //Configuration connexcion
        this.maCo = maConnexion;
        
        traitements = new Ajouter_traitement(maConnexion);
        
        
        //Configuration du bouton ajouter
        submit = new JButton("Ajouter");

        creation_menu_deroulant();
        
        panel_principal = new JPanel();
        panel_principal.setLayout(card_layout);
        panel_0 = new JPanel();
        preparation_malade();
        preparation_employe();

        uper_panel = new JPanel();
        //uper_panel.setBackground(Color.red);
        uper_panel.add(combo);
        
        panel_principal.add(panel_0,"0");
        panel_principal.add(panel_malade,"1");
        panel_principal.add(panel_employe,"2");
        
        add(panel_principal,BorderLayout.CENTER);
        add(uper_panel,BorderLayout.NORTH);
        
        card_layout.show(panel_principal,"0");

        //setAlwaysOnTop(true);
        setVisible(true);
        
    }
    
    public void creation_menu_deroulant(){
        //Création du menu déroulant
        combo = new JComboBox();
        combo.addItem("Choisissez une catégorie");
        combo.addItem("Malade");
        combo.addItem("Employe");
        combo.addActionListener(this);
    }

    public void preparation_malade(){
        //Création et configuration du panel malade
        panel_malade = new JPanel();
        //panel_malade.setBackground(Color.yellow);

    }
    
    public void preparation_employe(){
        panel_employe = new JPanel();
        //panel_employe.setBackground(Color.blue);
    }
    
    public void ajout_malade(String nom, String prenom, String adresse, String telephone, String mutuelle) throws SQLException{
        //Si chaque String n'est pas vide = toutes les infos ont été entrées
        if((nom.length()== 0)||(prenom.length()== 0)||(adresse.length()==0)||(telephone.length()==0)||(mutuelle.length() == 0)){
            System.out.println("null"); //Ca marche
            JOptionPane.showMessageDialog(null,"Vous n'avez pas entré toutes les infos necessaires","Impossible d'ajouter le malade",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Statement stmt = maCo.createStatement();
        
            //On récupère le dernier numéro de la liste des malades 
            int dernier=0;
            ResultSet Requete = stmt.executeQuery("SELECT MAX(numero) FROM malade");
            while(Requete.next()){
                dernier = Integer.parseInt(Requete.getString("MAX(numero)"));
            }
            //On incrémente le numéro du malade de 1
            dernier++;
            //Envoie des infos dans la base de donnée grâce à la classe connexion
            stmt.execute("INSERT INTO `malade` (`numero`, `nom`, `prenom`, `adresse`, `tel`, `mutuelle`) VALUES ('"+dernier+"', '"+nom+"', '"+prenom+"', '"+adresse+"', '"+telephone+"', '"+mutuelle+"')");
            this.dispose();
        }
    }
    
    public void ajout_employe(String nom, String prenom, String adresse, String telephone, String salaire, String type_employe) throws SQLException{
        //Si chaque String n'est pas vide = toutes les infos ont été entrées
        if((nom.length()== 0)||(prenom.length()== 0)||(adresse.length()==0)||(telephone.length()==0)){
            System.out.println("null"); //Ca marche
            JOptionPane.showMessageDialog(null,"Vous n'avez pas entré toutes les infos necessaires","Impossible d'ajouter l'employe",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Statement stmt = maCo.createStatement();
            //On récupère le dernier numéro de la liste des malades 
            int dernier=0;
            
            ResultSet Requete = stmt.executeQuery("SELECT MAX(numero) FROM employe");
            while(Requete.next()){
                dernier = Integer.parseInt(Requete.getString("MAX(numero)"));
            }
            //On incrémente le numéro du malade de 1
            dernier++;
            //Envoie des infos dans la base de donnée grâce à la classe connexion
            stmt.execute("INSERT INTO `employe` (`numero`, `nom`, `prenom`, `adresse`, `tel`) VALUES ('"+dernier+"', '"+nom+"', '"+prenom+"', '"+adresse+"', '"+telephone+"')");
            
            //En fonction du type d'employé que j'ajoute 
            if(type_employe.equals("Infirmier")){
                //Ajout de l'infirmier
                String service, rotation;
                service = (String) box_infirmier_service.getSelectedItem();
                rotation = (String) box_infirmier_rotation.getSelectedItem();
                //salaire = (String) salaire;
                
                stmt.execute("INSERT INTO `infirmier` (`numero`, `code_service`, `rotation`, `salaire`) VALUES ('"+dernier+"', '"+service+"', '"+rotation+"', '"+salaire+"')");
                this.dispose();
            }
            else if(type_employe.equals("Docteur")){
                //Ajout du docteur
                String specialite = (String) doc_service.getSelectedItem();
                stmt.execute("INSERT INTO `docteur` (`numero`, `specialite`) VALUES ('"+dernier+"', '"+specialite+"')");
                this.dispose();
            }
            
        }
    }
    
    //Listeners
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource()== combo){
            //On vérifie quel élément a été sélectionné
            if(combo.getSelectedItem() == "Malade"){
                
                //On crée le GroupLayout et on le lie à panel_malade
                layout = new GroupLayout(panel_malade);
                panel_malade.setLayout(layout);
                
                //On crée les textes à afficher
                JLabel label1 = new JLabel("Prenom");
                JLabel label2 = new JLabel("Nom");
                JLabel label3 = new JLabel("Telephone");
                JLabel label4 = new JLabel("Mutuelle");
                JLabel label5 = new JLabel("Adresse");
                
                //On crée les zones pour ajouter du texte
                JTextField prenom = new JTextField();
                JTextField nom = new JTextField();
                JTextField tel = new JTextField();
                JTextField mutuelle = new JTextField();
                JTextField adresse = new JTextField();
                
                
                //On ajoute un espace automatique entre chaque composant de la fenêtre
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);

                //On crée un groupe pour l'axe horizontal
                GroupLayout.SequentialGroup groupe_horizontal = layout.createSequentialGroup();

                groupe_horizontal.addGroup(layout.createParallelGroup().
                    addComponent(label1).addComponent(label2).addComponent(label3).addComponent(label4).addComponent(label5));
                groupe_horizontal.addGroup(layout.createParallelGroup().
                    addComponent(prenom).addComponent(nom).addComponent(tel).addComponent(mutuelle).addComponent(adresse).addComponent(submit));
 
                layout.setHorizontalGroup(groupe_horizontal);

                //On crée un autre groupe pour l'axe vertical
                GroupLayout.SequentialGroup groupe_vertical = layout.createSequentialGroup();

                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label1).addComponent(prenom));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label2).addComponent(nom));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label3).addComponent(tel));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label4).addComponent(mutuelle));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label5).addComponent(adresse));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(submit));
                
                layout.setVerticalGroup(groupe_vertical);
                
                //J'affiche Submit
                submit.setVisible(true);
                
                //Si on clique sur ajouter :
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        try {
                            
                            //On envoie les infos dans la base de donnée
                            //traitements.ajouter_malade(nom.getText(),prenom.getText(),adresse.getText(), tel.getText(),mutuelle.getText());
                            ajout_malade(nom.getText(),prenom.getText(),adresse.getText(), tel.getText(),mutuelle.getText());
                            
                        } catch (SQLException ex) {
                            System.out.println("Impossible de rajouter à la base de données");
                            //Pop up pour dire non ? 
                            JOptionPane.showMessageDialog(null,"Erreur: " + ex,"Titre : exception",JOptionPane.ERROR_MESSAGE);
                            //Logger.getLogger(Ajouter.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });
                //On affiche maintenant le panel_malade où sont venus se placer tous les éléments 
                card_layout.show(panel_principal,"1");
            }
            
            //Si on a sélectionné 
            else if(combo.getSelectedItem() == "Employe"){
                //On crée le GroupLayout et on le lie à panel_malade
                layout = new GroupLayout(panel_employe);
                panel_employe.setLayout(layout);
                
                //On crée les textes à afficher
                JLabel label1 = new JLabel("Prenom");
                JLabel label2 = new JLabel("Nom");
                JLabel label3 = new JLabel("Telephone");
                JLabel label5 = new JLabel("Adresse");
                JLabel label6 = new JLabel("Salaire");
                JComboBox box = new JComboBox();
                box.addItem("Autre");
                box.addItem("Infirmier");
                box.addItem("Docteur");
                
                //INFIRMIER
                box_infirmier_service = new JComboBox();
                box_infirmier_service.addItem("REA");
                box_infirmier_service.addItem("CHG");
                box_infirmier_service.addItem("CAR");
                
                box_infirmier_rotation = new JComboBox();
                box_infirmier_rotation.addItem("JOUR");
                box_infirmier_rotation.addItem("NUIT");
                
                box_infirmier_service.setVisible(false);
                box_infirmier_rotation.setVisible(false);
                
                //DOCTEUR
                doc_service = new JComboBox();
                doc_service.addItem("Orthopediste");
                doc_service.addItem("Cardiologue");
                doc_service.addItem("Traumatologue");
                doc_service.addItem("Anesthesiste"); 
                doc_service.addItem("Pneumologue"); 
                doc_service.addItem("Radiologue"); 
                
                doc_service.setVisible(false);

                //On crée les zones pour ajouter du texte
                JTextField prenom = new JTextField();
                JTextField nom = new JTextField();
                JTextField tel = new JTextField();
                JTextField adresse = new JTextField();
                JTextField salaire = new JTextField();
                
                //On ajoute un espace automatique entre chaque composant de la fenêtre
                layout.setAutoCreateGaps(true);
                layout.setAutoCreateContainerGaps(true);
                //On crée un groupe pour l'axe horizontal
                GroupLayout.SequentialGroup groupe_horizontal = layout.createSequentialGroup();
                groupe_horizontal.addGroup(layout.createParallelGroup().
                    addComponent(label1).addComponent(label2).addComponent(label3).addComponent(label5).addComponent(label6));
                groupe_horizontal.addGroup(layout.createParallelGroup().
                    addComponent(prenom).addComponent(nom).addComponent(tel).addComponent(adresse).addComponent(salaire).addComponent(box).addComponent(box_infirmier_service).addComponent(box_infirmier_rotation).addComponent(doc_service).addComponent(submit));  
                layout.setHorizontalGroup(groupe_horizontal);

                //On crée un autre groupe pour l'axe vertical
                GroupLayout.SequentialGroup groupe_vertical = layout.createSequentialGroup();
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label1).addComponent(prenom));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label2).addComponent(nom));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label3).addComponent(tel));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label5).addComponent(adresse));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(label6).addComponent(salaire));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(box));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(box_infirmier_service));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(box_infirmier_rotation));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(doc_service));
                groupe_vertical.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                         addComponent(submit));
                layout.setVerticalGroup(groupe_vertical);
                
                
                //On vérifie l'état de box
                box.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        
                        if(box.getSelectedItem() == "Infirmier"){
                            salaire.setVisible(true);
                            doc_service.setVisible(false);
                            box_infirmier_service.setVisible(true);
                            box_infirmier_rotation.setVisible(true);
                        }
                        else if(box.getSelectedItem() == "Docteur"){
                            salaire.setVisible(true);
                            box_infirmier_service.setVisible(false);
                            box_infirmier_rotation.setVisible(false);
                            doc_service.setVisible(true);
                        }
                    }
                });
                
                submit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        
                        try {
                            //traitements.ajout_employe(nom.getText(), prenom.getText(), adresse.getText(), tel.getText(), (String) box.getSelectedItem(), box_infirmier_service, box_infirmier_rotation, doc_service);
                            ajout_employe(nom.getText(),prenom.getText(),adresse.getText(), tel.getText(), salaire.getText(), (String) box.getSelectedItem());
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null,"Erreur: " + ex,"Titre : exception",JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                //On affiche maintenant le panel_malade où sont venus se placer tous les éléments 
                card_layout.show(panel_principal, "2");
            }
            
        }
        
    }
}
