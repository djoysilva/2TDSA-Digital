package br.com.fiap.config;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

//Path para acesso a API rest
@ApplicationPath("rest")
public class ApplicationConfig extends ResourceConfig{

	public ApplicationConfig() {
		//Pacote das classes que implementam o ws rest
		packages("br.com.fiap.resource");
	}
	
}
