package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ArquivosController implements IArquivosController{
	String pathRead = "C:\\Exercicio_Arquivos_Java";
	String nomeRead = "relatorio.txt";

	public ArquivosController() {
		super();
	}

	@Override
	public void criaArq(String pathCreate, String nomeCreate) throws IOException {
		File dir = new File(pathCreate);
		File arq = new File(pathCreate, nomeCreate);
		if (dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			String conteudo = escreveArq();
			FileWriter fileWriter = new FileWriter (arq, existe);
			PrintWriter print = new PrintWriter(fileWriter);
			print.write(conteudo);
			print.flush();
			print.close();
			fileWriter.close();
		} else {
			throw new IOException("Diretório Inválido!");
		}
	}

	@Override
	public String escreveArq() throws IOException {
		StringBuffer escreve = new StringBuffer();
		File arq = new File(pathRead, nomeRead);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			while (linha != null) {
				linha = new String(linha.getBytes(), "UTF-8");
				escreve.append(linha.replace(" ", ";"));
				escreve.append("\n");
				System.out.println(linha);
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo Inválido!");
		}
		return escreve.toString();
	}
	
}
