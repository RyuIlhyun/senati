package com.example.senati;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends Activity {

	MySQLiteOpenHelper helper;
	SQLiteDatabase db;
	
	TextView text;
	ListView list_view;
	MyAdapter adapter;
	ArrayList<TWord> al = new ArrayList<TWord>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		
		text = (TextView)findViewById(R.id.header_home_btn);
		text.setOnClickListener(mHomeListener);
		
		text = (TextView)findViewById(R.id.header_list_btn);
		text.setOnClickListener(mListListener);
		
		text = (TextView)findViewById(R.id.header_set_btn);
		text.setOnClickListener(mSetListener);
		
		list_view = (ListView)findViewById(R.id.listView1);
		
		helper = new MySQLiteOpenHelper(ListActivity.this, "basic_jwords.db", null, 1);
		al.clear();
		select();
		adapter = new MyAdapter(ListActivity.this, al, R.layout.list_row);
		
		
				/*
				if(adapter.getCount()<10) {
					helper.insert(helper, "鼻", "nose", "코", "はな", "び");
					helper.insert(helper, "足", "leg", "다리", "あし", "そく");
					helper.insert(helper, "腕", "arm", "팔", "うで", "わん");
					helper.insert(helper, "指", "finger", "손가락", "ゆび", "し");
					helper.insert(helper, "胸", "chest", "가슴", "むね", "きょう");
					helper.insert(helper, "首", "neck", "목", "くび", "しゅ");
					helper.insert(helper, "腹", "stomach", "배", "はら", "ふく");
					helper.insert(helper, "目", "eye", "눈", "め", "もく、ぼく");
				}
				*/

		
		list_view.setAdapter(adapter);
	}

	private void select() {
		db = helper.getReadableDatabase();
		Cursor c = db.query("t_word", null, null, null, null, null, null);
		
		while (c.moveToNext()){
			int _id = c.getInt(c.getColumnIndex("_id"));
			String name_j = c.getString(c.getColumnIndex("name_j"));
			String name_e = c.getString(c.getColumnIndex("name_e"));
			String name_k = c.getString(c.getColumnIndex("name_k"));
			String detail_e = c.getString(c.getColumnIndex("detail_e"));
			String detail_k = c.getString(c.getColumnIndex("detail_k"));
			int flg1 = c.getInt(c.getColumnIndex("flg1"));
			int flg2 = c.getInt(c.getColumnIndex("flg2"));
			
			Log.d("DB", _id + "/" + name_j + "/" + name_e + "/" + name_k + "/" + detail_e + "/" + detail_k + "/" + flg1 + "/" + flg2);
			
			TWord tw = new TWord();
			tw._id = _id;
			tw.name_j = name_j;
			tw.name_e = name_e;
			tw.name_k = name_k;
			tw.detail_e = detail_e;
			tw.detail_k = detail_k;
			tw.flg1 = flg1;
			tw.flg2 = flg2;
			al.add(tw);			
		}
		
		c.close();
		db.close();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	View.OnClickListener mHomeListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(ListActivity.this, MainActivity.class);
			startActivity(intent);
		}
		
	};
	
	View.OnClickListener mListListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	View.OnClickListener mSetListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	

}
