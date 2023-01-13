package com.kh.nbs.review.model.service;

import java.util.ArrayList;

import com.kh.nbs.review.model.vo.Review;

public interface ReviewService {
	
	//리뷰 작성
	int reviewInsert(Review r);

	//리뷰 페이지
	ArrayList<Review> selectReviewList();
	
	//리뷰 리스트
	int selectReviewCount();
	
}
