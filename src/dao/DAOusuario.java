package dao;


import java.util.List;

import com.db4o.query.Query;

import modelo.Usuario;
import modelo.Video;

public class DAOusuario extends DAO<Usuario>{

	@Override
	public Usuario read(Object chave) {
		return read(chave);
	}

	public List<Video> consultarVideosPorAssunto(String palavra) {
        Query q = manager.query();
        q.constrain(Video.class);
        q.descend("assunto").descend("palavra").constrain(palavra);
        List<Video> resultado = q.execute();
        if (resultado.size() == 0) {
            return null;
        }
        else {
            return resultado;
        }
    }
	
}
