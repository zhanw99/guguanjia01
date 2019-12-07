package cn.zhanw.service;

import cn.zhanw.entity.SysRole;
import cn.zhanw.mapper.SysResourceMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface SysRoleService extends IService<SysRole> {

    PageInfo<SysRole> selectByAndAll(Map<String, Object> params);


    List<String> selectByDataScope();

    List<String> officeName();
}
