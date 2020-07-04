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
		//获取图片路径的参数值
				String name=req.getParameter("name");//例如：upload/1.jpg
				//使用jspsmartupload组件下载图片
				//1、创建smartupload对象
				SmartUpload su=new SmartUpload();
				//2、组件初始化
				su.initialize(super.getServletConfig(), req, resp);
				//3、设置浏览器不直接打开图片，而是弹出下载对话框，下载文件
				su.setContentDisposition(null);
				try {
					//4、下载图片
					su.downloadFile(name);
				} catch (SmartUploadException e) {
					e.printStackTrace();
					System.out.println("文件下载失败!");
				}
	}
}
