package br.com.fiap.to;

public class DadosPessoa {

	private int dispositivo;
	
	private int batimento;
	
	private String pressao;
	
	private long timestamp;
	
	private float temperatura;

	public DadosPessoa() {
		super();
	}

	public DadosPessoa(int dispositivo, int batimento, String pressao, long timestamp, float temperatura) {
		super();
		this.dispositivo = dispositivo;
		this.batimento = batimento;
		this.pressao = pressao;
		this.timestamp = timestamp;
		this.temperatura = temperatura;
	}

	public int getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}

	public int getBatimento() {
		return batimento;
	}

	public void setBatimento(int batimento) {
		this.batimento = batimento;
	}

	public String getPressao() {
		return pressao;
	}

	public void setPressao(String pressao) {
		this.pressao = pressao;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public float getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(float temperatura) {
		this.temperatura = temperatura;
	}
	
}
