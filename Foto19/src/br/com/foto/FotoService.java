package br.com.foto;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;

public class FotoService {
	
private final String URL = "http://10.0.108.69:8080/AcumenDashboard/";
	
	
	public String enviarRecibo(byte[] recibo, String centroCusto, String valor, String categoria){
		WebService web = new WebService();
		String chamarURL = "";
		try {
			
			JSONObject obj = new JSONObject();
			obj.put("recibo", Base64.encodeToString(recibo, Base64.DEFAULT));
			obj.put("centroCusto", centroCusto);
			obj.put("usuario", "José Carlos");
			obj.put("categoria", categoria);
			obj.put("valor", valor);
			 chamarURL = web.chamarURL(URL+"enviarRecibo", obj.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return chamarURL;
	}

}
