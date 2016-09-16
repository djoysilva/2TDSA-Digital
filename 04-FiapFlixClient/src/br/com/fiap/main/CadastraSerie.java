package br.com.fiap.main;

import java.util.Calendar;

import br.com.fiap.entity.Serie;
import br.com.fiap.repository.SerieRepository;

public class CadastraSerie {

	public static void main(String[] args) {
		SerieRepository repo = new SerieRepository();
		Serie serie = new Serie(0, "Nachos", 2, 
					Calendar.getInstance(), "Gastronomia");
		repo.cadastrar(serie);
		System.out.println("Cadastrado!");		
	}
	
}
