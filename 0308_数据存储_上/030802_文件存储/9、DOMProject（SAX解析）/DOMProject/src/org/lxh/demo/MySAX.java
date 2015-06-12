package org.lxh.demo;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MySAX extends DefaultHandler {
	private List<LinkMan> all = null ;	// �����������
	private LinkMan man = null ;
	private String elementName = null ;	// ����ڵ������
	
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(this.elementName != null) {	// �Ѿ�ȡ����Ԫ������
			String data = new String(ch,start,length) ;
			if("name".equals(this.elementName)) {
				this.man.setName(data) ;
			} else if ("email".equals(this.elementName)) {
				this.man.setEmail(data) ;
			}
		}
	}

	
	
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if("linkman".equals(localName)) {
			this.all.add(this.man) ;
			this.man = null ;	// ׼�������´ε�����
		}
		this.elementName = null;// ��Ԫ���������
	}

	@Override
	public void startDocument() throws SAXException {
		this.all = new ArrayList<LinkMan>() ;	// ��ʾ��ʼ�����ĵ�������Ҫ���ü���
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if("linkman".equals(localName)) {	// ��һ��linkman�ڵ�
			this.man = new LinkMan() ;	// ʵ����LinkMan����
		}
		this.elementName = localName ;	// ����Ԫ������
	}

	public List<LinkMan> getAll() {
		return all;
	}
	
}
