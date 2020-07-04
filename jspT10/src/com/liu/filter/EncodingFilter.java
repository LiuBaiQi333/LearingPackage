package com.liu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter {

	String encoding=null;// �ַ�����ȫ�ֱ���
	@Override
	public void destroy() {
		System.out.println("3.׼�����ٹ�����");

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("2.�����������Ӧ");
		HttpServletRequest req=(HttpServletRequest)arg0;
		req.setCharacterEncoding(this.encoding);
		//��������
		arg2.doFilter(arg0, arg1);

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("1.��ʼ���ַ����������");
		this.encoding=arg0.getInitParameter("encode");
	}

}