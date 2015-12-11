package br.com.interceptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.interceptor.controller.LoginController;
import br.com.interceptor.producer.UsuarioLogado;

@Intercepts
public class AutenticacaoInterceptor {

	@Inject
	private UsuarioLogado usuario;
	
	@Inject
	private Result result;
	
	@AroundCall
	public void autentica(SimpleInterceptorStack stack){
		if(usuario.isLogado()){
			stack.next();
		}else{
			result.redirectTo(LoginController.class).formulario();
		}
	}
	
	@Accepts
	public boolean ehRestrito(ControllerMethod method){
		return !method.getController().getType().equals(LoginController.class);
	}
}
