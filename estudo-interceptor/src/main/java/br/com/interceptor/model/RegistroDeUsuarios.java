package br.com.interceptor.model;

import java.util.Set;

public interface RegistroDeUsuarios {

	public Usuario comLoginESenha(String login, String senha);
	Set<String> listaPermissoesPorPerfil(String role);
	Set<String> listaPerfisPorLogin(String login);
	public Usuario comLogin(String username);

}
