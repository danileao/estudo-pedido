package com.example.acumen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import br.com.droid.model.Login;
import br.com.droid.webservice.CadastrarService;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
	                .permitAll().build();
	    StrictMode.setThreadPolicy(policy);
		
		Button btnEntrar = (Button) findViewById(R.id.btnEntrar);
		Button btnCamera = (Button) findViewById(R.id.btnCamera);
		final TextView txtUsuario = (TextView) findViewById(R.id.txtUser);
		final TextView txtSenha = (TextView) findViewById(R.id.txtSenha);
		
		btnEntrar.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Login login = new Login();
				login.setSenha(txtSenha.getText().toString());
				login.setUsuario(txtUsuario.getText().toString());
				
				CadastrarService cad = new CadastrarService();
				cad.salvar(login);
			}
		});
		
		btnCamera.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent,1);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
