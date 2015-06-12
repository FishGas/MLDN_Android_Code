package org.lxh.demo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class MyView extends View {

	public MyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawColor(Color.WHITE) ;	// ��ɫ
		Paint paint = new Paint() ;
		paint.setColor(Color.BLUE) ;	// ����ͼ�εĵ�ɫ
		canvas.drawCircle(30, 50, 25, paint) ;
		paint.setColor(Color.BLACK) ;
		canvas.drawRect(80,20,160,80, paint) ;
		
		Rect rect = new Rect() ;	// �������
		rect.set(180, 20, 300, 80) ;
		paint.setStyle(Style.STROKE) ;
		canvas.drawRect(rect, paint) ;
	}
	
}
