package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
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
			RotateAnimation rotate = new RotateAnimation(
					0,360 ,	// 0~360��
					Animation.RELATIVE_TO_PARENT,0.5f ,	// Y�Ὺʼλ��
					Animation.RELATIVE_TO_PARENT,0.0f );	// Y���ƶ�λ��
			rotate.setDuration(3000); // 3����ɶ���
			set.addAnimation(rotate); // ���Ӷ���
			MyAnimationDemo.this.mldn.startAnimation(set); // ��������
		}
	}
}