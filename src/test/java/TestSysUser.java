import cn.zhanw.utils.EncryptUtils;
import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.SysUser;
import cn.zhanw.mapper.SysUserMapper;
import cn.zhanw.service.SysUserService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestSysUser {
    @Autowired
    SysUserMapper mapper;

    @Autowired
    SysUserService service;

    @Test
    public void selectByCondtion(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("uid",26);
        map.put("rid",1);
        map.put("oid",47);
        map.put("name","吉");
        List<SysUser> sysUsers = mapper.selectByCondtion(map);
        for (SysUser sysUser : sysUsers) {
            System.out.println(sysUser);
        }
    }

    @Test
    public void selectByCondtionService(){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("pageNum",1);
        map.put("pageSize",5);
        PageInfo<SysUser> sysUserPageInfo = service.selectPage(map);
        int size = sysUserPageInfo.getSize();
        System.out.println(size);
    }
    @Test
    public void Demo(){
        String admin = EncryptUtils.MD5_HEX(EncryptUtils.MD5_HEX("admin") + "admin");
        System.out.println(admin);
    }
    @Test
    public void selectByRidMapper(){
        SysUser sysUser = mapper.selectByRid(2l);
        System.out.println(sysUser);
    }


}
