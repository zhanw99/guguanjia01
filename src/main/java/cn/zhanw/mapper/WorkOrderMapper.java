package cn.zhanw.mapper;

import cn.zhanw.entity.WorkOrder;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface WorkOrderMapper extends Mapper<WorkOrder> {
    @Select("select wo.* ,cu.name createName,tu.name transportName,ru.name recipientName,co.name createOfficeName  " +
            " from  " +
            " work_order wo  " +
            " left join  " +
            " sys_user cu  " +
            " on  " +
            " wo.create_user_id=cu.id    " +
            " left join  " +
            " sys_user tu         " +
            " on  " +
            " wo.transport_user_id=tu.id  " +
            " left join  " +
            " sys_user ru  " +
            "  on  " +
            " wo.recipient_user_id=ru.id  " +
            " left join  " +
            " sys_office co  " +
            " on  " +
            " cu.office_id=co.id  " +
            "  where  " +
            " wo.del_flag=0 ")
    List<WorkOrder> selectAll();
}