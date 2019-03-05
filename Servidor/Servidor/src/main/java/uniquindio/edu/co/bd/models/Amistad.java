package uniquindio.edu.co.bd.models;

/**
 *
 * @author gusta
 */
public class Amistad {

    private int usuario;
    private Usuario amigo;
    private int amigo_Id;

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

    public int getAmigo_Id() {
        return amigo_Id;
    }

    public void setAmigo_Id(int amigo_Id) {
        this.amigo_Id = amigo_Id;
    }
    
    

    @Override
    public String toString() {
        return "Amistad{" + "usuario=" + usuario + ", amigo=" + amigo_Id + '}';
    }
    
    

}
