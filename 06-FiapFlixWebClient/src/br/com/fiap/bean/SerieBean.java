package br.com.fiap.bean;

import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.entity.Serie;
import br.com.fiap.repository.SerieRepository;

@ManagedBean
@RequestScoped
public class SerieBean {

	private Serie serie;
	
	private SerieRepository rep;
	
	private List<Serie> lista;
	
	@PostConstruct
	private void init(){
		//Inicializando os objetos
		serie = new Serie();
		serie.setDataLancamento(Calendar.getInstance());	
		rep = new SerieRepository();
		try {
			lista = rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			rep.cadastrar(serie);
			msg = new FacesMessage("Série cadastrada!");
			lista = rep.listar();
		} catch (Exception e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro!");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	public List<Serie> getLista() {
		return lista;
	}

	public void setLista(List<Serie> lista) {
		this.lista = lista;
	}
	
}
