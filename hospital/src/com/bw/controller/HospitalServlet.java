package com.bw.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bw.pojo.Hospital;
import com.bw.pojo.Type;
import com.bw.service.HospitalService;
import com.bw.service.impl.HospitalServiceImpl;
import com.bw.util.PageUtil;

/**
 * 功能描述：method这个参数决定调用哪个方法 <br>
 * 作者： zz <br>
 * 时间：2019年7月10日  下午3:04:17
 */
@WebServlet("/hospital")
public class HospitalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HospitalService hospitalService = new HospitalServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("getHospitalList".equals(method)) {
			//当前页，每页显示的条数3,5，总记录数
			//获取当前页
			String page = request.getParameter("page");
			//获取总记录数
			int count = hospitalService.getCount(); 
			//封装分页对象
			PageUtil pageUtil = new PageUtil(page, 10, count);
			//分页查询医院的列表信息
			List<Hospital> hlist = hospitalService.getHospitalList(pageUtil);
			//把列表和分页对象放置作用域
			request.setAttribute("pageUtil", pageUtil);
			request.setAttribute("hlist", hlist);
			//转发
			request.getRequestDispatcher("hlist.jsp").forward(request, response);
			
		}else if("toAdd".equals(method)) {
			//获取所有医院的等级列表
			List<Type> tlist = hospitalService.getTypeList();
			request.setAttribute("tlist", tlist);
			//转发到添加页面
			request.getRequestDispatcher("add.jsp").forward(request, response);
		}else if("add".equals(method)) {
			//添加医院信息
			String hospital_name = request.getParameter("hospital_name");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String datea = request.getParameter("datea");
			String content = request.getParameter("content");
			String tid = request.getParameter("tid");
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Date date = null;
			try {
				date = format.parse(datea);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Hospital hospital = new Hospital(0, hospital_name, name, tel, date, content, Integer.valueOf(tid));
			int row = hospitalService.add(hospital);
			if(row > 0) {
				//添加成功，重定向跳转至列表展示页面
				response.sendRedirect(request.getContextPath()+"/hospital?method=getHospitalList");
			}
		}else if("toUpdate".equals(method)) {
			//跳转至修改页面
			//1.根据id查询对象
			//2.查询所有的医院等级
		}else if("delete".equals(method)) {
			//根据id删除
		}else if("deleteAll".equals(method)) {
			String[] ids = request.getParameterValues("id");
			int row = hospitalService.deleteAll(ids);
		}
	}
	
	

}
