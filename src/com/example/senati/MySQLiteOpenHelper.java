package com.example.senati;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/*
* db helper
*/

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	
	SQLiteDatabase db;

	public MySQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		// first time SQLiteOpenHelper start		
		String sql = "create table t_word (" + 
				"_id integer primary key autoincrement, " + 
				"name_j string, " +
				"name_e string, " +
				"name_k string, " +
				"detail_e string, " +
				"detail_k string, " +
				"flg1 integer, " +
				"flg2 integer);";
		
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub		
		String sql = "drop table if exists t_word";
		db.execSQL(sql);
		
		onCreate(db);
		
	}
	
	public void insert(MySQLiteOpenHelper helper, 
					   String name_j, 
					   String name_e, 
					   String name_k,
					   String detail_e, 
					   String detail_k) {
		db = helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("name_j", name_j);
		values.put("name_e", name_e);
		values.put("name_k", name_k);
		values.put("detail_e", detail_e);
		values.put("detail_k", detail_k);
		values.put("flg1", 0);
		values.put("flg2", 0);
		db.insert("t_word", null, values);
		
		db.close();
	}
	
	public void update(MySQLiteOpenHelper helper, int id, String col_name, int val) {
		db = helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put(col_name, val);
		db.update("t_word", values, "_id=?", new String[]{Integer.toString(id)});
		
		db.close();
	}
	
	public void delete(MySQLiteOpenHelper helper, int id) {
		db = helper.getWritableDatabase();
		db.delete("t_word", "_id=?", new String[]{Integer.toString(id)});
		
		db.close();
	}
}