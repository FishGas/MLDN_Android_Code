package org.lxh.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MyListViewDemo extends Activity {
	private int pic[] = new int[] { R.drawable.pic_oracle,
			R.drawable.pic_javase, R.drawable.pic_javaweb,
			R.drawable.pic_javaee, R.drawable.pic_android, R.drawable.pic_game };
	private String data[][] = new String[][] { { "Oracle���ݿ�", "ħ�ֿƼ�" },
			{ "Java SE�����γ�", "���˻�" }, { "Java WEB�ۺϿ���", "MLDN" },
			{ "Java EE�߼�����", "���˻�" }, { "AndroidǶ��ʽ����", "���˻�" },
			{ "Java ��Ϸ����", "����" } };

	private ListView datalist = null; // ����ListView���
	private List<Map<String, String>> list = new ArrayList<Map<String, String>>(); // ������ʾ�����ݰ�װ
	private SimpleAdapter simpleAdapter = null; // �������ݵ�ת������

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.datalist = (ListView) super.findViewById(R.id.datalist); // ȡ�����
		for (int x = 0; x < this.data.length; x++) {
			Map<String, String> map = new HashMap<String, String>(); // ����Map���ϣ�����ÿһ������
			map.put("pic", String.valueOf(this.pic[x])); // ��data_list.xml�е�TextView���ƥ��
			map.put("title", this.data[x][0]); // ��data_list.xml�е�TextView���ƥ��
			map.put("author", this.data[x][1]); // ��data_list.xml�е�TextView���ƥ��
			map.put("type", "���");
			map.put("score", String.valueOf(R.drawable.start_05));
			this.list.add(map); // ���������е�������
		} 
		this.simpleAdapter = new SimpleAdapter(this, this.list,
				R.layout.data_list, new String[] { "pic", "title", "author",
						"type", "score" } // Map�е�key������
				, new int[] { R.id.pic, R.id.title, R.id.author, R.id.type,
						R.id.score }); // ��data_list.xml�ж�����������ԴID
		this.datalist.setAdapter(this.simpleAdapter);
	}
}