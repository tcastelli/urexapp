/********************************
/* OGMA BETA 0.2 
/* AUTOR: ANTONIO CASTELLI LLINAS
 * NIA : 146696
 ********************************/

package com.urexapp;


import java.util.ArrayList;
import java.util.List;
import com.urexapp.R;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.net.ParseException;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


public class SetGestureActivity extends ListActivity  {

	private Context context=this;
	private LayoutInflater mInflater;
	public static ArrayList<RowData> data;
	static RowData rd;
	Button addbuton;
	Button deletebutton;
	static CustomAdapter adapter;
	public static int selected;


	public static final String[] titles = new String[] {
		"aaaaaaaaaaaa", "bbbbbbbbbbbbb","cccccccccccccc","ddddd"    	
	};


	private Integer[] imgid = {
			R.drawable.news,R.drawable.news,R.drawable.news,
			R.drawable.news
	};

	public static void insert(RowData a){
		
		a.mId=(data.get(data.size()-1).mId)+1;
		data.add(a);
		adapter.notifyDataSetChanged();
	}




	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tab1);
		
		selected=-1;
		mInflater = (LayoutInflater) getSystemService(
				Activity.LAYOUT_INFLATER_SERVICE);

		addbuton = (Button)findViewById(R.id.addbutton);
		addbuton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				selected=-1;
				Intent in = new Intent(context,ViewPassActivity.class);
				startActivity(in);
				
			}
		});


		data = new ArrayList<RowData>();
		for(int i=0;i<titles.length;i++){

			try {
				rd = new RowData(i,titles[i]);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			data.add(rd);
		}
		adapter = new CustomAdapter(this, R.layout.list,
				R.id.title, data);
		setListAdapter(adapter);
		getListView().setTextFilterEnabled(true);
	}
	public void onListItemClick(ListView parent, View v, int position,
			long id) {        	

		//		Toast.makeText(getApplicationContext(), "You have selected "
		//				+(position+1)+"th item",  Toast.LENGTH_SHORT).show();

		
	}

	

	private class CustomAdapter extends ArrayAdapter<RowData> {

		public CustomAdapter(Context context, int resource,
				int textViewResourceId, List<RowData> objects) {               

			super(context, resource, textViewResourceId, objects);
		}
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {   

			ViewHolder holder = null;
			TextView title = null;
			//			TextView detail = null;
			ImageView i11=null;
			ImageButton b11=null;
			ImageButton b12=null;
			RowData rowData= getItem(position);
			if(null == convertView){
				convertView = mInflater.inflate(R.layout.list, null);
				holder = new ViewHolder(convertView);
				convertView.setTag(holder);
			}
			holder = (ViewHolder) convertView.getTag();
			title = holder.gettitle();
			title.setText(rowData.mTitle);
			//			detail = holder.getdetail();
			//			detail.setText(rowData.mDetail);                                                     

			i11=holder.getImage();
			
			for (int i=0; i<title.length(); i++){
				if (titles[i].equals(rowData.mTitle)){
					i11.setImageResource(imgid[i]);
					break;
				}
			}

			b11 = holder.getBoton1();
			b11.setBackgroundResource(R.drawable.ic_menu_edit);
			b11.setContentDescription("Edit");
			b11.setId(rowData.mId);

			b11.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					Intent ix = new Intent(context,ViewPassActivity.class);
					for (int i=0; i<data.size(); i++){
						if (data.get(i).mId == v.getId()){
							
							
							for (int j=0; j<AddWebActivity.titles.length; j++){
								if (AddWebActivity.titles[j].equalsIgnoreCase(data.get(i).mTitle)){
									selected=j;
									break;
									
								}
								
							}
							break;
							
						}
					}
					
					
					startActivity(ix);

				}
			});


			b12 = holder.getBoton2();
			b12.setBackgroundResource(R.drawable.ic_menu_delete);
			b12.setContentDescription("Delete");
			b12.setId(rowData.mId);
			b12.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					for (int i=0; i<data.size(); i++){
						if (data.get(i).mId == v.getId()){

							data.remove(i);
							break;
						}
					}
					adapter.notifyDataSetChanged();
				}



			});



			return convertView;
		}
		private class ViewHolder {
			private View mRow;
			private TextView title = null;
			//			private TextView detail = null;
			private ImageView i11=null; 
			private ImageButton b11=null;
			private ImageButton b12=null;


			public ViewHolder(View row) {
				mRow = row;
			}
			public TextView gettitle() {
				if(null == title){
					title = (TextView) mRow.findViewById(R.id.title);
				}
				return title;
			}     
			//
			//			public TextView getdetail() {
			//				if(null == detail){
			//					detail = (TextView) mRow.findViewById(R.id.detail);
			//				}
			//				return detail;
			//			}
			public ImageView getImage() {
				if(null == i11){
					i11 = (ImageView) mRow.findViewById(R.id.img);

				}
				return i11;
			}

			public ImageButton getBoton1(){

				if (null == b11){
					b11 = (ImageButton ) mRow.findViewById(R.id.button11);
				}
				return b11;

			}

			public ImageButton getBoton2(){

				if (null == b12){
					b12 = (ImageButton ) mRow.findViewById(R.id.button12);
				}
				return b12;

			}


		}
		
	} 
}