package org.lxh.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MytabCursor {
	private static final String TABLENAME = "mytab" ;
	private SQLiteDatabase db = null ;
	public MytabCursor(SQLiteDatabase db) {
		this.db = db ;
	}
	
	public int getCount() { // ���ؼ�¼��
		int count = 0;
		String sql = "SELECT COUNT(id) FROM " + TABLENAME; // ��ѯSQL
		Cursor result = this.db.rawQuery(sql, null);
		for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) { // ����ѭ���ķ�ʽ��������
			count = result.getInt(0);
		}
		return count;
	}
	
	public List<Map<String,Object>> find(int currentPage,int lineSize){
		List<Map<String,Object>> all = new ArrayList<Map<String,Object>>() ;
		String sql = "SELECT id,name,birthday FROM " + TABLENAME
				+ " LIMIT ?,?";
		String args[] = new String[] {
				String.valueOf((currentPage - 1) * lineSize),
				String.valueOf(lineSize) }; // �����ò���
		Cursor result = this.db.rawQuery(sql, args); // ִ�в�ѯ���
		for (result.moveToFirst(); !result.isAfterLast(); result.moveToNext()) {	// ����ѭ���ķ�ʽ��������
			Map<String,Object> map = new HashMap<String,Object>() ;
			map.put("id", result.getInt(0)) ;
			map.put("name", result.getString(1)) ;
			map.put("birthday",result.getString(2)) ;
			all.add(map) ;
		}
		this.db.close() ;
		return all ;
	}

}
