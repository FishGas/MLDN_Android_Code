package org.lxh.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MyAsyncTaskListFileDemo extends Activity {
	private List<Map<String,Object>> allFileItems = new ArrayList<Map<String,Object>>() ;
	private SimpleAdapter simple = null ;
	private ListView list = null ;
	private ListFileThread ft = null ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.list = (ListView) super.findViewById(R.id.list) ;
		File filePath = new File(java.io.File.separator); // �Ӹ�Ŀ¼�¿�ʼ�г�
		this.list.setOnItemClickListener(new OnItemClickListenerImpl()) ;
		this.ft = new ListFileThread() ;
		this.ft.execute(filePath) ;
	}
	
	private class OnItemClickListenerImpl implements OnItemClickListener{

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			File currFile = (File) MyAsyncTaskListFileDemo.this.allFileItems
					.get(position).get("name");
			if (currFile.isDirectory()) { // ��ǰ��һ��Ŀ¼
				MyAsyncTaskListFileDemo.this.allFileItems = new ArrayList<Map<String,Object>>() ;
				MyAsyncTaskListFileDemo.this.ft = new ListFileThread() ;
				MyAsyncTaskListFileDemo.this.ft.execute(currFile) ;
			}
		}
		
	}
	
	private class ListFileThread extends AsyncTask<File, File, String> {
		
		@Override
		protected void onProgressUpdate(File... values) {
			Map<String,Object> fileItem = new HashMap<String,Object>() ;	// ��ʾ���Է���
			if (values[0].isDirectory()) {
				fileItem.put("img", R.drawable.folder_close); // �ļ���
			} else {	// ���ļ�
				fileItem.put("img",R.drawable.file) ;
			}
			fileItem.put("name", values[0]) ;
			MyAsyncTaskListFileDemo.this.allFileItems.add(fileItem) ;
			MyAsyncTaskListFileDemo.this.simple = new SimpleAdapter(
					MyAsyncTaskListFileDemo.this,
					MyAsyncTaskListFileDemo.this.allFileItems,
					R.layout.file_list, new String[] { "img", "name" },
					new int[] { R.id.img, R.id.name });
			MyAsyncTaskListFileDemo.this.list
					.setAdapter(MyAsyncTaskListFileDemo.this.simple);
		}

		@Override
		protected String doInBackground(File... params) {
			if (!params[0].getPath().equals(java.io.File.separator)) { // ���Ǹ�Ŀ¼
				Map<String,Object> fileItem = new HashMap<String,Object>() ;	// ��ʾ���Է���
				fileItem.put("img",R.drawable.folder_open) ;	// ���Է���
				fileItem.put("name", params[0].getParentFile()) ;
				MyAsyncTaskListFileDemo.this.allFileItems.add(fileItem) ;
			}
			if (params[0].isDirectory()) {	// ���ļ���
				File tempFile [] = params[0].listFiles() ;
				if(tempFile != null) {
					for (int x = 0; x < tempFile.length; x++) {
						this.publishProgress(tempFile[x]) ;
					}
				}
			}
			return "�ļ����г�";
		}
	}
}