package com.xiaocai.processdemo2.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: xiaocai
 * @time: 2022/10/14 9:32
 */
@Controller
public class JspController {

    @GetMapping("jsp")
    public String jsp(Model model) {
        model.addAttribute("age",18);

        System.out.println("jsp ok");
        return "hello";
    }

    @GetMapping("index")
    public String index(Model model) {
        model.addAttribute("age",18);
        System.out.println("jsp ok");
        return "index";
    }

    @RequestMapping("/showEmp")
    public ModelAndView showEmp(){
        ModelAndView mav=new ModelAndView("/show");
        List list=new ArrayList<Emp>();

        for (int i = 0; i < 3; i++) {
            Emp emp=new Emp();
            emp.setEmpId(String.valueOf((int)(Math.random())*10));
            emp.setEmpName("haha"+String.valueOf((int)(Math.random()*10)));
            emp.setPassword("haha"+String.valueOf((int)(Math.random()*10)));
            list.add(emp);
        }
        mav.addObject("list",list);
        return mav;

    }

    @GetMapping("jspLifeCycle")
    public String jspLifeCycle(Model model) {
        return "jspLifeCycle";
    }

    @GetMapping("中文名称")
    public String 中文名称(Model model) {
        return "中文名称";
    }

    @GetMapping("基本语法")
    public String 基本语法(Model model) {
        return "jspGrammer/基本语法";
    }
}
