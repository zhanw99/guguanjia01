package cn.zhanw.controller;

import cn.zhanw.entity.AppVersion;
import cn.zhanw.service.AppVersionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("manager/app/index")
public class AppVersionController {
    @Autowired
    AppVersionService appVersionService;

    @RequestMapping("")
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/app/index.html");//记得加斜杠哦
        return modelAndView;
    }


    @RequestMapping("index")
    @ResponseBody
    public PageInfo<AppVersion> selectAll(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {

        return appVersionService.selectAll(pageNum, pageSize);
    }

    @RequestMapping("doDelete")
    @ResponseBody
    public int doDelete(Long id) {
        System.out.println("非 物理删除" + id);
        AppVersion appVersion = new AppVersion();
        appVersion.setId(id);
        appVersion.setDelFlag("1");
        return appVersionService.updateByPrimaryKeySelective(appVersion);
    }

    @RequestMapping("toUpdate")
    @ResponseBody
    public AppVersion toUpdate(Long id) {
        System.out.println("更新" + id);
        return appVersionService.selectByPrimaryKey(id);
    }


    @RequestMapping("update")
    @ResponseBody
    public int update(@RequestBody AppVersion appVersion) {
        System.err.println(appVersion);
        return appVersionService.updateByPrimaryKeySelective(appVersion);
    }


}
