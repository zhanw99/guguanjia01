import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.SysRole;
import cn.zhanw.mapper.SysRoleMapper;
import cn.zhanw.service.SysRoleService;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestSysRole {
    @Autowired
    SysRoleMapper mapper;

    @Autowired
    SysRoleService service;

    @Test
    public void selectByAndAllMapper(){
        Map<String,Object> map =new HashMap<String, Object>();
//        map.put("dataScope",1);
//        map.put("oid",56);
//        map.put("name","超级管理员");
        List<SysRole> sysRoles = mapper.selectByAndAll(map);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }
    @Test
    public void selectByService(){
        Map<String,Object> map =new HashMap<String, Object>();
//        map.put("pageNum",1);
//        map.put("pageSize",10);
//        map.put("dataScope",1);
//        map.put("remarks",1);
//        map.put("oid",56);
//        map.put("name","超级管理员");
        PageInfo<SysRole> pageInfo = service.selectByAndAll(map);
        System.out.println(pageInfo.getSize());
    }
    @Test
    public void selectByDataScopeMapper(){
        List<String> list = mapper.selectByDataScope();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
    @Test
    public void selectByDataScopeService(){
        List<String> list = service.selectByDataScope();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }


    /**
     * 角色管理的归属机构
     */
    @Test
    public void selectOfficeNameMapper(){
        List<String> strings = mapper.officeName();
        Map map= new HashMap<String,String>();
        for (int i = 0; i < strings.size(); i++) {
            map.put(i,strings.get(i));
        }
        Object o = JSON.toJSON(map);
        System.out.println(o);


    }



}