package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyMessageDemo extends Activity {
	private TextView info = null;
	private static final int SET = 1; // ������what״̬
	private Button but = null; // ������ť

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.info = (TextView) super.findViewById(R.id.info); // ȡ�����
		this.but = (Button) super.findViewById(R.id.but); // ȡ�����
		this.but.setOnClickListener(new OnClickListenerImpl()); // �����¼�
	}

	private class OnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			MyHandler myHandler = new MyHandler();
			myHandler.removeMessages(0); // ��ʾ������е���Ϣ
			String data = "ħ�ֿƼ����ѧԺ��MLDN��"; // Ҫ���ݵ���Ϣ
			Message msg = myHandler.obtainMessage(SET, 1, 1, data); // ������Ϣ
			myHandler.sendMessage(msg); // ������Ϣ
		}

	}

	private class MyHandler extends Handler {
		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) { // �жϲ�������Ϣ����
			case SET: // �������
				MyMessageDemo.this.info.setText(msg.obj.toString()); // �����ı����
			}
		}
	}
}