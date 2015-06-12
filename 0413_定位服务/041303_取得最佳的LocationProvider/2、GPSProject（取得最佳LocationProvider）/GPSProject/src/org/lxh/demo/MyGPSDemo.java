package org.lxh.demo;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class MyGPSDemo extends Activity {
	private TextView fineProvider = null;
	private LocationManager locationManager = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.fineProvider = (TextView) super.findViewById(R.id.fineprovider);
		this.locationManager = (LocationManager) super
				.getSystemService(Context.LOCATION_SERVICE);
		Criteria criteria = new Criteria() ;
		criteria.setAccuracy(Criteria.ACCURACY_FINE) ;	// ʹ����׼ȷ����
		criteria.setCostAllowed(false); // ����������
		criteria.setPowerRequirement(Criteria.POWER_LOW); // �ĵ�����
		String provider = this.locationManager.getBestProvider(criteria, true);
		this.fineProvider.setText("��ѵ�Provider���ƣ�" + provider) ;
	}
}