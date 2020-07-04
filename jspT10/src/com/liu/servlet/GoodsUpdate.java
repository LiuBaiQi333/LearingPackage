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
		//3、设置允许的文件类型(可省)  
		su.setAllowedFilesList("jpg,gif,png,bmp,JPG,GIF,PNG,BMP");
		
	
		
		//GoodsDao goods = new GoodsDao();
		//if(gimg==null){
		//	Goods g = goods.select(gid);
		//	gimg=g.getGimg();
		//}
		String gimg=null;
		
		
		try {
			//4、把页面传过来的文件上传到服务器
			su.upload();
			gimg=su.getRequest().getParameter("gimg");
			System.out.println(gimg);
			//5、获取文件对象
			 File file = su.getFiles().getFile(0);
			 //6、判断用户是否选择文件了
			 if(file.isMissing()){//用户没选文件
				 
			 }else{//用户选择文件
				 //先创建upload文件夹，用于保存上传的所有图片，并获取他在服务器中的完整路径
				 String path=req.getServletContext().getRealPath("upload");
				 System.out.println("保存路径是："+path);
				 String name=path+"/"+file.getFileName();
				 System.out.println("完整地址："+name);
				 //7、另存文件到需要保存的路径
				 file.saveAs(name);
				 gimg=file.getFileName();//把文件名称给gimg，保存表中
			 }
		} catch (SmartUploadException e) {
			e.printStackTrace();
			System.out.println("文件上传失败！");
		}
		
		
		
		
		
		req.setCharacterEncoding("utf-8");
		//获取表单传过来的参数值
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
				
		
		
		//类型转换
		float gprice=Float.parseFloat(gpriceStr);
		int gstock=Integer.parseInt(gstockStr);
		int gnum=Integer.parseInt(gnumStr);
		int gid=Integer.parseInt(gidStr);
		System.out.println(gname+gprice+gstock+gnum+gid);
		
		//封装成对象
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, gstock);
		GoodsDao dao = new GoodsDao();
		dao.update(g);
		resp.sendRedirect("GoodsSelect");
	}
}
