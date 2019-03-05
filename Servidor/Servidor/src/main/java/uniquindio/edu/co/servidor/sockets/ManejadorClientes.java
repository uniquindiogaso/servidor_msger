package uniquindio.edu.co.servidor.sockets;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gusta
 */
public class ManejadorClientes implements Runnable {

    Socket s;
    Scanner consola = new Scanner(System.in);
    final BufferedReader entradaDeCliente;
    final DataOutputStream salidaACliente;

    private String name;
    private String clienteId;
    boolean estaAutenticado;

    private HiloListaUsuarios listaUsuarios;
    private HiloSolicitudesAmistad solicitudesAmistad;

    
    private ServerChat serverChat;
    // constructor 
    public ManejadorClientes(Socket s, String name,
            BufferedReader dis, DataOutputStream dos, ServerChat ss) {
        this.entradaDeCliente = dis;
        this.salidaACliente = dos;
        this.name = name;
        this.s = s;
        this.estaAutenticado = true;
        System.out.println("manejador clientes 2");
        listaUsuarios = new HiloListaUsuarios(ss);
        solicitudesAmistad = new HiloSolicitudesAmistad(ss);
       
        
        this.serverChat = ss;

    }

    public void enviarMensaje(String msj) {
        try {
            salidaACliente.writeBytes(msj + "\n");
        } catch (IOException ex) {
            Logger.getLogger(ManejadorClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {

        String mensaje;
        while (true) {
            try {
                // receive the string 
                mensaje = entradaDeCliente.readLine();
                System.out.println("mensaje***** = |" + mensaje + "|");
                if (!mensaje.isEmpty()) {

                    // DATA ACTUAL "#MSJ||FQLSHP||c0||c2||Hola :)"
                    StringTokenizer st = new StringTokenizer(mensaje, Constantes._SEPARADOR);
                    String accion = st.nextToken();
                    String token = st.nextToken();
                    String origen = st.nextToken();
                    String destino = st.nextToken();

                    //TODO: Orgizar para quitar de las listas de usuarios
                    if (accion.equals("#DESCONECTAR") && destino.equals("s3rv1d0r")) {
                        for (ManejadorClientes mc : ServerChat.clientesHandle) {

                        }

                        int idClienteVector = -1;
                        for (int i = 0; i < ServerChat.clientesHandle.size(); i++) {
                            if (ServerChat.clientesHandle.get(i).clienteId.equals(origen)) {
                                idClienteVector = i;
                                break;
                            }
                        }

                        if (idClienteVector != -1) {
                            this.estaAutenticado = false;
                            this.s.close();
                            break;
                            
                            //serverChat.cerrarSesion(idClienteVector);
                            
                        }

                    }

                    //TODO:
                    //1. Comprobar si token es valido para origen
                    //2. Noticiar a origen si no esta autorizado
                    //3. si no es valido: return;
                    if (accion.equals("#HOLA") && destino.equals("s3rv1d0r")) {
                        //id = origen
                        String saludador = "c" + (ServerChat.clientesHandle.size() - 1);
                        for (ManejadorClientes mc : ServerChat.clientesHandle) {
                            if (mc.name.equals(saludador)) {
                                mc.clienteId = origen;
                                break;
                            }
                        }

                    }

                    for (ManejadorClientes mc : ServerChat.clientesHandle) {
                        System.out.println("usuarioId = " + mc.clienteId + " | destino " + destino);
                        //Si encuentra el cliente ... entonces conectar                        
                        if (mc.clienteId.equals(destino) && mc.estaAutenticado == true) {
                            //mc.salidaACliente.writeBytes(mensaje);                             
                            mc.salidaACliente.writeBytes(mensaje + "\n");
                            break;
                        }

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Ups... algo no salio bien ...");
            }

        }
        try {
            // closing resources 
            this.entradaDeCliente.close();
            this.salidaACliente.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public HiloListaUsuarios getListaUsuarios() {
        return listaUsuarios;
    }

    public HiloSolicitudesAmistad getSolicitudesAmistad() {
        return solicitudesAmistad;
    }

}
