package com.liu.listerner;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MysessionListerner implements HttpSessionListener {

	List<String> list = new ArrayList<String>();
	public static int count=0;  //����������
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
		System.out.println("ĳ���û�������վ�ˣ�"+count);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
		System.out.println("ĳ���û��˳���վ�ˣ�"+count);

	}

}
