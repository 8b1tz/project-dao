package aplicacao_console;

import fachada.Fachada;
import modelo.Video;

public class Cadastrar {

	public Cadastrar() {
		try {
			Fachada.inicializar();

			System.out.println("cadastrando...");
			Video vi01, vi02, vi03, vi04, vi05, vi06;
			vi01 = Fachada.cadastrarVideo(
					"https://www.youtube.com/watch?v=XXYlFuWEuKI&list=RDMMXXYlFuWEuKI&start_radio=1",
					"the weekend - save your tears", "musica");
			vi02 = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=0-7IHOXkiV8&list=RDMMXXYlFuWEuKI&index=2",
					"KALEO - Way Down We Go", "musica");
			vi03 = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=cHHLHGNpCSA&list=RDMMXXYlFuWEuKI&index=3",
					"Avicii - Waiting For Love", "musica");
			vi04 = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=KlIL63MeyMY",
					"Curso POO Teoria  - Aula - 01A", "aula");
			vi05 = Fachada.cadastrarVideo(
					"https://www.youtube.com/watch?v=Ucyx_QPfDng&list=PLHz_AreHm4dkqe2aR0tQK74m8SFe-aGsY&index=2",
					"Curso POO Teoria  - Aula - 01B", "aula");
			vi06 = Fachada.cadastrarVideo(
					"https://www.youtube.com/watch?v=aR7CKNFECx0&list=PLHz_AreHm4dkqe2aR0tQK74m8SFe-aGsY&index=3",
					"Curso POO Teoria  - Aula - 02A", "aula");

			Fachada.registrarVisualizacao(
					"https://www.youtube.com/watch?v=XXYlFuWEuKI&list=RDMMXXYlFuWEuKI&start_radio=1", "ana@gmail.com",
					5);

			Fachada.registrarVisualizacao(
					"https://www.youtube.com/watch?v=XXYlFuWEuKI&list=RDMMXXYlFuWEuKI&start_radio=1", "julia@gmail.com",
					2);
			Fachada.registrarVisualizacao("https://www.youtube.com/watch?v=cHHLHGNpCSA&list=RDMMXXYlFuWEuKI&index=3",
					"ana@gmail.com", 2);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa de cadastros");
	}

	public void cadastrar() {

	}

	// =================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}