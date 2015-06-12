package org.lxh.demo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;

public class MySharedPreferencesDemo extends Activity {
	private static final String FILENAME = "mldn"; // ������ļ�����

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);

		SharedPreferences share = super.getSharedPreferences(FILENAME,
				Activity.MODE_PRIVATE);

		SharedPreferences.Editor edit = share.edit();
		edit.putString("author", "LiXingHua");
		edit.putInt("age", 30);
		edit.commit();// �ύ����
	}
}