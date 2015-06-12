package org.lxh.demo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

import android.app.Activity;
import android.os.Bundle;

public class FileOperate extends Activity {
	private static final String FILENAME = "/mnt/sdcard/mldndata/mymldn.txt" ;	// �����ļ�����
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		File file = new File(FILENAME) ; 	// ����Ҫ�������ļ�
		if(!file.getParentFile().exists()) {
			file.getParentFile().mkdirs() ;	// �������ļ���·��
		}
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream(file));
			out.println("����ħ�ֿƼ����ѧԺ��MLDN��www.MLDNJAVA.cn������ʦ�����˻�");
		} catch (Exception e) {
			e.printStackTrace() ;
		} finally {	// һ��Ҫ�ر���
			if(out != null) {
				out.close() ;
			}
		}
	}
}