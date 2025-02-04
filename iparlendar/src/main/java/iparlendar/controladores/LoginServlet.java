package iparlendar.controladores;

import java.io.IOException;

import iparlendar.accesodatos.UsuarioDao;
import iparlendar.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("error", "");
		
		request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Usuario usuario = UsuarioDao.obtenerPorEmail(email);
		
		if(usuario != null && usuario.getPassword().equals(password)) {
			request.getSession().setAttribute("usuario", usuario);
			
			response.sendRedirect("citas");
		} else {
			request.setAttribute("error", "Usuario o contraseña no válidos");
			
			request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
		}
	}
}
