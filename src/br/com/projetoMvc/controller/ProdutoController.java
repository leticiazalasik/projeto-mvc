package br.com.projetoMvc.controller;

import java.util.ArrayList;
import java.util.List;

import br.com.projetoMvc.DAO.GenericDAO;
import br.com.projetoMvc.DAO.ProdutoDAOImpl;
import br.com.projetoMvc.model.Produto;

public class ProdutoController {

	public List<Produto> listarTodos(){ //método que retorna uma lista de objetos do tipo produto 
		
		List<Produto> listaProdutos = new ArrayList<Produto>(); //Inicializacao da lista 
		try {  
			GenericDAO dao = new ProdutoDAOImpl(); //Interface nome new nome da classe que implementou - a diferenca é que nesse caso só posso usar métofos da genericDAO e se quiser usar de tudo coloca produtoDAOIMpl mesmo 
		
			for (Object object : dao.listarTodos()) {  //a lista aqui é aquela lá do ProdutoDAOImpl esses objetos são genericos 
				listaProdutos.add((Produto) object); //Aqui converte os objetos genéricos pra objetos Produtos 
				
			}
			
		} catch (Exception e) {  //Se der erro faz isso 
			System.out.println("Erro na controller ao listar Produto.");
			e.printStackTrace();
		}
		
		return listaProdutos; 
	}
	
}
