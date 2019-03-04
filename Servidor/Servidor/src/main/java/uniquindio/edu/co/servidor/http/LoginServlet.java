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
import uniquindio.edu.co.controllers.UsuarioController;

public class LoginServlet extends HttpServlet {

    /**
     * protected void doGet(HttpServletRequest request, HttpServletResponse
     * response) throws ServletException, IOException {
     * System.out.println("HttpServletRequest : " + request);
     * System.out.println("request.getMethod() : " + request.getMethod());
     * System.out.println("request.getQueryString() " +
     * request.getQueryString()); response.setContentType("application/json");
     * response.setStatus(HttpServletResponse.SC_OK);
     * response.getWriter().println("{ \"status\": \"ok\"}");
    }
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Parametro recibido = " + request.getParameter("usr"));
        System.out.println("Parametro recibido = " + request.getParameter("pass"));

        String usuario = request.getParameter("usr");
        String clave = request.getParameter("pass");

        UsuarioController controller = new UsuarioController();
        String res = controller.comprobarLogin(usuario, clave);
        
        System.out.println("Respuesta loginController "  + res);

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(res);
    }
}
