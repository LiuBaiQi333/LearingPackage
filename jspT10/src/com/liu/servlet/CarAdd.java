package com.liu.servlet;

import java.util.List;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liu.bean.Cars;
import com.liu.bean.Goods;
import com.liu.bean.Users;
import com.liu.dao.CarDao;
import com.liu.dao.ConnDB;

@WebServlet("/CarAdd")
public class CarAdd extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//同请求的参数名称获取请求的参数值
				String gidStr=req.getParameter("gid");
				String gname=req.getParameter("gname");
				String gpriceStr=req.getParameter("gprice");
				String gimg=req.getParameter("gimg");
				String gnumStr=req.getParameter("gnum");
				
				//类型转换
				int gid=Integer.parseInt(gidStr);
				float gprice=Float.parseFloat(gpriceStr);
				int gnum=Integer.parseInt(gnumStr);
				//把变量封装成商品对象
				Goods g=new Goods(gid, gname, gprice, gimg, gnum, 0);
				//通过请求对象获取session对象
				HttpSession session=req.getSession();
				//从session中取出当前登陆的用户对象
				Users nowu=(Users)session.getAttribute("nowuser");
				int uid=nowu.getUid();//当前登陆的用户id
				System.out.println(uid);
				ConnDB db = new ConnDB();
				db.getConnDB();
				String sql = "select * from cars where uid="+uid+" and gid="+gid;
				System.out.println(sql);
				ResultSet rs =db.select(sql);
				System.out.println(rs);
				try {
					if(rs!=null&&rs.next()){
						String sql1 = "update cars set gnum=gnum+1 where uid="+uid+" and gid="+gid;
						System.out.println(sql1);
						db.execute(sql1);
						//System.out.println(000);
						CarDao da = new CarDao();
						List<Cars> list =da.select(uid);
						session.setAttribute("mycars", list);
						db.close();
						//System.out.println(0);
						//resp.sendRedirect("car.jsp");
						//System.out.println(1);
					}else{
						
					
					//调用dao完成对商品保存到购物车表的操作
					CarDao dao=new CarDao();
					dao.add(g,uid);
					
					//还需要查询出该用户所有的购物车商品，在页面上显示
					List<Cars> list = dao.select(uid);
					
					//把集合存入session对象
					session.setAttribute("mycars", list);
					db.close();
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        //重定向到购物车页面
				resp.sendRedirect("car.jsp");
				
	}
}
