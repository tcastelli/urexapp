/********************************
/* OGMA BETA 0.2 
/* AUTOR: ANTONIO CASTELLI LLINAS
 * NIA : 146696
 ********************************/

package com.urexapp;


import android.app.Activity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TabHost;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
	@Override
	  public void onCreate(Bundle icicle) {
		 

		super.onCreate(icicle);
		Intent tab = new Intent(this,MainTabActivity.class);
		startActivity(tab);
		finish();
	}
    
}
