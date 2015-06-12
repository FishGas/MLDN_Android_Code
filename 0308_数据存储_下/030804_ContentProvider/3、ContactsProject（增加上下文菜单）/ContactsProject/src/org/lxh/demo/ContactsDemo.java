package org.lxh.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

public class ContactsDemo extends Activity {
	private Cursor result = null; // ��ȻҪ��ѯ����ѯ���صľ��ǽ��
	private ListView contactsList = null; // ����ListView���
	private List<Map<String, Object>> allContacts = null;
	private SimpleAdapter simple = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.contactsList = (ListView) super.findViewById(R.id.contactsList); // ȡ�����
		this.result = super.getContentResolver().query(
				ContactsContract.Contacts.CONTENT_URI, null, null, null, null); // ��ѯ
		super.startManagingCursor(this.result); // �������������������
		this.allContacts = new ArrayList<Map<String, Object>>(); // ʵ����List����
		for (this.result.moveToFirst(); !this.result.isAfterLast(); this.result
				.moveToNext()) { // ȡ��������е�ÿһ������
			Map<String, Object> contact = new HashMap<String, Object>();
			contact.put("_id", this.result.getInt(this.result
					.getColumnIndex(ContactsContract.Contacts._ID)));
			contact.put("name", this.result.getString(this.result
					.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
			this.allContacts.add(contact);
		}
		this.simple = new SimpleAdapter(this, this.allContacts,
				R.layout.contacts, new String[] { "_id", "name" }, new int[] {
						R.id._id, R.id.name });
		this.contactsList.setAdapter(this.simple);
		super.registerForContextMenu(this.contactsList); // ע��˵�
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		int position = info.position; // ȡ�ò���λ��
		String contactsId = this.allContacts.get(position).get("_id").toString() ;
		switch(item.getItemId()){	// ���в˵��Ĳ���
		case Menu.FIRST + 1:	// �鿴
			String phoneSelection = ContactsContract.CommonDataKinds.Phone.CONTACT_ID
					+ "=?";
			String[] phoneSelectionArgs = new String[] { contactsId};
			Cursor c = super.getContentResolver().query(
					ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,
					phoneSelection, phoneSelectionArgs, null);
			StringBuffer buf = new StringBuffer() ;
			buf.append("�绰�����ǣ�") ;
			for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
				buf.append(
						c.getString(c
								.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)))
						.append("��");
			}
			Toast.makeText(this, buf, Toast.LENGTH_SHORT)
					.show();
			break ;
		case Menu.FIRST + 2:	// ɾ��
			super.getContentResolver().delete(
					Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_URI,
							contactsId), null, null);
			this.allContacts.remove(position) ;	// ɾ������������
			this.simple.notifyDataSetChanged() ;	// ֪ͨ�ı�
			Toast.makeText(this, "������ɾ����", Toast.LENGTH_SHORT).show();
			break ;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) { // �����˵�
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderTitle("��ϵ�˲���");
		menu.add(Menu.NONE, Menu.FIRST + 1, 1, "�鿴����");
		menu.add(Menu.NONE, Menu.FIRST + 2, 1, "ɾ����Ϣ");
	}

}