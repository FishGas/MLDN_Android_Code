package org.lxh.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyDialogDemo extends Activity {
	private Button mybut = null ;	// ���尴ť
	private TextView mych = null ;	// �����ı�
	private TextView mytext = null ;	// �����ı�
	private String fruitData [] = new String[] { "ƻ��", "����", "ˮ����" };
	private String fruitDesc [] = new String[] {
			"ƻ����ֲ����ˮ������λ��������зḻ��Ӫ���ɷ֣���ʳ�ơ��������Ƶȹ��ܡ�",
			"���ϣ�ѧ����Citrullus Lanatus��Ӣ�ģ�Watermelon��������«�ƣ�ԭ���ڷ��ޡ�",
			"ˮ���ң���ֲ�����ѧ������Ǿޱ�ƣ�÷������������Ϊ��ҶС��ľ��"} ;
	private int chNum = 0 ;	// ����ѡ��
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main); // ���ò��ֹ�����
		this.mybut = (Button) super.findViewById(R.id.mybut) ;	// ȡ�ð�ť
		this.mych = (TextView) super.findViewById(R.id.mych) ;	// ȡ���ı�
		this.mytext = (TextView) super.findViewById(R.id.mytext) ;	// ȡ���ı�
		this.mybut.setOnClickListener(new OnClickListenerImpl()) ;	// �����¼���
	}
	private class OnClickListenerImpl implements OnClickListener {
 
		@Override
		public void onClick(View view) {
			Dialog dialog = new AlertDialog.Builder(MyDialogDemo.this)
				.setIcon(R.drawable.pic_m) 
				.setTitle("��ѡ����ϲ���Ե�ˮ����")
				.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
									MyDialogDemo.this.mych
											.setText(MyDialogDemo.this.fruitData[MyDialogDemo.this.chNum]);	// ����ѡ�������
					}
				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				}).setSingleChoiceItems(MyDialogDemo.this.fruitData, 0, new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
									MyDialogDemo.this.mytext
											.setText(MyDialogDemo.this.fruitDesc[which]);
									MyDialogDemo.this.chNum = which ;	// ����ѡ�������
					}
				}).create() ;
			dialog.show() ;
		}
		
	}

}