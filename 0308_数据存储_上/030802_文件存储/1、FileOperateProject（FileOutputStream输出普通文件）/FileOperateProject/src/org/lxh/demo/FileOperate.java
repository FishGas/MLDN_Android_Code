package org.lxh.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import android.app.Activity;
import android.os.Bundle;

public class FileOperate extends Activity {
	private static final String FILENAME = "mldn.txt" ;	// �����ļ�����
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		FileOutputStream output = null ;	// �����ļ��������
		try {
			output = super.openFileOutput(FILENAME, Activity.MODE_PRIVATE) ;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		PrintStream out = new PrintStream(output) ; 	// �������
		out.println("���������˻���") ;
		out.println("���䣺30��") ;
		out.println("��ַ������ħ�ֿƼ����ѧԺ��") ; 
		out.close() ;	// ��Դһ��Ҫ�ر�
	}
}