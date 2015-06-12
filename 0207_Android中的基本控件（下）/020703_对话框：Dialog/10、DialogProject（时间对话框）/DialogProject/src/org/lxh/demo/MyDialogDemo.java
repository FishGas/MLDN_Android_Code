package org.lxh.demo;

import android.app.Activity;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MyDialogDemo extends Activity {
	private Button mybut = null ;	// ���尴ť
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main); // ���ò��ֹ�����
		this.mybut = (Button) super.findViewById(R.id.mybut) ;	// ȡ�ð�ť
		this.mybut.setOnClickListener(new OnClickListenerImpl()) ;	// �����¼���
	}
	private class OnClickListenerImpl implements OnClickListener {
 
		@Override
		public void onClick(View view) {
			Dialog dialog = new TimePickerDialog(MyDialogDemo.this,new TimePickerDialog.OnTimeSetListener() {
				@Override
				public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
					TextView text = (TextView) MyDialogDemo.this.findViewById(R.id.txt) ;
					text.setText("ʱ��Ϊ��" + hourOfDay + ":" + minute) ;
				}
			},19,20,true) ;
			dialog.show() ;	// ��ʾ�Ի���
		}
		
	}

}