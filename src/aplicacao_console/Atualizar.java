package aplicacao_console;

import fachada.Fachada;

public class Atualizar {

	public Atualizar() {
		Fachada.inicializar();
		try {
			Fachada.adicionarAssunto("aa", "Felipe Neto");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
			System.out.println("fim do programa");
		}
	}

	// =================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}