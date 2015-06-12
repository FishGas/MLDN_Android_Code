package org.lxh.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class MyMediaRecorderDemo extends Activity {
	private ImageButton record = null;
	private ImageButton stop = null;
	private TextView info = null;
	private ListView reclist = null;
	private SimpleAdapter recordSimpleAdapter = null;
	private MediaRecorder mediaRecorder = null;
	private boolean sdcardExists = false; // �ж�sd���Ƿ����
	private File recordAudioSaveFileDir = null; // ����������Ƶ�ļ����ļ���
	private File recordAudioSaveFile = null;	// ÿ�α�����Ƶ�ļ�������
	private String recordAudioSaveFileName = null;	// ÿ�α�����Ƶ�ļ�������
	private String recDir = "mldnrec"; // �����Ŀ¼����
	private boolean isRecord = false ;	// ¼���ı�־
	private List<Map<String,Object>> recordFiles = null ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.record = (ImageButton) super.findViewById(R.id.record);
		this.stop = (ImageButton) super.findViewById(R.id.stop);
		this.info = (TextView) super.findViewById(R.id.info);
		this.reclist = (ListView) super.findViewById(R.id.reclist);
		// ���������״̬����sdcardExists����
		if ((this.sdcardExists = Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED))) { // �ж�sd���Ƿ����
			this.recordAudioSaveFileDir = new File(Environment
					.getExternalStorageDirectory().toString()
					+ File.separator
					+ MyMediaRecorderDemo.this.recDir + File.separator);
			if (!this.recordAudioSaveFileDir.exists()) { // �ļ��в�����
				this.recordAudioSaveFileDir.mkdirs(); // �����ļ���
			}
		}
		this.stop.setEnabled(false) ;	// ��ť���ڲ�����
		this.record.setOnClickListener(new RecordOnClickListenerImpl());
		this.stop.setOnClickListener(new StopOnClickListenerImpl());
		this.reclist.setOnItemClickListener(new OnItemClickListenerImpl()) ;
		this.getRecordFiles() ;
	}

	private class RecordOnClickListenerImpl implements OnClickListener {

		@Override
		public void onClick(View v) {
			if(MyMediaRecorderDemo.this.sdcardExists) {	// ���sd������
				MyMediaRecorderDemo.this.recordAudioSaveFileName = MyMediaRecorderDemo.this.recordAudioSaveFileDir
						.toString()
						+ File.separator
						+ "MLDNRecord_"
						+ System.currentTimeMillis() + ".3gp";	// ÿ�ε�¼���ļ����ƶ���һ��
				MyMediaRecorderDemo.this.recordAudioSaveFile = new File(
						MyMediaRecorderDemo.this.recordAudioSaveFileName);
				MyMediaRecorderDemo.this.mediaRecorder = new MediaRecorder(); // ʵ��������
				// �ڽ���¼��֮ǰ�����������ɸ�����
				MyMediaRecorderDemo.this.mediaRecorder
						.setAudioSource(MediaRecorder.AudioSource.MIC); // ��Ƶ��Դ��MIC
				MyMediaRecorderDemo.this.mediaRecorder
						.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
				MyMediaRecorderDemo.this.mediaRecorder
						.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);
				MyMediaRecorderDemo.this.mediaRecorder
						.setOutputFile(MyMediaRecorderDemo.this.recordAudioSaveFileName);
				try {	// ���뵽����״̬
					MyMediaRecorderDemo.this.mediaRecorder.prepare() ;
				} catch (Exception e) {
					// Log.i("MyMediaRecorderDemo", e.toString()) ;
				}
				MyMediaRecorderDemo.this.mediaRecorder.start() ;	// ��ʼ¼��
				MyMediaRecorderDemo.this.info.setText("����¼����...") ;
				MyMediaRecorderDemo.this.stop.setEnabled(true); // ֹͣ¼����ť����ʹ����
				MyMediaRecorderDemo.this.record.setEnabled(false) ;
				MyMediaRecorderDemo.this.isRecord = true ;	// ����¼��
			}
		}
	}

	private class StopOnClickListenerImpl implements OnClickListener {
		@Override
		public void onClick(View v) {
			if(MyMediaRecorderDemo.this.isRecord) {	// ����¼��
				MyMediaRecorderDemo.this.mediaRecorder.stop() ;	// ֹͣ
				MyMediaRecorderDemo.this.mediaRecorder.release() ;	// �ͷ���Դ
				MyMediaRecorderDemo.this.record.setEnabled(true) ;
				MyMediaRecorderDemo.this.stop.setEnabled(false) ;
				MyMediaRecorderDemo.this.info.setText("¼���������ļ�·��Ϊ��"
						+ MyMediaRecorderDemo.this.recordAudioSaveFileName);
				MyMediaRecorderDemo.this.getRecordFiles() ;
			}
		}
	}
	
	private void getRecordFiles(){	// ��һ���ļ���֮�е�ȫ���ļ��г�
		this.recordFiles = new ArrayList<Map<String, Object>>();
		if(this.sdcardExists) {	// ��sd������
			File files [] = this.recordAudioSaveFileDir.listFiles() ;	// �г�Ŀ¼�е��ļ�
			for (int x = 0; x < files.length; x++) {
				Map<String, Object> fileInfo = new HashMap<String, Object>();
				fileInfo.put("filename", files[x].getName()) ;
				this.recordFiles.add(fileInfo) ;
			}
			this.recordSimpleAdapter = new SimpleAdapter(this,
					this.recordFiles, R.layout.recordfiles,
					new String[] { "filename" }, new int[] { R.id.filename });
			this.reclist.setAdapter(this.recordSimpleAdapter) ;
		}
	}
	private class OnItemClickListenerImpl implements OnItemClickListener {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if (MyMediaRecorderDemo.this.recordSimpleAdapter.getItem(position) instanceof Map) {
				Map<?, ?> map = (Map<?, ?>) MyMediaRecorderDemo.this.recordSimpleAdapter
						.getItem(position);
				Uri uri = Uri
						.fromFile(new File(MyMediaRecorderDemo.this.recordAudioSaveFileDir
								.toString()
								+ File.separator
								+ map.get("filename")));
				Intent intent = new Intent(Intent.ACTION_VIEW) ; 
				intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) ;
				intent.setDataAndType(uri, "audio/mp3") ;
				MyMediaRecorderDemo.this.startActivity(intent) ;
			}
		}
	}
}