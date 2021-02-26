package fachada;

import java.util.List;

import dao.DAO;
import dao.DAOAssunto;
import dao.DAOVisualizacao;
import dao.DAOusuario;
import dao.DAOvideo;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Fachada {
	private static DAOvideo daovideo = new DAOvideo();
	private static DAOAssunto daoassunto = new DAOAssunto();
	private static DAOusuario daousuario = new DAOusuario();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();
	private static int id = 0;
	
	public static void inicializar() {
		DAO.open();
	}

	public static void finalizar() {
		DAO.close();
	}

	public static Video cadastrarVideo(String link, String nome, String palavra) throws Exception {
		DAO.begin();
		Video v = daovideo.read(link);
		if (v != null) {
			DAO.rollback();
			throw new Exception("Video j√° cadastrado: " + link);
		}
		v = new Video(link, nome);
		v.adicionar(new Assunto(palavra));
		daovideo.create(v);
		DAO.commit();
		return v;
	}
	
	public static void adicionarAssunto(String link, String palavra) throws Exception {
		DAO.begin();
		Video v = daovideo.read(link);
		if(v == null) {
			DAO.rollback();	
			throw new Exception("Video inexistente");
		}
		v.adicionar(new Assunto(palavra));
		daovideo.update(v);
		DAO.commit();
	}
	
	public static Visualizacao registrarVisualizacao(String link, String email, int nota) throws Exception {
		DAO.begin();
		Video v = daovideo.read(link);
		if (v == null) {
			DAO.rollback();
			throw new Exception("Video n√£o encontrado");
		}
		Visualizacao visu = new Visualizacao(id++, nota, new Usuario(email), v);
		v.adicionar(visu);
		daovisualizacao.create(visu);
		DAO.commit();
		return visu;
		
	}

	public static Visualizacao localizarVisualizacao(int id) throws Exception{
		List<Visualizacao> visu = listarVisualizacoes();
		for(Visualizacao v : visu) {
			if(v.getId() == id) {
				return daovisualizacao.read(v);
			}
		}
		DAO.rollback();	
		throw new Exception("N„o existe visualizaÁ„o com esse id");
	};
	
	public static void apagarVisualizacao(int id) throws Exception {
		DAO.begin();
		Visualizacao visu = daovisualizacao.read(id);
		if (visu == null) {
			DAO.rollback();
			throw new Exception("Visualizac√£o inexistente "+ visu);
		}
		List<Video> v= listarVideos();
		for (Video vi : v) {
			vi.remover(visu);
		}
		daovisualizacao.delete(visu);
		DAO.commit();
	}
	
	public static List<Visualizacao> listarVisualizacoes(){
        return daovisualizacao.readAll();
        }

    public static List<Video> listarVideos(){
        return daovideo.readAll();
        }

    public static List<Usuario> listarUsuarios(){
        return daousuario.readAll();
        }
}


