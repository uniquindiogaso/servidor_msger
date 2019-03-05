package uniquindio.edu.co.controllers;

import java.util.List;
import uniquindio.edu.co.bd.models.Amistad;
import uniquindio.edu.co.bd.models.Solicitud;
import uniquindio.edu.co.bd.models.Usuario;
import uniquindio.edu.co.bd.pojo.AmistadPOJO;
import uniquindio.edu.co.bd.pojo.SolicitudesPOJO;
import uniquindio.edu.co.bd.pojo.UsuarioPOJO;

/**
 *
 * @author gusta
 */
public class SolicitudesController {

    private SolicitudesPOJO pojo;
    private UsuarioPOJO pojoUsuario;
    private AmistadPOJO pojoAmistad;

    public SolicitudesController() {
        pojo = new SolicitudesPOJO();
        pojoAmistad = new AmistadPOJO();
        pojoUsuario = new UsuarioPOJO();

    }

    public List<Solicitud> obtenerSolicitudes(int usuarioId) {
        return pojo.solicitudes(usuarioId);
    }

    public String insertarSolicitud(String de, String para) {

        String res = "903";

        int usuariosolicitaId = Integer.valueOf(de);
        int usuariosolicitadoId = Integer.valueOf(para);

        Usuario usuarioSolicita = pojoUsuario.obtenerUsuario(usuariosolicitaId);
        Usuario usuarioSolicitado = pojoUsuario.obtenerUsuario(usuariosolicitadoId);

        if (usuarioSolicita == null || usuarioSolicitado == null) {
            return "804";
        }

        Solicitud s = new Solicitud(usuarioSolicita.getId(), usuarioSolicitado.getId(), 1);

        int estadoSolicitud = pojo.insertar(s);

        if (estadoSolicitud != -1) {
            res = "704";
        }

        return res;

    }

    public String actualizarSolicitud(String id, int estado, String codigoRespues) {
        pojoUsuario = new UsuarioPOJO();
        String res = "905";

        Solicitud s = pojo.obtenerSolicitud(Integer.valueOf(id));

        if (s == null) {
            return "904";
        }

        s.setEstado(estado);
        int resultadoActualizacion = pojo.actualizar(s);
        if (resultadoActualizacion != -1) {
            res = codigoRespues;
        }

        //Si usuario acepta solicitud ... se debe actualizar la lista de amigos de ambos.
        if (s.getEstado() == 2) {
            Usuario de = pojoUsuario.obtenerUsuario(s.getUsuariosolicitaId());
            Usuario para = pojoUsuario.obtenerUsuario(s.getUsuariosolicitadoId());
            pojoAmistad.insertar(new Amistad(de.getId(), para));
            pojoAmistad.insertar(new Amistad(para.getId(), de));
        }

        return res;
    }

    
    public List<Amistad> amigosUsuario(int usuarioId){
        return pojoAmistad.amigos(usuarioId);
    }
}
