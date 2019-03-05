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

    public List<Usuario> login(String usr, String pass) {
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
    
    
    public List<Usuario> todos(String usuarioId) {
        try (Connection con = DbHelper.getSql2o().open()) {
            final String query
                    = "SELECT u.id, u.usr, u.nombres , u.apellidos , u.estado , u.email FROM usuario u  LEFT JOIN amigos a \n" +
                        "ON u.id = a.amigo_id AND a.id <> = :usuarioId";

            return con.createQuery(query)
                    .addParameter("usuarioId", usuarioId)                    
                    .executeAndFetch(Usuario.class);
        }
    }
    

    public int insertarUsuario(Usuario usuario) {
        int res = -1;
        final String insertQuery
                = "INSERT INTO usuario (usr, pass,nombres,apellidos,estado,email) "
                + "VALUES (:usr, :pass,:nombres,:apellidos,:estado,:email)";

        try (Connection con = DbHelper.getSql2o().beginTransaction()) {
            res = con.createQuery(insertQuery, true)
                    .addParameter("usr", usuario.getUsr())
                    .addParameter("pass", usuario.getPass())
                    .addParameter("nombres", usuario.getNombres())
                    .addParameter("apellidos", usuario.getApellidos())
                    .addParameter("estado", "Conectado")
                    .addParameter("email", usuario.getEmail())
                    .executeUpdate()
                    .getResult();
            con.commit();
        }

        return res;
    }

    public int actualizarUsuario(Usuario usuario) {
        int res = -1;

        final String updateQuery
                = "UPDATE usuario SET :usr, :pass,:nombres,:apellidos,:estado,:email WHERE id = :id";

        try (Connection con = DbHelper.getSql2o().open()) {
            res = con.createQuery(updateQuery, true)
                    .bind(usuario)
                    .executeUpdate()
                    .getResult();
        }

        return res;
    }

    public Usuario obtenerUsuario(int id) {
        try (Connection con = DbHelper.getSql2o().open()) {
            final String query
                    = "SELECT id, usr, pass , nombres , apellidos , estado , email , bloqueado "
                    + "FROM usuario WHERE id = :id";

            return con.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Usuario.class);
        }
    }

}
