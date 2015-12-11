package br.com.acumen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.acumen.util.BaseEntity;

@Table(name = "RECIBO" ,schema="acumen")
@Entity
public class Recibo implements BaseEntity<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "valor")
	private String valor;
	
	@Column(name = "categoria")
	private String categoria;
	
	@Column(name = "centro_custo")
	private String centroCusto;
	
	@Column(name = "data_envio")
	@Temporal(TemporalType.DATE)
	private Date dataEnvio;
	
	@Column(name = "imagem")
	private byte[] imagem;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getCentroCusto() {
		return centroCusto;
	}
	public void setCentroCusto(String centroCusto) {
		this.centroCusto = centroCusto;
	}
	public Date getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public byte[] getImagem() {
		return imagem;
	}
	public void setImagem(byte[] bs) {
		this.imagem = bs;
	}
	
}
