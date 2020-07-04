package com.liu.servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.liu.bean.Goods;
import com.liu.dao.ConnDB;
import com.liu.dao.GoodsDao;

@WebServlet("/GoodsUpdate")
public class GoodsUpdate extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		SmartUpload su =new SmartUpload();
		su.initialize(super.getServletConfig(), req, resp);
		//3������������ļ�����(��ʡ)  
		su.setAllowedFilesList("jpg,gif,png,bmp,JPG,GIF,PNG,BMP");
		
	
		
		//GoodsDao goods = new GoodsDao();
		//if(gimg==null){
		//	Goods g = goods.select(gid);
		//	gimg=g.getGimg();
		//}
		String gimg=null;
		
		
		try {
			//4����ҳ�洫�������ļ��ϴ���������
			su.upload();
			gimg=su.getRequest().getParameter("gimg");
			System.out.println(gimg);
			//5����ȡ�ļ�����
			 File file = su.getFiles().getFile(0);
			 //6���ж��û��Ƿ�ѡ���ļ���
			 if(file.isMissing()){//�û�ûѡ�ļ�
				 
			 }else{//�û�ѡ���ļ�
				 //�ȴ���upload�ļ��У����ڱ����ϴ�������ͼƬ������ȡ���ڷ������е�����·��
				 String path=req.getServletContext().getRealPath("upload");
				 System.out.println("����·���ǣ�"+path);
				 String name=path+"/"+file.getFileName();
				 System.out.println("������ַ��"+name);
				 //7������ļ�����Ҫ�����·��
				 file.saveAs(name);
				 gimg=file.getFileName();//���ļ����Ƹ�gimg���������
			 }
		} catch (SmartUploadException e) {
			e.printStackTrace();
			System.out.println("�ļ��ϴ�ʧ�ܣ�");
		}
		
		
		
		
		
		req.setCharacterEncoding("utf-8");
		//��ȡ���������Ĳ���ֵ
		//String gname=req.getParameter("gname");
		//String gpriceStr=req.getParameter("gprice");
		//String gstockStr=req.getParameter("gstock");
		//String gnumStr=req.getParameter("gnum");
		//String gidStr=req.getParameter("gid");
		//String gimg=req.getParameter("gimg");
		
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gstockStr=su.getRequest().getParameter("gstock");
		String gnumStr=su.getRequest().getParameter("gnum");
		String gidStr=su.getRequest().getParameter("gid");
				
		
		
		//����ת��
		float gprice=Float.parseFloat(gpriceStr);
		int gstock=Integer.parseInt(gstockStr);
		int gnum=Integer.parseInt(gnumStr);
		int gid=Integer.parseInt(gidStr);
		System.out.println(gname+gprice+gstock+gnum+gid);
		
		//��װ�ɶ���
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, gstock);
		GoodsDao dao = new GoodsDao();
		dao.update(g);
		resp.sendRedirect("GoodsSelect");
	}
}
