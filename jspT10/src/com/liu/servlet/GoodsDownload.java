package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

@WebServlet("/GoodsDownload")
public class GoodsDownload extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//��ȡͼƬ·���Ĳ���ֵ
				String name=req.getParameter("name");//���磺upload/1.jpg
				//ʹ��jspsmartupload�������ͼƬ
				//1������smartupload����
				SmartUpload su=new SmartUpload();
				//2�������ʼ��
				su.initialize(super.getServletConfig(), req, resp);
				//3�������������ֱ�Ӵ�ͼƬ�����ǵ������ضԻ��������ļ�
				su.setContentDisposition(null);
				try {
					//4������ͼƬ
					su.downloadFile(name);
				} catch (SmartUploadException e) {
					e.printStackTrace();
					System.out.println("�ļ�����ʧ��!");
				}
	}
}
