package fachada;

import dao.DAO;
import dao.DAOAssunto;
import dao.DAOVisualizacao;
import dao.DAOusuario;
import dao.DAOvideo;
import modelo.Assunto;
import modelo.Video;

public class Fachada {
	private static DAOvideo daovideo = new DAOvideo();
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOusuario daousuario = new DAOusuario();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();

	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	public static Video cadastrarVideo(String link, String nome, Assunto palavra) throws Exception {
		DAO.begin();
		Video v = daovideo.read(link);
		if (v != null) {
			DAO.rollback();
			throw new Exception("Video já cadastrado: " + link);
		}
		v = new Video(link, nome);
		daovideo.create(v);
		DAO.commit();
		return v;
	}
}
