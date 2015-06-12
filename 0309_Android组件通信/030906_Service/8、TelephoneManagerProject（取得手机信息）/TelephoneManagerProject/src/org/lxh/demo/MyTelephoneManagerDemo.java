package org.lxh.demo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MyTelephoneManagerDemo extends Activity {
	private ListView infolist = null ;
	private ListAdapter adapter = null ;
	private List<String> all = new ArrayList<String>() ;
	private TelephonyManager manager = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.infolist = (ListView) super.findViewById(R.id.infolist) ;
		this.manager = (TelephonyManager) super
				.getSystemService(Context.TELEPHONY_SERVICE); // �绰����
		this.list() ;
	}
	private void list(){	// �г�һЩ��Ϣ
		this.all.add(this.manager.getLine1Number() == null ? "û���ֻ�����" : "�ֻ����룺"
				+ this.manager.getLine1Number());
		this.all.add(this.manager.getNetworkOperatorName() == null ? "û���ƶ�������"
				: "�ƶ������̣�" + this.manager.getNetworkOperatorName());
		if (this.manager.getPhoneType() == TelephonyManager.NETWORK_TYPE_CDMA) {
			this.all.add("�ƶ����磺CDMA");
		} else if (this.manager.getPhoneType() == TelephonyManager.NETWORK_TYPE_GPRS) {
			this.all.add("�ƶ����磺GPRS");
		} else {
			this.all.add("�ƶ����磺δ֪");
		}
		if (this.manager.getNetworkType() == TelephonyManager.PHONE_TYPE_GSM) {
			this.all.add("�������ͣ�GSM");
		} else if (this.manager.getNetworkType() == TelephonyManager.PHONE_TYPE_CDMA) {
			this.all.add("�������ͣ�CDMA");
		} else {
			this.all.add("�������ͣ�δ֪");
		}
		this.all.add("�Ƿ����Σ�" + (this.manager.isNetworkRoaming() ? "����" : "������"));
		this.adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, this.all);
		this.infolist.setAdapter(this.adapter) ;
	}
}