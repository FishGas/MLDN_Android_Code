package org.lxh.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class PhoneBroadcastReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (Intent.ACTION_NEW_OUTGOING_CALL.equals(intent.getAction())) { // ȥ��
			String outgoingNumber = intent
					.getStringExtra(Intent.EXTRA_PHONE_NUMBER); // ȥ�����
			Intent pit = new Intent(context, PhoneService.class);
			pit.putExtra("outgoingNumber", outgoingNumber);
			context.startService(pit);
		} else { // ����
			context.startService(new Intent(context, PhoneService.class));
		}
	}

}
