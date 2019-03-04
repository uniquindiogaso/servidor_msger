/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.bd.pojo;

import java.util.List;
import org.sql2o.Connection;
import uniquindio.edu.co.bd.DbHelper;
import uniquindio.edu.co.bd.models.Solicitud;
import uniquindio.edu.co.bd.models.Usuario;

/**
 *
 * @author gusta
 */
public class SolicitudesPOJO {

    public List<Solicitud> solicitudes(int usuarioSolicitadoId) {
        try (Connection con = DbHelper.getSql2o().open()) {
            final String query
                    = "SELECT id, usuariosolicita_id"
                    + "FROM solicitudes WHERE usuariosolicitado_id = :usuariosolicitado_id AND estado = 1";

            return con.createQuery(query)
                    .addParameter("usuariosolicitado_id", usuarioSolicitadoId)
                    .executeAndFetch(Solicitud.class);
        }
    }

    public int insertar(Solicitud solicitud) {
        int res = -1;
        final String insertQuery
                = "INSERT INTO solicitudes (usuariosolicita_id, usuariosolicitado_id, estado) "
                + "VALUES (:usuariosolicita_id, :usuariosolicitado_id, :estado)";

        try (Connection con = DbHelper.getSql2o().beginTransaction()) {
            res = con.createQuery(insertQuery, true)
                    .addParameter("usuariosolicitado_id", solicitud.getUsuariosolicitadoId())
                    .addParameter("usuariosolicita_id", solicitud.getUsuariosolicitaId())
                    .addParameter("estado", 1)
                    .executeUpdate()
                    .getResult();
            con.commit();
        }

        return res;
    }

    public int actualizar(Solicitud s) {
        int res = -1;

        final String updateQuery
                = "UPDATE solicitudes SET :estado WHERE id = :id";

        try (Connection con = DbHelper.getSql2o().open()) {
            res = con.createQuery(updateQuery, true)
                    .bind(s)
                    .executeUpdate()
                    .getResult();
        }

        return res;
    }
    
    
    public Solicitud obtenerSolicitud(int id) {        
        try (Connection con = DbHelper.getSql2o().open()) {
            final String query
                    = "SELECT id,  usuariosolicita_id , usuariosolicitado_id , estado"
                    + "FROM solicitudes WHERE id = :id";

            return con.createQuery(query)
                    .addParameter("id", id)
                    .executeAndFetchFirst(Solicitud.class);
        }
    }

}
