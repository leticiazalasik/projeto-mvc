package br.com.projetoMvc.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

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
			
			PreparedStatement stmt =null;  //Objeto criado,  usado quando precisamos executar comandos SQL pré-compilados e obter o resultado produzido.
			Produto produto = null; //objeto produto
			ResultSet rs =null; //objeto que representa um conjunto de dados recuperados de uma base de dados após a execução de uma consulta SQL. 
			
			
			String sql = "SELECT * FROM produto WHERE id=" + "(?)"; //Var para armazenar o select que vais er executado no banco 
			
			try { 
				stmt =conn.prepareStatement(sql); //converter string em sql 
			stmt.setInt(1, id); // define o valor do primeiro parâmetro (índice 1) na consulta. O valor é o id fornecido.
			stmt.executeQuery(); // executa a consulta preparada no banco de dados, mas o resultado da execução não está sendo armazenado.
			rs = stmt.executeQuery(); //a consulta preparada é executada novamente e o resultado é armazenado em um objeto do tipo ResultSet chamado rs. O ResultSet contém os resultados da consulta realizada.
			
			if (rs.next()) { //resultado (ou seja, rs.next() retorna true):
	         produto = new Produto(rs.getInt("id"), rs.getString("descricao")); //produto recebe valores das colunas “id” e “descricao” obtidos do ResultSet.
	 		JOptionPane.showMessageDialog(null, "Produto localizado!");

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
			
			return produto; 
		}

	@Override
	public Boolean cadastrar(Object object) {
	Produto produto = (Produto) object; 
	PreparedStatement stmt =null; // Para executar consultas parametrizadas. 
	String sql = "INSERT INTO produto (descricao) " + "VALUES (?)"; // esse ponto de interrogacao será inserido depois e substituido. depois do descricao eu poderia colocar , mais coisas e no ponto de interrogacao mais coisas 
	
	try { 
		stmt =conn.prepareStatement(sql); //atribuído à variável "stmt" um objeto PreparedStatement criado a partir da conexão "conn" e da string "sql". Isso indica que uma consulta parametrizada está sendo preparada para execução no banco de dados.
		stmt.setString(1, produto.getDescricao()); //1 equivale ao primeiro ponto de interrogacao e o pdouto,getDescricao é o que vai ser colocado no lugar do ponto de interrogaçao.  Aqui está sendo definido o valor do primeiro parâmetro da consulta preparada. O método setString está sendo usado para atribuir a descrição do produto (provavelmente obtida do objeto "produto") ao primeiro parâmetro da consulta.
		stmt.execute(); // só executa sem um retorno execute query porque nao precis mostrar resultados de volta 
		return true; 
	} catch (SQLException ex) {
		System.out.println("problemas na DAO ao cadastrar Produto! Erro: " + ex.getMessage());
		ex.printStackTrace();
		return false; //se nao conseguiu cadastrar retorna false 
	} finally { 
		try { 
			ConnectionFactory.closeConnection(conn, stmt);
		} catch (Exception ex) { 
			System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	}

	@Override
	public Boolean alterar(Object object) {
		
		Produto produto = (Produto) object; //primeira coisa que fazemos é converter de objeto genérico para produto 
		PreparedStatement stmt =null;  //Objeto criado 
		String sql = "UPDATE produto SET descricao = "+ "(?)" + "WHERE id= " + "(?)"; 
			
			try { 
								
				stmt =conn.prepareStatement(sql); 
				stmt.setString(1, produto.getDescricao()); 
				stmt.setInt(2, produto.getId()); 
				stmt.execute();  
				
				return true; 
		
			} catch (SQLException ex) {
				ex.printStackTrace();
				
				return false; 
				
			} finally { 
				try { 
					ConnectionFactory.closeConnection(conn, stmt);
				} catch (Exception ex) { 
					System.out.println("Problemas ao fechar conexão!");
					ex.printStackTrace();
				}
			}
		
	}


	@Override
	public void excluir(int id) {

			PreparedStatement stmt =null;  //Objeto criado,  usado quando precisamos executar comandos SQL pré-compilados e obter o resultado produzido.
			
			String sql = "DELETE FROM produto WHERE id= "+ "(?)"; 
			
			try { 
				stmt =conn.prepareStatement(sql); //converter string em sql 
				stmt.setInt(1, id);  // define o valor do primeiro parâmetro (índice 1) na consulta. O valor é o id fornecido.
				stmt.executeUpdate(); //O método executeUpdate() é usado para executar comandos SQL que alteram os dados no banco de dados.
				
		
			} catch (SQLException ex) {
				System.out.println("problemas na DAO ao excluir Produto! Erro: " + ex.getMessage());
				ex.printStackTrace();
				
			} finally { 
				try { 
					ConnectionFactory.closeConnection(conn, stmt);
				} catch (Exception ex) { 
					System.out.println("Problemas ao fechar conexão! Erro: " + ex.getMessage());
					ex.printStackTrace();
				}
			}
		
		
	}
}
