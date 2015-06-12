package org.lxh.demo;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

public class MyExpandableListAdapter extends BaseExpandableListAdapter {
	// һ�����¿϶����ж����ѡ��
	private String[] groups = new String[] { "�ҵĺ���", "����", "ͬ��", "������" };	// ������
	private String[][] children = new String[][] {
			{ "���˻�", "����", "����", "MLDN" }, { "����", "ĸ��" },
			{ "����", "����", "����" }, { "Ʊ����", "�����" } };	// �����涨�����ѡ��
	private Context context = null ;
	public MyExpandableListAdapter(Context context) {
		this.context = context ;
	}
	@Override
	public Object getChild(int groupPosition, int childPosition) {	// ȡ��ָ������ѡ��
		return this.children[groupPosition][childPosition];
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	
	private TextView buildTextView() {
		AbsListView.LayoutParams params = new AbsListView.LayoutParams(
				ViewGroup.LayoutParams.FILL_PARENT, 35);
		TextView textView = new TextView(this.context) ;
		textView.setLayoutParams(params) ;
		textView.setTextSize(15.0f) ;
		textView.setGravity(Gravity.LEFT) ;
		textView.setPadding(40, 8, 3, 3) ;
		return textView ;
	}
	
	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		TextView textView = this.buildTextView() ;
		textView.setText(this.getChild(groupPosition, childPosition).toString()) ;
		return textView;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return this.children[groupPosition].length ;
	}

	@Override
	public Object getGroup(int groupPosition) {
		return this.groups[groupPosition];
	}

	@Override
	public int getGroupCount() {
		return this.groups.length;
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		TextView textView = this.buildTextView() ;
		textView.setText(this.getGroup(groupPosition).toString()) ;
		return textView;
	}

	@Override
	public boolean hasStableIds() {
		return true;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return true;
	}

}
