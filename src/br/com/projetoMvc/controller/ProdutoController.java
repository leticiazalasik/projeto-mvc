package br.com.projetoMvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.DAO.GenericDAO;
import br.com.projetoMvc.DAO.ProdutoDAOImpl;
import br.com.projetoMvc.model.Produto;

public class ProdutoController {
	
	Produto produto = null; // Inicializa o produto como null


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
	
public Produto listarPorId(int id){ //método que retorna uma lista de objetos do tipo produto 

		try {  
			GenericDAO dao = new ProdutoDAOImpl(); //instância de ProdutoDAOImpl, que implementa a interface GenericDAO, é criada e atribuída à variável dao. polimorfismo para tratar um objeto concreto (ProdutoDAOImpl) como se fosse do tipo genérico (GenericDAO).

			Produto produto = (Produto) dao.listarPorId(id);  //Aqui estamos chamando o método listarPorId do objeto dao, que deveria retornar um objeto do tipo Produto. O resultado dessa chamada é armazenado na variável produto. 			
			return produto; 
			
		} catch (Exception e) {  //Se der erro faz isso 
			System.out.println("Erro na controller ao listar Produto.");
			e.printStackTrace();
			return null; 
		}
		
	}


public void cadastrar(Produto produto){ //método para cadastrar produto 
		
		List<Produto> listaProdutos = new ArrayList<Produto>(); //Inicializacao da lista 
		try {  
			GenericDAO dao = new ProdutoDAOImpl(); //Interface nome new nome da classe que implementou - a diferenca é que nesse caso só posso usar métofos da genericDAO e se quiser usar de tudo coloca produtoDAOIMpl mesmo 
		if (dao.cadastrar(produto)) {
			JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
			} else { 
				JOptionPane.showMessageDialog(null, "Problemas ao cadatsrar produto");
			}
			
		} catch (Exception e) {  //Se der erro faz isso 
			System.out.println("Erro ao controller ao cadastrar Produto.");
			e.printStackTrace();
		}
		
	}

public boolean excluir(int id ){ //método para cadastrar produto 
	
	try {  
		GenericDAO dao = new ProdutoDAOImpl(); //Interface nome new nome da classe que implementou - a diferenca é que nesse caso só posso usar métofos da genericDAO e se quiser usar de tudo coloca produtoDAOIMpl mesmo 
	
		Produto produto = (Produto) dao.listarPorId(id);
		
		if (produto==null) { 
			return false; 
		}
	dao.excluir(id);
				
		return true; 
		
	} catch (Exception e) {  //Se der erro faz isso 
		System.out.println("Erro ao controller ao Excluir produto Produto.");
		e.printStackTrace();
		return false; 
	
}
}

public boolean alterar (Object object){ //método para cadastrar produto 

try {  
	GenericDAO dao = new ProdutoDAOImpl(); //Interface nome new nome da classe que implementou - a diferenca é que nesse caso só posso usar métofos da genericDAO e se quiser usar de tudo coloca produtoDAOIMpl mesmo 

dao.alterar(object);
		
	return true;
	
} catch (Exception e) {  //Se der erro faz isso 
	System.out.println("Erro ao controller ao Excluir produto Produto.");
	e.printStackTrace();
	return false; 

}
}
}
