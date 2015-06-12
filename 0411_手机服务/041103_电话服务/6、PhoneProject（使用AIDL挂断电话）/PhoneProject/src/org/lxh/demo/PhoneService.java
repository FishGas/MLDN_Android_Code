package org.lxh.demo;

import java.lang.reflect.Method;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

import com.android.internal.telephony.ITelephony;

public class PhoneService extends Service {
	private TelephonyManager telephony = null;
	private AudioManager audio = null; // ��������
	private String phoneNumber = null; // Ҫ���˵ĵ绰
	private IBinder myBinder = new BinderImpl();

	class BinderImpl extends Binder implements IService {

		@Override
		public String getInterfaceDescriptor() {
			return "���˵绰��" + PhoneService.this.phoneNumber + "�����óɹ���";
		}

	}

	@Override
	public IBinder onBind(Intent intent) {
		this.phoneNumber = intent.getStringExtra("phonenumber"); // ȡ�õ绰����
		this.audio = (AudioManager) super
				.getSystemService(Context.AUDIO_SERVICE); // ��������
		this.telephony = (TelephonyManager) super
				.getSystemService(Context.TELEPHONY_SERVICE);
		this.telephony.listen(new PhoneStateListenerImpl(),
				PhoneStateListener.LISTEN_CALL_STATE); // ���ü�������
		return this.myBinder;
	}

	private class PhoneStateListenerImpl extends PhoneStateListener {

		@Override
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE: // �Ҷϵ绰
				PhoneService.this.audio
						.setRingerMode(AudioManager.RINGER_MODE_NORMAL); // ������
				break;
			case TelephonyManager.CALL_STATE_RINGING: // ��������
				if (incomingNumber.equals(PhoneService.this.phoneNumber)) { // �绰����ƥ��
					ITelephony iTelephony = getITelephony() ;
					if (iTelephony != null) {
						try {
							iTelephony.endCall() ;	// �Ҷϵ绰
						} catch (RemoteException e) {
							e.printStackTrace();
						}
					}
				}
				break;
			case TelephonyManager.CALL_STATE_OFFHOOK: // �����绰
				break;
			}
		}
	}

	private ITelephony getITelephony() {
		ITelephony iTelephony = null ;
		Class<TelephonyManager> cls = TelephonyManager.class ;
		Method getITelephonyMethod = null ;
		try {
			getITelephonyMethod = cls.getDeclaredMethod("getITelephony") ;
			getITelephonyMethod.setAccessible(true) ;	// ȡ����װ
		} catch (Exception e) {
		}
		try {
			iTelephony = (ITelephony) getITelephonyMethod
					.invoke(this.telephony);
			return iTelephony ;
		} catch (Exception e) {
		}
		return iTelephony ;
	}
}
