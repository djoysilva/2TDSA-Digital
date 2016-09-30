package br.com.fiap.entity;

public class Candidato {

	private int id;
	
	private String nome;
	
	private boolean fichaLimpa;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isFichaLimpa() {
		return fichaLimpa;
	}

	public void setFichaLimpa(boolean fichaLimpa) {
		this.fichaLimpa = fichaLimpa;
	}
	
}
