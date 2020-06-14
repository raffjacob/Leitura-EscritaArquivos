package controller;
import java.io.IOException;

public interface IArquivosController {
	public void criaArq(String path, String nome) throws IOException;
	public String  escreveArq() throws IOException;
}
