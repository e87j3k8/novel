package com.project.novel.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.novel.dao.impl.ItemDaoImpl;
import com.project.novel.service.ItemService;
import com.project.novel.vo.ItemsVo;

@Service("itemService")
public class ItemServiceImpl implements ItemService{
	@Autowired ItemDaoImpl itemDao;
	
	@Override
	public List<ItemsVo> getItemList(ItemsVo vo) {
		return itemDao.getItemList(vo);
	}
	
	@Override
	public ItemsVo getItem(long itemId) {
		return itemDao.getItem(itemId);
	}
	
	@Override
	public int insertView(HashMap<String, Long> map) {
		return itemDao.insertView(map);
	}
	
	@Override
	public int isView(HashMap<String, Long> map) {
		return itemDao.isView(map);
	}
}
