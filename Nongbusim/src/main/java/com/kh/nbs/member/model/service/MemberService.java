package com.kh.nbs.member.model.service;

import java.util.ArrayList;

import com.kh.nbs.board.model.vo.Board;
import com.kh.nbs.market.model.vo.Market;
import com.kh.nbs.member.model.vo.Member;
import com.kh.nbs.program.model.vo.Program;

public interface MemberService {

	// 로그인 (select)
	Member loginMember(Member m);
	
	// 일반 사용자 회원가입 (insert)
	int userInsertMember(Member m);
	
	// 농부 회원가입(insert)
	int farmerInsertMember(Member m);
	
	// 일반 사용자 정보 수정 (update)
	int updateUser(Member m);
	
	// 농부 정보 수정(update)
	int updateFarmer(Member m);
	
	// 일반 사용자 탈퇴 (update)
	int deleteUser(String memId);
	
	// 농부 탈퇴(update)
	int deleteFarmer(String memId);
	
	// 아이디 중복체크(select)
	int idCheck(String memId);
	
	// 일반 사용자가 작성한 게시글 조회(select)
	ArrayList<Board> userMyBoardList(int memNo);
	
	// 농부가 작성한 게시글 조회(select)
	ArrayList<Board> farmerMyBoardList(int memNo);
	
	// 찜한 프로그램(select)
	ArrayList<Program> markProgram(int memNo);
	
	// 찜한 마켓(select)
	ArrayList<Market> markMarket(int memNo);
	
	// 비밀번호 변경(update)
	int updatePwd(String pwd);
	
	// 아이디 찾기(select)
//	Member findId(String memPwd);
	
	// 비밀번호 찾기(select)
}
