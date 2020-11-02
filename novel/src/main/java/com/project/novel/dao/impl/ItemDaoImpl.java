package com.project.novel.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.project.novel.dao.ItemDao;
import com.project.novel.vo.ItemsVo;

@Repository("itemDao")
public class ItemDaoImpl implements ItemDao{
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public List<ItemsVo> getItemList(ItemsVo vo) {
		return (List<ItemsVo>)sqlMapClientTemplate.queryForList("items.getItemList",vo);
	}
	
	@Override
	public ItemsVo getItem(long itemId) {
		return (ItemsVo)sqlMapClientTemplate.queryForObject("items.getItem",itemId);
	}
	
	@Override
	public int insertView(HashMap<String, Long> map) {
		return (int)sqlMapClientTemplate.update("items.insertView", map);
	}
	
	@Override
	public int isView(HashMap<String, Long> map) {
		return (int)sqlMapClientTemplate.queryForObject("items.isView", map);
	}
}
