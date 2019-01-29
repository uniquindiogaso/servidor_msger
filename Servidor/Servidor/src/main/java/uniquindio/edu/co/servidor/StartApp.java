/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.servidor;

import java.util.logging.Level;
import java.util.logging.Logger;
import uniquindio.edu.co.servidor.http.*;

/**
 *
 * @author gusta
 */
public class StartApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Servidor http
            JettyServer js = new JettyServer();
            js.start();
            //Servidor Chat
            new Server();            
        } catch (Exception ex) {
            Logger.getLogger(StartApp.class.getName()).log(Level.SEVERE, "OMG!... error en inicio servidor chat o jetty", ex);
        }

    }

}
