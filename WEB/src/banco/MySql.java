package banco;

import java.sql.*;

import com.mysql.jdbc.Connection;

/**
 * Classe responsável pela conexão com banco de dados MySQL
 */
public class MySql {

	/**
	 * Conn
	 */
	protected Connection conn = null;
	
	/**
	 * Banco que sera conectado
	 */
	private String banco = "passagens_aereas";
	/**
	 * Usuario do banco
	 */
	private String usuario = "root";
	/**
	 * Senha do usuario do banco
	 */
	private String senha = "";
	/**
	 * Url do banco
	 */
	private String url = "localhost:3306";

	
	public static final String STATUS_CONECTADO = "Conectado";
	public static final String STATUS_DESCONECTADO = "Desconectado";
	
	public static String StatusConexao = "";
	
	public static String StatusConexaoErro = "";
	// -----------------------------------------------------------
	// Carrega driver JDBC
	//
	/**
	 * Starta Classe (Construtor)
	 */
	public MySql() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			StatusConexaoErro = e.getMessage() + "  - \n  -  " + e.getStackTrace();
			throw new RuntimeException(e);
		}
		if(conectar()){
			StatusConexao = STATUS_CONECTADO;
		}else{
			StatusConexao = STATUS_DESCONECTADO;
		}
	}

	// -----------------------------------------------------------
	// Obtém conexão com o banco de dados
	/**
	 * Pega a o conexao do banco
	 * 
	 * @return
	 * @throws SQLException
	 */
	public boolean conectar(){
		if(conn != null){
			desconectar();
		}
		try {
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://" + this.url + "/"
					+ this.banco + "", this.usuario, this.senha);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			StatusConexaoErro = e.getMessage() + "  - \n  -  " + e.getStackTrace();
			return false;
		}
	}
	/**
	 * Desconectar
	 * @return
	 * @throws SQLException
	 */
	public boolean desconectar() {
		if(conn != null){
			try{
				conn.close();
				return true;
			}catch(SQLException e){
				e.printStackTrace();
				StatusConexaoErro = e.getMessage() + "  - \n  -  " + e.getStackTrace();
				return false;
			}
		}
		return true;
	}

	/**
	 * Retorna o banco utilizado
	 * 
	 * @return banco
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * Seta o banco a ser utilizado
	 * 
	 * @param banco
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * Pega o usuario que sera autenticado
	 * 
	 * @return
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Seta o usuario de autenticacao
	 * 
	 * @param usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Pega a senha que sera autenticada
	 * 
	 * @return
	 */
	public String getSenha() {
		return senha;
	}

	/**
	 * Seta a senha de autenticacao
	 * 
	 * @param senha
	 */
	public void setSenha(String senha) {
		this.senha = senha;
	}

	/**
	 * Pega Url do bando
	 * 
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Seta a url do banco
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}