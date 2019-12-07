package cn.zhanw.controller;

import cn.zhanw.entity.Examine;
import cn.zhanw.service.ExamineService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController//免写@responseBody
@RequestMapping("manager/examine/index")
public class ExamineController {
    @Autowired
    ExamineService service;

    @RequestMapping("")
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/examine/index.html");//记得加斜杠哦
        return modelAndView;
    }

    @RequestMapping("index")
    public PageInfo<Examine>  selectAll(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        System.out.println("查询全部"+pageNum+"--"+pageSize);
        return service.selectAll(pageNum, pageSize);
    }

}
