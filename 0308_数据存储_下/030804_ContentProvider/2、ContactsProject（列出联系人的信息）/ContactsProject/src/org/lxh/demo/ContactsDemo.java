package org.lxh.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class ContactsDemo extends Activity {
	private Cursor result = null ;	// ��ȻҪ��ѯ����ѯ���صľ��ǽ��
	private ListView contactsList = null ;	// ����ListView���
	private List<Map<String,Object>> allContacts = null ;
	private SimpleAdapter simple = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.contactsList = (ListView) super.findViewById(R.id.contactsList) ;	// ȡ�����
		this.result = super.getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null);	// ��ѯ
		super.startManagingCursor(this.result) ;	// �������������������
		this.allContacts = new ArrayList<Map<String,Object>>() ;	// ʵ����List����
		for (this.result.moveToFirst(); !this.result.isAfterLast(); this.result
				.moveToNext()) {	// ȡ��������е�ÿһ������
			Map<String,Object> contact = new HashMap<String,Object>() ;
			contact.put("_id", this.result.getInt(this.result
					.getColumnIndex(ContactsContract.Contacts._ID)));
			contact.put("name", this.result.getString(this.result
					.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
			this.allContacts.add(contact) ;
		}
		this.simple = new SimpleAdapter(this, this.allContacts,
				R.layout.contacts, new String[] { "_id", "name" }, new int[] {
						R.id._id, R.id.name });
		this.contactsList.setAdapter(this.simple) ;
	}
}