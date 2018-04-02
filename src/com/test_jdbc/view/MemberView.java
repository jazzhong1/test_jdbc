package com.test_jdbc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.test_jdbc.controller.MemberController;
import com.test_jdbc.vo.Member;

public class MemberView {
	
	private Scanner sc;
	
	public MemberView() {
		sc=new Scanner(System.in);
	}
	
	public void mainView(){
		
		do {
			System.out.println("==========회원관리프로그램===============");
			System.out.println("0.연결확인정보");
			System.out.println("1.전체회원조회");
			System.out.println("2.회원조회");
			System.out.println("9.종료");
			
			int choice =sc.nextInt();
			switch (choice) {
			case 0:	
					new MemberController().connectDB();
				break;
			case 1:
				new MemberController().selectAll();
				break;
			case 2:
				String id=new MemberView().select();
				new MemberController().selectOn(id);
				break;
				
			case 9:
				new MemberView().displaySuccess("종료");
				return;

			default:
				break;
			}
			
			
			
			
		} while (true);
		
	}
	
	public void displayError(String msg) {
		System.out.println(msg);
	}

	public void displaySuccess(String msg) {
			System.out.println(msg);
		
	}
	
	public void displayList(ArrayList<Member> list) {
		System.out.println("================================================== 회원 조회결과 =====================================================\n");
		System.out.println("아이디\t이름\t성별\t나이\t이메일\t\t\t전화번호\t\t주소\t\t\t취미\t\t가입일");
		for(Member m: list){
			System.out.println(m);
		}	
	}
	
	
	public String select(){
		System.out.println("아이디입력");
		String id=sc.next();
		return id;
	}

	public void displaym(Member member) {	System.out.println("================================================== 회원 조회결과 =====================================================\n");
	System.out.println("아이디\t이름\t성별\t나이\t이메일\t\t\t전화번호\t\t주소\t\t\t취미\t\t가입일");
	System.out.println(member.toString());
		
	}

}