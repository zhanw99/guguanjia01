package cn.zhanw.service.serviceImpl;

import cn.zhanw.entity.SysResource;
import cn.zhanw.entity.SysUser;
import cn.zhanw.mapper.SysResourceMapper;
import cn.zhanw.mapper.SysUserMapper;
import cn.zhanw.service.SysResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional//开启事务管理
@CacheConfig(cacheNames = "sysResourceCache")//设置全局缓存配置
public class SysResourceServiceImpl extends IServiceImpl<SysResource> implements SysResourceService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysResourceMapper sysResourceMapper;


//    @Cacheable(key =  "'SysResourceServiceImpl:selectAllByUid'+':'+#rid['rid']")
    @Autowired
    RedisTemplate template;


    @Override
    public List<SysResource> selectAllByUid(long rid) {
        SysUser sysUser = sysUserMapper.selectByRid(rid);
        Long id = sysUser.getId();
        template.opsForValue().set("'你好呀:'"+rid,sysUser);
        return sysResourceMapper.selectByRid(id);
    }

}
