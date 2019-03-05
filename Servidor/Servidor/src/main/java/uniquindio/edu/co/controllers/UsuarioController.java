package uniquindio.edu.co.controllers;

import java.util.List;
import uniquindio.edu.co.bd.models.Usuario;
import uniquindio.edu.co.bd.pojo.UsuarioPOJO;

/**
 *
 * @author gusta
 */
public class UsuarioController {

    private UsuarioPOJO pojo;

    public UsuarioController() {
        pojo = new UsuarioPOJO();
    }

    public String comprobarLogin(String usuario, String clave) {
        List<Usuario> usuarios = pojo.login(usuario, clave);

        if (usuarios.isEmpty()) {
            //No Existe ningun usuario con esos datos
            return "201";
        }

        if (usuarios.size() == 1) {
            if (usuarios.get(0).isBloqueado()) {
                //Usuario se encuentra Bloqueado / inhabilitado
                return "301";
            }
            //Usuario Correcto ...
            return "101||" + usuarios.get(0).getId();
        }
        //error general
        return "200";
    }

    public String insertarUsuario(Usuario usuario) {
        int res = pojo.insertarUsuario(usuario);
        return String.valueOf(res);
    }

    public String actualizarUsuario(Usuario usuario) {
        int res = pojo.actualizarUsuario(usuario);
        return String.valueOf(res);
    }

    public String obtenerUsuarios(String usuarioId) {
        String res = "";
        List<Usuario> todos = pojo.todos(usuarioId);
        for (Usuario u : todos) {
            res += String.format("%s||[%s] %s %s\n", u.getId(), u.getUsr(), u.getNombres(), u.getApellidos());
        }
        return res;
    }

}
