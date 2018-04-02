package com.test_jdbc.vo;

import java.sql.Date;

public class Member {
	
	private String member_id;
	private String member_pwd;
	private String member_name;
	private char gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String hobby;
	private Date enroll_date;
	
	public Member() {
	}
	
	public Member(String member_id,String member_pwd,String member_name,char gender,String email,String phone
					,String address,String hobby,Date enroll_date){
		this.member_id=member_id;
		this.member_pwd=member_pwd;
		this.member_name=member_name;
		this.gender=gender;
		this.email=email;
		this.phone=phone;
		this.address=address;
		this.hobby=hobby;
		this.enroll_date=enroll_date;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pwd() {
		return member_pwd;
	}
	public void setMember_pwd(String member_pwd) {
		this.member_pwd = member_pwd;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public Date getEnroll_date() {
		return enroll_date;
	}
	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		
		return member_id+"\t"+member_name+"\t"+gender+"\t"+age+"\t"
				+email+"\t\t"+phone+"\t"+address+"\t"+hobby+"\t"+enroll_date;
	}
	
	
	

}
