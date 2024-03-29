package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProdutoController controller = new ProdutoController(); 
		
		System.out.println("- Lista de produtos - ");
		List <Produto>lista = new ArrayList<Produto>(); 
		lista = controller.listarTodos();
		
		System.out.println("- Lista Produtos - ");
		
		for (Produto produto : lista) {
			System.out.print(produto.getId());
			System.out.print("-");
			System.out.println(produto.getDescricao());

		}
		
		System.out.println("Escolha uma opção: \n 1-Listar todos\n");
		
	}

}
