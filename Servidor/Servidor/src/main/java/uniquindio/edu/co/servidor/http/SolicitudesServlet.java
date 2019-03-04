/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniquindio.edu.co.servidor.http;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import uniquindio.edu.co.controllers.SolicitudesController;

public class SolicitudesServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String res = "903";

        System.out.println("[Solicitudes] : Parametros =  " + request.getParameterNames());

        String usuario = request.getParameter("usr");
        String clave = request.getParameter("pass");

        SolicitudesController controller = new SolicitudesController();

        if ("/enviarsolicitud".equals(request.getRequestURI())) {
            res = controller.insertarSolicitud(request.getParameter("de"), request.getParameter("para"));
        }

        if ("/aceptarsolicitud".equals(request.getRequestURI())) {
            res = controller.actualizarSolicitud(request.getParameter("id"), 2, "602");
        }

        if ("/rechazarsolicitud".equals(request.getRequestURI())) {
            res = controller.actualizarSolicitud(request.getParameter("id"), 3, "603");
        }

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(res);
    }
}
