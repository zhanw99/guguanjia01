package cn.zhanw.controller;

import cn.zhanw.entity.Qualification;
import cn.zhanw.mapper.QualificationMapper;
import cn.zhanw.service.QualificationService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

//替代Controller   自动添加@ResponseBody转换
@RestController
@RequestMapping("manager/qualification/index")
public class QualifucationController {
    @Autowired
    QualificationMapper mapper;

    @Autowired
    QualificationService qualificationService;

    @Value("${imgPath}")
    String imgPath;

    @RequestMapping("")
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/qualification/index.html");//记得加斜杠哦
        return modelAndView;
    }

    @RequestMapping("index")
    @ResponseBody
    public PageInfo<Qualification>  selectAll(@RequestParam(defaultValue = "1")Integer pageNum,@RequestParam(defaultValue = "5") Integer pageSize){
        System.out.println("查询全部"+pageNum+"--"+pageSize);
        return qualificationService.selectAll(pageNum, pageSize);
    }
    @RequestMapping("example")
    @ResponseBody
    public PageInfo<Qualification>  selectExample(@RequestBody Map<String,Object> params){
        //pageNum: 1, pageSize: 5, type: "2", check: "2", startDate: "", endDate: ""
        return qualificationService.selectByCondition(params);
    }
    @RequestMapping("toUpdate")
    @ResponseBody
    public Qualification toUpdate(@RequestParam Integer id){
        Qualification qualification = qualificationService.selectByPrimaryKey(id);
        //imgPath\0B0DF1F02F804F048A623804EFB88721.png
        qualification.setAddress(imgPath+ File.separator+qualification.getAddress());
        System.err.println(qualification.getAddress());
        return qualification;
    }
    @RequestMapping("update1")
    @ResponseBody
    public int update1(@RequestParam Long id){
        System.out.println(id);
        Qualification qualification = new Qualification();
        qualification.setId(id);
        qualification.setCheck(1);
        //<!--0未审核            1通过审核            2审核失败-->
        return qualificationService.updateByPrimaryKeySelective(qualification);
    }
    @RequestMapping("update2")
    @ResponseBody
    public int update2(@RequestParam Long id){
        System.out.println(id);
        Qualification qualification = new Qualification();
        qualification.setId(id);
        qualification.setCheck(2);
        //<!--0未审核            1通过审核            2审核失败-->
        return qualificationService.updateByPrimaryKeySelective(qualification);
    }


}
