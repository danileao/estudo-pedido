package br.com.acumen.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.acumen.DAO.DAOException;
import br.com.acumen.DAO.ReciboDAO;
import br.com.acumen.model.Recibo;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;

@Controller
public class RelatorioController {
	
	@Inject
	private Result result;
	
	@Inject
	private ReciboDAO reciboDAO;

	
	@Path("/relatorio")
	public void relatorio(){}
	
	@Path("/recibos")
	public void recibos() throws DAOException{
		List<Recibo> recibos = reciboDAO.list();
		result.include("recibos", recibos);
	}
}
