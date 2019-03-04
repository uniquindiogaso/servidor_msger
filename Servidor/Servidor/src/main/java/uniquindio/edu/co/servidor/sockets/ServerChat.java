package uniquindio.edu.co.servidor.sockets;

// Java implementation of  ServerChat side 
// It contains two classes : ServerChat and ManejadorClientes 
// Save file as ServerChat.java 

import java.io.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

// ServerChat class 
/**
 * https://www.geeksforgeeks.org/multi-threaded-chat-application-set-1/
 * https://www.geeksforgeeks.org/multi-threaded-chat-application-set-2/
 *
 * @author gusta
 */
public class ServerChat {

    // Estructura de Datos Almacenamiento Usuarios Conectados
    static Vector<ManejadorClientes> clientesHandle = new Vector<>();

    // counter for clients 
    static int i = 0;

    public ServerChat() throws IOException {
        // server is listening on port 1234 
        ServerSocket ss = new ServerSocket(1234);
        
        System.out.println("SERVIDOR[2] UQ ESC 1234");

        Socket s;

        // Escuchar infinitamente las solicitudes de los usuarios
        while (true) {
            // aceptar las conexiones entrantes
            s = ss.accept();

            System.out.println("Nueva Solicitud de conexion Recibida : " + s);

            // Obtener  streams de entradas y salidas
            BufferedReader entradaDeCliente = new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream salidaACliente = new DataOutputStream(s.getOutputStream());

            System.out.println("Creando Handle para Usuario Nuevo ...");

            // Crear nuevo escucha para cliente nuevo
            ManejadorClientes clienteHandle = new ManejadorClientes(s, "c" + i, entradaDeCliente, salidaACliente, this);

            //inicia el hilo que envfia la lista una sola vez para cada usuario               
            //clienteHandle.getListaUsuarios().start();

            //Iniciar hilo de comprobacion de solicitudes de amistad
            //clienteHandle.getSolicitudesAmistad().start();

            // crear hilo para cliente. 
            Thread clienteHilo = new Thread(clienteHandle);

            System.out.println("Adding this client to active client list");

            // agregar clientes a Listado de Cliente
            clientesHandle.add(clienteHandle);

            // Iniciar Hilo Cliente
            clienteHilo.start();

            // incrementable de clientes que han solicitado conexion.             
            i++;

        }
    }

    public static void main(String[] args) {
        try {
            new ServerChat();
        } catch (IOException ex) {
            Logger.getLogger(ServerChat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String listaUsuarios(String usuario) {
        String usuarios = "";
        //TODO ... enviar unicamente usuarios que sean amigos
        for (ManejadorClientes c : clientesHandle) {
            usuarios += c.getName() + "&&";
        }
        return usuarios;
    }

    public void enviarUsuariosConectados() {
        enviarMensajeTodos(Acciones._LISTAUSUARIOS);
    }

    public void enviarSolicitudesAmistad() {
        enviarMensajeTodos(Acciones._SOLICITUDES);
    }

    public void enviarMensajeTodos(String tipo) {
        for (ManejadorClientes c : clientesHandle) {

            String msj = "";

            if (Acciones._LISTAUSUARIOS.equals(tipo)) {
                msj = tipo + "||" + "tokenOK" + "||" + "server" + "||" + c.getName() + "||" + listaUsuarios(c.getName());
            }
            if (Acciones._SOLICITUDES.equals(tipo)) {
                //TODO : Cambiar listaUsuarios por Lista de Solicitudes
                msj = tipo + "||" + "tokenOK" + "||" + "server" + "||" + c.getName() + "||" + listaUsuarios(c.getName());
            }

            c.enviarMensaje(msj);
        }
    }

}
