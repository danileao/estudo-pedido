package br.com.foto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {
	
	final Context contexto = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button btnEntrar = (Button)findViewById(R.id.btnEntrar);
		
		
		btnEntrar.setOnClickListener(entrarListener);
	}
	
	private OnClickListener entrarListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			TextView user = (TextView) findViewById(R.id.txtUsuario);
			TextView senha = (TextView) findViewById(R.id.txtSenha);
			
			if(user.getText().toString().equals("admin") && senha.getText().toString().equals("admin")){
				Intent intent = new Intent();
				intent.setClass(LoginActivity.this, FotoActivity.class);
				startActivity(intent);
				finish();
			}else{
				AlertDialog.Builder alerta = new AlertDialog.Builder(contexto);
				alerta.setTitle("Login incorreto");
				alerta.setMessage("Usuário ou senha incorreta")
				.setCancelable(false)
				.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
				
				AlertDialog alertDialog = alerta.create();
				alertDialog.show();
			}

		}
	};

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
