package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class MyLongClickDemo extends Activity {
	private TextView info = null;
	private ImageView img = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.img = (ImageView) super.findViewById(R.id.img);
		this.info = (TextView) super.findViewById(R.id.info);
		this.img.setOnLongClickListener(new OnLongClickListenerImpl());
	}

	private class OnLongClickListenerImpl implements OnLongClickListener {

		public boolean onLongClick(View v) {
			try {
				MyLongClickDemo.this.clearWallpaper(); // ������е�����
				MyLongClickDemo.this.setWallpaper(MyLongClickDemo.this.img
						.getResources().openRawResource(R.drawable.mldn_bg)); // ��������
				MyLongClickDemo.this.info.setText("�ֻ����汳�����޸ġ�");
			} catch (Exception e) {
				e.printStackTrace() ;
				MyLongClickDemo.this.info.setText("�ֻ����汳������ʧ�ܡ�");
			}
			return false;
		}
	}
}