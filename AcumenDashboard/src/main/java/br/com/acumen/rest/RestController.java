package br.com.acumen.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import br.com.acumen.DAO.DAOException;
import br.com.acumen.DAO.ReciboDAO;
import br.com.acumen.model.CategoriaEnum;
import br.com.acumen.model.CentroCustoEnum;
import br.com.acumen.model.Recibo;
import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Controller
public class RestController {
	
	private static final String FROM = "dani.leao89@gmail.com";
	private static final String USUARIO = "dani.leao89";
	private static final String SENHA = "doug02es87";
	
	@Inject
	private Result result;
	
	@Inject
	private ReciboDAO reciboDAO;
	
	@Post("/enviarRecibo")
	@Consumes("application/json")
	public void enviarRecibo(String recibo, String centroCusto, String usuario, String valor, String categoria) throws DAOException{
		if(recibo != null){
			result.use(Results.json()).from("success").serialize();
			byte[] arquivo = Base64.decodeBase64(recibo);
			File file = new File("/home/daniele/Programação/imagem.JPEG");
			try {
				FileOutputStream in = new FileOutputStream(file);
				in.write(arquivo);
				in.close();
				
				enviarAnexo(file, centroCusto, usuario, categoria, valor);
				
				 Recibo reciboClass = new Recibo();
				 reciboClass.setCategoria(CategoriaEnum.valueOf(categoria).toString());
				 reciboClass.setCentroCusto(CentroCustoEnum.valueOf(centroCusto).toString());
				 reciboClass.setDataEnvio(new Date());
				 reciboClass.setImagem(arquivo);
				 reciboClass.setUsuario(usuario);
				 reciboClass.setValor(valor);
				 
				 reciboDAO.insert(reciboClass);
				 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			result.use(Results.json()).from("erro").serialize();
		}
	}

	public void enviarAnexo(File file, String centroCusto, String usuario, String categoria, String valor){
		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setHostName( "smtp.gmail.com" );
		
		email.setAuthenticator( new DefaultAuthenticator( USUARIO ,  SENHA ) );
		try {
		    
			email.setFrom( FROM);
		    email.setSubject( "Recebo - Acumen" );
		    email.setDebug(true);
		    
		    EmailAttachment anexo = new EmailAttachment();
		    anexo.setPath(file.getPath());
		    anexo.setDisposition(EmailAttachment.ATTACHMENT);
		    anexo.setName("imagem.JPEG");
		    SimpleDateFormat fmtDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		    
		    String msg = ("<h2>RECIBO DE DESPESAS </h2>");
			msg += ("<h3> Usuário: " + usuario           + "</h3>");
			msg += ("<h3> Centro de Custo: " + centroCusto           + "</h3>");
			msg += ("<h3> Categoria: " + categoria           + "</h3>");
			msg += ("<h3> Valor: R$" + valor           + "</h3>");
			msg += ("<h3> Data: " + fmtDate.format(new Date())           + "</h3>");
			
		     
		    email.setHtmlMsg( msg  );
		     
		    email.addTo( new String[]{"acumen.client@gmail.com"} );
		     
		    email.send();
		     
		} catch (EmailException e) {
		    e.printStackTrace();
		} 
	}
	
}
