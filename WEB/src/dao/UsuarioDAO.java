package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import banco.MySql;
import model.Usuario;

public class UsuarioDAO extends MySql{
	public UsuarioDAO() {
		super();
	}

	public boolean incluir(Usuario usuario){
		boolean incluiu = false;
		String sqlInsert = " INSERT INTO usuario( "
				+  " usuario, "
				+ " senha, "
				+ " perfil ) VALUES (?, ? , ?) ";
		PreparedStatement statement = null;
		try
		{
			statement = (PreparedStatement) conn.prepareStatement(sqlInsert);
			statement.setString(1, usuario.getUsuario());
			statement.setString(2, usuario.getSenha());
			statement.setString(3, usuario.getPerfil());
			statement.execute();
			incluiu = true;
		}catch (Exception e){
			e.printStackTrace();
			try{
				conn.rollback();
			}catch (SQLException e1){
				System.out.print(e1.getStackTrace());
			}	
		}finally{
			if (statement != null){
				try{
					statement.close();
				}catch (SQLException e1){
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return incluiu;

	}
	
	public boolean alterar(Usuario usuario){
		return false;
	}
	public Usuario buscar(Usuario usuario){
		String sqlSelect = 
				" SELECT * FROM usuario WHERE "
				+ " usuario = '"+usuario.getUsuario()+"' and "
				+ " senha = '"+usuario.getSenha()+"' "
				+ "";	
		
	  	Statement s = null;
	       try {
                  s = (Statement) conn.createStatement();
            } catch (SQLException e) {
                  e.printStackTrace();
            }
            ResultSet resultSet = null;
            try {
            	resultSet = s.executeQuery(sqlSelect);
            } catch (SQLException e) {
                  e.printStackTrace();
            }
            try {
	                  while (resultSet.next()){
	                	 usuario.setId(resultSet.getInt("id"));
	                	 usuario.setUsuario(resultSet.getString("usuario"));
	                	 usuario.setPerfil(resultSet.getString("perfil"));
	                  }
	            } catch (SQLException e) {
	                  // TODO Auto-generated catch block
	                  e.printStackTrace();
	            }
	            try {
	            	resultSet.close();
	            } catch (SQLException e) {
	                  // TODO Auto-generated catch block
	                  e.printStackTrace();
	            }

		return usuario;
	}
	
	
}
