package hibernate.entity;

import java.util.LinkedHashSet;
import java.util.Set;

public class Eleitor {

	private String tituloEleitor;
	private String nome;
	private Set<Voto> votos = new LinkedHashSet<Voto>();

	public String getTituloEleitor() {
		return tituloEleitor;
	}

	public void setTituloEleitor(String tituloEleitor) {
		this.tituloEleitor = tituloEleitor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Voto> getVotos() {
		return votos;
	}

	public void setVotos(Set<Voto> votos) {
		this.votos = votos;
	}

}
