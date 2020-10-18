package com.project.novel.service;

import com.project.novel.vo.NovelVo;

public interface NovelService {
	/* 전체 작품 리스트 */
	public NovelVo novelListAll(NovelVo vo);
	
	/* 장르별 작품 리스트 */
	public NovelVo novelListGenre(NovelVo vo);
	
	/* 랭킹별 작품 리스트 */
	public NovelVo novelListRanking(NovelVo vo);
}
