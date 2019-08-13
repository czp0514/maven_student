package com.bw.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bw.mapper.StudentMapper;
import com.bw.pojo.Course;
import com.bw.pojo.PageUtil;
import com.bw.pojo.StuCou;
import com.bw.pojo.Student;
import com.bw.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;
	
	
	@Override
	public int getCount(Student student) {
		return studentMapper.getCount(student);
	}

	@Override
	public List<Student> getStudentList(Student student, PageUtil pageUtil) {
		Map<String,Object> map= new HashMap();
		map.put("pageUtil", pageUtil);
		map.put("student", student);
		return studentMapper.getStudentList2(map);
	}
		// 添加学生信息
	@Override
	public boolean addStudent(Student student) {
		//1.插入学生基本信息student
			int row=studentMapper.addStudent(student);
			System.out.println("返回的自增的主键id"+student.getSid());
			int sid=student.getSid();
			
			List<Course> courseList = student.getCourseList();
			//放置学生选的课程id
			List<StuCou> stuCouList =new ArrayList<>();
			if(courseList !=null && courseList.size()>0) {
				for (Course course : courseList) {
					//course中的不等于null的时候表示课程被选中
					Integer cid=course.getCid();
					if(cid !=null) {
						//插入该课程和学生的对应关系
						StuCou stuCou = new StuCou();
						stuCou.setSid(sid);
						stuCou.setCid(cid);
						stuCouList.add(stuCou);
					}
				}
			}
			////2.插入学生和课程的关系表
				int row2=studentMapper.addStuCou(stuCouList);
				if(row>0 && row2>0) {
					return true;
				}
		return false;
	}

	@Override
	public Student getStudentById(Integer sid) {
		
		return studentMapper.getstudentById();
	}

}
