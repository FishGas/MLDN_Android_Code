package org.lxh.demo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MyAsyncTaskDemo extends Activity {
	private ProgressBar bar = null;
	private TextView info = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.bar = (ProgressBar) super.findViewById(R.id.bar);
		this.info = (TextView) super.findViewById(R.id.info);
		ChildUpdate child = new ChildUpdate() ;
		child.execute(100) ;
	}

	// ÿ�δ����̨���ȵ�������Integer������֮�����ֵInteger�����Ľ�����ص����ַ���
	private class ChildUpdate extends AsyncTask<Integer, Integer, String> {

		@Override
		protected void onPostExecute(String result) {
			MyAsyncTaskDemo.this.info.setText(result) ;
		}

		@Override
		protected void onProgressUpdate(Integer... values) {	// ÿ�θ���֮�������
			MyAsyncTaskDemo.this.info.setText("��ǰ�Ľ���ֵ�ǣ�" + String.valueOf(values[0])) ;
		}

		@Override
		protected String doInBackground(Integer... params) { // ÿ�εĽ��ȴ������Ը���UI���
			for (int x = 0; x < 100; x++) {
				MyAsyncTaskDemo.this.bar.setProgress(x); // ���ý���
				this.publishProgress(x) ;	// ���£����ø��²���
				try {// �ӳٵĲ������ⲿ����
					Thread.sleep(params[0]);
				} catch (InterruptedException e) {
				}
			}
			return "ִ�����";
		}

	}
}