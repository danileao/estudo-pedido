package br.com.interceptor.interceptor;

import java.util.Collections;
import java.util.Set;

import javax.inject.Inject;

import br.com.caelum.vraptor.security.Permission;
import br.com.caelum.vraptor.security.User;
import br.com.interceptor.model.RegistroDeUsuarios;
import br.com.interceptor.model.Usuario;

public class Autorizador implements Permission{
	
	@Inject
	private RegistroDeUsuarios usuarios;

	@Override
	public User getUserByUsername(String username) {
		Usuario usuario = usuarios.comLogin(username);
		return new User(usuario.getLogin(), usuario.getSenha());
	}

	@Override
	public Set<String> getRolesByUser(String username) {
		Usuario usuario = usuarios.comLogin(username);
		if(usuario.isAdmin()){
			return Collections.singleton("admin");
		}else{
			return Collections.emptySet();
		}
	}

	@Override
	public Set<String> getPermissionsByRole(String role) {
		return null;
	}


}
