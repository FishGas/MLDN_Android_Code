package org.lxh.demo;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class MyWebViewDemo extends Activity {
	private WebView webview = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.webview = (WebView) super.findViewById(R.id.webview);
		this.webview.getSettings().setJavaScriptEnabled(true); // ����JavaScript
		this.webview.getSettings().setBuiltInZoomControls(true); // ����ҳ������
		this.webview.loadUrl("file:/android_asset/html/show_js.html");
	}
}