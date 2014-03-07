package com.senapapa.baby2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

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
import android.widget.RelativeLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class DetailActivity extends Activity {

	MySQLiteOpenHelper helper;
	SQLiteDatabase db;
	
	ImageButton btn;
	TextView text;
	WebView wView;
	WebSettings wSettings;
	MyAdapter adapter;
	ArrayList<TWord> al;
	int wID;
	TWord tw;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detail_2);
		
		//AdView adView = (AdView)this.findViewById(R.id.ad2);
		//adView.loadAd(new AdRequest());
		
		
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
	    
		
		
		//Log.d("ih_test", "start Detail");
		
		Intent intent = getIntent();
		wID = intent.getIntExtra("wID", 0); 
		
		//text = (TextView)findViewById(R.id.header_home_btn);
		//text.setOnClickListener(mHomeListener);
		//text.setText("text");
		
		//text = (TextView)findViewById(R.id.header_set_btn);
		//text.setOnClickListener(mSetListener);
		
		helper = new MySQLiteOpenHelper(DetailActivity.this, "basic_jwords_1.db", null, 1);
		
		select();
		
		if (al.isEmpty()) return;
		
		tw = al.get(wID);
		
		text = (TextView)findViewById(R.id.textView1);
		text.setText(tw.name_j);
		
		text = (TextView)findViewById(R.id.textView2);
		text.setText("음독:  " + tw.pron);
		
		text = (TextView)findViewById(R.id.textView3);
		text.setText("훈독:  " + tw.read);
		
		text = (TextView)findViewById(R.id.textView4);
		text.setText("뜻:     " + tw.name_k);
		
		//btn = (ImageButton)findViewById(R.id.imageButton4);
		//btn.setOnClickListener(mPlayListener);
		
		btn = (ImageButton)findViewById(R.id.imageButton2);
		btn.setOnClickListener(mBeforeListener);
		
		btn = (ImageButton)findViewById(R.id.imageButton1);
		btn.setOnClickListener(mNextListener);
		
		btn = (ImageButton)findViewById(R.id.imageButton3);
		btn.setOnClickListener(mHomeListener);
		
		//text = (TextView)findViewById(R.id.textView3);
		//text.setText("?隴ｷ蟇ｳ逕ｯ隴ｷ謾ｵ:??ｼ?蜊???ｼ ??｣??ｼ??､ ??ｼ??ｸ??ｴ??ｬ??);
		
		wView = (WebView)findViewById(R.id.webView1);
		wView.setWebChromeClient(new WebChromeClient());
		wView.setWebViewClient(new WebViewClient());
		wSettings = wView.getSettings();
		wSettings.setBuiltInZoomControls(true);
		
		wView.loadUrl("http://www.google.com/search?q=" + tw.name_e + "&tbm=isch");
		
	}
	
	
	private void select() {
		
		al = new ArrayList<TWord>();
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
			
			Log.d("DB", _id + "/" + name_j + "/" + name_e + "/" + name_k + "/" + pron + "/" + read + "/" + flg1 + "/" + flg2);
			
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
		
		Collections.shuffle(al);
		
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
			al.clear();
			
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
			/*
			Intent intent = new Intent();
			intent.setClass(DetailActivity.this, DetailActivity.class);
			Log.d("ih_before", Integer.toString(wID));
			intent.putExtra("wID", wID - 1);
			startActivity(intent);
			*/
			Log.d("ih_next", Integer.toString(wID));
			wID = wID - 1;
			if(wID == -1) wID = al.size()-1;
			tw = al.get(wID);
			
			text = (TextView)findViewById(R.id.textView1);
			text.setText(tw.name_j);
			
			text = (TextView)findViewById(R.id.textView2);
			text.setText("음독:  " + tw.pron);
			
			text = (TextView)findViewById(R.id.textView3);
			text.setText("훈독:  " + tw.read);
			
			text = (TextView)findViewById(R.id.textView4);
			text.setText("뜻:     " + tw.name_k);
			
			wView.loadUrl("http://www.google.com/search?q=" + tw.name_e + "&tbm=isch");
		}
		
	};
	
	View.OnClickListener mNextListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			/*
			Intent intent = new Intent();
			intent.setClass(DetailActivity.this, DetailActivity.class);
			Log.d("ih_next", Integer.toString(wID));
			intent.putExtra("wID", wID + 1);
			startActivity(intent);
			*/	
			Log.d("ih_next", Integer.toString(wID));
			wID = wID + 1;
			if(wID>(al.size()-1)) wID = 0;
			tw = al.get(wID);
			
			text = (TextView)findViewById(R.id.textView1);
			text.setText(tw.name_j);
			
			text = (TextView)findViewById(R.id.textView2);
			text.setText("음독:  " + tw.pron);
			
			text = (TextView)findViewById(R.id.textView3);
			text.setText("훈독:  " + tw.read);
			
			text = (TextView)findViewById(R.id.textView4);
			text.setText("뜻:     " + tw.name_k);
			
			/*
			btn = (ImageButton)findViewById(R.id.imageButton4);
			btn.setOnClickListener(mPlayListener);
			
			btn = (ImageButton)findViewById(R.id.imageButton2);
			btn.setOnClickListener(mBeforeListener);
			
			btn = (ImageButton)findViewById(R.id.imageButton1);
			btn.setOnClickListener(mNextListener);
			
			btn = (ImageButton)findViewById(R.id.imageButton3);
			btn.setOnClickListener(mHomeListener);
			
			//text = (TextView)findViewById(R.id.textView3);
			//text.setText("?隴ｷ蟇ｳ逕ｯ隴ｷ謾ｵ:??ｼ?蜊???ｼ ??｣??ｼ??､ ??ｼ??ｸ??ｴ??ｬ??);

			 
			
			wView = (WebView)findViewById(R.id.webView1);
			wView.setWebChromeClient(new WebChromeClient());
			wView.setWebViewClient(new WebViewClient());
			wSettings = wView.getSettings();
			wSettings.setBuiltInZoomControls(true);
			*/
			
			wView.loadUrl("http://www.google.com/search?q=" + tw.name_e + "&tbm=isch");
		}
		
	};

}
