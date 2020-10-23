package com.project.novel.dao;

import java.util.List;

import com.project.novel.vo.NovelVo;

public interface NovelDao {
	/* 작품 리스트 */
	public List<NovelVo> novelListAll(NovelVo vo);
	
	/* 랭킹별 작품 리스트 */
	public List<NovelVo> novelListRanking(NovelVo vo);
	
}
