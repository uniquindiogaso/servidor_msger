/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.bd.pojo;

import java.util.List;
import org.sql2o.Connection;
import uniquindio.edu.co.bd.DbHelper;
import uniquindio.edu.co.bd.models.Amistad;
import uniquindio.edu.co.bd.models.Solicitud;

/**
 *
 * @author gusta
 */
public class AmistadPOJO {

    public List<Amistad> amigos(int usuarioId) {
        try (Connection con = DbHelper.getSql2o().open()) {
            final String query
                    = "SELECT amigo_id "
                    + "FROM amigos WHERE usuario_id = :usuario_id";

            return con.createQuery(query)
                    .addParameter("usuario_id", usuarioId)
                    .executeAndFetch(Amistad.class);
        }
    }

    public int insertar(Amistad amistad) {
        int res = -1;
        final String insertQuery
                = "INSERT INTO amigos (usuario_id, amigo_id) "
                + "VALUES (:amigo_id, :amigo_id)";

        try (Connection con = DbHelper.getSql2o().beginTransaction()) {
            res = con.createQuery(insertQuery, true)
                    .addParameter("usuario_id", amistad.getUsuario())
                    .addParameter("amigo_id", amistad.getAmigo().getId())
                    .executeUpdate()
                    .getResult();
            con.commit();
        }

        return res;
    }


}
