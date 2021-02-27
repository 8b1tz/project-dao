package aplicacao_console;

import fachada.Fachada;

public class Consultar {

	public Consultar(){

		try {
			Fachada.inicializar();
			System.out.println(Fachada.consultarUsuariosPorVideo("www.seila.com"));
			System.out.println(Fachada.consultarVideosPorUsuario("sarinhabinoculo1@gmail.com"));
			System.out.println(Fachada.consultarVideosPorAssunto("avestruz"));
			System.out.println(Fachada.consultarVideosPorAssunto("maquiagem"));
			System.out.println(Fachada.consultarVideosPorUsuario("meninoveneno18@gmail.com"));
			System.out.println(Fachada.consultarVideosPorUsuario("egirlboneka@msn.com"));
			System.out.println(Fachada.consultarVideosPorAssunto("celular"));
			System.out.println(Fachada.consultarVideosPorUsuario("yodafonfon@hotmail.com"));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("\nfim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}