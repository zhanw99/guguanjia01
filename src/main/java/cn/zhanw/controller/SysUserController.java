package cn.zhanw.controller;

import cn.zhanw.entity.SysUser;
import cn.zhanw.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
@RequestMapping("manager/sysuser")
public class SysUserController {
    @Autowired
    SysUserService sysUserService;

    @RequestMapping("")
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/user/user-list.html");//记得加斜杠哦
        return modelAndView;
    }

    @RequestMapping("user")
    public PageInfo<SysUser> selePage(@RequestBody Map map){
       return sysUserService.selectPage(map);
    }
}
