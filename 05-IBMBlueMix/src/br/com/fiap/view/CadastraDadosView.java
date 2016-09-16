package br.com.fiap.view;

import java.util.Date;

import br.com.fiap.repository.DadosPessoaRepository;
import br.com.fiap.to.DadosPessoa;

public class CadastraDadosView {

	public static void main(String[] args) throws Exception {
		DadosPessoaRepository rep = new DadosPessoaRepository();
		
		DadosPessoa dados = new DadosPessoa(2, 80, 
				"15/10", new Date().getTime() ,35.6f);
		
		rep.cadastrar(dados);
		System.out.println("Cadastrado!");
	}
	
}
