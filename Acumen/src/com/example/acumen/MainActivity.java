package com.example.acumen;

import com.google.gson.Gson;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.com.droid.model.Login;
import br.com.droid.webservice.LoginService;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		 StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
	                .permitAll().build();
	        StrictMode.setThreadPolicy(policy);
		
		Button btnRest = (Button)findViewById(R.id.btnRest);
		final TextView txtResultado = (TextView) findViewById(R.id.textView1);
		
		btnRest.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//ClienteREST rest = new ClienteREST();
				
				//Login login = rest.getLogin();
				LoginService ls = new LoginService();
				Login login = ls.requestContent();
				txtResultado.setText(login.getUsuario());
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
