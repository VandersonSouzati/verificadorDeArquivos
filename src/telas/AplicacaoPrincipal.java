package telas;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
public class AplicacaoPrincipal extends JPanel {
    private JPanel pnPrincipal, pnTable;
    private JButton btRemover, btAdicionar;
    private JScrollPane scrollTable;
    private JTable table;
    private JCheckBox ckNomeParcial, ckVerificar;
    private JLabel lbNumero, lbTotal, lbCaminho, lbNomeParcial, lbArquivo;
    private JTextField tfNumero, tfTotal, tfCaminho, tfPrecoUnitario, tfArquivo;
    private Font font;
    
    DecimalFormat df = new DecimalFormat("#,###.00");

    public AplicacaoPrincipal() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        font = new Font("Arial", Font.PLAIN, 12);
        lbCaminho = new JLabel("Caminho:");
        lbCaminho.setFont(font);
        
        lbArquivo = new JLabel("Arquivo:");
        lbNomeParcial = new JLabel("NomeParcial");
        ckNomeParcial = new JCheckBox("Nome Parcial");
        
        tfCaminho = new JTextField();
        tfArquivo = new JTextField();
        btAdicionar = new JButton("Adicionar");
        btAdicionar.setToolTipText("Adiciona um item ao pedido");
        btRemover = new JButton("Remover");
        btRemover.setToolTipText("Remove os itens selecionados");
        lbCaminho.setBounds(15, 10, 100, 25);
        lbArquivo.setBounds(350, 10, 120, 25);
        lbNomeParcial.setBounds(520, 10, 100, 25);
        tfCaminho.setBounds(15, 35, 320, 25);
        tfArquivo.setBounds(350, 35, 150, 25);
        ckNomeParcial.setBounds(510, 35, 120, 25);
        btAdicionar.setBounds(15, 100, 100, 22);
        btRemover.setBounds(125, 100, 100, 22);
        pnPrincipal = new JPanel();
        pnPrincipal.setLayout(null);
        pnPrincipal.setBounds(0, 0, 700, 500);
        pnPrincipal.add(lbCaminho);
        pnPrincipal.add(tfCaminho);
        pnPrincipal.add(lbArquivo);
        pnPrincipal.add(tfArquivo);
        pnPrincipal.add(ckNomeParcial);
        pnTable = new JPanel(new BorderLayout());
        pnTable.setBorder(new TitledBorder("Arquivos"));
        scrollTable = new JScrollPane();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        pnPrincipal.add(btAdicionar);
        pnPrincipal.add(btRemover);
        DefaultTableModel tableModel = new DefaultTableModel(
            new String[]{"Caminho", "Arquivo", "Parcial", "Verificar", "Abrir"},0) {
            public boolean isCellEditable(int row, int col) {
                if (col == 3) {
                    return false;
                }
                return true;
            }
        };
        table = new JTable(tableModel);
        DefaultTableCellRenderer alinhaDireita = new DefaultTableCellRenderer();
        alinhaDireita.setHorizontalAlignment(SwingConstants.CENTER);
        table.getColumnModel().getColumn(0).setPreferredWidth(310);
        table.getColumnModel().getColumn(0).setResizable(false);
        table.getColumnModel().getColumn(1).setPreferredWidth(125);
        table.getColumnModel().getColumn(1).setResizable(false);
        table.getColumnModel().getColumn(1).setCellRenderer(alinhaDireita);
        table.getColumnModel().getColumn(2).setPreferredWidth(75);
        table.getColumnModel().getColumn(2).setResizable(false);
        table.getColumnModel().getColumn(2).setCellRenderer(alinhaDireita);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setResizable(false);
        table.getColumnModel().getColumn(3).setCellRenderer(alinhaDireita);
        table.getColumnModel().getColumn(4).setPreferredWidth(60);
        table.getColumnModel().getColumn(4).setResizable(false);
        table.getColumnModel().getColumn(4).setCellRenderer(alinhaDireita);
        table.getTableHeader().setReorderingAllowed(false);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        scrollTable.setViewportView(table);
        pnTable.add(scrollTable);
        pnTable.setBounds(10, 130, 650, 500);
        pnPrincipal.add(pnTable);
        add(pnPrincipal);
    }

    private void definirEventos() {
        btAdicionar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(tfCaminho.getText().equals("") || tfArquivo.getText().equals("")){
                   JOptionPane.showMessageDialog(pnTable, "Preencha todos os campos!");
                   return;
                }
                String parcial = (ckNomeParcial.isEnabled()==true)?"SIM":"NÃO";
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                dtm.addRow(new Object[]{tfCaminho.getText(), tfArquivo.getText(),
                  parcial});
                limparCampos();
                calcularTotal();
            }
        });
        btRemover.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] linhas = table.getSelectedRows();
                DefaultTableModel dtm = (DefaultTableModel) table.getModel();
                for (int i = (linhas.length - 1); i >= 0; --i) {
                    dtm.removeRow(linhas[i]);
                }
                calcularTotal();
            }
        });
    }

    private void calcularTotal() {
        double total = 0;
        for (int linha = 0; linha < table.getRowCount(); linha++) {
            String valor = "" + table.getValueAt(linha, 3);
            valor = valor.replace(".", "");
            valor = valor.replace(",", ".");
            total += Double.parseDouble(valor);
        }
        tfTotal.setText("" + df.format(total));
    }

    private void limparCampos() {
        tfCaminho.setText("");
        tfArquivo.setText("1");
        tfPrecoUnitario.setText("");
        tfCaminho.requestFocus();
    }
}