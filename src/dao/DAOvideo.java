package dao;

import java.util.List;

import com.db4o.query.Query;

import modelo.Video;

public class DAOvideo extends DAO<Video> {

	@Override
	public Video read(Object chave) {
		return read(chave);
	}

	public List<Video> consultarVideosPorAssunto(String palavra) {
		Query q = manager.query();
		q.constrain(Video.class);
		q.descend("assuntos").descend("palavra").constrain(palavra);
		List<Video> resultado = q.execute();
		if (resultado.size() == 0) {
			return null;
		} else {
			return resultado;
		}
	}

	public List<Video> consultarVideosPorUsuario(String email) {
		Query q = manager.query();
		q.constrain(Video.class);
		q.descend("visualizacoes").descend("usuario").descend("email").constrain(email);
		List<Video> resultados = q.execute();
		if (resultados.size() == 0) {
			return null;
		} else {
			return resultados;
		}
	}

}
