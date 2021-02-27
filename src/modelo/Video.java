package modelo;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private String link;
	private String nome;
	private double media;
	private List<Assunto> assuntos = new ArrayList<>();
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	
	public Video(String link, String nome) {
		this.link = link;
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	public String getLink() {
        return link;
    }
	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}
	public void remover(Visualizacao vis) {
        visualizacoes.remove(vis);
    }
	
	public List<Assunto> getListaAssuntos() {
		return assuntos;
	}


	@Override
	public String toString() {
		String texto = "Video [" + (link != null ? "link=" + link + ", " : "") +  (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + media ;
		
		texto+=", assuntos= ";
		for(Assunto a : assuntos) {
			texto += a.getPalavra();
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}



	
}