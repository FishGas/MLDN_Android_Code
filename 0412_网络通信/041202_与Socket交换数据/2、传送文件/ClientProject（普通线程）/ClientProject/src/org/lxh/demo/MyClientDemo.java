package org.lxh.demo;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

import org.lxh.util.UploadFile;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MyClientDemo extends Activity {
	private Button send = null;
	private TextView info = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.send = (Button) super.findViewById(R.id.send);
		this.info = (TextView) super.findViewById(R.id.info);
		this.send.setOnClickListener(new SendOnClickListener());
	}

	private class SendOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			try {
				final Socket client = new Socket("192.168.1.114", 8888);
				BufferedReader buf = new BufferedReader(new InputStreamReader(
						client.getInputStream())); // ��ȡ���ص�����
				new Thread(new Runnable() {

					@Override
					public void run() {
						try {
							ObjectOutputStream oos = new ObjectOutputStream(
									client.getOutputStream());
							UploadFile myFile = SendOnClickListener.this
									.getUploadFile();
							oos.writeObject(myFile);
							oos.close();
						} catch (Exception e) {
						}
					}
				}).start();
				String result = buf.readLine(); // ���շ�����Ϣ
				System.out.println("**************** " + result);
				if ("true".equals(result)) {
					MyClientDemo.this.info.setText("�����ɹ���");
				} else {
					MyClientDemo.this.info.setText("����ʧ�ܣ�");
				}
				buf.close();
				client.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private UploadFile getUploadFile() throws Exception { // ��װ�˴�������
			UploadFile myFile = new UploadFile();
			myFile.setTitle("DISNEY��԰"); // ���ñ���
			myFile.setMimeType("image/jpeg"); // ͼƬ������
			File file = new File(Environment.getExternalStorageDirectory()
					.toString() + File.separator + "disney.jpg");
			InputStream input = null;
			try {
				input = new FileInputStream(file); // ���ļ��ж�ȡ
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte data[] = new byte[1024];
				int len = 0;
				while ((len = input.read(data)) != -1) {
					bos.write(data, 0, len);
				}
				myFile.setContentData(bos.toByteArray());
				myFile.setContentLength(file.length());
				myFile.setExt("jpg");
			} catch (Exception e) {
				throw e;
			} finally {
				input.close();
			}
			return myFile;
		}

	}

}