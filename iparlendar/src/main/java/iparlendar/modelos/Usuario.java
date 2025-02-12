package iparlendar.modelos;

import java.util.ArrayList;

public class Usuario {
	private Long id;
	private String nombre;
	private String email;
	private String password;
	private String rol;
	private ArrayList<Cita> citas = new ArrayList<Cita>();

	public Usuario(Long id, String nombre, String email, String password, String rol, ArrayList<Cita> citas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
		this.password = password;
		this.rol = rol;
		this.citas = citas;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public ArrayList<Cita> getCitas() {
		return citas;
	}

	public void setCitas(ArrayList<Cita> citas) {
		this.citas = citas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", email=" + email + ", password=" + password + ", rol="
				+ rol + ", citas=" + citas + "]";
	}

}
