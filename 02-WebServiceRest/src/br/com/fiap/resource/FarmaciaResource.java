package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.fiap.bo.FarmaciaBO;
import br.com.fiap.to.FarmaciaTO;

@Path("/farmacia")
public class FarmaciaResource {

	private FarmaciaBO bo = new FarmaciaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
	public String buscarFarmacia(@PathParam("id") int codigo){
		FarmaciaTO farmacia =  bo.buscar(codigo);			
		//Converter o Objeto para JSON
		return new Gson().toJson(farmacia);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listarTodos(){
		//Busca a lista de farmacia no Banco
		List<FarmaciaTO> lista = bo.listar();
		//Transforma a lista em um JSON array
		return new Gson().toJson(lista);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(String farmaciaJson){
		//Converter o JSON em um objeto Farmacia
		FarmaciaTO farmacia = 
			new Gson().fromJson(farmaciaJson, FarmaciaTO.class);
		//Cadastra no banco de dados
		bo.cadastrar(farmacia);
		//Retorna um status code HTTP - 201 -> Created
		return Response.status(201).build();
	}
	
}







