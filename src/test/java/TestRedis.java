import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.SysArea;
import cn.zhanw.listener.SysAreaListener;
import cn.zhanw.mapper.SysAreaMapper;
import cn.zhanw.service.SysAreaService;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestRedis {
    @Autowired
    SysAreaService service;

    @Autowired
    SysAreaMapper mapper;

    /*@Cacheable(key = "'SysAreaServiceImpl:selectAll'",value = "sysAreaCache")*/
    @Test
    public void selectAll(){
        List<SysArea> sysAreas = service.selectAll();
        System.out.println(sysAreas);
        List<SysArea> sysAreas2 = service.selectAll();
        System.out.println(sysAreas2);
    }

    @Cacheable(key = "'SysAreaServiceImpl:selectByAid'",value = "sysAreaCache")
    @Test
    public void selectOne(){
        SysArea sysArea = service.selectByAid1(1l);
        System.out.println(sysArea.toString());
        SysArea sysArea2 = service.selectByAid1(1l);
        System.out.println(sysArea2.toString());
    }


}
