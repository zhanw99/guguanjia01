package cn.zhanw.mapper;

import cn.zhanw.entity.SysUser;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface SysUserMapper extends Mapper<SysUser> {

    @SelectProvider(type = SysUserSqlProvider.class,method = "selectByCondtion")
    public List<SysUser> selectByCondtion(Map<String,Object> parms);

    @Select("  select    " +
   "  sr.*   " +
   "   from   " +
   "  sys_user su   " +
   "   LEFT JOIN   " +
   "  sys_user_role sur   " +
   "   ON   " +
   "  su.id=sur.user_id   " +
   "   LEFT JOIN   " +
   "  sys_role sr   " +
   "   ON   " +
   "  sr.id=sur.role_id   " +
   "   where   " +
   " su.del_flag=0 " +
   " AND " +
   "  su.id=#{rid}")
    SysUser selectByRid(long rid);

}