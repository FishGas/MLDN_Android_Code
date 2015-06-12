package org.lxh.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.Toast;

public class FileOperate extends Activity {
	private static final String FILENAME = "mymldn.txt" ;	// �����ļ�����
	private static final String DIR = "mldndata" ;	// �����ļ��е�����
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		
		if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			File file = new File(Environment.getExternalStorageDirectory()
					+ File.separator + DIR + File.separator + FILENAME); // ����Ҫ�������ļ�
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs(); // �������ļ���·��
			}
			PrintStream out = null;
			try {
				out = new PrintStream(new FileOutputStream(file));
				out.println("����ħ�ֿƼ����ѧԺ��MLDN��www.MLDNJAVA.cn������ʦ�����˻�");
			} catch (Exception e) {
				e.printStackTrace();
			} finally { // һ��Ҫ�ر���
				if (out != null) {
					out.close();
				}
			}
		} else {
			Toast.makeText(this, "����ʧ�ܣ�SD�������ڣ�", Toast.LENGTH_LONG).show() ;
		}
	}
}