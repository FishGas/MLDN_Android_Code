package org.lxh.demo;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MyGPSDemo extends Activity {
	private TextView msg = null;
	private LocationManager locationManager = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.msg = (TextView) super.findViewById(R.id.msg);
		this.locationManager = (LocationManager) super
				.getSystemService(Context.LOCATION_SERVICE);
		this.locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 1000, 1,
				new LocationListenerImpl());
	}

	private class LocationListenerImpl implements LocationListener {

		@Override
		public void onLocationChanged(Location location) { // λ�øı�
			MyGPSDemo.this.msg.setText("�û�λ�÷����ı䣬�µ����ݣ�\n" + "���ȣ�"
					+ location.getLongitude() + "\n" + "γ�ȣ�"
					+ location.getLatitude() + "\n" + "����׼ȷ�ȣ�"
					+ location.getAccuracy() + "\n" + "ʱ�䣺"
					+ location.getTime() + "\n" + "�ٶȣ�" + location.getSpeed()
					+ "\n" + "��λ��" + location.getBearing());
		}

		@Override
		public void onProviderDisabled(String provider) {

		}

		@Override
		public void onProviderEnabled(String provider) {

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {

		}

	}
}