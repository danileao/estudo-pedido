package br.com.foto;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FotoActivity extends Activity {

	private static final int TIRAR_FOTO = 1020394857;
	private Button btnIniciar;
	private ImageView imgFoto;
	private Uri imageUri;
	private Spinner spinner;
	private Spinner categoriaSpinner;
	final Context contexto = this;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foto);
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        
        addItemCentroCusto();
        addItemCategoria();
        
        btnIniciar = (Button)findViewById(R.id.btnFoto);
        imgFoto = (ImageView) findViewById(R.id.imageView1);
        btnIniciar.setOnClickListener(iniciarListener);
	}
	
	private void addItemCentroCusto() {
		spinner = (Spinner)findViewById(R.id.spinnerCentroCusto);
		List<String> centroCustos = new ArrayList<String>();
		centroCustos.add("Vendas01");
		centroCustos.add("Vendas02");
		centroCustos.add("Vendas03");
		centroCustos.add("Vendas04");
		centroCustos.add("Vendas05");
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, centroCustos);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(dataAdapter);
	}
	
	public void addItemCategoria(){
		categoriaSpinner = (Spinner) findViewById(R.id.spinnerCategoria);
		List<String> categorias = new ArrayList<String>();
		
		categorias.add("Hospedagem");
		categorias.add("Eventos");
		categorias.add("Alimentação");
		categorias.add("Transporte");
		categorias.add("Outros");
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categorias);
		categoriaSpinner.setAdapter(dataAdapter);
	}

	private OnClickListener iniciarListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
			File photo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "picture.jpg");
			imageUri = Uri.fromFile(photo);
			intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
			startActivityForResult(intent, TIRAR_FOTO);
		}
	};
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		if(requestCode == TIRAR_FOTO){
			if(resultCode == RESULT_OK){
				
				Uri selectedImage = imageUri;
				getContentResolver().notifyChange(selectedImage, null);
				
				ContentResolver cr =  getContentResolver();
				try {
					Bitmap bitmap = MediaStore.Images.Media.getBitmap(cr, selectedImage);
					
					ByteArrayOutputStream stream = new ByteArrayOutputStream();
					bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
					byte[] bitMapData = stream.toByteArray();
					spinner = (Spinner)findViewById(R.id.spinnerCentroCusto	);
					categoriaSpinner = (Spinner) findViewById(R.id.spinnerCategoria);
					
					String centroCusto = spinner.getSelectedItem().toString();
					String categoriaEscolhida = categoriaSpinner.getSelectedItem().toString();
					
					TextView valor = (TextView)findViewById(R.id.txtValor);
					
					FotoService fotoService = new FotoService();
					//String resultado = fotoService.enviarRecibo(bitMapData, centroCusto, valor.getText().toString(), categoriaEscolhida);
					String resultado = "sucesso";
					String msgRetorno;
					
					if(resultado.contains("success")){
						msgRetorno = "Recibo Enviado com sucesso";
						
					}else{
						msgRetorno = "Não foi possível enviar o Recibo. Verifique sua conexão";
					}
					
					AlertDialog.Builder alerta = new AlertDialog.Builder(contexto);
					alerta.setTitle("Envio Recibo");
					alerta.setMessage(msgRetorno)
					.setCancelable(false)
					.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
					});
					
					AlertDialog alertDialog = alerta.create();
					alertDialog.show();
		            
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else if (resultCode == RESULT_CANCELED) {//Cancelou a foto
                Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT);
            } else { //Saiu da Intent
                Toast.makeText(this, "Saiu", Toast.LENGTH_SHORT);
            }
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.foto, menu);
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
