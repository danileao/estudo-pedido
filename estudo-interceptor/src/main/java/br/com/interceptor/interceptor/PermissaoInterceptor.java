package br.com.interceptor.interceptor;

import javax.inject.Inject;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;

import br.com.caelum.vraptor.InterceptionException;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.core.InterceptorStack;
import br.com.caelum.vraptor.interceptor.Interceptor;
import br.com.interceptor.annotation.Permissao;
import br.com.interceptor.annotation.Public;
import br.com.interceptor.producer.UsuarioLogado;

@Intercepts
public class PermissaoInterceptor implements Interceptor {

	@Inject
	private Result result;
	private UsuarioLogado usuario;
	
	@Override
	public void intercept(InterceptorStack stack, ControllerMethod method, Object controllerInstance)
			throws InterceptionException {
		Permissao methodPermissao = method.getMethod().getAnnotation(Permissao.class);
		Permissao controllerPermissao = method.getController().getType().getAnnotation(Permissao.class);
		
	}

	@Override
	public boolean accepts(ControllerMethod method) {
		return !(method.getMethod().isAnnotationPresent(Public.class) || method.getController().getType().isAnnotationPresent(Public.class));
	}

}
