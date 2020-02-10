package modelos;

import java.util.Date;

public class RegistroGeral {
	private int id;
	private String unidade;
	private String mapeamento;
	private String arquivo;
	private Date dataVerificacao;
	private Date dataModificacao;
	private boolean tipoBusca;
	private boolean verificar;

	public RegistroGeral() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getMapeamento() {
		return mapeamento;
	}

	public void setMapeamento(String mapeamento) {
		this.mapeamento = mapeamento;
	}

	public String getArquivo() {
		return arquivo;
	}

	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}

	public Date getDataVerificacao() {
		return dataVerificacao;
	}

	public void setDataVerificacao(Date dataVerificacao) {
		this.dataVerificacao = dataVerificacao;
	}

	public Date getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}

	public boolean isTipoBusca() {
		return tipoBusca;
	}

	public void setTipoBusca(boolean tipoBusca) {
		this.tipoBusca = tipoBusca;
	}

	public boolean isVerificar() {
		return verificar;
	}

	public void setVerificar(boolean verificar) {
		this.verificar = verificar;
	}

}
