package com.senapapa.baby2;

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
				"pron string, " +
				"read string, " +
				"name_e string, " +
				"name_k string, " +
				"cate_j string, " +
				"cate_e string, " +
				"cate_k string, " +
				"level integer, " +
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
					   String pron,
					   String read,
					   String name_e, 
					   String name_k,
					   int level,
					   String cate_j,
					   String cate_e,
					   String cate_k
					   ) {
		db = helper.getWritableDatabase();
		
		ContentValues values = new ContentValues();
		values.put("name_j", name_j);
		values.put("pron", pron);
		values.put("read", read);
		values.put("name_e", name_e);
		values.put("name_k", name_k);
		values.put("cate_j", cate_j);
		values.put("cate_e", cate_e);
		values.put("cate_k", cate_k);
		values.put("level", level);
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