package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Hello extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // �������ڷ���
		TextView text = new TextView(this); // Ҫ���������ģ�Context���������
		text.setText(super.getString(R.string.info)); // ͨ��strings.xml�ļ���������
		super.setContentView(text); // ����Ҫʹ�õĲ��ֹ�����
	}
}