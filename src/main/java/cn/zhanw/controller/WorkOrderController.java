package cn.zhanw.controller;

import cn.zhanw.entity.Detail;
import cn.zhanw.entity.WorkOrder;
import cn.zhanw.service.DetailService;
import cn.zhanw.service.WorkOrderService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("manager/admin/work")
public class WorkOrderController {
    @Autowired
    WorkOrderService service;

    @Autowired
    DetailService detailService;

    @RequestMapping("")
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/work/admin/work.html");//记得加斜杠哦
        return modelAndView;
    }
    @RequestMapping("work")
    public PageInfo<WorkOrder> slelectPageInfo(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        System.out.println(pageNum+"-----"+pageSize);
        return service.selectPageInfo(pageNum, pageSize);
    }

//    @RequestMapping("selectId")
//    public List<Detail> slelectId(Integer id) {
//        System.out.println(id+"-----");
//        return detailService.selectMax(id);
//    }
    @RequestMapping("selectId")
    public String slelectId(Integer id) {
        System.out.println(id+"-----");
        return "success";
    }
}
