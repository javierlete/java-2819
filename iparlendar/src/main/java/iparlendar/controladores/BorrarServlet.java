package iparlendar.controladores;

import java.io.IOException;

import iparlendar.accesodatos.CitaDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/borrar")
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sId=request.getParameter("id");
		
		Long id = Long.parseLong(sId);
		
		CitaDao.borrar(id);
		
		response.sendRedirect("citas");
	}
}
