package org.lxh.demo;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.os.Bundle;

public class MyNotificationDemo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		NotificationManager notificationManager = (NotificationManager) super
				.getSystemService(Activity.NOTIFICATION_SERVICE);
		Notification notification = new Notification(R.drawable.pic_m,
				"����MLDN����Ϣ��", System.currentTimeMillis()); // ���̷���һ����Ϣ
		PendingIntent contentIntent = PendingIntent.getActivity(this, 0,
				super.getIntent(), PendingIntent.FLAG_UPDATE_CURRENT); // ������һ��PendingIntent����
		notification.setLatestEventInfo(this, "ħ�ֿƼ�",
				"����ħ�ֿƼ����ѧԺ��www.MLDNJAVA.cn��", contentIntent);
		notificationManager.notify("MLDN", R.drawable.pic_m, notification);
	}
}