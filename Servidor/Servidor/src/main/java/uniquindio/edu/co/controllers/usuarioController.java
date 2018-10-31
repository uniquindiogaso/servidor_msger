package uniquindio.edu.co.controllers;

import java.util.List;
import uniquindio.edu.co.bd.models.Usuario;
import uniquindio.edu.co.bd.pojo.UsuarioPOJO;

/**
 *
 * @author gusta
 */
public class usuarioController {

    private UsuarioPOJO pojo;
    
    public usuarioController() {
        pojo = new UsuarioPOJO();
    }
    
    public String comprobarLogin(String usuario , String clave){
         List<Usuario> usuarios = pojo.login("gaso", "123");
         return "";
    }
    
    
    
}
