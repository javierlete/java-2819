package tiendaweb.controladores;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("vistas/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Recoger información de la petición
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
//		Convertir la información recibida
//		Crear objetos en base a la información recibida
//		Ejecutar lógica de negocio
		if("javier@email.net".equals(email) && "contra".equals(password)) {
			HttpSession session = request.getSession();
			
//			Preparar los objetos para la siguienteS vistaS
			session.setAttribute("email", email);
			session.setAttribute("ip", request.getRemoteAddr());
//			Saltar a la siguiente vista
			response.sendRedirect("listado");
		} else {
			response.sendRedirect("login");
		}
		
	}

}
