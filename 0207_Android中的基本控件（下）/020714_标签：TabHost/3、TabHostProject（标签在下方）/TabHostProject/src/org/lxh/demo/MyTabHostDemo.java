package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MyTabHostDemo extends Activity { // �̳���TabActivity
	private TabHost myTabHost;
	private int[] layRes = new int[] { R.id.tab_edit, R.id.tab_clock,
			R.id.tab_sex }; // ��Щ����Ƕ�����ļ���ID
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.tab) ; 
		this.myTabHost = (TabHost) super.findViewById(R.id.tabhost) ;
		this.myTabHost.setup() ;	// ����TabHost���� 
		for (int x = 0; x < this.layRes.length; x++) {
			TabSpec myTab = this.myTabHost.newTabSpec("tab" + x) ;
			myTab.setIndicator("��ǩ  - " + x) ;
			myTab.setContent(this.layRes[x]) ;
			this.myTabHost.addTab(myTab) ;
		}
		this.myTabHost.setCurrentTab(0) ;	// Ĭ����ʾ�ı�ǩ����
	}
}