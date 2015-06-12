package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MySpinnerDemo extends Activity {
	private Spinner spiColor = null; // ��ʾҪ��ȡ����ɫ�б��
	private ArrayAdapter<CharSequence> adapterColor = null; // ���е����ݶ���String

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.spiColor = (Spinner) super.findViewById(R.id.mycolor); // ȡ����ɫ��������
		this.spiColor.setPrompt("��ѡ����ϲ������ɫ��");
		this.adapterColor = ArrayAdapter.createFromResource(this,
				R.array.color_labels, android.R.layout.simple_spinner_item); // ʵ������ArrayAdapter
		this.adapterColor 
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // �������
		this.spiColor.setAdapter(this.adapterColor); // ������ʾ��Ϣ
	}
}