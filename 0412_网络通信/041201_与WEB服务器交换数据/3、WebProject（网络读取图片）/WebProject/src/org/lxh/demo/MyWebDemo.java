package org.lxh.demo;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

public class MyWebDemo extends Activity {
	private ImageView img = null;
	private static final String PATH = "http://www.mldnjava.cn/android/android_book.jpg"; // �����ַ

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.img = (ImageView) super.findViewById(R.id.img);
		try {
			byte data [] = this.getUrlData() ;
			Bitmap bm = BitmapFactory.decodeByteArray(data, 0, data.length);	// �Ѷ����Ʊ�ΪͼƬ
			this.img.setImageBitmap(bm) ;
		} catch (Exception e) {
		}
	}
	public byte[] getUrlData() throws Exception {	// ͨ���˲�����ȡָ����ַ�ϵ���Ϣ
		ByteArrayOutputStream bos = null ;	// �ڴ���������
		try {
			URL url = new URL(PATH) ;
			bos = new ByteArrayOutputStream() ;
			byte data [] = new byte[1024] ;
			HttpURLConnection conn = (HttpURLConnection) url.openConnection() ;
			InputStream input = conn.getInputStream() ;
			int len = 0 ;
			while ((len = input.read(data)) != -1) {
				bos.write(data, 0, len);
			}
			return bos.toByteArray() ;
		} catch (Exception e) {
			throw e ;
		} finally {
			if(bos != null) {
				bos.close() ;
			}
		}
	}
}