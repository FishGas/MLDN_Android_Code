package org.lxh.demo;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.app.PendingIntent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class MySMSDemo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		String content = "����ħ�ֿƼ����ѧԺ��www.mldnjava.cn����"
				+ "��һ��ר�Ŵ�����Java�߶���ѵ��ְҵ��ѵ������"
				+ "��������ҵ���������Ƚ��Ľ�ѧ��������ѧ���������ĸ���֮����ս�����ѧϰ���ޣ�"
				+ "�ṩ��ͬ��ҵ�������õ�ְҵ��ҵ��Ϣ��Ϊѧ����ҵ���ϳɹ��ĳ��";// ������70����
		SmsManager smsManager = SmsManager.getDefault();
		PendingIntent sentIntent = PendingIntent.getActivity(this, 0,
				super.getIntent(), PendingIntent.FLAG_UPDATE_CURRENT);
		if (content.length() > 70) { // ����70���֣����
			List<String> msgs = smsManager.divideMessage(content); // ���
			Iterator<String> iter = msgs.iterator();
			while (iter.hasNext()) {
				String msg = iter.next();
				smsManager.sendTextMessage("13683527621", null, msg, sentIntent, null);
			}
		} else {
			smsManager.sendTextMessage("13683527621", null, content, sentIntent, null);
		}
		Toast.makeText(this, "���ŷ������", Toast.LENGTH_SHORT).show();
	}
}