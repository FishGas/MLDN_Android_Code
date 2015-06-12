package org.lxh.demo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;

public class MyJSONDemo extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		String data[] = new String[] { "www.mldnjava.cn", "lixinghua",
				"bbs.mldn.cn" }; // Ҫ���������
		JSONObject allData = new JSONObject(); // ����������Ľڵ����
		JSONArray sing = new JSONArray(); // ��������
		for (int x = 0; x < data.length; x++) { // �������������õ���Ӧ�Ľڵ�
			JSONObject temp = new JSONObject(); // ÿһ����װ�����ݶ���JSONObject
			try {
				temp.put("myurl", data[x]);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			sing.put(temp); // ������JSONObject
		}
		try {
			allData.put("urldata", sing);
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