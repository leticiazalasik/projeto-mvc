package br.com.projetoMvc.test;

import javax.swing.JOptionPane;

public class ExemploJOptionPane {
	
	public static void main(String[] args) {
		
		//Exemplo de captura de dados do usuário através da claasse JOptionPane
		String nome = JOptionPane.showInputDialog("Digite seu nome: ");
		
		//Exemplo de saída de dados do usuário através da claasse JOptionPane
		JOptionPane.showMessageDialog(null, "Nome digitado: " + nome);
				
		String menu = "Menu de opções" 
				+ "\n[1] cadastrar"
				+ "\n [2] Listar todos"; 
		
		//Exemplo de conversao de dados String para Integer 
		int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu)); 
		
		JOptionPane.showMessageDialog(null, opcao);
	}
}
