package com.project.novel.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.project.novel.dao.NovelDao;
import com.project.novel.vo.GenreVo;
import com.project.novel.vo.NovelVo;

@Repository("novelDao")
public class NovelDaoImpl implements NovelDao {
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<NovelVo> novelListAll(NovelVo vo) {
		return (List<NovelVo>)sqlMapClientTemplate.queryForList("novel.getProductList",vo);
	}
	
	@Override
	public NovelVo viewNovel(NovelVo vo) {
		return (NovelVo)sqlMapClientTemplate.queryForObject("novel.getProduct",vo);
	}
	
	@Override
	public List<GenreVo> getAllGenre() {
		return (List<GenreVo>)sqlMapClientTemplate.queryForList("novel.getGenre");
	}
	
	@Override
	public int novelCnt(int genreCode) {
		return (int)sqlMapClientTemplate.queryForObject("novel.countAll", genreCode);
	}
	
	@Override
	public List<NovelVo> novelListRanking(NovelVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Long> getRecommendStatus(HashMap<String, Long> map) {
		return (ArrayList<Long>)sqlMapClientTemplate.queryForList("novel.isRecommend",map);
	}
	
	@Override
	public HashMap<String, Integer> getRecommend(Long novelId) {
		return (HashMap<String, Integer>)sqlMapClientTemplate.queryForObject("novel.getRecommend", novelId);
	}
	
	@Override
	public int insertRecommend(HashMap<String, Object> map) {
		return (int)sqlMapClientTemplate.update("novel.insertRecommend", map);
	}
	
	@Override
	public List<NovelVo> novelListRanking(HashMap<String, Integer> map) {
		return (List<NovelVo>)sqlMapClientTemplate.queryForList("novel.rankingTop",map);
	}
}
