package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

public class MyAnimationDemo extends Activity {
	private ImageView mldn = null;
	private ViewGroup group = null ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mldn = (ImageView) super.findViewById(R.id.mldn);
		this.group = (ViewGroup) super.findViewById(R.id.group);
		AnimationSet set = new AnimationSet(true);
		TranslateAnimation tran = new TranslateAnimation(
				Animation.RELATIVE_TO_SELF,0.0f ,	// X�Ὺʼλ��
				Animation.RELATIVE_TO_SELF,0.5f ,	// X���ƶ��Ľ���λ��
				Animation.RELATIVE_TO_SELF,0.0f ,	// Y�Ὺʼλ��
				Animation.RELATIVE_TO_SELF,1.5f );	// Y���ƶ�λ��
		tran.setDuration(6000); // 3����ɶ���
		set.addAnimation(tran); // ���Ӷ���
		set.setAnimationListener(new AnimationListenerImpl()) ;
		this.mldn.startAnimation(set); // ��������
	}

	private class AnimationListenerImpl implements AnimationListener {

		@Override
		public void onAnimationEnd(Animation animation) {
			MyAnimationDemo.this.group.removeView(MyAnimationDemo.this.mldn) ;
		}

		@Override
		public void onAnimationRepeat(Animation animation) {
			
		}

		@Override
		public void onAnimationStart(Animation animation) {
			if(animation instanceof AnimationSet) {
				AnimationSet set = (AnimationSet) animation ;
				AlphaAnimation alpha = new AlphaAnimation(1, 0);
				alpha.setDuration(3000) ;
				set.addAnimation(alpha) ;
			}
		}
		
	}
}