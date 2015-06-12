package org.lxh.demo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MySharedPreferencesDemo extends Activity {
	private static final String FILENAME = "mldn"; // ������ļ�����
	
	private TextView authorinfo = null ;
	private TextView ageinfo = null ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		
		this.authorinfo = (TextView) super.findViewById(R.id.authorinfo) ;
		this.ageinfo = (TextView) super.findViewById(R.id.ageinfo) ;

		SharedPreferences share = super.getSharedPreferences(FILENAME,
				Activity.MODE_PRIVATE);

		this.authorinfo.setText("���ߣ�" + share.getString("author", "û��������Ϣ��")) ;
		this.ageinfo.setText("���䣺" + share.getInt("age", 0)) ;
	}
}