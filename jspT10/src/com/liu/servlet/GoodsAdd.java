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
		SmartUpload su =new SmartUpload();//创建smartupload对象
		su.initialize(super.getServletConfig(), req, resp);// 组件初始化
		su.setAllowedFilesList("jpg,gif,png,bmp,JPG,GIF,PNG,BMP");//设置文件许可类型
		
		String gimg=null;
		try {//将页面上传的文件保存到服务器
			su.upload();
			File file=su.getFiles().getFile(0);
			if(file.isMissing()){
				
			}else{//创建upload文件夹，用于保存上传的文件夹，并获取其在文件夹的位置
				String path=req.getServletContext().getRealPath("upload");
				System.out.println("保存路径是："+path);
				String name=path+"/"+file.getFileName();
				System.out.println("完整地址："+name);
				file.saveAs(name);//另存文件到需要保存的路径
				gimg=file.getFileName();//将文件名给gimg，保存
			}
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("文件上传失败！");
		}
		
		req.setCharacterEncoding("utf-8");
		//获取表单传过来的参数值
		//String gname=req.getParameter("gname");
		//String gpriceStr=req.getParameter("gprice");
		//String gstockStr=req.getParameter("gstock");
		
		//如果是上传文件，之前的req将获取不到值，要通过smartupload提供的req来获取值
		String gname=su.getRequest().getParameter("gname");
		String gpriceStr=su.getRequest().getParameter("gprice");
		String gstockStr=su.getRequest().getParameter("gstock");
		
		//类型转换
		float gprice=Float.parseFloat(gpriceStr);
		int gstock=Integer.parseInt(gstockStr);
		//其他商品信息也设置值
		int gnum=1;//默认为1件
		int gid=0;//随便一个值，不需要用
		
		
		//封装成对象
		Goods g=new Goods(gid, gname, gprice, gimg, gnum, gstock);
		
        //调用dao完成商品添加
		GoodsDao dao=new GoodsDao();
		dao.add(g);
		
		//操作完成后，重定向到goodselect类
		resp.sendRedirect("GoodsSelect");
	}
}
