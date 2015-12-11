package br.com.interceptor.controller;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;

@Controller
public class LivrosController {

	@Path("/livro/lista")
	public void lista() {
		
	}
	
	@Path("/livro/cadastro")
	public void cadastro(){}

}
