package br.com.interceptor.interceptor;

import javax.inject.Inject;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.view.Results;
import br.com.interceptor.controller.LoginController;
import br.com.interceptor.producer.UsuarioLogado;

@Intercepts(after = AutenticacaoInterceptor.class)
public class AutorizacaoInterceptor {

	@Inject
	private UsuarioLogado usuario;
	@Inject
	private Result result;

	@Accepts
	public boolean ehRestrito(ControllerMethod method){
		return !method.getController().getType().equals(LoginController.class);
	}
	
	@AroundCall
	public void autoriza(SimpleInterceptorStack stack, ControllerMethod method){
		if(podeAcessar(method)){
			stack.next();
		}else{
			result.use(Results.http()).sendError(401, "Você não tem permissão");
		}
	}

	private boolean podeAcessar(ControllerMethod method) {
		return method.containsAnnotation(Get.class) || usuario.getUsuario().isAdmin();
	}
	
}
