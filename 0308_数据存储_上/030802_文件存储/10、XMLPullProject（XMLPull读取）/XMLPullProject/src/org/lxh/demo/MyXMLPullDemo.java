package org.lxh.demo;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyXMLPullDemo extends Activity {
	private TextView name = null;
	private TextView email = null;
	private Button but = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.name = (TextView) super.findViewById(R.id.name);
		this.email = (TextView) super.findViewById(R.id.email);
		this.but = (Button) super.findViewById(R.id.but);
		this.but.setOnClickListener(new OnClickListenerImpl());
	}

	private class OnClickListenerImpl implements OnClickListener {

		@Override
		public void onClick(View v) {
			if (!Environment.getExternalStorageState().equals(
					Environment.MEDIA_MOUNTED)) { // �����ڲ�����
				return; // ���ص�����ı����ô�
			}
			File file = new File(Environment.getExternalStorageDirectory()
					+ File.separator + "mldndata" + File.separator
					+ "member.xml"); // Ҫ����ļ���·��
			if (!file.exists()) { // �ļ�������
				return;
			}
			try {
				InputStream input = new FileInputStream(file);
				MyXMLPullUtil util = new MyXMLPullUtil(input) ;
				List<LinkMan> all = util.getAllLinkMan() ;
				MyXMLPullDemo.this.name.setText(all.get(0).getName()) ;
				MyXMLPullDemo.this.email.setText(all.get(0).getEmail()) ;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}