package com.senapapa.baby2;

import java.util.ArrayList;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ListActivity extends Activity {

	MySQLiteOpenHelper helper;
	SQLiteDatabase db;
	
	ImageButton btn;
	TextView text;
	ListView list_view;
	MyAdapter adapter;
	ArrayList<TWord> al = new ArrayList<TWord>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list2);
		
		// Create the adView
	    AdView adView = new AdView(this, AdSize.BANNER, "a1530ea42bc175b");

	    // Lookup your LinearLayout assuming it's been given
	    // the attribute android:id="@+id/mainLayout"

	    RelativeLayout layout = (RelativeLayout)findViewById(R.id.adwrap);

	    // Add the adView to it
	    layout.addView(adView);
	    
	    // Create an ad request. Check logcat output for the hashed device ID to
	    // get test ads on a physical device.
	    AdRequest adRequest = new AdRequest();
	    adRequest.addTestDevice(AdRequest.TEST_EMULATOR);

	    // Initiate a generic request to load it with an ad
	    adView.loadAd(new AdRequest());
		
		/*
		text = (TextView)findViewById(R.id.header_home_btn);
		text.setOnClickListener(mHomeListener);
		
		text = (TextView)findViewById(R.id.header_list_btn);
		text.setOnClickListener(mListListener);
		
		text = (TextView)findViewById(R.id.header_set_btn);
		text.setOnClickListener(mSetListener);
		*/
		btn = (ImageButton)findViewById(R.id.imageButton5);
		btn.setOnClickListener(mHomeListener);
		
		list_view = (ListView)findViewById(R.id.listView1);
		
		helper = new MySQLiteOpenHelper(ListActivity.this, "basic_jwords_1.db", null, 1);
		al.clear();
		select();
		adapter = new MyAdapter(ListActivity.this, al, R.layout.list_row);
		
		
				/*
				if(adapter.getCount()<10) {
					helper.insert(helper, "é¼»", "nose", "??, "ã¯ãª", "ã³");
					helper.insert(helper, "è¶³", "leg", "?¤?¬", "ã‚ã—", "ãã");
					helper.insert(helper, "è…?, "arm", "ú¨?, "ã?§", "ã‚ã‚“");
					helper.insert(helper, "æŒ?, "finger", "?ê°?½", "ã‚??", "ã?);
					helper.insert(helper, "èƒ¸", "chest", "??Š´", "ã‚??", "ãã‚‡ã?);
					helper.insert(helper, "é¦?, "neck", "?©", "ãã?", "ã—ã‚…");
					helper.insert(helper, "è…¹", "stomach", "?°", "ã¯ã‚?, "ãµã?);
					helper.insert(helper, "ç›®", "eye", "??, "ã‚?, "ã‚‚ãã€ã¼ã?);
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
			String pron = c.getString(c.getColumnIndex("pron"));
			String read = c.getString(c.getColumnIndex("read"));
			String name_e = c.getString(c.getColumnIndex("name_e"));
			String name_k = c.getString(c.getColumnIndex("name_k"));
			int level = c.getInt(c.getColumnIndex("level"));
			String cate_j = c.getString(c.getColumnIndex("cate_j"));
			String cate_e = c.getString(c.getColumnIndex("cate_e"));
			String cate_k = c.getString(c.getColumnIndex("cate_k"));
			int flg1 = c.getInt(c.getColumnIndex("flg1"));
			int flg2 = c.getInt(c.getColumnIndex("flg2"));
			
			//Log.d("DB", _id + "/" + name_j + "/" + name_e + "/" + name_k + "/" + detail_e + "/" + detail_k + "/" + flg1 + "/" + flg2);
			
			TWord tw = new TWord();
			tw._id = _id;
			tw.name_j = name_j;
			tw.pron = pron;
			tw.read = read;
			tw.name_e = name_e;
			tw.name_k = name_k;
			tw.level = level;
			tw.cate_j = cate_j;
			tw.cate_e = cate_e;
			tw.cate_k = cate_k;
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
