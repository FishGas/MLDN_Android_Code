package org.lxh.demo;

import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MySQLiteDemo extends Activity {
	private ListView listView ;
	private SimpleAdapter simpleAdapter = null ;
	private LinearLayout loadLayout = null ;	// ��ȡ�Ľű����ͼ
	private TextView loadInfo = null ;	// ������Ϣ��ʾ
	private List<Map<String,Object>> all = null ;
	private LayoutParams layoutParams = new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.FILL_PARENT,
			LinearLayout.LayoutParams.WRAP_CONTENT);	// ��ʾ������Ĳ��ֲ���
	private SQLiteOpenHelper helper = null ;
	private LinearLayout mylayout = null ;
	private int currentPage = 1 ;
	private int lineSize = 15 ;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mylayout = (LinearLayout) super.findViewById(R.id.mylayout) ;
		this.loadLayout = new LinearLayout(this) ;	// ����ű�����Բ��ֹ�����
		this.loadInfo = new TextView(this) ;	// �ı����
		this.loadInfo.setText("���ݼ�����ing...") ;	// ������ʾ����
		this.loadInfo.setGravity(Gravity.CENTER) ;	// ���־�����ʾ
		this.loadInfo.setTextSize(30.0f) ;	// ���ִ�С
		this.loadLayout.addView(this.loadInfo,this.layoutParams) ;	// �������
		this.loadLayout.setGravity(Gravity.CENTER) ;
		this.showAllData() ;	// ������ʾ
	}
	private void showAllData(){	// ��ȡȫ��������
		MySQLiteDemo.this.helper = new MyDatabaseHelper(MySQLiteDemo.this);
		this.listView = new ListView(MySQLiteDemo.this) ;
		MySQLiteDemo.this.all = new MytabCursor(	// ʵ������ѯ
				MySQLiteDemo.this.helper.getReadableDatabase())	// ȡ��SQLiteDatabase����
			.find(MySQLiteDemo.this.currentPage,MySQLiteDemo.this.lineSize) ;
		this.listView.addFooterView(this.loadLayout) ;	// ���Ӷ�ȡ���ݵĲ����ļ�
		this.listView.setAdapter( // Ҫ��������
				new SimpleAdapter(MySQLiteDemo.this, 	// �����Ķ���
						MySQLiteDemo.this.all,			// ����Ҫ����������
						R.layout.tab_info,				// ���ֹ����� 
						new String[] { "id", "name", "birthday" },	// map�е�key
						new int[] { R.id.id, R.id.name, R.id.birthday }));	// ���ֹ����е�id
		this.listView.setOnScrollListener(new OnScrollListenerImpl()) ;
		this.mylayout.addView(listView) ;
	}
	private class OnScrollListenerImpl implements OnScrollListener{

		@Override
		public void onScroll(AbsListView view, int firstVisibleItem,
				int visibleItemCount, int totalItemCount) {
			System.out.println("firstVisibleItem = " + firstVisibleItem) ;
			System.out.println("visibleItemCount = " + visibleItemCount) ;
			System.out.println("totalItemCount = " + totalItemCount) ;
			System.out.println("***************************************************") ;
		}

		@Override
		public void onScrollStateChanged(AbsListView view, int scrollState) {
			
		}
		
	}
}