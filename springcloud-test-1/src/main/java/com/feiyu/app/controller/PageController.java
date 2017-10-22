package com.feiyu.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

	@RequestMapping("/index")
	public String index() {
		//看看提交成功了没有1
		//看看提交成功了没有2
		return "index";
	}
	
	@RequestMapping("/school")
	public String schoolPage() {
		return "school";
	}
	@RequestMapping("/student")
	public String studentPage() {
		return "student";
	}
}
