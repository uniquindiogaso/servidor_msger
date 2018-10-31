/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.bd.pojo;

import java.util.List;
import org.sql2o.Connection;
import uniquindio.edu.co.bd.DbHelper;
import uniquindio.edu.co.bd.models.Usuario;

/**
 *
 * @author gusta
 */
public class UsuarioPOJO {

    public List<Usuario> login(String usr , String pass) {
        try (Connection con = DbHelper.getSql2o().open()) {
            final String query
                    = "SELECT id, usr, pass , nombres , apellidos , estado , email , bloqueado "
                    + "FROM usuario WHERE usr = :usr AND pass = :pass";

            return con.createQuery(query)
                    .addParameter("usr", usr)
                    .addParameter("pass", pass)
                    .executeAndFetch(Usuario.class);
        }
    }

}
