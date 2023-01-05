package com.kh.nbs.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.nbs.diary.model.service.DiaryService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService diaryService;

	@RequestMapping("list.di")
	public String diaryList() {
		return "member/myPageFarmer/diaryListView" ;
		
	}
}
