package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name="seqPoke",sequenceName="SEQ_POKEMON",allocationSize=1)
public class Pokemon{

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seqPoke")
	private int codigo;
	
	private String nome;
	
	private Calendar dataCaptura;
	
	private int cp;
	
	private int nivel;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCaptura() {
		return dataCaptura;
	}

	public void setDataCaptura(Calendar dataCaptura) {
		this.dataCaptura = dataCaptura;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
}
