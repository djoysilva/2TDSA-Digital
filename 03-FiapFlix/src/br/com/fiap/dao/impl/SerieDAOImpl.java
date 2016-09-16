package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.SerieDAO;
import br.com.fiap.entity.Serie;

public class SerieDAOImpl extends DAOImpl<Serie, Integer> implements SerieDAO{

	public SerieDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
