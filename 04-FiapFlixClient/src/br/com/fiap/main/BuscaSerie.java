package br.com.fiap.main;

import br.com.fiap.entity.Serie;
import br.com.fiap.repository.SerieRepository;

public class BuscaSerie {

	public static void main(String[] args) {
		SerieRepository repository = new SerieRepository();
		try {
			Serie serie = repository.buscar(5);
			System.out.println(serie.getTitulo());
			System.out.println(serie.getGenero());
			System.out.println(serie.getDataLancamento().getTime());
		} catch (Exception e) {
			System.out.println("ERROU");
			e.printStackTrace();
		}
	}
	
}
