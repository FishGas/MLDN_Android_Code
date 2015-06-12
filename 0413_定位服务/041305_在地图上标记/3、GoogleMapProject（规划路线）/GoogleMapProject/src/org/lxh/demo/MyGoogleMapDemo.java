package org.lxh.demo;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class MyGoogleMapDemo extends MapActivity {
	private MapView mapView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.mapView = (MapView) super.findViewById(R.id.mapview); // ȡ�õ�ͼ��ͼ
		this.mapView.setBuiltInZoomControls(true);
		// ����һ�����꣺�찲�ŵ����꣺116.3975060��39.9087110
		GeoPoint beginGeoPoint = new GeoPoint((int) (39.9087110 * 1E6),
				(int) (116.3975060 * 1E6));
		GeoPoint endGeoPoint = new GeoPoint((int) (39.9995740 * 1E6),
				(int) (116.2739010 * 1E6));
		this.mapView.getOverlays().add(new PaintPointOverlay(beginGeoPoint));
		this.mapView.getOverlays().add(new PaintPointOverlay(endGeoPoint));
		this.mapView.getOverlays().add(
				new PaintLineOverlay(beginGeoPoint, endGeoPoint));
		MapController mapController = this.mapView.getController() ;
		mapController.animateTo(beginGeoPoint); // ��������Ķ���
		mapController.setZoom(12); // ���ļ�����12
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}