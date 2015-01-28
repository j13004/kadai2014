package com.example.pedometer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

	private static final String DATABASE_NAME = "mydata.db";
	private static final int DATABASE_VERSION = 2;
	private static final String TABLE_NAME = "Pedometer";
	private static final String ID = "id";
	private static final String hosuu = "hosuu";
	private static final String ido = "ido";
	private static final String keido = "keido";

	 DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO 自動生成されたコンストラクター・スタブ
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String query = "create table " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +hosuu+ " INTEGER," +ido+ " INTEGER,"+keido+" INTEGER);";
		db.execSQL(query);
				// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("drop table if exists" + TABLE_NAME);
		onCreate(db);
		// TODO 自動生成されたメソッド・スタブ

	}

}
