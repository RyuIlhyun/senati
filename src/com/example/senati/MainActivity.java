package com.example.senati;

import android.os.Bundle;
import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	public static final String preferences_name = "jword_conf";
	public SharedPreferences preferences;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		preferences = getSharedPreferences(preferences_name, Service.MODE_PRIVATE);
		int db_set_flg = preferences.getInt("app_ver", 0);
		
		if(db_set_flg == 0) {
			SharedPreferences.Editor editor = preferences.edit();
			editor.putInt("app_ver", 1);
			editor.commit();
			
			MySQLiteOpenHelper helper = new MySQLiteOpenHelper(MainActivity.this, "basic_jwords.db", null, 1);
			
			helper.insert(helper, "顔", "face", "얼굴", "かお", "がん、あん");
			helper.insert(helper, "手", "hand", "손", "て、た", "しゅ");
		}		
		Button button;
		
		button = (Button) findViewById(R.id.startBtn);
		button.setOnClickListener(mStartListener);
		
		button = (Button) findViewById(R.id.listBtn);
		button.setOnClickListener(mListListener);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	View.OnClickListener mStartListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, DetailActivity.class);
			startActivity(intent);
		}
		
	};
	
	View.OnClickListener mListListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, ListActivity.class);
			startActivity(intent);
			
		}
		
	};
	

}
