package com.bw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bw.pojo.Page;
import com.bw.pojo.Student;
import com.bw.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("GetStudentList")
	public ModelAndView GetStudentList() { 
		List<Student> slist = studentService.findStudent();
		ModelAndView mv=new ModelAndView();
		mv.addObject("slist", slist);
		mv.setViewName("forward:studentMain.jsp");
		return mv;
	}
	
	@RequestMapping("/findByPage")
	public ModelAndView findByPage(HttpServletRequest request) {
		//初始化显示第一页
		int pageIndex=1;
		int pageSize=3;//每页显示的个数
		Page<Student> page = new Page<Student>();
		List<Student> slist=new ArrayList<>();
		if(request.getParameter("pageIndex")!=null) {
			pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
		}
		page.setPageIndex(pageIndex);
		int pageNum = studentService.pageCount();
		page.setPageNum(pageNum);
		page.setPageSize(pageSize);
		if(page.getPageNum()%page.getPageSize()==0) {
			page.setPageCount(page.getPageNum()/page.getPageSize());
		}else {
			page.setPageCount(page.getPageNum()/page.getPageSize()+1);
		}
		int index=(pageIndex-1)*pageSize;
		slist = studentService.findByPage(index);
		page.setList(slist);
		ModelAndView mv=new ModelAndView();
		mv.addObject("page", page);
		mv.setViewName("forward:studentMain.jsp");
		return mv;
	}
}
