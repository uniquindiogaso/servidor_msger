package uniquindio.edu.co.bd.models;

/**
 *
 * @author gusta
 */
public class Amistad {

    private int usuario;
    private Usuario amigo;

    public Amistad() {
    }

    public Amistad(int usuario, Usuario amigo) {
        this.usuario = usuario;
        this.amigo = amigo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public Usuario getAmigo() {
        return amigo;
    }

    public void setAmigo(Usuario amigo) {
        this.amigo = amigo;
    }

}
