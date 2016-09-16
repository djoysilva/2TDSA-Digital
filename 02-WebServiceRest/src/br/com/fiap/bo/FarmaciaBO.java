package br.com.fiap.bo;

import java.util.ArrayList;
import java.util.List;
import br.com.fiap.to.FarmaciaTO;

public class FarmaciaBO {

	private static List<FarmaciaTO> lista = new ArrayList<FarmaciaTO>();
	
	static{
		lista.add(new FarmaciaTO(1,"Cura Brasil","Av Paulista",1,1));
		lista.add(new FarmaciaTO(2,"Brasil tem cura","Av Lins",10,100));
	}
	
	public void cadastrar(FarmaciaTO to){		
		lista.add(to);
	}
	
	public FarmaciaTO buscar(int codigo){
		for (FarmaciaTO farmaciaTO : lista) {
			if (farmaciaTO.getCodigo() == codigo) return farmaciaTO;
		}
		return null;
	}
	
	public List<FarmaciaTO> listar(){
		return lista;
	}
	
	
}
