package org.lxh.demo;

import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyGeocodeDemo extends Activity {
	private EditText lng = null;
	private EditText lat = null;
	private Button search = null;
	private TextView result = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.lng = (EditText) super.findViewById(R.id.lng);
		this.lat = (EditText) super.findViewById(R.id.lat);
		this.search = (Button) super.findViewById(R.id.search);
		this.result = (TextView) super.findViewById(R.id.result);
		this.search.setOnClickListener(new SearchOnClickListenerImpl());
	}

	private class SearchOnClickListenerImpl implements OnClickListener {

		@Override
		public void onClick(View v) {
			double latitude = Double.parseDouble(MyGeocodeDemo.this.lat
					.getText().toString());
			double longitude = Double.parseDouble(MyGeocodeDemo.this.lng
					.getText().toString());
			MyGeocodeDemo.this.result.setText("���Եȣ���Ϣ���ڼ�����...") ;
			new SearchAsyncTask(latitude,longitude).execute(0) ;
		}

	}

	// ��ʱҪ�����첽����Ĺ���������Google�Ͻ������ݵ��ύ����������ͨ�����ص�JSON���ݽ������������������
	private class SearchAsyncTask extends AsyncTask<Integer, String, Integer> {
		private double latitude;
		private double longitude;

		public SearchAsyncTask(double latitude, double longitude) {
			this.latitude = latitude;
			this.longitude = longitude;
		}
		
		@Override
		protected void onProgressUpdate(String... values) {
			MyGeocodeDemo.this.result.setText(values[0]) ;
		}

		@Override
		protected Integer doInBackground(Integer... arg0) {
			Map<String, String> map = null;
			try {
				map = this.parseJson(this.latitude, this.longitude);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if("OK".equals(map.get("status"))) {	// ��������
				this.publishProgress(map.get("address")) ;	// ��address���ݷ���
			} else {
				this.publishProgress("û�в�ѯ�����") ;
			}
			return null;
		}

		private Map<String, String> parseJson(double latitude, double longitude)
				throws Exception {
			Map<String, String> allMap = new HashMap<String, String>();
			StringBuffer buf = new StringBuffer();
			InputStream input = null;
			try {
				URL url = new URL(
						"http://maps.google.com/maps/api/geocode/json?latlng="
								+ this.latitude + "," + this.longitude
								+ "&sensor=false");
				input = url.openStream();
				Scanner scan = new Scanner(input);
				while (scan.hasNext()) {
					buf.append(scan.next()); // ���е����ݶ��������ַ�������
				}
			} catch (Exception e) {
				e.printStackTrace();
				throw e;
			} finally {
				input.close() ;
			}
			JSONObject allData = new JSONObject(buf.toString());
			allMap.put("status", allData.getString("status")) ; 
			JSONArray jsonArr = allData.getJSONArray("results") ;
			JSONObject jsonObj = jsonArr.getJSONObject(0) ;
			allMap.put("address", jsonObj.getString("formatted_address")) ;
			return allMap;
		}
	}
}