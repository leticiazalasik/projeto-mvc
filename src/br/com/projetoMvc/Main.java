package br.com.projetoMvc;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.projetoMvc.controller.ProdutoController;
import br.com.projetoMvc.model.Produto;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		
		String menu=" "
				.concat("-Opcoes- \n")
				.concat("[1] Cadastrar\n")
				.concat("[2] Listar Todos\n")
				.concat("[3] Listar por ID\n")
				.concat("[4] Excluir\n")
				.concat("[5] Editar\n")
				.concat("[6] Finalizar\n")
				.concat("Digite a opção desejada: \n");
		
			String option = JOptionPane.showInputDialog(menu);
			int optionInt = Integer.parseInt(option);

		
		ProdutoController controller = new ProdutoController(); 

		while (optionInt!=0) {
		switch (optionInt){
		
		case 1: 
				//Cadastrar 
				Produto novoProduto = new Produto(); 
				novoProduto.setDescricao(JOptionPane.showInputDialog("Descricao do produto: "));
				controller.cadastrar(novoProduto);
				break; 
				
			case 2: 
	
				//Listar 
				List <Produto>lista = new ArrayList<Produto>(); 
				lista = controller.listarTodos();

	
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
				break; 
				
			case 3: 
				
				
				int opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: ")); 
								
				Produto produtoEncontrado = controller.listarPorId(opcao);


				String mensagemLista2=" "
				.concat("Id: ") 
				.concat(String.valueOf(produtoEncontrado.getId())) //concat só recebe string entao preciso converter 
				.concat("\n")
				.concat("Descrição: ")
				.concat(produtoEncontrado.getDescricao()); 

				if (produtoEncontrado != null) {
					JOptionPane.showMessageDialog(null, mensagemLista2);

				} else {
					JOptionPane.showMessageDialog(null, "Não existe produto com esse código na lista");
				}
				break; 
				
			case 4: 
				opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: ")); 
				
				controller.excluir(opcao);


				break; 
	
			case 5: 
				opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o id: ")); 
				
				controller.alterar(controller.listarPorId(opcao));
				break; 
				
			case 6: 
				JOptionPane.showMessageDialog(null, "Sistema finalizado!");
				break; 
	
				default: 
					JOptionPane.showMessageDialog(null, "Opção inexistente \n Tente novamente!");
					
					break; 
			}
		if (optionInt!=6) {
		option = JOptionPane.showInputDialog(menu);
		optionInt = Integer.parseInt(option);
		} else { 
			break; 
		}
		}
	}
}
