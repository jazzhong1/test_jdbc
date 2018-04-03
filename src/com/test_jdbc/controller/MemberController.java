package com.test_jdbc.controller;

import java.util.ArrayList;

import com.test_jdbc.dao.MemberDao;
import com.test_jdbc.view.MemberView;
import com.test_jdbc.vo.Member;

public class MemberController {
	
	public MemberController() {
		// TODO Auto-generated constructor stub
	}
	
	public void connectDB(){
		int result=new MemberDao().connectDB();
		
		if(result>0){
			new MemberView().displaySuccess("연결성공");
		}
		else{
			new MemberView().displayError("연결실패");
		}
	}
	
	public void selectAll(){
		ArrayList<Member>list=new MemberDao().selectAll();	
		
		if(list!=null&&list.size()>0){
			new MemberView().displayList(list);
		}
		else{
			new MemberView().displayError("실패");
		}
		
	}
	
	public void selectOn(String id){
		Member member=new MemberDao().selectOne(id);
		
		if(member!=null){
			new MemberView().displaym(member);
		}
		else{
			new MemberView().displayError("실패");
		}
		
	}
	
	public void insertMember(Member member){
		
		int result=new MemberDao().insertMember(member);
		if(result>0){
			new MemberView().displaySuccess("성공");
		}
		else{
			new MemberView().displayError("실패");
		}
		
		
		
	}
	
	public void updateMember(String id){
		int result=new MemberDao().find(id);
		
		if(result>0){
			Member member=new MemberView().updateMember();
			int result2=new MemberDao().updateMember(member,id);
			if(result2>0){
				new MemberView().displaySuccess("수정완료");
			}
			else{
				new MemberView().displayError("정보를 확인하세요");
			}
		}
		else{
			new MemberView().displayError("아이디오류");
		}
		
	}
	
	public void deleteMember(String id){
		int result=new MemberDao().find(id);
		
		if(result>0){
			int result2=new MemberDao().memberDelete(id);
			if(result2>0){
				new MemberView().displaySuccess("삭제성공");
			}
		}
		else{
			new MemberView().displayError("아이디확인");
		}
	}
	
	
}
