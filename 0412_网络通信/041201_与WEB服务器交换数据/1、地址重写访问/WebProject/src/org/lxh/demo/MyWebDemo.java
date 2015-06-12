package org.lxh.demo;

import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MyWebDemo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		TextView info = (TextView) super.findViewById(R.id.info);
		boolean flag = false ;	// �ɹ����ı��
		try {
			URL url = new URL("http", "114.249.165.249", 80,
					"/mldn/android.jsp?id=lixinghua&password=mldn");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			byte data[] = new byte[512];
			int len = conn.getInputStream().read(data); // ��������ȡ
			if (len > 0) {	// �Ѿ���ȡ������
				String temp = new String(data, 0, len).trim();
				flag = Boolean.parseBoolean(temp) ;	// ȡ�������boolean������
			}
			conn.getInputStream().close() ;
		} catch (Exception e) {
			info.setText("WEB����������ʧ�ܣ�") ;
		}
		if(flag){
			info.setText("�û���¼�ɹ���") ;
		} else {
			info.setText("�û���¼ʧ�ܣ�") ;
		}
	}
}