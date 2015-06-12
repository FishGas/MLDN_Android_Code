package org.lxh.demo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;

public class MyGoogleMapDemo extends MapActivity {
	private MapView mapView = null;
	private int longitudeE6 = 0;
	private int latitudeE6 = 0;

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
		Drawable drawable = super.getResources().getDrawable(R.drawable.arrow);
		MyOverlayImpl mol = new MyOverlayImpl(drawable, this); // ׼����ͼ��
		OverlayItem overlayItem = new OverlayItem(point, "����λ�ã�", "���������찲��");
		mol.addOverlayItem(overlayItem); // ��ǵ����
		this.mapView.getOverlays().add(mol) ;
		MapController mapController = this.mapView.getController();
		mapController.animateTo(point); // ��������Ķ���
		mapController.setZoom(16) ;	// ���ļ�����16
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}
}