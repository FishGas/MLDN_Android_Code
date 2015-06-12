package org.lxh.demo;

import java.io.File;
import java.io.IOException;

import android.app.Activity;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class MyMediaRecorderDemo extends Activity {
	private ImageButton record = null;
	private ImageButton stop = null;
	private ImageButton browser = null;
	private TextView info = null;
	private MediaRecorder mediaRecorder = null;
	private boolean sdcardExists = false; // SD�����ڵı��
	private File recordVideoSaveFileDir = null;
	private File recordVideoSaveFile = null;
	private String recordVideoSaveFileName = null;
	private String recDir = "mldnvideo";
	private boolean isRecord = false;
	private SurfaceView surface = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.requestWindowFeature(Window.FEATURE_NO_TITLE); // ����ʾ����
		super.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.getWindow().addFlags(
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // �����ķ����ʾ
		super.setContentView(R.layout.main);
		this.record = (ImageButton) super.findViewById(R.id.record);
		this.stop = (ImageButton) super.findViewById(R.id.stop);
		this.browser = (ImageButton) super.findViewById(R.id.browser);
		this.info = (TextView) super.findViewById(R.id.info);
		this.surface = (SurfaceView) super.findViewById(R.id.surface);
		this.surface.getHolder().setType(
				SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
		this.surface.getHolder().setFixedSize(480, 800);
		if ((this.sdcardExists = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED))) {
			this.recordVideoSaveFileDir = new File(Environment
					.getExternalStorageDirectory().toString()
					+ File.separator
					+ MyMediaRecorderDemo.this.recDir + File.separator); // �����ļ���
			if (!this.recordVideoSaveFileDir.exists()) {
				this.recordVideoSaveFileDir.mkdirs(); // �����ļ���
			}
		}
		this.record.setOnClickListener(new RecordOnClickListenerImpl()) ;
		this.stop.setOnClickListener(new StopOnClickListenerImpl()) ;
		this.browser.setOnClickListener(new BrowserOnClickListenerImpl()) ;
		this.stop.setEnabled(false) ;	// ֹͣ¼��İ�ť��ʱ������
	}
	private class RecordOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			if(MyMediaRecorderDemo.this.sdcardExists) {	// sd������
				MyMediaRecorderDemo.this.recordVideoSaveFileName = MyMediaRecorderDemo.this.recordVideoSaveFileDir
						.toString()
						+ File.separator
						+ "MLDNVideo_"
						+ System.currentTimeMillis() + ".3gp";// �ļ���·������
				MyMediaRecorderDemo.this.recordVideoSaveFile = new File(
						MyMediaRecorderDemo.this.recordVideoSaveFileName);// �ļ�·��
				MyMediaRecorderDemo.this.mediaRecorder = new MediaRecorder() ;
				MyMediaRecorderDemo.this.mediaRecorder.reset(); // ����
				MyMediaRecorderDemo.this.mediaRecorder
						.setAudioSource(MediaRecorder.AudioSource.MIC);
				MyMediaRecorderDemo.this.mediaRecorder
						.setVideoSource(MediaRecorder.VideoSource.CAMERA);
				MyMediaRecorderDemo.this.mediaRecorder
						.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				MyMediaRecorderDemo.this.mediaRecorder
						.setVideoEncoder(MediaRecorder.VideoEncoder.H263);
				MyMediaRecorderDemo.this.mediaRecorder
						.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
				MyMediaRecorderDemo.this.mediaRecorder
						.setOutputFile(MyMediaRecorderDemo.this.recordVideoSaveFileName);
				MyMediaRecorderDemo.this.mediaRecorder.setVideoSize(320, 240) ;
				MyMediaRecorderDemo.this.mediaRecorder.setVideoFrameRate(10) ;
				MyMediaRecorderDemo.this.mediaRecorder
						.setPreviewDisplay(MyMediaRecorderDemo.this.surface
								.getHolder().getSurface());
				try {
					MyMediaRecorderDemo.this.mediaRecorder.prepare() ;
				} catch (Exception e) {
					Log.i("MyMediaRecorderDemo", e.toString()) ;
				}
				MyMediaRecorderDemo.this.mediaRecorder.start() ;
				MyMediaRecorderDemo.this.info.setText("����¼����...") ;
				MyMediaRecorderDemo.this.stop.setEnabled(true) ;
				MyMediaRecorderDemo.this.record.setEnabled(false) ;
				MyMediaRecorderDemo.this.isRecord = true ;
			}
		}
	} 
	private class StopOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			if(MyMediaRecorderDemo.this.isRecord) {
				MyMediaRecorderDemo.this.mediaRecorder.stop() ;
				MyMediaRecorderDemo.this.mediaRecorder.release() ;
				MyMediaRecorderDemo.this.stop.setEnabled(false) ;
				MyMediaRecorderDemo.this.record.setEnabled(true) ;
				MyMediaRecorderDemo.this.info.setText("¼��������ļ�·��Ϊ��"
						+ MyMediaRecorderDemo.this.recordVideoSaveFile);
			}
		}
	} 
	private class BrowserOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			
		}
	} 
}