package com.jd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jd.dao.ForumMapper;
import com.jd.pojo.Forum;
import com.jd.pojo.ForumExample;

@Service
public class ForumServiceImpl implements ForumService {

	@Autowired
	private ForumMapper forumMapper;
	
	@Override
	public int countByExample(ForumExample example) {
		return forumMapper.countByExample(example);
	}

	@Override
	public boolean deleteByExample(ForumExample example) {
		return forumMapper.deleteByExample(example) > 0;
	}

	@Override
	public boolean deleteByPrimaryKey(Integer forumId) {
		return forumMapper.deleteByPrimaryKey(forumId) > 0;
	}

	@Override
	public boolean insert(Forum record) {
		return forumMapper.insert(record) > 0;
	}

	@Override
	public boolean insertSelective(Forum record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Forum> selectByExample(ForumExample example) {
		return forumMapper.selectByExample(example);
	}

	@Override
	public Forum selectByPrimaryKey(Integer forumId) {
		return forumMapper.selectByPrimaryKey(forumId);
	}

	@Override
	public boolean updateByExampleSelective(Forum record, ForumExample example) {
		return false;
	}

	@Override
	public boolean updateByExample(Forum record, ForumExample example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateByPrimaryKeySelective(Forum record) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateByPrimaryKey(Forum record) {
		// TODO Auto-generated method stub
		return false;
	}

}
