package org.lxh.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MyAnimationDemo extends Activity {
	private ListView myListView = null ;
	private String idData [] = new String[] {"mldn","lxh","bbs","javajob"} ;
	private String titleData [] = new String[] {"ħ�ֿƼ�","�� �� ��","ħ������","�� Ƹ ��"} ;
	private SimpleAdapter simple = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.myListView = (ListView) super.findViewById(R.id.myListView) ;
		List<Map<String,Object>> all = new ArrayList<Map<String,Object>>() ;
		Map<String,Object> map = null ;
		for (int x = 0; x < this.idData.length; x++) {
			map = new HashMap<String,Object>() ;
			map.put("id", this.idData[x]) ;
			map.put("title", this.titleData[x]) ;
			all.add(map) ;
		}
		this.simple = new SimpleAdapter(this, all, R.layout.info, new String[] {
				"id", "data" }, new int[] { R.id.id, R.id.title });
		this.myListView.setAdapter(this.simple) ;
	}
}