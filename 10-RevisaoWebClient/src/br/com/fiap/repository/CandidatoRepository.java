package br.com.fiap.repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;

import br.com.fiap.entity.Candidato;

public class CandidatoRepository {

	public void cadastrar(Candidato candidato) throws Exception{
		URL url = new URL("http://localhost:8080/09-RevisaoWS/rest/candidato");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json");
		con.setRequestProperty("charset", "UTF-8");
		
		con.setDoOutput(true);
		
		OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream());
		out.write(new Gson().toJson(candidato));
		out.close();
		
		int resposta = con.getResponseCode();
		
		if (resposta != 201){
			throw new Exception("Erro");
		}
	}
	
	public List<Candidato> listar() throws Exception{
		URL url = new URL("http://localhost:8080/09-RevisaoWS/rest/candidato");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		
		con.setRequestMethod("GET");
		con.setRequestProperty("Accept", "application/json");
		con.setRequestProperty("charset", "UTF-8");
		
		int resposta = con.getResponseCode();
		
		if (resposta == 200){
			StringBuilder json = new StringBuilder();
			String linha;
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(con.getInputStream()));
			
			while ((linha = reader.readLine()) != null){
				json.append(linha);
			}
			
			//return  Arrays.asList(new Gson().fromJson(json.toString(), Candidato[].class));
			
			return new LinkedList<Candidato>(
				Arrays.asList(new Gson().fromJson(json.toString(), Candidato[].class)));
		}
		return null;
	}
	
}
