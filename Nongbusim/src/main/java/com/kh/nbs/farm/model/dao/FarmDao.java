package com.kh.nbs.farm.model.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.kh.nbs.common.model.vo.Attachment;
import com.kh.nbs.common.model.vo.PageInfo;
import com.kh.nbs.farm.model.vo.Farm;
import com.kh.nbs.program.model.vo.Program;

@Repository
public class FarmDao {

	public int selectFarmCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("farmMapper.selectFarmCount");
	}
	
	public int selectFarmCount(String localCode, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("farmMapper.selectFarmCount", localCode);
	}
	
	public ArrayList<Farm> selectFarmList(PageInfo pi, String localCode, SqlSessionTemplate sqlSession) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("farmMapper.selectFarmList", localCode, rowBounds);
	}
	
	public ArrayList<Attachment> selectAttachmentList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("farmMapper.selectAttachmentList");
	}
	
	public ArrayList<Program> selectProgramList(SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("farmMapper.selectProgramList");
	}
	
	public int insertAttachment(Attachment a, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("attachmentMapper.insertAttachmentFarm", a);
	}

	public int insertFarm(Farm f, SqlSessionTemplate sqlSession) {
		return sqlSession.insert("farmMapper.insertFarm", f);
	}

	public ArrayList<Farm> selectMyFarmList(int memNo, SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("farmMapper.selectMyFarmList", memNo);
	}

	public Farm selectFarm(int farmNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("farmMapper.selectFarm", farmNo);
	}
	
	public ArrayList<Attachment> selectAttachment(int farmNo, SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("farmMapper.selectAttachment", farmNo);
	}
	
	public ArrayList<Program> selectProgram(int farmNo, SqlSessionTemplate sqlSession) {
		return (ArrayList)sqlSession.selectList("farmMapper.selectProgram", farmNo);
	}

	public List selectFileNo(int farmNo, SqlSessionTemplate sqlSession) {
		return sqlSession.selectList("farmMapper.selectFileNo", farmNo);
	}
	
	public int deleteAttachment(List delList, SqlSessionTemplate sqlSession) {
		return sqlSession.delete("farmMapper.deleteAttachment", delList);
	}
	
	public int insertAttachment(List upfileList, SqlSessionTemplate sqlSession) {
		return sqlSession.update("farmMapper.insertAttachment", upfileList);
	}
	
	public int updateFarm(Farm f, SqlSessionTemplate sqlSession) {
		return sqlSession.update("farmMapper.updateFarm", f);
	}
	
	public int updateInsertAttachment(List upfileList, SqlSessionTemplate sqlSession) {
		return sqlSession.update("farmMapper.updateInsertAttachment", upfileList);
	}
	
	/*
	public ArrayList<Attachment> deleteAttachment(int[] fileNo, SqlSessionTemplate sqlSession) {
		List list = Arrays.asList(fileNo);
		
		return (ArrayList)sqlSession.selectList("farmMapper.deleteAttachment", list);
	}
	*/

	public int deleteFarm(int farmNo, SqlSessionTemplate sqlSession) {
		return sqlSession.update("farmMapper.deleteFarm", farmNo);
	}

	public int selectSearchListCount(HashMap map, SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("farmMapper.selectSearchListCount", map);
	}

	public ArrayList<Farm> selectSearchList(PageInfo pi, HashMap map, SqlSessionTemplate sqlSession) {
		int offset = (pi.getCurrentPage() - 1) * pi.getBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getBoardLimit());
		return (ArrayList)sqlSession.selectList("farmMapper.selectSearchList", map, rowBounds);
	}



	
	




}
