package com.senapapa.baby2;

//import com.example.senati.R;

import com.senapapa.baby2.MainActivity;

import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;

public class TabViewActivity extends TabActivity{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final TabHost tabHost = getTabHost();

        tabHost.addTab(tabHost.newTabSpec("tab1")
                .setIndicator("HOME")
                .setContent(new Intent(this, MainActivity.class)));

        tabHost.addTab(tabHost.newTabSpec("tab2")
                .setIndicator("LIST")
                .setContent(new Intent(this, MainActivity.class)));
        
        // This tab sets the intent flag so that it is recreated each time
        // the tab is clicked.
        tabHost.addTab(tabHost.newTabSpec("tab3")
                .setIndicator("SET")
                .setContent(new Intent(this, MainActivity.class)));
                        //.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)));
        
        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
        	public void onTabChanged(String tabId) {
        		Log.d("ih", tabId);
        		tabHost.getTabWidget().removeView(tabHost.getTabWidget().getChildTabViewAt(3));
        	}
        });
    }
    
}