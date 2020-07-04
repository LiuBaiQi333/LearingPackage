package com.liu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import com.liu.bean.Goods;
import com.liu.bean.Page;

public class GoodsDao {

	ConnDB db= new ConnDB();
	public List<Goods> select(){
		List<Goods> list =new ArrayList<Goods>();
		db.getConnDB();
		String sql="select * from goods";
		ResultSet rs =db.select(sql);
		try {
			while(rs!=null&&rs.next()){
				Goods g=new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getFloat("gprice"),rs.getString("gimg"),rs.getInt("gnum"),rs.getInt("gstock"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return list;
	}

	public List<Goods> selectPage(Page p){
		List<Goods> list =new ArrayList<Goods>();
		db.getConnDB();
		int m=(p.getPageNum()-1)*p.getPageSize();
		int n=p.getPageSize();
		String sql="select * from goods limit "+m+","+n;
		ResultSet rs =db.select(sql);
		try {
			while(rs!=null&&rs.next()){
				Goods g=new Goods(rs.getInt("gid"),rs.getString("gname"),rs.getFloat("gprice"),rs.getString("gimg"),rs.getInt("gnum"),rs.getInt("gstock"));
				list.add(g);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return list;
	}
	
	public int selecttotal(){
		int total=0;
		db.getConnDB();
		String sql="select count(*) as total from goods ";
		ResultSet rs =db.select(sql);
		try {
			while(rs!=null&&rs.next()){
				total=rs.getInt("total");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		db.close();
		return total;
	}
	
	public void delete(int gid){
		db.getConnDB();
		String sql="delete from goods where gid="+gid;
		db.execute(sql);
		db.close();
	}
	public void add(Goods g){
		db.getConnDB();
		String sql="insert into goods values(null,'"+g.getGname()+"',"+g.getGprice()+",'"+g.getGimg()+"',"+g.getGnum()+","+g.getGstock()+")";
		db.execute(sql);
		db.close();
	}
	public void update(Goods g){
		db.getConnDB();
		String sql="update  goods set gname='"+g.getGname()+"',gprice="+g.getGprice()+",gimg='"+g.getGimg()+"',gnum="+g.getGnum()+",gstock="+g.getGstock()+" where gid="+g.getGid();
		db.execute(sql);
		db.close();
	}
}
