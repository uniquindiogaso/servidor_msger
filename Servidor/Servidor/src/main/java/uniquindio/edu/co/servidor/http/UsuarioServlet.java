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
import uniquindio.edu.co.bd.models.Usuario;
import uniquindio.edu.co.controllers.UsuarioController;

public class UsuarioServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("end-point = " + request.getContextPath());
        System.out.println("UsuarioServlet Parametro recibido = " + request.getParameter("usr"));
        System.out.println("UsuarioServlet Parametro recibido = " + request.getParameter("pass"));

        String res = "-2";

        UsuarioController controller = new UsuarioController();

        Usuario usuario = new Usuario();
        usuario.setUsr(request.getParameter("usr"));
        usuario.setPass(request.getParameter("pass"));
        usuario.setNombres(request.getParameter("nombres"));
        usuario.setApellidos(request.getParameter("apellidos"));
        usuario.setEstado(request.getParameter("estado"));
        usuario.setBloqueado(Boolean.getBoolean(request.getParameter("bloqueado")));
        usuario.setEmail(request.getParameter("email"));

        if ("usuariocrear".equals(request.getContextPath())) {
            res = controller.insertarUsuario(usuario);
        }

        if ("usuariomodificar".equals(request.getContextPath())) {
            res = controller.actualizarUsuario(usuario);
        }

        response.setContentType("text/html;charset=UTF-8");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().println(res);
    }
}