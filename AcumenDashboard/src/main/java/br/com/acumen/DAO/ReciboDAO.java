package br.com.acumen.DAO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.com.acumen.model.Recibo;

@Stateless
public class ReciboDAO extends DAO<Recibo, Long>{
	
	public ReciboDAO() {
		super(Recibo.class);
	}

	@Override
	public void setEntityManager(EntityManager em) {
		super.setInternalEntityManager(em);
	}

}
