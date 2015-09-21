package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TreeSet;

import banco.MySql;
import model.Aeronave;

public class AeronaveDAO extends MySql{
	public AeronaveDAO() {
		super();
	}

	public boolean incluir(Aeronave aeronave){
		boolean incluiu = false;
		String sqlInsert = " INSERT INTO aeronave( "
				+  " codigo, "
				+ " nome, "
				+ " total_assentos, "
				+ " qtd_assentos_A, "
				+ " qtd_assentos_B, "
				+ " qtd_assentos_C, "
				+ " qtd_assentos_verticais, "
				+ " qtd_assentos_horizontais ) VALUES (?, ? , ? , ? , ?, ? , ? , ?) ";
		PreparedStatement statement = null;
		try
		{
			statement = (PreparedStatement) conn.prepareStatement(sqlInsert);
			statement.setString(1, aeronave.getCodigo());
			statement.setString(2, aeronave.getNome());
			statement.setInt(3, aeronave.getTotal_assentos());
			statement.setInt(4, aeronave.getQtd_assentos_A());
			statement.setInt(5, aeronave.getQtd_assentos_B());
			statement.setInt(6, aeronave.getQtd_assentos_C());
			statement.setInt(7, aeronave.getQtd_assentos_verticais());
			statement.setInt(8, aeronave.getQtd_assentos_horizontais());
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
	
	public boolean alterar(Aeronave aeronave){
		return false;
	}
	public Aeronave buscar(Aeronave aeronave){
		String sqlSelect = 
				" SELECT * FROM aeronave WHERE "
				+ " id = '"+aeronave.getId()+"' "
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
	                	 aeronave.setId(resultSet.getInt("id"));
	                	 aeronave.setCodigo(resultSet.getString("codigo"));
	                	 aeronave.setNome(resultSet.getString("nome"));
	                	 aeronave.setQtd_assentos_A(resultSet.getInt("qtd_assentos_A"));
	                	 aeronave.setQtd_assentos_B(resultSet.getInt("qtd_assentos_B"));
	                	 aeronave.setQtd_assentos_C(resultSet.getInt("qtd_assentos_C"));
	                	 aeronave.setQtd_assentos_horizontais(resultSet.getInt("qtd_assentos_horizontais"));
	                	 aeronave.setQtd_assentos_verticais(resultSet.getInt("qtd_assentos_verticais"));
	                  }
	            } catch (SQLException e) {
	                  e.printStackTrace();
	            }
	            try {
	            	resultSet.close();
	            } catch (SQLException e) {
	                  e.printStackTrace();
	            }

		return aeronave;
	}

	
	public ArrayList<Aeronave> listagem(){
		ArrayList<Aeronave> lista = new ArrayList<Aeronave>();
		Aeronave aeronave = null;
		String sqlSelect = 
				" SELECT * FROM aeronave";
		
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
	                	 aeronave = new Aeronave();
	                	 aeronave.setId(resultSet.getInt("id"));
	                	 aeronave.setCodigo(resultSet.getString("codigo"));
	                	 aeronave.setNome(resultSet.getString("nome"));
	                	 aeronave.setQtd_assentos_A(resultSet.getInt("qtd_assentos_A"));
	                	 aeronave.setQtd_assentos_B(resultSet.getInt("qtd_assentos_B"));
	                	 aeronave.setQtd_assentos_C(resultSet.getInt("qtd_assentos_C"));
	                	 aeronave.setQtd_assentos_horizontais(resultSet.getInt("qtd_assentos_horizontais"));
	                	 aeronave.setQtd_assentos_verticais(resultSet.getInt("qtd_assentos_verticais"));
	                	 lista.add(aeronave);
	                  }
	            } catch (SQLException e) {
	                  e.printStackTrace();
	            }
	            try {
	            	resultSet.close();
	            } catch (SQLException e) {
	                  e.printStackTrace();
	            }

		return lista;
	}
	
}
