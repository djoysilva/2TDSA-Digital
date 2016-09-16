package br.com.fiap.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.List;
import com.google.gson.Gson;
import br.com.fiap.to.DadosPessoa;
import br.com.fiap.to.Documentos;

public class DadosPessoaRepository {
	
	//inglasentsedyseentiongly
	//a35ccdd3a8d8f6acf79034eda68faf54732f8e2b

	//Enviar os dados do dispositivo
	public void cadastrar(DadosPessoa dados) throws Exception{
		URL url = new URL("http://a2900c1d-1506-462d-9fa1-6332e83c3161-bluemix.cloudant.com/dados-pessoa/");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("charset", "utf-8");
		
		//Autorização
		String usuario = "inglasentsedyseentiongly";
		String senha = "a35ccdd3a8d8f6acf79034eda68faf54732f8e2b";
		String encodePass = usuario + ":" + senha;
		String encode = Base64.getEncoder().encodeToString(encodePass.getBytes());
		
		con.setRequestProperty("Authorization", "Basic " + encode);
		
		con.setDoOutput(true);
		
		OutputStreamWriter writer = new OutputStreamWriter(con.getOutputStream());
		writer.write(new Gson().toJson(dados));
		writer.close();
		
		int status = con.getResponseCode();
		
		if (status != 201){
			throw new Exception("Erro!");
		}
	}
	
	//Buscar dados do dispositivo de uma pessoa
	public List<DadosPessoa> buscar(int dispositivo) throws Exception{
		
		URL url = new URL("http://a2900c1d-1506-462d-9fa1-6332e83c3161-bluemix.cloudant.com/dados-pessoa/_find");
		HttpURLConnection con = 
				(HttpURLConnection) url.openConnection();
		
		//Configurações da requisição
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("charset", "utf-8");
		
		//Autorização
		String usuario = "inglasentsedyseentiongly";
		String senha = "a35ccdd3a8d8f6acf79034eda68faf54732f8e2b";
		String encodePass = usuario + ":" + senha;
		String encode = Base64.getEncoder().encodeToString(encodePass.getBytes());
		
		con.setRequestProperty("Authorization", "Basic " + encode);
		
		String sql = "{\"selector\" : { \"dispositivo\" :  "
				+dispositivo+" }, \"sort\" : "
					+ "[ { \"dispositivo\" : \"desc\" } ] }";
	
		//Coloca o SQL na conexão
		con.setDoOutput(true);
		OutputStreamWriter writer = 
				new OutputStreamWriter(con.getOutputStream());
		writer.write(sql);
		writer.close();
		
		int statusHttp = con.getResponseCode();
		
		if (statusHttp == 200){
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			StringBuilder builder = new StringBuilder();
			String linha;
			
			while ((linha = reader.readLine()) != null){
				builder.append(linha);
			}
			
			//Transformar o JSON no objeto java
			Documentos doc = 
				new Gson().fromJson(builder.toString(),
											Documentos.class);
			//System.out.println(builder.toString());
			//Retorna a lista de DadosPessoa
			return doc.getDocs();
		}
		return null;
	}
	
}






