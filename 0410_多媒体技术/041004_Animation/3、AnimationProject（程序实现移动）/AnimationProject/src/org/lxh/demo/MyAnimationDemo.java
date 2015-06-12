package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
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
			TranslateAnimation tran = new TranslateAnimation(
					Animation.RELATIVE_TO_SELF,0.0f ,	// X�Ὺʼλ��
					Animation.RELATIVE_TO_SELF,0.5f ,	// X���ƶ��Ľ���λ��
					Animation.RELATIVE_TO_SELF,0.0f ,	// Y�Ὺʼλ��
					Animation.RELATIVE_TO_SELF,1.5f );	// Y���ƶ�λ��
			tran.setDuration(3000); // 3����ɶ���
			set.addAnimation(tran); // ���Ӷ���
			MyAnimationDemo.this.mldn.startAnimation(set); // ��������
		}
	}
}