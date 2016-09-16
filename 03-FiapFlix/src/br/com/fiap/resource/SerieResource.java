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

import br.com.fiap.dao.SerieDAO;
import br.com.fiap.dao.impl.SerieDAOImpl;
import br.com.fiap.entity.Serie;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.exceptions.IdNotFoundException;
import br.com.fiap.singleton.EMFactorySingleton;

@Path("/serie")
public class SerieResource {

	private SerieDAO dao;
	
	public SerieResource() {
		dao = new SerieDAOImpl(EMFactorySingleton.getInstance());
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(String json){
		Serie serie = new Gson().fromJson(json, Serie.class);
		try {
			dao.insert(serie);
			return Response.status(201).build();
		} catch (DBCommitException e) {
			e.printStackTrace();
		}
		return Response.status(500).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String buscar(@PathParam("id") int codigo){
		Serie serie = dao.findById(codigo);
		return new Gson().toJson(serie);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(){
		List<Serie> series = dao.list();
		return new Gson().toJson(series);
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") int id){
		try {
			dao.delete(id);
			//Retorna OK
			return Response.status(200).entity("Apagado!").build();
		} catch (DBCommitException | IdNotFoundException e) {
			e.printStackTrace();
			//Retorna Erro
			return Response.status(500).entity("Erro").build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterar(String json){
		//Transforma o json em um objeto Serie
		Serie serie = new Gson().fromJson(json, Serie.class);
		try {
			//Chama o dao para alterar
			dao.update(serie);
			//devolve uma resposta
			return Response.status(200).build();
		} catch (DBCommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.status(500).build();
		}
	}
	
	
	
}






