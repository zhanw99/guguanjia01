package cn.zhanw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("manager/office")
public class OfficeController {

    @RequestMapping("")
    @ResponseBody
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/office/office.html");//记得加斜杠哦
        return modelAndView;
    }
}
