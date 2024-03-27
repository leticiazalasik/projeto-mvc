package br.com.projetoMvc.test;

import java.sql.Connection;

import br.com.projetoMvc.util.ConnectionFactory;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try { 
			
			Connection connection = ConnectionFactory.getConnection();  //Aqui voce busca o conection do pacote projetoMvc e 
			if (connection != null) {
				System.out.println("Conexão estabelecida com sucesso!");
			}
			
			connection.close(); 
		} catch (Exception e) {
			System.out.println("Erro ao conectar: " + e.getMessage());
			e.printStackTrace();
			
		}
	}

}
