package com.project.novel.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.project.novel.vo.GenreVo;
import com.project.novel.vo.NovelVo;

public interface NovelService {
	/* 전체 작품 리스트 */
	public List<NovelVo> novelList(NovelVo vo);
	
	/* 작품 정보 조회 */
	public NovelVo viewNovel(NovelVo vo);
	
	/* 장르 목록 가져오기 */
	public List<GenreVo> getAllGenre();
	
	/* 페이징 작품 수 */
	public int novelCnt(int genreCode);
	
	/* 랭킹별 작품 리스트 */
	public List<NovelVo> novelListRanking(NovelVo vo);
	
	/* 작품 추천 상태 */
	public ArrayList<Long> getRecommendStatus(HashMap<String, Long> map);
	
	/* 추천수 갱신 */
	public HashMap<String, Integer> getRecommend(Long novelId);
	
	/* 작품 추천 삽입 */
	public int insertRecommend(HashMap<String, Object> map);
	
	/* 작품 추천 변경 */
	
	/* 랭킹 top */
	public List<NovelVo> novelListRanking(HashMap<String, Integer> map);
}
