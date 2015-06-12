package org.lxh.demo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyDialogDemo extends Activity {
	private Button mybut = null ;	// ���尴ť
	private static final int MAX_PROGRESS = 100 ;	// ���ֵ
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
			final ProgressDialog proDia = new ProgressDialog(MyDialogDemo.this) ;
			proDia.setTitle("��������") ;
			proDia.setMessage("�����ĵȴ�") ;
			proDia.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL) ;	// ˮƽ������
			proDia.setMax(MAX_PROGRESS) ;	// ���ý��ȵ����ֵ
			proDia.setProgress(30) ;	// �ӽ���30��ʼ
			proDia.setButton("��̨����", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					proDia.dismiss() ;	// �رնԻ���
				}
			}) ;
			proDia.setButton2("��ϸ��Ϣ", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			}) ;
			proDia.onStart() ;	// ��������
			new Thread(){
				public void run(){	// �̵߳�������
					for (int x = 0; x < MAX_PROGRESS; x++) {
						try {
							Thread.sleep(500); // ��������
						} catch (Exception e) {
						} 
						proDia.incrementProgressBy(1) ;
					}
					proDia.dismiss() ;
				}
			}.start() ;
			proDia.show() ;	// ��ʾ�Ի���
		}
		
	}

}