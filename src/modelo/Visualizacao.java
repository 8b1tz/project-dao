package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visualizacao {
	private int id;
	private LocalDateTime datahora = LocalDateTime.now();
	private int nota;
	private Usuario usuario;
	private Video video;

	public Visualizacao(int id, int nota, Usuario usuario, Video video) throws Exception {
		if(nota > 5 || nota < 1) {
			throw new Exception("Nota invalida!");
		}
		this.id = id;
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public Video getVideo() {
		return video;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNota() {
		return nota;
	}

	@Override
	public String toString() {
		return "Visualizacao [id=" + id + ", datahora="
				+ datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss")) + ", nota=" + nota + "\n usuario="
				+ usuario.getEmail() + ", video=" + video.getNome() + "]";
	}

}
