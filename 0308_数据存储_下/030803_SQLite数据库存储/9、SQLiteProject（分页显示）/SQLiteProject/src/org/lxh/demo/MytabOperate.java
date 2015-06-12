package org.lxh.demo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class MytabOperate {
	private static final String TABLENAME = "mytab"; // ��ʾҪ���������ݱ�����
	private SQLiteDatabase db = null; // ���ݿ����

	public MytabOperate(SQLiteDatabase db) {
		this.db = db;
	}
	public void insert(String name,String birthday) {
		ContentValues cv = new ContentValues() ;
		cv.put("name", name) ;
		cv.put("birthday", birthday) ;
		this.db.insert(TABLENAME, null, cv) ;
		this.db.close() ;
	}

	public void update(int id, String name, String birthday) {
		ContentValues cv = new ContentValues() ;
		cv.put("name", name) ;
		cv.put("birthday", birthday) ;
		String whereClause = "id=?" ;
		String whereArgs[] = new String[]{String.valueOf(id)} ;
		this.db.update(TABLENAME, cv, whereClause, whereArgs) ;
		this.db.close() ;
	}
	
	public void delete(int id) {
		String whereClause = "id=?" ;
		String whereArgs[] = new String[]{String.valueOf(id)} ;
		this.db.delete(TABLENAME, whereClause, whereArgs) ;
		this.db.close() ;
	}
}
