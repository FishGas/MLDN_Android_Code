package org.lxh.demo;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MytabCursor {
	private static final String TABLENAME = "mytab" ;
	private SQLiteDatabase db = null ;
	public MytabCursor(SQLiteDatabase db) {
		this.db = db ;
	}
	public List<String> find(){
		List<String> all = new ArrayList<String>() ;	// ��ʱֻ��String
		String sql = "SELECT id,name,birthday FROM " + TABLENAME + " WHERE name LIKE ? OR birthday LIKE ?" ;
		String keyWord = "3" ;	// ��ѯ�ؼ��� ��Ӧ���ɷ�������
		String args[] = new String[] { "%" + keyWord + "%", "%" + keyWord + "%" };
		Cursor result = this.db.rawQuery(sql, args); // ִ�в�ѯ���
		for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {	// ����ѭ���ķ�ʽ��������
			all.add("��" + result.getInt(0) + "��" + " " + result.getString(1)
					+ "��" + result.getString(2));
		}
		this.db.close() ;
		return all ;
	}
}
