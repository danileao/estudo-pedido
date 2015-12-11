package br.com.foto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Base64;

public class WebService {
	public String chamarURL(String URL, String json) throws JSONException, UnsupportedEncodingException{
		@SuppressWarnings({ "deprecation", "resource" })
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = null;
		HttpResponse response = null;
		try {
			httpPost = new HttpPost(new URI(URL));
			
			StringEntity sEntity = new StringEntity(json, HTTP.UTF_8);
			sEntity.setContentType("application/json");
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

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (instream != null) {
				try {
					instream.close();
				} catch (Exception exc) {
					exc.printStackTrace();
				}
			}
		}
		return result;
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
	
	private String convertDespesaToJson(byte[] recibo){
		String img = Base64.encodeToString(recibo, Base64.DEFAULT);
		
		JSONObject obj = new JSONObject();
		try{
			obj.put("recibo", img);
			
		}catch(JSONException e){
			e.printStackTrace();
		}
		return obj.toString();
	}

}
