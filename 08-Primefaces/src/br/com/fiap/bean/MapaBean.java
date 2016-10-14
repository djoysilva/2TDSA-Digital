package br.com.fiap.bean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@ViewScoped
public class MapaBean {

	private MapModel mapa; 
	
	@PostConstruct
	private void init(){
		mapa = new DefaultMapModel();
		//Criar uma posição
		LatLng posicao = new LatLng(-23.563674, -46.682963);
		//Adiciona um marcador no mapa
		mapa.addOverlay(new Marker(posicao, "Casa de algum professor"));
	}

	public MapModel getMapa() {
		return mapa;
	}

	public void setMapa(MapModel mapa) {
		this.mapa = mapa;
	}
	
}
