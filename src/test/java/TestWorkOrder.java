import cn.zhanw.config.SpringMybatisConfig;
import cn.zhanw.entity.Examine;
import cn.zhanw.entity.WorkOrder;
import cn.zhanw.mapper.ExamineMapper;
import cn.zhanw.mapper.WorkOrderMapper;
import cn.zhanw.service.ExamineService;
import cn.zhanw.service.WorkOrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringMybatisConfig.class)
public class TestWorkOrder {
    @Autowired
    WorkOrderMapper examineMapper;

    @Autowired
    WorkOrderService service;


    //测试mapper
    @Test
    public void PageMapper(){
        List<WorkOrder> workOrders = examineMapper.selectAll();
        for (WorkOrder workOrder : workOrders) {
            System.out.println(workOrder);
        }
    }
//    测试service
    @Test
    public void PageService(){
        service.selectPageInfo(1,5);
    }

}
