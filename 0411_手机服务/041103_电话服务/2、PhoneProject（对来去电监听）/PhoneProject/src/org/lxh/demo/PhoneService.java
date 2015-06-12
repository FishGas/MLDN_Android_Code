package org.lxh.demo;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneService extends Service {
	private TelephonyManager telephony = null;
	private String outgoingNumber = null ;

	@Override
	public void onCreate() { // ���񴴽���ʱ�����
		super.onCreate();
		this.telephony = (TelephonyManager) super
				.getSystemService(Context.TELEPHONY_SERVICE);
		this.telephony.listen(new PhoneStateListenerImpl(),
				PhoneStateListener.LISTEN_CALL_STATE); // ���ü�������
	}

	
	@Override
	public void onStart(Intent intent, int startId) {
		this.outgoingNumber = intent.getStringExtra("outgoingNumber") ;
		super.onStart(intent, startId);
	}



	private class PhoneStateListenerImpl extends PhoneStateListener {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE: // �Ҷϵ绰
				break;
			case TelephonyManager.CALL_STATE_RINGING: // ��������
				System.out.println("����绰���룺"
						+ incomingNumber
						+ "������ʱ�䣺"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(new Date()));
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK: // �����绰
				System.out.println("�����绰���룺"
						+ PhoneService.this.outgoingNumber
						+ "������ʱ�䣺"
						+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
								.format(new Date()));
				break;
			}
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
