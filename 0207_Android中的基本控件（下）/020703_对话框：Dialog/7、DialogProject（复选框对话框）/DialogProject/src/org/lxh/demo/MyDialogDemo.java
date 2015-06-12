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
	private String fruitData [] = new String[] { "ƻ��", "����", "ˮ����" };
	private boolean chData[] = new boolean[] { true, true, false };
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main); // ���ò��ֹ�����
		this.mybut = (Button) super.findViewById(R.id.mybut) ;	// ȡ�ð�ť
		this.mych = (TextView) super.findViewById(R.id.mych) ;	// ȡ���ı�
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
					}
				})
				.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
							})
					.setMultiChoiceItems(MyDialogDemo.this.fruitData,
							MyDialogDemo.this.chData,
							new DialogInterface.OnMultiChoiceClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which, boolean isChecked) {
									for (int x = 0; x < MyDialogDemo.this.fruitData.length; x++) {
										if(x == which && isChecked) {	// ��ǰѡ�ѡ��
											MyDialogDemo.this.mych
													.append(MyDialogDemo.this.fruitData[x]
															+ "��");
										}
									}
								}
							}).create();
			dialog.show() ;
		}
		
	}

}