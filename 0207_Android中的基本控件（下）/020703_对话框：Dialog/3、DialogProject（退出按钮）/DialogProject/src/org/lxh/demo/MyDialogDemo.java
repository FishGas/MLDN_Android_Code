package org.lxh.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MyDialogDemo extends Activity {
	private ImageButton but = null ;	// ���尴ť
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main); // ���ò��ֹ�����
		this.but = (ImageButton) super.findViewById(R.id.but) ;	// ȡ�ð�ť
		this.but.setOnClickListener(new OnClickListenerImpl()) ;	// �����¼���
	}
	private class OnClickListenerImpl implements OnClickListener {
 
		@Override
		public void onClick(View view) {
			MyDialogDemo.this.exitDialog() ;
		}
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {	// ���ؼ�
			this.exitDialog() ;
		}
		return false ;
	}
	private void exitDialog(){
		Dialog dialog = new AlertDialog.Builder(MyDialogDemo.this)
			.setTitle("�����˳���")		// ��������
			.setMessage("��ȷ��Ҫ�˳���������") // ��ʾ�Ի����е�����
			.setIcon(R.drawable.pic_m) // ����LOGO
			.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					MyDialogDemo.this.finish() ;	// ��������
				}
			}).setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
					
				}
			}).create(); // ������һ���Ի���
		dialog.show() ;	// ��ʾ�Ի���
	}
}