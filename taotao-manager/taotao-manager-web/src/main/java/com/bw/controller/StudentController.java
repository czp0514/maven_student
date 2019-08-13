package com.bw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bw.pojo.Course;
import com.bw.pojo.Grade;
import com.bw.pojo.PageUtil;
import com.bw.pojo.Student;
import com.bw.service.CourseService;
import com.bw.service.GradeService;
import com.bw.service.StudentService;

/**
 * 功能描述:TODO<br>
 *
 * 时间:2019年8月12日  下午4:19:23
 */
@Controller
public class StudentController {
		@Autowired
		private StudentService studentService;
	
		@Autowired
		private GradeService gradeService;
		
		@Autowired
		private CourseService courseService;
		
	@RequestMapping("getStudentList.action")
	public String getStudentList(Student student,@RequestParam(value="page",defaultValue="1")String page,Model model) {
		int row=studentService.getCount(student);
		PageUtil pageUtil=new PageUtil(page,2,row);
		
		List<Student> studentList=studentService.getStudentList(student,pageUtil);
		List<Grade> gList=gradeService.getGradeList();
		model.addAttribute("pageUtil", pageUtil);
		model.addAttribute("studentList", studentList);
		model.addAttribute("gList", gList);
		model.addAttribute("student", student);
		
		return "studentList";
	}
	
	/**
	 * 功能描述:跳转到添加页面
	 *
	 * 时间:2019年8月12日  下午4:19:52
	 */
	@RequestMapping("toAdd.action")
	public String toAdd(Model model) {
		//1.查询所有的班级信息
		List<Grade> gList=gradeService.getGradeList();
		//2.查询所有的课程信息
		List<Course>cList=courseService.getCourseList();
		model.addAttribute("gList", gList);
		model.addAttribute("cList", cList);
		return "add";
	}
	
	@RequestMapping("save.action")
	public String save(Student student) {
		boolean flag=studentService.addStudent(student);
		//增删改操作完成之后重定向到列表查询页面
		if(flag) {
			return "redirect:getStudentList.action";
		}
		return "redirect:add.jsp";
	}
	
	
	/**
	 * @param sid
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdate.action")
	public String toUpdate(Integer sid,Model model) {
		//根据id查询学生的信息
		Student stu=studentService.getStudentById(sid);
		//所有班级的列表.
		List<Grade> gList = gradeService.getGradeList();
		//所有课程的列表
		List<Course> cList = courseService.getCourseList();
		model.addAttribute("stu", stu);
		model.addAttribute("gList", gList);
		model.addAttribute("cList", cList);
		return null;
	}
}
