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
		Page p=new Page();//Ĭ�ϵ�һҳ��ÿҳ��ʾ����
		String pageNumStr=req.getParameter("pageNum");
		if(pageNumStr!=null&&!pageNumStr.equals("")){
			int pageNum=Integer.parseInt(pageNumStr);
			p.setPageNum(pageNum);//�ı�ҳ��ֵ
		}
		
		//����dao����ѯ������Ʒ��Ϣ
		GoodsDao dao=new GoodsDao();
		List<Goods> list = dao.selectPage(p);
		
		//��ѯ������������
		int total=dao.selecttotal();
		p.setPageTotal(total);
		
		//�Ѽ���װrequest����
		req.setAttribute("p", p);
		req.setAttribute("goods", list);
		//ת����jspҳ��
		req.getRequestDispatcher("goodsselectpage.jsp").forward(req, resp);
			
	}
}
