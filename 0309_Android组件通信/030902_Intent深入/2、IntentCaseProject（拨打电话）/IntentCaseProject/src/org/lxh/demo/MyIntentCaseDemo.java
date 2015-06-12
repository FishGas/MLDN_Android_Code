package org.lxh.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyIntentCaseDemo extends Activity {
	private Button mybut = null ;
	private EditText tel = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mybut = (Button) super.findViewById(R.id.mybut) ;	// ȡ�����
		this.tel = (EditText) super.findViewById(R.id.tel) ;	// ȡ�����
		this.mybut.setOnClickListener(new OnClickListenerImpl()) ;
	}
	private class OnClickListenerImpl implements OnClickListener{
		@Override
		public void onClick(View v) {
			String telStr = MyIntentCaseDemo.this.tel.getText().toString() ;	// ȡ��������Ϣ
			Uri uri = Uri.parse("tel:" + telStr) ;	// ���ò�����·��
			Intent it = new Intent() ;
			it.setAction(Intent.ACTION_DIAL) ;	// ����Ҫ������Action
			it.setData(uri) ;	// Ҫ���õ�����
			MyIntentCaseDemo.this.startActivity(it) ;	// ִ����ת
		}
		
	}
}