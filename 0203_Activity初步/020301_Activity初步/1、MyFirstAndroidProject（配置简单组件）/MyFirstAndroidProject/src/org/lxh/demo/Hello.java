package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Hello extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); // �������ڷ���
		super.setContentView(R.layout.main); // ����Ҫʹ�õĲ��ֹ�����
		TextView text = (TextView) super.findViewById(R.id.mytext); // ȡ��TextView���
		text.setText("����ħ�ֿƼ����ѧԺ��MLDN��") ;	// ������ʾ����
		Button but = (Button) super.findViewById(R.id.mybut) ;	// ȡ�ð�ť���
		but.setText("���ң�����û�á�") ;
	}
}