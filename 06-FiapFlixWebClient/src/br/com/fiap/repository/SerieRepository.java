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

import br.com.fiap.entity.Serie;

public class SerieRepository {

	public void remover(int id) {
		URL url;
		try {
			url = new URL("http://localhost:8080/" 
					+ "03-FiapFlix/rest/serie/"+id);
			HttpURLConnection connection = 
					(HttpURLConnection) url.openConnection();
			
			connection.setRequestMethod("DELETE");
			
			int status = connection.getResponseCode();
			
			if (status != 200){
				throw new Exception("Erro!");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void atualizar(Serie serie) {
		try {
			URL url = new URL("http://localhost:8080/" + "03-FiapFlix/rest/serie/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Configura o request
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("charset", "utf-8");
			// Configura o tipo de dados que será enviado
			connection.setRequestProperty("Content-Type", "application/json");
			// Habilita a escrita no output da conexão
			connection.setDoOutput(true);

			// Mandar o JSON para o servidor
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(new Gson().toJson(serie));
			writer.close();

			// Valida a resposta do servidor
			int statusHttp = connection.getResponseCode();

			// 200 -> Created
			if (statusHttp != 200) {
				throw new Exception("Erro");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cadastrar(Serie serie) throws Exception {
		
			URL url = new URL("http://localhost:8080/" + "03-FiapFlix/rest/serie/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Configura o request
			connection.setRequestMethod("POST");
			connection.setRequestProperty("charset", "utf-8");
			// Configura o tipo de dados que será enviado
			connection.setRequestProperty("Content-Type", "application/json");
			// Habilita a escrita no output da conexão
			connection.setDoOutput(true);

			// Mandar o JSON para o servidor
			OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
			writer.write(new Gson().toJson(serie));
			writer.close();

			// Valida a resposta do servidor
			int statusHttp = connection.getResponseCode();

			// 201 -> Created
			if (statusHttp != 201) {
				throw new Exception("Erro");
			}
	}

	public List<Serie> listar() throws Exception {

		try {
			URL url = new URL("http://localhost:8080/" + "03-FiapFlix/rest/serie/");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Configura as propriedades da requisição
			connection.setRequestMethod("GET");
			connection.setRequestProperty("charset", "utf-8");

			// Manda a requisição do servidor e pega o retorno
			int httpCode = connection.getResponseCode();

			// Valida se está ok
			if (httpCode == 200) {
				// Recupera o JSON
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder builder = new StringBuilder();
				String linha;

				while ((linha = reader.readLine()) != null) {
					builder.append(linha);
				}

				// Transformar o JSON no Serie[]
				Serie[] array = new Gson().fromJson(builder.toString(), Serie[].class);
				// Transformar o vetor na Collection List
				return new LinkedList<Serie>(Arrays.asList(array));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		throw new Exception();

	}

	public Serie buscar(int codigo) throws Exception {

		try {
			// Criar a URL com o endereço do serviço web
			URL url = new URL("http://localhost:8080/03-FiapFlix/rest/serie/" + codigo);

			HttpURLConnection client = (HttpURLConnection) url.openConnection();

			// Configura o método da requisição e o enconding
			client.setRequestMethod("GET");
			client.setRequestProperty("charset", "utf-8");

			// Recupera o código HTTP
			int httpCode = client.getResponseCode();

			// Valida o status HTTP 200 OK
			if (httpCode == 200) {
				// Ler a resposta (JSON)
				BufferedReader buffer = new BufferedReader(new InputStreamReader(client.getInputStream()));

				// StringBuilder para armazenar o JSON
				StringBuilder builder = new StringBuilder();

				String linha;
				while ((linha = buffer.readLine()) != null) {
					builder.append(linha);
				}

				// Transformar o JSON em um objeto do tipo Serie
				return new Gson().fromJson(builder.toString(), Serie.class);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new Exception("Errou");
	}

}
