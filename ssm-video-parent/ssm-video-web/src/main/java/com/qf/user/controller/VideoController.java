package com.qf.user.controller;

import com.qf.pojo.Course;
import com.qf.pojo.Subject;
import com.qf.pojo.Video;
import com.qf.user.service.CourseService;
import com.qf.user.service.SpeakerService;
import com.qf.user.service.SubjectService;
import com.qf.user.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: bug修复员
 * @Date: 2020/10/22 15:01
 */
@Controller
@RequestMapping("video")
public class VideoController {
    @Autowired
    private VideoService videoService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private SpeakerService speakerService;

    @RequestMapping("showVideo")
    public String showVideo(String videoId, String subjectName, Model model){
        Video video = videoService.findVideoById(videoId);
        video.setSpeaker(speakerService.findById(video.getSpeakerId()));
        List<Subject> subjectList = subjectService.findAll();
        Course course =  courseService.findByid(video.getCourseId());
        List<Video> videoList = videoService.findByCourseId(video.getCourseId());
        course.setVideoList(videoList);
        model.addAttribute("video",video);
        model.addAttribute("subjectList",subjectList);
        model.addAttribute("course",course);
        model.addAttribute("subjectName",subjectName);

        return "before/section.jsp";
    }

}
