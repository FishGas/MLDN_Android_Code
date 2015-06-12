package org.lxh.demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {
	private static final String DATABASENAME = "mldn.db" ;
	private static final int DATABASERVERSION = 2 ;	// �������ݿ�İ汾
	private static final String TABLENAME = "mytab" ;
	
	public MyDatabaseHelper(Context context) {	// �û�����ĵ�Ҳ�϶�ֻ��Context
		super(context, DATABASENAME, null, DATABASERVERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {	// �������ݱ�
		String sql = "CREATE TABLE " + TABLENAME + "("
				+ "id		INTEGER			PRIMARY KEY ," 	// ��SQLite������ΪInteger��PRIMARY KEY��ID�Զ�����
				+ "name 	VARCHAR(50) 	NOT NULL ,"
				+ "birthday DATE NOT 		NULL" + ")";
		db.execSQL(sql) ;	// ִ��SQL
		System.out.println("****************** ������onCreate()��");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		String sql = "DROP TABLE IF EXISTS " + TABLENAME ;
		db.execSQL(sql) ;
		System.out.println("****************** ���£�onUpgrade()��");
		this.onCreate(db) ;
	}

}
