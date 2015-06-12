package org.lxh.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class MyJSONDemo extends Activity {
	private String nameData[] = new String[] { "���˻�", "ħ�ֿƼ�", "MLDN" };
	private int ageData[] = new int[] { 30, 5, 7 };
	private boolean isMarraiedData[] = new boolean[] { false, true, false };
	private double salaryData[] = new double[] { 3000.0, 5000.0, 9000.0 };
	private Date birthdayData[] = new Date[] { new Date(), new Date(),
			new Date() };
	private String companyName = "����ħ�ֿƼ����ѧԺ��MLDN���ʵѵ���ģ�" ;
	private String companyAddr = "��������������������6��" ;
	private String companyTel = "010-51283346" ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		JSONObject allData = new JSONObject(); // ����������Ľڵ����
		JSONArray sing = new JSONArray(); // ��������
		for (int x = 0; x < this.nameData.length; x++) { // �������������õ���Ӧ�Ľڵ�
			JSONObject temp = new JSONObject(); // ÿһ����װ�����ݶ���JSONObject
			try {
				temp.put("name", this.nameData[x]);
				temp.put("age", this.ageData[x]);
				temp.put("married", this.isMarraiedData[x]);
				temp.put("salary", this.salaryData[x]);
				temp.put("birthday", this.birthdayData[x]);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			sing.put(temp); // ������JSONObject
		}
		try {
			allData.put("persondata", sing);
			allData.put("company", this.companyName) ; 
			allData.put("address", this.companyAddr) ;
			allData.put("telephone", this.companyTel) ;
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if (!Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED)) { // �����ڲ�����
			return; // ���ص�����ı����ô�
		}
		File file = new File(Environment.getExternalStorageDirectory()
				+ File.separator + "mldndata" + File.separator + "json.txt"); // Ҫ����ļ���·��
		if (!file.getParentFile().exists()) { // �ļ�������
			file.getParentFile().mkdirs(); // �����ļ���
		}
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream(file));
			out.print(allData.toString()); // �����ݱ�Ϊ�ַ����󱣴�
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close(); // �ر����
			}
		}
	}
}