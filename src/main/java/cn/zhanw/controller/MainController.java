package cn.zhanw.controller;

import cn.zhanw.entity.Result;
import cn.zhanw.entity.SysResource;
import cn.zhanw.service.SysResourceService;
import cn.zhanw.service.SysRoleService;
import cn.zhanw.utils.EncryptUtils;
import cn.zhanw.entity.SysUser;
import cn.zhanw.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("manager")
public class MainController {
    @Autowired
    SysUserService sysUserService;

    @Autowired
    SysRoleService sysRoleService;

    @Autowired
    SysResourceService sysResourceService;

    @RequestMapping("login")
    public Result getCode(@RequestBody Map<String, Object> params, HttpSession session) {
        SysUser sysUser = new SysUser();
        Result result = new Result();
        if (params.containsKey("code") && !StringUtils.isEmpty(params.get("code"))){
            if (params.get("code").equals(session.getAttribute("checkCode"))) {
                String username = (String) params.get("username");
                String password = (String) params.get("password");
                if (params.containsKey("username") && !StringUtils.isEmpty(username)
                        && params.containsKey("password") && !StringUtils.isEmpty(password)) {
                    sysUser.setUsername(username);
                    sysUser.setPassword(EncryptUtils.MD5_HEX(EncryptUtils.MD5_HEX(password) + username));
                    SysUser login = sysUserService.selectOne(sysUser);
                    if (login != null && !"".equals(login)) {//如果为null就说明登录失败
                        HashMap<String, Object> map = new HashMap<String, Object>();
                        List<SysResource> sysResources = sysResourceService.selectAllByUid(login.getId());
                        map.put("username", username);//放入姓名
                        map.put("id", login.getId());//放入ID
                        map.put("resources", sysResources);//放入个人权限
                        result.setObj(map);
                        result.setMsg("登陆成功");
                        result.setSuccess(true);
                        //将用户信息放入session  跟前台sessionStorage这个session没有他妈的任何关系
                        session.setAttribute("user", sysUser);
                        session.setAttribute("resources", sysResources);
                        return result;
                    }
                }
            }else {
                result.setSuccess(false);
                result.setMsg("验证码错误");
            }
        }
        return result;
    }
}
