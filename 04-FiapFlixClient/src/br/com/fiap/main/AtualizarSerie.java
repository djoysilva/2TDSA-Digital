package br.com.fiap.main;

import br.com.fiap.entity.Serie;
import br.com.fiap.repository.SerieRepository;

public class AtualizarSerie {

	public static void main(String[] args) throws Exception {
		SerieRepository rep = new SerieRepository();
		
		Serie serie = rep.buscar(22);
		
		serie.setTitulo("The Walking Dead");
		
		rep.atualizar(serie);
	}
	
}
