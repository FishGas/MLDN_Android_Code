package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyThreadDemo extends Activity {
	public static final int SETMAIN = 1; // ����һ��what���
	public static final int SETCHILD = 2; // ����what�ı��]
	private Handler mainHandler, childHandler;
	private TextView msg = null;
	private Button but;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.msg = (TextView) super.findViewById(R.id.msg);
		this.but = (Button) super.findViewById(R.id.but);
		this.mainHandler = new Handler(){

			@Override
			public void handleMessage(Message msg) {
				switch(msg.what) {
				case SETMAIN :
					MyThreadDemo.this.msg.setText("���߳̽������ݣ�" + msg.obj.toString()) ;
					break ;
				}
			}
			
		} ;
		new Thread(new ChildThread(), "Child Thread").start();
		this.but.setOnClickListener(new OnClickListenerImpl()) ;
	}

	private class OnClickListenerImpl implements OnClickListener {

		@Override
		public void onClick(View v) {	// �ǽ���Ϣ���͵����߳�֮��
			if (MyThreadDemo.this.childHandler != null) {
				Message childMsg = MyThreadDemo.this.childHandler
						.obtainMessage(); // ������Ϣ
				childMsg.obj = MyThreadDemo.this.mainHandler.getLooper()
						.getThread().getName()
						+ " --> Hello MLDN .";
				childMsg.what = SETCHILD ;
				MyThreadDemo.this.childHandler.sendMessage(childMsg) ;
			}
		}

	}
	
	class ChildThread implements Runnable {

		@Override
		public void run() {	// ���߳�
			Looper.prepare() ;	// 
			MyThreadDemo.this.childHandler = new Handler(){

				@Override
				public void handleMessage(Message msg) {
					switch(msg.what) {
					case SETCHILD: // ���߳̽������̷߳���������Ϣ
						System.out.println("*** Main Child Message : " + msg.obj) ;	// �������
						Message toMain = MyThreadDemo.this.mainHandler.obtainMessage() ;
						toMain.obj = "\n\n[B]�������̷߳��͸����̵߳���Ϣ��" + super.getLooper().getThread().getName() ;
						toMain.what = SETMAIN ;
						MyThreadDemo.this.mainHandler.sendMessage(toMain) ;
						break ;
					}
				}
				
			} ;
			Looper.loop() ;	// ������Ϣ����
		}
		
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		MyThreadDemo.this.childHandler.getLooper().quit() ;
	}
	
	
}