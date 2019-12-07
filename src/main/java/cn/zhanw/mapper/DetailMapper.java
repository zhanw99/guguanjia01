package cn.zhanw.mapper;

import cn.zhanw.entity.Detail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface DetailMapper extends Mapper<Detail> {
    @Select("select wo.id, de.component,de.weight,de.morphological,de.packaging,de.plate_number,na.`name` medicine,co.`CODE` model,cc.`code` number,tr.content,tr.update_date,su.phone,su.mobile FROM  " +
            "detail de " +
            "left JOIN " +
            "waste_type na " +
            "on " +
            "de.waste_type_id =na.id " +
            "LEFT JOIN " +
            "waste_type co " +
            "on " +
            "de.waste_type_id =co.id " +
            "LEFT JOIN " +
            "waste cc " +
            "on " +
            "de.waste_id=cc.id " +
            "left JOIN " +
            "work_order wo " +
            "on " +
            "de.work_order_id= wo.id " +
            "left JOIN " +
            "transfer tr " +
            "ON " +
            "tr.work_order_id=wo.id " +
            "LEFT JOIN " +
            "sys_user su " +
            "ON " +
            "tr.oprate_user_id= su.id " +
            " " +
            "where  " +
            "wo.id=#{id} " +
            "AND " +
            "de.component=#{component} " +
            " " +
            "order by " +
            "tr.update_date desc")
    List<Detail> selectMax(@Param(value = "id") Integer id,@Param(value = "component") String component);
}