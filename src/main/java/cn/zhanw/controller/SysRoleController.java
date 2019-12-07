package cn.zhanw.controller;

import cn.zhanw.entity.SysRole;
import cn.zhanw.service.SysRoleService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("manager/role")
public class SysRoleController {
    @Autowired
    SysRoleService service;

    @RequestMapping("")
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/role/role.html");//记得加斜杠哦
        return modelAndView;
    }

    @RequestMapping("role")
    @ResponseBody
    public PageInfo<SysRole> selectBy(@RequestBody Map<String,Object> parms){
        PageInfo<SysRole> pageInfo = service.selectByAndAll(parms);
        return pageInfo;
    }

    /**
     * 查询全部数据范围，返回树
     * @return
     */
    @RequestMapping("dataScope")
    @ResponseBody
    public List<String> selectByDataScope(){
        return service.selectByDataScope();
    }

    @RequestMapping("updataById")
    @ResponseBody
    public String updataById(@RequestParam long parms){
        System.out.println(parms);
        return "ressouc";
    }

    /**
     * 角色管理页面的归属机构
     * @return
     */
    @RequestMapping("officeName")
    @ResponseBody
    public  Map<Integer,String> officeName(){
        List<String> strings = service.officeName();
        Map map= new HashMap<String,String>();
        for (int i = 0; i < strings.size(); i++) {
            map.put(i,strings.get(i));
        }
//         List list = new ArrayList();
//        list.add(JSON.toJSON(map));
        return map;
    }
}
