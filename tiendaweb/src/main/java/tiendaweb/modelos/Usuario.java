package tiendaweb.modelos;

public class Usuario {
	private Long id;
	private String email;
	private String password;
	private String rol;

	public Usuario(Long id, String email, String password, String rol) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.rol = rol;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", rol=" + rol + "]";
	}

}
