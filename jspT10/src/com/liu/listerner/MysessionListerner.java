package com.liu.listerner;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MysessionListerner implements HttpSessionListener {

	List<String> list = new ArrayList<String>();
	public static int count=0;  //计数器变量
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		count++;
		System.out.println("某个用户进入网站了："+count);

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		count--;
		System.out.println("某个用户退出网站了："+count);

	}

}
