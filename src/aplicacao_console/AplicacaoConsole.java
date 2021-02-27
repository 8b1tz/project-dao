package aplicacao_console;

import fachada.Fachada;

public class AplicacaoConsole {

	public static void main(String[] args) {
		Fachada.inicializar();
		try {
			Fachada.cadastrarVideo("www.seila.com", "felipe neto", "doidos");
			Fachada.adicionarAssunto("www.seila.com", "avestruz");
			System.out.println(Fachada.listarVideos());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Fachada.finalizar();
	}

}
