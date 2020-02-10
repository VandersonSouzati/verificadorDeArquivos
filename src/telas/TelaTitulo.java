package telas;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaTitulo extends JPanel{
  JLabel titulo;
  
  public TelaTitulo() {
	  inicializarComponentes();
	  definirEventos();
  }
  
  public void inicializarComponentes() {
	  //setLayout(null);
	  titulo = new JLabel("Verificador de Arquivos");
	  Font font = new Font("Arial", Font.BOLD, 35);
	  titulo.setFont(font);
	  add(titulo);
  }
  
  public void definirEventos() {
	  
  }
  
}
