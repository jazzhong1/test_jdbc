package com.test_jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.test_jdbc.util.DBConnector;
import com.test_jdbc.vo.Member;

import oracle.jdbc.driver.DBConversion;

public class MemberDao {
	
	
	
	
	public MemberDao() {
		
	}
	
	

	public int connectDB() {
		int result=0;
		
		try {
			Connection conn=DBConnector.getConnect();
			Statement st=conn.createStatement();
			String sql="select * from member";
			result=st.executeUpdate(sql);
			DBConnector.disConnect(st, conn);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return result;
	}
	
	public ArrayList<Member> selectAll(){
		ArrayList<Member> list=new  ArrayList<Member>();
		
		try {
			Connection conn=DBConnector.getConnect();
			Statement st=conn.createStatement();
			String sql="select * from member";
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next()){
				Member member=new Member();
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
	
	public Member selectOne(String id){
		Member member=null;
		try {
			Connection conn=DBConnector.getConnect();
			Statement st=conn.createStatement();
			String sql="select * from member where member_id='"+id+"'";
			ResultSet rs=st.executeQuery(sql);
			
			member=new Member();
			
			rs.next();	//cusor역활 빠지면 안됨.
			
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




}
