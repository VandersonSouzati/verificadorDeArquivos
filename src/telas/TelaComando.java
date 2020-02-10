package telas;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class TelaComando extends JPanel {
    private JPanel painelComandos, painelBotoes, painelBotaoRestaurar;
    private JButton btnUnidades, btnMapeamento, btnArquivos,btnAbrir,btnRestaurar;
	public TelaComando() {
		inicializarComponentes();
		definirEventos();
	}

	public void inicializarComponentes() {
		setLayout(new BorderLayout());
		//Foi necessário criar um JPainel para posicionar sem ocupar todo o principal
		painelBotoes = new JPanel();
		painelBotaoRestaurar = new JPanel();
		painelBotoes.setLayout(new GridLayout(5, 1, 1, 5));//Posicionando apenas o painel
		painelBotaoRestaurar.setLayout(new GridLayout());
		btnUnidades  = new JButton("Novo Registro");
		btnMapeamento   = new JButton("Mapeamento");
		btnArquivos  = new JButton("Arquivos");
        btnAbrir = new JButton("Abrir pasta");
        btnRestaurar = new JButton("Restaurar");
        
        Font font = new Font("Arial", Font.PLAIN, 12);
        btnUnidades.setFont(font);
        btnMapeamento.setFont(font);
        btnArquivos.setFont(font);
        btnAbrir.setFont(font);
        btnRestaurar.setFont(font);
        
        painelBotoes.add(btnUnidades);
        painelBotoes.add(btnMapeamento);
        painelBotoes.add(btnArquivos);
        painelBotoes.add(btnAbrir);
		
		painelBotaoRestaurar.add(btnRestaurar);
		
		add("North",painelBotoes);
		add("South", painelBotaoRestaurar);
	}

	public void definirEventos() {

	}
}
