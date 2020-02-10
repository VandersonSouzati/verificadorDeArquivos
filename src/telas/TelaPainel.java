package telas;

import javax.swing.*;
import javax.swing.table.*;
import modelos.Arquivos;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class TelaPainel extends JPanel {
	private JPanel pnPrincipal, pnTable;
	private JButton btRemover, btnFiltrar, btnVerificar;
	private JScrollPane scrollTable;
	private JTable table;
	private JCheckBox ckNomeParcial, ckVerificar;
	private JLabel lbNumero, lbTotal, lbUnidade, lbMapeamento, lbNomeParcial, lbArquivo;
	private JTextField tfNumero, tfTotal, tfUnidade, tfMapeamento, tfArquivo;
	private JComboBox cbUnidades, cbMapeamentos, cbArquivos;
	private Font fontBotoesMenu, fontBotoesPainel;
	private Arquivos arquivo;
	private String[] unidades = { "Todas", "001", "002", "003", "004", "005", "006", "007", "008", "009", "010", "011",
			"012", "013", "014", "015", "016", "017", "018", "019", "020", "021", "022" };
	private String[] listaMapeamentos = { "Todos os Mapeamentos: ", "\\serverunl1\\rp\\import\\",
			"\\serverunl2\\rp\\import\\", "\\serverunl3\\rp\\import\\", "\\serverunl4\\rp\\import\\",
			"\\serverunl5\\rp\\import\\", "\\serverunl6\\rp\\import\\", "\\serverunl7\\rp\\import\\",
			"\\serverunl8\\rp\\import\\", "\\serverunl9\\rp\\import\\", "\\serverunl10\\rp\\import\\",
			"\\serverunl11\\rp\\import\\", "\\serverunl12\\rp\\import\\", "\\serverunl13\\rp\\import\\",
			"\\serverunl14\\rp\\import\\", "\\serverunl15\\rp\\import\\", "\\serverunl16\\rp\\import\\",
			"\\serverunl17\\rp\\import\\", "\\serverunl18\\rp\\import\\", "\\serverunl19\\rp\\import\\",
			"\\serverunl20\\rp\\import\\", "\\serverunl21\\rp\\import\\", "\\serverunl22\\rp\\import\\" };
	private String[] listaArquivos = { "Todos Arquivos", "Tirateima.txt", "ItensMGV.txt", "ProdGer.exp(Parcial)", };
	DecimalFormat df = new DecimalFormat("#,###.00");

	public TelaPainel() {
		inicializarComponentes();
		definirEventos();
	}

	private void inicializarComponentes() {
		setLayout(null);
		fontBotoesMenu = new Font("Arial", fontBotoesMenu.PLAIN, 12);
		lbUnidade = new JLabel("Unidade:");

		lbArquivo = new JLabel("Arquivo:");
		lbNomeParcial = new JLabel("NomeParcial");
		lbMapeamento = new JLabel("Mapeamento:");
		ckNomeParcial = new JCheckBox("Nome Parcial");

		tfUnidade = new JTextField();
		tfArquivo = new JTextField();

		cbUnidades = new JComboBox(unidades);
		cbMapeamentos = new JComboBox(listaMapeamentos);
		cbArquivos = new JComboBox(listaArquivos);

		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.setToolTipText("Filtra registros apresentados no Grid");
		btRemover = new JButton("Remover");
		btRemover.setToolTipText("Remove os itens selecionados");
		btnVerificar = new JButton("Verificar");

		lbUnidade.setBounds(15, 10, 100, 25);
		cbUnidades.setBounds(15, 35, 80, 25);
		// cbUnidades.setfontBotoesMenu(new fontBotoesMenu("Arial",
		// fontBotoesMenu.PLAIN, 15));
		lbArquivo.setBounds(110, 10, 120, 25);
		cbArquivos.setBounds(110, 35, 150, 25);

		lbMapeamento.setBounds(275, 10, 120, 25);
		cbMapeamentos.setBounds(275, 35, 250, 25);
		// cbMapeamentos.setfontBotoesMenu(new fontBotoesMenu("Arial",
		// fontBotoesMenu.PLAIN, 15));

		btnVerificar.setBounds(560, 35, 100, 25);
		btnVerificar.setFont(fontBotoesPainel);

		btnFiltrar.setBounds(560, 80, 100, 22);
		btRemover.setBounds(125, 80, 100, 22);

		pnPrincipal = new JPanel();
		pnPrincipal.setLayout(null);
		pnPrincipal.setBounds(0, 0, 810, 500);
		pnPrincipal.add(lbUnidade);
		pnPrincipal.add(cbUnidades);
		pnPrincipal.add(lbArquivo);
		pnPrincipal.add(cbArquivos);
		pnPrincipal.add(lbMapeamento);
		pnPrincipal.add(cbMapeamentos);
		pnPrincipal.add(btnVerificar);
		pnTable = new JPanel(new BorderLayout());
		pnTable.setBorder(new TitledBorder("Arquivos"));
		scrollTable = new JScrollPane();
		df.setMinimumFractionDigits(2);
		df.setMaximumFractionDigits(2);
		pnPrincipal.add(btnFiltrar);
		pnPrincipal.add(btRemover);
		DefaultTableModel tableModel = new DefaultTableModel(
				new String[] { "Id", "Unidade", "Mapeamento", "Arquivo", "Data Modificação", "Consultado Em:" }, 0);
		table = new JTable(tableModel);
		DefaultTableCellRenderer alinhaCentro = new DefaultTableCellRenderer();
		alinhaCentro.setHorizontalAlignment(SwingConstants.CENTER);
		DefaultTableCellRenderer alinhaEsquerda = new DefaultTableCellRenderer();
		alinhaEsquerda.setHorizontalAlignment(SwingConstants.LEFT);
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(110);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(1).setCellRenderer(alinhaCentro);
		table.getColumnModel().getColumn(2).setPreferredWidth(240);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setPreferredWidth(140);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(3).setCellRenderer(alinhaCentro);
		// table.getColumnModel().set
		table.getColumnModel().getColumn(4).setPreferredWidth(120);
		table.getColumnModel().getColumn(4).setResizable(false);
		table.getColumnModel().getColumn(4).setCellRenderer(alinhaCentro);
		table.getColumnModel().getColumn(5).setPreferredWidth(105);
		table.getColumnModel().getColumn(5).setResizable(false);
		table.getColumnModel().getColumn(5).setCellRenderer(alinhaCentro);
		table.getTableHeader().setReorderingAllowed(false);

		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBackground(Color.decode("#AAFFAA"));
		scrollTable.setViewportView(table);
		pnTable.add(scrollTable);
		pnTable.setBounds(10, 100, 760, 400);
		pnPrincipal.add(pnTable);
		add(pnPrincipal);
	}

	private void definirEventos() {
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String parcial = (ckNomeParcial.isEnabled() == true) ? "SIM" : "NÃO";
				// String parcial = (ckNomeParcial.isEnabled() == true) ? "SIM" : "NÃO";
				arquivo = new Arquivos();
				ckVerificar = new JCheckBox();
				ckVerificar.setEnabled(true);
				/*
				 * arquivo.setMapeamento(tfUnidade.getText());
				 * arquivo.setArquivo(tfArquivo.getText()); arquivo.setParcial(parcial);
				 * 
				 * if (arquivo.getMapeamento().equals("") || arquivo.getArquivo().equals("")) {
				 * JOptionPane.showMessageDialog(pnTable, "Preencha todos os campos!"); return;
				 * }
				 */
				String unidade = (String) "Unidade: " + cbUnidades.getSelectedItem();
				String caminho = (String) cbMapeamentos.getSelectedItem();
				String arquivo = (String) cbArquivos.getSelectedItem();

				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.addRow(new Object[] { "109", unidade, caminho, arquivo, "20-01-2019","26/01/20" });
				limparCampos();

			}

		});

		btRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int[] linhas = table.getSelectedRows();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				for (int i = (linhas.length - 1); i >= 0; --i) {
					dtm.removeRow(linhas[i]);
				}

			}
		});

		cbUnidades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// JOptionPane.showMessageDialog(null,cbUnidades.getSelectedItem());
				// cbArquivos.removeAllItems();
				// cbArquivos.addItem("Unidade: "+cbUnidades.getSelectedItem());
			}
		});
        
		table.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent tecla) {
				if(tecla.getKeyChar() == KeyEvent.VK_ENTER) {
				   
				}
				
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				int linha  = table.getSelectedRow();
				int coluna = table.getSelectedColumn();
				
				//System.out.println(table.getSelectedRow());
				JOptionPane.showMessageDialog(null,table.getSelectedRow()); 
				//JOptionPane.showMessageDialog(null, table.getValueAt(linha, coluna));
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
	}
	
	
	private void limparCampos() {
		tfUnidade.setText("");
		tfArquivo.setText("1");
		tfUnidade.requestFocus();
	}
}