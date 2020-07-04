package com.liu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.bean.Goods;
import com.liu.dao.GoodsDao;
@WebServlet("/GoodsSelect")
public class GoodsSelect extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//调用dao，查询所有商品信息
				GoodsDao dao=new GoodsDao();
				List<Goods> list = dao.select();
				
				//把集合装request对象
				req.setAttribute("goods", list);
				//转发到jsp页面
				req.getRequestDispatcher("goodsselect.jsp").forward(req, resp);
			
	}
}
