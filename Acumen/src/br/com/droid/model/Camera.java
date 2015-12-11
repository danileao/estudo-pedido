package br.com.droid.model;

public class Camera {
	
	private byte[] imagem;
	
	public Camera() {
	}
	
	public Camera(byte[] imagem){
		this.imagem = imagem;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

}
