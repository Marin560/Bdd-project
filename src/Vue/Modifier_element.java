/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import java.sql.Connection;

/**
 *
 * @author peti_
 */
public class Modifier_element extends Fenetre {
    
    public Modifier_element(Connection maConnexion){
        super("Modifier des Elements");
        
        setVisible(true);
    }
    
}
