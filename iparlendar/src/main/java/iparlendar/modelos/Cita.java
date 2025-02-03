package iparlendar.modelos;

import java.time.LocalDateTime;

public class Cita {
	private Long id;
	private String asunto;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	private String prioridad;
	private String descripcion;
	private Usuario usuario;

	public Cita(Long id, String asunto, LocalDateTime inicio, LocalDateTime fin, String prioridad, String descripcion,
			Usuario usuario) {
		super();
		this.id = id;
		this.asunto = asunto;
		this.inicio = inicio;
		this.fin = fin;
		this.prioridad = prioridad;
		this.descripcion = descripcion;
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public LocalDateTime getInicio() {
		return inicio;
	}

	public void setInicio(LocalDateTime inicio) {
		this.inicio = inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public void setFin(LocalDateTime fin) {
		this.fin = fin;
	}

	public String getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Cita [id=" + id + ", asunto=" + asunto + ", inicio=" + inicio + ", fin=" + fin + ", prioridad="
				+ prioridad + ", descripcion=" + descripcion + ", usuario=" + usuario + "]";
	}

}
