package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CheckBox;

public class MyCheckBoxDemo extends Activity {
	private CheckBox box = null; // �������

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.box = (CheckBox) super.findViewById(R.id.url3); // ȡ�����
		this.box.setChecked(true); // �����������ΪĬ��ѡ��
		this.box.setText("www.jiangker.com"); // ������ʾ����
	}
}