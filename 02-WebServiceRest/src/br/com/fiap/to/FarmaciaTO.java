package br.com.fiap.to;

public class FarmaciaTO {

	private int codigo;
	
	private String nome;
	
	private String endereco;
	
	private int franquias;
	
	private double valorInvestimento;
	
	public FarmaciaTO() {
		super();
	}

	public FarmaciaTO(int codigo, String nome, String endereco, int franquias, double valorInvestimento) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.franquias = franquias;
		this.valorInvestimento = valorInvestimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getFranquias() {
		return franquias;
	}

	public void setFranquias(int franquias) {
		this.franquias = franquias;
	}

	public double getValorInvestimento() {
		return valorInvestimento;
	}

	public void setValorInvestimento(double valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
}
