package cn.zhanw.mapper;

import cn.zhanw.entity.SysResource;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SysResourceMapper extends Mapper<SysResource> {

    @Select("SELECT " +
            " se.*  " +
            "FROM " +
            " sys_role sr, " +
            " sys_role_resource srr, " +
            " sys_resource se  " +
            "WHERE " +
            " sr.id = #{rid} and sr.id=srr.role_id and se.id=srr.resource_id")
    List<SysResource> selectByRid(long rid);
}