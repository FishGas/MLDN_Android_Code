package org.lxh.demo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

public class MyWebViewDemo extends Activity {
	private WebView webview = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.webview = (WebView) super.findViewById(R.id.webview);
		this.webview.getSettings().setJavaScriptEnabled(true); // ����JavaScript
		this.webview.getSettings().setBuiltInZoomControls(true); // ����ҳ������
		this.webview.setWebChromeClient(new WebChromeClientImpl());
		this.webview.loadUrl("file:/android_asset/html/show_js.html");
	}

	private class WebChromeClientImpl extends WebChromeClient {

		@Override
		public boolean onJsAlert(WebView view, String url, String message,
				final JsResult result) {
			Dialog dialog = new AlertDialog.Builder(MyWebViewDemo.this)
					.setIcon(R.drawable.pic_m)
					.setTitle("MLDN����")
					.setMessage(message)
					.setPositiveButton(android.R.string.ok,
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Toast.makeText(MyWebViewDemo.this, "�رվ����",
											Toast.LENGTH_SHORT).show();
									result.cancel();
								}
							}).create();
			dialog.show() ;
			return true;
		}

		@Override
		public boolean onJsConfirm(WebView view, String url, String message,
				final JsResult result) {
			Dialog dialog = new AlertDialog.Builder(MyWebViewDemo.this)
					.setIcon(R.drawable.pic_m)
					.setTitle("ȷ��ɾ����")
					.setMessage(message)
					.setPositiveButton("ɾ��",
							new DialogInterface.OnClickListener() {

								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Toast.makeText(MyWebViewDemo.this, "ȷ��ɾ��",
											Toast.LENGTH_SHORT).show();
									result.confirm();
								}
							})
					.setNegativeButton("ȡ��",
							new DialogInterface.OnClickListener() {
								@Override
								public void onClick(DialogInterface dialog,
										int which) {
									Toast.makeText(MyWebViewDemo.this, "ȡ��ɾ��",
											Toast.LENGTH_SHORT).show();
									result.cancel();
								}
							}).create();
			dialog.show() ;
			return true;
		}

		@Override
		public void onReceivedTitle(WebView view, String title) {
			MyWebViewDemo.this.setTitle(title) ;
			super.onReceivedTitle(view, title) ;
		}

	}
}