package com.senapapa.baby2;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {

	Context context;
	ArrayList<TWord> al;
	int layout;
	LayoutInflater inf;
	
	public MyAdapter(Context context, ArrayList<TWord> al, int layout) {
		this.context = context;
		this.al = al;
		this.layout = layout;
		inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return al.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return al.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (convertView == null) {
			convertView = inf.inflate(layout, null);
		}
		TextView tv1 = (TextView) convertView.findViewById(R.id.listTextView1);
		TextView tv2 = (TextView) convertView.findViewById(R.id.listTextView2);
		
		TWord tw = al.get(position);
		tv1.setText(tw.name_j);
		tv2.setText(tw.name_k);
		
		return convertView;
		
	}
	
}