package org.lxh.demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FileOperate extends Activity {
	private static final String FILENAME = "mldn.txt" ;	// �����ļ�����
	private TextView msg = null ;		// �ı����
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.msg = (TextView) super.findViewById(R.id.msg) ; 
		FileInputStream input = null ;
		try {
			input = super.openFileInput(FILENAME) ;	// ȡ��������
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Scanner scan = new Scanner(input) ;
		while(scan.hasNext()) {
			this.msg.append(scan.next() + "\n") ;
		}
		scan.close() ;
	}
}