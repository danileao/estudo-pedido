package br.com.interceptor.interceptor;

import java.io.IOException;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import br.com.interceptor.producer.UsuarioLogado;

public class PermissaoHelper extends SimpleTagSupport{
	@Inject
	private UsuarioLogado usuario;
	private String message;

	   public void setMessage(String msg) {
	      this.message = msg;
	   }

	   StringWriter sw = new StringWriter();

	   public void doTag() throws JspException, IOException {
		   if(usuario.getUsuario().isAdmin()){
			   JspWriter out = getJspContext().getOut();
		       out.println( message );
		   }
//	       else {
//	          /* use message from the body */
//	          getJspBody().invoke(sw);
//	          getJspContext().getOut().println(sw.toString());
//	       }
	   }
	   
	   public String verificarQualPermissao(String param1){
		   System.out.println(param1);
		   return param1;
	   }

}
