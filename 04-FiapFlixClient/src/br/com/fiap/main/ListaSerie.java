package br.com.fiap.main;

import java.util.List;

import br.com.fiap.entity.Serie;
import br.com.fiap.repository.SerieRepository;

public class ListaSerie {

	public static void main(String[] args) {
		SerieRepository repository = new SerieRepository();
		List<Serie> lista;
		try {
			lista = repository.listar();
			for (Serie serie : lista) {
				System.out.println(serie.getCodigo() + " - " + serie.getTitulo());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
