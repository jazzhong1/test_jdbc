package com.test_jdbc.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.test_jdbc.util.DBConnector;
import com.test_jdbc.util.DBQuery;
import com.test_jdbc.vo.Member;

import oracle.jdbc.driver.DBConversion;

public class MemberDao {
	

	public MemberDao() {
	
	}

	public int connectDB() {
		int result = 0;

		try {
			Connection conn = DBConnector.getConnect();
			Statement st = conn.createStatement();
			String sql = "select * from member";
			result = st.executeUpdate(sql);
			DBConnector.disConnect(st, conn);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	public ArrayList<Member> selectAll() {
		ArrayList<Member> list = new ArrayList<Member>();

		try {
			Connection conn = DBConnector.getConnect();
			String sql = "select * from member";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Member member = new Member();
				member.setMember_id(rs.getString("member_id"));
				member.setMember_pwd(rs.getString("member_pwd"));
				member.setMember_name(rs.getString("member_name"));
				member.setGender(rs.getString("gender").charAt(0));
				member.setAge(rs.getInt("age"));
				member.setEmail(rs.getString("email"));
				member.setPhone(rs.getString("phone"));
				member.setAddress(rs.getString("address"));
				member.setHobby(rs.getString("hobby"));
				member.setEnroll_date(rs.getDate("enroll_date"));

				list.add(member);
			}

			DBConnector.disConnect(rs, st, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public Member selectOne(String id) {
		Member member = null;
		try {
			Connection conn = DBConnector.getConnect();
			String sql = DBQuery.getQuery().getProperty("selectOne");
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();

			member = new Member();

			rs.next(); // cusor역활 빠지면 안됨.

			member.setMember_id(rs.getString("member_id"));
			member.setMember_pwd(rs.getString("member_pwd"));
			member.setMember_name(rs.getString("member_name"));
			member.setGender(rs.getString("gender").charAt(0));
			member.setAge(rs.getInt("age"));
			member.setEmail(rs.getString("email"));
			member.setPhone(rs.getString("phone"));
			member.setAddress(rs.getString("address"));
			member.setHobby(rs.getString("hobby"));
			member.setEnroll_date(rs.getDate("enroll_date"));

			DBConnector.disConnect(rs, st, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public int insertMember(Member member) {
		int result = 0;
		try {
			Connection conn = DBConnector.getConnect();
			Statement stmt = conn.createStatement();
			String sql = DBQuery.getQuery().getProperty("insertMember");

			result = stmt.executeUpdate(sql);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			DBConnector.disConnect(stmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public int find(String id) {
		int result = 0;
		try {
			Connection conn = DBConnector.getConnect();
			Statement st = conn.createStatement();
			String sql = "select * from member where member_id='" + id + "'";
			result = st.executeUpdate(sql);

			DBConnector.disConnect(st, conn);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int updateMember(Member member, String id) {

		Connection conn = null;
		Statement stmt = null;
		int result = 0;
		try {
			conn = DBConnector.getConnect();
			stmt = conn.createStatement();			
			String sql = DBQuery.getQuery().getProperty("updateMember");

			result = stmt.executeUpdate(sql);

			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}

			DBConnector.disConnect(stmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int memberDelete(String id) {
		int result=0;
		try {
			Connection conn = DBConnector.getConnect();
			Statement stmt = conn.createStatement();
			String sql = DBQuery.getQuery().getProperty("memberDelete");
			result = stmt.executeUpdate(sql);
			if (result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			DBConnector.disConnect(stmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
