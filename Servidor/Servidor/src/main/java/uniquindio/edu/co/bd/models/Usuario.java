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
public class Usuario {

    private int id;
    private String usr;
    private String pass;
    private String nombres;
    private String apellidos;
    private String estado;
    private boolean bloqueado;
    private String email;

    public Usuario() {
    }

    public Usuario(int id, String usr, String pass, String nombres, String apellidos, String estado, boolean bloqueado, String email) {
        this.id = id;
        this.usr = usr;
        this.pass = pass;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estado = estado;
        this.bloqueado = bloqueado;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usr=" + usr + ", pass=" + pass + ", nombres=" + nombres + ", apellidos=" + apellidos + ", estado=" + estado + ", bloqueado=" + bloqueado + ", email=" + email + '}';
    }

    
    
}
