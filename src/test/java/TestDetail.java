import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Detail;
import cn.zhanw.entity.Examine;
import cn.zhanw.mapper.DetailMapper;
import cn.zhanw.mapper.ExamineMapper;
import cn.zhanw.service.DetailService;
import cn.zhanw.service.ExamineService;
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
public class TestDetail {
    @Autowired
    DetailMapper mapper;

    @Autowired
    DetailService service;


    //测试mapper
    @Test
    public void PageMapper(){
        List<Detail> details = mapper.selectMax(12,"废药品");
        for (Detail detail : details) {
            System.out.println(detail);
        }

    }
    //测试service
    @Test
    public void PageService(){
        List<Detail> details = service.selectMax(12,"废药品");
        for (Detail detail : details) {
            System.out.println(detail);
        }
    }

    @Test
    public void MapDemo(){
        Map map = new HashMap();
        map.put("aaa","123");
        System.out.println(map.containsKey("aaa"));
        System.out.println(map.get("aaa"));
    }

}
