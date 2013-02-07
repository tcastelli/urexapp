/********************************
/* OGMA BETA 0.2 
/* AUTOR: ANTONIO CASTELLI LLINAS
 * NIA : 146696
 ********************************/

package com.urexapp;

import com.urexapp.R;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;


public class MainTabActivity extends TabActivity {
	/** Called when the activity is first created. */	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		setTabs() ;
		getTabWidget().setCurrentTab(0);
		
	}
	private void setTabs()
	{
		addTab("News", R.drawable.tab_options, SetGestureActivity.class);
		addTab("Events", R.drawable.tab_options, AddWebActivity.class);						
		addTab("Messages", R.drawable.tab_options, OptionsActivity.class);
		addTab("Users", R.drawable.tab_options, UsersActivity.class);
		
		

		//To add more tabs just use addTab() method here like previous line.
	}
	
	private void addTab(String labelId, int drawableId, Class<?> c)
	{
		TabHost tabHost = getTabHost();
		Intent intent = new Intent(this, c);
		TabHost.TabSpec spec = tabHost.newTabSpec("tab" + labelId);	
		
		View tabIndicator = LayoutInflater.from(this).inflate(R.layout.tab_indicator, getTabWidget(), false);
		TextView title = (TextView) tabIndicator.findViewById(R.id.title);
		title.setText(labelId);
		ImageView icon = (ImageView) tabIndicator.findViewById(R.id.icon);
		icon.setImageResource(drawableId);
		
		spec.setIndicator(tabIndicator);
		spec.setContent(intent);
		tabHost.addTab(spec);
	}
}