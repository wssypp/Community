package com.jd.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jd.pojo.Forum;
import com.jd.pojo.ForumExample;
import com.jd.pojo.ForumExample.Criteria;
import com.jd.pojo.Users;
import com.jd.service.ForumService;

@Controller
@RequestMapping("/ForumController")
public class ForumController {
	
	@Autowired
	private ForumService forumService;
	
	private ForumExample forumExample;
	
	@GetMapping("/getForums")
	public String getForums(HttpServletRequest request, HttpSession session ) throws ParseException{
		String forumId = request.getParameter("forumId");
		String page = request.getParameter("page");
		String pageSize = request.getParameter("pageSize");
		
		String forumTime = request.getParameter("forumTime");
		String forumType = request.getParameter("forumType");
		Forum selectByPrimaryKey = forumService.selectByPrimaryKey(Integer.parseInt(forumId));
		
		
		List<Forum> flist = forumService.selectByExample(null);
		
		forumExample = new ForumExample();
		
		forumExample.setOrderByClause(" forum_id limit "+page+","+pageSize);
		
		forumExample.setDistinct(true);
		
		Criteria createCriteria = forumExample.createCriteria();
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat();
		
		Date parse = simpleDateFormat.parse(forumTime);
		
		createCriteria.andForumTimeEqualTo(parse);
		
		
		
		List<Forum> listbyLimit = forumService.selectByExample(forumExample);
		
		Forum forum = forumService.selectByPrimaryKey(Integer.parseInt(forumId));
		
		Users users = forum.getUsers();
	
		users.getUsersName();
		
		Forum forum1 = new Forum();
		
	
		/*forumService.insert(record);
		
		Forum forum2 = new Forum();
		
		forum2.setForumTime(forumTime);
		
		forum2.setForumType(forumType);
		
		forumService.insertSelective(forum2);
		
		Forum forum4 = new Forum();
		forum4.setForumId(forumId);
		
		forum4.setForumType(forumType);
		forumService.updateByPrimaryKey(forum4);
		
		forumService.updateByPrimaryKeySelective(record)
		
		forumService.updateByExample(record, example)
		
		forumService.updateByExampleSelective(record, example)*/
		
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
