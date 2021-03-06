package br.com.fiap.entity;

import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqSerie",sequenceName="SEQ_SERIE",allocationSize=1)
public class Serie {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="seqSerie")
	private int codigo;
	
	private String titulo;
	
	private int temporadas;
	
	private Calendar dataLancamento;
	
	private String genero;

	public Serie() {
		super();
	}

	public Serie(int codigo, String titulo, int temporadas, Calendar dataLancamento, String genero) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.temporadas = temporadas;
		this.dataLancamento = dataLancamento;
		this.genero = genero;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public Calendar getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Calendar dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
