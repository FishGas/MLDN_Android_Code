package org.lxh.demo;

import android.database.sqlite.SQLiteDatabase;

public class MytabOperate {
	private static final String TABLENAME = "mytab"; // ��ʾҪ���������ݱ�����
	private SQLiteDatabase db = null; // ���ݿ����

	public MytabOperate(SQLiteDatabase db) {
		this.db = db;
	}
	public void insert(String name,String birthday) {
		String sql = "INSERT INTO " + TABLENAME + "(name,birthday) VALUES ('"
				+ name + "','" + birthday + "')";
		this.db.execSQL(sql) ;
		this.db.close() ;
	}

	public void update(int id, String name, String birthday) {
		String sql = "UPDATE " + TABLENAME + " SET name='" + name
				+ "',birthday='" + birthday + "' WHERE id=" + id;
		this.db.execSQL(sql); 
		this.db.close() ;
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM " + TABLENAME + " WHERE id=" + id ;
		this.db.execSQL(sql) ;
		this.db.close() ;
	}
}
