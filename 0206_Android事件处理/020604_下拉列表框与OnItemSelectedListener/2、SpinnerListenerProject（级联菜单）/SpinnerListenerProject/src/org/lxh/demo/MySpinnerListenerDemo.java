package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
public class MySpinnerListenerDemo extends Activity {
	private Spinner city = null; // �����б������
	private Spinner area = null; // �����б�
	private String[][] areaData = new String[][] {
			{ "����", "����", "����", "����", "ƽ��" }, // �����һ��������Ϣ
			{ "����", "����", "����" }, // ����ڶ���������Ϣ
			{ "����" } // ���������������Ϣ
	}; // �Ӳ˵���
	private ArrayAdapter<CharSequence> adapterArea = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.city = (Spinner) super.findViewById(R.id.city); // ȡ�������б��
		this.area = (Spinner) super.findViewById(R.id.area); // ȡ�������б��
		this.city.setOnItemSelectedListener(new OnItemSelectedListenerImpl());
	}

	private class OnItemSelectedListenerImpl implements OnItemSelectedListener {

		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) { // ��ʾѡ��ı��ʱ�򴥷�
			MySpinnerListenerDemo.this.adapterArea = new ArrayAdapter<CharSequence>(
					MySpinnerListenerDemo.this,
					android.R.layout.simple_spinner_item,
					MySpinnerListenerDemo.this.areaData[position]); // �������е��б���
			MySpinnerListenerDemo.this.area
					.setAdapter(MySpinnerListenerDemo.this.adapterArea);// ���ö��������б��ѡ������
		}

		public void onNothingSelected(AdapterView<?> arg0) { // ��ʾû��ѡ���ʱ�򴥷�
			// һ��˷������ڲ�����
		}
	}
}