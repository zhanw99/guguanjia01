package cn.zhanw.service;

import cn.zhanw.entity.SysUser;
import cn.zhanw.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Map;

public interface SysUserService extends IService<SysUser> {

    PageInfo<SysUser> selectPage(Map<String, Object> parms);

    SysUser selectByRid(long rid);
}
