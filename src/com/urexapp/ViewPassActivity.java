/********************************
/* OGMA BETA 0.2 
/* AUTOR: ANTONIO CASTELLI LLINAS
 * NIA : 146696
 ********************************/

package com.urexapp;

import com.urexapp.R;
import com.urexapp.RowData;

import android.app.Activity;
import android.app.Dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;

import android.view.View;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import android.widget.TextView;


public class ViewPassActivity extends Activity {
	Button ok;
	private Context context=this;
	private String array_spinner[];


	public void onCreate(Bundle savedInstanceState) {
		

		super.onCreate(savedInstanceState);
		setContentView(R.layout.form);
	

		// Here come all the options that you wish to show depending on the
		// size of the array.
		array_spinner=new String[AddWebActivity.titles.length];
		for (int i=0; i<AddWebActivity.titles.length;i++){
			array_spinner[i]=AddWebActivity.titles[i];
		}
		final Spinner s = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
		android.R.layout.simple_spinner_item, array_spinner);
		s.setAdapter(adapter);
		
		
		if (AddWebActivity.selected >=0){
			s.setSelection(AddWebActivity.selected);
			s.setEnabled(false);
		}
		
		ok = (Button)findViewById(R.id.confirmar);

		ok.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				if (AddWebActivity.selected==-1){
					
					RowData a = new RowData(-1,(String)s.getSelectedItem());
					AddWebActivity.insert(a);
					
				}
				
				
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.popup);
				dialog.setTitle("¡Grabación finalizada!");
				

				TextView text = (TextView) dialog.findViewById(R.id.text);
				text.setText("Datos actualizados correctamente");

				Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
				
				dialog.setOnDismissListener(new OnDismissListener() {
					
					@Override
					public void onDismiss(DialogInterface dialog) {
					   
						
						
						finish();
						
					}
				});
				dialogButton.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						dialog.dismiss();
						
						finish();

					}


				});
				dialog.show();
				
			}


		});
		
		
		
	}
	

	

	

}


