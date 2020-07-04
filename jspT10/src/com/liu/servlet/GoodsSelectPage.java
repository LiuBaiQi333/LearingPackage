package com.liu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.bean.Goods;
import com.liu.bean.Page;
import com.liu.dao.GoodsDao;
@WebServlet("/GoodsSelectPage")
public class GoodsSelectPage extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Page p=new Page();//默认第一页，每页显示五条
		String pageNumStr=req.getParameter("pageNum");
		if(pageNumStr!=null&&!pageNumStr.equals("")){
			int pageNum=Integer.parseInt(pageNumStr);
			p.setPageNum(pageNum);//改变页码值
		}
		
		//调用dao，查询所有商品信息
		GoodsDao dao=new GoodsDao();
		List<Goods> list = dao.selectPage(p);
		
		//查询并设置总条数
		int total=dao.selecttotal();
		p.setPageTotal(total);
		
		//把集合装request对象
		req.setAttribute("p", p);
		req.setAttribute("goods", list);
		//转发到jsp页面
		req.getRequestDispatcher("goodsselectpage.jsp").forward(req, resp);
			
	}
}
