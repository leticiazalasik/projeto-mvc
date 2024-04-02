package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProdutoController controller = new ProdutoController(); 
		
		List <Produto>lista = new ArrayList<Produto>(); 
		lista = controller.listarTodos();
		
//		System.out.println("- Lista de produtos - ");

//		for (Produto produto : lista) {
//			System.out.print(produto.getId());
//			System.out.print("-");
//			System.out.println(produto.getDescricao());
//		}
//				
		String mensagemLista=" "
		.concat("-Lista Produtos-")
		.concat("\n")
		.concat("Cód. Descrição"); 
		
		for (Produto produto : lista) {
		mensagemLista=mensagemLista
				.concat("\n")
				.concat(String.valueOf(produto.getId())) //concat só recebe string entao preciso converter 
				.concat("            ")
				.concat(produto.getDescricao()); 
			
		}
		JOptionPane.showMessageDialog(null, mensagemLista);
		
	}

}
