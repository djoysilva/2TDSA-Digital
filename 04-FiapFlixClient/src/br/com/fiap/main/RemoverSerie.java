package br.com.fiap.main;

import br.com.fiap.repository.SerieRepository;

public class RemoverSerie {

	public static void main(String[] args) {
		SerieRepository rep = new SerieRepository();
		rep.remover(4);
		System.out.println("Serie Removida!");
	}
	
}
