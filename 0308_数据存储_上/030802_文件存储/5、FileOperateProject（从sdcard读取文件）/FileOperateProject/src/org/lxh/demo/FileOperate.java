package org.lxh.demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

public class FileOperate extends Activity {
	private static final String FILENAME = "mymldn.txt" ;	// �����ļ�����
	private static final String DIR = "mldndata" ;	// �����ļ��е�����
	private TextView msg = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.msg = (TextView) super.findViewById(R.id.msg) ;
		
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			File file = new File(Environment.getExternalStorageDirectory()
					+ File.separator + DIR + File.separator + FILENAME); // ����Ҫ�������ļ�
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs(); // �������ļ���·��
			}
			Scanner scan = null ;
			try {
				scan = new Scanner(new FileInputStream(file)) ;
				while(scan.hasNext()) {
					this.msg.append(scan.next() + "\n") ;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // һ��Ҫ�ر���
				if (scan != null) {
					scan.close();
				}
			}
		} else {
			Toast.makeText(this, "����ʧ�ܣ�SD�������ڣ�", Toast.LENGTH_LONG).show() ;
		}
	}
}