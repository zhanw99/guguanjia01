package cn.zhanw.controller;

import cn.zhanw.entity.Result;
import cn.zhanw.entity.SysArea;
import cn.zhanw.service.SysAreaService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manager/area")
public class SysAreaController {

    @Autowired
    SysAreaService service;

    @RequestMapping("")
    public ModelAndView selectHtml(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/html/area/area.html");//记得加斜杠哦
        return modelAndView;
    }
    @RequestMapping("ztree")
    public List<SysArea> selectAll(){
        List<SysArea> sysAreas = service.selectAll();
        for (SysArea sysArea : sysAreas) {
            System.err.println(sysArea);
        }
        return sysAreas;
    }
    @RequestMapping("selectPage")
    public PageInfo<SysArea> selectPage(@RequestBody Map<String,Object> params){
        return  service.selectByPage(params);
    }

    @RequestMapping("toUpdate")
    public SysArea toUpdate(@RequestParam Long aid){
        System.out.println(aid);
        return service.selectByAid1(aid);
    }

//      导出Excel  下载
    @RequestMapping("exportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        //在response输出之前,设置输出的格式
        //默认不支持中文,new String(fname.getBytes(),"ISO-8859-1"),转义中文编码
        response.addHeader("Content-Disposition", "attachment;filename="+new String("area.xlsx".getBytes(),"ISO-8859-1"));
        //将文件写入到response的输出流
        service.getListOutputStream(response.getOutputStream());//写出
    }

    //导入数据 上传
    @RequestMapping("importExcel")
    public Result importExcel(@RequestParam("file") MultipartFile file) throws IOException {
        System.out.println("导入数据");
        int i = service.importExcel(file.getInputStream());
        Result result = new Result();
        if(i>0){
            result.setMsg("操作成功");
            result.setSuccess(true);
        }
        return result;
    }
    //模糊查询市
    @RequestMapping("selectByPageName")
    public PageInfo<SysArea> selectByPageName(@RequestBody Map<String, Object> params){
        return service.selectByPageName(params);
    }


}
