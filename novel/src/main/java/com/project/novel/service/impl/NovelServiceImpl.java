package com.project.novel.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.novel.dao.impl.NovelDaoImpl;
import com.project.novel.service.NovelService;
import com.project.novel.vo.GenreVo;
import com.project.novel.vo.NovelVo;

@Service("novelService")
public class NovelServiceImpl implements NovelService {
	@Autowired private NovelDaoImpl novelDao;  
	
	@Override
	public List<NovelVo> novelList(NovelVo vo) {
		return novelDao.novelListAll(vo);
	}
	
	@Override
	public NovelVo viewNovel(NovelVo vo) {
		return novelDao.viewNovel(vo);
	}
	
	@Override
	public List<GenreVo> getAllGenre() {
		return novelDao.getAllGenre();
	}
	
	@Override
	public int novelCnt(int genreCode) {
		return novelDao.novelCnt(genreCode);
	}
	
	@Override
	public List<NovelVo> novelListRanking(NovelVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public ArrayList<Long> getRecommendStatus(HashMap<String, Long> map) {
		return novelDao.getRecommendStatus(map);
	}
	
	@Override
	public HashMap<String, Integer> getRecommend(Long novelId) {
		return novelDao.getRecommend(novelId);
	}
	
	@Override
	public int insertRecommend(HashMap<String, Object> map) {
		return novelDao.insertRecommend(map);
	}
	
	@Override
	public List<NovelVo> novelListRanking(HashMap<String, Integer> map) {
		return novelDao.novelListRanking(map);
	}
}
