package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Pokemon;

public interface PokemonDAO extends DAO<Pokemon,Integer>{

	List<Pokemon> buscarPorNome(String nome);
	
	List<String> buscarAutocomplete(String nome);
}
