package br.com.droid.webservice;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;
import br.com.droid.model.Camera;
import br.com.droid.model.Login;

public class CadastrarService {
	
	private final String URL = "http://10.0.108.76:8080/rest-server/imagemEmail";

	public void salvar(Login login) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = null;
		HttpResponse response = null;
		try {
			httpPost = new HttpPost(new URI(URL));
			httpPost.setHeader("Content-type", "application/json");
			StringEntity sEntity = new StringEntity(convertJson(login), "UTF-8");
			httpPost.setEntity(sEntity);
			
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		 
		  String result = null;
		  InputStream instream = null;
		 
		  try {
		    response = httpclient.execute(httpPost);
		    HttpEntity entity = response.getEntity();
		 
		    if (entity != null) {
		      instream = entity.getContent();
		      result = convertStreamToString(instream);
		    }
		 
		  } catch (Exception e) {
			  e.printStackTrace();
		  } finally {
		    if (instream != null) {
		      try {
		        instream.close();
		      } catch (Exception exc) {
		 
		      }
		    }
		  }
		  
	}
	
	public void enviarImagem(Camera camera) {
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = null;
		HttpResponse response = null;
		try {
			httpPost = new HttpPost(new URI(URL));
			httpPost.setHeader("Content-type", "application/json");
			StringEntity sEntity = new StringEntity(convertCameraToJson(camera), "UTF-8");
			httpPost.setEntity(sEntity);
			
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		 
		  String result = null;
		  InputStream instream = null;
		 
		  try {
		    response = httpclient.execute(httpPost);
		    HttpEntity entity = response.getEntity();
		 
		    if (entity != null) {
		      instream = entity.getContent();
		      result = convertStreamToString(instream);
		    }
		 
		  } catch (Exception e) {
			  e.printStackTrace();
		  } finally {
		    if (instream != null) {
		      try {
		        instream.close();
		      } catch (Exception exc) {
		 
		      }
		    }
		  }
		  
	}
	
	private String convertCameraToJson(Camera camera){
		String img = Base64.encodeToString(camera.getImagem(), Base64.DEFAULT);
		
		JSONObject obj = new JSONObject();
		try{
			obj.put("imagem", img);
		}catch(JSONException e){
			e.printStackTrace();
		}
		return obj.toString();
	}
	
	private String convertJson(Login login){
		JSONObject obj = new JSONObject();
		try {
			obj.put("usuario", login.getUsuario());
			obj.put("senha", login.getSenha());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj.toString();
	}
	
	public String convertStreamToString(InputStream is) {
		  BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		  StringBuilder sb = new StringBuilder();
		  String line = null;
		 
		  try {
		    while ((line = reader.readLine()) != null) {
		      sb.append(line + "\n");
		    }
		  } catch (IOException e) {
		  } finally {
		    try {
		      is.close();
		    } catch (IOException e) {
		    }
		  }
		 
		  return sb.toString();
		}	

}
