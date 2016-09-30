package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import br.com.fiap.dao.CandidatoDAO;
import br.com.fiap.dao.impl.CandidatoDAOImpl;
import br.com.fiap.entity.Candidato;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;
import br.com.fiap.singleton.EMFactorySingleton;

@Path("/candidato")
public class CandidatoResource {

	private CandidatoDAO dao;

	// Construtor
	public CandidatoResource() {
		dao = new CandidatoDAOImpl(EMFactorySingleton.getInstance());
	}

	// cadastrar
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(String canJSON) {
		Candidato can = new Gson().fromJson(canJSON, Candidato.class);
		try {
			dao.insert(can);
			return Response.status(201).build();
		} catch (DBCommitException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualizar(String json){
		Candidato candidato = new Gson().fromJson(json, Candidato.class);
		try {
			dao.update(candidato);
			return Response.status(200).build();
		} catch (DBCommitException e) {
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") int id) {
		try {
			dao.delete(id);
			return Response.status(200).entity("Candidato deletado!").build();
		} catch (DBCommitException | IdNotFoundException e) {
			e.printStackTrace();
			return Response.status(500).entity("Erro!").build();
		}
	}

	// listar
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar() {
		List<Candidato> candidatos = dao.list();
		return new Gson().toJson(candidatos);
	}

	// buscar por id
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("id") int id) {
		Candidato candidato = dao.findById(id);
		return new Gson().toJson(candidato);
	}
}
