package com.example.senati;

import java.util.ArrayList;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.TextView;


public class DetailActivity extends Activity {

	MySQLiteOpenHelper helper;
	SQLiteDatabase db;
	
	ImageButton btn;
	TextView text;
	WebView wView;
	WebSettings wSettings;
	MyAdapter adapter;
	ArrayList<TWord> al = new ArrayList<TWord>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail);
		
		//Log.d("ih_test", "start Detail");
		
		Intent intent = getIntent();
		int wID = intent.getIntExtra("wID", 0); 
		
		//text = (TextView)findViewById(R.id.header_home_btn);
		//text.setOnClickListener(mHomeListener);
		//text.setText("text");
		
		//text = (TextView)findViewById(R.id.header_set_btn);
		//text.setOnClickListener(mSetListener);
		
		helper = new MySQLiteOpenHelper(DetailActivity.this, "basic_jwords.db", null, 1);
		al.clear();
		select();
		//adapter = new MyAdapter(ListActivity.this, al, R.layout.list_row);
		//Log.d("ih_test", Integer.toString(wID));
		TWord tw = al.get(wID);
		
		text = (TextView)findViewById(R.id.textView4);
		text.setText(tw.name_j);
		
		text = (TextView)findViewById(R.id.textView1);
		text.setText(tw.name_e);
		
		text = (TextView)findViewById(R.id.textView2);
		text.setText(tw.detail_e);
		
		btn = (ImageButton)findViewById(R.id.imageButton1);
		btn.setOnClickListener(mPlayListener);
		
		btn = (ImageButton)findViewById(R.id.imageButton2);
		btn.setOnClickListener(mBeforeListener);
		
		btn = (ImageButton)findViewById(R.id.imageButton3);
		btn.setOnClickListener(mNextListener);
		
		btn = (ImageButton)findViewById(R.id.imageButton4);
		btn.setOnClickListener(mHomeListener);
		
		//text = (TextView)findViewById(R.id.textView3);
		//text.setText("음원파일:민중서림 엣센스 일본어사전");
		
		wView = (WebView)findViewById(R.id.webView1);
		wView.setWebChromeClient(new WebChromeClient());
		wView.setWebViewClient(new WebViewClient());
		wSettings = wView.getSettings();
		wSettings.setBuiltInZoomControls(true);
		
		wView.loadUrl("http://www.google.com/search?q=" + tw.name_e + "&tbm=isch");
		
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
			intent.setClass(DetailActivity.this, MainActivity.class);
			startActivity(intent);
		}
		
	};
	
	View.OnClickListener mListListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(DetailActivity.this, ListActivity.class);
			startActivity(intent);
		}
		
	};
	
	View.OnClickListener mSetListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	View.OnClickListener mPlayListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			MediaPlayer mPlayer;
			
			mPlayer = MediaPlayer.create(DetailActivity.this, R.raw.hand);
			mPlayer.start();			
		}
		
	};
	
	View.OnClickListener mBeforeListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(DetailActivity.this, DetailActivity.class);
			intent.putExtra("wID", 0);
			startActivity(intent);			
		}
		
	};
	
	View.OnClickListener mNextListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(DetailActivity.this, DetailActivity.class);
			intent.putExtra("wID", 1);
			startActivity(intent);			
		}
		
	};

}
