package org.lxh.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;

public class MyDialogDemo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main); // ���ò��ֹ�����
		Dialog dialog = new AlertDialog.Builder(this)
			.setTitle("�Ի���")		// ��������
			.setMessage("��ʾ��ʾ��Ϣ") // ��ʾ�Ի����е�����
			.setIcon(R.drawable.pic_m) // ����LOGO
			.create(); // ������һ���Ի���
		dialog.show() ;	// ��ʾ�Ի���
	}
}