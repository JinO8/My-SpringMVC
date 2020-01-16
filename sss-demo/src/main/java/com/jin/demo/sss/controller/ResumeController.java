package com.jin.demo.sss.controller;

import com.jin.demo.sss.pojo.Resume;
import com.jin.demo.sss.pojo.User;
import com.jin.demo.sss.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author wangjin
 */
@Controller
public class ResumeController {

    @Autowired
    private ResumeService resumeService;

    @RequestMapping("/resume/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String username, String password){
        ModelAndView modelAndView = new ModelAndView();
        if ("admin".equals(username)&&"admin".equals(password)) {
            modelAndView.setViewName("redirect:/getAll");
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            request.getSession().setAttribute("user",user);
        }else {
            modelAndView.setViewName("/index.html");
        }
        return modelAndView;
    }

    @RequestMapping("/getAll")
    public ModelAndView getAll(){
        ModelAndView modelAndView = new ModelAndView();
        List<Resume> resumes = resumeService.getAll();
        modelAndView.addObject(resumes);
        modelAndView.setViewName("/jsp/view.jsp");
        return modelAndView;
    }
    @RequestMapping("/add")
    public ModelAndView add(String name,String address,String phone){
        ModelAndView modelAndView = new ModelAndView();
        Resume resume = new Resume();
        resume.setName(name);
        resume.setAddress(address);
        resume.setPhone(phone);
        resumeService.add(resume);
        modelAndView.setViewName("redirect:/getAll");
        return modelAndView;
    }
    @RequestMapping("/update")
    public ModelAndView update(Long id,String name,String address,String phone){
        ModelAndView modelAndView = new ModelAndView();
        Resume resume = new Resume();
        resume.setId(id);
        resume.setName(name);
        resume.setAddress(address);
        resume.setPhone(phone);
        resumeService.update(resume);
        modelAndView.setViewName("redirect:/getAll");
        return modelAndView;
    }

    @RequestMapping("/premodify")
    public ModelAndView premodify(Long id){
        Resume resume = resumeService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(resume);
        modelAndView.setViewName("/jsp/modify.jsp");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public ModelAndView delete(Long id){
        ModelAndView modelAndView = new ModelAndView();
        Resume resume = new Resume();
        resume.setId(id);
        resumeService.delete(resume);
        modelAndView.setViewName("redirect:/getAll");
        return modelAndView;
    }
}
