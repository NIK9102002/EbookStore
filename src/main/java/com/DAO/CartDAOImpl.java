package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDtls;
import com.entity.Cart;
import com.mysql.cj.exceptions.RSAException;

public class CartDAOImpl implements CartDAO {

	private Connection conn;

	public CartDAOImpl(Connection conn) {
		this.conn = conn;

	}

	@Override
	public boolean addCart(Cart c) {
		boolean f = false;
		try {
			String sql = "insert into cart(bid,uid,book_name,author,price,total_price) values(?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getBookName());
			ps.setString(4, c.getAuthor());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalPrice());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return f;
	}

	@Override
	public List<Cart> getBookByUser(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart c = null;
		double totalPrice = 0;
		try {
			String sql = "Select * from cart where uid=?";
			PreparedStatement pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, userId);

			ResultSet resultSet = pStatement.executeQuery();

			while (resultSet.next()) {
				c = new Cart();
				c.setCid(resultSet.getInt(1));
				c.setBid(resultSet.getInt(2));
				c.setUid(resultSet.getInt(3));
				c.setBookName(resultSet.getString(4));
				c.setAuthor(resultSet.getString(5));
				c.setPrice(resultSet.getDouble(6));

				totalPrice = totalPrice + resultSet.getDouble(7);
				c.setTotalPrice(totalPrice);

				list.add(c);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public boolean deleteBook(int bid,int uid,int cid) {
		boolean f = false;

		try {
			String sql = "delete from cart where bid=? and uid=? and cid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
