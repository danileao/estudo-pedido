package com.example.acumen;

import java.io.ByteArrayOutputStream;
import java.io.File;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import br.com.droid.webservice.CadastrarService;

public class Camera extends Activity {
	
	private static String loglog = "Acumen";
	private static int TAKE_PICTURE = 1;
	private Uri imageUri;
	final Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
		
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
		StrictMode.setThreadPolicy(policy);
		
		Button cameraButton = (Button)findViewById(R.id.btn_camera);
		Button loginButton = (Button)findViewById(R.id.btn_login);
		
 		cameraButton.setOnClickListener(cameraListiner);
 		loginButton.setOnClickListener(loginListener);
		
	}
	
	private OnClickListener loginListener = new OnClickListener() {
		@Override
		public void onClick(View v) {
			
			EditText login = (EditText)findViewById(R.id.txtLogin);
			
			if(login.getText().toString().equals("dani")){
				Intent intent = new Intent();
				intent.setClass(Camera.this,MenuActivity.class);
				startActivity(intent);
				finish();
			}else{
				AlertDialog.Builder alert = new AlertDialog.Builder(context);
				alert.setTitle("Login incorreto");
				alert.setMessage("Seu usuário está incorreto")
					.setCancelable(false)
					.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which) {
							dialog.cancel();
						}
					});
				
				AlertDialog alertDialog = alert.create();
				alertDialog.show();
			}
			
		}
	};
	
	private OnClickListener cameraListiner = new OnClickListener() {
		@Override
		public void onClick(View v) {
			takePhoto(v);
		}
	};
	
	private void takePhoto(View v){
		Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
		File photo = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "picture.jpg");
		imageUri = Uri.fromFile(photo);
		intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
		
		startActivityForResult(intent, TAKE_PICTURE);
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent intent){
		super.onActivityResult(requestCode, resultCode, intent);
		
		if(resultCode == Activity.RESULT_OK){
			Uri selectedImage = imageUri;
			getContentResolver().notifyChange(selectedImage, null);
			
			ImageView imageView = (ImageView)findViewById(R.id.image_cd_camera);
			ContentResolver cr = getContentResolver();
			Bitmap bitmap;
			
			try{
				bitmap = MediaStore.Images.Media.getBitmap(cr, selectedImage);
				
				ByteArrayOutputStream stream = new ByteArrayOutputStream();
				bitmap.compress(Bitmap.CompressFormat.JPEG,100, stream);
				byte[] bitMapData = stream.toByteArray();

				CadastrarService cad = new CadastrarService();
				cad.enviarImagem(new br.com.droid.model.Camera(bitMapData));
				
				imageView.setImageBitmap(bitmap);
				Toast.makeText(Camera.this, selectedImage.toString(), Toast.LENGTH_LONG).show();
			}catch(Exception e){
				Log.e(loglog, e.toString());
			}
		}
	}
	
	public void enviarEmail(){
		Intent email = new Intent(Intent.ACTION_SEND);
		email.putExtra(Intent.EXTRA_EMAIL, new String[]{"dani.leao89@gmail.com"});
		email.putExtra(Intent.EXTRA_SUBJECT, "recibo");
		email.putExtra(Intent.EXTRA_TEXT, "Você recebeu um e-mail");
		email.setType("message/rfc822");
		startActivity(Intent.createChooser(email, "Escolher um programa para envio"));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camera, menu);
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
