package com.project.novel.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.novel.dao.impl.NovelDaoImpl;
import com.project.novel.service.NovelService;
import com.project.novel.vo.NovelVo;

@Service("novelService")
public class NovelServiceImpl implements NovelService {
	@Autowired private NovelDaoImpl novelDao;  
	
	@Override
	public List<NovelVo> novelList(NovelVo vo) {
		return novelDao.novelListAll(vo);
	}
	
	@Override
	public List<NovelVo> novelListRanking(NovelVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
}
