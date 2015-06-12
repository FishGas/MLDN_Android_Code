package org.lxh.demo;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class MyMediaPlayerDemo extends Activity {
	private ImageButton play = null ;
	private ImageButton pause = null ;
	private ImageButton stop = null ;
	private TextView info = null ;
	private MediaPlayer myMediaPlayer = null ;
	private SeekBar seekbar = null ;
	private boolean playFlag = true ;	// ���ű��
	private boolean pauseFlag = true ;	// ��ͣ���
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		super.setContentView(R.layout.main);
		this.info = (TextView) super.findViewById(R.id.info) ;
		this.play = (ImageButton) super.findViewById(R.id.play) ;
		this.pause = (ImageButton) super.findViewById(R.id.pause) ;
		this.stop = (ImageButton) super.findViewById(R.id.stop) ;
		this.seekbar = (SeekBar) super.findViewById(R.id.seekbar) ;
		this.play.setOnClickListener(new PlayOnClickListener()) ;
		this.pause.setOnClickListener(new PauseOnClickListener()) ;
		this.stop.setOnClickListener(new StopOnClickListener()) ;
		this.seekbar.setOnSeekBarChangeListener(new OnSeekBarChangeListenerImpl()) ;
	}
	
	private class PlayOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			MyMediaPlayerDemo.this.myMediaPlayer = MediaPlayer.create(
					MyMediaPlayerDemo.this, R.raw.mldn_ad);	// Ҫ���ŵ��ļ�
			if (MyMediaPlayerDemo.this.myMediaPlayer != null) {
				MyMediaPlayerDemo.this.myMediaPlayer.stop(); // ֹͣ����
			}
			MyMediaPlayerDemo.this.myMediaPlayer.setOnCompletionListener(new OnCompletionListener(){

				@Override
				public void onCompletion(MediaPlayer mp) {
					MyMediaPlayerDemo.this.playFlag = false ;	// �������
					MyMediaPlayerDemo.this.myMediaPlayer.release() ;	// �ͷ���Դ
				}}) ;
			try {
				MyMediaPlayerDemo.this.myMediaPlayer.prepare() ;
				MyMediaPlayerDemo.this.myMediaPlayer.start() ;
				MyMediaPlayerDemo.this.info.setText("���ڲ�����Ƶ�ļ�...") ;
			} catch (Exception e) {
				MyMediaPlayerDemo.this.info.setText("�ļ����ų����쳣��" + e) ;
			}
			
		}
		
	}
	private class PauseOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			if(MyMediaPlayerDemo.this.myMediaPlayer != null) {
				if (MyMediaPlayerDemo.this.pauseFlag) { // ������ͣ
					MyMediaPlayerDemo.this.myMediaPlayer.start();
					MyMediaPlayerDemo.this.pauseFlag = false ;
				} else {
					MyMediaPlayerDemo.this.myMediaPlayer.pause(); // ��ͣ
					MyMediaPlayerDemo.this.pauseFlag = true ;
				}
			}
		}
		
	}
	private class StopOnClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			if(MyMediaPlayerDemo.this.myMediaPlayer != null) {
				MyMediaPlayerDemo.this.myMediaPlayer.stop() ;	// ֹͣ
				MyMediaPlayerDemo.this.info.setText("ֹͣ������Ƶ�ļ�...") ;
			}
		}
	}
	private class OnSeekBarChangeListenerImpl implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress,
				boolean fromUser) {
			
		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			
		}
		
	}
}