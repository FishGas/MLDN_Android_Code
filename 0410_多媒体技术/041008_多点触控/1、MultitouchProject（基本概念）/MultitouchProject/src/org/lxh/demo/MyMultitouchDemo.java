package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MyMultitouchDemo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		if (event.getPointerCount() == 2) {
			System.out.println("����A��X = " + event.getX(0) + "��Y = "
					+ event.getY(0));
			System.out.println("����B��X = " + event.getX(1) + "��Y = "
					+ event.getY(1));
		}
		return super.onTouchEvent(event);
	}

}