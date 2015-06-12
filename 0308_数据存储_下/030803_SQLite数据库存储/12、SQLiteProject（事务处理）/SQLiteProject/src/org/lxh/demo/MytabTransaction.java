package org.lxh.demo;

import android.database.sqlite.SQLiteDatabase;

public class MytabTransaction {
	private static final String TABLENAME = "mytab"; // ��ʾҪ���������ݱ�����
	private SQLiteDatabase db = null; // ���ݿ����

	public MytabTransaction(SQLiteDatabase db) {
		this.db = db;
	}
	public void insertBatch() {
		this.db.beginTransaction() ;	// ��ʼ����
		try {
			this.db.execSQL("INSERT INTO " + TABLENAME + " (name,birthday) VALUES (?,?) ",new Object[]{"���˻�","1989-09-12"} ) ;
			this.db.execSQL("INSERT INTO " + TABLENAME + " (id,name,birthday) VALUES (?,?) ",new Object[]{"ħ�ֿƼ�","1000-09-12"} ) ;
			this.db.execSQL("INSERT INTO " + TABLENAME + " (name,birthday) VALUES (?,?) ",new Object[]{"�����","1982-08-03"} ) ;
			this.db.setTransactionSuccessful() ;	// �����ύ
		} catch (Exception e) {
			e.printStackTrace() ;
		} finally {
			this.db.endTransaction() ;	// ��������
		}
		this.db.close() ;
	}
}
