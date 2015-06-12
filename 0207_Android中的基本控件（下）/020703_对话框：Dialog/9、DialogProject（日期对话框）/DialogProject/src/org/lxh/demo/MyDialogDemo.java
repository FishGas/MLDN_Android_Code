package org.lxh.demo;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

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
			Dialog dialog = new DatePickerDialog(MyDialogDemo.this,new DatePickerDialog.OnDateSetListener() {
				
				@Override
				public void onDateSet(DatePicker view, int year, int monthOfYear,
						int dayOfMonth) {
					TextView text = (TextView) MyDialogDemo.this.findViewById(R.id.txt) ;
					text.setText("���µ�����Ϊ��" + year + "-" + monthOfYear + "-" + dayOfMonth) ;
				}
			},1981,8,19) ; // Ĭ�ϵ��ꡢ�¡���
			dialog.show() ;	// ��ʾ�Ի���
		}
		
	}

}