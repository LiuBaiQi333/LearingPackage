package com.liu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liu.dao.GoodsDao;

@WebServlet("/GoodsDelete")
public class GoodsDelete extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String gidStr=req.getParameter("gid");
		int gid = Integer.parseInt(gidStr);
		GoodsDao dao = new GoodsDao();
		dao.delete(gid);
		resp.sendRedirect("GoodsSelect");
	}
}
