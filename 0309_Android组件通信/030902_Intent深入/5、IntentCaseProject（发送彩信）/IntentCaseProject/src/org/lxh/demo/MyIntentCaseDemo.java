package org.lxh.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyIntentCaseDemo extends Activity {
	private Button mybut = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mybut = (Button) super.findViewById(R.id.mybut) ;	// ȡ�����
		this.mybut.setOnClickListener(new OnClickListenerImpl()) ;
	}
	private class OnClickListenerImpl implements OnClickListener{
		@Override
		public void onClick(View v) {
			Uri uri = Uri.parse("file:///sdcard/mypic.jpg") ;	// ���ò�����·��
			Intent it = new Intent() ; 
			it.setAction(Intent.ACTION_SEND) ;	// ����Ҫ������Action
			it.putExtra("address","13683527621") ;	// ���ö�������
			it.putExtra("sms_body","����ħ�ֿƼ����ѧԺ") ;	// ���ö�������
			it.putExtra(Intent.EXTRA_STREAM, uri); // ���ö�������
			it.setType("image/png") ;	// ���ŵ�MIME����
			MyIntentCaseDemo.this.startActivity(it) ;	// ִ����ת
		}
		
	}
}