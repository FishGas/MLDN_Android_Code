package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class MyEditTextDemo extends Activity {
	private EditText edit = null; // ��Ϊ���Գ���

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.edit = (EditText) super.findViewById(R.id.myet2); // ȡ�����
		this.edit.setEnabled(false) ;	// ���ڲ��ɱ༭
	}
}