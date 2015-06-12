package org.lxh.demo;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;

public class MyGoogleMapDemo extends MapActivity {
	private MapView mapView = null;
	private int longitudeE6 = 0;
	private int latitudeE6 = 0;
	private LocationManager locationManager = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mapView = (MapView) super.findViewById(R.id.mapview); // ȡ�õ�ͼ��ͼ
		this.mapView.setBuiltInZoomControls(true);
		// ����һ�����꣺�찲�ŵ����꣺116.3975060��39.9087110
		this.longitudeE6 = (int) (116.3975060 * 1E6);
		this.latitudeE6 = (int) (39.9087110 * 1E6);
		GeoPoint point = new GeoPoint(this.latitudeE6, this.longitudeE6); // Ҫ��ǵ�����
		MyLocationOverlay myloc = new MyLocationOverlay(this, this.mapView);
		myloc.enableMyLocation(); // ע��GPS�����ҵ�λ��
		myloc.enableCompass(); // �����ų���Ӧ
		this.mapView.getOverlays().add(myloc);
		MapController mapController = this.mapView.getController();
		mapController.animateTo(point); // ��������Ķ���
		mapController.setCenter(point);
		mapController.setZoom(16); // ���ļ�����16

		this.locationManager = (LocationManager) super
				.getSystemService(Context.LOCATION_SERVICE);
		this.locationManager.requestLocationUpdates(
				LocationManager.GPS_PROVIDER, 0, 0, new LocationListenerImpl());
	}

	private class LocationListenerImpl implements LocationListener {

		@Override
		public void onLocationChanged(Location location) {
			MyGoogleMapDemo.this.longitudeE6 = (int) (location.getLongitude() * 1E6);
			MyGoogleMapDemo.this.latitudeE6 = (int) (location.getLatitude() * 1E6);
		}

		@Override
		public void onProviderDisabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onProviderEnabled(String provider) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// TODO Auto-generated method stub

		}

	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}