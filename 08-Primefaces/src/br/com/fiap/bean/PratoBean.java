package br.com.fiap.bean;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import br.com.fiap.dao.PratoDAO;
import br.com.fiap.dao.impl.PratoDAOImpl;
import br.com.fiap.entity.Prato;
import br.com.fiap.exceptions.DBCommitException;
import br.com.fiap.singleton.EMFactorySingleton;

@ManagedBean
@SessionScoped
public class PratoBean {

	private PratoDAO dao;
	
	private Prato prato;
	
	@PostConstruct
	private void init(){
		dao = new PratoDAOImpl(EMFactorySingleton.getInstance());
		prato = new Prato();
	}
	
	//Exibe a foto 2 na página
	public StreamedContent getFoto2(){
		DefaultStreamedContent foto = new DefaultStreamedContent();
		foto.setContentType("image/jpg");
		if (prato.getFoto2() != null)
			foto.setStream(new ByteArrayInputStream(prato.getFoto2()));	
		return foto;
	}
	
	//Grava a foto no banco de dados
	public void subirFoto2(FileUploadEvent event){
		//Escreve o byte[] no atributo do prato
		try {
			prato.setFoto2(IOUtils.toByteArray(event.getFile().getInputstream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//Exibe a foto na página
	public StreamedContent getFoto(){
		DefaultStreamedContent foto = new DefaultStreamedContent();
		//Configura o tipo do arquivo
		foto.setContentType("image/jpg");
		try{
			if (prato.getFoto() != null){
				//Recupera a foto do disco
				foto.setStream(new FileInputStream("c://foto//" + prato.getFoto()));
			}else{
				foto.setStream(new FileInputStream("c://foto//semfoto.jpg"));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return foto;
	}

	//Método para gravar a foto
	public void subirFoto(FileUploadEvent event){
		//Cria um arquivo no diretório c:/foto com o mesmo nome do arrquivo do upload
		File arquivo = new File("C://foto//", event.getFile().getFileName() );
		try{
			//Gravar informação no arquivo
			FileOutputStream output = new FileOutputStream(arquivo);
			output.write(event.getFile().getContents());
			output.close();
			//Grava o nome do arquivo de imagem na entidade
			prato.setFoto(event.getFile().getFileName());
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void cadastrar(){
		FacesMessage msg;
		try {
			dao.insert(prato);
			msg = new FacesMessage("Cadastrado!");
			prato = new Prato();
		} catch (DBCommitException e) {
			e.printStackTrace();
			msg = new FacesMessage("Erro");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public Prato getPrato() {
		return prato;
	}

	public void setPrato(Prato prato) {
		this.prato = prato;
	}
	
}


