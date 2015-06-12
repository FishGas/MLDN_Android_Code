package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.EditText;
import android.widget.TextView;

public class MyFocusDemo extends Activity {
	private EditText edit = null; // �ڴ���������ý����¼�
	private TextView txt = null; // ������Ϣ��ʾ

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.edit = (EditText) super.findViewById(R.id.edit); // ȡ�����
		this.txt = (TextView) super.findViewById(R.id.txt); // ȡ�����
		this.edit.setOnFocusChangeListener(new OnFocusChangeListenerImpl());
	}

	private class OnFocusChangeListenerImpl implements OnFocusChangeListener {

		public void onFocusChange(View v, boolean hasFocus) { // ��ʾ�������������hasFocus��ʾ�Ƿ��ý���
			if (hasFocus) { // �Ѿ�����˽���
				MyFocusDemo.this.txt.setText("�ı����������ý��㡣") ;
			} else {
				MyFocusDemo.this.txt.setText("�ı��������ʧȥ���㡣") ;
			}
		}

	}
}