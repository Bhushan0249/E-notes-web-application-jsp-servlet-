package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.User.post;

public class postDAO {

	private Connection conn;

	public postDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addNotes(String ti, String co, int ui) {

		boolean f = false;

		try {

			String query = "insert into post(title, content,id) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, ui);

			int n = ps.executeUpdate();

			if (n == 1) {
				f = true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return f;

	}

	public List<post> getData(int id) {

		ArrayList<post> list = new ArrayList<post>();
		post po = null;

		try {

			String query = "select * from post where id=? order by mid DESC";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				po = new post();

				po.setMid(rs.getInt(1));
				po.setTitle(rs.getString(2));
				po.setContent(rs.getString(3));
				po.setUdate(rs.getDate(4));
				list.add(po);
			}

		} catch (Exception e) {
			e.getStackTrace();
			// TODO: handle exception
		}

		return list;

	}

	public post getDatabyid(int noteId) {

		post p = null;

		try {

			String query = "select * from post where mid=?";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, noteId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				p = new post();

				p.setMid(rs.getInt(1));
				p.setTitle(rs.getString(2));
				p.setContent(rs.getString(3));
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return p;

	}

	public boolean postUpdate(int nid, String ti, String co) {

		boolean f = false;

		try {
			String query = "update post set title=? , content=? where mid=?;";

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ti);
			ps.setString(2, co);
			ps.setInt(3, nid);

			int i = ps.executeUpdate();

			if (i > 0) {
				f = true;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}

		return f;

	}
	
	public boolean deletNotes(int nid) {
		
		boolean f=false;
		
		try {
			
			String query="delete from post where mid=?";
			
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, nid);
			
			int i = ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
			
			
		} catch (Exception e) {
       e.getStackTrace();
		
		}
		
		
		
		return f;
		
	}
	
	
	
	

}
