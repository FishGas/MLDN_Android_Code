package org.lxh.demo;

import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MyTabHostDemo extends TabActivity { // �̳���TabActivity
	private TabHost myTabHost;
	private int[] layRes = new int[] { R.id.tab_edit, R.id.tab_clock,
			R.id.tab_sex }; // ��Щ����Ƕ�����ļ���ID

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.myTabHost = super.getTabHost(); // ȡ��TabHost����
		LayoutInflater.from(this).inflate(R.layout.tab,
				this.myTabHost.getTabContentView(), true); // true��ʾʵ���������ļ��е����
		for (int x = 0; x < this.layRes.length; x++) {
			TabSpec myTab = this.myTabHost.newTabSpec("tab" + x) ;
			myTab.setIndicator("��ǩ  - " + x) ;
			myTab.setContent(this.layRes[x]) ;
			this.myTabHost.addTab(myTab) ;
		}
	}
}