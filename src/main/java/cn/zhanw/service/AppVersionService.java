package cn.zhanw.service;


import cn.zhanw.entity.AppVersion;
import com.github.pagehelper.PageInfo;


public interface AppVersionService extends IService<AppVersion> {
    //查询
    PageInfo<AppVersion> selectAll(Integer pageNum, Integer pageSize);
    //..

}
