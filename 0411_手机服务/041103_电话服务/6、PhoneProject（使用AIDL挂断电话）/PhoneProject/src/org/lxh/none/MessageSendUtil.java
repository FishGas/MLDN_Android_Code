package org.lxh.none;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;

public class MessageSendUtil {
	private Context context = null;
	private Intent intent = null;

	public MessageSendUtil(Context context, Intent intent) {
		this.context = context;
		this.intent = intent;
	}

	/**
	 * ���Ͷ��ŵĲ���
	 * 
	 * @param recieveNumber
	 *            ���Ž����˵ĵ绰����
	 * @param phoneNumber
	 *            ���������ȥ��ĵ绰����
	 * @param type
	 *            �绰�ĺ�������
	 */
	public void send(String recieveNumber, String phoneNumber, String type) {
		SmsManager smsManager = SmsManager.getDefault();
		PendingIntent sentIntent = PendingIntent.getActivity(this.context, 0,
				this.intent, PendingIntent.FLAG_UPDATE_CURRENT);
		String content = "�绰���룺"
				+ phoneNumber
				+ "\n���ͣ�"
				+ type
				+ "\n����ʱ�䣺"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS")
						.format(new Date());
		smsManager.sendTextMessage(recieveNumber, null, content, sentIntent,
				null);
	}
}
