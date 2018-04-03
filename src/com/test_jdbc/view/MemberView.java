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
			System.out.println("3.회원가입");
			System.out.println("4.회원정보수정");
			System.out.println("5.회원삭제");
			System.out.println("9.종료");
			System.out.println("입력: ");
			
			int choice =sc.nextInt();
			sc.nextLine();
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
			case 3:
				Member member=this.insertMember();
				new MemberController().insertMember(member);
				break;
				
			case 4:
				id=new MemberView().select();
				new MemberController().updateMember(id);
				break;
			case 5:
				id=new MemberView().select();
				new MemberController().deleteMember(id);
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
	
	public Member insertMember(){
		
		Member member=new Member();
		System.out.println("=====회원정보입력======");
		System.out.print("아이디 : ");
		member.setMember_id(sc.nextLine());
		System.out.print("비밀번호 : ");
		member.setMember_pwd(sc.nextLine());
		System.out.print("이름 : ");
		member.setMember_name(sc.nextLine());
		System.out.print("성별 : ");
		member.setGender(sc.next().charAt(0));
		System.out.print("나이 : ");
		member.setAge(sc.nextInt());
		sc.nextLine();	///앞에int가있을경우 이런 현상이 발생한다.
						///굳이 사용하고 싶지 않을경우 next로 사용한다.
		
		System.out.print("이메일 : ");
		member.setEmail(sc.nextLine());
		System.out.print("전화번호 : ");
		member.setPhone(sc.nextLine());
		System.out.print("주소 : ");
		member.setAddress(sc.nextLine());
		System.out.print("취미 : ");
		member.setHobby(sc.nextLine());
		member.setEnroll_date(null);
		return member;
		}
	
	public Member updateMember() {	
		
		Member member=new Member();
		
		System.out.println("=====수정입력======");
		System.out.print("이름 : ");
		member.setMember_name(sc.nextLine());
		System.out.print("나이 : ");
		member.setAge(sc.nextInt());
		sc.nextLine();	///앞에int가있을경우 이런 현상이 발생한다.
						///굳이 사용하고 싶지 않을경우 next로 사용한다.
	
		System.out.print("전화번호 : ");
		member.setPhone(sc.nextLine());
		System.out.print("주소 : ");
		member.setAddress(sc.nextLine());
		return member;
	
	}

}
