package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TimePicker;

public class MyTimePicker extends Activity {
	private TimePicker mytp = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mytp = (TimePicker) super.findViewById(R.id.tp2) ;	// ȡ�����
		this.mytp.setIs24HourView(true) ;	// ����Ϊ24Сʱ��
		this.mytp.setCurrentHour(18) ;	// ����ʱ
		this.mytp.setCurrentMinute(30) ;	// ���÷�
	}
}