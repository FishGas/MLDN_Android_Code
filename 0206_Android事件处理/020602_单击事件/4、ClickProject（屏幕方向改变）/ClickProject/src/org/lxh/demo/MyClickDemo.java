package org.lxh.demo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MyClickDemo extends Activity {
	private Button change = null;
	private ImageView img = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.change = (Button) super.findViewById(R.id.change); // ȡ�ð�ť
		this.img = (ImageView) super.findViewById(R.id.img); // ȡ��ͼƬ
		this.change.setOnClickListener(new MyOnClickListenerImpl()); // ���ü�������
	}

	private class MyOnClickListenerImpl implements OnClickListener { // �����¼�

		public void onClick(View v) {
			if (MyClickDemo.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED) {// �޷����л������ת
				MyClickDemo.this.change.setText("�����޷��ı���Ļ����");
			} else {
				if (MyClickDemo.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) { // ���ڵķ����Ǻ�����ʾ
					MyClickDemo.this
							.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT); // ��Ϊ������ʾ
				} else if (MyClickDemo.this.getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) { // ���Ϊ������ʾ
					MyClickDemo.this
							.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE); // ��Ϊ������ʾ
				}
			}
		}
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) { // ��ʾ����ϵͳ�����޸ĵ�ʱ�򴥷�
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) { // ���ڵ���Ļ�����Ǻ���
			MyClickDemo.this.change.setText("�ı���Ļ����Ϊ������ʾ����ǰΪ������ʾ��");
			MyClickDemo.this.img.setImageResource(R.drawable.mldn_landscape);// ��ʾ����ͼƬ
		} else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) { // ��������
			MyClickDemo.this.change.setText("�ı���Ļ����Ϊ������ʾ����ǰΪ������ʾ��");
			MyClickDemo.this.img.setImageResource(R.drawable.mldn_portrait);// ��ʾ����ͼƬ
		}
		super.onConfigurationChanged(newConfig);
	}

}