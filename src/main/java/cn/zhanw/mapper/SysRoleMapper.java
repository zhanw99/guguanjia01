package cn.zhanw.mapper;

import cn.zhanw.entity.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysRoleMapper extends Mapper<SysRole> {

    @SelectProvider(value = SysRoleSqlProvider.class, method = "selectByAndAll")
    public List<SysRole> selectByAndAll(Map<String, Object> params);

    @Select("select sr.data_scope " +
            " FROM " +
            " sys_role sr " +
            " WHERE " +
            " sr.del_flag=0")
    public List<String> selectByDataScope();

    /**
     * 角色管理的归属机构
     */
    @Select("SELECT so.`name`" +
            " FROM  " +
            "sys_role sr " +
            "LEFT JOIN  " +
            "sys_office so " +
            "on " +
            "sr.office_id =so.id")
    public List<String> officeName();
}