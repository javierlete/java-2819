package iparlendar.controladores;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import iparlendar.accesodatos.CitaDao;
import iparlendar.accesodatos.UsuarioDao;
import iparlendar.modelos.Cita;
import iparlendar.modelos.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");

		Cita cita;

		if (sId != null) {
			Long id = Long.parseLong(sId);

			cita = CitaDao.obtenerPorId(id);

		} else {
			cita = new Cita(0L, "", LocalDateTime.now(), LocalDateTime.now(), "", "",
					new Usuario(null, null, null, null, null, null));
		}

		request.setAttribute("cita", cita);

		ArrayList<Usuario> usuarios = UsuarioDao.obtenerTodos();

		request.setAttribute("usuarios", usuarios);
		request.getRequestDispatcher("/WEB-INF/vistas/formulario.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sId = request.getParameter("id");
		String asunto = request.getParameter("asunto");
		String sInicio = request.getParameter("inicio");
		String sFin = request.getParameter("fin");
		String prioridad = request.getParameter("prioridad");
		String sUsuarioId = request.getParameter("usuario");
		String descripcion = request.getParameter("descripcion");

		Long id = Long.parseLong(sId);
		LocalDateTime inicio = LocalDateTime.parse(sInicio);
		LocalDateTime fin = LocalDateTime.parse(sFin);
		Long usuarioId = Long.parseLong(sUsuarioId);

		Usuario usuario = new Usuario(usuarioId, null, null, null, null, null);

		Cita cita = new Cita(id, asunto, inicio, fin, prioridad, descripcion, usuario);

		if(id == 0) {
			CitaDao.insertar(cita);
		} else {
			CitaDao.modificar(cita);
		}
		

		response.sendRedirect("citas");
	}
}
