package com.feiyu.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feiyu.app.model.Result;
import com.feiyu.app.model.School;

@Controller
public class SchoolController {
	
	@RequestMapping("/getSchool")
	@ResponseBody
	public Map<String,Object> getSchool() {
		//TODO 查找的逻辑
		System.out.println("getSchool!!");
		String str = "{'total':4,'rows':[{'id':'111','name':'四川大学'},{'id':'12','name':'清华大学'}]}";
		Map map = new HashMap();
		List list = new ArrayList();
		School s1 = new School();
		s1.setId(1);
		s1.setName("清华大学");
		School s2 = new School();
		s2.setId(2);
		s2.setName("北京大学");
		list.add(s1);
		list.add(s2);
		map.put("total", 2);
		map.put("rows", list);	
		System.out.println(map);
		return map;
	}
	
	@RequestMapping("/addSchool")
	@ResponseBody
	public Result addSchool(String name) {
		System.out.println(name);
		//TODO 添加的逻辑
		Result result = new Result();
//		result.setSuccess(true);
//		result.setMsg("添加成功");		
		result.setSuccess(false);
		result.setMsg("添加失败");
		return result;
	}
	
	@RequestMapping("/deleteSchool")
	@ResponseBody
	public Result deleteSchool(String ids) {
		System.out.println(ids);
		//TODO 删除的逻辑
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg("删除成功");		
//		result.setSuccess(false);
//		result.setMsg("删除失败");
		return result;
	}
	
	@RequestMapping("/updateSchool")
	@ResponseBody
	public Result updateSchool(String id,String name) {
		System.out.println(id);
		System.out.println(name);
		//TODO 删除的逻辑
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg("修改成功");		
//		result.setSuccess(false);
//		result.setMsg("修改失败");
		return result;
	}
	
	
}
