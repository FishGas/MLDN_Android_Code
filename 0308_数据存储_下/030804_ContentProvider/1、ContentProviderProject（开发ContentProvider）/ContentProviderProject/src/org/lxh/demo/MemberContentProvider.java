package org.lxh.demo;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MemberContentProvider extends ContentProvider {
	private static UriMatcher uriMatcher = null ;	// ��ַת��
	private static final int GET_MEMBER_LIST = 1 ;	// �õ�ȫ��������
	private static final int GET_MEMBER_ITEM = 2 ;	// ȡ��һ������
	private MyDatabaseHelper helper = null ;
	static {	// ��̬�����
		uriMatcher = new UriMatcher(UriMatcher.NO_MATCH) ;	// ʵ��������
		uriMatcher.addURI(MLDNDatabaseMetaData.AUTHORITY,
				MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME,
				GET_MEMBER_LIST);	// ȡ��ȫ�����ݵ�ƥ���ַ
		uriMatcher.addURI(MLDNDatabaseMetaData.AUTHORITY,
				MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME + "/#",
				GET_MEMBER_ITEM);	// ȡ��һ�����ݵ�ƥ���ַ
	}

	@Override
	public String getType(Uri uri) { // ȡ�����ݵ����͵�
		switch (uriMatcher.match(uri)) { // ƥ�䴫�������Uri������
		case GET_MEMBER_LIST:
			return MLDNDatabaseMetaData.MemberTableMetaData.CONTACT_LIST;
		case GET_MEMBER_ITEM:
			return MLDNDatabaseMetaData.MemberTableMetaData.CONTACT_ITEM;
		default:
			throw new UnsupportedOperationException("Not Support Operation :"
					+ uri);
		}
	}

	@Override
	public boolean onCreate() {
		this.helper = new MyDatabaseHelper(super.getContext()) ;
		return true;	// �����ɹ���
	}
	
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs)  {
		SQLiteDatabase db = this.helper.getWritableDatabase() ;// ��д��ʽ�����ݿ�
		int result = 0	;	// �������
		switch (uriMatcher.match(uri)) {
		case GET_MEMBER_LIST:
			result = db.delete(
					MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME,
					selection, selectionArgs);	// ɾ��ȫ��
			break ;
		case GET_MEMBER_ITEM:
			long id = ContentUris.parseId(uri) ;	// �ҵ�һ�����ݵ�ID
			String where = "_id=" + id ;
			result = db.delete(
					MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME, where,
					selectionArgs);
			break ;
		default:
			throw new UnsupportedOperationException("Not Support Operation :"
					+ uri);
		}
		return result;
	}



	@Override
	public Uri insert(Uri uri, ContentValues values) {	// content://org.lxh.demo.membercontentprovider/member
		SQLiteDatabase db = this.helper.getWritableDatabase() ;// ��д��ʽ�����ݿ�
		long id = 0 ;	// ȡ�������������ID
		switch(uriMatcher.match(uri)) {
		case GET_MEMBER_LIST :
			id = db.insert(MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME,
					MLDNDatabaseMetaData.MemberTableMetaData._ID, values);
			String uriPath = uri.toString() ;
			String path = uriPath + "/" + id ;
			return Uri.parse(path) ;
		case GET_MEMBER_ITEM :
			return null ; 
		default:
			throw new UnsupportedOperationException("Not Support Operation :"
					+ uri);
		}
	}



	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase db = this.helper.getWritableDatabase() ;// ��д��ʽ�����ݿ�
		switch (uriMatcher.match(uri)) {
		case GET_MEMBER_LIST:
			return db
					.query(MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME,
							projection, selection, selectionArgs, null, null,
							sortOrder);
		case GET_MEMBER_ITEM:
			long id = ContentUris.parseId(uri) ;	// �ҵ�ID
			String where = "_id=" + id ;
			return db
					.query(MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME,
							projection, where, selectionArgs, null, null,
							sortOrder);
		default:
			throw new UnsupportedOperationException("Not Support Operation :"
					+ uri);
		}
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		SQLiteDatabase db = this.helper.getWritableDatabase() ;// ��д��ʽ�����ݿ�
		int result = 0 ;	// ��ʾ���
		switch (uriMatcher.match(uri)) {
		case GET_MEMBER_LIST:
			result = db.update(
					MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME,
					values, null, null);
			break ;
		case GET_MEMBER_ITEM:
			long id = ContentUris.parseId(uri) ;	// �ҵ������id
			String where = "_id=" + id ;
			result = db.update(
					MLDNDatabaseMetaData.MemberTableMetaData.TABLE_NAME,
					values, where, selectionArgs);
			break ;
		default:
			throw new UnsupportedOperationException("Not Support Operation :"
					+ uri);
		}
		return result ; 
	}

}
