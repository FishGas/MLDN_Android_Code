package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MyMenuDemo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, Menu.FIRST + 1, 5, "ɾ��").setIcon(
				android.R.drawable.ic_menu_delete);
		menu.add(Menu.NONE, Menu.FIRST + 2, 2, "����").setIcon(
				android.R.drawable.ic_menu_save);
		menu.add(Menu.NONE, Menu.FIRST + 3, 6, "����").setIcon(
				android.R.drawable.ic_menu_help);
		menu.add(Menu.NONE, Menu.FIRST + 4, 1, "���").setIcon(
				android.R.drawable.ic_menu_add);
		menu.add(Menu.NONE, Menu.FIRST + 5, 4, "����").setIcon(
				android.R.drawable.ic_menu_info_details);
		menu.add(Menu.NONE, Menu.FIRST + 6, 7, "����").setIcon(
				android.R.drawable.ic_menu_send);
		menu.add(Menu.NONE, Menu.FIRST + 7, 3, "�༭").setIcon(
				android.R.drawable.ic_menu_edit);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch(item.getItemId()) {	// �жϲ����Ĳ˵�ID
		case Menu.FIRST + 1: 
			Toast.makeText(this, "��ѡ����ǡ�ɾ���˵�����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 2: 
			Toast.makeText(this, "��ѡ����ǡ�����˵�����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 3: 
			Toast.makeText(this, "��ѡ����ǡ������˵�����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 4: 
			Toast.makeText(this, "��ѡ����ǡ���Ӳ˵�����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 5: 
			Toast.makeText(this, "��ѡ����ǡ�����˵�����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 6: 
			Toast.makeText(this, "��ѡ����ǡ����Ͳ˵�����", Toast.LENGTH_LONG).show() ;
			break ;
		case Menu.FIRST + 7: 
			Toast.makeText(this, "��ѡ����ǡ��༭�˵�����", Toast.LENGTH_LONG).show() ;
			break ;
		}
		return false;
	}

	@Override
	public void onOptionsMenuClosed(Menu menu) {
		Toast.makeText(this,
				"ѡ��˵��ر���",
				Toast.LENGTH_LONG).show();
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		Toast.makeText(this,
				"�ڲ˵���ʾ��onCreateOptionsMenu()����֮ǰ����ô˲����������ڴ˲���֮�����һЩԤ�����ܡ���",
				Toast.LENGTH_LONG).show();
		return true;
	}
	
}