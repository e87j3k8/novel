package com.project.novel.service;

import java.util.HashMap;
import java.util.List;

import com.project.novel.vo.ItemsVo;

public interface ItemService {
	
	/* 소설 목록 조회 */
	public List<ItemsVo> getItemList(ItemsVo vo);
	
	/* 소설 보기 */
	public ItemsVo getItem(long itemId);
	
	/* 조회수 업 */
	public int insertView(HashMap<String, Long> map);
	
	/* 조회 여부 */
	public int isView(HashMap<String, Long> map);
}
