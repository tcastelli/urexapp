/********************************
/* OGMA BETA 0.2 
/* AUTOR: ANTONIO CASTELLI LLINAS
 * NIA : 146696
 ********************************/

package com.urexapp;

public class RowData {
	protected int mId;
	protected String mTitle;

	//protected String mDetail;
	RowData(int id,String title){
		mId=id;
		mTitle = title;

		//mDetail=detail;
	}
	

	@Override
	public String toString() {
		return mId+" "+mTitle;
	}
}