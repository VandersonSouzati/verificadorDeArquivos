package operacoes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArquivoService {

	// Retorna a ultima data de modificação de um arquivo
	public String retornaDataModificacao(String caminho, String arquivo) {
		String path = caminho + "//" + arquivo;
		String dataFormatada = null;
		File file = new File(path);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		dataFormatada = sdf.format(file.lastModified());
		return dataFormatada;
	}

	// Busca os arquivos com o mesmo final no nome.
	public String buscaArquivos(String caminho, String nomeArquivo) {
		String dataFormatada = null;
		File file = new File(caminho);
		List<String> lista = new ArrayList<String>();
		String[] nomes = file.list();
		lista = Arrays.asList(nomes);
		lista.stream().filter(arquivo -> verificaNomeArquivo("teste.txt"))
				.forEach(arquivo -> System.out.println(arquivo));

		return null;
	}

	// Retorna true caso encontre o nome no final do arquivo
	public boolean verificaNomeArquivo(String nome) {
		boolean encontrado = (nome.endsWith(nome)) ? true : false;
		return encontrado;
	}

}
