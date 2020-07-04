package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.liu.bean.Goods;
import com.liu.dao.GoodsDao;

@WebServlet("/GoodsAdd")
public class GoodsAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SmartUpload su =new SmartUpload();//����smartupload����
		su.initialize(super.getServletConfig(), req, resp);// �����ʼ��
		su.setAllowedFilesList("jpg,gif,png,bmp,JPG,GIF,PNG,BMP");//�����ļ��������
		
		String gimg=null;
		try {//��ҳ���ϴ����ļ����浽������
			su.upload();
			File file=su.getFiles().getFile(0);
			if(file.isMissing()){
				
			}else{//����upload�ļ��У����ڱ����ϴ����ļ��У�����ȡ�����ļ��е�λ��
				String path=req.getServletContext().getRealPath("upload");
				System.out.println("����·���ǣ�"+path);
				String name=path+"/"+file.getFileName();
				System.out.println("������ַ��"+name);
				file.saveAs(name);//����ļ�����Ҫ�����·��
				gimg=file.getFileName();//���ļ�����gimg������
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ļ��ϴ�ʧ�ܣ�");
		}
		
		req.setCharacterEncoding("utf-8");
		//��ȡ���������Ĳ���ֵ
		//String gname=req.getParameter("gname");
		//String gpriceStr=req.getParameter("gprice");
		//String gstockStr=req.getParameter("gstock");
		
		//������ϴ��ļ���֮ǰ��req����ȡ����ֵ��Ҫͨ��smartupload�ṩ��req����ȡֵ
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gstockStr=su.getRequest().getParameter("gstock");
		
		//����ת��
		float gprice=Float.parseFloat(gpriceStr);
		int gstock=Integer.parseInt(gstockStr);
		//������Ʒ��ϢҲ����ֵ
		int gnum=1;//Ĭ��Ϊ1��
		int gid=0;//���һ��ֵ������Ҫ��
		
		
		//��װ�ɶ���
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, gstock);
		
        //����dao�����Ʒ���
		GoodsDao dao=new GoodsDao();
		dao.add(g);
		
		//������ɺ��ض���goodselect��
		resp.sendRedirect("GoodsSelect");
	}
}
