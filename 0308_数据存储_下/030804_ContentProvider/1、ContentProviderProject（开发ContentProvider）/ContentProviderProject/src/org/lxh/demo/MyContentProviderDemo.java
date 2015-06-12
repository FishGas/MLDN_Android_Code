package org.lxh.demo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MyContentProviderDemo extends Activity {
	private Button insertBut = null ;	// ������ť
	private Button updateBut = null ;
	private Button deleteBut = null ;
	private Button queryBut = null ;
	private TextView mainInfo = null ;
	private ListView memberList = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mainInfo = (TextView) super.findViewById(R.id.mainInfo) ;	// ȡ�����
		this.insertBut = (Button) super.findViewById(R.id.insertBut) ;	// ȡ�����
		this.updateBut = (Button) super.findViewById(R.id.updateBut) ;	// ȡ�����
		this.deleteBut = (Button) super.findViewById(R.id.deleteBut) ;	// ȡ�����
		this.queryBut = (Button) super.findViewById(R.id.queryBut) ;	// ȡ�����
		this.memberList = (ListView) super.findViewById(R.id.memberList) ;	// ȡ�����
		this.insertBut.setOnClickListener(new InsertOnClickListener()) ;
		this.updateBut.setOnClickListener(new UpdateOnClickListener()) ;
		this.deleteBut.setOnClickListener(new DeleteOnClickListener()) ;
		this.queryBut.setOnClickListener(new QueryOnClickListener()) ;
	}
	private class InsertOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			MyContentProviderDemo.this.mainInfo.setText("ִ�е������Ӳ���...") ;
			long id = 0 ;	// ���շ��ص�id����
			id = MyContentProviderDemo.this.testInsert("���˻�", 30,
					new SimpleDateFormat("yyyy-MM-dd").format(new Date()));	// ��������
			Toast.makeText(MyContentProviderDemo.this, "�������ӳɹ���IDΪ��" + id,
					Toast.LENGTH_LONG).show();
		}
		
	}
	private class DeleteOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			MyContentProviderDemo.this.mainInfo.setText("ִ�е���ɾ������...") ;
			long result = 0 ;	// ���շ��ص�id����
			result = MyContentProviderDemo.this.testDelete(String.valueOf(4)); // ��������
			Toast.makeText(MyContentProviderDemo.this, "ɾ����" + result + "����¼",
					Toast.LENGTH_LONG).show();
		}
		
	}
	private class QueryOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			MyContentProviderDemo.this.mainInfo.setText("ִ�е��ǲ�ѯ����...") ;
			Cursor result = MyContentProviderDemo.this.testQuery(null) ;	// ��ѯȫ��
			MyContentProviderDemo.this.startManagingCursor(result) ;	// ���������ϵͳ����
			List<Map<String,Object>> members = new ArrayList<Map<String,Object>>() ;
			for (result.moveToFirst(); !result.isAfterLast(); result
					.moveToNext()) {
				Map<String,Object> member = new HashMap<String,Object>() ;
				member.put("_id", result.getInt(0)) ;
				member.put("name", result.getString(1)) ;
				member.put("age", result.getInt(2)) ;
				member.put("birthday", result.getString(3)) ;
				members.add(member) ;
			}
			MyContentProviderDemo.this.memberList
					.setAdapter(new SimpleAdapter(MyContentProviderDemo.this,
							members, R.layout.member, new String[] { "_id",
									"name", "age", "birthday" }, new int[] {
									R.id._id, R.id.name, R.id.age,
									R.id.birthday }));
			Toast.makeText(MyContentProviderDemo.this, "���ݲ�ѯ�ɹ���",
					Toast.LENGTH_LONG).show();
		}
		
	}
	private class UpdateOnClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			MyContentProviderDemo.this.mainInfo.setText("ִ�е��Ǹ��²���...") ;
			long result = 0 ;	// ���շ��ص�id����
			result = MyContentProviderDemo.this.testUpdate("", "MLDN", 18,
					"1989-09-19"); // ��������
			Toast.makeText(MyContentProviderDemo.this, "������" + result + "����¼",
					Toast.LENGTH_LONG).show();
		}
		
	}
	private long testInsert(String name,int age,String birthday) {	// ִ�����Ӳ���
		ContentResolver contentResolver = super.getContentResolver() ;	// ȡ��ContentResolver����
		ContentValues values = new ContentValues() ;
		values.put(MLDNDatabaseMetaData.MemberTableMetaData.MEMBER_NAME, name) ;
		values.put(MLDNDatabaseMetaData.MemberTableMetaData.MEMBER_AGE, age) ;
		values.put(MLDNDatabaseMetaData.MemberTableMetaData.MEMBER_BIRTHDAY, birthday) ;
		Uri resultUri = contentResolver.insert(
				MLDNDatabaseMetaData.MemberTableMetaData.CONTENT_URI, values);
		return ContentUris.parseId(resultUri) ;	// ���������ص�id����
	}

	private long testUpdate(String _id, String name, int age, String birthday) { // ִ�����Ӳ���
		long result = 0 ;	// ���ؽ��
		ContentResolver contentResolver = super.getContentResolver() ;	// ȡ��ContentResolver����
		ContentValues values = new ContentValues() ;
		values.put(MLDNDatabaseMetaData.MemberTableMetaData.MEMBER_NAME, name) ;
		values.put(MLDNDatabaseMetaData.MemberTableMetaData.MEMBER_AGE, age) ;
		values.put(MLDNDatabaseMetaData.MemberTableMetaData.MEMBER_BIRTHDAY, birthday) ;
		
		if(_id == null || "".equals(_id)) {	// ����ȫ��
			result = contentResolver.update(MLDNDatabaseMetaData.MemberTableMetaData.CONTENT_URI, values, null, null) ;
		} else {	// ����id����
			result = contentResolver.update(
					Uri.withAppendedPath(MLDNDatabaseMetaData.MemberTableMetaData.CONTENT_URI, _id),
					values, null, null);
		}
		return result ;	// ���������ص�id����
	}
	
	private long testDelete(String _id) {
		ContentResolver contentResolver = super.getContentResolver() ;	// ȡ��ContentResolver����
		long result = 0 ;
		if (_id == null || "".equals(_id)) {
			result = contentResolver.delete(
					MLDNDatabaseMetaData.MemberTableMetaData.CONTENT_URI, null,
					null);
		} else {
			result = contentResolver.delete(Uri.withAppendedPath(
					MLDNDatabaseMetaData.MemberTableMetaData.CONTENT_URI, _id),
					null, null);
		}
		return result ;
	}
	
	private Cursor testQuery(String id) {
		if(id == null || "".equals(id)) {	// ��ѯȫ��
			return super.getContentResolver().query(
					MLDNDatabaseMetaData.MemberTableMetaData.CONTENT_URI, null,
					null, null,
					MLDNDatabaseMetaData.MemberTableMetaData.SORT_ORDER);
		} else {
			return super
					.getContentResolver()
					.query(Uri.withAppendedPath(
							MLDNDatabaseMetaData.MemberTableMetaData.CONTENT_URI,
							id), null, null, null,
							MLDNDatabaseMetaData.MemberTableMetaData.SORT_ORDER);
		}
	}
}