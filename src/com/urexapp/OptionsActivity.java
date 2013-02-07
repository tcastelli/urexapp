/********************************
/* OGMA BETA 0.2 
/* AUTOR: ANTONIO CASTELLI LLINAS
 * NIA : 146696
 ********************************/





package com.urexapp;


import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;

import com.urexapp.R;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class OptionsActivity extends Activity {

	private Button genpass;
	private Button unsubs;
	private Button about;
	private Context context = this;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab3);  

		unsubs = (Button)findViewById(R.id.unsubs);
		genpass = (Button)findViewById(R.id.genpas);
		about = (Button)findViewById(R.id.about);

		genpass.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.popup);
				dialog.setTitle("¡Nueva contraseña!");
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(new BigInteger(130, new SecureRandom()).toString(32));
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				
				dialogButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();

					}

				});

				dialog.show();

			}	

		});

		about.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {

				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.popup);
				dialog.setTitle("Ogma 0.2");
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(Html.fromHtml("<center>Toni Castelli - 146696 <br> 2012</center>"));
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				dialogButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();

					}

				});

				dialog.show();

			}	

		});

		unsubs.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.popup);
				dialog.setTitle("Subscripción eliminada");
				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText(Html.fromHtml("Tus datos se han eliminado correctamente del servidor"));
				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				dialogButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();

					}

				});

				dialog.show();

			}	

		});


	}





}
