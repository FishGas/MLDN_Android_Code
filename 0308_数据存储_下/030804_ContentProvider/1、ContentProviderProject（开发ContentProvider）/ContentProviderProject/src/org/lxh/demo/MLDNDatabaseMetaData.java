package org.lxh.demo;

import android.net.Uri;
import android.provider.BaseColumns;

public interface MLDNDatabaseMetaData {
	// ������ⲿ���ʵ�Authority��Content��ַΪ��content//org.lxh.demo.membercontentprovider
	public static final String AUTHORITY = "org.lxh.demo.membercontentprovider" ;
	// ���ݿ������
	public static final String DATABASE_NAME = "mldn" ;	// ���������ݿ������
	public static final int VERSION = 1 ;	// ���ݿ�İ汾
	
	public static interface MemberTableMetaData extends BaseColumns{
		public static final String TABLE_NAME = "member" ;	// ������
		// �ⲿ������ʱ����Uri��ַ���������ƶ�ͳһ����ΪCONTENT_URI
		public static final Uri CONTENT_URI = Uri.parse("content://"
				+ AUTHORITY + "/" + TABLE_NAME);
		// �õ�member���е�ȫ����¼
		public static final String CONTACT_LIST = "vnd.android.cursor.dir/vnd.mldncontentprovider.member" ;
		// ȡ��һ��member����Ϣ���൱�ھ��ǰ���ID��ѯ
		public static final String CONTACT_ITEM = "vnd.android.cursor.item/vnd.mldncontentprovider.member" ;
		
		public static final String MEMBER_NAME = "name" ;
		public static final String MEMBER_AGE = "age" ;
		public static final String MEMBER_BIRTHDAY = "birthday" ;
		
		public static final String SORT_ORDER = "_id DESC" ;// �������
	}
}
