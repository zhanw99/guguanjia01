package cn.zhanw.service;

import cn.zhanw.entity.SysResource;

import java.util.List;

public interface SysResourceService extends IService<SysResource> {
    List<SysResource> selectAllByUid(long rid);
}
