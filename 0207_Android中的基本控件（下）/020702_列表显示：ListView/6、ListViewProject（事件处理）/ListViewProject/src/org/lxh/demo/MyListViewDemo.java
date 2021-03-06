package org.lxh.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MyListViewDemo extends Activity {
	private String data[][] = { { "001", "北京魔乐科技" },
			{ "002", "www.mldnjava.cn" }, { "003", "讲师：李兴华" },
			{ "004", "中国高校讲师联盟" }, { "005", "www.jiangker.com" },
			{ "006", "咨询邮箱：mldnqa@163.com" }, { "007", "客户服务：mldnkf@163.com" },
			{ "008", "客户电话：(010) 51283346" }, { "009", "魔乐社区：bbs.mldn.cn" },
			{ "010", "程序员招聘网：http://www.javajob.cn/" } }; // 准备出若干个信息而这些信息以后将通过程序加入到内嵌的线性布局文件之中
	private ListView datalist = null; // 定义ListView组件
	private List<Map<String, String>> list = new ArrayList<Map<String, String>>(); // 定义显示的内容包装
	private SimpleAdapter simpleAdapter = null; // 进行数据的转换操作
	private TextView info = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.datalist = (ListView) super.findViewById(R.id.datalist); // 取得组件
		this.info = (TextView) super.findViewById(R.id.info); // 取得组件
		for (int x = 0; x < this.data.length; x++) {
			Map<String, String> map = new HashMap<String, String>(); // 定义Map集合，保存每一行数据
			map.put("_id", this.data[x][0]); // 与data_list.xml中的TextView组加匹配
			map.put("name", this.data[x][1]); // 与data_list.xml中的TextView组加匹配
			this.list.add(map); // 保存了所有的数据行
		}
		this.simpleAdapter = new SimpleAdapter(this, this.list,
				R.layout.data_list, new String[] { "_id", "name" } // Map中的key的名称
				, new int[] { R.id._id, R.id.name }); // 是data_list.xml中定义的组件的资源ID
		this.datalist.setAdapter(this.simpleAdapter);
		this.datalist.setOnItemClickListener(new OnItemClickListenerImpl()); // 单击选项
	}

	private class OnItemClickListenerImpl implements OnItemClickListener {

		@SuppressWarnings("unchecked")
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			Map<String, String> map = (Map<String, String>) MyListViewDemo.this.simpleAdapter
					.getItem(position);
			String _id = map.get("_id");
			String name = map.get("name");
			MyListViewDemo.this.info.setText("选中的数据项ID是：" + _id + "，名称是："
					+ name);
		}
	}
}