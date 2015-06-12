package org.lxh.demo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class SMSSendBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("SMS_SEND_ACTION")) { // ���ŷ���
			switch (super.getResultCode()) { // �������
			case Activity.RESULT_OK:
				Toast.makeText(context, "�����ѷ��ͣ�", Toast.LENGTH_SHORT).show();
				break;
			case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
				Toast.makeText(context, "���ŷ���ʧ�ܣ�", Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}

}
