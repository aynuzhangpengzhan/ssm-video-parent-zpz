package com.qf.user.controller;

import com.qf.pojo.Subject;
import com.qf.user.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 10:23
 */
@Controller
@RequestMapping("subject")
public class SubjectController {
    @Autowired
    private SubjectService subjectService;
    @RequestMapping("selectAll")
    public String findAll(Model model){
        List<Subject> subjectList =  subjectService.findAll();
       model.addAttribute("subjectList",subjectList);
       return "before/index.jsp";
       
    }

}
