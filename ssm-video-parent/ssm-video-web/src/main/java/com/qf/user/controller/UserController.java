package com.qf.user.controller;

import com.qf.pojo.User;
import com.qf.user.service.UserService;
import com.qf.videos.utils.MailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    static String variablecode;
    @RequestMapping("loginUser")
    @ResponseBody
    public String login(String email, String password, HttpSession session){
//        System.out.println("111111111");
        User user = userService.findUser(email,password);
//        System.out.println(user);
      //  System.out.println("user"+user);
        if(null != user){
            session.setAttribute("user",user);
            session.setMaxInactiveInterval(60*60*24);
            return "success";
        }else {
            return "1111";
        }
    }
//    @RequestMapping("insertUser.action")
//    @ResponseBody
//    public String insertUser(User user){
//        System.out.println("11111");
//        userService.insertUser(user);
//        String data = "success";
//        return "data";
//    }

    @RequestMapping("insertUser")
    @ResponseBody
    public String insertUser(User user,HttpSession session){
        System.out.println("2222222222222");
        userService.insertUser(user);
        session.setAttribute("user",user);
        System.out.println("55555");
        return "success";
    }

    @RequestMapping("validateEmail")
    @ResponseBody
    public String validateEmail(String email) {
        User user = userService.findUserByEmail(email);
            String flag = "success";
            if (user!=null) {
                System.out.println("1111111111");
                return flag;
            }else {
                return flag;
            }

    }

    @RequestMapping("validateEmailCode")
    public String validateEmailCode(String email,String code){
        if(variablecode.equals(code)){
            return "before/reset_password.jsp";
        }else {
            return "before/forget_password.jsp";
        }

    }
    @RequestMapping("forgetPassword")
    public String forgetPassword(){

        return "before/forget_password.jsp";
    }
    @RequestMapping("sendEmail")
    @ResponseBody
    public String sendEmail(String email){
        User user = userService.findUserByEmail(email);
        System.out.println(email);
        String flag = "hasNoUser";

        if(null!=user){

           variablecode = MailUtils.getValidateCode(6);
            MailUtils.sendMail(email,"11","11"+variablecode);
            flag =  "success";
        }
        return flag;

    }


    @RequestMapping("showMyProfile")
    public String Change(HttpSession session){

       User user1 =  (User) session.getAttribute("user");
       User user = userService.findUserByEmail(user1.getEmail());
      // System.out.println("email:"+user.getEmail());
      // System.out.println("user:"+user);
       session.setAttribute("user",user);
       return "before/my_profile.jsp";
    }
    @RequestMapping("changeProfile")
    public String ChangeProfile(HttpSession session){
        User user1 = (User)session.getAttribute("user");
        User user = userService.findUserByEmail(user1.getEmail());
       // System.out.println("email:"+user.getEmail());
       // System.out.println("user:"+user);
        session.setAttribute("user",user);


        return "before/change_profile.jsp";

    }

    @RequestMapping("updateUser")
    public String UpdateUser(User user1,HttpSession session){
        System.out.println("user:"+user1);
         userService.updateUser(user1);
//        System.out.println("user:"+user);
//        session.setAttribute("user",user);

        return "redirect:/user/showMyProfile";

    }
    @RequestMapping("changeAvatar")
    public String ChangeAvatar(HttpSession session){
        User user1 = (User)session.getAttribute("user");
        User user = userService.findUserByEmail(user1.getEmail());

        session.setAttribute("user",user);
        return "before/change_avatar.jsp";
    }
    @RequestMapping("upLoadImage")
    public String UpLoadImage(MultipartFile image_file, HttpSession session){
        //上传地址
        String path = "D:\\study\\software\\websoftware\\apache-tomcat-7.0.103\\webapps\\upload\\";
        //上传的文件名
        String photoFileName = image_file.getOriginalFilename();
        System.out.println("上传的文件名：" + photoFileName);
//        //预防上传文件的文件名重复
//        String uuid = UUID.randomUUID().toString().replace("-", "");
//        String uploadFileName = uuid + photoFileName;

        //上传文件
        File file = new File(path + photoFileName);
        //上传方法
        try {
            image_file.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        User user = (User) session.getAttribute("user");
        //设置属性
        user.setImgUrl(photoFileName);
        userService.updateUser(user);
        session.setAttribute("user",user);

        return "before/my_profile.jsp";
    }




    @RequestMapping("passwordSafe")
    public String PasswordSafe(HttpSession session){
        User user1 = (User)session.getAttribute("user");
        User user = userService.findUserByEmail(user1.getEmail());
        // System.out.println("email:"+user.getEmail());
        // System.out.println("user:"+user);
        session.setAttribute("user",user);
        return "before/password_safe.jsp";
    }
    @RequestMapping("validatePassword")
    @ResponseBody
    public String validatePassword(HttpSession session,String password){
        System.out.println("1111111111111111111111111111");
        User user = (User)session.getAttribute("user");
        User user1 = userService.findUser(user.getEmail(),password);
        System.out.println(user1);
        if(null!=user1){
            session.setAttribute("user1",user1);
        return "success";
        }else {
            return "111";
        }
    }




    @RequestMapping("updatePassword")
    public String updatePassword(String newPassword, HttpSession session){
      User user1 = (User)session.getAttribute("user");
//        System.out.println("newPassword:");
       user1.setPassword(newPassword);
//        System.out.println("user:"+user.getPassword());
      userService.updateUser(user1);
        return "before/my_profile.jsp";
    }
    @RequestMapping("loginOut")
    public String loginOut(HttpSession session){

        session.invalidate();
        return "before/my_profile.jsp";
    }

    @RequestMapping("loginOut2")
    public String loginOut2(){


        return "redirect:/subject/selectAll";
    }


}
