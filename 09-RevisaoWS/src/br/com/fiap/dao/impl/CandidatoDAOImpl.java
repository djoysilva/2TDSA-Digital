package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.CandidatoDAO;
import br.com.fiap.entity.Candidato;

public class CandidatoDAOImpl extends DAOImpl<Candidato, Integer> implements CandidatoDAO{

	public CandidatoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
