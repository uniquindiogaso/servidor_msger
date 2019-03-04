/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.bd.models;

/**
 *
 * @author gusta
 */
public class Solicitud {

    private int id;
    private int usuariosolicitaId;
    private int usuariosolicitadoId;
    private int estado;

    public Solicitud() {
    }

    public Solicitud(int id) {
        this.id = id;
    }

    public Solicitud(int id, int estado) {
        this.id = id;
        this.estado = estado;
    }

    public Solicitud(int id, int usuariosolicitaId, int usuariosolicitadoId, int estado) {
        this.id = id;
        this.usuariosolicitaId = usuariosolicitaId;
        this.usuariosolicitadoId = usuariosolicitadoId;
        this.estado = estado;
    }

    public Solicitud(int usuariosolicitaId, int usuariosolicitadoId, int estado) {
        this.usuariosolicitaId = usuariosolicitaId;
        this.usuariosolicitadoId = usuariosolicitadoId;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuariosolicitaId() {
        return usuariosolicitaId;
    }

    public void setUsuariosolicitaId(int usuariosolicitaId) {
        this.usuariosolicitaId = usuariosolicitaId;
    }

    public int getUsuariosolicitadoId() {
        return usuariosolicitadoId;
    }

    public void setUsuariosolicitadoId(int usuariosolicitadoId) {
        this.usuariosolicitadoId = usuariosolicitadoId;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
