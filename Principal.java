package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController();
		String pathCreate = "C:\\Exercicio_Arquivos_Java";
		String nomeCreate = "relatorio.csv";
		
		try {
			arqCont.criaArq(pathCreate, nomeCreate);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
