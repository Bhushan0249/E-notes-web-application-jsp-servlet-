package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class dao {

	private Connection conn;

	public dao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean addUser(UserDetails us) {

		boolean f = false;
		try {
			String query = "insert into User (fullname,email,password)values(?,?,?)";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, us.getFullname());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());

			int a = ps.executeUpdate();

			if (a > 0) {
				f = true;
			} else {
				f = false;
			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return f;

	}

	public UserDetails loginUser(UserDetails us) {
		UserDetails user = null;
		try {

			String query = "select * from User where email=?and password=?";

			PreparedStatement ps = conn.prepareStatement(query);

			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {

				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setFullname(rs.getString("fullname"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			} else {

			}

		} catch (Exception e) {
			e.getStackTrace();
		}
		return user;

	}

}
