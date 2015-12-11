package br.com.droid.webservice;

import com.google.gson.Gson;

import br.com.droid.model.Login;

public class ClienteREST {

    private static final String URL_WS = "http://localhost:8080/rest-server/";
    
    public Login getLogin(){
    	String[] resposta = new WebServiceCliente().get(URL_WS+"login");
    	
    	if(resposta[0].equals("200")){
    		Gson gson = new Gson();
    		Login login = gson.fromJson(resposta[1],Login.class);
    		return login;
    	}
    	return null;
    	
    }

}
