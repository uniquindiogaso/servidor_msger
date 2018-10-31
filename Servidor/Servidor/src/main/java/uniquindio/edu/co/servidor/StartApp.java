/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.servidor;
import java.util.List;
import uniquindio.edu.co.bd.models.Usuario;
import uniquindio.edu.co.bd.pojo.UsuarioPOJO;
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
        //new Server();
        
        UsuarioPOJO pojo = new UsuarioPOJO();
        
        List<Usuario> usuarios = pojo.login("gaso", "123");
        
        for (Usuario u : usuarios){
            System.out.println("Usuario " + u);
        }

    }
    
}
