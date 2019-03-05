/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.servidor.http;

import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.util.thread.QueuedThreadPool;

public class JettyServer {

    private Server server;

    public void start() throws Exception {

        int maxThreads = 100;
        int minThreads = 10;
        int idleTimeout = 120;

        QueuedThreadPool threadPool = new QueuedThreadPool(maxThreads, minThreads, idleTimeout);

        server = new Server(threadPool);
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(8000);
        server.setConnectors(new Connector[] { connector });

        ServletHandler servletHandler = new ServletHandler();
        server.setHandler(servletHandler);
        
        System.out.println("[HTTP]Servidor escuchando por 8000");

        servletHandler.addServletWithMapping(LoginServlet.class, "/status");
        servletHandler.addServletWithMapping(UsuarioServlet.class, "/usuariocrear");
        servletHandler.addServletWithMapping(UsuarioServlet.class, "/usuariomodificar");
        servletHandler.addServletWithMapping(SolicitudesServlet.class, "/enviarsolicitud");
        servletHandler.addServletWithMapping(SolicitudesServlet.class, "/aceptarsolicitud");
        servletHandler.addServletWithMapping(SolicitudesServlet.class, "/rechazarsolicitud");

        server.start();

    }

    void stop() throws Exception {
        server.stop();
    }
}