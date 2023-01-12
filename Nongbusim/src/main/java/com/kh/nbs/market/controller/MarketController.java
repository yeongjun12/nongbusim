package com.kh.nbs.market.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kh.nbs.common.model.vo.Attachment;
import com.kh.nbs.common.model.vo.PageInfo;
import com.kh.nbs.common.template.Pagination;
import com.kh.nbs.market.model.service.MarketService;
import com.kh.nbs.market.model.vo.Market;
import com.kh.nbs.member.model.vo.Member;


@Controller
public class MarketController {

	@Autowired
	private MarketService marketService;
	
	
	
	
	
	//게시판으로 이동
	@RequestMapping("list.mk")
	public String marketSelectList(@RequestParam(value="cpage", defaultValue="1") int currentPage,
								   Model model) {
		
		PageInfo pi = Pagination.getPageInfo(marketService.selectListCount(), currentPage, 5, 9);
		

		model.addAttribute("pi", pi);
		model.addAttribute("list", marketService.marketSelectList(pi));
		model.addAttribute("at", marketService.attachmentSelectList());
		
		
		ArrayList<Market> list = marketService.marketSelectList(pi);
		
		return "market/marketListView";
		
	}
	
	
	
	
	
	
	//게시물상세화면으로 이동
	@RequestMapping("detail.mk")
	public ModelAndView marketDetailView(Market market, ModelAndView mv) {
		
		if(marketService.increaseCount(market) > 0) {
			
			if(marketService.marketDetailView(market) != null) {
				
				mv.addObject("list", marketService.marketDetailView(market));
				
				if(marketService.marketDetailAttachment(market) != null) {
						
					mv.addObject("at", marketService.marketDetailAttachment(market));
					mv.setViewName("market/marketDetailView");
					
				}
			}
			
		}
		
		return mv;
		
	}
	
	
	
	
	
	
	
	//게시물 작성화면으로 이동
	@RequestMapping("insertForm.mk")
	public String marketInsertForm() {
		
		return "market/marketInsertForm";
	}
	
	
	//파일이름수정
	public String saveFile(MultipartFile upfile, HttpSession session) {
		
		// 파일 명 수정 작업 후 서버에 업로드 시키기("image.png" => 2022.12.38123.123.png)
		String originName = upfile.getOriginalFilename();
		
		// "20221226103530"(년월일시분초)
		String currentTime = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		// 12321(5자리 랜덤값)
		int ranNum = (int)(Math.random() * 90000 + 10000);
		// 확장자
		String ext = originName.substring(originName.lastIndexOf("."));
		
		String changeName = currentTime + ranNum + ext;
		
		// 업로드 시키고자하는 폴더의 물리적인경로 알아내기
		String savePath = session.getServletContext().getRealPath("/resources/uploadFiles/");
		
		try {
			upfile.transferTo(new File(savePath + changeName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return changeName;
	}
	
	
	
	
	
	
	
	
	//게시물 작성
	@RequestMapping("insert.mk")
	public ModelAndView marketInsert(Market market, ModelAndView mv, MultipartFile[] upfiles, RedirectAttributes rttr, HttpSession session, Attachment a) {
		
		market.setMemNo(((Member)session.getAttribute("loginUser")).getMemNo());
		
		if(marketService.insertMarket(market) > 0) {
	
			for(MultipartFile upfile : upfiles) {
				
				if(!upfile.getOriginalFilename().equals("")) {

					a.setBoardType("mk");
					a.setOriginName(upfile.getOriginalFilename()); // 원본명
					a.setChangeName("resources/uploadFiles/" + saveFile(upfile, session)); // 저장경로
					
					marketService.insertAttachment(a);
						
				}
			}
			rttr.addFlashAttribute("alertMsg", "게시물이 등록되었습니다");
			mv.setViewName("redirect:/list.mk");
			return mv;
		} else {
			// 첨부파일 삭제
			return mv;
		}
		
		
	}
	
	
	
	
	
	
	
	//게시물 수정화면으로 이동
	@RequestMapping("updateForm.mk")
	public ModelAndView marketUpdateForm(Market market, ModelAndView mv) {

		
		mv.addObject("market", marketService.marketDetailView(market));
		mv.addObject("at", marketService.marketDetailAttachment(market));
		mv.setViewName("market/marketUpdateForm");
		
		return mv;
	
		
	}
	
	
	
	
	
	
	
	
	//게시물 수정 
	

	
	
	
	
	
	
	//게시물 삭제 
	@RequestMapping("delete.mk")
	public ModelAndView marketDelete(int marketNo, ModelAndView mv, RedirectAttributes rttr) {
		
		if(marketService.marketDeleteAttachment(marketNo) > 0) {
			
			if(marketService.marketDelete(marketNo) > 0) {		
				
				//첨부파일 삭제
				
				
				rttr.addFlashAttribute("alertMsg", "게시물이 삭제되었습니다.");
				mv.setViewName("redirect:list.mk");
				return mv;
			}
			
		}else {
			rttr.addFlashAttribute("alertMsg", "게시물 삭제를 실패했습니다.");
			mv.setViewName("redirect:list.mk");
			return mv;
			
		}
		return mv;

		
	}
	
	
	
	

	
	
	

	
}
