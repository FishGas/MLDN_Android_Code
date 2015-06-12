package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.ImageView;

public class MyKeyDemo extends Activity {
	private EditText input = null;
	private ImageView img = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.input = (EditText) super.findViewById(R.id.input); // ȡ�����
		this.img = (ImageView) super.findViewById(R.id.img); // ȡ�����
		this.input.setOnKeyListener(new OnKeyListenerImpl());
	}

	private class OnKeyListenerImpl implements OnKeyListener {

		public boolean onKey(View v, int keyCode, KeyEvent event) {
			switch (event.getAction()) {
			case KeyEvent.ACTION_UP:
				String msg = MyKeyDemo.this.input.getText().toString(); // ȡ�������������Ϣ
				if (msg.matches("\\w+@\\w+\\.\\w+")) { // ��֤ͨ��
					MyKeyDemo.this.img.setImageResource(R.drawable.right); // ������ȷͼƬ
				} else {
					MyKeyDemo.this.img.setImageResource(R.drawable.wrong); // ���ô���ͼƬ
				}
			case KeyEvent.ACTION_DOWN: // ���̰���
				break;
			}
			return false;
		}
	}
}