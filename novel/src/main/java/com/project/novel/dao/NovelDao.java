package com.project.novel.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.project.novel.vo.NovelVo;

public interface NovelDao {
	/* 작품 리스트 */
	public List<NovelVo> novelListAll(NovelVo vo);
	
	/* 작품 정보 조회 */
	public NovelVo viewNovel(NovelVo vo);
	
	/* 작품 페이징 */
	public int novelCnt();
	
	/* 랭킹별 작품 리스트 */
	public List<NovelVo> novelListRanking(NovelVo vo);
	
	/* 작품 추천 상태 */
	public ArrayList<Long> getRecommendStatus(HashMap<String, Long> map);
	
	/* 추천수 갱신 */
	public HashMap<String, Integer> getRecommend(Long novelId);
	
	/* 작품 추천 삽입 */
	public int insertRecommend(HashMap<String, Object> map);
	
	/* 작품 추천 변경 */
	
	/* 메인 랭킹 top */
	public List<NovelVo> novelListRanking(HashMap<String, Integer> map);
}
