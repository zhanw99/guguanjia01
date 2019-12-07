import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Examine;
import cn.zhanw.mapper.ExamineMapper;
import cn.zhanw.service.ExamineService;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestExamine {
    @Autowired
    ExamineMapper examineMapper;

    @Autowired
    ExamineService service;


    //测试mapper
    @Test
    public void PageMapper(){
        List<Examine> examines = examineMapper.selectAll();
        for (Examine examine : examines) {
            System.out.println(examine);
        }
    }
    //测试service
    @Test
    public void PageService(){
        service.selectAll(1,5);
    }

}
