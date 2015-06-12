package org.lxh.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		Bitmap bitmap = BitmapFactory.decodeResource(super.getResources(),
				R.drawable.android_mldn);	// �ҵ�ͼƬ��Bitmap����
		Paint paint = new Paint() ;
		paint.setAntiAlias(true); // �������
		canvas.drawBitmap(bitmap, 0, 0, paint) ;
		paint.setColor(Color.WHITE) ;	// ��ɫ
		paint.setTextSize(20) ;
		canvas.drawText(
				"ͼƬ�߶ȣ�" + bitmap.getHeight() + "��ͼƬ��ȣ�" + bitmap.getWidth(),
				10, bitmap.getHeight() + 20, paint);
	}
}
