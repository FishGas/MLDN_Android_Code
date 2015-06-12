package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Hello extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // �������ڷ���
		LinearLayout layout = new LinearLayout(this); // ���岼�ֹ�����
		layout.setOrientation(LinearLayout.VERTICAL) ;	// ���������ֱ�ڷ�
		TextView text = new TextView(this); // Ҫ���������ģ�Context���������
		text.setText(super.getString(R.string.info)); // ͨ��strings.xml�ļ���������
		Button but = new Button(this); // ���尴ť
		but.setText(super.getString(R.string.msg)); // �����������
		layout.addView(text); // �򲼾ֹ�����֮�������ı����
		layout.addView(but); // �򲼾ֹ�����֮�����Ӱ�ť���
		super.setContentView(layout); // ����Ҫʹ�õĲ��ֹ�����
	}
}