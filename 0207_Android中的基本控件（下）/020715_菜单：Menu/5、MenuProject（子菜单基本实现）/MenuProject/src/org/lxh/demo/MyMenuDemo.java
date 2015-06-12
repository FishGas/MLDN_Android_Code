package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MyMenuDemo extends Activity {
	private String data[] = new String[] { "����ħ�ֿƼ�", "www.mldnjava.cn",
			"��ʦ�����˻�", "�й���У����", "www.jiangker.com" }; // ����ListView����ʾ��
	private ListView listView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.listView = new ListView(this);
		this.listView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_expandable_list_item_1, this.data));
		super.setContentView(this.listView);
		super.registerForContextMenu(this.listView) ;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		SubMenu fileMenu = menu.addSubMenu("�ļ�") ;
		SubMenu editMenu = menu.addSubMenu("�༭") ;
		fileMenu.add(Menu.NONE,Menu.FIRST + 1 , 1, "�½�") ;
		fileMenu.add(Menu.NONE,Menu.FIRST + 2 , 2, "��") ;
		fileMenu.add(Menu.NONE,Menu.FIRST + 3 , 3, "����") ;
		editMenu.add(Menu.NONE,Menu.FIRST + 4 , 4, "����") ;
		editMenu.add(Menu.NONE,Menu.FIRST + 5 , 5, "�ָ�") ;
		return true ;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {	// �жϲ����Ĳ˵�ID
		case Menu.FIRST + 1: 
			Toast.makeText(this, "��ѡ����ǡ������ϵ�ˡ���", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 2: 
			Toast.makeText(this, "��ѡ����ǡ��鿴���顱��", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 3: 
			Toast.makeText(this, "��ѡ����ǡ�ɾ����Ϣ����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 4: 
			Toast.makeText(this, "��ѡ����ǡ����Ϊ����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 5: 
			Toast.makeText(this, "��ѡ����ǡ��༭����", Toast.LENGTH_LONG).show() ;
			break ;
		}
		return false;
	}

}