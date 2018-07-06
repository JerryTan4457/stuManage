package com.yfkj.stumanage.controller;

import com.yfkj.stumanage.pojo.Classes;
import com.yfkj.stumanage.pojo.StudentExt;
import com.yfkj.stumanage.service.ClassesService;
import com.yfkj.stumanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * <p>Company: offcn</p>
 * @author zgf
 * @date 2017年5月22日
 * @version 1.0
 */
@Controller
@RequestMapping("/cla")
public class ClassesController {
	@Autowired
    ClassesService classesService;
	@Autowired
    StudentService studentService;

	 /*
     * 列表与分页Action
     */
    @RequestMapping("/list")
    public String list(Model model, @RequestParam(required=false,defaultValue="1") int pageNO){
        int size=3;
        model.addAttribute("size",size);
        model.addAttribute("pageNO",pageNO);
        model.addAttribute("count",classesService.getClassesCount());
        
        model.addAttribute("clalist", classesService.getClassPager(pageNO, size));
        return "template/employee/department/list";
//        return "class/list";
     }

    /*
     * 删除单个对象Action
     */
    @RequestMapping("/delete/{id}")
    public String delete(Model model, @PathVariable int id, @RequestParam(required=false,defaultValue="1") int pageNO, RedirectAttributes redirectAttributes){
        if(classesService.delete(id)>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/cla/list?pageNO="+pageNO;
//        return "template/employee/shixi/ac";
    }

    /*
     * 删除多个对象Action
     */
    @RequestMapping("/deletes")
    public String deletes(Model model,@RequestParam int[] id,@RequestParam(required=false,defaultValue="1") int pageNO,RedirectAttributes redirectAttributes){
        //执行删除
    	System.out.println("批量删除"+id.toString());
        int rows=classesService.deletes(id);
        if(rows>0)
        {
            redirectAttributes.addFlashAttribute("message", "删除"+rows+"行记录成功！");
        }else{
            redirectAttributes.addFlashAttribute("message", "删除失败！");
        }
        return "redirect:/cla/list?pageNO="+pageNO;
//        return "template/employee/shixi/ac";
    }

    /*
     * 添加学生
     */
    @RequestMapping("/add")
    public String add(Model model){
        model.addAttribute("entity", new Classes());
//        return "class/add";
//        return "template/employee/shixi/ac";
        return "template/employee/shixi/add";
    }

    /*
     * 添加保存
     */
    @RequestMapping("/addSave")
    public String addSave(Model model, @ModelAttribute("entity") @Valid Classes entity, BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
//             return "class/add";
            return "template/employee/shixi/add";

        }else{
        	classesService.insert(entity);
//             return "redirect:/cla/list";
            return "template/employee/shixi/list";

        }
    }


    /*
     * 编辑
     */
    @RequestMapping("/edit/{id}")
    public String edit(Model model,@PathVariable int id){
        model.addAttribute("entity", classesService.getCLassId(id));
        return "class/edit";
//        return "template/employee/shixi/ac";
    }

    /*
     * 编辑保存
     */
    @RequestMapping("/editSave")
    public String editSave(Model model,@ModelAttribute("entity") @Valid Classes entity,BindingResult bindingResult){
        //如果模型中存在错误
        if(bindingResult.hasErrors()){
        	 model.addAttribute("entity", entity);
             return "/class/edit";
//            return "template/employee/shixi/ac";

        }else{
        	classesService.update(entity);

//            return "redirect:list";
            return "template/employee/shixi/ac";
        }

    }

    @RequestMapping("search/{id}")
    public String search(@PathVariable int id,Model model) {
    	List<StudentExt> slist=studentService.getStuByCid(id);
    	model.addAttribute("slist", slist);
		return "class/stulist";
//        return "template/employee/shixi/ac";
	}



    @RequestMapping("search1/{id}")
    public String search1(@PathVariable int id,Model model) {
    	/*List<StudentExt> slist=studentService.getStuByCid(id);
    	model.addAttribute("slist", slist);*/
    	Classes classes=classesService.getStuByid(id);
    	model.addAttribute("classes", classes);
		return "class/stulist1";
//        return "template/employee/shixi/ac";
	}
    
}
