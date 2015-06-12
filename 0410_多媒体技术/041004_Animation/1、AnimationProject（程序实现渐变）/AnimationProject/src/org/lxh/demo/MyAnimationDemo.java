package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.widget.ImageView;

public class MyAnimationDemo extends Activity {
	private ImageView mldn = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mldn = (ImageView) super.findViewById(R.id.mldn);
		this.mldn.setOnClickListener(new OnClickListenerImpl());
	}

	private class OnClickListenerImpl implements OnClickListener {

		@Override
		public void onClick(View v) {
			AnimationSet set = new AnimationSet(true);
			AlphaAnimation alpha = new AlphaAnimation(1, 0); // ����ȫ��ʾ --> ��ȫ͸��
			alpha.setDuration(3000); // 3����ɶ���
			set.addAnimation(alpha); // ���Ӷ���
			MyAnimationDemo.this.mldn.startAnimation(set); // ��������
		}

	}
}