package aplicacao_console;
/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * POB - Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

import fachada.Fachada;
import modelo.Video;


public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Video vi01, vi02, vi03, vi04;
			vi01 = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=XXYlFuWEuKI&list=RDMMXXYlFuWEuKI&start_radio=1", "the weekend - save your tears", "musica");
			vi02 = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=0-7IHOXkiV8&list=RDMMXXYlFuWEuKI&index=2", "KALEO - Way Down We Go", "musica");
			vi03 = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=cHHLHGNpCSA&list=RDMMXXYlFuWEuKI&index=3", "Avicii - Waiting For Love", "musica");
			vi04 = Fachada.cadastrarVideo("https://www.youtube.com/watch?v=KlIL63MeyMY", "Curso POO Teoria #01a​ - O que é Programação Orientada a Objetos", "aula");	
			
			
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa de cadastros");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}