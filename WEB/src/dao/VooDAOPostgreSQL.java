package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import to.VooTO;
import to.ListagemVooTO;
import factory.ConnFactory;
import model.Aeronave;
import model.Aeroporto;

public class VooDAOPostgreSQL extends VooDAO{

	@Override
	public void desconectar(Connection conn) throws SQLException {
		conn.close();
	}

	@Override
	public VooTO incluir(VooTO to){
		String inclusao = " INSERT INTO voo( "
				+  " codigo, "
				+ " nome, "
				+ " qtdAssentosA, "
				+" qtdAssentosB, "
				+ "qtdAssentosC, "
				+ "qtdAssentosHorizontais, "
				+ "qtdAssentosVerticais, "
				+ ") VALUES (?, ? , ?, ?, ? ,? ,?) ";
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(inclusao);
			//configurar parametros
			pst.setString(1,to.codigo);
			pst.setString(2,to.nome);
			pst.execute();
			//funcao do MySQL para pegar o ultimo id inserido nesta secao"
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			String selecao = "select LAST_INSERT_ID()";
			pst = conn.prepareStatement(selecao);
			rs = pst.executeQuery();
			if(rs.next()){
				to.id = rs.getInt(1);
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

	@Override
	public boolean remover(int to){
		String alteracao = "delete from voo where id=?";
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			//configurar parametros
			pst.setInt(1, to);
			//fim configurar parametros
			pst.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	@Override
	public VooTO alterar(VooTO to){
		String alteracao = " update voo set( "
				+  " codigo, "
				+ " nome, "
				+ " qtdAssentosA, "
				+" qtdAssentosB, "
				+ "qtdAssentosC, "
				+ "qtdAssentosHorizontais, "
				+ "qtdAssentosVerticais, "
				+ ") VALUES (?, ? , ?, ?, ? ,? ,?) where id = ? ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setString(1,to.codigo);
			pst.setString(2,to.nome);
			pst.setInt(8,to.id);
			to = null;
			rs = pst.executeQuery();
			if(rs.next()){
				to = new VooTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
				to.nome = rs.getString("nome");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

	@Override
	public VooTO buscarId(int id) {
		String alteracao = " SELECT * FROM voo "
				+ "where id = ? ";
		VooTO to = null;
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			pst.setInt(1,id);
			rs = pst.executeQuery();
			if(rs.next()){
				to = new VooTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
				to.nome = rs.getString("nome");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return to;
	}

	@Override
	public ListagemVooTO buscar(VooTO toFiltro) {
		ListagemVooTO listagemTO = new ListagemVooTO();
		String search = " SELECT * FROM voo WHERE " + this.prepareSearch(toFiltro);
				
		
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(search);
			rs = pst.executeQuery();
			if(rs.next()){
				VooTO to = new VooTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
				to.nome = rs.getString("nome");
				listagemTO.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listagemTO;
	}

	private String prepareSearch(VooTO toFiltro) {
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public ListagemVooTO listagem() {
		ListagemVooTO listagemTO = new ListagemVooTO();
		String alteracao = " SELECT * FROM voo ";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			rs = pst.executeQuery();
			if(rs.next()){
				VooTO to = new VooTO();
				to.id = rs.getInt("id");
				to.codigo = rs.getString("codigo");
				to.nome = rs.getString("nome");
				listagemTO.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listagemTO;
	}
	public ListagemVooTO listagem(String origem , String destino) {
		ListagemVooTO listagemTO = new ListagemVooTO();
		String alteracao = " SELECT * FROM voo WHERE aeroportoOrigemId='"+origem+"' and  aeroportoDestinoId='"+destino+"'";

		Aeronave aeronave = new Aeronave();
		Aeroporto aeroporto = new Aeroporto();
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			conn = ConnFactory.conectar();
			pst = conn.prepareStatement(alteracao);
			rs = pst.executeQuery();
			while(rs.next()){
				VooTO to = new VooTO();
				to.id = rs.getInt("id");
				to.nome = rs.getString("nome");
				to.codigo = rs.getString("codigo");
				to.aeroportoOrigemId = rs.getInt("aeroportoOrigemId");
				to.aeroportoOrigem = aeroporto.buscarId(to.aeroportoOrigemId);
				to.aeroportoDestinoId = rs.getInt("aeroportoDestinoId");
				to.aeroportoDestino= aeroporto.buscarId(to.aeroportoDestinoId);
				to.aeronaveId = rs.getInt("aeronaveId");
				to.aeronave = aeronave.buscarId(to.aeronaveId);
				to.preco = rs.getDouble("preco");
				to.data = new java.util.Date (rs.getDate("data").getTime());
				listagemTO.add(to);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pst != null){
				try {
					pst.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn != null){
				try {
					desconectar(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listagemTO;
	}

}
