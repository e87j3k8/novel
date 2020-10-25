package com.project.novel.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.project.novel.dao.NovelDao;
import com.project.novel.vo.NovelVo;

@Repository("novelDao")
public class NovelDaoImpl implements NovelDao {
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<NovelVo> novelListAll(NovelVo vo) {
		return (List<NovelVo>)sqlMapClientTemplate.queryForList("novel.getProductList",vo);
	}
	
	@Override
	public List<NovelVo> novelListRanking(NovelVo vo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<NovelVo> novelListRanking(HashMap<String, Integer> map) {
		return (List<NovelVo>)sqlMapClientTemplate.queryForList("novel.rankingTop",map);
	}
}
