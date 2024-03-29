package br.com.projetoMvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projetoMvc.model.Produto;
import br.com.projetoMvc.util.ConnectionFactory;

public class ProdutoDAOImpl implements GenericDAO {
	
	private Connection conn; 
	
	public ProdutoDAOImpl() throws Exception { 
		try { 
			this.conn=ConnectionFactory.getConnection();
			System.out.println("Conectado com sucesso!");
			
		} catch (Exception ex) {
			throw new Exception (ex.getMessage()); 
		}
	}

	@Override
	public List<Object> listarTodos() {
		
		List <Object> lista = new ArrayList<Object>(); //Lista que vai retornar 
		PreparedStatement stmt =null;  //Objeto criado 
		ResultSet rs = null; //Objeto criado 
		
		String sql = "SELECT * FROM produto ORDER BY descricao"; //Var para armazenar o select que vais er executado no banco 
		
		try { 
			stmt = conn.prepareStatement(sql);  //aqui o objetivo é transformar o sql em algo que relamwente vai ser lido pelo banco, uma sql executável, é isso que o prepareStatemet faz
			rs = stmt.executeQuery(); //esse aqui é o que vai lá no banco e realmente executa, ele vais er armazenado aqui no rs 
			while(rs.next()) { //enquanto houver linha nessa tabela ele vai pulando 
				Produto produto = new Produto(); //Crio um novo produto lá da classe produto 
				produto.setId(rs.getInt("id"));
				produto.setDescricao(rs.getString("descricao"));
				lista.add(produto);
			}
			
		} catch (SQLException ex) {
			System.out.println("Problemas na DAO ao listar produto! Erro:" + ex.getMessage());
			ex.printStackTrace();
		} finally { 
			try { 
				ConnectionFactory.closeConnection(conn, stmt, rs);
			} catch (Exception ex) { 
				System.out.println("Problemas ao fechar conexão! Erro:" + ex.getMessage());
			}
		}
		
		return lista; 
	}
		

	@Override
	public Object listarPorId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean cadastrar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean alterar(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(int id) {
		// TODO Auto-generated method stub
		
	}

}
