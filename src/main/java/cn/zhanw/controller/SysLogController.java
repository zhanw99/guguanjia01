package cn.zhanw.controller;

import cn.zhanw.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("manager/syslog")
public class SysLogController {

    @Autowired
    SysLogService service;

    @RequestMapping("")
//    @ResponseBody
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
         modelAndView.setViewName("/html/log/log.html");
        return modelAndView;
    }

}
