package org.lxh.demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

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
			final ProgressDialog proDia = ProgressDialog.show(MyDialogDemo.this,
					"��������", "�����ĵȴ�...");
			new Thread(){
				public void run(){	// �̵߳�������
					try {
						Thread.sleep(3000) ;	// ��������
					} catch (Exception e) {
					} finally {
						proDia.dismiss() ;	// �رնԻ���
					}
				}
			}.start() ;
			proDia.show() ;	// ��ʾ�Ի���
		}
		
	}

}