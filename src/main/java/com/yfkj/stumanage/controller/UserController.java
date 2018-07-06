package com.yfkj.stumanage.controller;

import com.yfkj.stumanage.pojo.Student;
import com.yfkj.stumanage.pojo.Teacher;
import com.yfkj.stumanage.pojo.User;
import com.yfkj.stumanage.service.StudentService;
import com.yfkj.stumanage.service.TeacherService;
import com.yfkj.stumanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class UserController {

	@Autowired
	UserService userService;

	@Autowired
	StudentService studentService;

	@Autowired
	TeacherService teacherService;

	@RequestMapping("/login")
	public String login(User user, Model model, HttpServletRequest req) {
		HttpSession session=req.getSession();
		int usertype=-1;
		if(user!=null){
		  usertype=user.getUsertype();
		  if(usertype==1){
			  //管理员
			 User loginuser= userService.userlogin(user);
			 if(loginuser!=null){
				 session.setAttribute("user", loginuser);
//				 return "homepage/index";
				 return "template/employee/shixi/ac";
			 }else{
				 model.addAttribute("msg", "请输入正确的用户名和密码");
//				 return "/index";

				 return "template/employee/shixi/ac";
			 }
		  }else if(usertype==2){
			  //学生
			  Student student=new Student();
			  student.setLoginname(user.getName());
			  student.setPassword(user.getPassword());
			  Student loginstu=studentService.stulogin(student);
			  if(loginstu!=null){
				  session.setAttribute("user", loginstu);
//				  return "homepage/index";
				  return "template/employee/shixi/ac";
			  }else{
				  model.addAttribute("msg", "请输入正确的用户名和密码");
//				  return "/index";
				  return "template/employee/shixi/ac";
			  }

		  }else{
			 //老师
			  Teacher tea=new Teacher();
			  tea.setLoginname(user.getName());
			  tea.setPassword(user.getPassword());
			  Teacher logintea=teacherService.loginTea(tea);
			  if(logintea!=null){
				  session.setAttribute("user", logintea);
//				  return "homepage/index";
				  return "template/employee/shixi/ac";
			  }else{
				  model.addAttribute("msg", "请输入正确的用户名和密码");
//				  return "/index";
				  return "template/employee/shixi/ac";
			  }
		  }

		}
//		return "homepage/index";
        return "template/employee/ac";
	}

}
