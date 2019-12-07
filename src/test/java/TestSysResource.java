import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.SysResource;
import cn.zhanw.mapper.SysResourceMapper;
import cn.zhanw.service.SysResourceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestSysResource {
    @Autowired
    SysResourceMapper mapper;

    @Autowired
    SysResourceService service;

    @Test
    public void selectByRidMapper(){
        List<SysResource> sysResources = mapper.selectByRid(1l);
        for (SysResource sysResource : sysResources) {

            System.out.println(sysResource);
        }
        System.out.println(sysResources.size());
    }

    @Test
    public void selectByRidService(){
        List<SysResource> sysResources = service.selectAllByUid(2l);
        for (SysResource sysResource : sysResources) {

            System.out.println(sysResource);
        }
        System.out.println(sysResources.size());
    }
    @Test
    public void selectAllService(){
        List<SysResource> sysResources = service.selectAll();
        for (SysResource sysResource : sysResources) {
            System.out.println(sysResource.getUrl());
        }
    }
}
