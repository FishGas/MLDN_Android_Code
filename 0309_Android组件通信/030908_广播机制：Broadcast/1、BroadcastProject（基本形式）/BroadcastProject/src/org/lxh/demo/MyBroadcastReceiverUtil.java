package org.lxh.demo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiverUtil extends BroadcastReceiver {
	public MyBroadcastReceiverUtil() { // ���췽��
		System.out.println("** ÿ�ι㲥����ʵ����һ���µĹ㲥������в�����");
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		Toast.makeText(context, "�㲥�Ѿ�����", Toast.LENGTH_SHORT).show();
	}

}
