package com.project.novel.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.project.novel.dao.UserDao;
import com.project.novel.vo.UserVo;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Autowired SqlMapClientTemplate sqlMapClientTemplate;
	
	@Override
	public UserVo getUser(UserVo vo) {
		return (UserVo)sqlMapClientTemplate.queryForObject("user.getUser",vo);
	}
}
