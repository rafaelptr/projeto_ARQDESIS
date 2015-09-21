package model;



public class Usuario {
	
	private int id;
	private String usuario;
	private String senha;
	private String perfil;

	public Usuario(){
		this.usuario = "";
		this.senha = "";
		this.perfil = "";
	}
	public Usuario(String usuario,String senha,String perfil){
		this.setSenha(senha);
		this.setPerfil(perfil);
		this.setUsuario(usuario);
	}
	public Usuario(String usuario,String senha){
		this.setSenha(senha);
		this.setUsuario(usuario);
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return this.id;
	}
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getPerfil() {
		return this.perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	
}

