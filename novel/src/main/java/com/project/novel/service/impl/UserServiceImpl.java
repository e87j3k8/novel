package com.project.novel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.novel.dao.UserDao;
import com.project.novel.service.UserService;
import com.project.novel.vo.UserVo;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired private UserDao userDao;
	
	@Override
	public UserVo getUser(UserVo vo) {
		return userDao.getUser(vo);
	}
}
