package com.qf.user.controller;

import com.qf.pojo.Course;
import com.qf.pojo.Subject;
import com.qf.pojo.Video;
import com.qf.user.service.CourseService;
import com.qf.user.service.SubjectService;
import com.qf.user.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/20 11:04
 */
@Controller
@RequestMapping("course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private VideoService videoService;

    @Autowired
    private SubjectService subjectService;


    @RequestMapping("course/{sId}")
    public String find(@PathVariable Integer sId , Model model){

        Subject subject = subjectService.findSubject(sId);

//        System.out.println("subject:"+subject);
        List<Course> courseList = courseService.findAll();
        subject.setCourseList(courseList);

//        System.out.println("courseList:"+courseList);
        for (Course course : courseList) {
            course.setVideoList(videoService.findAll());
        }
        System.out.println("subject"+subject);
        List<Subject> subjectList = subjectService.findAll();
        model.addAttribute("subject",subject);
        model.addAttribute("subjectList",subjectList);


        return "before/course.jsp";
    }
}
