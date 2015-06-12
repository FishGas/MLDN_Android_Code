package org.lxh.demo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public class MyXMLPullUtil {
	private InputStream input = null ;
	public MyXMLPullUtil(InputStream input) {
		this.input = input ;
	}
	public List<LinkMan> getAllLinkMan() throws Exception{
		List<LinkMan> all = null ;
		LinkMan man = null ;
		String elementName = null ;	// ����ڵ������
		XmlPullParserFactory factory = XmlPullParserFactory.newInstance() ;
		XmlPullParser xpp = factory.newPullParser() ;
		xpp.setInput(this.input, "UTF-8") ;
		int eventType = xpp.getEventType() ;	// ȡ���¼���
		while(eventType != XmlPullParser.END_DOCUMENT) {	// �����ĵ��ײ�
			if(eventType == XmlPullParser.START_DOCUMENT) {	// �ĵ���ʼ
				all = new ArrayList<LinkMan>() ;
			} else if (eventType == XmlPullParser.START_TAG) {	// Ԫ�ر�ǿ�ʼ
				elementName = xpp.getName() ;	// ȡ��Ԫ�ص�����
				if("linkman".equals(elementName)) {
					man = new LinkMan() ;
				}
			} else if (eventType == XmlPullParser.END_TAG) {	// ����Ԫ��
				elementName = xpp.getName() ;	// ȡ�ýڵ�����
				if("linkman".equals(elementName)) {
					all.add(man) ;
					man = null ;
				}
			} else if (eventType == XmlPullParser.TEXT) {	// ����
				if("name".equals(elementName)) {
					man.setName(xpp.getText()) ;
				} else if ("email".equals(elementName)) {
					man.setEmail(xpp.getText()) ;
				}
			}
			eventType = xpp.next() ;	// ȡ����һ���¼���
		}
		return all ; 
	}
}
