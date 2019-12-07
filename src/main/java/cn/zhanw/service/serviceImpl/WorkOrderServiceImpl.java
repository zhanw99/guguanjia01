package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.WorkOrder;
import cn.zhanw.mapper.WorkOrderMapper;
import cn.zhanw.service.WorkOrderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WorkOrderServiceImpl extends IServiceImpl<WorkOrder> implements WorkOrderService {
    @Autowired
    WorkOrderMapper Mapper;

    @Override
    public PageInfo<WorkOrder> selectPageInfo(Integer pageNum, Integer pageSize){
        PageHelper.startPage(pageNum, pageSize);//开启分页拦截功能
        List<WorkOrder> workOrders = mapper.selectAll();
        PageInfo<WorkOrder> pageInfo = new PageInfo(workOrders);
        return pageInfo;
    };
}
