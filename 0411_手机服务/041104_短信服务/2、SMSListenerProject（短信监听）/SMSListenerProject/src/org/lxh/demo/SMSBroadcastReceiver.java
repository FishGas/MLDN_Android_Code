package org.lxh.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;

public class SMSBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Object[] pdusData = (Object[]) intent.getExtras().get("pdus"); // ȡ��ȫ�����ŵ�����
		for (int x = 0; x < pdusData.length; x++) {
			byte[] pdus = (byte[]) pdusData[x];	// ȡ��һ�������Ķ���
			SmsMessage msg = SmsMessage.createFromPdu(pdus);
			String messageBody = msg.getMessageBody() ;	// ��Ϣ����
			String phoneNumber = msg.getOriginatingAddress(); // ȡ�õ�ַ
			String receiveData = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS")
					.format(new Date(msg.getTimestampMillis()));
			SmsManager smsManager = SmsManager.getDefault() ;
			PendingIntent sentIntent = PendingIntent.getActivity(context, 0,
					intent, PendingIntent.FLAG_UPDATE_CURRENT);
			String content = "���ź��룺" + phoneNumber + "\n����ʱ�䣺" + receiveData
					+ "\n�������ݣ���" + messageBody + "��";
			System.out.println(content) ;
			smsManager.sendTextMessage("5556", null, content, sentIntent, null) ; 
		}
	}

}
