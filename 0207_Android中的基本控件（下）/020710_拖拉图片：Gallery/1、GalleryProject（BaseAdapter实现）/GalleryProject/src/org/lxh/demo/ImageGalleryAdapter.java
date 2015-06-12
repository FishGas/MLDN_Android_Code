package org.lxh.demo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

public class ImageGalleryAdapter extends BaseAdapter {
	private Context context = null ;
	// ��������з�����ʾ���ǿ��Ը���ָ������ʾͼƬ������������ÿ��ͼƬ�Ĵ���
	private int[] imgRes = new int[] { R.drawable.ispic_a,
			R.drawable.ispic_b, R.drawable.ispic_c, R.drawable.ispic_d,
			R.drawable.ispic_e };	// ��Щ����Ҫ��ʾ��ͼƬ����Դ
	public ImageGalleryAdapter(Context context) {
		this.context = context ;
	}
	@Override
	public int getCount() {	// ȡ��Ҫ��ʾ�����ݵ�����
		return this.imgRes.length ;	// ��Դ������
	}

	@Override
	public Object getItem(int position) {
		return this.imgRes[position];
	}

	@Override
	public long getItemId(int position) {	// ȡ�����ID
		return this.imgRes[position]; 
	}
	// ����Դ���õ�һ�����֮�У�����������������ImageView���
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView img = new ImageView(this.context) ;
		img.setBackgroundColor(0xFFFFFFFF) ;
		img.setImageResource(this.imgRes[position]) ;	// ��ָ������Դ���õ�ImageView��
		img.setScaleType(ImageView.ScaleType.CENTER) ;	// ������ʾ
		img.setLayoutParams(new Gallery.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT));
		return img;
	}

}
