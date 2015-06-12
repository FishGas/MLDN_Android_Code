package org.lxh.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiverUtil extends BroadcastReceiver {
	@Override
	public void onReceive(Context context, Intent intent) {
		if ("org.lxh.action.MLDN".equals(intent.getAction())) {	// ָ����Action
			String msg = intent.getStringExtra("msg") ;	// ȡ�ø�����Ϣ
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}
	}

}
