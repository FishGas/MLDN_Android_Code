package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MyAutoCompleteTextViewDemo extends Activity {
	private static final String DATA[] = new String[] { "mldn", "mldn java",
			"mldnħ�ֿƼ�", "mldn���˻�", "mldn job" };
	private AutoCompleteTextView myauto = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_dropdown_item_1line, DATA); // ���ݼ�
		this.myauto = (AutoCompleteTextView) super.findViewById(R.id.myauto); // ȡ�����
		this.myauto.setAdapter(adapter); // ��������
	}
}