package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyScrollViewDemo extends Activity {
	private String data[] = { "����ħ�ֿƼ�", "www.mldnjava.cn", "��ʦ�����˻�",
			"�й���У��ʦ����", "www.jiangker.com", "��ѯ���䣺mldnqa@163.com",
			"�ͻ�����mldnkf@163.com", "�ͻ��绰��(010) 51283346", "ħ��������bbs.mldn.cn",
			"����Ա��Ƹ����http://www.javajob.cn/" }; // ׼�������ɸ���Ϣ����Щ��Ϣ�Ժ�ͨ��������뵽��Ƕ�����Բ����ļ�֮��

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main); // ����Ĭ�ϵĲ��ֹ�����
		LinearLayout layout = (LinearLayout) super.findViewById(R.id.mylinear); // ȡ�����
		LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT); // ���岼�ֲ���
		for (int x = 0; x < this.data.length; x++) { // ͨ��ѭ����ʽ�����ϵ���Ϣͨ��Button������з�װ
			Button but = new Button(this);
			but.setText(this.data[x]); // ������ʾ����
			layout.addView(but, param); // �������
		}
	}
}