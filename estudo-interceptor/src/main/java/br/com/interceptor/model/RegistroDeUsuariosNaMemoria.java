package br.com.interceptor.model;

import java.util.Set;

public class RegistroDeUsuariosNaMemoria implements RegistroDeUsuarios{
	
	private Usuario usuario;
	
	public RegistroDeUsuariosNaMemoria() {
		usuario = new Usuario();
		usuario.setLogin("root");
		usuario.setSenha("root");
		usuario.setAdmin(true);
	}
	@Override
	public Usuario comLoginESenha(String login, String senha) {
		return login.equals(usuario.getLogin()) && senha.equals(usuario.getSenha()) ? usuario : null;
	}

	@Override
	public Set<String> listaPermissoesPorPerfil(String role) {
		return null;
	}

	@Override
	public Set<String> listaPerfisPorLogin(String login) {
		return null;
	}
	@Override
	public Usuario comLogin(String username) {
		return username.equals(usuario.getSenha()) ? usuario : null;
	}

}
