package br.com.fiap.bean;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.dao.impl.PokemonDAOImpl;
import br.com.fiap.entity.Pokemon;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@ViewScoped
public class PokemonBean {

	private Pokemon pokemon;
	private PokemonDAO dao;
	private String nomeBusca;
	private int codigo;
	
	private List<Pokemon> lista;
	
	//Método de inicialização
	@PostConstruct
	private void init(){
		pokemon = new Pokemon();
		pokemon.setDataCaptura(Calendar.getInstance());
	
		EntityManager em = EMFactorySingleton.
				getInstance();
		dao = new PokemonDAOImpl(em);
		
		lista = dao.list();
	}
	
	//Método de buscar (clique do botão)
	public void buscar(){
		lista = dao.buscarPorNome(nomeBusca);
	}
	
	//Método para o autocomplete
	public List<String> autocompletar(String nome){
		return dao.buscarAutocomplete(nome);
	}
	
	//Método para exclui um pokemon
	public void banir(){
		FacesMessage msg;
		try {
			dao.delete(codigo);
			msg = new FacesMessage("Banido!");
			lista = dao.list();
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Falhou..");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	//Método de cadastrar (clique do botão)
	public void capturar(){
		FacesMessage msg;
		try {
			if (pokemon.getCodigo() == 0){
				dao.insert(pokemon);
				msg = new FacesMessage("Adicionado à Pokedex");			
				lista.add(pokemon);
			}else{
				dao.update(pokemon);
				msg = new FacesMessage("Atualizado");				
			}			
			//Inicializa um novo pokemon
			pokemon = new Pokemon();
			pokemon.setDataCaptura(Calendar.getInstance());
		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Pokebola falhou");
		}
		FacesContext.getCurrentInstance()
			.addMessage(null, msg);
	}

	public Pokemon getPokemon() {
		return pokemon;
	}

	public void setPokemon(Pokemon pokemon) {
		this.pokemon = pokemon;
	}

	public List<Pokemon> getLista() {
		return lista;
	}

	public void setLista(List<Pokemon> lista) {
		this.lista = lista;
	}

	public String getNomeBusca() {
		return nomeBusca;
	}

	public void setNomeBusca(String nomeBusca) {
		this.nomeBusca = nomeBusca;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
