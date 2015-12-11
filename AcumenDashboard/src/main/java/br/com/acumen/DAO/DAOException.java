package br.com.acumen.DAO;

public class DAOException extends Exception {

	private static final long serialVersionUID = -5216216774584510621L;

	public DAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(Throwable cause) {
		super(cause);
	}
	
}