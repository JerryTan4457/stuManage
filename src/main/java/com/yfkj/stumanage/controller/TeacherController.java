package com.yfkj.stumanage.controller;

import com.yfkj.stumanage.pojo.Grade;
import com.yfkj.stumanage.pojo.StudentView;
import com.yfkj.stumanage.pojo.Teacher;
import com.yfkj.stumanage.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
@Controller
@RequestMapping("/tea")
public class TeacherController {
	@Autowired
    TeacherService teacherService;

	 /*
     * 学生列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model,@RequestParam(required=false,defaultValue="1") int pageNO){
        int size=3;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",teacherService.getTeacherCount());

        model.addAttribute("tealist", teacherService.getTeacherPager(pageNO, size));
//        return "teacher/list";
        return "template/employee/ac";
     }


    /*
     * 删除单个学生对象Action
     */
    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable int id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        if(teacherService.delete(id)>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
//        return "redirect:/tea/list?pageNO="+pageNO;
        return "template/employee/shixi/ac";
    }

    /*
     * 删除多个学生对象Action
     */
    @RequestMapping("/deletes")
    public String deletes(Model model,@RequestParam int[] id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        //执行删除
    	System.out.println("批量删除"+id.toString());
        int rows=teacherService.deletes(id);
        if(rows>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除"+rows+"行记录成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
//        return "redirect:/tea/list?pageNO="+pageNO;
        return "template/employee/shixi/ac";
    }

    /*
     * 添加
     */
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("entity", new Teacher());
//        return "teacher/add";
        return "template/employee/shixi/ac";
    }

    /*
     * 添加保存
     */
    @RequestMapping("/addSave")
    public String addSave(Model model, @ModelAttribute("entity") @Valid Teacher entity, BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
//             return "teacher/add";
            return "template/employee/shixi/ac";

        }else{
        	entity.setPassword("aaaaaa");
        	teacherService.insert(entity);
//             return "redirect:/tea/list";
            return "template/employee/shixi/ac";
        }
    }


    /*
     * 编辑
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable int id){
        model.addAttribute("entity", teacherService.getTeacherId(id));
//        return "teacher/edit";
        return "template/employee/shixi/ac";
    }

    /*
     * 保存
     */
    @RequestMapping("/editSave")
    public String editSave(Model model,@ModelAttribute("entity") @Valid Teacher entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
//             return "/teacher/edit";
            return "template/employee/shixi/ac";

        }else{
        	//entity.setPassword("aaaaaa");
        	teacherService.update(entity);
//            return "redirect:list";
            return "template/employee/shixi/ac";
        }

    }

    @RequestMapping("getMyStu")
    public String getMyStu(Model model,HttpServletRequest req){
    	HttpSession session=req.getSession();
    	Teacher teacher=(Teacher) session.getAttribute("user");
        List<StudentView> slist=teacherService.getMystus(teacher.getId());
        model.addAttribute("stulist", slist);
//    	return "teacher/couOftea/stulist";
        return "template/employee/shixi/ac";
    }

    //
    @RequestMapping("setGrades/{sid}/{sname}/{cid}")
    public String setGrades(Model model,@PathVariable int sid,@PathVariable String sname,@PathVariable int cid){
    	Grade grade=new Grade();
    	grade.setSid(sid);
    	grade.setCid(cid);
    	model.addAttribute("entity", grade);
    	model.addAttribute("sname", sname);
//    	return "teacher/couOftea/setgrade";
        return "template/employee/shixi/ac";
    }

    @RequestMapping("/saveGrade")
    public String setGrades(Model model, Grade entity, HttpServletRequest req, RedirectAttributes redirectAttributes){
    	HttpSession session=req.getSession();
    	Teacher teacher=(Teacher) session.getAttribute("user");
    	entity.setZgrade(entity.getPgrade()+entity.getKgrade());
    	entity.setTid(teacher.getId());
    	int rows=teacherService.insertGrade(entity);
    	if(rows>0){
    		redirectAttributes.addFlashAttribute("msg", "录入成功！");
    	}else{
    		redirectAttributes.addFlashAttribute("msg", "录入失败！");
    	}
//    	return "redirect:getMyStu";
        return "template/employee/shixi/ac";
    }



}
