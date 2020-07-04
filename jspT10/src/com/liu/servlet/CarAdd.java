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
		//ͬ����Ĳ������ƻ�ȡ����Ĳ���ֵ
				String gidStr=req.getParameter("gid");
				String gname=req.getParameter("gname");
				String gpriceStr=req.getParameter("gprice");
				String gimg=req.getParameter("gimg");
				String gnumStr=req.getParameter("gnum");
				
				//����ת��
				int gid=Integer.parseInt(gidStr);
				float gprice=Float.parseFloat(gpriceStr);
				int gnum=Integer.parseInt(gnumStr);
				//�ѱ�����װ����Ʒ����
				Goods g=new Goods(gid, gname, gprice, gimg, gnum, 0);
				//ͨ����������ȡsession����
				HttpSession session=req.getSession();
				//��session��ȡ����ǰ��½���û�����
				Users nowu=(Users)session.getAttribute("nowuser");
				int uid=nowu.getUid();//��ǰ��½���û�id
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
						
					
					//����dao��ɶ���Ʒ���浽���ﳵ��Ĳ���
					CarDao dao=new CarDao();
					dao.add(g,uid);
					
					//����Ҫ��ѯ�����û����еĹ��ﳵ��Ʒ����ҳ������ʾ
					List<Cars> list = dao.select(uid);
					
					//�Ѽ��ϴ���session����
					session.setAttribute("mycars", list);
					db.close();
					
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        //�ض��򵽹��ﳵҳ��
				resp.sendRedirect("car.jsp");
				
	}
}
