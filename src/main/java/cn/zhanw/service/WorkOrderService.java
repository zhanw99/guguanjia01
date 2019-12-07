package cn.zhanw.service;

import cn.zhanw.entity.WorkOrder;
import com.github.pagehelper.PageInfo;

public interface WorkOrderService extends IService<WorkOrder> {
    PageInfo<WorkOrder> selectPageInfo(Integer pageNum, Integer pageSize);
}
