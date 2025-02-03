package iparlendar.controladores;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import iparlendar.accesodatos.CitaDao;

@WebServlet("/citas")
public class CitasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("citas", CitaDao.obtenerTodas());
		
		request.getRequestDispatcher("/WEB-INF/vistas/citas.jsp").forward(request, response);
	}
}
