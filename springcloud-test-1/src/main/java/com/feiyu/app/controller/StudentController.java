package com.feiyu.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.feiyu.app.model.Result;
import com.feiyu.app.model.School;
import com.feiyu.app.model.Student;

@Controller
public class StudentController {
	
	@RequestMapping("/getStudent")
	@ResponseBody
	public Map<String,Object> getStudent() {
		//TODO 查找的逻辑
		System.out.println("getStudent!!");
		String str = "{'total':4,'rows':[{'id':'111','name':'四川大学'},{'id':'12','name':'清华大学'}]}";
		Map map = new HashMap();
		List list = new ArrayList();
		
		Student s1 = new Student();
		s1.setId(1);
		s1.setName("小明");
			School school1 = new School();
			school1.setId(1);
			school1.setName("清华大学");
		s1.setSchool(school1);
		
		Student s2 = new Student();
		s2.setId(2);
		s2.setName("小王");
			School school2 = new School();
			school2.setId(2);
			school2.setName("北京大学");
		s2.setSchool(school2);
		list.add(s1);
		list.add(s2);
		map.put("total", 2);
		map.put("rows", list);	
		System.out.println(map);
		return map;
	}
	
	@RequestMapping("/addStudent")
	@ResponseBody
	public Result addStudent(String name,String SchoolName) {
		System.out.println(name);
		//TODO 添加的逻辑
		Result result = new Result();
//		result.setSuccess(true);
//		result.setMsg("添加成功");		
		result.setSuccess(false);
		result.setMsg("添加失败");
		return result;
	}
	
	@RequestMapping("/deleteStudent")
	@ResponseBody
	public Result deleteStudent(String ids) {
		System.out.println(ids);
		//TODO 删除的逻辑
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg("删除成功");		
//		result.setSuccess(false);
//		result.setMsg("删除失败");
		return result;
	}
	
	@RequestMapping("/updateStudent")
	@ResponseBody
	public Result updateStudent(String id,String name,String schoolName) {
		System.out.println(id);
		System.out.println(name);
		//TODO 修改的逻辑
		Result result = new Result();
		result.setSuccess(true);
		result.setMsg("修改成功");		
//		result.setSuccess(false);
//		result.setMsg("修改失败");
		return result;
	}
}
