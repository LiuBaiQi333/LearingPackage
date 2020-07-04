package com.liu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.liu.bean.Cars;
import com.liu.bean.Goods;

public class CarDao {
	
	ConnDB db=new ConnDB();
	
	//��ӹ��ﳵ�б���Ϣ
	public void add(Goods g,int uid){
		db.getConnDB();
		String sql="insert into cars values(null,"+g.getGid()+",'"+g.getGname()+"',"+
	            g.getGprice()+",'"+g.getGimg()+"',"+g.getGnum()+","+uid+")";
		db.execute(sql);
		db.close();
	}
	
	public List<Cars> select(int uid){
		List<Cars> list=new ArrayList<Cars>();
		db.getConnDB();
		String sql="select * from cars where uid="+uid;
		ResultSet rs =db.select(sql);
		try {
			while(rs!=null&&rs.next()){
				Cars c= new Cars(rs.getInt("cid"), 
						rs.getInt("gid"), 
						rs.getString("gname"), 
						rs.getFloat("gprice"), 
						rs.getString("gimg"), 
						rs.getInt("gnum"), 
						rs.getInt("uid"));
				list.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("��ѯ�û����ﳵ��Ʒʧ�ܣ�");
		}
		db.close();
		return list;
	}
	
}
