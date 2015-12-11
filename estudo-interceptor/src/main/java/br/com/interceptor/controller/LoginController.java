package br.com.interceptor.controller;

import javax.inject.Inject;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.security.AuthorizationRestrictionListener;
import br.com.caelum.vraptor.validator.I18nMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.interceptor.model.RegistroDeUsuarios;
import br.com.interceptor.model.Usuario;
import br.com.interceptor.producer.UsuarioLogado;

@Controller
public class LoginController implements AuthorizationRestrictionListener{
	
	@Inject
	private RegistroDeUsuarios usuarios;
	@Inject
	private UsuarioLogado logado;
	@Inject
	private Result result;
	@Inject
	private Validator validator;
	
	@Get("/")
	public void formulario(){}
	
	@Post("/login")
	@RequiresAuthentication
	public void login(String login, String senha){
		result.redirectTo(LivrosController.class).lista();
		Usuario usuario = usuarios.comLoginESenha(login, senha);
		validator.ensure(usuario != null, new I18nMessage("usuario", "login.ou.senha.invalidos"));
		
		validator.onErrorRedirectTo(this).formulario();
		
		logado.loga(usuario);
		
	}
	
	@Get("/logout")
	public void logout(){
		logado.desloga();
		result.redirectTo(this).formulario();
	}

	@Override
	public void onAuthorizationRestriction(AuthorizationException e) {
		result.include("error", e.toString());
		result.redirectTo(this).formulario();
	}
}
