package org.lxh.demo;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

public class MyMessageDemo extends Activity {
	private TextView info = null ;
	private static int count = 0 ;	// ��ʾ���º�ļ�¼
	private static final int SET = 1 ;	// ������what״̬
	
	private Handler myHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch(msg.what) {	// �жϲ�������Ϣ����
			case SET:	// �������
				MyMessageDemo.this.info.setText("MLDN - " + count ++) ;
			}
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.info = (TextView) super.findViewById(R.id.info) ;	// ȡ�����
		Timer timer = new Timer() ;
		timer.schedule(new MyTask(), 0,1000) ;
		
	}
	private class MyTask extends TimerTask{

		@Override
		public void run() {
			Message msg = new Message() ;	// ���ø���
			msg.what = SET ;	// �����ı��
			MyMessageDemo.this.myHandler.sendMessage(msg) ;	// ������Ϣ
		}
		
	}
}