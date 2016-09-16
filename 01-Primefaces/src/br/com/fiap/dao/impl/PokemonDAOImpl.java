package br.com.fiap.dao.impl;

import br.com.fiap.entity.Pokemon;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.PokemonDAO;

public class PokemonDAOImpl extends DAOImpl<Pokemon,Integer> implements PokemonDAO{

	public PokemonDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Pokemon> buscarPorNome(String nome) {		
		return em.createQuery("from Pokemon p where "
				+ "p.nome like :n",Pokemon.class)
			.setParameter("n", "%"+nome+"%")
			.getResultList();
	}

	@Override
	public List<String> buscarAutocomplete(String nome) {		
		return em.createQuery("select p.nome from "
			+ "Pokemon p where upper(p.nome) like "
			+ "upper(:n)",String.class)
			.setParameter("n", "%"+nome+"%")
			.getResultList();
	}

}
