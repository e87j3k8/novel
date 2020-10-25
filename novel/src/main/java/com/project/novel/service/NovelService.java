package com.project.novel.service;

import java.util.HashMap;
import java.util.List;

import com.project.novel.vo.NovelVo;

public interface NovelService {
	/* 전체 작품 리스트 */
	public List<NovelVo> novelList(NovelVo vo);
	
	/* 랭킹별 작품 리스트 */
	public List<NovelVo> novelListRanking(NovelVo vo);
	
	/* 랭킹 top */
	public List<NovelVo> novelListRanking(HashMap<String, Integer> map);
}
