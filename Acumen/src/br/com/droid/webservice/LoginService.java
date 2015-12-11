package br.com.droid.webservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.droid.model.Login;

public class LoginService {
	private final String URL = "http://10.0.108.76:8080/rest-server/login";
	
	
	public Login requestContent() {
		  HttpClient httpclient = new DefaultHttpClient();
		  String result = null;
		  HttpGet httpget = new HttpGet(URL);
		  HttpResponse response = null;
		  InputStream instream = null;
		 
		  try {
		    response = httpclient.execute(httpget);
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
		  
		  try {
			JSONObject userOBJ = new JSONObject(result).getJSONObject("login");
			Login login = new Login();
			login.setUsuario(userOBJ.getString("usuario"));
			login.setSenha(userOBJ.getString("senha"));
			return login;
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		  return null;
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
