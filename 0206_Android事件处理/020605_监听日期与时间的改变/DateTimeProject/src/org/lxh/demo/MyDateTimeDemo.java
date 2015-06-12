package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MyDateTimeDemo extends Activity {
	private EditText input = null;
	private DatePicker date = null;
	private TimePicker time = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.input = (EditText) super.findViewById(R.id.input);
		this.date = (DatePicker) super.findViewById(R.id.date);
		this.time = (TimePicker) super.findViewById(R.id.time);
		this.time.setIs24HourView(true); // ����24Сʱ����ʾʱ��
		this.time.setOnTimeChangedListener(new OnTimeChangedListenerImpl());
		this.date.init(this.date.getYear(), this.date.getMonth(),
				this.date.getDayOfMonth(), new OnDateChangedListenerImpl());
		this.setDateTime(); // ϣ��һ��ʼ��������һЩ�ı�������
	}

	private class OnTimeChangedListenerImpl implements OnTimeChangedListener {

		public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
			MyDateTimeDemo.this.setDateTime();
		}
	}

	private class OnDateChangedListenerImpl implements OnDateChangedListener {
		public void onDateChanged(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			MyDateTimeDemo.this.setDateTime();
		}
	}

	public void setDateTime() { // ��������ʱ�����֮���ı��������������ҲҪ�޸�
		this.input.setText(this.date.getYear() + "-"
				+ (this.date.getMonth() + 1) + "-" + this.date.getDayOfMonth()
				+ " " + this.time.getCurrentHour() + ":"
				+ this.time.getCurrentMinute()); // �޸��ı�������
	}
}